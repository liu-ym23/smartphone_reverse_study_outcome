package com.bytedance.bmmt.video;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.bytedance.bmmt.base.Logging;
import com.bytedance.bmmt.base.ThreadUtils;
import com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes8.dex */
public class SurfaceViewRenderer extends SurfaceView implements SurfaceHolder.Callback, VideoSink, RendererCommon.RendererEvents {
    private static final String TAG = "SurfaceViewRenderer";
    private final SurfaceEglRenderer eglRenderer;
    private boolean enableFixedSize;
    private float radius;
    private RendererCommon.RendererEvents rendererEvents;
    private final String resourceName;
    private int rotatedFrameHeight;
    private int rotatedFrameWidth;
    private int surfaceHeight;
    private int surfaceWidth;
    private final RendererCommon.VideoLayoutMeasure videoLayoutMeasure;

    public static /* synthetic */ void a(SurfaceViewRenderer r100, int r101, int r102) {
        r100.lambda$onFrameResolutionChanged$0(r101, r102);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder r100) {
    }

    public void clearImage() {
        this.eglRenderer.clearImage();
    }

    public void disableFpsReduction() {
        this.eglRenderer.disableFpsReduction();
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.RendererEvents
    public void onFirstFrameRendered() {
        RendererCommon.RendererEvents r100 = this.rendererEvents;
        if (r100 == null) goto L6;
        r100.onFirstFrameRendered();
        return;
    }

    public void pauseVideo() {
        this.eglRenderer.pauseVideo();
    }

    public void release() {
        this.eglRenderer.release();
    }

    private String getResourceName() {
        return getResources().getResourceEntryName(getId());
    L4:
        return "";
    }

    private void updateSurfaceSize() {
        ThreadUtils.checkIsOnMainThread();
        if (this.enableFixedSize == true) goto L5;
    L21:
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        getHolder().setSizeFromLayout();
        return;
    L5:
        if (this.rotatedFrameWidth == 0) goto L21;
        if (this.rotatedFrameHeight == 0) goto L21;
        if (getWidth() == 0) goto L21;
        if (getHeight() == 0) goto L21;
        float r100 = getWidth() / getHeight();
        int r101 = this.rotatedFrameWidth;
        int r102 = this.rotatedFrameHeight;
        if ((r101 / r102) <= r100) goto L15;
        r101 = (int) (r102 * r100);
    L16:
        int r103 = Math.min(getWidth(), r101);
        int r104 = Math.min(getHeight(), r102);
        logD("updateSurfaceSize. Layout size: " + getWidth() + "x" + getHeight() + ", frame size: " + this.rotatedFrameWidth + "x" + this.rotatedFrameHeight + ", requested surface size: " + r103 + "x" + r104 + ", old surface size: " + this.surfaceWidth + "x" + this.surfaceHeight);
        if (r103 == this.surfaceWidth) goto L19;
    L20:
        this.surfaceWidth = r103;
        this.surfaceHeight = r104;
        getHolder().setFixedSize(r103, r104);
        return;
    L19:
        if (r104 != this.surfaceHeight) goto L20;
        return;
    L15:
        r102 = (int) (r101 / r100);
        goto L16
    }

    public SurfaceViewRenderer(Context r100) {
        super(r100);
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
        String r101 = getResourceName();
        this.resourceName = r101;
        SurfaceEglRenderer r102 = new SurfaceEglRenderer(r101);
        this.eglRenderer = r102;
        getHolder().addCallback(this);
        getHolder().addCallback(r102);
        this.radius = 0.0f;
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent)));
    }

    private void logD(String r100) {
        Logging.i(TAG, this.resourceName + ": " + r100);
    }

    private void postOrRun(Runnable r100) {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        r100.run();
        return;
    L5:
        post(r100);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void draw(Canvas r100) {
        if (this.radius <= 0.0f) goto L5;
        Path r101 = new Path();
        RectF r102 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float r103 = this.radius;
        r101.addRoundRect(r102, r103, r103, Path.Direction.CCW);
        r100.clipPath(r101, Region.Op.REPLACE);
    L5:
        super.draw(r100);
    }

    @Override // com.bytedance.bmmt.video.VideoSink
    public void onFrame(BmmtVideoFrameInterface r100) {
        this.eglRenderer.onFrame(r100);
    }

    public void removeFrameListener(EglRenderer.FrameListener r100) {
        this.eglRenderer.removeFrameListener(r100);
    }

    public void setEnableHardwareScaler(boolean r100) {
        ThreadUtils.checkIsOnMainThread();
        this.enableFixedSize = r100;
        updateSurfaceSize();
    }

    public void setFpsReduction(float r100) {
        this.eglRenderer.setFpsReduction(r100);
    }

    public void setMirror(boolean r100) {
        this.eglRenderer.setMirror(r100);
    }

    public void setRadius(float r100) {
        this.radius = Math.max(0.0f, r100);
    }

    public void setScalingType(RendererCommon.ScalingType r100) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(r100);
        requestLayout();
        this.eglRenderer.setRenderModel(r100);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder r100) {
        ThreadUtils.checkIsOnMainThread();
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        updateSurfaceSize();
    }

    public SurfaceViewRenderer(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
        String r102 = getResourceName();
        this.resourceName = r102;
        SurfaceEglRenderer r103 = new SurfaceEglRenderer(r102);
        this.eglRenderer = r103;
        getHolder().addCallback(this);
        getHolder().addCallback(r103);
        this.radius = 0.0f;
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent)));
    }

    private /* synthetic */ void lambda$onFrameResolutionChanged$0(int r100, int r101) {
        this.rotatedFrameWidth = r100;
        this.rotatedFrameHeight = r101;
        updateSurfaceSize();
        requestLayout();
    }

    public void addFrameListener(EglRenderer.FrameListener r100, float r101) {
        this.eglRenderer.addFrameListener(r100, r101);
    }

    public void init(EglBase.Context r100, RendererCommon.RendererEvents r101) {
        init(r100, r101, EglBase.CC.getEGLConfig(EglBase.EglVersion.getPreferredEglVersion(), EglBase.Config.CONFIG_PLAIN), new GlRectDrawer());
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int r100, int r101) {
        ThreadUtils.checkIsOnMainThread();
        Point r102 = this.videoLayoutMeasure.measure(r100, r101, this.rotatedFrameWidth, this.rotatedFrameHeight);
        setMeasuredDimension(r102.x, r102.y);
        logD("onMeasure(). New size: " + r102.x + "x" + r102.y);
    }

    public void setScalingType(RendererCommon.ScalingType r100, RendererCommon.ScalingType r101) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(r100, r101);
        requestLayout();
    }

    public void addFrameListener(EglRenderer.FrameListener r100, float r101, RendererCommon.GlDrawer r102) {
        this.eglRenderer.addFrameListener(r100, r101, r102);
    }

    @Override // com.bytedance.bmmt.video.RendererCommon.RendererEvents
    public void onFrameResolutionChanged(final int r100, int r101, int r102) {
        RendererCommon.RendererEvents r103 = this.rendererEvents;
        if (r103 == null) goto L6;
        r103.onFrameResolutionChanged(r100, r101, r102);
    L6:
        if (r102 == 0) goto L10;
        if (r102 == 180) goto L10;
        final int r104 = r101;
    L11:
        if (r102 == 0) goto L13;
        if (r102 == 180) goto L13;
    L14:
        postOrRun(new u(this, r104, r100));
        return;
    L13:
        r100 = r101;
    L10:
        r104 = r100;
        goto L11
    }

    public void init(EglBase.Context r100, RendererCommon.RendererEvents r101, int[] r102, RendererCommon.GlDrawer r103) {
        ThreadUtils.checkIsOnMainThread();
        this.rendererEvents = r101;
        this.rotatedFrameWidth = 0;
        this.rotatedFrameHeight = 0;
        this.eglRenderer.init(r100, this, r102, r103);
    }

    @Override // android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        ThreadUtils.checkIsOnMainThread();
        this.eglRenderer.setLayoutAspectRatio((r103 - r101) / (r104 - r102));
        updateSurfaceSize();
    }
}
