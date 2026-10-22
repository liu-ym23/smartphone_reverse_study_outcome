package com.ss.bytertc.engine.mediaio;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.TextureView;
import com.bytedance.bmmt.video.m;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.RendererCommon;
import com.bytedance.realx.video.VideoFrame;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.bytertc.base.media.EglRenderer;
import com.ss.bytertc.engine.ui.VideoFrameRender;
import com.ss.bytertc.engine.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import ujc.c;
import ujc.d;
import ujc.e;

/* JADX INFO: loaded from: classes40.dex */
public class TextureEglRenderer extends EglRenderer implements TextureView.SurfaceTextureListener {
    private static final String TAG = "TextureEglRenderer";
    private final AtomicBoolean mHasBindAtomic;
    private final AtomicBoolean mHasInitAtomic;
    private VideoFrameRender.SurfaceLifecycleCallback mSurfaceLifecycleCallback;
    private TextureView.SurfaceTextureListener mSurfaceTextureListener;
    private final Object mSurfaceTextureListenerLock;
    private volatile WeakReference<TextureView> mTextureViewRef;
    private final Handler mainHandler;

    public static /* synthetic */ void i(Runnable r100, CountDownLatch r101) {
        lambda$postOnMainThreadAndLock$2(r100, r101);
    }

    public static /* synthetic */ void j(TextureEglRenderer r100, VideoFrame r101, CountDownLatchI420Buffer r102) {
        r100.lambda$onFrame$1(r101, r102);
    }

    public static /* synthetic */ void k(TextureEglRenderer r100, TextureView r101) {
        r100.lambda$bind$0(r101);
    }

    @Override // com.ss.bytertc.base.media.EglRenderer
    public void release() {
        if (this.mHasInitAtomic.compareAndSet(true, false) == false) goto L11;
        LogUtil.d(TAG, "release");
        super.release();
        this.mHasBindAtomic.compareAndSet(true, false);
        if (this.mTextureViewRef == null) goto L12;
        TextureView r100 = this.mTextureViewRef.get();
        if (r100 == null) goto L13;
        r100.setSurfaceTextureListener(null);
        return;
    L13:
        return;
    L12:
        return;
    L11:
        throw new IllegalStateException("TextureEglRenderer has not init or already released!!!!!");
    }

    public TextureEglRenderer(String r100) {
        super(r100);
        this.mSurfaceTextureListenerLock = new Object();
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.mHasInitAtomic = new AtomicBoolean(false);
        this.mHasBindAtomic = new AtomicBoolean(false);
        this.mTextureViewRef = new WeakReference(null);
    }

    private /* synthetic */ void lambda$bind$0(TextureView r100) {
        if (r100.getSurfaceTexture() == null) goto L7;
        createEglSurface(r100.getSurfaceTexture());
        VideoFrameRender.SurfaceLifecycleCallback r101 = this.mSurfaceLifecycleCallback;
        if (r101 == null) goto L7;
        r101.onCreated();
    L7:
        r100.setSurfaceTextureListener(this);
    }

    private void runOnUIThread(Runnable r100) {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        r100.run();
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(r100);
    }

    @Override // com.ss.bytertc.base.media.EglRenderer, com.ss.bytertc.base.media.VideoSink
    public void onFrame(final VideoFrame r100) {
        if (this.mHasInitAtomic.get() == true) goto L5;
        return;
    L5:
        if (this.mHasBindAtomic.get() == true) goto L7;
        return;
    L7:
        if (this.mTextureViewRef == null) goto L28;
        TextureView r101 = this.mTextureViewRef.get();
        if (r100 == null) goto L24;
        if (r101 != null) goto L13;
        return;
    L13:
        if (r101.isShown() == true) goto L16;
        return;
    L16:
        if ((r100.getBuffer() instanceof CountDownLatchI420Buffer) == false) goto L20;
        final CountDownLatchI420Buffer r102 = (CountDownLatchI420Buffer) r100.getBuffer();
        r102.retain();
        if (postOnMainThreadAndLock(new d(this, r100, r102), r102.getLatch()) == true) goto L26;
        r102.release();
        return;
    L26:
        return;
    L20:
        super.onFrame(r100);
        return;
    L24:
        return;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        ThreadUtils.checkIsOnMainThread();
        LogUtil.d(TAG, "onSurfaceTextureDestroyed");
        CountDownLatch r101 = new CountDownLatch(1);
        releaseEglSurface(new m(r101));
        int r102 = EglRenderer.mDestroyTimeoutMs;
        if (r102 > 0) goto L5;
        ThreadUtils.awaitUninterruptibly(r101);
    L6:
        VideoFrameRender.SurfaceLifecycleCallback r103 = this.mSurfaceLifecycleCallback;
        if (r103 == null) goto L9;
        r103.onDestroy();
    L9:
        Object r104 = this.mSurfaceTextureListenerLock;
        monitor-enter(r104);
        TextureView.SurfaceTextureListener r105 = this.mSurfaceTextureListener;     // Catch: Throwable -> L16
        if (r105 == null) goto L14;
        r105.onSurfaceTextureDestroyed(r100);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r104);     // Catch: Throwable -> L16
        return true;
    L16:
        th = move-exception;
        throw th;
    L5:
        ThreadUtils.awaitUninterruptibly(r101, r102);
        goto L6
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture r100) {
        Object r101 = this.mSurfaceTextureListenerLock;
        monitor-enter(r101);
        TextureView.SurfaceTextureListener r102 = this.mSurfaceTextureListener;     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.onSurfaceTextureUpdated(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener r100) {
        Object r101 = this.mSurfaceTextureListenerLock;
        monitor-enter(r101);
        this.mSurfaceTextureListener = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onFrame$1(VideoFrame r100, CountDownLatchI420Buffer r101) {
        super.onFrame(r100);
        r101.release();
    }

    private static /* synthetic */ void lambda$postOnMainThreadAndLock$2(Runnable r100, CountDownLatch r101) {
        r100.run();
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (r101.getCount() == 0) goto L12;
        r101.await();     // Catch: InterruptedException -> L7
        return;
    }

    private boolean postOnMainThreadAndLock(final Runnable r100, final CountDownLatch r101) {
        return this.mainHandler.post(new c(r100, r101));
    }

    public void bind(final TextureView r100, VideoFrameRender.SurfaceLifecycleCallback r101) {
        if (this.mHasInitAtomic.get() == false) goto L11;
        if (this.mHasBindAtomic.compareAndSet(false, true) == false) goto L9;
        LogUtil.d(TAG, "bind");
        this.mTextureViewRef = new WeakReference(r100);
        this.mSurfaceLifecycleCallback = r101;
        runOnUIThread(new e(this, r100));
        return;
    L9:
        throw new IllegalStateException("Called bind functions multiple times!!!!!!");
    L11:
        throw new IllegalStateException("TextureEglRenderer has not init!!!!!!");
    }

    @Override // com.ss.bytertc.base.media.EglRenderer
    public void init(EglBase.Context r100, int[] r101, RendererCommon.GlDrawer r102) {
        if (this.mHasInitAtomic.compareAndSet(false, true) == false) goto L7;
        LogUtil.d(TAG, "init");
        super.init(r100, r101, r102);
        return;
    L7:
        throw new IllegalStateException("TextureEglRenderer has already init!!!!!!");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        ThreadUtils.checkIsOnMainThread();
        LogUtil.d(TAG, "onSurfaceTextureAvailable");
        createEglSurface(r100);
        VideoFrameRender.SurfaceLifecycleCallback r103 = this.mSurfaceLifecycleCallback;
        if (r103 == null) goto L5;
        r103.onCreated();
    L5:
        Object r104 = this.mSurfaceTextureListenerLock;
        monitor-enter(r104);
        TextureView.SurfaceTextureListener r105 = this.mSurfaceTextureListener;     // Catch: Throwable -> L12
        if (r105 == null) goto L10;
        r105.onSurfaceTextureAvailable(r100, r101, r102);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r104);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        LogUtil.d(TAG, "onSurfaceTextureSizeChanged");
        Object r103 = this.mSurfaceTextureListenerLock;
        monitor-enter(r103);
        TextureView.SurfaceTextureListener r104 = this.mSurfaceTextureListener;     // Catch: Throwable -> L9
        if (r104 == null) goto L7;
        r104.onSurfaceTextureSizeChanged(r100, r101, r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r103);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
