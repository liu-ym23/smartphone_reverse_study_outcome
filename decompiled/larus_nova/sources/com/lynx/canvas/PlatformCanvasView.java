package com.lynx.canvas;

import android.graphics.Rect;
import android.view.MotionEvent;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class PlatformCanvasView {
    private static final int MAX_POINTER_COUNT = 5;
    private static final String[] MEMORY_DETAIL_KEYS = null;
    private static final String TAG = "PlatformCanvasView";
    private static final int TOUCH_EVENT_BUFFER_SIZE = 112;
    private WeakReference<KryptonApp> mApp;
    private float mContentScaleOverride;
    private Rect mCurrentRect;
    private boolean mHasNotifySurfaceCreate;
    private int mHeight;
    private Boolean mInitialized;
    private String mName;
    private long mNativeCanvasViewPtr;
    private float mScale;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private int mWidth;

    private native long nativeCreateCanvasView(String r100, long r101, int r102, int r103);

    private native void nativeDestroyCanvasView(long r100);

    private native void nativeDispatchTouchEvent(long r100, ByteBuffer r101);

    private native long nativeGetMemoryUsageBytes(long r100);

    private native long[] nativeGetMemoryUsageDetail(long r100);

    private native void nativeOnSurfaceChanged(long r100, int r101, int r102);

    private native void nativeOnSurfaceCreated(long r100, long r101, int r102, int r103, int r104);

    private native void nativeOnSurfaceDestroyed(long r100);

    private native void nativeViewLayoutUpdate(long r100, int r101, int r102, int r103, int r104, int r105, int r106);

    static {
        MEMORY_DETAIL_KEYS = new String[]{"krypton.total.estimated_bytes", "krypton.total.object_count", "krypton.canvas_element.bytes", "krypton.canvas_element.count", "krypton.image_element.bytes", "krypton.image_element.count", "krypton.video_element.count", "krypton.video_context.count", "krypton.webgl_generic.count", "krypton.webgl_buffer.bytes", "krypton.webgl_buffer.count", "krypton.webgl_texture.bytes", "krypton.webgl_texture.count", "krypton.webgl_renderbuffer.bytes", "krypton.webgl_renderbuffer.count", "krypton.external_data.bytes", "krypton.external_data.count", "krypton.gl_surface.count"};
    }

    public void dispose() {
        long r100 = this.mNativeCanvasViewPtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        this.mNativeCanvasViewPtr = 0;
        nativeDestroyCanvasView(r100);
    }

    public long getMemoryUsageBytes() {
        long r100 = this.mNativeCanvasViewPtr;
        if (r100 != 0) goto L6;
        return 0;
    L6:
        return nativeGetMemoryUsageBytes(r100);
    }

    public Map<String, String> getMemoryUsageDetail() {
        long r100 = this.mNativeCanvasViewPtr;
        if (r100 != 0) goto L5;
        return null;
    L5:
        long[] r101 = nativeGetMemoryUsageDetail(r100);
        if (r101 != null) goto L8;
        return null;
    L8:
        HashMap r102 = new HashMap();
        int r103 = Math.min(r101.length, MEMORY_DETAIL_KEYS.length);
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L11;
        r102.put(MEMORY_DETAIL_KEYS[r104], String.valueOf(r101[r104]));
        r104 = r104 + 1;
        goto L9
    L11:
        return r102;
    }

    public void onSurfaceDestroyed() {
        long r100 = this.mNativeCanvasViewPtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        this.mHasNotifySurfaceCreate = false;
        nativeOnSurfaceDestroyed(r100);
    }

    public PlatformCanvasView() {
        this.mInitialized = Boolean.FALSE;
        this.mContentScaleOverride = 0.0f;
        this.mHasNotifySurfaceCreate = false;
    }

    private boolean initInternal() {
        if (Krypton.inst().hasInitialized() == true) goto L6;
        KryptonLLog.w(TAG, "initCanvasInternal but krypton do not init.");
        return false;
    L6:
        KryptonApp r100 = this.mApp.get();
        if (r100 != null) goto L10;
        KryptonLLog.w(TAG, "krypton app has been released.");
        return false;
    L10:
        long r101 = r100.newNativeWeakPtr();
        if (r101 != 0) goto L14;
        KryptonLLog.w(TAG, "canvas app has been destroyed.");
        return false;
    L14:
        this.mNativeCanvasViewPtr = nativeCreateCanvasView(this.mName, r101, this.mWidth, this.mHeight);
        return true;
    }

    public float getScale() {
        return this.mScale;
    }

    private int px2dip(float r100) {
        return (int) ((r100 / this.mScale) + 0.5f);
    }

    private int px2overriden(float r100) {
        return (int) (((r100 / this.mScale) * this.mContentScaleOverride) + 0.5f);
    }

    public void dispatchTransformedTouchEvent(ByteBuffer r100) {
        long r101 = this.mNativeCanvasViewPtr;
        if (r101 == 0) goto L6;
        nativeDispatchTouchEvent(r101, r100);
        return;
    }

    public void setContentScaleOverride(float r100) {
        KryptonLLog.i(TAG, "setContentScaleOverride " + r100);
        monitor-enter(this);
        this.mContentScaleOverride = r100;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        if (this.mInitialized.booleanValue() == false) goto L17;
        KryptonApp r101 = this.mApp.get();
        if (r101 == null) goto L18;
        r101.setDevicePixelRatio(r100);
        return;
    L18:
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void onSurfaceChanged(int r100, int r101) {
        long r102 = this.mNativeCanvasViewPtr;
        if (r102 != 0) goto L6;
        KryptonLLog.e(TAG, "surface changed but mNativeCanvasViewPtr " + this.mNativeCanvasViewPtr);
        return;
    L6:
        nativeOnSurfaceChanged(r102, r100, r101);
    }

    public void dispatchTouchEvent(MotionEvent r110, Rect r111, Rect r112) {
        int r100 = r110.getActionIndex();
        int r101 = 5;
        if (r100 < 5) goto L5;
        return;
    L5:
        int r102 = r110.getPointerCount();
        if (r102 > 5) goto L9;
        r101 = r102;
    L9:
        ByteBuffer r103 = ByteBuffer.allocateDirect(112);
        r103.order(ByteOrder.LITTLE_ENDIAN);
        r103.clear();
        r103.put((byte) r110.getActionMasked()).put((byte) r101).put((byte) r100).put((byte) 1).putInt(px2dip(r112.left)).putInt(px2dip(r112.top));
        float r104 = r110.getRawX() - r110.getX();
        float r105 = r110.getRawY() - r110.getY();
        int r106 = 0;
    L10:
        if (r106 >= r101) goto L12;
        r103.putInt(r110.getPointerId(r106)).putFloat(((r111.left - r112.left) + r110.getX(r106)) / this.mScale).putFloat(((r111.top - r112.top) + r110.getY(r106)) / this.mScale).putFloat((r110.getX(r106) + r104) / this.mScale).putFloat((r110.getY(r106) + r105) / this.mScale);
        r106 = r106 + 1;
        goto L10
    L12:
        long r113 = this.mNativeCanvasViewPtr;
        if (r113 == 0) goto L17;
        nativeDispatchTouchEvent(r113, r103);
        return;
    }

    public void notifyLayoutUpdate(Rect r110, int r111, int r112) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.mContentScaleOverride <= 0.0f) goto L6;
        Rect r100 = new Rect(px2overriden(r110.left), px2overriden(r110.top), px2overriden(r110.right), px2overriden(r110.bottom));     // Catch: Throwable -> L20
        int r101 = px2overriden(r111);     // Catch: Throwable -> L20
        int r102 = px2overriden(r112);     // Catch: Throwable -> L20
        r110 = r100;
    L8:
        if (r110.equals(this.mCurrentRect) == true) goto L10;
    L15:
        this.mCurrentRect = r110;     // Catch: Throwable -> L20
        this.mWidth = r101;     // Catch: Throwable -> L20
        this.mHeight = r102;     // Catch: Throwable -> L20
        long r103 = this.mNativeCanvasViewPtr;     // Catch: Throwable -> L20
        if (r103 == 0) goto L18;
        nativeViewLayoutUpdate(r103, r110.left, r110.right, r110.top, r110.bottom, r101, r102);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L10:
        if (this.mWidth != r101) goto L15;
        if (this.mHeight != r102) goto L15;
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L6:
        r101 = r111;
        r102 = r112;
        goto L8
    }

    public void notifySurfaceChanged(INativeSurfaceProvider r100, int r101, int r102) {
        notifySurfaceChangedWithScaleMode(r100, r101, r102, SurfaceScaleMode.SCALE_TO_FILL);
    }

    public void notifySurfaceChangedWithScaleMode(INativeSurfaceProvider r100, int r110, int r111, SurfaceScaleMode r112) {
        monitor-enter(this);
        if (r110 == 0) goto L34;
        if (r111 == 0) goto L34;
        if (this.mContentScaleOverride <= 0.0f) goto L10;
        r110 = px2overriden(r110);     // Catch: Throwable -> L37
        r111 = px2overriden(r111);     // Catch: Throwable -> L37
    L10:
        int r101 = r110;
        int r102 = r111;
        if (this.mHasNotifySurfaceCreate == true) goto L26;
        if (this.mNativeCanvasViewPtr != 0) goto L17;
        KryptonLLog.e(TAG, "surface created but mNativeCanvasViewPtr is 0");     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return;
    L17:
        long r103 = r100.acquireNativeSurfacePtr();     // Catch: Throwable -> L37
        if (r103 != 0) goto L22;
        KryptonLLog.e(TAG, "notify surface created but provider already drained");     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return;
    L22:
        KryptonLLog.i(TAG, "notify surface created w " + r101 + " h " + r102 + " scaleMode " + r112);     // Catch: Throwable -> L37
        this.mSurfaceWidth = r101;     // Catch: Throwable -> L37
        this.mSurfaceHeight = r102;     // Catch: Throwable -> L37
        this.mHasNotifySurfaceCreate = true;     // Catch: Throwable -> L37
        nativeOnSurfaceCreated(this.mNativeCanvasViewPtr, r103, r101, r102, r112.value);     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return;
    L26:
        if (this.mSurfaceWidth == r101) goto L28;
    L31:
        KryptonLLog.i(TAG, "notify surface changed w " + r101 + " h " + r102);     // Catch: Throwable -> L37
        this.mSurfaceWidth = r101;     // Catch: Throwable -> L37
        this.mSurfaceHeight = r102;     // Catch: Throwable -> L37
        onSurfaceChanged(r101, r102);     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return;
    L28:
        if (this.mSurfaceHeight != r102) goto L31;
        monitor-exit(this);     // Catch: Throwable -> L37
        return;
    L34:
        KryptonLLog.i(TAG, "ignore notify surface changed w " + r110 + " h " + r111 + " or platform view disposed");     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return;
    L37:
        th = move-exception;
        throw th;
    }

    public boolean setup(String r100, KryptonApp r101, float r102, int r103, int r104) {
        if (this.mInitialized.booleanValue() == false) goto L6;
        KryptonLLog.e(TAG, "Set name to initialized canvas with old name " + this.mName + " new name " + r100);
        return true;
    L6:
        this.mScale = r102;
        this.mName = r100;
        if (this.mContentScaleOverride <= 0.0f) goto L9;
        this.mWidth = px2overriden(r103);
        this.mHeight = px2overriden(r104);
        r101.setDevicePixelRatio(this.mContentScaleOverride);
    L10:
        this.mApp = new WeakReference(r101);
        if (initInternal() == true) goto L14;
        KryptonLLog.e(TAG, "init canvas internal failed " + r100);
        return false;
    L14:
        this.mInitialized = Boolean.TRUE;
        return true;
    L9:
        this.mWidth = r103;
        this.mHeight = r104;
        goto L10
    }
}
