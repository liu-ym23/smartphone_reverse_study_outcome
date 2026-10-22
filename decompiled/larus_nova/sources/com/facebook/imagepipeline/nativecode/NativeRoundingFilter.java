package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;

/* JADX INFO: loaded from: classes23.dex */
public class NativeRoundingFilter {
    public NativeRoundingFilter() {
    }

    private static native void nativeToCircleFilter(Bitmap r100, boolean r101);

    private static native void nativeToCircleWithBorderFilter(Bitmap r100, int r101, int r102, boolean r103);

    static {
        NativeFiltersLoader.load();
    }

    public static void toCircle(Bitmap r100) {
        toCircle(r100, false);
    }

    public static void toCircle(Bitmap r100, boolean r101) {
        Preconditions.checkNotNull(r100);
        nativeToCircleFilter(r100, r101);
    }

    public static void toCircleWithBorder(Bitmap r100, int r101, int r102, boolean r103) {
        Preconditions.checkNotNull(r100);
        nativeToCircleWithBorderFilter(r100, r101, r102, r103);
    }
}
