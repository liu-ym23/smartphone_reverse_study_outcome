package com.lynx.canvas;

import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public class KryptonViewAdaptor implements INativeSurfaceProvider {
    private static final String TAG = "KryptonViewAdaptor";
    private Rect mCurrentRect;
    private long mNativeSurfacePtr;
    private PlatformCanvasView mPlatformCanvasView;
    private final SurfaceScaleMode mSurfaceScaleMode;
    private WeakReference<KryptonSurfaceView> mSurfaceView;

    private native long nativeCreateSurface(Surface r100);

    @Override // com.lynx.canvas.INativeSurfaceProvider
    public synchronized long acquireNativeSurfacePtr() {
        monitor-enter(this);
        long r100 = this.mNativeSurfacePtr;     // Catch: Throwable -> L6
        this.mNativeSurfacePtr = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public void dispose() {
        this.mPlatformCanvasView.dispose();
        monitor-enter(this);
        long r100 = this.mNativeSurfacePtr;     // Catch: Throwable -> L9
        if (r100 == 0) goto L7;
        SurfaceHolder.destroyOrphanSurface(r100);     // Catch: Throwable -> L9
        this.mNativeSurfacePtr = 0;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private KryptonViewAdaptor(SurfaceScaleMode r100) {
        this.mSurfaceScaleMode = r100;
    }

    public static /* synthetic */ SurfaceScaleMode access$000(KryptonViewAdaptor r100) {
        return r100.mSurfaceScaleMode;
    }

    public static /* synthetic */ long access$100(KryptonViewAdaptor r100) {
        return r100.mNativeSurfacePtr;
    }

    public static /* synthetic */ WeakReference access$300(KryptonViewAdaptor r100) {
        return r100.mSurfaceView;
    }

    public static /* synthetic */ PlatformCanvasView access$400(KryptonViewAdaptor r100) {
        return r100.mPlatformCanvasView;
    }

    public static KryptonViewAdaptor from(SurfaceView r100) {
        return from(r100, SurfaceScaleMode.SCALE_TO_FILL);
    }

    public void notifyLayoutUpdate(Rect r100) {
        if (this.mSurfaceView.get() != null) goto L6;
        KryptonLLog.e(TAG, "ignore layout update, surfaceView has been released");
        return;
    L6:
        this.mCurrentRect = r100;
        this.mPlatformCanvasView.notifyLayoutUpdate(r100, r100.right - r100.left, r100.bottom - r100.top);
    }

    public void setContentScaleOverride(float r100) {
        if (r100 > 0.0f) goto L5;
        return;
    L5:
        this.mPlatformCanvasView.setContentScaleOverride(r100);
        KryptonSurfaceView r101 = this.mSurfaceView.get();
        if (r101 == null) goto L8;
        this.mPlatformCanvasView.notifySurfaceChangedWithScaleMode(this, r101.getWidth(), r101.getHeight(), this.mSurfaceScaleMode);
    L8:
        Rect r102 = this.mCurrentRect;
        if (r102 == null) goto L12;
        this.mPlatformCanvasView.notifyLayoutUpdate(r102, r102.right - r102.left, r102.bottom - r102.top);
        return;
    }

    public static /* synthetic */ long access$102(KryptonViewAdaptor r100, long r101) {
        r100.mNativeSurfacePtr = r101;
        return r101;
    }

    public static /* synthetic */ long access$200(KryptonViewAdaptor r100, Surface r101) {
        return r100.nativeCreateSurface(r101);
    }

    public static KryptonViewAdaptor from(final KryptonSurfaceView r100, SurfaceScaleMode r101) {
        if (r100 != null) goto L5;
        KryptonLLog.i(TAG, "surface view should not be null");
        return null;
    L5:
        final KryptonViewAdaptor r102 = new KryptonViewAdaptor(r101);
        r102.mSurfaceView = new WeakReference(r100);
        r102.mPlatformCanvasView = new PlatformCanvasView();
        r100.getHolder().addCallback(new AnonymousClass2(r102));
        r100.setOnTouchListener(new AnonymousClass3(r100, r102));
        return r102;
    }

    public void setup(String r100, KryptonApp r101) {
        KryptonSurfaceView r102 = this.mSurfaceView.get();
        if (r102 != null) goto L6;
        KryptonLLog.e(TAG, "ignore setup, surfaceView has been released");
        return;
    L6:
        float r103 = r102.getDensity();
        this.mPlatformCanvasView.setup(r100, r101, r103, r102.getWidth(), r102.getHeight());
        Surface r104 = r102.getHolder().getSurface();
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L9:
        if (this.mNativeSurfacePtr != 0) goto L14;
        if (r104 == null) goto L14;
        if (r104.isValid() == false) goto L14;
        KryptonLLog.i(TAG, "create surface for surfaceCreated event missed.");     // Catch: Throwable -> L17
        this.mNativeSurfacePtr = nativeCreateSurface(r104);     // Catch: Throwable -> L17
    L14:
        this.mPlatformCanvasView.notifySurfaceChangedWithScaleMode(this, r102.getWidth(), r102.getHeight(), this.mSurfaceScaleMode);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
    }

    public static KryptonViewAdaptor from(final SurfaceView r100, SurfaceScaleMode r101) {
        return from(new AnonymousClass1(r100), r101);
    }
}
