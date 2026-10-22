package p0;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.layer.Layer;
import j0.p;

/* JADX INFO: loaded from: classes28.dex */
public final class b extends com.airbnb.lottie.model.layer.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Paint f527261w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Rect f527262x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Rect f527263y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public p f527264z;

    public final void s(RectF r100) {
        Bitmap r101 = this.f24899m.e(this.f24900n.f24870g);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r0.c.a.f535397a == false) goto L7;
        r100.set(0.0f, 0.0f, r101.getWidth() * u0.f.d(), r101.getHeight() * u0.f.d());
    L8:
        this.f24898l.mapRect(r100);
        return;
    L7:
        r100.set(r100.left, r100.top, Math.min(r100.right, r101.getWidth()), Math.min(r100.bottom, r101.getHeight()));
        goto L8
    }

    public b(LottieDrawable r100, Layer r101) {
        super(r100, r101);
        this.f527262x = new Rect();
        this.f527263y = new Rect();
        if (r0.c.a.f535397a == false) goto L5;
        this.f527261w = new h0.a(3);
    L6:
        LottieComposition r102 = r101.f24865b;
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.getImages() == null) goto L13;
        h r103 = r101.f24865b.getImages().get(r101.f24870g);
        return;
    L13:
        return;
    L5:
        this.f527261w = new Paint(3);
        goto L6
    }

    @Override // com.airbnb.lottie.model.layer.a, i0.e
    public final void c(RectF r100, Matrix r101) {
        super.c(r100, r101);
        s(r100);
    }

    @Override // com.airbnb.lottie.model.layer.a, m0.f
    public final <T> void g(T r100, v0.c<T> r101) {
        super.g(r100, r101);
        if (r100 != k.C) goto L8;
        if (r101 != null) goto L6;
        this.f527264z = null;
        return;
    L6:
        this.f527264z = new p(r101);
        return;
    }

    @Override // com.airbnb.lottie.model.layer.a
    public final void l(RectF r100, Matrix r101) {
        super.l(r100, r101);
        s(r100);
    }

    @Override // com.airbnb.lottie.model.layer.a
    public final void k(Canvas r100, Matrix r101, int r102) {
        Bitmap r103 = this.f24899m.e(this.f24900n.f24870g);
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.isRecycled() == true) goto L17;
        float r104 = u0.f.d();
        this.f527261w.setAlpha(r102);
        p r105 = this.f527264z;
        if (r105 == null) goto L10;
        this.f527261w.setColorFilter((ColorFilter) r105.g());
    L10:
        r100.save();
        r100.concat(r101);
        this.f527262x.set(0, 0, r103.getWidth(), r103.getHeight());
        this.f527263y.set(0, 0, (int) (r103.getWidth() * r104), (int) (r103.getHeight() * r104));
        if (r103.isRecycled() == false) goto L14;
        r100.restore();
        return;
    L14:
        r100.drawBitmap(r103, this.f527262x, this.f527263y, this.f527261w);
        r100.restore();
        return;
    }
}
