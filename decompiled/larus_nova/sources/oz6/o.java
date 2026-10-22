package oz6;

import android.graphics.Matrix;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes21.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f527226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f527227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a<?, PointF> f527228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f527229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f527230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f527231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f527232g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f527233h;

    /* JADX WARN: Multi-variable type inference failed */
    public final Matrix d() {
        this.f527226a.reset();
        PointF r100 = this.f527228c.e();
        float r101 = r100.x;
        if (r101 == 0.0f) goto L5;
    L6:
        this.f527226a.preTranslate(r101, r100.y);
    L7:
        float r102 = this.f527230e.e().floatValue();
        if (r102 == 0.0f) goto L10;
        this.f527226a.preRotate(r102);
    L10:
        xz6.d r103 = this.f527229d.e();
        float r104 = r103.f565540a;
        if (r104 == 1.0f) goto L13;
    L14:
        this.f527226a.preScale(r104, r103.f565541b);
    L15:
        Object[] r105 = xz6.d.a.f565542b.f561955a;
        if (r105[0] != null) goto L19;
        r105[0] = r103;
    L24:
        PointF r106 = (PointF) this.f527227b.e();
        float r107 = r106.x;
        if (r107 == 0.0f) goto L27;
    L28:
        this.f527226a.preTranslate(-r107, -r106.y);
    L30:
        return this.f527226a;
    L27:
        if (r106.y == 0.0f) goto L30;
    L19:
        if (r105[1] != null) goto L22;
        r105[1] = r103;
        goto L24
    L22:
        if (r105[2] != null) goto L24;
        r105[2] = r103;
        goto L24
    L13:
        if (r103.f565541b == 1.0f) goto L15;
    L5:
        if (r100.y == 0.0f) goto L7;
        goto L6
    }

    public o(rz6.l r100) {
        this.f527226a = new Matrix();
        this.f527227b = (f) r100.f539970a.a();
        this.f527228c = r100.f539971b.a();
        this.f527229d = (k) r100.f539972c.a();
        this.f527230e = (c) r100.f539973d.a();
        this.f527231f = (e) r100.f539974e.a();
        rz6.b r101 = r100.f539975f;
        if (r101 == null) goto L5;
        this.f527232g = (c) r101.a();
    L6:
        rz6.b r102 = r100.f539976g;
        if (r102 == null) goto L9;
        this.f527233h = (c) r102.a();
        return;
    L9:
        this.f527233h = null;
        return;
    L5:
        this.f527232g = null;
        goto L6
    }

    public final void a(com.bytedance.lottie.model.layer.a r100) {
        r100.e(this.f527227b);
        r100.e(this.f527228c);
        r100.e(this.f527229d);
        r100.e(this.f527230e);
        r100.e(this.f527231f);
        c r101 = this.f527232g;
        if (r101 == null) goto L5;
        r100.e(r101);
    L5:
        c r102 = this.f527233h;
        if (r102 == null) goto L9;
        r100.e(r102);
        return;
    }

    public final void b(a.InterfaceC7134a r100) {
        this.f527227b.a(r100);
        this.f527228c.a(r100);
        this.f527229d.a(r100);
        this.f527230e.a(r100);
        this.f527231f.a(r100);
        c r101 = this.f527232g;
        if (r101 == null) goto L5;
        r101.a(r100);
    L5:
        c r102 = this.f527233h;
        if (r102 == null) goto L9;
        r102.a(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Matrix e(float r110) {
        PointF r100 = this.f527228c.e();
        PointF r101 = (PointF) this.f527227b.e();
        xz6.d r102 = this.f527229d.e();
        float r103 = this.f527230e.e().floatValue();
        this.f527226a.reset();
        this.f527226a.preTranslate(r100.x * r110, r100.y * r110);
        double r104 = r110;
        this.f527226a.preScale((float) Math.pow(r102.f565540a, r104), (float) Math.pow(r102.f565541b, r104));
        this.f527226a.preRotate(r103 * r110, r101.x, r101.y);
        return this.f527226a;
    }

    public final <T> boolean c(T r100, xz6.c<T> r101) {
        if (r100 != com.bytedance.lottie.n.f264557e) goto L6;
        this.f527227b.i(r101);
        return true;
    L6:
        if (r100 != com.bytedance.lottie.n.f264558f) goto L9;
        this.f527228c.i(r101);
        return true;
    L9:
        if (r100 != com.bytedance.lottie.n.f264561i) goto L12;
        this.f527229d.i(r101);
        return true;
    L12:
        if (r100 != com.bytedance.lottie.n.f264562j) goto L15;
        this.f527230e.i(r101);
        return true;
    L15:
        if (r100 != com.bytedance.lottie.n.f264555c) goto L18;
        this.f527231f.i(r101);
        return true;
    L18:
        if (r100 != com.bytedance.lottie.n.f264573u) goto L23;
        c r102 = this.f527232g;
        if (r102 == null) goto L23;
        r102.i(r101);
        return true;
    L23:
        if (r100 != com.bytedance.lottie.n.f264574v) goto L29;
        c r103 = this.f527233h;
        if (r103 == null) goto L37;
        r103.i(r101);
        return true;
    L37:
        return false;
    L29:
        return false;
    }
}
