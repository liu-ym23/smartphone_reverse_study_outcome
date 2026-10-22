package i0;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.GradientType;
import com.ss.ttvideoengine.TTVideoEngineInterface;

/* JADX INFO: loaded from: classes28.dex */
public final class i extends a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f487781o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f487782p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f487783q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RectF f487784r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final GradientType f487785s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f487786t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final j0.d f487787u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final j0.j f487788v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final j0.j f487789w;

    public final int e() {
        int r100 = Math.round(this.f487788v.f496749e * this.f487786t);
        int r101 = Math.round(this.f487789w.f496749e * this.f487786t);
        int r102 = Math.round(this.f487787u.f496749e * this.f487786t);
        if (r100 == 0) goto L5;
        int r103 = r100 * TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER;
    L6:
        if (r101 == 0) goto L8;
        r103 = (r103 * 31) * r101;
    L8:
        if (r102 != 0) goto L10;
        return r103;
    L10:
        return (r103 * 31) * r102;
    L5:
        r103 = 17;
        goto L6
    }

    @Override // i0.c
    public final String getName() {
        return this.f487781o;
    }

    public i(LottieDrawable r110, com.airbnb.lottie.model.layer.a r111, com.airbnb.lottie.model.content.a r112) {
        super(r110, r111, r112.f24859h.toPaintCap(), r112.f24860i.toPaintJoin(), r112.f24861j, r112.f24855d, r112.f24858g, r112.f24862k, r112.f24863l);
        this.f487782p = new LongSparseArray();
        this.f487783q = new LongSparseArray();
        this.f487784r = new RectF();
        this.f487781o = r112.f24852a;
        this.f487785s = r112.f24853b;
        this.f487786t = (int) (r110.f24725b.getDuration() / 32.0f);
        j0.a<o0.c, o0.c> r113 = r112.f24854c.a();
        this.f487787u = (j0.d) r113;
        r113.a(this);
        r111.e(r113);
        j0.a<PointF, PointF> r114 = r112.f24856e.a();
        this.f487788v = (j0.j) r114;
        r114.a(this);
        r111.e(r114);
        j0.a<PointF, PointF> r115 = r112.f24857f.a();
        this.f487789w = (j0.j) r115;
        r115.a(this);
        r111.e(r115);
    }

    @Override // i0.a, i0.e
    public final void d(Canvas r110, Matrix r111, int r210) {
        c(this.f487784r, r111);
        if (this.f487785s != GradientType.Linear) goto L9;
        Paint r100 = this.f487729i;
        long r101 = e();
        LinearGradient r102 = this.f487782p.get(r101);
        if (r102 != null) goto L8;
        PointF r103 = this.f487788v.g();
        PointF r104 = this.f487789w.g();
        o0.c r105 = this.f487787u.g();
        int[] r112 = r105.f521574b;
        float[] r113 = r105.f521573a;
        RectF r106 = this.f487784r;
        int r107 = (int) ((r106.left + (r106.width() / 2.0f)) + r103.x);
        RectF r108 = this.f487784r;
        int r109 = (int) ((r108.top + (r108.height() / 2.0f)) + r103.y);
        RectF r114 = this.f487784r;
        int r115 = (int) ((r114.left + (r114.width() / 2.0f)) + r104.x);
        RectF r116 = this.f487784r;
        LinearGradient r117 = new LinearGradient(r107, r109, r115, (int) ((r116.top + (r116.height() / 2.0f)) + r104.y), r112, r113, Shader.TileMode.CLAMP);
        this.f487782p.put(r101, r117);
        r102 = r117;
    L8:
        r100.setShader(r102);
    L14:
        super.d(r110, r111, r210);
        return;
    L9:
        Paint r118 = this.f487729i;
        long r119 = e();
        RadialGradient r120 = this.f487783q.get(r119);
        if (r120 != null) goto L13;
        PointF r121 = this.f487788v.g();
        PointF r122 = this.f487789w.g();
        o0.c r123 = this.f487787u.g();
        int[] r124 = r123.f521574b;
        float[] r125 = r123.f521573a;
        RectF r126 = this.f487784r;
        int r127 = (int) ((r126.left + (r126.width() / 2.0f)) + r121.x);
        RectF r128 = this.f487784r;
        int r129 = (int) ((r128.top + (r128.height() / 2.0f)) + r121.y);
        RectF r130 = this.f487784r;
        int r131 = (int) ((r130.left + (r130.width() / 2.0f)) + r122.x);
        RectF r132 = this.f487784r;
        RadialGradient r133 = new RadialGradient(r127, r129, (float) Math.hypot(r131 - r127, ((int) ((r132.top + (r132.height() / 2.0f)) + r122.y)) - r129), r124, r125, Shader.TileMode.CLAMP);
        this.f487783q.put(r119, r133);
        r120 = r133;
    L13:
        r118.setShader(r120);
        goto L14
    }
}
