package u4a;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapReferenceDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.lynx.animax.util.AnimaXLog;

/* JADX INFO: loaded from: classes32.dex */
public final class h extends BaseBitmapReferenceDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i.a f548736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DataSource f548737b;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
        if (r100.getFailureCause() == null) goto L5;
        String r101 = "Fresco failed to load bitmap.reason: " + r100.getFailureCause().getMessage();
    L6:
        ((g) this.f548736a).a(null, r101);
        r100.close();
        return;
    L5:
        r101 = "Fresco failed to load bitmap.";
        goto L6
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapReferenceDataSubscriber
    public final void onNewResultImpl(CloseableReference<Bitmap> r100) {
        if (r100 == null) goto L5;
        Bitmap r101 = r100.get();
    L6:
        if (r101 == null) goto L24;
        boolean r102 = true;
        if (((r101.getWidth() * r101.getHeight()) * 4) != r101.getByteCount()) goto L10;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        ((g) this.f548736a).a(new f(r100), "");
    L25:
        this.f548737b.close();
        return;
    L14:
        AnimaXLog.b("FrescoUtil", "Fresco returned a bitmap with an invalid format. Attempting to convert it to ARGB_8888.");
        Bitmap r104 = r101.copy(Bitmap.Config.ARGB_8888, false);
        if (r104 != null) goto L18;
    L20:
        r102 = false;
    L21:
        if (r102 == false) goto L23;
        ((g) this.f548736a).a(new q(r104), "");
        goto L25
    L23:
        ((g) this.f548736a).a(null, "Fresco returned unknown bitmap format which cannot be converted to RGBA8888.");
        goto L25
    L18:
        if (((r104.getWidth() * r104.getHeight()) * 4) != r104.getByteCount()) goto L20;
    L10:
        r103 = false;
        goto L12
    L24:
        ((g) this.f548736a).a(null, "Fresco returned a null bitmap on success.");
        goto L25
    L5:
        r101 = null;
        goto L6
    }

    public h(g r100, DataSource r101) {
        this.f548736a = r100;
        this.f548737b = r101;
    }
}
