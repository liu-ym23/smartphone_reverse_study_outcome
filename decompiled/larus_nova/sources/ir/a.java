package ir;

import android.graphics.Bitmap;
import com.bytedance.android.ecom.live.adapter.impl.f;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataSource f495435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f495436b;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
        if (r100 == null) goto L4;
        r100.close();
    L4:
        this.f495436b.accept(null);
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    public final void onNewResultImpl(Bitmap r100) {
        if (this.f495435a.isFinished() == false) goto L6;
        if (r100 == null) goto L6;
        Bitmap r101 = Bitmap.createBitmap(r100);
        this.f495436b.accept(r101);
        this.f495435a.close();
        return;
    L6:
        this.f495436b.accept(null);
    }

    public a(DataSource r100, f r101) {
        this.f495435a = r100;
        this.f495436b = r101;
    }
}
