package com.ss.texturerender;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.view.Surface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.texturerender.base.EGLRuntime;
import com.ss.texturerender.effect.AbsEffect;
import com.ss.texturerender.effect.AdaptiveSharpenEffect;
import com.ss.texturerender.effect.BMFVQScoreWrapper;
import com.ss.texturerender.effect.EffectConfig;
import com.ss.texturerender.effect.EffectFactory;
import com.ss.texturerender.effect.EffectTexture;
import com.ss.texturerender.effect.EffectTextureManager;
import com.ss.texturerender.effect.EmptyEffect;
import com.ss.texturerender.effect.FrameBuffer;
import com.ss.texturerender.effect.GLBlitFilter;
import com.ss.texturerender.effect.GLBlitOESFliter;
import com.ss.texturerender.effect.GLBrightnessBalanceFilter;
import com.ss.texturerender.effect.GLDefaultFilter;
import com.ss.texturerender.effect.GLLut3DFilter;
import com.ss.texturerender.effect.GLOesTo2DFilter;
import com.ss.texturerender.effect.HardwareBuffer2GLFilter;
import com.ss.texturerender.effect.HardwareBufferEglPoolFilter;
import com.ss.texturerender.effect.PureColorDetector;
import com.ss.texturerender.effect.VideoOCLSREffect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes40.dex */
public class VideoTextureRenderer extends TextureRenderer {
    private static VideoTextureRenderer mRenderInstance;
    private AbsEffect mAesBoostFilter;
    private AbsEffect mAnimationFilter;
    private AbsEffect mBMFDrawer;
    private GLBlitFilter mBlitFilter;
    private GLBlitOESFliter mBlitOESFliter;
    private GLBrightnessBalanceFilter mBrightnessBalanceFilter;
    private GLDefaultFilter mCurrentDrawer;
    private Queue<Integer> mErrorList;
    private Map<VideoSurfaceTexture, AbsEffect> mExtScreenFilters;
    private int mFinalTexId;
    private FrameBuffer mFrameBuffer;
    private ByteBuffer mFrameCallbackBufffer;
    private AbsEffect mHardwareBuffer2GLFilter;
    private AbsEffect mHardwareBufferEGLPoolFilter;
    private GLLut3DFilter mLut3DFilter;
    private AbsEffect mMultiRenderTargetFilter;
    private int mOutTexHeight;
    private int mOutTexWidth;
    private PureColorDetector mPureColorDetector;
    private ByteBuffer mSaveFrameBuffer;
    private EffectTexture mStoredEffectTexture;
    private FrameBuffer mStoredFrameBuffer;
    private GLDefaultFilter mTex2dDrawer;
    private GLOesTo2DFilter mTexOesDrawer;
    private VideoSurfaceTexture mTileVideoSurfaceTexture;
    private AbsEffect mTopEffect;
    private BMFVQScoreWrapper mVqscoreWrapper;

    @Override // com.ss.texturerender.TextureRenderer
    public void deinitEffectComponents() {
        this.mBMFDrawer = null;
        AbsEffect r100 = this.mTopEffect.release();
    L4:
        if (r100 == null) goto L6;
        this.mEffectConfig.setEffectOpen(r100.getIntOption(10005), 0);
        r100 = r100.release();
        goto L4
    L6:
        EffectConfig r101 = this.mEffectConfig;
        if (r101 != null) goto L9;
    L11:
        AbsEffect r102 = this.mMultiRenderTargetFilter;
        if (r102 == null) goto L14;
        r102.release();
        this.mMultiRenderTargetFilter = null;
    L14:
        AbsEffect r103 = this.mAesBoostFilter;
        if (r103 == null) goto L17;
        r103.release();
        this.mAesBoostFilter = null;
    L17:
        GLLut3DFilter r104 = this.mLut3DFilter;
        if (r104 == null) goto L20;
        r104.release();
        this.mLut3DFilter = null;
    L20:
        AbsEffect r105 = this.mAnimationFilter;
        if (r105 == null) goto L28;
        r105.release();
        this.mAnimationFilter = null;
        FrameBuffer r106 = this.mStoredFrameBuffer;
        if (r106 == null) goto L25;
        r106.release();
        this.mStoredFrameBuffer = null;
    L25:
        EffectTexture r107 = this.mStoredEffectTexture;
        if (r107 == null) goto L28;
        r107.giveBack();
        this.mStoredEffectTexture = null;
    L28:
        GLBrightnessBalanceFilter r108 = this.mBrightnessBalanceFilter;
        if (r108 == null) goto L32;
        r108.release();
        this.mBrightnessBalanceFilter = null;
    L32:
        if (this.mExtScreenFilters.isEmpty() == true) goto L47;
        Iterator<Map.Entry<VideoSurfaceTexture, AbsEffect>> r109 = this.mExtScreenFilters.entrySet().iterator();
    L35:
        if (r109.hasNext() == false) goto L39;
        Map.Entry<VideoSurfaceTexture, AbsEffect> r110 = r109.next();
        AbsEffect r111 = r110.getValue();
        if (r111 == null) goto L35;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, r110.getKey() + " remove ext screen filter:" + r111);
        r111.release();
        goto L35
    L39:
        this.mExtScreenFilters.clear();
        return;
    L47:
        return;
    L9:
        if (this.mVqscoreWrapper == null) goto L11;
        r101.setEffectOpen(16, 0);
        this.mVqscoreWrapper.release();
        goto L11
    }

    @Override // com.ss.texturerender.TextureRenderer
    public void onInternalStateChanged(int r100) {
    }

    @Override // com.ss.texturerender.TextureRenderer
    public synchronized void release() {
        monitor-enter(this);
        super.release();     // Catch: Throwable -> L6
        mRenderInstance = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.texturerender.TextureRenderer
    public void updateDisplaySize(int r100, int r101) {
    }

    public static synchronized VideoTextureRenderer getRenderer() {
        monitor-enter(VideoTextureRenderer.class);
        VideoTextureRenderer r100 = getRenderer(null, null);     // Catch: Throwable -> L8
        monitor-exit(VideoTextureRenderer.class);
        return r100;
    L8:
        th = move-exception;
        throw th;
    }

    private void initFbo() {
        if (this.mFrameBuffer != null) goto L6;
        this.mFrameBuffer = new FrameBuffer();
    L6:
        if (this.mEffectTextureManager != null) goto L9;
        this.mEffectTextureManager = new EffectTextureManager(this.mTexType);
        return;
    }

    private void resetCropParams() {
        GLOesTo2DFilter r100 = this.mTexOesDrawer;
        if (r100 == null) goto L5;
        r100.resetCropParams();
    L5:
        GLDefaultFilter r101 = this.mTex2dDrawer;
        if (r101 == null) goto L9;
        r101.resetCropParams();
        return;
    }

    private void resetRotationMirrorParams() {
        GLOesTo2DFilter r100 = this.mTexOesDrawer;
        if (r100 == null) goto L5;
        r100.setOption(30, 0);
        this.mTexOesDrawer.setOption(31, 0);
        this.mTexOesDrawer.setOption(29, 0);
        this.mTexOesDrawer.setOption(26, 1);
    L5:
        GLDefaultFilter r101 = this.mTex2dDrawer;
        if (r101 == null) goto L9;
        r101.setOption(30, 0);
        this.mTex2dDrawer.setOption(31, 0);
        this.mTex2dDrawer.setOption(29, 0);
        this.mTex2dDrawer.setOption(26, 1);
        return;
    }

    private void setup2DGraphics() {
        GLDefaultFilter r100 = this.mTex2dDrawer;     // Catch: Exception -> L18
        if (r100 == null) goto L5;
        r100.release();     // Catch: Exception -> L18
    L5:
        GLDefaultFilter r101 = (GLDefaultFilter) EffectFactory.createEffect(this.mTexType, 7);     // Catch: Exception -> L18
        this.mTex2dDrawer = r101;     // Catch: Exception -> L18
        if (r101 != null) goto L9;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "create effect failed");     // Catch: Exception -> L18
        return;
    L9:
        r101.init(null);     // Catch: Exception -> L18
        this.mTex2dDrawer.setParentRender(this);     // Catch: Exception -> L18
        GLBlitFilter r102 = this.mBlitFilter;     // Catch: Exception -> L18
        if (r102 == null) goto L12;
        r102.release();     // Catch: Exception -> L18
    L12:
        GLBlitFilter r103 = (GLBlitFilter) EffectFactory.createEffect(this.mTexType, 25);     // Catch: Exception -> L18
        this.mBlitFilter = r103;     // Catch: Exception -> L18
        if (r103 != null) goto L16;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "create effectblit failed");     // Catch: Exception -> L18
        return;
    L16:
        r103.init(null);     // Catch: Exception -> L18
        this.mBlitFilter.setParentRender(this);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        notifyEGLError(0, e.toString());
    }

    private void setupGraphics() {
        GLOesTo2DFilter r100 = this.mTexOesDrawer;     // Catch: Exception -> L24
        if (r100 == null) goto L5;
        r100.release();     // Catch: Exception -> L24
    L5:
        GLOesTo2DFilter r101 = (GLOesTo2DFilter) EffectFactory.createEffect(this.mTexType, 3);     // Catch: Exception -> L24
        this.mTexOesDrawer = r101;     // Catch: Exception -> L24
        if (r101 != null) goto L10;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "create effect failed");     // Catch: Exception -> L24
        return;
    L10:
        if (this.mTexType != 1) goto L12;
    L14:
        Bundle r102 = null;
    L15:
        this.mTexOesDrawer.init(r102);     // Catch: Exception -> L24
        this.mTexOesDrawer.setParentRender(this);     // Catch: Exception -> L24
        GLBlitOESFliter r103 = this.mBlitOESFliter;     // Catch: Exception -> L24
        if (r103 == null) goto L18;
        r103.release();     // Catch: Exception -> L24
    L18:
        GLBlitOESFliter r104 = (GLBlitOESFliter) EffectFactory.createEffect(this.mTexType, 26);     // Catch: Exception -> L24
        this.mBlitOESFliter = r104;     // Catch: Exception -> L24
        if (r104 != null) goto L22;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "create effectoesblitTo2d failed");     // Catch: Exception -> L24
        return;
    L22:
        r104.init(r102);     // Catch: Exception -> L24
        this.mBlitOESFliter.setParentRender(this);     // Catch: Exception -> L24
        return;
    L12:
        if (this.mEGLRuntime == null) goto L14;
        r102 = new Bundle();     // Catch: Exception -> L24
        r102.putInt(TextureRenderKeys.KEY_IS_GL_MAJOR_VERSION, this.mEGLRuntime.getGLMajorVersion());     // Catch: Exception -> L24
        r102.putInt(TextureRenderKeys.KEY_IS_GL_MINOR_VERSION, this.mEGLRuntime.getGLMinorVersion());     // Catch: Exception -> L24
    L24:
        e = move-exception;
        notifyEGLError(0, e.toString());
    }

    @Override // com.ss.texturerender.TextureRenderer
    public void deinitGLComponents() {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "delete program");
        this.mCurrentDrawer = null;
        PureColorDetector r100 = this.mPureColorDetector;
        if (r100 == null) goto L5;
        r100.release();
        this.mPureColorDetector = null;
    L5:
        GLOesTo2DFilter r101 = this.mTexOesDrawer;
        if (r101 == null) goto L8;
        r101.release();
        this.mTexOesDrawer = null;
    L8:
        GLDefaultFilter r102 = this.mTex2dDrawer;
        if (r102 == null) goto L11;
        r102.release();
        this.mTex2dDrawer = null;
    L11:
        GLBlitFilter r103 = this.mBlitFilter;
        if (r103 == null) goto L14;
        r103.release();
        this.mBlitFilter = null;
    L14:
        GLBlitOESFliter r104 = this.mBlitOESFliter;
        if (r104 == null) goto L17;
        r104.release();
        this.mBlitOESFliter = null;
    L17:
        FrameBuffer r105 = this.mFrameBuffer;
        if (r105 == null) goto L20;
        r105.release();
        this.mFrameBuffer = null;
    L20:
        EffectTextureManager r106 = this.mEffectTextureManager;
        if (r106 == null) goto L23;
        r106.release();
        this.mEffectTextureManager = null;
    L23:
        AbsEffect r107 = this.mHardwareBuffer2GLFilter;
        if (r107 == null) goto L26;
        r107.release();
        this.mHardwareBuffer2GLFilter = null;
    L26:
        AbsEffect r108 = this.mHardwareBufferEGLPoolFilter;
        if (r108 == null) goto L30;
        r108.release();
        this.mHardwareBufferEGLPoolFilter = null;
        return;
    }

    @Override // com.ss.texturerender.TextureRenderer
    public void initGLComponents() {
        if (this.mState != (-1)) goto L5;
        return;
    L5:
        setupGraphics();
        if (this.mEffectConfig.isOpenSR() == false) goto L9;
        setup2DGraphics();
        return;
    }

    private void initTileVideoSurfaceTexture() {
        ITexture r100 = getTexture();
        if (r100 == null) goto L5;
        VideoSurfaceTexture r101 = new VideoSurfaceTexture(r100, this.mHandler, this);
        r101.setEffectOpen(18, 1, null);
        r101.setOption(5, this.mTexType);
        r101.bindEGLEnv(this.mEGLRuntime);
        r100.decRef();
        this.mTileVideoSurfaceTexture = r101;
        return;
    L5:
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "tile surface texture init failed");
    }

    @Override // com.ss.texturerender.TextureRenderer
    public VideoSurfaceTexture getExtraVideoSurfaceTexture() {
        return this.mTileVideoSurfaceTexture;
    }

    private boolean checkUseOesFormat(AbsEffect r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        AbsEffect r101 = this.mMultiRenderTargetFilter;
        if (r101 != null) goto L10;
        r101 = this.mTopEffect.getNextEffect();
    L10:
        if (r101 == null) goto L26;
        if (r101 == r100) goto L26;
        if (r100.getIntOption(10011) >= r101.getIntOption(10011)) goto L16;
        boolean r102 = false;
    L27:
        if (r102 == true) goto L29;
    L33:
        return false;
    L29:
        if (r100.getIntOption(10014) != 1) goto L33;
        if (this.mEffectConfig.getEffectOpen(11) == true) goto L33;
        return true;
    L16:
        if (r101.getIntOption(10004) != 36197) goto L26;
        int r103 = r101.getIntOption(10005);
        if (reInitIfNeed(r103, 3553) == 0) goto L26;
        if (r103 != 5) goto L22;
        this.mErrorList.offer(1);
        goto L26
    L22:
        if (r103 != 1) goto L24;
        this.mErrorList.offer(3);
        goto L26
    L24:
        this.mErrorList.offer(6);
    L26:
        r102 = true;
        goto L27
    }

    private void frameBufferCallback(Message r110) {
        VideoSurfaceTexture r111 = (VideoSurfaceTexture) r110.obj;
        Bundle r100 = r111.getFrameCallbackBundle();
        if (r100 == null) goto L45;
        VideoSurface.FrameRenderCallback r101 = (VideoSurface.FrameRenderCallback) r100.getSerializable("callback");
        int r112 = this.mOutTexWidth;
        int r113 = this.mOutTexHeight;
        int r114 = r100.getInt(TextureRenderKeys.KEY_IS_BUFFER_TYPE);
        if (r114 != 2) goto L35;
        int r102 = (r112 * r113) * 4;
        if (r100.getBoolean(TextureRenderKeys.KEY_IS_REUSE_BUFFER) == false) goto L15;
        ByteBuffer r103 = this.mFrameCallbackBufffer;     // Catch: Exception -> L32
        if (r103 != null) goto L12;
    L13:
        this.mFrameCallbackBufffer = ByteBuffer.allocateDirect(r102);     // Catch: Exception -> L32
    L14:
        ByteBuffer r104 = this.mFrameCallbackBufffer;     // Catch: Exception -> L32
    L16:
        r104.rewind();     // Catch: Exception -> L32
        r104.order(ByteOrder.LITTLE_ENDIAN);     // Catch: Exception -> L32
        GLES20.glFinish();     // Catch: Exception -> L32
        FrameBuffer r105 = this.mFrameBuffer;     // Catch: Exception -> L32
        if (r105 == null) goto L21;
        int r106 = this.mFinalTexId;     // Catch: Exception -> L32
        if (r106 == (-1)) goto L21;
        r105.bindTexture2D(r106);     // Catch: Exception -> L32
    L21:
        GLES20.glReadPixels(0, 0, r112, r113, 6408, 5121, r104);     // Catch: Exception -> L32
        FrameBuffer r107 = this.mFrameBuffer;     // Catch: Exception -> L32
        if (r107 == null) goto L24;
        r107.unbindTexture2D();     // Catch: Exception -> L32
    L24:
        int r108 = TexGLUtils.checkGLError(this.mTexType, "handleFrameCallback");     // Catch: Exception -> L32
        if (r108 == 0) goto L27;
        r111.notifyError(r108, 0, "handleFrameCallback");     // Catch: Exception -> L32
    L27:
        r104.rewind();     // Catch: Exception -> L32
        int r115 = r112 * 4;     // Catch: Exception -> L32
        byte[] r109 = new byte[r115];     // Catch: Exception -> L32
        int r116 = 0;
    L29:
        if (r116 >= (r113 / 2)) goto L31;
        r104.get(r109);     // Catch: Exception -> L32
        System.arraycopy(r104.array(), r104.limit() - r104.position(), r104.array(), r104.position() - r115, r115);     // Catch: Exception -> L32
        System.arraycopy(r109, 0, r104.array(), r104.limit() - r104.position(), r115);     // Catch: Exception -> L32
        r116 = r116 + 1;     // Catch: Exception -> L32
        goto L29
    L31:
        r104.rewind();     // Catch: Exception -> L32
        r101.onBytebufferCallbck(2, r104, r112, r113, System.currentTimeMillis());     // Catch: Exception -> L32
        return;
    L12:
        if (r103.capacity() >= r102) goto L14;
    L15:
        r104 = ByteBuffer.allocateDirect(r102);     // Catch: Exception -> L32
        goto L16
    L35:
        if (r114 != 1) goto L47;
        r101.onTextureCallback(6408, 2, this.mFinalTexId, this.mEGLRuntime.eglContext, r112, r113, System.currentTimeMillis());     // Catch: Exception -> L32
        return;
    L47:
        return;
    L32:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "frame callback failed " + e.getMessage());
        if (r114 != 2) goto L41;
        r101.onBytebufferCallbck(-1, null, -1, -1, System.currentTimeMillis());
        return;
    L41:
        r101.onTextureCallback(-1, -1, -1, null, -1, -1, System.currentTimeMillis());
        return;
    }

    private int getConsumerHeight(EGLSurface r100) {
        if (r100 != EGL14.EGL_NO_SURFACE) goto L6;
        return -1;
    L6:
        int[] r101 = new int[1];
        EGL14.eglQuerySurface(this.mEGLRuntime.eglDisplay, r100, 12374, r101, 0);
        return r101[0];
    }

    private int getConsumerWidth(EGLSurface r100) {
        if (r100 != EGL14.EGL_NO_SURFACE) goto L6;
        return -1;
    L6:
        int[] r101 = new int[1];
        EGL14.eglQuerySurface(this.mEGLRuntime.eglDisplay, r100, 12375, r101, 0);
        return r101[0];
    }

    private AbsEffect getEffect(int r100) {
        AbsEffect r101 = this.mMultiRenderTargetFilter;
        if (r101 != null) goto L5;
    L8:
        AbsEffect r102 = this.mAesBoostFilter;
        if (r102 != null) goto L11;
    L14:
        AbsEffect r103 = this.mAnimationFilter;
        if (r103 != null) goto L17;
    L20:
        GLBrightnessBalanceFilter r104 = this.mBrightnessBalanceFilter;
        if (r104 != null) goto L23;
    L26:
        AbsEffect r105 = this.mTopEffect.getNextEffect();
    L27:
        if (r105 == null) goto L32;
        if (r105.getIntOption(10005) == r100) goto L30;
        r105 = r105.getNextEffect();
        goto L27
    L30:
        return r105;
    L32:
        return null;
    L23:
        if (r100 != r104.getIntOption(10005)) goto L26;
        return this.mBrightnessBalanceFilter;
    L17:
        if (r100 != r103.getIntOption(10005)) goto L20;
        return this.mAnimationFilter;
    L11:
        if (r100 != r102.getIntOption(10005)) goto L14;
        return this.mAesBoostFilter;
    L5:
        if (r100 != r101.getIntOption(10005)) goto L8;
        return this.mMultiRenderTargetFilter;
    }

    private boolean hasEffectOpen(VideoSurfaceTexture r100) {
        ConcurrentHashMap<Integer, Integer> r101 = this.mEffectConfig.getEffectConfigMap();
        EffectConfig r102 = r100.getEffectConfig();
        Iterator<Map.Entry<Integer, Integer>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L13;
        Map.Entry<Integer, Integer> r104 = r103.next();
        if (r104.getKey().intValue() == 11) goto L4;
        if (r104.getValue().intValue() != 1) goto L4;
        if (r102.getEffectOpen(r104.getKey().intValue()) == false) goto L4;
        return true;
    L13:
        return false;
    }

    private void saveImage(Message r110) {
        VideoSurfaceTexture r100 = (VideoSurfaceTexture) r110.obj;
        Bundle r111 = r110.getData();
        VideoSurface.SaveFrameCallback r101 = (VideoSurface.SaveFrameCallback) r111.getSerializable("callback");
        if (r101 != null) goto L36;
        return;
    L36:
        int r102 = r100.getViewportWidth();     // Catch: Exception -> L33
        int r103 = r100.getViewportHeight();     // Catch: Exception -> L33
        if (r111.getBoolean(TextureRenderKeys.KEY_IS_ORIGIN_VIDEO, false) == false) goto L10;
        GLDefaultFilter r104 = this.mCurrentDrawer;     // Catch: Exception -> L33
        if (r104 == null) goto L10;
        int r105 = r104.getIntOption(20003);     // Catch: Exception -> L33
        int r106 = this.mCurrentDrawer.getIntOption(20004);     // Catch: Exception -> L33
        int r107 = this.mCurrentDrawer.getIntOption(20001);     // Catch: Exception -> L33
        int r112 = this.mCurrentDrawer.getIntOption(20002);     // Catch: Exception -> L33
    L11:
        float r113 = r111.getFloat("width", -1.0f);     // Catch: Exception -> L33
        if (r113 <= 0.0f) goto L14;
        float r108 = r102;
        int r109 = Math.round(r113 * r108);     // Catch: Exception -> L33
        float r114 = r103;
        int r115 = Math.round(r111.getFloat("height") * r114);     // Catch: Exception -> L33
        r105 = Math.round(r111.getFloat("x") * r108);     // Catch: Exception -> L33
        int r116 = r115;
        int r117 = r109;
        r106 = Math.round(r111.getFloat("y") * r114);     // Catch: Exception -> L33
    L15:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "async saveframe = " + r117 + ", " + r116 + " viewW:" + r102 + " viewH:" + r103);     // Catch: Exception -> L33
        int r118 = (r117 * r116) * 4;     // Catch: Exception -> L33
        if (r111.getBoolean(TextureRenderKeys.KEY_IS_REUSE_BUFFER) == false) goto L23;
        ByteBuffer r119 = this.mSaveFrameBuffer;     // Catch: Exception -> L33
        if (r119 != null) goto L20;
    L21:
        this.mSaveFrameBuffer = ByteBuffer.allocateDirect(r118);     // Catch: Exception -> L33
    L22:
        ByteBuffer r120 = this.mSaveFrameBuffer;     // Catch: Exception -> L33
    L24:
        r120.rewind();     // Catch: Exception -> L33
        r120.order(ByteOrder.LITTLE_ENDIAN);     // Catch: Exception -> L33
        GLES20.glFinish();     // Catch: Exception -> L33
        GLES20.glReadPixels(r105, r106, r117, r116, 6408, 5121, r120);     // Catch: Exception -> L33
        int r121 = TexGLUtils.checkGLError(this.mTexType, "handleSaveFrame");     // Catch: Exception -> L33
        if (r121 == 0) goto L27;
        r100.notifyError(r121, 0, "handleSaveFrame");     // Catch: Exception -> L33
    L27:
        r120.rewind();     // Catch: Exception -> L33
        int r122 = r117 * 4;     // Catch: Exception -> L33
        byte[] r123 = new byte[r122];     // Catch: Exception -> L33
        int r124 = 0;
    L29:
        if (r124 >= (r116 / 2)) goto L31;
        r120.get(r123);     // Catch: Exception -> L33
        System.arraycopy(r120.array(), r120.limit() - r120.position(), r120.array(), r120.position() - r122, r122);     // Catch: Exception -> L33
        System.arraycopy(r123, 0, r120.array(), r120.limit() - r120.position(), r122);     // Catch: Exception -> L33
        r124 = r124 + 1;     // Catch: Exception -> L33
        goto L29
    L31:
        r120.rewind();     // Catch: Exception -> L33
        r101.onFrame(r120, r117, r116);     // Catch: Exception -> L33
        return;
    L20:
        if (r119.capacity() >= r118) goto L22;
    L23:
        r120 = ByteBuffer.allocateDirect(r118);     // Catch: Exception -> L33
        goto L24
    L14:
        r117 = r107;
        r116 = r112;
    L10:
        r107 = r102;
        r112 = r103;
        r105 = 0;
        r106 = 0;
    L33:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "save frame failed " + e.getMessage());
        r101.onFrame(null, 0, 0);
    }

    private int storeEffectTexture(EffectTexture r110) {
        if (this.mStoredFrameBuffer != null) goto L6;
        this.mStoredFrameBuffer = new FrameBuffer();
    L6:
        if (this.mEffectTextureManager != null) goto L8;
        this.mEffectTextureManager = new EffectTextureManager(this.mTexType);
    L8:
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        if (this.mStoredEffectTexture != null) goto L11;
        this.mStoredEffectTexture = this.mEffectTextureManager.genTexture(r100, r101, null);
    L11:
        this.mStoredFrameBuffer.bindTexture2D(r110.getTexID());
        GLES20.glBindTexture(3553, this.mStoredEffectTexture.getTexID());
        GLES20.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, r100, r101);
        this.mStoredFrameBuffer.unbindTexture2D();
        int r111 = GLES20.glGetError();
        if (r111 == 0) goto L14;
        this.mStoredEffectTexture.giveBack();
        this.mStoredEffectTexture = null;
    L14:
        return r111;
    }

    private boolean surfaceTextureUpdateImage(VideoSurfaceTexture r100) {
        if (r100 != null) goto L23;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "surface texture is null not draw");
        return false;
    L23:
        r100.lock();     // Catch: Throwable -> L14 Exception -> L16
        if (r100.isRelease() == false) goto L11;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "surface texture is released not draw");     // Catch: Throwable -> L14 Exception -> L16
        r100.unlock();
        return false;
    L11:
        r100.updateTexImage();     // Catch: Throwable -> L14 Exception -> L16
        r100.mFrameReady = false;     // Catch: Throwable -> L14 Exception -> L16
        r100.unlock();
        return true;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "surface texture no draw" + e.toString());     // Catch: Throwable -> L14
        r100.unlock();
        return false;
    L14:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    private boolean updateTexImage(VideoSurfaceTexture r100) {
        r100.lock();     // Catch: Throwable -> L12 Exception -> L14
        if (r100.isRelease() == false) goto L6;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "surface texture is released not draw");     // Catch: Throwable -> L12 Exception -> L14
    L6:
        r100.updateTexImage();     // Catch: Throwable -> L12 Exception -> L14
        r100.unlock();
        if (r100.needDrop() == false) goto L10;
        return false;
    L10:
        return true;
    L12:
        th = move-exception;
        r100.unlock();
        throw th;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
        r100.unlock();
        return false;
    }

    @Override // com.ss.texturerender.TextureRenderer
    public Object getOption(Bundle r100) {
        AbsEffect r101 = getEffect(r100.getInt("effect_type"));
        if (r101 == null) goto L7;
        return r101.getOption(r100);
    L7:
        if (r100.getInt("action") != 174) goto L14;
        GLDefaultFilter r102 = this.mCurrentDrawer;
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.getStringOption(11003);
    L14:
        return null;
    }

    @Override // com.ss.texturerender.TextureRenderer
    public void handleFrameAvailable(Message r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        VideoSurfaceTexture r100 = (VideoSurfaceTexture) r110.obj;
        if (r100 != this.mTileVideoSurfaceTexture) goto L8;
        updateTexImage(r100);
        return;
    L8:
        if (r100 != null) goto L10;
    L12:
        this.mCheckDispatcher.onSurfaceTextureCallbackCalled(r100);
        this.mCheckDispatcher.onFrameCome(r100);
        boolean r101 = draw(r100, r110.arg1);
        frameBufferCallback(r110);
        if (r101 == false) goto L15;
        saveImage(r110);
        r101 = r100.render();
    L15:
        if (r100 == null) goto L17;
        r100.getEventLogger().setPostRenderEnd(r101);
    L17:
        float r102 = SystemClock.elapsedRealtime();
        float r103 = r100.getFloatOption(123);
        int r104 = r100.getIntOption(121);
        float r105 = r100.getFloatOption(122);
        if (r101 == false) goto L21;
        r104 = r104 + 1;
    L21:
        if (r104 <= 1) goto L23;
        r105 = r105 + (r102 - r103);
    L23:
        r100.setOption(121, r104);
        r100.setOption(122, r105);
        r100.setOption(123, r102);
        if (r105 <= 0.0f) goto L27;
        if (r104 <= 0) goto L27;
        r100.setOption(120, ((r104 - 1) * 1000.0f) / r105);
    L27:
        if (r101 == false) goto L30;
        this.mCheckDispatcher.onDrawSucceed(r100);
    L30:
        if (r110.arg2 != 1) goto L38;
        monitor-enter(r100);
        r100.notify();     // Catch: Throwable -> L35
        monitor-exit(r100);     // Catch: Throwable -> L35
        return;
    L35:
        th = move-exception;
        throw th;
    L38:
        return;
    L10:
        if (this.mEGLRuntime == null) goto L12;
        r100.checkGeometry();
        goto L12
    }

    @Override // com.ss.texturerender.TextureRenderer
    public void handleGLThreadMessage(Message r100) {
        int r101 = r100.what;
        if (r101 != 12) goto L5;
    L52:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "setEffect bundle:" + r100.getData() + " surfacetexture:" + r100.obj);
        setEffect(r100.getData(), (VideoSurfaceTexture) r100.obj);
        return;
    L5:
        if (r101 != 25) goto L7;
        Bundle r102 = r100.getData();
        Surface r103 = (Surface) r102.getParcelable("surface");
        VideoSurfaceTexture r104 = (VideoSurfaceTexture) r102.getSerializable(VideoSurfaceTexture.KEY_TEXTURE);
        int r105 = r100.arg1;
        if (r105 != 1) goto L44;
        r104.initExtraSurface(r103);
        return;
    L44:
        if (r105 != 2) goto L47;
        r104.releaseExtraSurface(r103);
        return;
    L47:
        if (r105 != 3) goto L50;
        r104.releaseAllExtraSurface();
        return;
    L50:
        if (r105 != 4) goto L76;
        r104.updateAllExtraSurface();
        return;
    L76:
        return;
    L7:
        if (r101 == 26) goto L36;
        switch(r101) {
            case 34: goto L35;
            case 35: goto L32;
            case 36: goto L52;
            default: goto L9;
        };
    L9:
        switch(r101) {
            case 40: goto L31;
            case 41: goto L30;
            case 42: goto L29;
            case 43: goto L17;
            case 44: goto L12;
            case 45: goto L11;
            default: goto L78;
        };
    L11:
        ArrayList r106 = (ArrayList) r100.obj;
        initExtEffect((VideoSurfaceTexture) ListProtector.get(r106, 0), (AbsEffect) ListProtector.get(r106, 1));
        return;
    L12:
        Bundle r107 = r100.getData();
        if (r107 == null) goto L59;
        Surface r108 = (Surface) r107.getParcelable("surface");
        if (r108 == null) goto L60;
        VideoSurfaceTexture r109 = (VideoSurfaceTexture) r107.getSerializable(VideoSurfaceTexture.KEY_TEXTURE);
        r109.releaseExtraSurface(r108);
        r109.updateSurface(r108);
        return;
    L60:
        return;
    L59:
        return;
    L17:
        VideoSurfaceTexture r110 = (VideoSurfaceTexture) r100.obj;
        EGLRuntime r111 = this.mEGLRuntime;
        if (r111 != null) goto L20;
        return;
    L20:
        if (r111.eglContext != EGL14.EGL_NO_CONTEXT) goto L22;
        return;
    L22:
        if (r111.eglDisplay == EGL14.EGL_NO_DISPLAY) goto L64;
        if (r110 == null) goto L65;
        r110.releaseTexImage();     // Catch: Exception -> L26 Throwable -> L54
        goto L81
    L79:
        return;
    L26:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "releseTexImage" + e.toString());     // Catch: Throwable -> L54
        return;
    L81:
        return;
    L65:
        return;
    L64:
        return;
    L29:
        resetRotationMirrorParams();
        return;
    L30:
        this.mTopEffect.setOption(r100.arg1, r100.obj);
        return;
    L31:
        resetCropParams();
        return;
    L78:
        return;
    L32:
        Bundle r112 = r100.getData();
        if (r112 == null) goto L69;
        _setValueToElement(r100.arg1, r112.getFloat(TextureRenderKeys.KEY_IS_FLOAT_VALUE));
        return;
    L69:
        return;
    L35:
        _setValueToElement(r100.arg1, r100.arg2);
        return;
    L36:
        VideoSurfaceTexture r113 = (VideoSurfaceTexture) r100.obj;
        if (r113 == null) goto L39;
        r113.handleUpdateVideoState(r100.arg1);
    L39:
        this.mTopEffect.setOption(1, r100.arg1);
    }

    @Override // com.ss.texturerender.TextureRenderer
    public void handleSetSurface(Message r100) {
        Bundle r101 = r100.getData();
        if (r101 == null) goto L23;
        VideoSurfaceTexture r102 = (VideoSurfaceTexture) r101.getSerializable(VideoSurfaceTexture.KEY_TEXTURE);
        if (r102 == null) goto L21;
        if (r102.handleSurfaceChange(r100) == false) goto L9;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "texture switch surface & playing");
    L9:
        Object r103 = r100.obj;
        if (r103 == null) goto L18;
        monitor-enter(r103);
        r103.notify();     // Catch: Throwable -> L15
        monitor-exit(r103);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L18:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "set surface done");
        return;
    L21:
        throw new RuntimeException("update surface but missing texture");
    L23:
        throw new RuntimeException("update surface but missing bundle?");
    }

    public VideoTextureRenderer(EffectConfig r100, int r101) {
        super(r100, r101);
        this.mErrorList = new LinkedList();
        this.mExtScreenFilters = new HashMap();
        this.mSaveFrameBuffer = null;
        this.mFrameCallbackBufffer = null;
        this.mOutTexWidth = -1;
        this.mOutTexHeight = -1;
        this.mFinalTexId = -1;
        this.mTileVideoSurfaceTexture = null;
        this.mVqscoreWrapper = null;
        this.mTopEffect = new EmptyEffect(r101);
    }

    private void _setValueToElement(int r100, float r101) {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "_setValueToElement key:" + r100 + ", value:" + r101);
        this.mTopEffect.setOption(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    private boolean checkDirectRenderToScreen(AbsEffect r100, VideoSurfaceTexture r101) {
        ?? r102 = 0;
        if (r100 != 0) goto L5;
        return false;
    L5:
        HashMap<Surface, EGLSurface> r103 = r101.getExtraRealSurfaces();
        if (r103 != null) goto L8;
    L10:
        boolean r104 = true;
    L12:
        if (r101.mRotationType == 0) goto L14;
    L19:
        r104 = false;
    L21:
        if (r100.getNextEffect() == null) goto L24;
        r104 = false;
    L24:
        if (this.mAnimationFilter == null) goto L31;
        if (r101.getEffectConfig() == null) goto L31;
        if (r101.getEffectConfig().getEffectOpen(29) == false) goto L31;
        r104 = false;
    L31:
        if (this.mExtScreenFilters.get(r101) != null) goto L33;
    L37:
        r102 = r104;
    L38:
        r100.setOption(10015, r102);
        return r102;
    L33:
        if (r101.getEffectConfig() == null) goto L37;
        if (r101.getEffectConfig().getEffectOpen(100) == false) goto L37;
    L14:
        if (r101.mIsMirrorHorizontal != 0) goto L19;
        if (r101.mIsMirrorVertical != 0) goto L19;
        if (r101.getCropParamsBundle(false, null) == null) goto L21;
    L8:
        if (r103.isEmpty() == true) goto L10;
        r104 = false;
        goto L12
    }

    private void clearEffect(Bundle r100, VideoSurfaceTexture r101) {
        int r102 = r100.getInt("effect_type");
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "try clearEffect:" + r102);
        int r103 = -1;
        if (r102 == 29) goto L6;
    L39:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "clearEffect:" + r102 + " ret:" + r103);
        return;
    L6:
        if (this.mAnimationFilter != null) goto L8;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "no effect");
        goto L39
    L8:
        if (r101 != null) goto L10;
    L38:
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "invalid surface texture");
        goto L39
    L10:
        if (r101.getEffectConfig() == null) goto L38;
        if (r101.getEffectConfig().getEffectOpen(29) == true) goto L16;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "effect unused");
        goto L39
    L16:
        if (r101.getLastComeFrameType() != 1) goto L18;
    L31:
        r101.getEffectConfig().setEffectOpen(29, 0);
        if (draw(r101, 1) == true) goto L34;
    L36:
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "force draw failed");
    L37:
        r101.getEffectConfig().setEffectOpen(29, 1);
        goto L39
    L34:
        if (r101.render() == false) goto L36;
        r103 = 0;
        goto L37
    L18:
        if (r101.getLastComeFrameType() == 4) goto L31;
        if (this.mStoredEffectTexture != null) goto L24;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "no stored effect texture");
        goto L39
    L24:
        if (this.mTex2dDrawer != null) goto L26;
        setup2DGraphics();
    L26:
        this.mTex2dDrawer.setSurfaceTexture(r101);
        this.mTex2dDrawer.setOption(26, r101.mLayoutMode);
        this.mTex2dDrawer.setOption(27, r101.mLayoutRatio);
        if (r101.getIntOption(146) != 1) goto L29;
        this.mTex2dDrawer.setOption(30, r101.mIsMirrorHorizontal);
        this.mTex2dDrawer.setOption(31, r101.mIsMirrorVertical);
        this.mTex2dDrawer.setOption(29, r101.mRotationType);
    L30:
        this.mTex2dDrawer.setOption(10006, r101.getViewportWidth());
        this.mTex2dDrawer.setOption(10007, r101.getViewportHeight());
        this.mTex2dDrawer.process(this.mStoredEffectTexture, null);
        r103 = this.mTex2dDrawer.getIntOption(20005);
        r101.render();
        goto L39
    L29:
        this.mTex2dDrawer.setOption(29, r101.mRotationType);
        this.mTex2dDrawer.setOption(30, r101.mIsMirrorHorizontal);
        this.mTex2dDrawer.setOption(31, r101.mIsMirrorVertical);
        goto L30
    }

    private boolean draw(VideoSurfaceTexture r110, int r111) {
        boolean r100 = surfaceTextureUpdateImage(r110);
        if (r100 == true) goto L6;
        return r100;
    L6:
        if (this.mErrorList == null) goto L11;
    L8:
        if (this.mErrorList.isEmpty() == true) goto L11;
        r110.notifyError(this.mErrorList.poll().intValue(), 0, "");
    L11:
        if (r110.needDrop() == true) goto L187;
        if (r111 != 0) goto L15;
        return false;
    L15:
        if (r110.isMakeCurrent() == false) goto L17;
    L30:
        CopyOnWriteArrayList<Bundle> r101 = r110.getParamList();
        if (r101 == null) goto L36;
        Iterator<Bundle> r102 = r101.iterator();
    L34:
        if (r102.hasNext() == false) goto L36;
        setEffect(r102.next(), r110);
    L36:
        boolean r103 = hasEffectOpen(r110);
        r110.effectChainBegin();
        EffectTexture r104 = r110.getEffectTexture();
        if (r104 != null) goto L41;
        TextureRenderLog.d(-1, this.LOG_TAG, "surfaceTexture.getEffectTexture() null");
        return false;
    L41:
        if (r104.getWidth() != 0) goto L43;
    L44:
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "invalid effectTexture, draw to surface directly");
        r103 = false;
    L46:
        if (r104.getSourceType() != 2) goto L54;
        if (this.mHardwareBuffer2GLFilter != null) goto L52;
        EGLRuntime r105 = this.mEGLRuntime;
        if (r105 == null) goto L52;
        this.mHardwareBuffer2GLFilter = new HardwareBuffer2GLFilter(this.mTexType, r105.eglDisplay);
    L52:
        r104 = this.mHardwareBuffer2GLFilter.process(r104, null);
    L65:
        if (this.mVqscoreWrapper != null) goto L67;
    L76:
        VideoSurface.VQScoreCallback r106 = null;
        boolean r107 = false;
    L77:
        EffectConfig r112 = r110.getEffectConfig();
        AbsEffect r108 = this.mMultiRenderTargetFilter;
        if (r108 != null) goto L80;
    L89:
        EffectTexture r113 = null;
    L91:
        if (this.mTexType != 0) goto L98;
        if (this.mTexOesDrawer == null) goto L98;
        if (r112.getEffectOpen(11) == true) goto L98;
        this.mTexOesDrawer.resetCropParams();
    L104:
        if (r103 == false) goto L106;
        r104 = processEffectTexture(r110, r104);
    L107:
        if (r104 != null) goto L111;
        r110.effectChainEnd();
        return true;
    L111:
        if (r104.getDrType() != (-1)) goto L113;
    L116:
        if (r103 == false) goto L122;
        if (r107 == false) goto L122;
        BMFVQScoreWrapper r109 = this.mVqscoreWrapper;
        if (r109 == null) goto L122;
        r109.processVqscore(r104, r106, true);
    L122:
        if (this.mPureColorDetector != null) goto L124;
    L136:
        EffectTexture r114 = r104;
        Iterator<Map.Entry<Surface, EGLSurface>> r115 = r110.getExtraRealSurfaces().entrySet().iterator();
        boolean r116 = false;
    L138:
        if (r115.hasNext() == false) goto L149;
        Map.Entry<Surface, EGLSurface> r117 = r115.next();
        EGLSurface r118 = r117.getValue();
        r110.makeCurrent(r118);
        Surface r119 = r117.getKey();
        if (r113 != null) goto L142;
        EffectTexture r120 = r114;
    L144:
        if (drawToSurface(r120, r110, r110.getConsumerHeight(r118), r110.getConsumerWidth(r118), true, r119) != 0) goto L148;
        if (r110.getIntOption(141) != 1) goto L148;
        r110.notifyExtraSurfaceRender(r119);
    L148:
        r116 = true;
        goto L138
    L142:
        r120 = r113;
        goto L144
    L149:
        if (r113 == null) goto L152;
        r113.giveBack();
    L152:
        if (r110.getIntOption(202) == 1) goto L154;
    L155:
        if (r116 == false) goto L157;
    L156:
        boolean r121 = true;
    L159:
        if (switchContextToMainSurface(r110, Boolean.valueOf(r121)) == true) goto L161;
        return false;
    L161:
        this.mOutTexWidth = r114.getWidth();
        this.mOutTexHeight = r114.getHeight();
        if (r110.getFrameCallbackBundle() != null) goto L164;
    L172:
        EffectTexture r122 = r114;
    L174:
        if (r112.getEffectOpen(18) == true) goto L176;
        r110.getEventLogger().setPostRenderBegin();
        int r123 = drawToSurface(r122, r110, r110.getViewportHeight(), r110.getViewportWidth(), false, null);
    L177:
        r110.effectChainEnd();
        if (r123 != 0) goto L188;
        return true;
    L188:
        return false;
    L176:
        r123 = 0;
        goto L177
    L164:
        if (r114.getTexTarget() == 3553) goto L172;
        if (this.mFrameBuffer != null) goto L168;
        initFbo();
    L168:
        this.mTexOesDrawer.setSurfaceTexture(r110);
        this.mTexOesDrawer.setOption(10006, r110.getViewportWidth());
        this.mTexOesDrawer.setOption(10007, r110.getViewportHeight());
        EffectTexture r124 = this.mTexOesDrawer.process(r114, this.mFrameBuffer);
        if (this.mTex2dDrawer != null) goto L171;
        setup2DGraphics();
    L171:
        this.mFinalTexId = r124.getTexID();
        r122 = r124;
        goto L174
    L157:
        r121 = false;
        goto L159
    L154:
        if (r110.getIntOption(201) == 1) goto L156;
    L124:
        if (r104.getTexTarget() == 36197) goto L126;
    L135:
        this.mPureColorDetector.setSurfaceTexture(r110);
        this.mPureColorDetector.process(r104);
        goto L136
    L126:
        if (this.mTex2dDrawer != null) goto L129;
        setup2DGraphics();
    L129:
        if (this.mFrameBuffer != null) goto L131;
        initFbo();
    L131:
        this.mTexOesDrawer.setSurfaceTexture(r110);
        if (this.mTexType != 1) goto L134;
        this.mTexOesDrawer.resetCropParams();
    L134:
        r104 = this.mTexOesDrawer.process(r104, this.mFrameBuffer);
        goto L135
    L113:
        if (r104.getDrType() == r110.getIntOption(8, -1)) goto L116;
        r110.effectChainEnd();
        return true;
    L106:
        r110.setOption(6, 0);
        r110.resetFlag();
    L98:
        if (this.mTexType != 0) goto L104;
        if (this.mTexOesDrawer == null) goto L104;
        if (r112.getEffectOpen(11) == false) goto L104;
        this.mTexOesDrawer.setOption(r110.getCropParamsBundle(false, null));
        goto L104
    L80:
        if (r112.getEffectOpen(r108.getIntOption(10005)) == false) goto L89;
        if (r104.getTexTarget() == 36197) goto L84;
    L86:
        EffectTexture[] r125 = this.mMultiRenderTargetFilter.processWithMRT(r104, this.mFrameBuffer);
        if (r125 == null) goto L89;
        r104 = r125[0];
        r113 = r125[1];
        goto L91
    L84:
        if (this.mMultiRenderTargetFilter.getIntOption(10004) != 3553) goto L86;
        this.mTexOesDrawer.setSurfaceTexture(r110);
        r104 = this.mTexOesDrawer.process(r104, this.mFrameBuffer);
        goto L86
    L67:
        if (r110.getIntOption(152) != 1) goto L76;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "enter open vqscore");
        this.mVqscoreWrapper.setSurfaceTexture(r110);
        Bundle r126 = r110.getOption(153);
        if (r126 == null) goto L73;
        r106 = (VideoSurface.VQScoreCallback) r126.getSerializable(TextureRenderKeys.KEY_IS_BMF_VQSCORE_CALLBACK);
        if (r106 == null) goto L74;
        this.mVqscoreWrapper.processVqscore(r104, r106, false);
        r107 = true;
    L75:
        r110.setOption(152, 0);
    L74:
        r107 = false;
        goto L75
    L73:
        r106 = null;
        goto L74
    L54:
        if (r104.getSourceType() != 3) goto L65;
        if (Build.VERSION.SDK_INT < 29) goto L65;
        if (this.mHardwareBufferEGLPoolFilter != null) goto L60;
        this.mHardwareBufferEGLPoolFilter = new HardwareBufferEglPoolFilter(this.mTexType);
    L60:
        this.mHardwareBufferEGLPoolFilter.setSurfaceTexture(r110);
        r104 = this.mHardwareBufferEGLPoolFilter.process(r104, null);
        if (r104.getTexID() > 0) goto L65;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "HardwareBuffer process failed");
        return false;
    L43:
        if (r104.getHeight() != 0) goto L46;
    L17:
        if (r110.getRenderSurface() != null) goto L25;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "texture : " + r110 + " not set surface");
        if (r110.getEnableUseEglDummySurface() == 1) goto L21;
    L23:
        return false;
    L21:
        if (this.mEGLRuntime == null) goto L23;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "create dummy surface");
        r110.createEGLWindowSurface(true);
        goto L30
    L25:
        if (this.mHandler.hasMessages(4) == true) goto L30;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "texture : " + r110 + ", retry create");
        if (r110.createEGLWindowSurface(false) == true) goto L30;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "texture : " + r110 + ", retry failed");
        return false;
    L187:
        return false;
    }

    public static synchronized VideoTextureRenderer getRenderer(EGLContext r100, EGLConfig r101) {
        monitor-enter(VideoTextureRenderer.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (mRenderInstance != null) goto L7;
        mRenderInstance = new VideoTextureRenderer(new EffectConfig(0), 0, r100, r101);     // Catch: Throwable -> L18
    L7:
        VideoTextureRenderer r102 = mRenderInstance;     // Catch: Throwable -> L18
        if (r102 != null) goto L11;
    L15:
        VideoTextureRenderer r103 = mRenderInstance;     // Catch: Throwable -> L18
        monitor-exit(VideoTextureRenderer.class);
        return r103;
    L11:
        if (r102.mState != (-1)) goto L15;
        monitor-exit(VideoTextureRenderer.class);
        return null;
    }

    private int initEffect(Bundle r110, VideoSurfaceTexture r111) {
        int r100 = r110.getInt("effect_type");
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "initeffect:" + r100);
        int r101 = 36197;
        int r102 = 3;
        AbsEffect r103 = null;
        if (r100 == 1) goto L88;
        if (r100 == 5) goto L88;
        int r112 = 0;
        if (r100 == 11) goto L80;
        if (r100 == 16) goto L71;
        switch(r100) {
            case 28: goto L49;
            case 29: goto L37;
            case 30: goto L25;
            default: goto L11;
        };
    L11:
        AbsEffect r104 = getEffect(r100);
        if (r104 != null) goto L14;
        r104 = EffectFactory.createEffect(this.mTexType, r100);
    L14:
        r103 = r104;
        if (r103 != null) goto L18;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "create effect fail" + r100);
        return -1;
    L18:
        r103.setSurfaceTexture(r111);
        r103.setParentRender(this);
        if (checkUseOesFormat(r103) == true) goto L22;
        r101 = 3553;
    L22:
        r110.putInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE, r101);
        int r105 = r103.init(r110);
        if (r100 != 22) goto L111;
        this.mMultiRenderTargetFilter = r103;
    L111:
        if (r103 == null) goto L128;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "initeffect successful:" + r100);
        this.mEffectConfig.setEffectOpen(r100, 1);
        if (this.mTex2dDrawer != null) goto L116;
        setup2DGraphics();
    L116:
        if (r110.containsKey(TextureRenderKeys.KEY_IS_EFFECT_ORDER) == false) goto L119;
        r103.setOption(10011, r110.getInt(TextureRenderKeys.KEY_IS_EFFECT_ORDER));
    L119:
        if (getEffect(r100) != null) goto L121;
        this.mTopEffect.insertEffect(r103);
    L121:
        if (r100 == 1) goto L124;
        if (r100 == 5) goto L124;
        initFbo();
    L124:
        if (r111 == null) goto L128;
        if (r110.containsKey(TextureRenderKeys.KEY_IS_USE_EFFECT) == false) goto L128;
        r111.setEffectOpen(r100, r110.getInt(TextureRenderKeys.KEY_IS_USE_EFFECT), r110);
    L128:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "initEffect chain:" + this.mTopEffect.toString());
        return r105;
    L25:
        AbsEffect r106 = this.mBrightnessBalanceFilter;
        if (r106 != null) goto L32;
        r106 = EffectFactory.createEffect(this.mTexType, r100);
        if (r106 != null) goto L31;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "create effect failed " + r100);
        return -1;
    L31:
        this.mBrightnessBalanceFilter = (GLBrightnessBalanceFilter) r106;
    L32:
        r106.setSurfaceTexture(r111);
        r106.setParentRender(this);
        int r107 = r106.init(r110);
        if (r107 == 0) goto L36;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "init effect failed " + r100);
        r106.release();
        this.mBrightnessBalanceFilter = null;
        return -1;
    L36:
        r103 = r106;
        r105 = r107;
        goto L111
    L37:
        AbsEffect r108 = this.mAnimationFilter;
        if (r108 != null) goto L44;
        r108 = EffectFactory.createEffect(this.mTexType, r100);
        if (r108 != null) goto L43;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "create effect failed " + r100);
        return -1;
    L43:
        this.mAnimationFilter = r108;
        r108.setSurfaceTexture(r111);
        r108.setParentRender(this);
        r112 = r108.init(r110);
    L45:
        if (r112 == 0) goto L48;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "init effect failed " + r100);
        r108.release();
        this.mBrightnessBalanceFilter = null;
        return -1;
    L48:
        r103 = r108;
        r105 = r112;
        goto L111
    L44:
        r108.setSurfaceTexture(r111);
        r108.setParentRender(this);
        r108.setOption(r110);
        goto L45
    L49:
        EGLRuntime r109 = this.mEGLRuntime;
        if (r109 == null) goto L52;
        int r113 = r109.getGLMajorVersion();
    L53:
        if (r113 >= 3) goto L56;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "unsupported " + r100 + " gl version = " + r113);
        return -1;
    L56:
        if (r111 != null) goto L59;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "invalid surface texture " + r100);
        return -1;
    L59:
        r106 = this.mAesBoostFilter;
        if (r106 != null) goto L66;
        r106 = EffectFactory.createEffect(this.mTexType, r100);
        if (r106 != null) goto L65;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "create effect failed " + r100);
        return -1;
    L65:
        this.mAesBoostFilter = r106;
    L66:
        r106.setSurfaceTexture(r111);
        r106.setParentRender(this);
        r107 = r106.init(r110);
        if (r107 == 0) goto L36;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "init effect failed " + r100);
        r106.release();
        this.mAesBoostFilter = null;
        return -1;
    L52:
        r113 = 2;
        goto L53
    L71:
        if (this.mVqscoreWrapper != null) goto L78;
        BMFVQScoreWrapper r114 = (BMFVQScoreWrapper) EffectFactory.createEffect(this.mTexType, r100);
        this.mVqscoreWrapper = r114;
        if (r114 == null) goto L78;
        EGLRuntime r115 = this.mEGLRuntime;
        if (r115 == null) goto L77;
        r114.setShareEGLShareConfig(r115.eglConfig);
        this.mVqscoreWrapper.setEGLShareContext(this.mEGLRuntime.eglContext);
    L77:
        this.mVqscoreWrapper.setSurfaceTexture(r111);
        this.mVqscoreWrapper.setParentRender(this);
        this.mVqscoreWrapper.downloadModel(r110);
    L78:
        return 0;
    L80:
        if (this.mTex2dDrawer == null) goto L87;
        this.mTexOesDrawer.setOption(r110);
        initFbo();
        checkUseOesFormat(this.mTexOesDrawer);
        this.mEffectConfig.setEffectOpen(r100, 1);
        if (r111 != null) goto L84;
    L86:
        return 0;
    L84:
        if (r110.containsKey(TextureRenderKeys.KEY_IS_USE_EFFECT) == false) goto L86;
        r111.setEffectOpen(r100, r110.getInt(TextureRenderKeys.KEY_IS_USE_EFFECT), r110);
        goto L86
    L87:
        return -1;
    L88:
        this.mBMFDrawer = null;
        AbsEffect r116 = getEffect(r100);
        if (r116 != null) goto L95;
        r116 = EffectFactory.createEffect(this.mTexType, r100);
        if (r116 != null) goto L95;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "create effect failed");
        return -1;
    L95:
        if (checkUseOesFormat(r116) == true) goto L97;
    L100:
        initFbo();
        r110.putInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE, 3553);
    L101:
        r116.setSurfaceTexture(r111);
        r116.setShareEGLShareConfig(this.mEGLRuntime.eglConfig);
        r116.setEGLShareContext(this.mEGLRuntime.eglContext);
        r105 = r116.init(r110);
        if (r105 >= 0) goto L108;
        r116.release();
        Queue<Integer> r117 = this.mErrorList;
        if (r100 != 5) goto L106;
        r102 = 1;
    L106:
        r117.offer(Integer.valueOf(r102));
        goto L111
    L108:
        if (r110.getBoolean(TextureRenderKeys.KEY_IS_ENABLE_DIRECT_DRAW) == false) goto L110;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "setup bmf drawer, effect type: " + r100);
        this.mBMFDrawer = r116;
    L110:
        r103 = r116;
        goto L111
    L97:
        if (DeviceManager.isVRDevice() == true) goto L100;
        r110.putInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE, 36197);
        goto L101
    }

    private int initExtEffect(VideoSurfaceTexture r100, AbsEffect r101) {
        int r102 = r101.getIntOption(10005);
        if (r102 == 100) goto L6;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "unsupported ext effect:" + r102);
        return -1;
    L6:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init ext effect:" + r102);
        r101.setSurfaceTexture(r100);
        r101.setParentRender(this);
        Bundle r103 = new Bundle();
        if (checkUseOesFormat(r101) == false) goto L9;
        int r104 = 36197;
    L10:
        r103.putInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE, r104);
        int r105 = r101.init(r103);
        if (r105 == 0) goto L14;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "create ext effect:" + r102 + " failed:" + r105);
        return -1;
    L14:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, r100 + " add ext screen filter:" + r101);
        this.mExtScreenFilters.put(r100, r101);
        if (r100 == null) goto L17;
        r100.setEffectOpen(r102, 1, null);
    L17:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init ext effect success:" + r102);
        return 0;
    L9:
        r104 = 3553;
        goto L10
    }

    private EffectTexture processEffectTexture(VideoSurfaceTexture r110, EffectTexture r111) {
        r110.getEventLogger().setTotalEffectRenderBegin();
        r110.effectChainBegin();
        EffectConfig r100 = r110.getEffectConfig();
        AbsEffect r101 = this.mTopEffect.getNextEffect();
        AbsEffect r102 = null;
        EffectTexture r103 = r111;
    L3:
        boolean r104 = false;
        if (r101 == null) goto L83;
        if (r103 == null) goto L83;
        int r112 = r101.getIntOption(10005);
        if (r100.getEffectOpen(r112) == false) goto L79;
        if (r103.getTexTarget() != 36197) goto L30;
        if (r101.getIntOption(10004) != 3553) goto L30;
        if (r100.getEffectOpen(18) == true) goto L30;
        if (this.mTexType != 1) goto L17;
        this.mTexOesDrawer.resetCropParams();
    L17:
        this.mTexOesDrawer.setSurfaceTexture(r110);
        if (DeviceManager.isVRDevice() == false) goto L21;
        EffectTexture.FilterType r105 = EffectTexture.FilterType.NEAREST;
        r111.switchFilterType(r105, r105);
    L21:
        if (this.mFrameBuffer != null) goto L24;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init fbo before oesTo2d process");
        initFbo();
    L24:
        if (r103.getRect() == null) goto L26;
        this.mTexOesDrawer.setOption(10017, 1);
    L26:
        r103 = this.mTexOesDrawer.process(r103, this.mFrameBuffer);
        this.mTexOesDrawer.setOption(10017, 0);
        if (DeviceManager.isVRDevice() == false) goto L30;
        EffectTexture.FilterType r106 = EffectTexture.FilterType.LINEAR;
        r111.switchFilterType(r106, r106);
    L30:
        if (r110.getLastComeFrameType() == 4) goto L32;
    L43:
        r101.setSurfaceTexture(r110);
        if (r103.getRect() != null) goto L46;
        r101.setOption(10017, 0);
    L67:
        if (r101.getIntOption(10005) != 18) goto L70;
        r101.setOption(10006, r110.getViewportWidth());
        r101.setOption(10007, r110.getViewportHeight());
    L70:
        if (r110.getExtraVideoSurfaceTexture() == null) goto L73;
        VideoSurfaceTexture r107 = r110.getExtraVideoSurfaceTexture();
        r103.setExtraEffectTexture(new EffectTexture[]{new EffectTexture(null, r107.getTexId().lock(), r107.getTexWidth(), r107.getTexHeight(), 36197, null)});
        r107.getTexId().unlock();
    L73:
        if (DeviceManager.isVRDevice() == true) goto L75;
        r104 = checkDirectRenderToScreen(r101, r110);
    L75:
        if (r104 == false) goto L77;
        switchContextToMainSurface(r110, Boolean.FALSE);
    L77:
        r103 = r101.process(r103, this.mFrameBuffer);
        r102 = r101;
    L82:
        r101 = r101.getNextEffect();
        goto L3
    L46:
        if (r101.getIntOption(10016) != 1) goto L49;
        r101.setOption(10017, 1);
        goto L67
    L49:
        if (r103.getTexTarget() != 36197) goto L50;
        if (this.mFrameBuffer != null) goto L55;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init fbo before clip process, filter:" + r112);
        initFbo();
    L55:
        this.mTexOesDrawer.setSurfaceTexture(r110);
        this.mTexOesDrawer.setOption(10017, 1);
        r103 = this.mTexOesDrawer.process(r103, this.mFrameBuffer);
        this.mTexOesDrawer.setOption(10017, 0);
        if (r101.getIntOption(10004) != 36197) goto L67;
        if (reInitIfNeed(r112, 3553) == 0) goto L67;
        if (r112 != 5) goto L62;
        this.mErrorList.offer(1);
        goto L67
    L62:
        if (r112 != 1) goto L64;
        this.mErrorList.offer(3);
        goto L67
    L64:
        this.mErrorList.offer(6);
        goto L67
    L50:
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "unable to process clip before effect process");
        return r103;
    L32:
        if (r103.getTexTarget() != 3553) goto L43;
        if (r101.getIntOption(10004) != 36197) goto L43;
        if (reInitIfNeed(r112, 3553) == 0) goto L43;
        if (r112 != 5) goto L40;
        this.mErrorList.offer(1);
        goto L43
    L40:
        if (r112 != 1) goto L42;
        this.mErrorList.offer(3);
        goto L43
    L42:
        this.mErrorList.offer(6);
        goto L43
    L79:
        if (r112 != 5) goto L81;
        r110.setOption(6, 0);
    L81:
        r110.setOption(19, r112, 0);
    L83:
        TextureRenderEventLogger r108 = r110.getEventLogger();
        if (r102 == null) goto L86;
        r104 = true;
    L86:
        r108.setTotalEffectRenderEnd(r104);
        r110.effectChainEnd();
        return r103;
    }

    private int reInitIfNeed(int r100, int r101) {
        AbsEffect r102 = getEffect(r100);
        if (r102 != null) goto L5;
        return 0;
    L5:
        if (r102.getIntOption(10004) == r101) goto L15;
        Bundle r103 = r102.getInitBundle();
        if (r103 == null) goto L9;
        r103.putInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE, r101);
        r103.putInt(TextureRenderKeys.KEY_IS_REINIT_EFFECT_FOR_TEXTARGET_CHANGED, 1);
    L9:
        int r104 = r102.init(r103);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "reInit, effectType:" + r100 + ",texTarget:" + TexGLUtils.texTargetToString(r101));
        if (r104 == 0) goto L16;
        r102.release();
        return r104;
    L16:
        return 0;
    L15:
        return 0;
    }

    private void releaseEffect(Bundle r100, VideoSurfaceTexture r101) {
        if (r100 != null) goto L5;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "releaseEffect bundle null");
        return;
    L5:
        int r102 = r100.getInt("effect_type");
        if (r102 != 32) goto L13;
        if (r101 == null) goto L11;
        AbsEffect r103 = this.mTopEffect.getNextEffect();
    L9:
        if (r103 == null) goto L11;
        r101.setOption(19, r103.getIntOption(10005), 0);
        r103 = r103.getNextEffect();
    L11:
        deinitEffectComponents();
    L47:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "releaseEffect type:" + r102 + " chain:" + this.mTopEffect);
        return;
    L13:
        if (r102 != 28) goto L21;
        AbsEffect r104 = this.mAesBoostFilter;
        if (r104 == null) goto L17;
        r104.release();
        this.mAesBoostFilter = null;
    L17:
        GLLut3DFilter r105 = this.mLut3DFilter;
        if (r105 == null) goto L44;
        r105.release();
        this.mLut3DFilter = null;
    L44:
        this.mEffectConfig.setEffectOpen(r102, 0);
        if (r101 == null) goto L47;
        r101.setOption(19, r102, 0);
        goto L47
    L21:
        if (r102 != 29) goto L31;
        AbsEffect r106 = this.mAnimationFilter;
        if (r106 == null) goto L44;
        r106.release();
        this.mAnimationFilter = null;
        FrameBuffer r107 = this.mStoredFrameBuffer;
        if (r107 == null) goto L27;
        r107.release();
        this.mStoredFrameBuffer = null;
    L27:
        EffectTexture r108 = this.mStoredEffectTexture;
        if (r108 == null) goto L44;
        r108.giveBack();
        this.mStoredEffectTexture = null;
        goto L44
    L31:
        if (r102 != 30) goto L36;
        GLBrightnessBalanceFilter r109 = this.mBrightnessBalanceFilter;
        if (r109 == null) goto L44;
        r109.release();
        this.mBrightnessBalanceFilter = null;
        goto L44
    L36:
        if (r102 != 100) goto L41;
        AbsEffect r110 = this.mExtScreenFilters.get(r101);
        if (r110 == null) goto L40;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, r101 + " remove ext screen filter:" + r110);
        r110.release();
    L40:
        this.mExtScreenFilters.remove(r101);
        goto L44
    L41:
        AbsEffect r111 = getEffect(r102);
        if (r111 == null) goto L44;
        r111.release();
        goto L44
    }

    private void setEffect(Bundle r100, VideoSurfaceTexture r101) {
        if (r100 != null) goto L5;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "set effect but missing bundle?");
        return;
    L5:
        int r102 = r100.getInt("action");
        if (r102 != 21) goto L8;
        initEffect(r100, r101);
        return;
    L8:
        if (r102 != 32) goto L10;
        releaseEffect(r100, r101);
        return;
    L10:
        if (r102 == 151) goto L24;
        if (r102 == 177) goto L20;
        if (r102 == 191) goto L18;
        AbsEffect r103 = getEffect(r100.getInt("effect_type"));
        if (r103 == null) goto L29;
        r103.setOption(r100);
        return;
    L29:
        return;
    L18:
        clearEffect(r100, r101);
        return;
    L20:
        if (this.mPureColorDetector != null) goto L22;
        this.mPureColorDetector = new PureColorDetector(this.mTexType);
    L22:
        this.mPureColorDetector.setParentRender(this);
        this.mPureColorDetector.init(r100);
        return;
    L24:
        if (this.mVqscoreWrapper == null) goto L33;
        this.mVqscoreWrapper.init(r100);
        return;
    }

    private boolean switchContextToMainSurface(VideoSurfaceTexture r100, Boolean r101) {
        if (r100.isCurrentObject() == true) goto L10;
        if (r100.isMakeCurrent() == false) goto L7;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "not active texture but already make current : " + r100);
        r100.makeCurrent();
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "texture switch surface & playing ");
        return true;
    L7:
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "tex: " + r100 + " not current object id " + r100.getOjbectId());
        r100.effectChainEnd();
        return false;
    L10:
        if (r101.booleanValue() == false) goto L15;
        r100.makeCurrent();
        return true;
    L15:
        return true;
    }

    private void _setValueToElement(int r100, int r101) {
        this.mTopEffect.setOption(r100, r101);
    }

    public VideoTextureRenderer(EffectConfig r100, int r101, EGLContext r102, EGLConfig r110) {
        super(r100, r101, r102, r110, false);
        this.mErrorList = new LinkedList();
        this.mExtScreenFilters = new HashMap();
        this.mSaveFrameBuffer = null;
        this.mFrameCallbackBufffer = null;
        this.mOutTexWidth = -1;
        this.mOutTexHeight = -1;
        this.mFinalTexId = -1;
        this.mTileVideoSurfaceTexture = null;
        this.mVqscoreWrapper = null;
        if (r100.isOpenTile() == false) goto L5;
        initTileVideoSurfaceTexture();
    L5:
        this.mTopEffect = new EmptyEffect(r101);
    }

    public VideoTextureRenderer(EffectConfig r100, int r101, EGLContext r102, EGLConfig r103, boolean r104) {
        super(r100, r101, r102, r103, r104);
        this.mErrorList = new LinkedList();
        this.mExtScreenFilters = new HashMap();
        this.mSaveFrameBuffer = null;
        this.mFrameCallbackBufffer = null;
        this.mOutTexWidth = -1;
        this.mOutTexHeight = -1;
        this.mFinalTexId = -1;
        this.mTileVideoSurfaceTexture = null;
        this.mVqscoreWrapper = null;
        if (r100.isOpenTile() == false) goto L5;
        initTileVideoSurfaceTexture();
    L5:
        this.mTopEffect = new EmptyEffect(r101);
    }

    private int drawToSurface(EffectTexture r110, VideoSurfaceTexture r111, int r112, int r210, boolean r211, Surface r212) {
        AbsEffect r100 = this.mBMFDrawer;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L9:
        EffectTexture r102 = r110;
    L11:
        if (r102.getRect() == null) goto L23;
        if (r102.getTexTarget() == 36197) goto L17;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "unable to process clip before draw to surface");
        return -1;
    L17:
        if (this.mFrameBuffer != null) goto L19;
        initFbo();
    L19:
        this.mTexOesDrawer.setSurfaceTexture(r111);
        this.mTexOesDrawer.setOption(10017, 1);
        r102 = this.mTexOesDrawer.process(r102, this.mFrameBuffer);
        this.mTexOesDrawer.setOption(10017, 0);
        if (this.mTex2dDrawer != null) goto L23;
        setup2DGraphics();
    L23:
        if (r111.getIntOption(176) <= 0) goto L40;
        EGLRuntime r103 = this.mEGLRuntime;
        if (r103 == null) goto L40;
        if (r103.getGLMajorVersion() < 3) goto L40;
        if (r111.getLastComeFrameType() != 3) goto L35;
        if (r111.getLastComeFrameType() != 3) goto L40;
        if (r111.getIntOption(182) <= 0) goto L40;
    L35:
        if (r102.getTexTarget() != 3553) goto L40;
        if (r102.getTexTarget() != 3553) goto L39;
        GLDefaultFilter r104 = this.mBlitFilter;
    L41:
        EffectConfig r113 = r111.getEffectConfig();
        if (r104 == null) goto L53;
        if (r111.mRotationType != 0) goto L53;
        if (r111.mIsMirrorHorizontal != 0) goto L53;
        if (r111.mIsMirrorVertical != 0) goto L53;
        if (r113 == null) goto L60;
        if (r113.getEffectOpen(11) == true) goto L53;
    L60:
        if (r102.getWidth() == 0) goto L92;
        if (r102.getHeight() == 0) goto L92;
        if (this.mAesBoostFilter == null) goto L92;
        if (r113 == null) goto L92;
        if (r113.getEffectOpen(28) == false) goto L92;
        if (r113.getEffectOpen(2) == true) goto L92;
        this.mAesBoostFilter.setSurfaceTexture(r111);
        EffectTexture r105 = this.mAesBoostFilter.process(r102, null);
        if (r105.getUsage() != EffectTexture.TextureUsage.LUT_3D) goto L92;
        if (this.mLut3DFilter != null) goto L79;
        GLLut3DFilter r114 = new GLLut3DFilter(this.mTexType);
        r114.setSurfaceTexture(r111);
        if (r114.init(null) == 0) goto L77;
        r114.release();
        r114 = null;
    L77:
        this.mLut3DFilter = r114;
    L79:
        if (this.mLut3DFilter != null) goto L81;
        r113.setEffectOpen(28, 0);
        goto L92
    L81:
        if (r102.getTexTarget() == 36197) goto L83;
    L89:
        this.mLut3DFilter.setSurfaceTexture(r111);
        this.mLut3DFilter.setLutTexture(r105.getTexID());
        this.mLut3DFilter.setOption(20, r105.getAlpha());
        r104 = this.mLut3DFilter;
        r101 = true;
        goto L92
    L83:
        if (this.mFrameBuffer != null) goto L86;
        initFbo();
    L86:
        if (this.mTexType != 1) goto L88;
        this.mTexOesDrawer.resetCropParams();
    L88:
        this.mTexOesDrawer.setSurfaceTexture(r111);
        r102 = this.mTexOesDrawer.process(r102, this.mFrameBuffer);
    L92:
        if (this.mBrightnessBalanceFilter == null) goto L101;
        if (r113 == null) goto L101;
        if (r113.getEffectOpen(30) == false) goto L101;
        if (r113.getEffectOpen(28) == true) goto L101;
        if (r113.getEffectOpen(2) == true) goto L101;
        r104 = this.mBrightnessBalanceFilter;
        r101 = true;
    L101:
        this.mCurrentDrawer = r104;
        if (r104 != null) goto L104;
        return -1;
    L104:
        if (r211 == true) goto L117;
        if (this.mExtScreenFilters.get(r111) == null) goto L117;
        if (r113 == null) goto L117;
        if (r113.getEffectOpen(100) == false) goto L117;
        AbsEffect r106 = this.mExtScreenFilters.get(r111);
        if (r106 == null) goto L117;
        if (this.mFrameBuffer != null) goto L115;
        initFbo();
    L115:
        r106.setSurfaceTexture(r111);
        r102 = r106.process(r102, this.mFrameBuffer);
    L117:
        if (r211 == false) goto L119;
    L142:
        r104.setSurfaceTexture(r111);
        r104.setOption(26, r111.mLayoutMode);
        r104.setOption(27, r111.mLayoutRatio);
        if (r111.getIntOption(146) != 1) goto L145;
        r104.setOption(30, r111.mIsMirrorHorizontal);
        r104.setOption(31, r111.mIsMirrorVertical);
        r104.setOption(29, r111.mRotationType);
    L146:
        r104.setOption(10006, r210);
        r104.setOption(10007, r112);
        if (this.mTexType != 1) goto L155;
        Bundle r107 = r111.getCropParamsBundle(r211, r212);
        if (r107 == null) goto L151;
        r104.setOption(r107);
        goto L155
    L151:
        if (r211 == true) goto L155;
        if (r111.getIntOption(171) != 1) goto L155;
        r104.resetCropParams();
    L155:
        if (r211 == true) goto L157;
        r104.setOption(10018, 1);
    L157:
        r104.process(r102, null);
        return r104.getIntOption(20005);
    L145:
        r104.setOption(29, r111.mRotationType);
        r104.setOption(30, r111.mIsMirrorHorizontal);
        r104.setOption(31, r111.mIsMirrorVertical);
        goto L146
    L119:
        if (this.mAnimationFilter == null) goto L142;
        if (r113 == null) goto L142;
        if (r113.getEffectOpen(29) == false) goto L142;
        if (this.mFrameBuffer != null) goto L126;
        initFbo();
    L126:
        if (r101 == false) goto L129;
        r104.setSurfaceTexture(r111);
        r102 = r104.process(r102, this.mFrameBuffer);
    L132:
        if (r111.getLastComeFrameType() != 1) goto L134;
    L138:
        this.mAnimationFilter.setSurfaceTexture(r111);
        r102 = this.mAnimationFilter.process(r102, this.mFrameBuffer);
        if (this.mTex2dDrawer != null) goto L141;
        setup2DGraphics();
    L141:
        r104 = this.mTex2dDrawer;
        goto L142
    L134:
        if (r111.getLastComeFrameType() == 4) goto L138;
        int r108 = storeEffectTexture(r102);
        if (r108 == 0) goto L138;
        TextureRenderLog.w(this.mTexType, this.LOG_TAG, "store animation effect texture failed:" + r108);
        goto L138
    L129:
        if (r102.getTexTarget() != 36197) goto L132;
        this.mTexOesDrawer.setSurfaceTexture(r111);
        r102 = this.mTexOesDrawer.process(r102, this.mFrameBuffer);
    L53:
        if (r102.getTexTarget() == 3553) goto L55;
        r104 = this.mTexOesDrawer;
        goto L60
    L55:
        if (this.mTex2dDrawer != null) goto L57;
        setup2DGraphics();
    L57:
        r104 = this.mTex2dDrawer;
        goto L60
    L39:
        r104 = this.mBlitOESFliter;
    L40:
        r104 = null;
        goto L41
    L5:
        if (r100.getIntOption(11004) != 1) goto L9;
        r102 = drawWidthBmf(r110, r111, r112, r210, r211, r212);
        if (r102 != null) goto L11;
        return 0;
    }

    private EffectTexture drawWidthBmf(EffectTexture r100, VideoSurfaceTexture r101, int r102, int r103, boolean r104, Surface r105) {
        this.mBMFDrawer.setSurfaceTexture(r101);
        this.mBMFDrawer.setOption(26, r101.mLayoutMode);
        this.mBMFDrawer.setOption(27, r101.mLayoutRatio);
        int r106 = this.mBMFDrawer.effectType();
        if (r106 != 5) goto L6;
        return ((VideoOCLSREffect) this.mBMFDrawer).directDraw(r100);
    L6:
        if (r106 == 1) goto L8;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "DirectDraw invalid effect type: " + r106);
        return r100;
    L8:
        return ((AdaptiveSharpenEffect) this.mBMFDrawer).directDraw(r100);
    }
}
