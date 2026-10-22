package i0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes28.dex */
public final class p implements e, m, j, j0.a.InterfaceC6374a, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f487821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f487822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LottieDrawable f487823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.a f487824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f487825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j0.c f487826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j0.c f487827g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j0.o f487828h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f487829i;

    @Override // j0.a.InterfaceC6374a
    public final void a() {
        this.f487823c.invalidateSelf();
    }

    @Override // i0.m
    public final Path getPath() {
        Path r100 = this.f487829i.getPath();
        this.f487822b.reset();
        float r101 = this.f487826f.g().floatValue();
        float r102 = this.f487827g.g().floatValue();
        int r103 = (int) r101;
    L3:
        r103 = r103 - 1;
        if (r103 < 0) goto L7;
        this.f487821a.set(this.f487828h.e(r103 + r102));
        this.f487822b.addPath(r100, this.f487821a);
        goto L3
    L7:
        return this.f487822b;
    }

    @Override // i0.c
    public final String getName() {
        return this.f487825e;
    }

    @Override // i0.j
    public final void e(ListIterator<c> r100) {
        if (this.f487829i == null) goto L6;
        return;
    L6:
        if (r100.hasPrevious() == false) goto L10;
        if (r100.previous() != this) goto L6;
    L10:
        ArrayList r101 = new ArrayList();
    L12:
        if (r100.hasPrevious() == false) goto L14;
        r101.add(r100.previous());
        r100.remove();
        goto L12
    L14:
        Collections.reverse(r101);
        this.f487829i = new d(this.f487823c, this.f487824d, "Repeater", r101, null);
    }

    @Override // i0.c
    public final void b(List<c> r100, List<c> r101) {
        this.f487829i.b(r100, r101);
    }

    @Override // i0.e
    public final void c(RectF r100, Matrix r101) {
        this.f487829i.c(r100, r101);
    }

    @Override // m0.f
    public final <T> void g(T r100, v0.c<T> r101) {
        if (this.f487828h.c(r100, r101) == false) goto L6;
        return;
    L6:
        if (r100 != com.airbnb.lottie.k.f24802q) goto L9;
        this.f487826f.k(r101);
        return;
    L9:
        if (r100 != com.airbnb.lottie.k.f24803r) goto L13;
        this.f487827g.k(r101);
        return;
    }

    public p(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101, o0.f r102) {
        this.f487821a = new Matrix();
        this.f487822b = new Path();
        this.f487823c = r100;
        this.f487824d = r101;
        this.f487825e = r102.f521586a;
        j0.a<Float, Float> r103 = r102.f521587b.a();
        this.f487826f = (j0.c) r103;
        r101.e(r103);
        r103.a(this);
        j0.a<Float, Float> r104 = r102.f521588c.a();
        this.f487827g = (j0.c) r104;
        r101.e(r104);
        r104.a(this);
        n0.l r105 = r102.f521589d;
        r105.getClass();
        j0.o r106 = new j0.o(r105);
        this.f487828h = r106;
        r106.a(r101);
        r106.b(this);
    }

    @Override // i0.e
    public final void d(Canvas r110, Matrix r111, int r112) {
        float r100 = this.f487826f.g().floatValue();
        float r101 = this.f487827g.g().floatValue();
        float r102 = this.f487828h.f496784g.g().floatValue() / 100.0f;
        float r103 = this.f487828h.f496785h.g().floatValue() / 100.0f;
        int r104 = (int) r100;
    L3:
        r104 = r104 - 1;
        if (r104 < 0) goto L6;
        this.f487821a.set(r111);
        float r105 = r104;
        this.f487821a.preConcat(this.f487828h.e(r105 + r101));
        u0.e.a r106 = u0.e.f548111a;
        this.f487829i.d(r110, this.f487821a, (int) (r112 * (((r105 / r100) * (r103 - r102)) + r102)));
        goto L3
    }

    @Override // m0.f
    public final void f(m0.e r100, int r101, List<m0.e> r102, m0.e r103) {
        u0.e.d(r100, r101, r102, r103, this);
    }
}
