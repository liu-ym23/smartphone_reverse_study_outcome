package com.lynx.canvas;

import android.graphics.RectF;
import android.os.Looper;
import android.view.Surface;

/* JADX INFO: loaded from: classes32.dex */
public class KryptonDownStreamManager {
    private static final String TAG = "KryptonDownStreamManager";

    /* JADX INFO: renamed from: com.lynx.canvas.KryptonDownStreamManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Holder {
        private static final KryptonDownStreamManager INSTANCE = null;

        private Holder() {
        }

        static {
            INSTANCE = new KryptonDownStreamManager(null);
        }

        public static /* synthetic */ KryptonDownStreamManager access$000() {
            return INSTANCE;
        }
    }

    private static native long nativeAddSurface(long r100, String r101, Surface r102, int r103, int r104, int r105, float r106, float r107, float r108, float r110, int r111);

    private static native void nativeRemoveSurface(long r100, String r101, long r102);

    private KryptonDownStreamManager() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException("KryptonDownStreamManager should be used on main thread only.");
    }

    public static KryptonDownStreamManager getInstance() {
        return Holder.access$000();
    }

    public /* synthetic */ KryptonDownStreamManager(AnonymousClass1 r100) {
        this();
    }

    public void removeDownStreamSurface(KryptonApp r100, String r101, long r102) {
        long r103 = r100.newNativeWeakPtr();
        if (r103 != 0) goto L6;
        KryptonLLog.e(TAG, "canvas app weak ptr is nullptr.");
        return;
    L6:
        nativeRemoveSurface(r103, r101, r102);
    }

    public long addDownStreamSurface(KryptonApp r110, String r111, Surface r112, int r113, int r114, SurfaceScaleMode r115, RectF r116) {
        return addDownStreamSurface(r110, r111, r112, r113, r114, r115, r116, 0);
    }

    public long addDownStreamSurface(KryptonApp r110, String r111, Surface r112, int r113, int r114, SurfaceScaleMode r115, RectF r116, int r210) {
        long r100 = r110.newNativeWeakPtr();
        if (r100 != 0) goto L7;
        KryptonLLog.e(TAG, "canvas app weak ptr is nullptr.");
        return 0;
    L7:
        if (r115 != SurfaceScaleMode.SCALE_TO_FILL_WITH_SOURCE_CROP) goto L14;
        if (r116 == null) goto L12;
        return nativeAddSurface(r100, r111, r112, r113, r114, r115.value, r116.left, (1.0f - r116.top) - r116.height(), r116.width(), r116.height(), r210);
    L12:
        throw new IllegalArgumentException("sourceRect must be passed if use SCALE_TO_FILL_WITH_SOURCE_CROP");
    L14:
        return nativeAddSurface(r100, r111, r112, r113, r114, r115.value, 0.0f, 0.0f, 0.0f, 0.0f, r210);
    }
}
