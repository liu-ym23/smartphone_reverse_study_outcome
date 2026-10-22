package com.ss.texturerender;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.hardware.HardwareBuffer;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.texturerender.base.EGLExt;
import com.ss.texturerender.base.EGLRuntime;
import com.ss.texturerender.effect.EffectConfig;
import com.ss.texturerender.effect.EffectTextureManager;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public abstract class TextureRenderer implements Handler.Callback {
    public static final int ERROR_FATAl = 0;
    public static final int ERROR_WARN = 1;
    private static final long EXPIRE_TIME = 120000;
    protected static final String KEY_SURFACE_OBJ = "surface";
    protected static final int MSG_AUTO_RELEASE = 11;
    protected static final int MSG_CHECK_FRAME_CALLBACK = 37;
    protected static final int MSG_CLEAR_SURFACE = 13;
    protected static final int MSG_DEINIT = 3;
    protected static final int MSG_ERROR = 6;
    protected static final int MSG_GEN_TEXTURE = 9;
    protected static final int MSG_INIT = 1;
    protected static final int MSG_RELEASE_TEX_IMG = 43;
    public static final int MSG_RENDER = 2;
    protected static final int MSG_RESET_CROP_PARAMS = 40;
    protected static final int MSG_RESET_ROTATION_MIRROR_PARAMS = 42;
    protected static final int MSG_RESET_SURFACE = 44;
    protected static final int MSG_SAVE_FRAME = 14;
    protected static final int MSG_SET_ACTIVE_TEXTURE = 10;
    public static final int MSG_SET_EFFECT = 36;
    protected static final int MSG_SET_EXTRA_SURFACE = 25;
    protected static final int MSG_SET_EXT_EFFECT = 45;
    public static final int MSG_SET_FLOAT_OPTION = 35;
    public static final int MSG_SET_INT_OPTION = 34;
    protected static final int MSG_SET_MAIN_SURFACE = 33;
    protected static final int MSG_SET_OBJECT_OPTION = 41;
    protected static final int MSG_SET_OVERLAY_RATIO = 27;
    protected static final int MSG_SET_OVERLAY_SYNC = 31;
    protected static final int MSG_SET_SURFACE = 4;
    public static final int MSG_SR_INIT_CONFIG = 12;
    protected static final int MSG_START_RENDER_CHECK = 38;
    protected static final int MSG_STATE_CHANGED = 7;
    protected static final int MSG_STOP_RENDER_CHECK = 39;
    protected static final int MSG_TEXTURE_RENDERED = 8;
    protected static final int MSG_UPDATE_FRAME_TIME = 32;
    public static final int MSG_UPDATE_VIDEO_STATUS = 26;
    public static final int STATE_ERROR = -1;
    public static final int STATE_EXECUTING = 2;
    public static final int STATE_IDLE = 0;
    public static final int STATE_INITED = 1;
    private static final String VERSION = "3.252.9";
    protected String LOG_TAG;

    /* JADX INFO: renamed from: es, reason: collision with root package name */
    private ExecutorService f457018es;
    protected RenderCheckDispatcher mCheckDispatcher;
    protected EGLRuntime mEGLRuntime;
    protected EffectConfig mEffectConfig;
    protected EffectConfig mEffectConfigWant;
    protected EffectTextureManager mEffectTextureManager;
    private OnEglErrorListener mErrorListener;
    private String mErrorReason;
    protected volatile Handler mHandler;
    private final Object mHandlerObject;
    private HandlerThread mHandlerThread;
    protected Handler mNotifyHandler;
    private Object mSetupFence;
    protected volatile int mState;
    private OnStateChangeListener mStateChangeListener;
    protected int mTexType;
    protected TextureFactory mTextureFactory;
    protected List<VideoSurfaceTexture> mTextureList;
    private ThreadLocal<ThreadRuntime> mThreadRuntime;
    protected int mUpdateSurfaceCount;
    private ReentrantLock mUpdateSurfaceCountLock;

    public class MyEGLErrorCallback implements EGLRuntime.ErrorCallback {
        final /* synthetic */ TextureRenderer this$0;

        private MyEGLErrorCallback(TextureRenderer r100) {
            this.this$0 = r100;
        }

        public /* synthetic */ MyEGLErrorCallback(TextureRenderer r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.ss.texturerender.base.EGLRuntime.ErrorCallback
        public void onError(EGLRuntime r100, int r101, String r102) {
            this.this$0.notifyEGLError(r101, r102);
        }
    }

    public interface OnEglErrorListener {
        void onError(int r100, String r101);
    }

    public interface OnStateChangeListener {
        void onStateChanged(int r100);
    }

    public interface OnTextureFocusLossListener {
        void onFocusLoss();
    }

    public static class ThreadRuntime {
        MyRenderTask renderTask;
        final Semaphore semaphore;

        public static class MyRenderTask implements Runnable {
            final String TAG;
            int fenceFd;
            HardwareBuffer hardwareBuffer;
            int[] hardwareBufferRect;
            Message message;
            Semaphore semaphore;
            final int texType;
            WeakReference<TextureRenderer> textureRenderRef;

            @Override // java.lang.Runnable
            public void run() {
                com_ss_texturerender_TextureRenderer$ThreadRuntime$MyRenderTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_ss_texturerender_TextureRenderer$ThreadRuntime$MyRenderTask__run$___twin___() {
                TextureRenderer r100 = this.textureRenderRef.get();     // Catch: Throwable -> L51 Exception -> L53
                if (r100 == null) goto L45;
                VideoSurfaceTexture r101 = (VideoSurfaceTexture) this.message.obj;     // Catch: Throwable -> L51 Exception -> L53
                if (r101 != null) goto L8;
            L40:
                HardwareBuffer r102 = this.hardwareBuffer;
                if (r102 != null) goto L43;
            L26:
                this.message.recycle();
                this.semaphore.release();
                return;
            L43:
                if (r102.isClosed() == true) goto L26;
            L25:
                this.hardwareBuffer.close();
                this.hardwareBuffer = null;
                this.hardwareBufferRect = null;
                goto L26
            L8:
                if (r101.getState() == 3) goto L40;
                if (this.hardwareBuffer == null) goto L28;
                int r103 = r101.getIntOption(189);     // Catch: Throwable -> L51 Exception -> L53
                if (r103 != 1) goto L16;
                int r104 = r101.updateHardwareBufferTexture(this.hardwareBuffer, this.hardwareBufferRect);     // Catch: Throwable -> L51 Exception -> L53
            L20:
                if (r104 == 0) goto L28;
                HardwareBuffer r105 = this.hardwareBuffer;
                if (r105 == null) goto L26;
                if (r105.isClosed() == true) goto L26;
            L16:
                if (r103 != 2) goto L18;
                r104 = r101.updateHardwareBuffer(this.hardwareBuffer, this.hardwareBufferRect);     // Catch: Throwable -> L51 Exception -> L53
                goto L20
            L18:
                TextureRenderLog.e(this.texType, this.TAG, "handleFrameAvailable failed, renderDirectly = " + r103);     // Catch: Throwable -> L51 Exception -> L53
                r104 = -1;
            L28:
                r100.handleFrameAvailable(this.message);     // Catch: Throwable -> L51 Exception -> L53
                int r106 = GLES20.glGetError();     // Catch: Throwable -> L51 Exception -> L53
                if (r106 == 0) goto L37;
                TextureRenderLog.e(this.texType, this.TAG, "handleFrameAvailable failed = " + r106);     // Catch: Throwable -> L51 Exception -> L53
                HardwareBuffer r107 = this.hardwareBuffer;
                if (r107 == null) goto L26;
                if (r107.isClosed() == true) goto L26;
            L37:
                if (addReleaseFence() == 0) goto L45;
                TextureRenderLog.w(this.texType, this.TAG, "handleFrameAvailable add release fence failed");     // Catch: Throwable -> L51 Exception -> L53
                GLES20.glFinish();     // Catch: Throwable -> L51 Exception -> L53
            L45:
                HardwareBuffer r108 = this.hardwareBuffer;
                if (r108 != null) goto L48;
            L50:
                this.message.recycle();
                this.semaphore.release();
                return;
            L48:
                if (r108.isClosed() == true) goto L50;
            L49:
                this.hardwareBuffer.close();
                this.hardwareBuffer = null;
                this.hardwareBufferRect = null;
            L53:
                e = move-exception;
                TextureRenderLog.e(this.texType, this.TAG, "handleFrameAvailable exp = " + e);     // Catch: Throwable -> L51
                HardwareBuffer r109 = this.hardwareBuffer;
                if (r109 == null) goto L50;
                if (r109.isClosed() == true) goto L50;
            L51:
                th = move-exception;
                HardwareBuffer r110 = this.hardwareBuffer;
                if (r110 != null) goto L64;
            L66:
                this.message.recycle();
                this.semaphore.release();
                throw th;
            L64:
                if (r110.isClosed() == true) goto L66;
                this.hardwareBuffer.close();
                this.hardwareBuffer = null;
                this.hardwareBufferRect = null;
                goto L66
            }

            public int syncForRelease() {
                int r100 = this.fenceFd;
                if (r100 == (-1)) goto L7;
                int r101 = EGLExt.syncForRelease(r100, 3000);
                this.fenceFd = -1;
                if (r101 >= 0) goto L9;
                return -1;
            L9:
                return 0;
            L7:
                return 0;
            }

            public int addReleaseFence() {
                int r100 = EGLExt.addReleaseFence();
                if (r100 >= 0) goto L6;
                return -1;
            L6:
                this.fenceFd = r100;
                return 0;
            }

            public String toString() {
                return this.TAG;
            }

            public MyRenderTask(TextureRenderer r100) {
                this.fenceFd = -1;
                this.TAG = TextureRenderLog.getLogTag(this);
                this.texType = r100.mTexType;
                this.textureRenderRef = new WeakReference(r100);
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_ss_texturerender_TextureRenderer$ThreadRuntime$MyRenderTask_com_larus_apm_impl_protector_RunnableLancet_run(MyRenderTask r100) {
                r100.com_ss_texturerender_TextureRenderer$ThreadRuntime$MyRenderTask__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public void setMessage(Message r100) {
                this.message = r100;
            }

            public void setSemaphore(Semaphore r100) {
                this.semaphore = r100;
            }

            public void setHardwareBuffer(HardwareBuffer r100, int[] r101) {
                this.hardwareBuffer = r100;
                this.hardwareBufferRect = r101;
            }
        }

        private ThreadRuntime() {
            this.semaphore = new Semaphore(1, true);
        }

        public /* synthetic */ ThreadRuntime(AnonymousClass1 r100) {
            this();
        }
    }

    public abstract void deinitEffectComponents();

    public abstract void deinitGLComponents();

    public VideoSurfaceTexture getExtraVideoSurfaceTexture() {
        return null;
    }

    public Object getOption(Bundle r100) {
        return null;
    }

    public ITexture getTexture() {
        Message r100 = this.mHandler.obtainMessage(9);     // Catch: Exception -> L22
        Message r101 = new Message();
        r100.obj = r101;
        monitor-enter(r101);     // Catch: Exception -> L19
        this.mHandler.sendMessageAtFrontOfQueue(r100);     // Catch: Throwable -> L16
        r101.wait(1000);     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
    L9:
        if (r101.obj != null) goto L15;
        if (this.mHandler.hasMessages(9) == false) goto L13;
        this.mErrorReason = "The handler is busy for other operation timeout";     // Catch: Exception -> L19
        goto L15
    L13:
        this.mErrorReason = "Try modify the wait timeOut";     // Catch: Exception -> L19
    L15:
        return (ITexture) r101.obj;
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L19
    L19:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "texture render may exit, error:" + e.toString());
        return null;
    L22:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "texture render already exit");
        return null;
    }

    public abstract void handleFrameAvailable(Message r100);

    public abstract void handleGLThreadMessage(Message r100);

    public abstract void handleSetSurface(Message r100);

    public abstract void initGLComponents();

    public abstract void onInternalStateChanged(int r100);

    public abstract void updateDisplaySize(int r100, int r101);

    private void checkExpired() {
        if (this.mHandler != null) goto L5;
        return;
    L5:
        if (this.mEffectConfig.isOpenSR() == true) goto L11;
        if (this.mEffectConfig.isOpenSharpen() == true) goto L11;
        if (this.mEffectConfig.getEffectOpen(14) == true) goto L11;
    L13:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "check expired");
        List<VideoSurfaceTexture> r100 = this.mTextureList;
        monitor-enter(r100);
    L46:
        th = move-exception;
        throw th;
    L16:
        if (this.mHandler.hasMessages(8) == false) goto L18;
    L43:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "renderer is excuting");     // Catch: Throwable -> L46
        this.mHandler.sendEmptyMessageDelayed(11, 120000);     // Catch: Throwable -> L46
        monitor-exit(r100);     // Catch: Throwable -> L46
        return;
    L18:
        if (this.mHandler.hasMessages(9) == true) goto L43;
        if (this.mTextureList.size() != 0) goto L25;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "renderer is expired");     // Catch: Throwable -> L46
        release();     // Catch: Throwable -> L46
        monitor-exit(r100);     // Catch: Throwable -> L46
        return;
    L25:
        Iterator<VideoSurfaceTexture> r101 = this.mTextureList.iterator();     // Catch: Throwable -> L46
    L27:
        if (r101.hasNext() == false) goto L35;
        VideoSurfaceTexture r102 = r101.next();     // Catch: Throwable -> L46
        if (r102.isRelease() == true) goto L27;
        if (r102.isAlive() == true) goto L34;
        if (r102.couldForceRelease() == true) goto L27;
    L34:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "a texture is still working " + r102);     // Catch: Throwable -> L46
        boolean r103 = true;
    L36:
        if (r103 == true) goto L40;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "non live texture , renderer is expired");     // Catch: Throwable -> L46
        release();     // Catch: Throwable -> L46
        monitor-exit(r100);     // Catch: Throwable -> L46
        return;
    L40:
        this.mHandler.sendEmptyMessageDelayed(11, 120000);     // Catch: Throwable -> L46
        monitor-exit(r100);     // Catch: Throwable -> L46
        return;
    L35:
        r103 = false;
    L11:
        if ((this.mTexType & 4) != 0) goto L13;
    }

    private VideoSurfaceTexture getSurfaceTextureNew() {
        List<VideoSurfaceTexture> r100 = this.mTextureList;
        monitor-enter(r100);
        Iterator<VideoSurfaceTexture> r101 = this.mTextureList.iterator();     // Catch: Throwable -> L35
        VideoSurfaceTexture r102 = null;
        final VideoSurfaceTexture r103 = null;
        int r104 = 0;
    L6:
        if (r101.hasNext() == false) goto L18;
        r103 = r101.next();     // Catch: Throwable -> L35
        if (r103.isRelease() == true) goto L17;
        if (r103.isAlive() == true) goto L17;
        r104 = r104 + 1;     // Catch: Throwable -> L35
        if (r102 == null) goto L13;
        if (r104 <= 3) goto L6;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "reused count of supply too max,can't reuse, delete = " + r103);     // Catch: Throwable -> L35
        this.f457018es.execute(new AnonymousClass3(this, r103));     // Catch: Throwable -> L35
        r101.remove();     // Catch: Throwable -> L35
        r103 = null;
        goto L18
    L13:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "get surfacetexture new reuse texture");     // Catch: Throwable -> L35
        r103.pause(false, false);     // Catch: Throwable -> L35
        r103.getOffScreenSurface();     // Catch: Throwable -> L35
        r103.setFrameRenderChecker(this.mCheckDispatcher);     // Catch: Throwable -> L35
        r102 = r103;
    L17:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "still living relese:" + r103.isRelease() + "alive:" + r103.isAlive());     // Catch: Throwable -> L35
    L18:
        if (r102 == null) goto L22;
        r102.mReleaseOffScreenSurfaceFinish = false;     // Catch: Throwable -> L35
        r102.getEventLogger().resetAllEvents();     // Catch: Throwable -> L35
        r102.getEventLogger().setSurfaceTextureReuse(1);     // Catch: Throwable -> L35
        monitor-exit(r100);     // Catch: Throwable -> L35
        return r102;
    L22:
        ITexture r105 = getTexture();     // Catch: Throwable -> L35
        if (r105 == null) goto L25;
        r103 = genNewVideoSurfaceTexture(r105);     // Catch: Throwable -> L35
        r103.setOption(5, this.mTexType);     // Catch: Throwable -> L35
        r103.bindEGLEnv(this.mEGLRuntime);     // Catch: Throwable -> L35
        r105.decRef();     // Catch: Throwable -> L35
        r103.getOffScreenSurface();     // Catch: Throwable -> L35
        r103.setFrameRenderChecker(this.mCheckDispatcher);     // Catch: Throwable -> L35
        r103.mReleaseOffScreenSurfaceFinish = false;     // Catch: Throwable -> L35
        r103.getEventLogger().setSurfaceTextureReuse(0);     // Catch: Throwable -> L35
        this.mTextureList.add(r103);     // Catch: Throwable -> L35
    L31:
        monitor-exit(r100);     // Catch: Throwable -> L35
        return r103;
    L25:
        if (r103 != null) goto L27;
    L33:
        monitor-exit(r100);     // Catch: Throwable -> L35
        return null;
    L27:
        if (r103.isRelease() == true) goto L33;
        if (r103.isAlive() == false) goto L31;
    L35:
        th = move-exception;
        throw th;
    }

    private VideoSurfaceTexture getSurfaceTextureOld() {
        List<VideoSurfaceTexture> r100 = this.mTextureList;
        monitor-enter(r100);
        Iterator<VideoSurfaceTexture> r101 = this.mTextureList.iterator();     // Catch: Throwable -> L48
    L5:
        VideoSurfaceTexture r102 = null;
    L7:
        if (r101.hasNext() == false) goto L35;
        r102 = r101.next();     // Catch: Throwable -> L48
        if (r102.isRelease() == true) goto L19;
        if (r102.isAlive() == true) goto L19;
        if (r102.canReuse(Looper.myLooper()) == true) goto L14;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "can't reuse, delete = " + r102);     // Catch: Throwable -> L48
        r102.release(false);     // Catch: Throwable -> L48
        r101.remove();     // Catch: Throwable -> L48
        goto L5
    L14:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "same looper reuse texture");     // Catch: Throwable -> L48
        r102.pause(false, false);     // Catch: Throwable -> L48
        r102.getOffScreenSurface();     // Catch: Throwable -> L48
        r102.setFrameRenderChecker(this.mCheckDispatcher);     // Catch: Throwable -> L48
        r102.getEventLogger().resetAllEvents();     // Catch: Throwable -> L48
        r102.getEventLogger().setSurfaceTextureReuse(1);     // Catch: Throwable -> L48
        monitor-exit(r100);     // Catch: Throwable -> L48
        return r102;
    L19:
        if (this.mEffectConfig.isOpenSR() == true) goto L7;
        if (this.mEffectConfig.isOpenSharpen() == true) goto L7;
        if (this.mEffectConfig.getEffectOpen(14) == true) goto L7;
        if (this.mEffectConfig.getEffectOpen(16) == true) goto L7;
        if (this.mEffectConfig.getEffectOpen(28) == true) goto L7;
        if (this.mEffectConfig.getEffectOpen(30) == true) goto L7;
        int r103 = this.mTexType;     // Catch: Throwable -> L48
        if ((r103 & 4) != 0) goto L7;
        TextureRenderLog.i(r103, this.LOG_TAG, "still living");     // Catch: Throwable -> L48
        monitor-exit(r100);     // Catch: Throwable -> L48
        return null;
    L35:
        ITexture r104 = getTexture();     // Catch: Throwable -> L48
        if (r104 == null) goto L38;
        r102 = genNewVideoSurfaceTexture(r104);     // Catch: Throwable -> L48
        r102.setOption(5, this.mTexType);     // Catch: Throwable -> L48
        r102.bindEGLEnv(this.mEGLRuntime);     // Catch: Throwable -> L48
        r104.decRef();     // Catch: Throwable -> L48
        r102.getOffScreenSurface();     // Catch: Throwable -> L48
        r102.setFrameRenderChecker(this.mCheckDispatcher);     // Catch: Throwable -> L48
        r102.getEventLogger().setSurfaceTextureReuse(0);     // Catch: Throwable -> L48
        this.mTextureList.add(r102);     // Catch: Throwable -> L48
    L44:
        monitor-exit(r100);     // Catch: Throwable -> L48
        return r102;
    L38:
        if (r102 != null) goto L40;
    L46:
        monitor-exit(r100);     // Catch: Throwable -> L48
        return null;
    L40:
        if (r102.isRelease() == true) goto L46;
        if (r102.isAlive() == false) goto L44;
    L48:
        th = move-exception;
        throw th;
    }

    private void handleStartRenderCheck() {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "handleStartRenderCheck");
        if (this.mHandler == null) goto L6;
        this.mHandler.sendEmptyMessage(37);
        return;
    }

    private void handleStopRenderCheck() {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "handleStopRenderCheck");
        if (this.mHandler == null) goto L6;
        this.mHandler.removeMessages(37);
        return;
    }

    private boolean isSupportGL3() {
        boolean r100 = false;
        Context r101 = TextureRenderManager.getManager().getContext();     // Catch: Exception -> L14
        if (r101 == null) goto L16;
        ActivityManager r102 = (ActivityManager) r101.getSystemService("activity");     // Catch: Exception -> L14
        if (r102 == null) goto L16;
        ConfigurationInfo r103 = r102.getDeviceConfigurationInfo();     // Catch: Exception -> L14
        if (r103 == null) goto L16;
        if (r103.reqGlEsVersion < 196608) goto L12;
        r100 = true;
    L12:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "gles version: " + r103.reqGlEsVersion + ", isSupportGL3: " + r100);     // Catch: Exception -> L14
    L16:
        return r100;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public void addUpdateSurfaceCount() {
        this.mUpdateSurfaceCountLock.lock();
        this.mUpdateSurfaceCount++;
        this.mUpdateSurfaceCountLock.unlock();
    }

    public void decUpdateSurfaceCount() {
        this.mUpdateSurfaceCountLock.lock();
        this.mUpdateSurfaceCount--;
        this.mUpdateSurfaceCountLock.unlock();
    }

    public void deleteTextures() {
        List<VideoSurfaceTexture> r100 = this.mTextureList;
        monitor-enter(r100);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mTextureList.size() <= 0) goto L10;
        Iterator<VideoSurfaceTexture> r101 = this.mTextureList.iterator();     // Catch: Throwable -> L13
    L8:
        if (r101.hasNext() == false) goto L10;
        r101.next().release(true);     // Catch: Throwable -> L13
        r101.remove();     // Catch: Throwable -> L13
    L10:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "delete textures : " + this.mTextureList.size());     // Catch: Throwable -> L13
        this.mTextureFactory.release();     // Catch: Throwable -> L13
        monitor-exit(r100);     // Catch: Throwable -> L13
    }

    public VideoSurface genOffscreenSurface() {
        if (this.mState >= 1) goto L5;
        return null;
    L5:
        VideoSurfaceTexture r100 = getSurfaceTexture();
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.getOffScreenSurface();
    }

    public int handleAttachGLContext() {
        if (this.mThreadRuntime.get() == null) goto L5;
        return 0;
    L5:
        ThreadRuntime r100 = new ThreadRuntime(null);
        r100.renderTask = new ThreadRuntime.MyRenderTask(this);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "attach runtime = " + r100 + " renderTask = " + r100.renderTask);
        this.mThreadRuntime.set(r100);
        return 0;
    }

    public void handleCheckFrameCallback() {
        if (this.mCheckDispatcher.isEnabled() == true) goto L5;
    L9:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "handleCheckFrameCallback invalid state");
        return;
    L5:
        if (this.mCheckDispatcher.isStarted() == false) goto L9;
        this.mHandler.removeMessages(37);
        this.mCheckDispatcher.checkSurfaceTextureCallbackTime();
        this.mHandler.sendEmptyMessageDelayed(37, 500);
    }

    public void handleDeinit() {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "deinit");
        changeState(0, true);
        deinitEffectComponents();
        deleteTextures();
        deinitGLComponents();
        EGLRuntime r100 = this.mEGLRuntime;
        if (r100 == null) goto L5;
        r100.deinitEGL();
    L5:
        this.mHandler = null;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "deinit done");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.concurrent.Semaphore] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.concurrent.Semaphore] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    public void handleDetachGLContext() {
        ThreadRuntime r100 = this.mThreadRuntime.get();
        if (r100 == null) goto L14;
        ?? r101 = r100.semaphore;
        r101.acquire();     // Catch: Throwable -> L7 Exception -> L9
        r100.renderTask.syncForRelease();     // Catch: Throwable -> L7 Exception -> L9
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "detach runtime = " + r100 + " renderTask = " + r100.renderTask);     // Catch: Throwable -> L7 Exception -> L9
    L11:
        r101.release();
        int r102 = this.mTexType;
        r101 = this.LOG_TAG;
        TextureRenderLog.i(r102, r101, "detach runtime = " + r100);
        goto L14
    L7:
        th = move-exception;
        r101.release();
        throw th;
    L9:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "handleDetachGLContext exp = " + e);     // Catch: Throwable -> L7
    L14:
        this.mThreadRuntime.remove();
    }

    public void release() {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "call release");
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != 0) goto L7;
    L14:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "release return");     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L7:
        if (this.mHandler == null) goto L14;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "send deinit");     // Catch: Throwable -> L17
        this.mHandler.sendEmptyMessage(3);     // Catch: Throwable -> L17
        this.mHandlerThread.quitSafely();     // Catch: Exception -> L20 Throwable -> L17
    L11:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "call release end");     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
    }

    private VideoSurfaceTexture getSurfaceTexture() {
        TextureRenderManager r100 = TextureRenderManager.getManager();
        if (r100 != null) goto L5;
    L10:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "getSurfaceTexture old");
        return getSurfaceTextureOld();
    L5:
        if (r100.isAsyncRelaseSurfaceTexture() == false) goto L10;
        int r101 = this.mTexType;
        if (r101 != 0) goto L10;
        TextureRenderLog.i(r101, this.LOG_TAG, "getSurfaceTexture new");
        return getSurfaceTextureNew();
    }

    public EffectConfig getEffectConfig() {
        return this.mEffectConfig;
    }

    public EffectTextureManager getEffectTextureManager() {
        return this.mEffectTextureManager;
    }

    public String getErrorReason() {
        return this.mErrorReason;
    }

    public int getState() {
        return this.mState;
    }

    public int texType() {
        return this.mTexType;
    }

    public String toString() {
        return this.LOG_TAG;
    }

    private void handleChangeActiveTexture(VideoSurfaceTexture r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "resume texture =" + r100);
        if (r100.isCurrentObject() == true) goto L8;
        r100.makeCurrent();
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "change active drawing id");
        return;
    }

    private void handleClearSurface(Message r100) {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "handle clear surface");
        Message r101 = (Message) r100.obj;
        if (this.mState >= 1) goto L7;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "state is invalid : " + this.mState);
        msgNotify(r101);
        return;
    L7:
        if (this.mEGLRuntime == null) goto L9;
        this.mEGLRuntime.clearSurface((Surface) r100.getData().getParcelable("surface"));
    L9:
        msgNotify(r101);
    }

    private void handleGenTexture(Message r100) {
        ITexture r101 = this.mTextureFactory.createTexture(36197, this.mTexType);
        if (r101 != null) goto L5;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "Create Texture failed.");
    L5:
        r100.obj = r101;
        monitor-enter(r100);
        r100.notify();     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void handleSaveFrame(Message r110) {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "handle save frame");
        Bundle r100 = r110.getData();
        if (r100 == null) goto L26;
        VideoSurfaceTexture r101 = (VideoSurfaceTexture) r100.getSerializable(VideoSurfaceTexture.KEY_TEXTURE);
        if (r101 == null) goto L24;
        Message r111 = (Message) r110.obj;
        if (this.mState >= 1) goto L27;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "state is invalid : " + this.mState);
        msgNotify(r111);
        return;
    L27:
        int r112 = r101.getViewportWidth();     // Catch: Exception -> L19
        int r113 = r101.getViewportHeight();     // Catch: Exception -> L19
        if (r112 == 0) goto L13;
        if (r113 == 0) goto L13;
    L14:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "savexx frame = " + r112 + ", " + r113);     // Catch: Exception -> L19
        ByteBuffer r102 = ByteBuffer.allocateDirect((r112 * r113) * 4);     // Catch: Exception -> L19
        r102.order(ByteOrder.LITTLE_ENDIAN);     // Catch: Exception -> L19
        GLES20.glFinish();     // Catch: Exception -> L19
        GLES20.glReadPixels(0, 0, r112, r113, 6408, 5121, r102);     // Catch: Exception -> L19
        int r103 = TexGLUtils.checkGLError(this.mTexType, "handleSaveFrame");     // Catch: Exception -> L19
        if (r103 == 0) goto L17;
        r101.notifyError(r103, 0, "handleSaveFrame");     // Catch: Exception -> L19
    L17:
        Bitmap r104 = Bitmap.createBitmap(r112, r113, Bitmap.Config.ARGB_8888);     // Catch: Exception -> L19
        r102.rewind();     // Catch: Exception -> L19
        r104.copyPixelsFromBuffer(r102);     // Catch: Exception -> L19
        Matrix r105 = new Matrix();     // Catch: Exception -> L19
        r105.postScale(1.0f, -1.0f);     // Catch: Exception -> L19
        r111.obj = Bitmap.createBitmap(r104, 0, 0, r112, r113, r105, true);     // Catch: Exception -> L19
        r104.recycle();     // Catch: Exception -> L19
    L21:
        msgNotify(r111);
        return;
    L13:
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "texture size is invalid = " + r112 + ", height =" + r113);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "save frame failed " + e.getMessage());
        goto L21
    L24:
        throw new RuntimeException("update surface but missing texture");
    L26:
        throw new RuntimeException("update surface but missing bundle?");
    }

    private final void msgNotify(Message r100) {
        if (r100 == null) goto L10;
        monitor-enter(r100);
        r100.arg1 = this.mState;     // Catch: Throwable -> L7
        r100.notify();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public VideoSurfaceTexture genNewVideoSurfaceTexture(ITexture r100) {
        return new VideoSurfaceTexture(r100, this.mHandler, this);
    }

    public int handleHardwareBufferAvailable(VideoSurfaceTexture r100) {
        if (this.mState >= 1) goto L14;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "handleHardwareBufferAvailable failed, state is invalid = " + this.mState);
        return -1;
    L14:
        final Message r101 = this.mHandler.obtainMessage(2);     // Catch: Exception -> L11
        r101.obj = r100;     // Catch: Exception -> L11
        r101.arg1 = 1;     // Catch: Exception -> L11
        r101.arg2 = 0;     // Catch: Exception -> L11
        Bundle r102 = r100.getSaveFrameBundle();     // Catch: Exception -> L11
        if (r102 == null) goto L9;
        r101.setData(r102);     // Catch: Exception -> L11
    L9:
        final CountDownLatch r103 = new CountDownLatch(1);     // Catch: Exception -> L11
        this.mHandler.post(new AnonymousClass2(this, r101, r103));     // Catch: Exception -> L11
        r103.await();     // Catch: Exception -> L11
        return 0;
    L11:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "handleHardwareBufferAvailable exp = " + e);
        return -1;
    }

    public void handleInit(Object r100) {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init start");
        EGLRuntime r101 = this.mEGLRuntime;
        if (r101 == null) goto L6;
        r101.initEGL();
    L6:
        if (this.mState != (-1)) goto L8;
        return;
    L8:
        initGLComponents();
        if (this.mState != (-1)) goto L11;
        return;
    L11:
        changeState(1, true);
        monitor-enter(r100);
        r100.notify();     // Catch: Throwable -> L16
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init done");     // Catch: Throwable -> L16
        monitor-exit(r100);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r100) {
        int r101 = r100.what;
        if (r101 != 6) goto L5;
        OnEglErrorListener r102 = this.mErrorListener;
        if (r102 == null) goto L27;
        r102.onError(r100.arg1, r100.obj.toString());
        return true;
    L27:
        return true;
    L5:
        if (r101 != 7) goto L7;
        OnStateChangeListener r103 = this.mStateChangeListener;
        if (r103 == null) goto L24;
        r103.onStateChanged(r100.arg1);
        if (r100.arg1 != 0) goto L25;
        this.mNotifyHandler.removeCallbacksAndMessages(null);
        this.mNotifyHandler = null;
        return true;
    L25:
        return true;
    L24:
        return true;
    L7:
        if (r101 != 8) goto L28;
        int r104 = r100.arg1;
        VideoSurfaceTexture r105 = (VideoSurfaceTexture) r100.obj;
        if (r105 == null) goto L29;
        r105.notifyRenderFrame(r104);
        return true;
    L29:
        return true;
    L28:
        return true;
    }

    public void handleTextureRenderMsg(Message r100) {
        int r101 = r100.what;
        if (r101 != 1) goto L5;
        handleInit(r100.obj);
        return;
    L5:
        if (r101 != 2) goto L7;
        handleFrameAvailable(r100);
        return;
    L7:
        if (r101 != 3) goto L9;
        handleDeinit();
        return;
    L9:
        if (r101 != 4) goto L11;
        handleSetSurface(r100);
        return;
    L11:
        if (r101 != 13) goto L13;
        handleClearSurface(r100);
        return;
    L13:
        if (r101 == 14) goto L28;
        switch(r101) {
            case 9: goto L26;
            case 10: goto L24;
            case 11: goto L22;
            default: goto L15;
        };
    L15:
        switch(r101) {
            case 37: goto L20;
            case 38: goto L19;
            case 39: goto L18;
            default: goto L16;
        };
    L16:
        handleGLThreadMessage(r100);
        return;
    L18:
        handleStopRenderCheck();
        return;
    L19:
        handleStartRenderCheck();
        return;
    L20:
        handleCheckFrameCallback();
        return;
    L22:
        checkExpired();
        return;
    L24:
        handleChangeActiveTexture((VideoSurfaceTexture) r100.obj);
        return;
    L26:
        handleGenTexture((Message) r100.obj);
        return;
    L28:
        handleSaveFrame(r100);
    }

    public void init(int r100) {
        TextureRenderManager r101 = TextureRenderManager.getManager();
        if (r101 != null) goto L5;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == false) goto L25;
        EffectConfig r103 = this.mEffectConfigWant;
        if (r103 == null) goto L21;
        if (r103.getEffectOpen(8) == false) goto L21;
        this.mHandlerThread = new PthreadHandlerThreadV2("TRThread_" + r100);
    L26:
        ThreadMethodProxy.start(this.mHandlerThread);
        final Looper r104 = this.mHandlerThread.getLooper();
        this.mHandler = new AnonymousClass1(this, r104);
        this.mCheckDispatcher = new RenderCheckDispatcher(this.mHandler, this.mTexType);
        Message r105 = this.mHandler.obtainMessage(1);
        Object r106 = this.mSetupFence;
        r105.obj = r106;
        monitor-enter(r106);
        r105.sendToTarget();     // Catch: Throwable -> L35
        this.mSetupFence.wait(1000);     // Catch: InterruptedException -> L33 Throwable -> L35
        monitor-exit(r106);     // Catch: Throwable -> L35
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(11), 120000);
        return;
    L34:
        throw new RuntimeException("EGL initial timeout");     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    L21:
        if (this.mTexType != 0) goto L23;
        int r107 = r101.getTrThreadPriority();
    L24:
        this.mHandlerThread = new PthreadHandlerThreadV2("TRThread_" + r100, r107);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "enable set tr thread priority:" + r107);
        goto L26
    L23:
        r107 = r101.getLiveTRThreadPriority();
        goto L24
    L25:
        this.mHandlerThread = new PthreadHandlerThreadV2("TRThread_" + r100);
        goto L26
    L5:
        if (r101.getEnableSetTRThreadPriority() == false) goto L9;
        if (this.mTexType != 0) goto L9;
    L12:
        r102 = true;
    L9:
        if (r101.getLiveTRThreadPriority() == (-1)) goto L13;
        if (this.mTexType != 1) goto L13;
        goto L12
    }

    public void setOnErrorListener(OnEglErrorListener r100) {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "setOnErrorListener =  " + r100);
        this.mErrorListener = r100;
    }

    public void setOnStateChangedListener(OnStateChangeListener r100) {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "setOnStateChangedListener =  " + r100);
        this.mStateChangeListener = r100;
    }

    public void setVQSCoreInitResult(boolean r100) {
        if (r100 == false) goto L7;
        EffectConfig r101 = this.mEffectConfig;
        if (r101 == null) goto L8;
        r101.setEffectOpen(16, 1);
        return;
    L8:
        return;
    }

    public TextureRenderer(EffectConfig r100, int r101) {
        this(r100, r101, null, null, false);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "version :3.252.9 config:" + r100 + " type:" + r101);
    }

    public void changeState(int r100, boolean r101) {
        if (this.mState != r100) goto L6;
        return;
    L6:
        if (this.mState != (-1)) goto L9;
        if (r100 == 0) goto L9;
        return;
    L9:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "state change from " + this.mState + " to " + r100);
        this.mState = r100;
        if (r101 == true) goto L12;
        return;
    L12:
        Object r102 = this.mHandlerObject;
        monitor-enter(r102);
    L24:
        th = move-exception;
        throw th;
    L15:
        if (this.mStateChangeListener == null) goto L22;
        Handler r103 = this.mNotifyHandler;     // Catch: Throwable -> L24
        if (r103 == null) goto L22;
        Message r104 = r103.obtainMessage(7);     // Catch: Throwable -> L24
        r104.arg1 = r100;     // Catch: Throwable -> L24
        r104.sendToTarget();     // Catch: Throwable -> L24
        monitor-exit(r102);     // Catch: Throwable -> L24
        return;
    L22:
        monitor-exit(r102);     // Catch: Throwable -> L24
    }

    public boolean clearSurface(Surface r100, boolean r101) {
        Message r102 = this.mHandler.obtainMessage(13);
        Bundle r103 = new Bundle();
        r103.putParcelable("surface", r100);
        r102.setData(r103);
        if (r101 == true) goto L15;
        Message r104 = new Message();
        r102.obj = r104;
        monitor-enter(r104);     // Catch: InterruptedException -> L14
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "clear surface start");     // Catch: Throwable -> L11
        this.mHandler.sendMessage(r102);     // Catch: Throwable -> L11
        r104.wait(1000);     // Catch: Throwable -> L11
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "clear surface end : ret = " + r104.arg1);     // Catch: Throwable -> L11
        monitor-exit(r104);     // Catch: Throwable -> L11
    L9:
        if (r104.arg1 >= 1) goto L16;
        return false;
    L16:
        return true;
    L11:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L14
    L14:
        return false;
    L15:
        this.mHandler.sendMessage(r102);
        goto L16
    }

    public void notifyEGLError(int r100, String r101) {
        Object r102 = this.mHandlerObject;
        monitor-enter(r102);
        this.mErrorReason = r101 + ", reason = " + GLUtils.getEGLErrorString(EGL14.eglGetError());     // Catch: Throwable -> L9
        changeState(-1, false);     // Catch: Throwable -> L9
        if (this.mErrorListener == null) goto L7;
        Message r103 = this.mNotifyHandler.obtainMessage(6);     // Catch: Throwable -> L9
        r103.arg1 = r100;     // Catch: Throwable -> L9
        r103.obj = "EGL fail = " + r101 + ", reason = " + GLUtils.getEGLErrorString(EGL14.eglGetError());     // Catch: Throwable -> L9
        r103.sendToTarget();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void sendMessage(int r100, Bundle r101) {
        if (this.mHandler == null) goto L9;
        Message r102 = this.mHandler.obtainMessage(r100);     // Catch: Exception -> L6
        r102.setData(r101);     // Catch: Exception -> L6
        this.mHandler.sendMessage(r102);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public int handleHardwareBufferDirectly(VideoSurfaceTexture r100, HardwareBuffer r101, int[] r102) {
        if (this.mState >= 1) goto L6;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "handleHardwareBufferDirectly failed, state is invalid = " + this.mState);
        return -1;
    L6:
        ThreadRuntime r103 = this.mThreadRuntime.get();
        if (r103 != null) goto L10;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "handleHardwareBufferDirectly failed, runtime is invalid");
        return -1;
    L10:
        Semaphore r104 = r103.semaphore;
        r104.acquire();     // Catch: Exception -> L20
        if (r103.renderTask.syncForRelease() == 0) goto L15;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "handleHardwareBufferDirectly sync for release failed");     // Catch: Exception -> L20
        r104.release();     // Catch: Exception -> L20
        return -1;
    L15:
        Message r105 = this.mHandler.obtainMessage(2);     // Catch: Exception -> L20
        r105.obj = r100;     // Catch: Exception -> L20
        r105.arg1 = 1;     // Catch: Exception -> L20
        r105.arg2 = 0;     // Catch: Exception -> L20
        Bundle r106 = r100.getSaveFrameBundle();     // Catch: Exception -> L20
        if (r106 == null) goto L18;
        r105.setData(r106);     // Catch: Exception -> L20
    L18:
        r103.renderTask.setMessage(r105);     // Catch: Exception -> L20
        r103.renderTask.setSemaphore(r104);     // Catch: Exception -> L20
        r103.renderTask.setHardwareBuffer(r101, r102);     // Catch: Exception -> L20
        this.mHandler.post(r103.renderTask);     // Catch: Exception -> L20
        return 0;
    L20:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "handleHardwareBufferDirectly exp = " + e);
        r104.release();
        return -1;
    }

    public TextureRenderer(EffectConfig r100, int r101, EGLContext r102, EGLConfig r103, boolean r110) {
        this.mHandlerObject = new Object();
        this.mSetupFence = new Object();
        this.mUpdateSurfaceCount = 0;
        this.f457018es = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("TextureRenderer"));
        this.mThreadRuntime = new ThreadLocal();
        String r104 = TextureRenderLog.getLogTag(this);
        this.LOG_TAG = r104;
        TextureRenderLog.i(this.mTexType, r104, "version :3.252.9 config:" + r100 + " type:" + r101 + ", useGL3: " + r110);
        EGLRuntime r105 = new EGLRuntime(r101, new MyEGLErrorCallback(this, null), r102, r103);
        this.mEGLRuntime = r105;
        r105.setUseGL3(r110);
        EGLRuntime r106 = this.mEGLRuntime;
        if (r100 == null) goto L5;
        int r107 = r100.getEGLBitDepth();
    L6:
        r106.setBitDepth(r107);
        this.mState = 0;
        this.mErrorReason = null;
        this.mEffectConfig = new EffectConfig(r101);
        this.mEffectConfigWant = r100;
        this.mTexType = r101;
        this.mTextureFactory = new TextureFactory(this);
        this.mTextureList = new ArrayList();
        init(r101);
        this.mUpdateSurfaceCountLock = new ReentrantLock();
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "construct done");
        return;
    L5:
        r107 = 8;
        goto L6
    }
}
