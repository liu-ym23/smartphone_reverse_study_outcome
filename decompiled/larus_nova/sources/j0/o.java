package j0;

import android.graphics.Matrix;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes28.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f496778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f496779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a<?, PointF> f496780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f496781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f496782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f496783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f496784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f496785h;

    /* JADX WARN: Multi-variable type inference failed */
    public final Matrix d() {
        this.f496778a.reset();
        PointF r100 = this.f496780c.g();
        float r101 = r100.x;
        if (r101 == 0.0f) goto L5;
    L6:
        this.f496778a.preTranslate(r101, r100.y);
    L7:
        float r102 = this.f496782e.g().floatValue();
        if (r102 == 0.0f) goto L10;
        this.f496778a.preRotate(r102);
    L10:
        v0.d r103 = this.f496781d.g();
        float r104 = r103.f552293a;
        if (r104 == 1.0f) goto L13;
    L14:
        this.f496778a.preScale(r104, r103.f552294b);
    L15:
        PointF r105 = (PointF) this.f496779b.g();
        float r106 = r105.x;
        if (r106 == 0.0f) goto L18;
    L19:
        this.f496778a.preTranslate(-r106, -r105.y);
    L21:
        return this.f496778a;
    L18:
        if (r105.y == 0.0f) goto L21;
    L13:
        if (r103.f552294b == 1.0f) goto L15;
    L5:
        if (r100.y == 0.0f) goto L7;
        goto L6
    }

    public o(n0.l r100) {
        this.f496778a = new Matrix();
        this.f496779b = (f) r100.f516558a.a();
        this.f496780c = r100.f516559b.a();
        this.f496781d = (k) r100.f516560c.a();
        this.f496782e = (c) r100.f516561d.a();
        this.f496783f = (e) r100.f516562e.a();
        n0.b r101 = r100.f516563f;
        if (r101 == null) goto L5;
        this.f496784g = (c) r101.a();
    L6:
        n0.b r102 = r100.f516564g;
        if (r102 == null) goto L9;
        this.f496785h = (c) r102.a();
        return;
    L9:
        this.f496785h = null;
        return;
    L5:
        this.f496784g = null;
        goto L6
    }

    public final void a(com.airbnb.lottie.model.layer.a r100) {
        r100.e(this.f496779b);
        r100.e(this.f496780c);
        r100.e(this.f496781d);
        r100.e(this.f496782e);
        r100.e(this.f496783f);
        c r101 = this.f496784g;
        if (r101 == null) goto L5;
        r100.e(r101);
    L5:
        c r102 = this.f496785h;
        if (r102 == null) goto L9;
        r100.e(r102);
        return;
    }

    public final void b(a.InterfaceC6374a r100) {
        this.f496779b.a(r100);
        this.f496780c.a(r100);
        this.f496781d.a(r100);
        this.f496782e.a(r100);
        this.f496783f.a(r100);
        c r101 = this.f496784g;
        if (r101 == null) goto L5;
        r101.a(r100);
    L5:
        c r102 = this.f496785h;
        if (r102 == null) goto L9;
        r102.a(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Matrix e(float r110) {
        PointF r100 = this.f496780c.g();
        PointF r101 = (PointF) this.f496779b.g();
        v0.d r102 = this.f496781d.g();
        float r103 = this.f496782e.g().floatValue();
        this.f496778a.reset();
        this.f496778a.preTranslate(r100.x * r110, r100.y * r110);
        double r104 = r110;
        this.f496778a.preScale((float) Math.pow(r102.f552293a, r104), (float) Math.pow(r102.f552294b, r104));
        this.f496778a.preRotate(r103 * r110, r101.x, r101.y);
        return this.f496778a;
    }

    public final <T> boolean c(T r100, v0.c<T> r101) {
        if (r100 != com.airbnb.lottie.k.f24790e) goto L6;
        this.f496779b.k(r101);
        return true;
    L6:
        if (r100 != com.airbnb.lottie.k.f24791f) goto L9;
        this.f496780c.k(r101);
        return true;
    L9:
        if (r100 != com.airbnb.lottie.k.f24796k) goto L12;
        this.f496781d.k(r101);
        return true;
    L12:
        if (r100 != com.airbnb.lottie.k.f24797l) goto L15;
        this.f496782e.k(r101);
        return true;
    L15:
        if (r100 != com.airbnb.lottie.k.f24788c) goto L18;
        this.f496783f.k(r101);
        return true;
    L18:
        if (r100 != com.airbnb.lottie.k.f24810y) goto L23;
        c r102 = this.f496784g;
        if (r102 == null) goto L23;
        r102.k(r101);
        return true;
    L23:
        if (r100 != com.airbnb.lottie.k.f24811z) goto L29;
        c r103 = this.f496785h;
        if (r103 == null) goto L37;
        r103.k(r101);
        return true;
    L37:
        return false;
    L29:
        return false;
    }
}
