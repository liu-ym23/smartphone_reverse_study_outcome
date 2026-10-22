package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;

/* JADX INFO: loaded from: classes23.dex */
public class NativeBlurFilter {
    public NativeBlurFilter() {
    }

    private static native void nativeIterativeBoxBlur(Bitmap r100, int r101, int r102);

    static {
        NativeFiltersLoader.load();
    }

    public static void iterativeBoxBlur(Bitmap r100, int r101, int r102) {
        Preconditions.checkNotNull(r100);
        boolean r103 = true;
        if (r101 <= 0) goto L5;
        boolean r104 = true;
    L6:
        Preconditions.checkArgument(r104);
        if (r102 > 0) goto L10;
        r103 = false;
    L10:
        Preconditions.checkArgument(r103);
        nativeIterativeBoxBlur(r100, r101, r102);
        return;
    L5:
        r104 = false;
        goto L6
    }
}
