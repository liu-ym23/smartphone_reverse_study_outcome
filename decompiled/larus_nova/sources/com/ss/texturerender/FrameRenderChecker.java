package com.ss.texturerender;

/* JADX INFO: loaded from: classes40.dex */
public class FrameRenderChecker {
    public static final int NO_RENDER_REASON_CALLBACK = 0;
    public static final int NO_RENDER_REASON_DRAW = 1;
    private static final int THRESHOLD_NO_RENDER_FRAME = 30;
    private static final int THRESHOLD_NO_RENDER_TIME = 1000;
    private final String TAG;
    private RenderCheckDispatcher checkDispatcher;
    private long continuousNoCallbackCount;
    private long continuousNoDrawCount;
    private volatile boolean failedCallback;
    private volatile boolean failedRender;
    private boolean isStarted;
    private long lastCallbackTime;
    private VideoSurface.OnNoRenderListener listener;
    private VideoSurfaceTexture videoSurfaceTexture;

    private void reset() {
        this.failedCallback = false;
        this.failedRender = false;
        this.continuousNoCallbackCount = 0;
        this.continuousNoDrawCount = 0;
    }

    public void checkSurfaceTextureCallbackTime() {
        if (this.isStarted == true) goto L6;
        return;
    L6:
        if (this.failedCallback == false) goto L9;
        return;
    L9:
        if ((System.currentTimeMillis() - this.lastCallbackTime) < 1000) goto L11;
        this.continuousNoCallbackCount++;
    L13:
        if (this.continuousNoCallbackCount < 2) goto L18;
        this.failedCallback = true;
        VideoSurface.OnNoRenderListener r100 = this.listener;
        if (r100 == null) goto L19;
        r100.onNoRenderStart(0);
        return;
    L19:
        return;
    L18:
        return;
    L11:
        this.continuousNoCallbackCount = 0;
        goto L13
    }

    public void onDrawSucceed() {
        this.continuousNoDrawCount = 0;
        if (this.failedRender == false) goto L10;
        this.failedRender = false;
        if (this.listener != null) goto L7;
        return;
    L7:
        if (this.failedCallback == true) goto L12;
        this.listener.onNoRenderEnd(1);
        return;
    L12:
        return;
    }

    public void onFrameCome() {
        this.continuousNoDrawCount++;
        if (this.failedRender == false) goto L5;
        return;
    L5:
        if (this.continuousNoDrawCount <= 30) goto L11;
        this.failedRender = true;
        VideoSurface.OnNoRenderListener r100 = this.listener;
        if (r100 == null) goto L12;
        r100.onNoRenderStart(1);
        return;
    L12:
        return;
    }

    public void onSurfaceTextureCallbackCalled() {
        if (this.isStarted == true) goto L5;
        return;
    L5:
        this.lastCallbackTime = System.currentTimeMillis();
        if (this.failedCallback == false) goto L13;
        this.failedCallback = false;
        this.continuousNoCallbackCount = 0;
        if (this.listener != null) goto L10;
        return;
    L10:
        if (this.failedRender == true) goto L15;
        this.listener.onNoRenderEnd(0);
        return;
    L15:
        return;
    }

    public void start() {
        VideoSurfaceTexture r100 = this.videoSurfaceTexture;
        if (r100 == null) goto L6;
        TextureRenderLog.i(r100.texType(), this.TAG, "start, isStarted: " + this.isStarted);
    L6:
        if (this.isStarted == false) goto L8;
        return;
    L8:
        this.isStarted = true;
        reset();
        RenderCheckDispatcher r101 = this.checkDispatcher;
        if (r101 == null) goto L12;
        r101.increase(this.videoSurfaceTexture, this);
        return;
    }

    public void stop() {
        VideoSurfaceTexture r100 = this.videoSurfaceTexture;
        if (r100 == null) goto L6;
        TextureRenderLog.i(r100.texType(), this.TAG, "stop, isStarted: " + this.isStarted);
    L6:
        if (this.isStarted == true) goto L8;
        return;
    L8:
        this.isStarted = false;
        reset();
        RenderCheckDispatcher r101 = this.checkDispatcher;
        if (r101 == null) goto L12;
        r101.decrease(this.videoSurfaceTexture, this);
        return;
    }

    public void setCheckDispatcher(RenderCheckDispatcher r100) {
        this.checkDispatcher = r100;
        if (this.isStarted == false) goto L7;
        if (r100 == null) goto L8;
        r100.increase(this.videoSurfaceTexture, this);
        return;
    L8:
        return;
    }

    public void setListener(VideoSurface.OnNoRenderListener r100) {
        this.listener = r100;
    }

    public FrameRenderChecker(RenderCheckDispatcher r100, VideoSurfaceTexture r101) {
        this.TAG = TextureRenderLog.getLogTag(this);
        this.checkDispatcher = r100;
        this.videoSurfaceTexture = r101;
    }
}
