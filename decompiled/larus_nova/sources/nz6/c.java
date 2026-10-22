package nz6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements d, l, oz6.a.InterfaceC7134a, qz6.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f521445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f521446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f521447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f521448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f521449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LottieDrawable f521450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<l> f521451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final oz6.o f521452h;

    @Override // oz6.a.InterfaceC7134a
    public final void a() {
        this.f521450f.invalidateSelf();
    }

    public final List<l> e() {
        if (this.f521451g != null) goto L12;
        this.f521451g = new ArrayList();
        int r100 = 0;
    L6:
        if (r100 >= this.f521449e.size()) goto L12;
        b r101 = (b) ListProtector.get(this.f521449e, r100);
        if ((r101 instanceof l) == false) goto L10;
        this.f521451g.add((l) r101);
    L10:
        r100 = r100 + 1;
    L12:
        return this.f521451g;
    }

    @Override // nz6.l
    public final Path getPath() {
        this.f521445a.reset();
        oz6.o r100 = this.f521452h;
        if (r100 == null) goto L5;
        this.f521445a.set(r100.d());
    L5:
        this.f521446b.reset();
        int r101 = this.f521449e.size() - 1;
    L6:
        if (r101 < 0) goto L12;
        b r102 = (b) ListProtector.get(this.f521449e, r101);
        if ((r102 instanceof l) == false) goto L10;
        this.f521446b.addPath(((l) r102).getPath(), this.f521445a);
    L10:
        r101 = r101 - 1;
        goto L6
    L12:
        return this.f521446b;
    }

    @Override // nz6.b
    public final String getName() {
        return this.f521448d;
    }

    @Override // nz6.b
    public final void b(List<b> r100, List<b> r101) {
        ArrayList r102 = new ArrayList(r100.size() + this.f521449e.size());
        r102.addAll(r100);
        int r103 = this.f521449e.size() - 1;
    L3:
        if (r103 < 0) goto L5;
        b r104 = (b) ListProtector.get(this.f521449e, r103);
        r104.b(r102, this.f521449e.subList(0, r103));
        r102.add(r104);
        r103 = r103 - 1;
        goto L3
    }

    @Override // nz6.d
    public final void c(RectF r100, Matrix r101) {
        this.f521445a.set(r101);
        oz6.o r102 = this.f521452h;
        if (r102 == null) goto L5;
        this.f521445a.preConcat(r102.d());
    L5:
        this.f521447c.set(0.0f, 0.0f, 0.0f, 0.0f);
        int r103 = this.f521449e.size() - 1;
    L6:
        if (r103 < 0) goto L14;
        b r104 = (b) ListProtector.get(this.f521449e, r103);
        if ((r104 instanceof d) == false) goto L13;
        ((d) r104).c(this.f521447c, this.f521445a);
        if (r100.isEmpty() == false) goto L12;
        r100.set(this.f521447c);
        goto L13
    L12:
        r100.set(Math.min(r100.left, this.f521447c.left), Math.min(r100.top, this.f521447c.top), Math.max(r100.right, this.f521447c.right), Math.max(r100.bottom, this.f521447c.bottom));
    L13:
        r103 = r103 - 1;
        goto L6
    }

    @Override // qz6.f
    public final <T> void f(T r100, xz6.c<T> r101) {
        oz6.o r102 = this.f521452h;
        if (r102 == null) goto L6;
        r102.c(r100, r101);
        return;
    }

    public c(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101, sz6.i r102) {
        String r103 = r102.f543977a;
        List<sz6.b> r104 = r102.f543978b;
        ArrayList r105 = new ArrayList(r104.size());
        int r106 = 0;
        int r107 = 0;
    L4:
        if (r107 >= r104.size()) goto L9;
        b r108 = ((sz6.b) ListProtector.get(r104, r107)).a(r100, r101);
        if (r108 == null) goto L8;
        r105.add(r108);
    L8:
        r107 = r107 + 1;
        goto L4
    L9:
        List<sz6.b> r109 = r102.f543978b;
    L11:
        if (r106 >= r109.size()) goto L16;
        sz6.b r110 = (sz6.b) ListProtector.get(r109, r106);
        if ((r110 instanceof rz6.l) == true) goto L14;
        r106 = r106 + 1;
        goto L11
    L14:
        rz6.l r111 = (rz6.l) r110;
    L17:
        this(r100, r101, r103, r105, r111);
        return;
    L16:
        r111 = null;
        goto L17
    }

    @Override // nz6.d
    public final void d(Canvas r100, Matrix r101, int r102) {
        this.f521445a.set(r101);
        oz6.o r103 = this.f521452h;
        if (r103 == null) goto L5;
        this.f521445a.preConcat(r103.d());
        r102 = (int) ((((this.f521452h.f527231f.e().intValue() / 100.0f) * r102) / 255.0f) * 255.0f);
    L5:
        int r104 = this.f521449e.size();
    L6:
        r104 = r104 - 1;
        if (r104 < 0) goto L11;
        Object r105 = ListProtector.get(this.f521449e, r104);
        if ((r105 instanceof d) == false) goto L6;
        ((d) r105).d(r100, this.f521445a, r102);
        goto L6
    }

    @Override // qz6.f
    public final void g(qz6.e r100, int r101, List<qz6.e> r102, qz6.e r103) {
        if (r100.c(this.f521448d, r101) == true) goto L6;
        return;
    L6:
        if ("__container".equals(this.f521448d) == true) goto L12;
        String r104 = this.f521448d;
        r103.getClass();
        qz6.e r105 = new qz6.e(r103);
        r105.f535375a.add(r104);
        if (r100.a(this.f521448d, r101) == false) goto L10;
        qz6.e r106 = new qz6.e(r105);
        r106.f535376b = this;
        ((ArrayList) r102).add(r106);
    L10:
        r103 = r105;
    L12:
        if (r100.d(this.f521448d, r101) == false) goto L20;
        int r107 = r101 + r100.b(this.f521448d, r101);
        int r108 = 0;
    L15:
        if (r108 >= this.f521449e.size()) goto L24;
        b r109 = (b) ListProtector.get(this.f521449e, r108);
        if ((r109 instanceof qz6.f) == false) goto L19;
        ((qz6.f) r109).g(r100, r107, r102, r103);
    L19:
        r108 = r108 + 1;
        goto L15
    L24:
        return;
    }

    public c(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101, String r102, List<b> r103, rz6.l r104) {
        this.f521445a = new Matrix();
        this.f521446b = new Path();
        this.f521447c = new RectF();
        this.f521448d = r102;
        this.f521450f = r100;
        this.f521449e = r103;
        if (r104 == null) goto L5;
        oz6.o r105 = new oz6.o(r104);
        this.f521452h = r105;
        r105.a(r101);
        r105.b(this);
    L5:
        ArrayList r106 = new ArrayList();
        ArrayList r107 = (ArrayList) r103;
        int r108 = r107.size();
    L6:
        r108 = r108 - 1;
        if (r108 < 0) goto L11;
        b r109 = (b) ListProtector.get(r103, r108);
        if ((r109 instanceof i) == false) goto L6;
        r106.add((i) r109);
        goto L6
    L11:
        int r110 = r106.size();
    L12:
        r110 = r110 - 1;
        if (r110 < 0) goto L15;
        ((i) ListProtector.get(r106, r110)).e(r107.listIterator(r107.size()));
        goto L12
    }
}
