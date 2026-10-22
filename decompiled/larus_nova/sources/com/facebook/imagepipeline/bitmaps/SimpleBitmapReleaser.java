package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.ResourceReleaser;

/* JADX INFO: loaded from: classes23.dex */
public class SimpleBitmapReleaser implements ResourceReleaser<Bitmap> {
    private static SimpleBitmapReleaser sInstance;

    private SimpleBitmapReleaser() {
    }

    public static SimpleBitmapReleaser getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new SimpleBitmapReleaser();
    L6:
        return sInstance;
    }

    @Override // com.facebook.common.references.ResourceReleaser
    public /* bridge */ /* synthetic */ void release(Bitmap r100) {
        release2(r100);
    }

    /* JADX INFO: renamed from: release, reason: avoid collision after fix types in other method */
    public void release2(Bitmap r100) {
        r100.recycle();
    }
}
