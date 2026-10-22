package nz6;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements d, oz6.a.InterfaceC7134a, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f521461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f521462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.lottie.model.layer.a f521463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f521464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<l> f521465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final oz6.b f521466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final oz6.e f521467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public oz6.p f521468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LottieDrawable f521469i;

    @Override // oz6.a.InterfaceC7134a
    public final void a() {
        this.f521469i.invalidateSelf();
    }

    @Override // nz6.b
    public final String getName() {
        return this.f521464d;
    }

    @Override // nz6.b
    public final void b(List<b> r100, List<b> r101) {
        int r102 = 0;
    L4:
        if (r102 >= r101.size()) goto L9;
        b r103 = (b) ListProtector.get(r101, r102);
        if ((r103 instanceof l) == false) goto L8;
        ArrayList r104 = (ArrayList) this.f521465e;
        r104.add((l) r103);
    L8:
        r102 = r102 + 1;
        goto L4
    }

    @Override // nz6.d
    public final void c(RectF r100, Matrix r101) {
        this.f521461a.reset();
        int r102 = 0;
    L4:
        if (r102 >= ((ArrayList) this.f521465e).size()) goto L6;
        this.f521461a.addPath(((l) ListProtector.get(this.f521465e, r102)).getPath(), r101);
        r102 = r102 + 1;
        goto L4
    L6:
        this.f521461a.computeBounds(r100, false);
        r100.set(r100.left - 1.0f, r100.top - 1.0f, r100.right + 1.0f, r100.bottom + 1.0f);
    }

    @Override // qz6.f
    public final <T> void f(T r100, xz6.c<T> r101) {
        if (r100 != com.bytedance.lottie.n.f264553a) goto L6;
        this.f521466f.i(r101);
        return;
    L6:
        if (r100 != com.bytedance.lottie.n.f264556d) goto L9;
        this.f521467g.i(r101);
        return;
    L9:
        if (r100 != com.bytedance.lottie.n.f264576x) goto L16;
        if (r101 != null) goto L12;
        this.f521468h = null;
        return;
    L12:
        oz6.p r102 = new oz6.p(r101);
        this.f521468h = r102;
        r102.a(this);
        this.f521463c.e(this.f521468h);
        return;
    }

    public f(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101, sz6.h r102) {
        Path r103 = new Path();
        this.f521461a = r103;
        this.f521462b = new Paint(1);
        this.f521465e = new ArrayList();
        this.f521463c = r101;
        this.f521464d = r102.f543974c;
        this.f521469i = r100;
        if (r102.f543975d != null) goto L5;
    L9:
        this.f521466f = null;
        this.f521467g = null;
        return;
    L5:
        if (r102.f543976e == null) goto L9;
        r103.setFillType(r102.f543973b);
        oz6.a<Integer, Integer> r104 = r102.f543975d.a();
        this.f521466f = (oz6.b) r104;
        r104.a(this);
        r101.e(r104);
        oz6.a<Integer, Integer> r105 = r102.f543976e.a();
        this.f521467g = (oz6.e) r105;
        r105.a(this);
        r101.e(r105);
    }

    @Override // nz6.d
    public final void d(Canvas r100, Matrix r101, int r102) {
        Set<String> r103 = com.bytedance.lottie.c.f264422a;
        this.f521462b.setColor(this.f521466f.e().intValue());
        int r104 = 0;
        this.f521462b.setAlpha(Math.max(0, Math.min(255, (int) ((((r102 / 255.0f) * this.f521467g.e().intValue()) / 100.0f) * 255.0f))));
        oz6.p r105 = this.f521468h;
        if (r105 == null) goto L5;
        this.f521462b.setColorFilter((ColorFilter) r105.e());
    L5:
        this.f521461a.reset();
    L7:
        if (r104 >= ((ArrayList) this.f521465e).size()) goto L9;
        this.f521461a.addPath(((l) ListProtector.get(this.f521465e, r104)).getPath(), r101);
        r104 = r104 + 1;
        goto L7
    L9:
        r100.drawPath(this.f521461a, this.f521462b);
        com.bytedance.lottie.c.a();
    }

    @Override // qz6.f
    public final void g(qz6.e r100, int r101, List<qz6.e> r102, qz6.e r103) {
        wz6.f.d(r100, r101, r102, r103, this);
    }
}
