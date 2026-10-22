package nz6;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.model.content.GradientType;
import com.ss.ttvideoengine.TTVideoEngineInterface;

/* JADX INFO: loaded from: classes21.dex */
public final class h extends a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f521487o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f521488p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f521489q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RectF f521490r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final GradientType f521491s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f521492t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final oz6.d f521493u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final oz6.j f521494v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final oz6.j f521495w;

    public final int e() {
        int r100 = Math.round(this.f521494v.f527199d * this.f521492t);
        int r101 = Math.round(this.f521495w.f527199d * this.f521492t);
        int r102 = Math.round(this.f521493u.f527199d * this.f521492t);
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

    @Override // nz6.b
    public final String getName() {
        return this.f521487o;
    }

    public h(LottieDrawable r110, com.bytedance.lottie.model.layer.a r111, com.bytedance.lottie.model.content.a r112) {
        super(r110, r111, r112.f264497h.toPaintCap(), r112.f264498i.toPaintJoin(), r112.f264499j, r112.f264493d, r112.f264496g, r112.f264500k, r112.f264501l);
        this.f521488p = new LongSparseArray();
        this.f521489q = new LongSparseArray();
        this.f521490r = new RectF();
        this.f521487o = r112.f264490a;
        this.f521491s = r112.f264491b;
        this.f521492t = (int) (r110.f264394b.b() / 32.0f);
        oz6.a<sz6.c, sz6.c> r113 = r112.f264492c.a();
        this.f521493u = (oz6.d) r113;
        r113.a(this);
        r111.e(r113);
        oz6.a<PointF, PointF> r114 = r112.f264494e.a();
        this.f521494v = (oz6.j) r114;
        r114.a(this);
        r111.e(r114);
        oz6.a<PointF, PointF> r115 = r112.f264495f.a();
        this.f521495w = (oz6.j) r115;
        r115.a(this);
        r111.e(r115);
    }

    @Override // nz6.a, nz6.d
    public final void d(Canvas r110, Matrix r111, int r210) {
        c(this.f521490r, r111);
        if (this.f521491s != GradientType.Linear) goto L9;
        Paint r100 = this.f521437i;
        long r101 = e();
        LinearGradient r102 = this.f521488p.get(r101);
        if (r102 != null) goto L8;
        PointF r103 = this.f521494v.e();
        PointF r104 = this.f521495w.e();
        sz6.c r105 = this.f521493u.e();
        int[] r112 = r105.f543953b;
        float[] r113 = r105.f543952a;
        RectF r106 = this.f521490r;
        int r107 = (int) ((r106.left + (r106.width() / 2.0f)) + r103.x);
        RectF r108 = this.f521490r;
        int r109 = (int) ((r108.top + (r108.height() / 2.0f)) + r103.y);
        RectF r114 = this.f521490r;
        int r115 = (int) ((r114.left + (r114.width() / 2.0f)) + r104.x);
        RectF r116 = this.f521490r;
        LinearGradient r117 = new LinearGradient(r107, r109, r115, (int) ((r116.top + (r116.height() / 2.0f)) + r104.y), r112, r113, Shader.TileMode.CLAMP);
        this.f521488p.put(r101, r117);
        r102 = r117;
    L8:
        r100.setShader(r102);
    L14:
        super.d(r110, r111, r210);
        return;
    L9:
        Paint r118 = this.f521437i;
        long r119 = e();
        RadialGradient r120 = this.f521489q.get(r119);
        if (r120 != null) goto L13;
        PointF r121 = this.f521494v.e();
        PointF r122 = this.f521495w.e();
        sz6.c r123 = this.f521493u.e();
        int[] r124 = r123.f543953b;
        float[] r125 = r123.f543952a;
        RectF r126 = this.f521490r;
        int r127 = (int) ((r126.left + (r126.width() / 2.0f)) + r121.x);
        RectF r128 = this.f521490r;
        int r129 = (int) ((r128.top + (r128.height() / 2.0f)) + r121.y);
        RectF r130 = this.f521490r;
        int r131 = (int) ((r130.left + (r130.width() / 2.0f)) + r122.x);
        RectF r132 = this.f521490r;
        RadialGradient r133 = new RadialGradient(r127, r129, (float) Math.hypot(r131 - r127, ((int) ((r132.top + (r132.height() / 2.0f)) + r122.y)) - r129), r124, r125, Shader.TileMode.CLAMP);
        this.f521489q.put(r119, r133);
        r120 = r133;
    L13:
        r118.setShader(r120);
        goto L14
    }
}
