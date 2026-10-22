package tz6;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.model.layer.Layer;
import com.bytedance.lottie.n;
import oz6.p;

/* JADX INFO: loaded from: classes21.dex */
public final class e extends com.bytedance.lottie.model.layer.a {
    public p A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RectF f548059v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Paint f548060w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float[] f548061x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Path f548062y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Layer f548063z;

    public e(LottieDrawable r100, Layer r101) {
        super(r100, r101);
        this.f548059v = new RectF();
        Paint r102 = new Paint();
        this.f548060w = r102;
        this.f548061x = new float[8];
        this.f548062y = new Path();
        this.f548063z = r101;
        r102.setAlpha(0);
        r102.setStyle(Paint.Style.FILL);
        r102.setColor(r101.f264513l);
    }

    @Override // com.bytedance.lottie.model.layer.a, nz6.d
    public final void c(RectF r100, Matrix r101) {
        super.c(r100, r101);
        RectF r102 = this.f548059v;
        Layer r103 = this.f548063z;
        r102.set(0.0f, 0.0f, r103.f264511j, r103.f264512k);
        this.f264536l.mapRect(this.f548059v);
        r100.set(this.f548059v);
    }

    @Override // com.bytedance.lottie.model.layer.a, qz6.f
    public final <T> void f(T r100, xz6.c<T> r101) {
        super.f(r100, r101);
        if (r100 != n.f264576x) goto L8;
        if (r101 != null) goto L6;
        this.A = null;
        return;
    L6:
        this.A = new p(r101);
        return;
    }

    @Override // com.bytedance.lottie.model.layer.a
    public final void j(Canvas r110, Matrix r111, int r112) {
        int r100 = Color.alpha(this.f548063z.f264513l);
        if (r100 != 0) goto L5;
        return;
    L5:
        int r113 = (int) (((r112 / 255.0f) * (((r100 / 255.0f) * this.f264544t.f527231f.e().intValue()) / 100.0f)) * 255.0f);
        this.f548060w.setAlpha(r113);
        p r101 = this.A;
        if (r101 == null) goto L8;
        this.f548060w.setColorFilter((ColorFilter) r101.e());
    L8:
        if (r113 <= 0) goto L11;
        float[] r114 = this.f548061x;
        r114[0] = 0.0f;
        r114[1] = 0.0f;
        Layer r102 = this.f548063z;
        float r103 = r102.f264511j;
        r114[2] = r103;
        r114[3] = 0.0f;
        r114[4] = r103;
        float r104 = r102.f264512k;
        r114[5] = r104;
        r114[6] = 0.0f;
        r114[7] = r104;
        r111.mapPoints(r114);
        this.f548062y.reset();
        Path r115 = this.f548062y;
        float[] r116 = this.f548061x;
        r115.moveTo(r116[0], r116[1]);
        Path r117 = this.f548062y;
        float[] r118 = this.f548061x;
        r117.lineTo(r118[2], r118[3]);
        Path r119 = this.f548062y;
        float[] r120 = this.f548061x;
        r119.lineTo(r120[4], r120[5]);
        Path r121 = this.f548062y;
        float[] r122 = this.f548061x;
        r121.lineTo(r122[6], r122[7]);
        Path r123 = this.f548062y;
        float[] r124 = this.f548061x;
        r123.lineTo(r124[0], r124[1]);
        this.f548062y.close();
        r110.drawPath(this.f548062y, this.f548060w);
        return;
    }
}
