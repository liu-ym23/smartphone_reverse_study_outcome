package vs;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import fu.j;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataSource f556970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j.a f556971b;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
        if (r100 == null) goto L4;
        r100.close();
    L4:
        this.f556971b.accept(null);
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    public final void onNewResultImpl(Bitmap r100) {
        if (this.f556970a.isFinished() == false) goto L6;
        if (r100 == null) goto L6;
        Bitmap r101 = Bitmap.createBitmap(r100);
        this.f556971b.accept(r101);
        this.f556970a.close();
        return;
    L6:
        this.f556971b.accept(null);
    }

    public c(DataSource r100, a r101) {
        this.f556970a = r100;
        this.f556971b = r101;
    }
}
