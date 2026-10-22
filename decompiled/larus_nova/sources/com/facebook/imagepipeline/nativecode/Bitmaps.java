package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;

/* JADX INFO: loaded from: classes23.dex */
public class Bitmaps {
    public Bitmaps() {
    }

    private static native void nativeCopyBitmap(Bitmap r100, int r101, Bitmap r102, int r103, int r104);

    static {
        ImagePipelineNativeLoader.load();
    }

    public static void copyBitmap(Bitmap r100, Bitmap r101) {
        boolean r102 = true;
        if (r101.getConfig() != r100.getConfig()) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkArgument(r103);
        Preconditions.checkArgument(r100.isMutable());
        if (r100.getWidth() != r101.getWidth()) goto L9;
        boolean r104 = true;
    L10:
        Preconditions.checkArgument(r104);
        if (r100.getHeight() == r101.getHeight()) goto L14;
        r102 = false;
    L14:
        Preconditions.checkArgument(r102);
        nativeCopyBitmap(r100, r100.getRowBytes(), r101, r101.getRowBytes(), r100.getHeight());
        return;
    L9:
        r104 = false;
        goto L10
    L5:
        r103 = false;
        goto L6
    }
}
