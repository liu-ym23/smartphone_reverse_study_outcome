package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class BaseBitmapReferenceDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    public abstract void onNewResultImpl(@Nullable CloseableReference<Bitmap> r100);

    public BaseBitmapReferenceDataSubscriber() {
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> r100) {
        if (r100.isFinished() == true) goto L5;
        return;
    L5:
        CloseableReference<CloseableImage> r101 = r100.getResult();
        if (r101 != null) goto L8;
    L10:
        CloseableReference<Bitmap> r102 = null;
    L17:
        onNewResultImpl(r102);     // Catch: Throwable -> L14
        CloseableReference.closeSafely(r102);
        CloseableReference.closeSafely(r101);
        return;
    L14:
        th = move-exception;
        CloseableReference.closeSafely(r102);
        CloseableReference.closeSafely(r101);
        throw th;
    L8:
        if ((r101.get() instanceof CloseableStaticBitmap) == false) goto L10;
        r102 = ((CloseableStaticBitmap) r101.get()).cloneUnderlyingBitmapReference();
        goto L17
    }
}
