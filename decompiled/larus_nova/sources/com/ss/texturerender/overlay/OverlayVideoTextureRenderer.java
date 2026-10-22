package com.ss.texturerender.overlay;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.texturerender.ITexture;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.TextureRenderManager;
import com.ss.texturerender.TextureRenderer;
import com.ss.texturerender.VideoSurfaceTexture;
import com.ss.texturerender.base.EGLRuntime;
import com.ss.texturerender.effect.EffectConfig;
import com.ss.texturerender.effect.EffectTexture;
import com.ss.texturerender.effect.FrameBuffer;
import com.ss.texturerender.effect.GLDefaultFilter;
import com.ss.texturerender.effect.GLOesTo2DFilter;
import com.ss.texturerender.vsync.VsyncHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

/* JADX INFO: loaded from: classes40.dex */
public class OverlayVideoTextureRenderer extends TextureRenderer {
    private static int ALL_VIDEO_STREAM_NUM = 2;
    private static int DROP_NUM_THRESHOLD = 3;
    private static int DROP_THRESHOLD_MS = 500;
    private int mAvailCount;
    private NormalClock mClock;
    private Surface mCurrentSurface;
    private GLDefaultFilter mDefaultDrawer;
    private EGLSurface mEglSurface;
    private FrameBuffer mFBO;
    private int mFBOTexH;
    private int mFBOTexW;
    private boolean mIsMakeCurrent;
    private boolean mIsOverlayRatioChanged;
    private boolean mIsVsyncWorking;
    private FrameTimeQueue mMainFrameTimeQueue;
    private VideoSurfaceTexture mMainSurfaceTexture;
    private ITexture mMainTex;
    private float[] mMainTexVerticesData;
    private int mMainVideoFastDropNum;
    private boolean mNeedSync;
    private GLOesTo2DFilter mOESDrawer;
    private float mOverlayRatio;
    private Vector<SurfaceTextureStatus> mReadySurfaceTextureVector;
    private FrameTimeQueue mSubFrameTimeQueue;
    private ITexture mSubTex;
    private float[] mSubTexVerticesData;
    private int mSubVideoFastDropNum;
    private int mTexType;
    private HashMap<VideoSurfaceTexture, Message> mTextureNotifyMap;
    private long mTid;
    private long mUpdateSurfaceTime;
    private VsyncHelper.VsyncCallback mVsyncCallback;
    private VsyncHelper mVsyncHelper;

    public static class SurfaceTextureStatus {
        public static int NEED_DRAW = 1;
        public static int NEED_DROP = 3;
        public static int NEED_NOT_DRAW = 2;
        public FrameTimeQueue.FrameTime frameTime;
        public int status;
        public VideoSurfaceTexture surfaceTexture;

        public SurfaceTextureStatus(VideoSurfaceTexture r100, FrameTimeQueue.FrameTime r101) {
            this.surfaceTexture = r100;
            this.status = NEED_DRAW;
            this.frameTime = r101;
        }
    }

    @Override // com.ss.texturerender.TextureRenderer
    public void deinitEffectComponents() {
    }

    @Override // com.ss.texturerender.TextureRenderer
    public void onInternalStateChanged(int r100) {
    }

    @Override // com.ss.texturerender.TextureRenderer
    public synchronized void release() {
        monitor-enter(this);
        super.release();     // Catch: Throwable -> L6
        _dropAllFrames();     // Catch: Throwable -> L6
        this.mAvailCount = 0;     // Catch: Throwable -> L6
        this.mClock.stop();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.texturerender.TextureRenderer
    public void updateDisplaySize(int r100, int r101) {
    }

    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    private boolean _draw() {
        _initFBOComponents();
        Iterator<SurfaceTextureStatus> r100 = this.mReadySurfaceTextureVector.iterator();
        ?? r101 = 0;
        int r102 = 0;
    L4:
        if (r100.hasNext() == false) goto L11;
        SurfaceTextureStatus r103 = r100.next();
        int r104 = r103.status;
        if (r104 == SurfaceTextureStatus.NEED_DRAW) goto L7;
        if (r104 != SurfaceTextureStatus.NEED_DROP) goto L4;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "_draw drop isMainSurface:" + isMainSurface(r103.surfaceTexture));
        _updateTexImage(r103.surfaceTexture);
        notify(r103.surfaceTexture);
        r100.remove();
        goto L4
    L7:
        r102 = r102 + 1;
        goto L4
    L11:
        boolean r105 = this.mNeedSync;
        if (r105 == true) goto L14;
    L15:
        if (r105 == true) goto L18;
        if (r102 <= 0) goto L18;
    L17:
        boolean r106 = true;
    L19:
        int r107 = getConsumerWidth();
        int r108 = getConsumerHeight();
        Iterator<SurfaceTextureStatus> r109 = this.mReadySurfaceTextureVector.iterator();
    L21:
        if (r109.hasNext() == false) goto L40;
        SurfaceTextureStatus r110 = r109.next();
        if (r110.status != SurfaceTextureStatus.NEED_DRAW) goto L39;
        if (isMainSurface(r110.surfaceTexture) == false) goto L27;
        this.mMainVideoFastDropNum = r101;
    L28:
        _updateTexImage(r110.surfaceTexture);
        if (r106 == true) goto L31;
    L38:
        notify(r110.surfaceTexture);
        r109.remove();
        goto L39
    L31:
        if (r110.surfaceTexture.needDrop() == true) goto L38;
        this.mNeedSync = r101;
        ITexture r111 = r110.surfaceTexture.getTexId();
        int r112 = r111.lock();
        GLOesTo2DFilter r113 = this.mOESDrawer;
        if (isMainSurface(r110.surfaceTexture) == false) goto L36;
        ITexture r114 = this.mMainTex;
    L37:
        this.mFBO.bindTexture2D(r114.lock());
        r113.setSurfaceTexture(r110.surfaceTexture);
        r113.setOption(13000, GLDefaultFilter.mTextureVerticesData);
        r113.setOption(10006, r107);
        r113.setOption(10007, r108);
        r113.setOption(10010, 1);
        r113.process(new EffectTexture(null, r112, -1, -1, 36197, null), null);
        r114.unlock();
        r111.unlock();
        notify(r110.surfaceTexture);
        VideoSurfaceTexture r115 = r110.surfaceTexture;
        r115.notifyRenderFrame(r115.getSerial());
        r109.remove();
        goto L39
    L36:
        r114 = this.mSubTex;
        goto L37
    L27:
        this.mSubVideoFastDropNum = r101;
    L39:
        r101 = 0;
        goto L21
    L40:
        if (r106 == false) goto L42;
    L45:
        boolean r116 = true;
    L46:
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "_draw needDrawCount:" + r102 + " needDrawToFBO:" + r106 + " needDrawToScreen" + r116 + " mNeedSync:" + this.mNeedSync);
        if (r116 == false) goto L49;
        GLES20.glBindFramebuffer(36160, 0);
        float[] r117 = this.mMainTexVerticesData;
        float r118 = this.mOverlayRatio;
        r117[2] = r118;
        r117[6] = r118;
        this.mDefaultDrawer.setOption(10008, 0);
        float r119 = r107;
        this.mDefaultDrawer.setOption(10006, (int) (this.mOverlayRatio * r119));
        this.mDefaultDrawer.setOption(10007, r108);
        this.mDefaultDrawer.setOption(13000, this.mMainTexVerticesData);
        this.mDefaultDrawer.setOption(10010, 1);
        this.mDefaultDrawer.process(new EffectTexture(null, this.mMainTex.lock(), -1, -1, 3553, null), null);
        this.mMainTex.unlock();
        float[] r120 = this.mSubTexVerticesData;
        float r121 = this.mOverlayRatio;
        r120[0] = r121;
        r120[4] = r121;
        this.mDefaultDrawer.setOption(10008, (int) (r121 * r119));
        this.mDefaultDrawer.setOption(10006, (int) (r119 * (1.0f - this.mOverlayRatio)));
        this.mDefaultDrawer.setOption(10007, getConsumerHeight());
        this.mDefaultDrawer.setOption(13000, this.mSubTexVerticesData);
        this.mDefaultDrawer.setOption(10010, 0);
        this.mDefaultDrawer.process(new EffectTexture(null, this.mSubTex.lock(), -1, -1, 3553, null), null);
        this.mSubTex.unlock();
        this.mIsOverlayRatioChanged = false;
    L49:
        return r116;
    L42:
        if (this.mIsOverlayRatioChanged == true) goto L45;
        r116 = false;
    L18:
        r106 = false;
        goto L19
    L14:
        if (r102 >= ALL_VIDEO_STREAM_NUM) goto L17;
        goto L15
    }

    private void _dropAllFrames() {
        Iterator<SurfaceTextureStatus> r100 = this.mReadySurfaceTextureVector.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        SurfaceTextureStatus r101 = r100.next();
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "_dropAllFrames isMain:" + isMainSurface(r101.surfaceTexture));
        _updateTexImage(r101.surfaceTexture);
        notify(r101.surfaceTexture);
        r100.remove();
        goto L4
    }

    private void _initFBOComponents() {
        if (this.mFBO != null) goto L6;
        this.mFBO = new FrameBuffer();
    L6:
        if (this.mSubTex != null) goto L9;
        this.mSubTex = this.mTextureFactory.createTexture(3553, this.mTexType);
    L9:
        if (this.mMainTex != null) goto L11;
        this.mMainTex = this.mTextureFactory.createTexture(3553, this.mTexType);
    L11:
        int r100 = getConsumerWidth();
        int r110 = getConsumerHeight();
        if (r100 <= 0) goto L33;
        if (r110 > 0) goto L15;
        return;
    L15:
        if (this.mFBOTexW == r100) goto L17;
    L18:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "_initFBOComponents surface H:" + r110 + " W:" + r100 + " mFBOTexH:" + this.mFBOTexH + " mFBOTexW:" + this.mFBOTexW);
        GLES20.glBindTexture(3553, this.mSubTex.lock());
        GLES20.glTexImage2D(3553, 0, 6408, r100, r110, 0, 6408, 5121, null);
        this.mSubTex.unlock();
        int r101 = TexGLUtils.checkGLError(this.mTexType, "createTexture sub");
        if (r101 == 0) goto L23;
        VideoSurfaceTexture r102 = this.mMainSurfaceTexture;
        if (r102 == null) goto L23;
        r102.notifyError(r101, 0, "createTexture sub");
    L23:
        ITexture r103 = this.mMainTex;
        if (r103 == null) goto L26;
        GLES20.glBindTexture(3553, r103.lock());
        GLES20.glTexImage2D(3553, 0, 6408, r100, r110, 0, 6408, 5121, null);
        this.mMainTex.unlock();
    L26:
        int r104 = TexGLUtils.checkGLError(this.mTexType, "createTexture main");
        if (r104 == 0) goto L31;
        VideoSurfaceTexture r105 = this.mMainSurfaceTexture;
        if (r105 == null) goto L31;
        r105.notifyError(r104, 0, "createTexture main");
    L31:
        this.mFBOTexH = r110;
        this.mFBOTexW = r100;
        return;
    L17:
        if (this.mFBOTexH != r110) goto L18;
        return;
    }

    private boolean _makeCurrent() {
        if (this.mEglSurface != EGL14.EGL_NO_SURFACE) goto L6;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "no surface for make current");
        return false;
    L6:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "make current again");
        GLES20.glFinish();
        EGLRuntime r100 = this.mEGLRuntime;
        EGLDisplay r101 = r100.eglDisplay;
        EGLSurface r102 = this.mEglSurface;
        if (EGL14.eglMakeCurrent(r101, r102, r102, r100.eglContext) == true) goto L10;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "make current failed = " + this.mEglSurface);
        return false;
    L10:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "make current done");
        this.mIsMakeCurrent = true;
        return true;
    }

    private int _render() {
        EGLSurface r100 = this.mEglSurface;
        if (r100 != EGL14.EGL_NO_SURFACE) goto L7;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "no surface to render");
        return -1;
    L7:
        if (EGL14.eglSwapBuffers(this.mEGLRuntime.eglDisplay, r100) == true) goto L10;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "swap buffer failed");
        return -1;
    L10:
        return 0;
    }

    @Override // com.ss.texturerender.TextureRenderer
    public void deinitGLComponents() {
        GLOesTo2DFilter r100 = this.mOESDrawer;
        if (r100 == null) goto L5;
        r100.release();
        this.mOESDrawer = null;
    L5:
        GLDefaultFilter r101 = this.mDefaultDrawer;
        if (r101 == null) goto L8;
        r101.release();
        this.mDefaultDrawer = null;
    L8:
        FrameBuffer r102 = this.mFBO;
        if (r102 == null) goto L11;
        r102.release();
        this.mFBO = null;
    L11:
        ITexture r103 = this.mMainTex;
        if (r103 == null) goto L14;
        r103.decRef();
        this.mMainTex = null;
    L14:
        ITexture r104 = this.mSubTex;
        if (r104 == null) goto L18;
        r104.decRef();
        this.mSubTex = null;
        return;
    }

    public int getConsumerHeight() {
        EGLSurface r100 = this.mEglSurface;
        if (r100 != EGL14.EGL_NO_SURFACE) goto L6;
        return -1;
    L6:
        int[] r101 = new int[1];
        EGL14.eglQuerySurface(this.mEGLRuntime.eglDisplay, r100, 12374, r101, 0);
        return r101[0];
    }

    public int getConsumerWidth() {
        EGLSurface r100 = this.mEglSurface;
        if (r100 != EGL14.EGL_NO_SURFACE) goto L6;
        return -1;
    L6:
        int[] r101 = new int[1];
        EGL14.eglQuerySurface(this.mEGLRuntime.eglDisplay, r100, 12375, r101, 0);
        return r101[0];
    }

    public long getMasterTimeStamp() {
        return this.mClock.getClock();
    }

    @Override // com.ss.texturerender.TextureRenderer
    public void initGLComponents() {
        if (this.mState != (-1)) goto L17;
        return;
    L17:
        GLOesTo2DFilter r100 = this.mOESDrawer;     // Catch: Exception -> L13
        if (r100 == null) goto L8;
        r100.release();     // Catch: Exception -> L13
    L8:
        GLOesTo2DFilter r101 = new GLOesTo2DFilter(this.mTexType);     // Catch: Exception -> L13
        this.mOESDrawer = r101;     // Catch: Exception -> L13
        r101.init(null);     // Catch: Exception -> L13
        GLDefaultFilter r102 = this.mDefaultDrawer;     // Catch: Exception -> L13
        if (r102 == null) goto L11;
        r102.release();     // Catch: Exception -> L13
    L11:
        GLDefaultFilter r103 = new GLDefaultFilter(this.mTexType);     // Catch: Exception -> L13
        this.mDefaultDrawer = r103;     // Catch: Exception -> L13
        r103.init(null);     // Catch: Exception -> L13
        this.mVsyncCallback = new VsyncHelper.VsyncCallback(this.mHandler);     // Catch: Exception -> L13
    L15:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "initGLComponents done");
        return;
    L13:
        e = move-exception;
        notifyEGLError(0, e.toString());
        goto L15
    }

    private void _avSyncByVsync() {
        long r100 = getMasterTimeStamp();
        Iterator<SurfaceTextureStatus> r101 = this.mReadySurfaceTextureVector.iterator();
    L4:
        if (r101.hasNext() == false) goto L23;
        SurfaceTextureStatus r102 = r101.next();
        long r103 = r102.frameTime.pts - r100;
        if (r103 > DROP_THRESHOLD_MS) goto L8;
        long r104 = 1000000 * r103;
        if (r104 >= (this.mVsyncHelper.getVsyncDurationNs() * (-2))) goto L19;
        r102.status = SurfaceTextureStatus.NEED_DROP;
    L22:
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "_avSyncByVsync pts:" + r102.frameTime.pts + " master:" + r100 + " diff:" + r103 + " isMainSurface:" + isMainSurface(r102.surfaceTexture) + " status:" + r102.status);
        goto L4
    L19:
        if (r104 <= this.mVsyncHelper.getVsyncDurationNs()) goto L21;
        r102.status = SurfaceTextureStatus.NEED_NOT_DRAW;
        goto L22
    L21:
        r102.status = SurfaceTextureStatus.NEED_DRAW;
        goto L22
    L8:
        if (isMainSurface(r102.surfaceTexture) == false) goto L10;
        int r105 = this.mMainVideoFastDropNum + 1;
        this.mMainVideoFastDropNum = r105;
    L12:
        if (r105 > DROP_NUM_THRESHOLD) goto L14;
        r102.status = SurfaceTextureStatus.NEED_DROP;
        goto L22
    L14:
        r102.status = SurfaceTextureStatus.NEED_NOT_DRAW;
        goto L22
    L10:
        r105 = this.mSubVideoFastDropNum + 1;
        this.mSubVideoFastDropNum = r105;
        goto L12
    }

    private void handleVsyncDraw() {
        _avSyncByVsync();
        if (_draw() == false) goto L5;
        _render();
    L5:
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "handleVsyncDraw end, ReadyVector size:" + this.mReadySurfaceTextureVector.size());
        if (this.mReadySurfaceTextureVector.isEmpty() == false) goto L9;
        this.mVsyncHelper.removeObserver(this.mVsyncCallback);
        this.mIsVsyncWorking = false;
        return;
    }

    public long getSurfaceUpdateTime() {
        return this.mUpdateSurfaceTime;
    }

    private void _updateTexImage(VideoSurfaceTexture r100) {
        r100.lock();     // Catch: Throwable -> L8 Exception -> L10
        if (r100.isRelease() == false) goto L6;
        r100.unlock();
        return;
    L6:
        r100.updateTexImage();     // Catch: Throwable -> L8 Exception -> L10
    L12:
        r100.unlock();
        return;
    L8:
        th = move-exception;
        r100.unlock();
        throw th;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L12
    }

    private boolean isMainSurface(VideoSurfaceTexture r100) {
        if (r100 != this.mMainSurfaceTexture) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean needNotify(VideoSurfaceTexture r100) {
        Iterator<SurfaceTextureStatus> r101 = this.mReadySurfaceTextureVector.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r101.next().surfaceTexture != r100) goto L4;
        return false;
    L9:
        if (isMainSurface(r100) == false) goto L14;
        if (this.mMainFrameTimeQueue.getSize() <= 0) goto L16;
        return false;
    L16:
        return true;
    L14:
        if (this.mSubFrameTimeQueue.getSize() <= 0) goto L21;
        return false;
    L21:
        return true;
    }

    private void notify(VideoSurfaceTexture r100) {
        Message r101 = this.mTextureNotifyMap.get(r100);
        if (r101 == null) goto L11;
        monitor-enter(r101);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "notify st:" + r100 + " MainQueue:" + this.mMainFrameTimeQueue.toString() + " SubQueue:" + this.mSubFrameTimeQueue.toString());     // Catch: Throwable -> L8
        r101.arg1 = Integer.MIN_VALUE;     // Catch: Throwable -> L8
        r101.notify();     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.texturerender.TextureRenderer
    public void handleFrameAvailable(Message r110) {
        VideoSurfaceTexture r111 = (VideoSurfaceTexture) r110.obj;
        if (isMainSurface(r111) == false) goto L5;
        FrameTimeQueue.FrameTime r100 = this.mMainFrameTimeQueue.poll(r111.getTimestamp());
    L6:
        long r101 = -1;
        if (r100 == null) goto L9;
        long r102 = r100.pts - getMasterTimeStamp();
    L10:
        int r103 = this.mTexType;
        String r104 = this.LOG_TAG;
        StringBuilder r105 = new StringBuilder("handleFrameAvailable,st = ");
        r105.append(r111);
        r105.append(" isMainSurface:");
        r105.append(isMainSurface(r111));
        r105.append(" pts:");
        if (r100 == null) goto L13;
        r101 = r100.pts;
    L13:
        r105.append(r101);
        r105.append(" master:");
        r105.append(getMasterTimeStamp());
        r105.append(" diff:");
        r105.append(r102);
        TextureRenderLog.d(r103, r104, r105.toString());
        if (r102 >= 0) goto L18;
        _updateTexImage(r111);
        notify(r111);
        return;
    L18:
        if (this.mIsVsyncWorking == true) goto L20;
        this.mVsyncHelper.addObserver(this.mVsyncCallback);
        this.mIsVsyncWorking = true;
    L20:
        this.mReadySurfaceTextureVector.add(new SurfaceTextureStatus(r111, r100));
        return;
    L9:
        r102 = -1;
        goto L10
    L5:
        r100 = this.mSubFrameTimeQueue.poll(r111.getTimestamp());
        goto L6
    }

    @Override // com.ss.texturerender.TextureRenderer
    public void handleGLThreadMessage(Message r100) {
        boolean r101 = true;
        switch(r100.what) {
            case 26: goto L36;
            case 27: goto L33;
            case 28: goto L31;
            case 29: goto L56;
            case 30: goto L56;
            case 31: goto L27;
            case 32: goto L6;
            case 33: goto L5;
            default: goto L56;
        };
    L5:
        this.mMainSurfaceTexture = (VideoSurfaceTexture) r100.obj;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "MSG_SET_MAIN_SURFACE st:" + this.mMainSurfaceTexture);
        return;
    L6:
        Bundle r102 = r100.getData();
        VideoSurfaceTexture r103 = (VideoSurfaceTexture) r102.getSerializable(VideoSurfaceTexture.KEY_TEXTURE);
        FrameTimeQueue.FrameTime r104 = (FrameTimeQueue.FrameTime) r102.getSerializable(TextureRenderKeys.OVERLAY_UPDATE_FRAME_TIME);
        if (isMainSurface(r103) == false) goto L11;
        String r105 = r102.getString(TextureRenderKeys.OVERLAY_MASTER_CLOCK);
        if (TextUtils.isEmpty(r105) == true) goto L11;
        updateMaster(CastLongProtector.parseLong(r105.trim()) + (SystemClock.elapsedRealtime() - r102.getLong(TextureRenderKeys.OVERLAY_MASTER_CLOCK_DIFF)));
    L11:
        boolean r106 = needNotify(r103);
        if (r106 == false) goto L21;
        Message r107 = (Message) r100.obj;
        monitor-enter(r107);
        r107.arg1 = (int) r104.pts;     // Catch: Throwable -> L18
        r100.obj.notify();     // Catch: Throwable -> L18
        monitor-exit(r107);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L21:
        this.mTextureNotifyMap.put(r103, (Message) r100.obj);
        if (isMainSurface(r103) == false) goto L24;
        this.mMainFrameTimeQueue.add(r104);
    L25:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "MSG_UPDATE_FRAME_TIME needNotify:" + r106 + " MainQueue:" + this.mMainFrameTimeQueue.getSize() + " SubQueue:" + this.mSubFrameTimeQueue.getSize());
        return;
    L24:
        this.mSubFrameTimeQueue.add(r104);
        goto L25
    L31:
        handleVsyncComing(r100);
        return;
    L33:
        handleSetOverlayRatio(r100);
        return;
    L56:
        return;
    L27:
        if (r100.arg1 == 1) goto L30;
        r101 = false;
    L30:
        this.mNeedSync = r101;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "MSG_SET_OVERLAY_SYNC mNeedSync:" + this.mNeedSync);
        return;
    L36:
        if (isMainSurface((VideoSurfaceTexture) r100.obj) == true) goto L38;
        return;
    L38:
        int r108 = r100.arg1;
        if (r108 != 1) goto L41;
        this.mClock.start();
        return;
    L41:
        if (r108 != 3) goto L43;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "TEXTURE_STATE_STOP");
        this.mMainFrameTimeQueue.clear();
        this.mSubFrameTimeQueue.clear();
        this.mClock.stop();
        return;
    L43:
        if (r108 != 4) goto L57;
        this.mClock.pause();
        return;
    }

    public void handleSetOverlayRatio(Message r100) {
        float r101 = r100.getData().getFloat(TextureRenderKeys.OVERLAY_RATIO);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "SetOverlayRatio ratio:" + r101);
        if (r101 == this.mOverlayRatio) goto L8;
        this.mOverlayRatio = r101;
        this.mIsOverlayRatioChanged = true;
        if (this.mIsVsyncWorking == true) goto L9;
        this.mVsyncHelper.addObserver(this.mVsyncCallback);
        this.mIsVsyncWorking = true;
        return;
    L9:
        return;
    }

    @Override // com.ss.texturerender.TextureRenderer
    public void handleSetSurface(Message r110) {
        Bundle r100 = r110.getData();
        if (r100 == null) goto L51;
        VideoSurfaceTexture r101 = (VideoSurfaceTexture) r100.getSerializable(VideoSurfaceTexture.KEY_TEXTURE);
        if (r101 == null) goto L49;
        Surface r102 = r101.getUpdateSurface();
        Surface r103 = this.mCurrentSurface;
        if (r103 == null) goto L14;
        if (r103 != r102) goto L14;
        if (r102 == null) goto L14;
        if (r102.toString().contains("SurfaceTexture") == false) goto L14;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "set same surface, return");
        return;
    L14:
        if (r102 != null) goto L20;
        _dropAllFrames();
        if (this.mCurrentSurface != null) goto L20;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "reset null surface, return");
        return;
    L20:
        if (this.mEglSurface == EGL14.EGL_NO_SURFACE) goto L25;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "destory previous surface = " + this.mEglSurface);
        if (r102 != null) goto L24;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "make current to dummy surface due to non render surface");
        EGLRuntime r104 = this.mEGLRuntime;
        EGLDisplay r105 = r104.eglDisplay;
        EGLSurface r106 = r104.eglDummySurface;
        EGL14.eglMakeCurrent(r105, r106, r106, r104.eglContext);
    L24:
        boolean r107 = EGL14.eglDestroySurface(this.mEGLRuntime.eglDisplay, this.mEglSurface);
        this.mEglSurface = EGL14.EGL_NO_SURFACE;
        this.mIsMakeCurrent = false;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "destory previous surface done = " + this.mEglSurface + " ret:" + r107);
    L25:
        if (r102 != null) goto L27;
    L37:
        this.mUpdateSurfaceTime = System.nanoTime();
        this.mCurrentSurface = r102;
        Object r111 = r110.obj;
        if (r111 == null) goto L46;
        monitor-enter(r111);
        r111.notify();     // Catch: Throwable -> L43
        monitor-exit(r111);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    L46:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "set surface done, mEglSurface=" + this.mEglSurface);
        return;
    L27:
        if (r102.isValid() == false) goto L37;
        int[] r108 = {12344};
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "create window surface from " + r102);     // Catch: Exception -> L35
        EGLRuntime r109 = this.mEGLRuntime;     // Catch: Exception -> L35
        EGLSurface r112 = EGL14.eglCreateWindowSurface(r109.eglDisplay, r109.eglConfig, r102, r108, 0);     // Catch: Exception -> L35
        this.mEglSurface = r112;     // Catch: Exception -> L35
        if (r112 != EGL14.EGL_NO_SURFACE) goto L33;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "create window surface failed" + GLUtils.getEGLErrorString(EGL14.eglGetError()));     // Catch: Exception -> L35
        return;
    L33:
        _makeCurrent();     // Catch: Exception -> L35
        float[] r113 = GLDefaultFilter.mTextureVerticesData;     // Catch: Exception -> L35
        int r114 = r113.length;     // Catch: Exception -> L35
        float[] r115 = new float[r114];     // Catch: Exception -> L35
        this.mMainTexVerticesData = r115;     // Catch: Exception -> L35
        System.arraycopy(r113, 0, r115, 0, r114);     // Catch: Exception -> L35
        float[] r116 = new float[r114];     // Catch: Exception -> L35
        this.mSubTexVerticesData = r116;     // Catch: Exception -> L35
        System.arraycopy(GLDefaultFilter.mTextureVerticesData, 0, r116, 0, r114);     // Catch: Exception -> L35
    L35:
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "create current exception failed");
        return;
    L49:
        throw new RuntimeException(this.LOG_TAG + " update surface but missing texture");
    L51:
        throw new RuntimeException(this.LOG_TAG + " update surface but missing bundle?");
    }

    public void handleVsyncComing(Message r100) {
        handleVsyncDraw();
    }

    public void updateMaster(long r100) {
        this.mClock.updateClock(r100);
    }

    public OverlayVideoTextureRenderer(EffectConfig r100, int r101) {
        this(r100, r101, null, null);
    }

    public OverlayVideoTextureRenderer(EffectConfig r100, int r101, EGLContext r102, EGLConfig r110) {
        super(r100, r101, r102, r110, false);
        this.mCurrentSurface = null;
        this.mEglSurface = EGL14.EGL_NO_SURFACE;
        this.mIsMakeCurrent = false;
        this.mAvailCount = 0;
        this.mIsVsyncWorking = false;
        this.mFBOTexH = 0;
        this.mFBOTexW = 0;
        this.mOverlayRatio = 0.5f;
        this.mIsOverlayRatioChanged = false;
        this.mNeedSync = false;
        this.mMainVideoFastDropNum = 0;
        this.mSubVideoFastDropNum = 0;
        this.mTextureNotifyMap = new HashMap();
        this.mTexType = -1;
        this.mReadySurfaceTextureVector = new Vector(2);
        this.mVsyncHelper = new VsyncHelper(TextureRenderManager.getManager().getContext(), this.mTexType);
        this.mMainFrameTimeQueue = new FrameTimeQueue();
        this.mSubFrameTimeQueue = new FrameTimeQueue();
        this.mTexType = r101;
        this.mClock = new NormalClock(r101);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "OverlayVideoTextureRenderer");
    }
}
