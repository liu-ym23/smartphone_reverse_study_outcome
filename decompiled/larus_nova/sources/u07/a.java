package u07;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import u7a.l;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CloseableReference<CloseableImage> f548155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f548156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Drawable f548157c;

    public a(CloseableReference<CloseableImage> r100) {
        this.f548155a = r100;
        if (r100 == null) goto L5;
        CloseableImage r101 = r100.get();
    L7:
        if ((r101 instanceof CloseableBitmap) == false) goto L9;
        this.f548156b = ((CloseableBitmap) r101).getUnderlyingBitmap();
    L10:
        this.f548157c = null;
        return;
    L9:
        this.f548156b = null;
        goto L10
    L5:
        r101 = null;
        goto L7
    }

    public a(Drawable r100, CloseableReference<CloseableImage> r101) {
        this.f548155a = r101;
        this.f548157c = r100;
        this.f548156b = null;
    }
}
