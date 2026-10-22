package p0;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.layer.Layer;
import j0.p;

/* JADX INFO: loaded from: classes28.dex */
public final class e extends com.airbnb.lottie.model.layer.a {
    public final Layer A;
    public p B;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RectF f527266w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Paint f527267x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float[] f527268y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Path f527269z;

    public e(LottieDrawable r100, Layer r101) {
        super(r100, r101);
        this.f527266w = new RectF();
        Paint r102 = new Paint();
        this.f527267x = r102;
        this.f527268y = new float[8];
        this.f527269z = new Path();
        this.A = r101;
        r102.setAlpha(0);
        r102.setStyle(Paint.Style.FILL);
        r102.setColor(r101.f24875l);
    }

    @Override // com.airbnb.lottie.model.layer.a, i0.e
    public final void c(RectF r100, Matrix r101) {
        super.c(r100, r101);
        RectF r102 = this.f527266w;
        Layer r103 = this.A;
        r102.set(0.0f, 0.0f, r103.f24873j, r103.f24874k);
        this.f24898l.mapRect(this.f527266w);
        r100.set(this.f527266w);
    }

    @Override // com.airbnb.lottie.model.layer.a, m0.f
    public final <T> void g(T r100, v0.c<T> r101) {
        super.g(r100, r101);
        if (r100 != k.C) goto L8;
        if (r101 != null) goto L6;
        this.B = null;
        return;
    L6:
        this.B = new p(r101);
        return;
    }

    @Override // com.airbnb.lottie.model.layer.a
    public final void l(RectF r100, Matrix r101) {
        super.l(r100, r101);
        RectF r102 = this.f527266w;
        Layer r103 = this.A;
        r102.set(0.0f, 0.0f, r103.f24873j, r103.f24874k);
        this.f24898l.mapRect(this.f527266w);
        r100.set(this.f527266w);
    }

    @Override // com.airbnb.lottie.model.layer.a
    public final void k(Canvas r110, Matrix r111, int r112) {
        int r100 = Color.alpha(this.A.f24875l);
        if (r100 != 0) goto L5;
        return;
    L5:
        int r113 = (int) (((r112 / 255.0f) * (((r100 / 255.0f) * this.f24907u.f496783f.g().intValue()) / 100.0f)) * 255.0f);
        this.f527267x.setAlpha(r113);
        p r101 = this.B;
        if (r101 == null) goto L8;
        this.f527267x.setColorFilter((ColorFilter) r101.g());
    L8:
        if (r113 <= 0) goto L11;
        float[] r114 = this.f527268y;
        r114[0] = 0.0f;
        r114[1] = 0.0f;
        Layer r102 = this.A;
        float r103 = r102.f24873j;
        r114[2] = r103;
        r114[3] = 0.0f;
        r114[4] = r103;
        float r104 = r102.f24874k;
        r114[5] = r104;
        r114[6] = 0.0f;
        r114[7] = r104;
        r111.mapPoints(r114);
        this.f527269z.reset();
        Path r115 = this.f527269z;
        float[] r116 = this.f527268y;
        r115.moveTo(r116[0], r116[1]);
        Path r117 = this.f527269z;
        float[] r118 = this.f527268y;
        r117.lineTo(r118[2], r118[3]);
        Path r119 = this.f527269z;
        float[] r120 = this.f527268y;
        r119.lineTo(r120[4], r120[5]);
        Path r121 = this.f527269z;
        float[] r122 = this.f527268y;
        r121.lineTo(r122[6], r122[7]);
        Path r123 = this.f527269z;
        float[] r124 = this.f527268y;
        r123.lineTo(r124[0], r124[1]);
        this.f527269z.close();
        r110.drawPath(this.f527269z, this.f527267x);
        return;
    }
}
