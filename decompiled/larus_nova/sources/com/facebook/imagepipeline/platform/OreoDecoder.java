package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import androidx.core.util.Pools;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;

/* JADX INFO: loaded from: classes3.dex */
public class OreoDecoder extends DefaultDecoder {
    private static boolean hasColorGamutMismatch(BitmapFactory.Options r100) {
        ColorSpace r101 = r100.outColorSpace;
        if (r101 != null) goto L5;
    L9:
        return false;
    L5:
        if (r101.isWideGamut() == false) goto L9;
        if (r100.inPreferredConfig == Bitmap.Config.RGBA_F16) goto L9;
        return true;
    }

    public OreoDecoder(BitmapPool r100, int r101, Pools.SynchronizedPool r102) {
        super(r100, r101, r102);
    }

    @Override // com.facebook.imagepipeline.platform.DefaultDecoder
    public int getBitmapSize(int r100, int r101, BitmapFactory.Options r102) {
        if (hasColorGamutMismatch(r102) == false) goto L6;
        return (r100 * r101) * 8;
    L6:
        return BitmapUtil.getSizeInByteForBitmap(r100, r101, r102.inPreferredConfig);
    }
}
