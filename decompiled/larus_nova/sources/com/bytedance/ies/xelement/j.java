package com.bytedance.ies.xelement;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes19.dex */
public final class j extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxLottieView.a f250098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f250099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DataSource<CloseableReference<CloseableImage>> f250100c;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
        this.f250098a.onFailed();
        if (r100 == null) goto L5;
        r100.close();
    L5:
        this.f250099b.countDown();
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    public final void onNewResultImpl(Bitmap r100) {
        if (this.f250100c.isFinished() == false) goto L8;
        if (r100 == null) goto L8;
        this.f250098a.onSuccess(r100);
        DataSource<CloseableReference<CloseableImage>> r101 = this.f250100c;
        if (r101 == null) goto L8;
        r101.close();
    L8:
        this.f250099b.countDown();
    }

    public j(LynxLottieView.d r100, CountDownLatch r101, DataSource r102) {
        this.f250098a = r100;
        this.f250099b = r101;
        this.f250100c = r102;
    }
}
