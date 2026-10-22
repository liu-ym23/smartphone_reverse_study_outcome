package nz6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.lottie.LottieDrawable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes21.dex */
public final class o implements d, l, i, oz6.a.InterfaceC7134a, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f521525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f521526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LottieDrawable f521527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.lottie.model.layer.a f521528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f521529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final oz6.c f521530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final oz6.c f521531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final oz6.o f521532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f521533i;

    @Override // oz6.a.InterfaceC7134a
    public final void a() {
        this.f521527c.invalidateSelf();
    }

    @Override // nz6.l
    public final Path getPath() {
        Path r100 = this.f521533i.getPath();
        this.f521526b.reset();
        float r101 = this.f521530f.e().floatValue();
        float r102 = this.f521531g.e().floatValue();
        int r103 = (int) r101;
    L3:
        r103 = r103 - 1;
        if (r103 < 0) goto L7;
        this.f521525a.set(this.f521532h.e(r103 + r102));
        this.f521526b.addPath(r100, this.f521525a);
        goto L3
    L7:
        return this.f521526b;
    }

    @Override // nz6.b
    public final String getName() {
        return this.f521529e;
    }

    @Override // nz6.i
    public final void e(ListIterator<b> r100) {
        if (this.f521533i == null) goto L6;
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
        this.f521533i = new c(this.f521527c, this.f521528d, "Repeater", r101, null);
    }

    @Override // nz6.b
    public final void b(List<b> r100, List<b> r101) {
        this.f521533i.b(r100, r101);
    }

    @Override // nz6.d
    public final void c(RectF r100, Matrix r101) {
        this.f521533i.c(r100, r101);
    }

    @Override // qz6.f
    public final <T> void f(T r100, xz6.c<T> r101) {
        if (this.f521532h.c(r100, r101) == false) goto L6;
        return;
    L6:
        if (r100 != com.bytedance.lottie.n.f264565m) goto L9;
        this.f521530f.i(r101);
        return;
    L9:
        if (r100 != com.bytedance.lottie.n.f264566n) goto L13;
        this.f521531g.i(r101);
        return;
    }

    public o(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101, sz6.f r102) {
        this.f521525a = new Matrix();
        this.f521526b = new Path();
        this.f521527c = r100;
        this.f521528d = r101;
        this.f521529e = r102.f543965a;
        oz6.a<Float, Float> r103 = r102.f543966b.a();
        this.f521530f = (oz6.c) r103;
        r101.e(r103);
        r103.a(this);
        oz6.a<Float, Float> r104 = r102.f543967c.a();
        this.f521531g = (oz6.c) r104;
        r101.e(r104);
        r104.a(this);
        rz6.l r105 = r102.f543968d;
        r105.getClass();
        oz6.o r106 = new oz6.o(r105);
        this.f521532h = r106;
        r106.a(r101);
        r106.b(this);
    }

    @Override // nz6.d
    public final void d(Canvas r110, Matrix r111, int r112) {
        float r100 = this.f521530f.e().floatValue();
        float r101 = this.f521531g.e().floatValue();
        float r102 = this.f521532h.f527232g.e().floatValue() / 100.0f;
        float r103 = this.f521532h.f527233h.e().floatValue() / 100.0f;
        int r104 = (int) r100;
    L3:
        r104 = r104 - 1;
        if (r104 < 0) goto L6;
        this.f521525a.set(r111);
        float r105 = r104;
        this.f521525a.preConcat(this.f521532h.e(r105 + r101));
        this.f521533i.d(r110, this.f521525a, (int) (r112 * (((r105 / r100) * (r103 - r102)) + r102)));
        goto L3
    }

    @Override // qz6.f
    public final void g(qz6.e r100, int r101, List<qz6.e> r102, qz6.e r103) {
        wz6.f.d(r100, r101, r102, r103, this);
    }
}
