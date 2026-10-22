package com.bytedance.bmmt.video;

import android.view.SurfaceHolder;
import com.bytedance.bmmt.base.Logging;
import com.bytedance.bmmt.base.ThreadUtils;
import com.bytedance.bmmt.video.memory.BmmtVideoFrameInterface;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes8.dex */
public class SurfaceEglRenderer extends EglRenderer implements SurfaceHolder.Callback {
    private static final String TAG = "SurfaceEglRenderer";
    private int frameRotation;
    private boolean isFirstFrameRendered;
    private boolean isRenderingPaused;
    private final Object layoutLock;
    private RendererCommon.RendererEvents rendererEvents;
    private int rotatedFrameHeight;
    private int rotatedFrameWidth;

    @Override // com.bytedance.bmmt.video.EglRenderer
    public void disableFpsReduction() {
        Object r100 = this.layoutLock;
        monitor-enter(r100);
        this.isRenderingPaused = false;     // Catch: Throwable -> L9
        monitor-exit(r100);     // Catch: Throwable -> L9
        super.disableFpsReduction();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bmmt.video.EglRenderer
    public void pauseVideo() {
        Object r100 = this.layoutLock;
        monitor-enter(r100);
        this.isRenderingPaused = true;     // Catch: Throwable -> L9
        monitor-exit(r100);     // Catch: Throwable -> L9
        super.pauseVideo();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bmmt.video.EglRenderer
    public void release() {
        super.release();
        CountDownLatch r100 = new CountDownLatch(1);
        releaseEglSurface(new m(r100));
        ThreadUtils.awaitUninterruptibly(r100);
    }

    public SurfaceEglRenderer(String r100) {
        super(r100);
        this.layoutLock = new Object();
    }

    private void logD(String r100) {
        Logging.i(TAG, this.name + ": " + r100);
    }

    private void updateFrameDimensionsAndReportEvents(BmmtVideoFrameInterface r100) {
        Object r101 = this.layoutLock;
        monitor-enter(r101);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.isRenderingPaused == false) goto L9;
        monitor-exit(r101);     // Catch: Throwable -> L25
        return;
    L9:
        if (this.isFirstFrameRendered == true) goto L14;
        this.isFirstFrameRendered = true;     // Catch: Throwable -> L25
        logD("Reporting first rendered frame.");     // Catch: Throwable -> L25
        RendererCommon.RendererEvents r102 = this.rendererEvents;     // Catch: Throwable -> L25
        if (r102 == null) goto L14;
        r102.onFirstFrameRendered();     // Catch: Throwable -> L25
    L14:
        if (this.rotatedFrameWidth == r100.getRotatedWidth()) goto L16;
    L19:
        logD("Reporting frame resolution changed to " + r100.getRotatedWidth() + "x" + r100.getHeight() + " with rotation " + r100.getRotation());     // Catch: Throwable -> L25
        RendererCommon.RendererEvents r103 = this.rendererEvents;     // Catch: Throwable -> L25
        if (r103 == null) goto L22;
        r103.onFrameResolutionChanged(r100.getWidth(), r100.getHeight(), r100.getRotation().value());     // Catch: Throwable -> L25
    L22:
        this.rotatedFrameWidth = r100.getRotatedWidth();     // Catch: Throwable -> L25
        this.rotatedFrameHeight = r100.getRotatedHeight();     // Catch: Throwable -> L25
        this.frameRotation = r100.getRotation().value();     // Catch: Throwable -> L25
    L23:
        monitor-exit(r101);     // Catch: Throwable -> L25
        return;
    L16:
        if (this.rotatedFrameHeight != r100.getRotatedHeight()) goto L19;
        if (this.frameRotation == r100.getRotation().value()) goto L23;
        goto L19
    }

    @Override // com.bytedance.bmmt.video.EglRenderer, com.bytedance.bmmt.video.VideoSink
    public void onFrame(BmmtVideoFrameInterface r100) {
        updateFrameDimensionsAndReportEvents(r100);
        super.onFrame(r100);
    }

    @Override // com.bytedance.bmmt.video.EglRenderer
    public void setFpsReduction(float r100) {
        Object r101 = this.layoutLock;
        monitor-enter(r101);
        if (r100 != 0.0f) goto L7;
        boolean r102 = true;
    L15:
        this.isRenderingPaused = r102;     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        super.setFpsReduction(r100);
        return;
    L12:
        th = move-exception;
        throw th;
    L7:
        r102 = false;
        goto L15
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder r100) {
        ThreadUtils.checkIsOnMainThread();
        createEglSurface(r100.getSurface());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder r100) {
        ThreadUtils.checkIsOnMainThread();
        CountDownLatch r101 = new CountDownLatch(1);
        releaseEglSurface(new m(r101));
        ThreadUtils.awaitUninterruptibly(r101);
    }

    @Override // com.bytedance.bmmt.video.EglRenderer
    public void init(EglBase.Context r100, int[] r101, RendererCommon.GlDrawer r102) {
        init(r100, null, r101, r102);
    }

    public void init(EglBase.Context r100, RendererCommon.RendererEvents r101, int[] r102, RendererCommon.GlDrawer r103) {
        ThreadUtils.checkIsOnMainThread();
        Object r104 = this.layoutLock;
        monitor-enter(r104);
        this.rendererEvents = r101;     // Catch: Throwable -> L8
        this.isFirstFrameRendered = false;     // Catch: Throwable -> L8
        this.rotatedFrameWidth = 0;     // Catch: Throwable -> L8
        this.rotatedFrameHeight = 0;     // Catch: Throwable -> L8
        this.frameRotation = 0;     // Catch: Throwable -> L8
        monitor-exit(r104);     // Catch: Throwable -> L8
        super.init(r100, r102, r103);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        ThreadUtils.checkIsOnMainThread();
        logD("surfaceChanged: format: " + r101 + " size: " + r102 + "x" + r103);
    }
}
