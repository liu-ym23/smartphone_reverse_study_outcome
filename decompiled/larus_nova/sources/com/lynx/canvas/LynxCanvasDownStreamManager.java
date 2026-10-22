package com.lynx.canvas;

import android.os.Looper;
import android.view.Surface;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;

/* JADX INFO: loaded from: classes32.dex */
public class LynxCanvasDownStreamManager {
    private static final String TAG = "KryptonDownStreamMgr";

    /* JADX INFO: renamed from: com.lynx.canvas.LynxCanvasDownStreamManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Holder {
        private static final LynxCanvasDownStreamManager INSTANCE = null;

        private Holder() {
        }

        static {
            INSTANCE = new LynxCanvasDownStreamManager(null);
        }

        public static /* synthetic */ LynxCanvasDownStreamManager access$000() {
            return INSTANCE;
        }
    }

    private static native long nativeAddSurface(long r100, String r101, Surface r102, int r103, int r104, int r105);

    private static native void nativeRemoveSurface(long r100, String r101, long r102);

    private LynxCanvasDownStreamManager() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException("CanvasDownStreamSurfaceManager should be used on main thread only.");
    }

    public static LynxCanvasDownStreamManager getInstance() {
        return Holder.access$000();
    }

    public /* synthetic */ LynxCanvasDownStreamManager(AnonymousClass1 r100) {
        this();
    }

    private long newNativeCanvasAppWeakPtr(LynxView r100) {
        LynxKryptonHelper r101 = LynxKryptonUtils.getLynxKryptonHelper(r100);
        if (r101 != null) goto L7;
        KryptonLLog.e(TAG, "LynxView may be not inited / destroyed or current card do not enable canvas.");
        return 0;
    L7:
        return r101.getCanvasManager().newNativeCanvasAppWeakPtr();
    }

    public void RemoveDownStreamSurface(LynxView r100, String r101, long r102) {
        long r103 = newNativeCanvasAppWeakPtr(r100);
        if (r103 != 0) goto L6;
        KryptonLLog.e(TAG, "canvas app weak ptr is nullptr.");
        return;
    L6:
        nativeRemoveSurface(r103, r101, r102);
    }

    public long AddDownStreamSurface(LynxView r100, String r101, Surface r110, int r111, int r112) {
        return addDownStreamSurface(r100, r101, r110, r111, r112, 0);
    }

    public long addDownStreamSurface(LynxView r100, String r101, Surface r110, int r111, int r112, int r113) {
        long r102 = newNativeCanvasAppWeakPtr(r100);
        if (r102 != 0) goto L7;
        KryptonLLog.e(TAG, "canvas app weak ptr is nullptr.");
        return 0;
    L7:
        return nativeAddSurface(r102, r101, r110, r111, r112, r113);
    }
}
