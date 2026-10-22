package i0;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes28.dex */
public final class g implements e, j0.a.InterfaceC6374a, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f487755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f487756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.a f487757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f487758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<m> f487759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j0.b f487760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j0.e f487761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j0.p f487762h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LottieDrawable f487763i;

    @Override // j0.a.InterfaceC6374a
    public final void a() {
        this.f487763i.invalidateSelf();
    }

    @Override // i0.c
    public final String getName() {
        return this.f487758d;
    }

    @Override // i0.c
    public final void b(List<c> r100, List<c> r101) {
        int r102 = 0;
    L4:
        if (r102 >= r101.size()) goto L9;
        c r103 = (c) ListProtector.get(r101, r102);
        if ((r103 instanceof m) == false) goto L8;
        ArrayList r104 = (ArrayList) this.f487759e;
        r104.add((m) r103);
    L8:
        r102 = r102 + 1;
        goto L4
    }

    @Override // i0.e
    public final void c(RectF r100, Matrix r101) {
        this.f487755a.reset();
        int r102 = 0;
    L4:
        if (r102 >= ((ArrayList) this.f487759e).size()) goto L6;
        this.f487755a.addPath(((m) ListProtector.get(this.f487759e, r102)).getPath(), r101);
        r102 = r102 + 1;
        goto L4
    L6:
        this.f487755a.computeBounds(r100, false);
        r100.set(r100.left - 1.0f, r100.top - 1.0f, r100.right + 1.0f, r100.bottom + 1.0f);
    }

    @Override // m0.f
    public final <T> void g(T r100, v0.c<T> r101) {
        if (r100 != com.airbnb.lottie.k.f24786a) goto L6;
        this.f487760f.k(r101);
        return;
    L6:
        if (r100 != com.airbnb.lottie.k.f24789d) goto L9;
        this.f487761g.k(r101);
        return;
    L9:
        if (r100 == com.airbnb.lottie.k.C) goto L11;
        return;
    L11:
        if (r0.c.a.f535397a == false) goto L15;
        j0.p r102 = this.f487762h;
        if (r102 == null) goto L15;
        ((ArrayList) this.f487757c.f24906t).remove(r102);
    L15:
        if (r101 != null) goto L17;
        this.f487762h = null;
        return;
    L17:
        j0.p r103 = new j0.p(r101);
        this.f487762h = r103;
        r103.a(this);
        this.f487757c.e(this.f487762h);
    }

    public g(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101, o0.h r102) {
        Path r103 = new Path();
        this.f487755a = r103;
        this.f487756b = new Paint(1);
        this.f487759e = new ArrayList();
        this.f487757c = r101;
        this.f487758d = r102.f521595c;
        this.f487763i = r100;
        if (r102.f521596d != null) goto L5;
    L9:
        this.f487760f = null;
        this.f487761g = null;
        return;
    L5:
        if (r102.f521597e == null) goto L9;
        r103.setFillType(r102.f521594b);
        j0.a<Integer, Integer> r104 = r102.f521596d.a();
        this.f487760f = (j0.b) r104;
        r104.a(this);
        r101.e(r104);
        j0.a<Integer, Integer> r105 = r102.f521597e.a();
        this.f487761g = (j0.e) r105;
        r105.a(this);
        r101.e(r105);
    }

    @Override // i0.e
    public final void d(Canvas r100, Matrix r101, int r102) {
        Set<String> r103 = com.airbnb.lottie.f.f24776a;
        this.f487756b.setColor(this.f487760f.g().intValue());
        int r104 = (int) ((((r102 / 255.0f) * this.f487761g.g().intValue()) / 100.0f) * 255.0f);
        Paint r105 = this.f487756b;
        u0.e.a r106 = u0.e.f548111a;
        int r107 = 0;
        r105.setAlpha(Math.max(0, Math.min(255, r104)));
        j0.p r108 = this.f487762h;
        if (r108 == null) goto L5;
        this.f487756b.setColorFilter((ColorFilter) r108.g());
    L5:
        this.f487755a.reset();
    L7:
        if (r107 >= ((ArrayList) this.f487759e).size()) goto L9;
        this.f487755a.addPath(((m) ListProtector.get(this.f487759e, r107)).getPath(), r101);
        r107 = r107 + 1;
        goto L7
    L9:
        r100.drawPath(this.f487755a, this.f487756b);
        com.airbnb.lottie.f.a();
    }

    @Override // m0.f
    public final void f(m0.e r100, int r101, List<m0.e> r102, m0.e r103) {
        u0.e.d(r100, r101, r102, r103, this);
    }
}
