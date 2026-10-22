package i0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class d implements e, m, j0.a.InterfaceC6374a, m0.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f487738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f487739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f487740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f487741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<c> f487742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LottieDrawable f487743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<m> f487744g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j0.o f487745h;

    @Override // j0.a.InterfaceC6374a
    public final void a() {
        this.f487743f.invalidateSelf();
    }

    public final List<m> e() {
        if (this.f487744g != null) goto L12;
        this.f487744g = new ArrayList();
        int r100 = 0;
    L6:
        if (r100 >= this.f487742e.size()) goto L12;
        c r101 = (c) ListProtector.get(this.f487742e, r100);
        if ((r101 instanceof m) == false) goto L10;
        this.f487744g.add((m) r101);
    L10:
        r100 = r100 + 1;
    L12:
        return this.f487744g;
    }

    @Override // i0.m
    public final Path getPath() {
        this.f487738a.reset();
        j0.o r100 = this.f487745h;
        if (r100 == null) goto L5;
        this.f487738a.set(r100.d());
    L5:
        this.f487739b.reset();
        int r101 = this.f487742e.size() - 1;
    L6:
        if (r101 < 0) goto L12;
        c r102 = (c) ListProtector.get(this.f487742e, r101);
        if ((r102 instanceof m) == false) goto L10;
        this.f487739b.addPath(((m) r102).getPath(), this.f487738a);
    L10:
        r101 = r101 - 1;
        goto L6
    L12:
        return this.f487739b;
    }

    @Override // i0.c
    public final String getName() {
        return this.f487741d;
    }

    @Override // i0.c
    public final void b(List<c> r100, List<c> r101) {
        ArrayList r102 = new ArrayList(r100.size() + this.f487742e.size());
        r102.addAll(r100);
        int r103 = this.f487742e.size() - 1;
    L3:
        if (r103 < 0) goto L5;
        c r104 = (c) ListProtector.get(this.f487742e, r103);
        r104.b(r102, this.f487742e.subList(0, r103));
        r102.add(r104);
        r103 = r103 - 1;
        goto L3
    }

    @Override // i0.e
    public final void c(RectF r100, Matrix r101) {
        this.f487738a.set(r101);
        j0.o r102 = this.f487745h;
        if (r102 == null) goto L5;
        this.f487738a.preConcat(r102.d());
    L5:
        this.f487740c.set(0.0f, 0.0f, 0.0f, 0.0f);
        int r103 = this.f487742e.size() - 1;
    L6:
        if (r103 < 0) goto L17;
        c r104 = (c) ListProtector.get(this.f487742e, r103);
        if ((r104 instanceof e) == false) goto L16;
        e r105 = (e) r104;
        r105.c(this.f487740c, this.f487738a);
        if (r0.c.a.f535397a == false) goto L13;
        r105.c(this.f487740c, this.f487738a);
        r100.union(this.f487740c);
        goto L16
    L13:
        if (r100.isEmpty() == false) goto L15;
        r100.set(this.f487740c);
        goto L16
    L15:
        r100.set(Math.min(r100.left, this.f487740c.left), Math.min(r100.top, this.f487740c.top), Math.max(r100.right, this.f487740c.right), Math.max(r100.bottom, this.f487740c.bottom));
    L16:
        r103 = r103 - 1;
        goto L6
    }

    @Override // m0.f
    public final <T> void g(T r100, v0.c<T> r101) {
        j0.o r102 = this.f487745h;
        if (r102 == null) goto L6;
        r102.c(r100, r101);
        return;
    }

    public d(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101, o0.i r102) {
        String r103 = r102.f521598a;
        List<o0.b> r104 = r102.f521599b;
        ArrayList r105 = new ArrayList(r104.size());
        int r106 = 0;
        int r107 = 0;
    L4:
        if (r107 >= r104.size()) goto L9;
        c r108 = ((o0.b) ListProtector.get(r104, r107)).a(r100, r101);
        if (r108 == null) goto L8;
        r105.add(r108);
    L8:
        r107 = r107 + 1;
        goto L4
    L9:
        List<o0.b> r109 = r102.f521599b;
    L11:
        if (r106 >= r109.size()) goto L16;
        o0.b r110 = (o0.b) ListProtector.get(r109, r106);
        if ((r110 instanceof n0.l) == true) goto L14;
        r106 = r106 + 1;
        goto L11
    L14:
        n0.l r111 = (n0.l) r110;
    L17:
        this(r100, r101, r103, r105, r111);
        return;
    L16:
        r111 = null;
        goto L17
    }

    @Override // i0.e
    public final void d(Canvas r100, Matrix r101, int r102) {
        this.f487738a.set(r101);
        j0.o r103 = this.f487745h;
        if (r103 == null) goto L5;
        this.f487738a.preConcat(r103.d());
        r102 = (int) ((((this.f487745h.f496783f.g().intValue() / 100.0f) * r102) / 255.0f) * 255.0f);
    L5:
        int r104 = this.f487742e.size();
    L6:
        r104 = r104 - 1;
        if (r104 < 0) goto L11;
        Object r105 = ListProtector.get(this.f487742e, r104);
        if ((r105 instanceof e) == false) goto L6;
        ((e) r105).d(r100, this.f487738a, r102);
        goto L6
    }

    @Override // m0.f
    public final void f(m0.e r100, int r101, List<m0.e> r102, m0.e r103) {
        if (r100.c(this.f487741d, r101) == true) goto L6;
        return;
    L6:
        if ("__container".equals(this.f487741d) == true) goto L12;
        String r104 = this.f487741d;
        r103.getClass();
        m0.e r105 = new m0.e(r103);
        r105.f511470a.add(r104);
        if (r100.a(this.f487741d, r101) == false) goto L10;
        m0.e r106 = new m0.e(r105);
        r106.f511471b = this;
        ((ArrayList) r102).add(r106);
    L10:
        r103 = r105;
    L12:
        if (r100.d(this.f487741d, r101) == false) goto L20;
        int r107 = r101 + r100.b(this.f487741d, r101);
        int r108 = 0;
    L15:
        if (r108 >= this.f487742e.size()) goto L24;
        c r109 = (c) ListProtector.get(this.f487742e, r108);
        if ((r109 instanceof m0.f) == false) goto L19;
        ((m0.f) r109).f(r100, r107, r102, r103);
    L19:
        r108 = r108 + 1;
        goto L15
    L24:
        return;
    }

    public d(LottieDrawable r100, com.airbnb.lottie.model.layer.a r101, String r102, List<c> r103, n0.l r104) {
        this.f487738a = new Matrix();
        this.f487739b = new Path();
        this.f487740c = new RectF();
        this.f487741d = r102;
        this.f487743f = r100;
        this.f487742e = r103;
        if (r104 == null) goto L5;
        j0.o r105 = new j0.o(r104);
        this.f487745h = r105;
        r105.a(r101);
        r105.b(this);
    L5:
        ArrayList r106 = new ArrayList();
        ArrayList r107 = (ArrayList) r103;
        int r108 = r107.size();
    L6:
        r108 = r108 - 1;
        if (r108 < 0) goto L11;
        c r109 = (c) ListProtector.get(r103, r108);
        if ((r109 instanceof j) == false) goto L6;
        r106.add((j) r109);
        goto L6
    L11:
        int r110 = r106.size();
    L12:
        r110 = r110 - 1;
        if (r110 < 0) goto L15;
        ((j) ListProtector.get(r106, r110)).e(r107.listIterator(r107.size()));
        goto L12
    }
}
