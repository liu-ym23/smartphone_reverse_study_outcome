package com.ss.bytertc.engine.mediaio;

import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.VideoFrame;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.bytertc.base.media.SurfaceEglRenderer;
import com.ss.bytertc.engine.ui.VideoFrameRender;
import com.ss.bytertc.engine.utils.LogUtil;
import java.lang.ref.SoftReference;
import java.util.concurrent.atomic.AtomicBoolean;
import ujc.b;

/* JADX INFO: loaded from: classes40.dex */
public class SurfaceEglRender extends SurfaceEglRenderer {
    private static final String TAG = "SurfaceEglRender";
    private SurfaceHolder.Callback mCallback;
    private final AtomicBoolean mHasBindAtomic;
    private final AtomicBoolean mHasInitAtomic;
    private final Object mSurfaceCallbackLock;
    private VideoFrameRender.SurfaceLifecycleCallback mSurfaceLifecycleCallback;
    private final Object mSurfaceLifecycleCallbackLock;
    private SoftReference<SurfaceView> surfaceViewSoftReference;

    public static /* synthetic */ void i(SurfaceEglRender r100, SurfaceView r101) {
        r100.lambda$bind$0(r101);
    }

    @Override // com.ss.bytertc.base.media.SurfaceEglRenderer, com.ss.bytertc.base.media.EglRenderer
    public void release() {
        if (this.mHasInitAtomic.compareAndSet(true, false) == false) goto L11;
        LogUtil.d(TAG, "release");
        super.release();
        this.mHasBindAtomic.compareAndSet(true, false);
        SoftReference<SurfaceView> r100 = this.surfaceViewSoftReference;
        if (r100 == null) goto L12;
        SurfaceView r101 = r100.get();
        if (r101 == null) goto L13;
        r101.getHolder().removeCallback(this);
        return;
    L13:
        return;
    L12:
        return;
    L11:
        throw new IllegalStateException("TextureEglRenderer has not init or already released!!!!!");
    }

    public SurfaceEglRender(String r100) {
        super(r100);
        this.mHasInitAtomic = new AtomicBoolean(false);
        this.mHasBindAtomic = new AtomicBoolean(false);
        this.mSurfaceLifecycleCallbackLock = new Object();
        this.mSurfaceCallbackLock = new Object();
        this.surfaceViewSoftReference = new SoftReference(null);
    }

    private /* synthetic */ void lambda$bind$0(SurfaceView r100) {
        SurfaceHolder r101 = r100.getHolder();
        Object r102 = this.mSurfaceCallbackLock;
        monitor-enter(r102);
        SurfaceHolder.Callback r103 = this.mCallback;     // Catch: Throwable -> L15
        if (r103 == null) goto L7;
        r101.addCallback(r103);     // Catch: Throwable -> L15
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L15
        this.surfaceViewSoftReference = new SoftReference(r100);
        if (r101.getSurface() != null) goto L11;
    L13:
        r101.addCallback(this);
        return;
    L11:
        if (r101.getSurface().isValid() == false) goto L13;
        setLayoutAspectRatio(r100.getMeasuredWidth() / r100.getMeasuredHeight());
        surfaceCreated(r101);
    L15:
        th = move-exception;
        throw th;
    }

    private void runOnUIThread(Runnable r100) {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        r100.run();
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(r100);
    }

    public void bind(final SurfaceView r100) {
        if (this.mHasInitAtomic.get() == false) goto L11;
        if (this.mHasBindAtomic.compareAndSet(false, true) == false) goto L9;
        LogUtil.d(TAG, "bind");
        runOnUIThread(new b(this, r100));
        return;
    L9:
        throw new IllegalStateException("Called bind functions multiple times!!!!!!");
    L11:
        throw new IllegalStateException("TextureEglRenderer has not init!!!!!!");
    }

    @Override // com.ss.bytertc.base.media.SurfaceEglRenderer, com.ss.bytertc.base.media.EglRenderer, com.ss.bytertc.base.media.VideoSink
    public void onFrame(VideoFrame r100) {
        if (this.mHasInitAtomic.get() == true) goto L5;
        return;
    L5:
        if (this.mHasBindAtomic.get() == false) goto L10;
        super.onFrame(r100);
        return;
    }

    public void setSurfaceHolderCallback(SurfaceHolder.Callback r100) {
        Object r101 = this.mSurfaceCallbackLock;
        monitor-enter(r101);
        this.mCallback = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setSurfaceLifecycleLisenter(VideoFrameRender.SurfaceLifecycleCallback r100) {
        Object r101 = this.mSurfaceLifecycleCallbackLock;
        monitor-enter(r101);
        this.mSurfaceLifecycleCallback = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.base.media.SurfaceEglRenderer, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder r100) {
        super.surfaceCreated(r100);
        LogUtil.d(TAG, "surfaceCreated");
        Object r101 = this.mSurfaceLifecycleCallbackLock;
        monitor-enter(r101);
        VideoFrameRender.SurfaceLifecycleCallback r102 = this.mSurfaceLifecycleCallback;     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.onCreated();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.base.media.SurfaceEglRenderer, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder r100) {
        super.surfaceDestroyed(r100);
        LogUtil.d(TAG, "surfaceDestroyed");
        Object r101 = this.mSurfaceLifecycleCallbackLock;
        monitor-enter(r101);
        VideoFrameRender.SurfaceLifecycleCallback r102 = this.mSurfaceLifecycleCallback;     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.onDestroy();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.base.media.SurfaceEglRenderer, com.ss.bytertc.base.media.EglRenderer
    public void init(EglBase.Context r100, int[] r101, RendererCommon.GlDrawer r102) {
        ThreadUtils.checkIsOnMainThread();
        if (this.mHasInitAtomic.compareAndSet(false, true) == false) goto L7;
        LogUtil.d(TAG, "init");
        super.init(r100, r101, r102);
        return;
    L7:
        throw new IllegalStateException("SurfaceEglRender has already init!!!!!!");
    }

    @Override // com.ss.bytertc.base.media.SurfaceEglRenderer, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        super.surfaceChanged(r100, r101, r102, r103);
        LogUtil.d(TAG, "surfaceChanged");
    }
}
