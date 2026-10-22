package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public abstract class WrapperBitmapDataSubscriber extends BaseBitmapDataSubscriber {
    private BaseBitmapDataSubscriber mBaseBitmapDataSubscriber;

    public abstract Bitmap convertBitmap(Bitmap r100);

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
    }

    public WrapperBitmapDataSubscriber(BaseBitmapDataSubscriber r100) {
        this.mBaseBitmapDataSubscriber = r100;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
    public void onCancellation(DataSource<CloseableReference<CloseableImage>> r100) {
        BaseBitmapDataSubscriber r101 = this.mBaseBitmapDataSubscriber;
        if (r101 == null) goto L6;
        r101.onCancellation(r100);
        return;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
    public void onFailure(DataSource<CloseableReference<CloseableImage>> r100) {
        BaseBitmapDataSubscriber r101 = this.mBaseBitmapDataSubscriber;
        if (r101 == null) goto L6;
        r101.onFailure(r100);
        return;
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    public void onNewResultImpl(@Nullable Bitmap r100) {
        BaseBitmapDataSubscriber r101 = this.mBaseBitmapDataSubscriber;
        if (r101 == null) goto L6;
        r101.onNewResultImpl(convertBitmap(r100));
        return;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
    public void onProgressUpdate(DataSource<CloseableReference<CloseableImage>> r100) {
        BaseBitmapDataSubscriber r101 = this.mBaseBitmapDataSubscriber;
        if (r101 == null) goto L6;
        r101.onProgressUpdate(r100);
        return;
    }
}
