package com.facebook.imagepipeline.platform;

import android.graphics.BitmapFactory;
import androidx.core.util.Pools;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;

/* JADX INFO: loaded from: classes23.dex */
public class ArtDecoder extends DefaultDecoder {
    public ArtDecoder(BitmapPool r100, int r101, Pools.SynchronizedPool r102) {
        super(r100, r101, r102);
    }

    @Override // com.facebook.imagepipeline.platform.DefaultDecoder
    public int getBitmapSize(int r100, int r101, BitmapFactory.Options r102) {
        return BitmapUtil.getSizeInByteForBitmap(r100, r101, r102.inPreferredConfig);
    }
}
