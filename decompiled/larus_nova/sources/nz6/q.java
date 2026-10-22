package nz6;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.model.content.ShapeStroke;

/* JADX INFO: loaded from: classes21.dex */
public final class q extends a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.lottie.model.layer.a f521539o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f521540p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final oz6.b f521541q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public oz6.p f521542r;

    @Override // nz6.b
    public final String getName() {
        return this.f521540p;
    }

    @Override // nz6.a, qz6.f
    public final <T> void f(T r100, xz6.c<T> r101) {
        super.f(r100, r101);
        if (r100 != com.bytedance.lottie.n.f264554b) goto L6;
        this.f521541q.i(r101);
        return;
    L6:
        if (r100 != com.bytedance.lottie.n.f264576x) goto L12;
        if (r101 != null) goto L9;
        this.f521542r = null;
        return;
    L9:
        oz6.p r102 = new oz6.p(r101);
        this.f521542r = r102;
        r102.a(this);
        this.f521539o.e(this.f521541q);
        return;
    }

    public q(LottieDrawable r110, com.bytedance.lottie.model.layer.a r111, ShapeStroke r112) {
        super(r110, r111, r112.f264478g.toPaintCap(), r112.f264479h.toPaintJoin(), r112.f264480i, r112.f264476e, r112.f264477f, r112.f264474c, r112.f264473b);
        this.f521539o = r111;
        this.f521540p = r112.f264472a;
        oz6.a<Integer, Integer> r113 = r112.f264475d.a();
        this.f521541q = (oz6.b) r113;
        r113.a(this);
        r111.e(r113);
    }

    @Override // nz6.a, nz6.d
    public final void d(Canvas r100, Matrix r101, int r102) {
        this.f521437i.setColor(this.f521541q.e().intValue());
        oz6.p r103 = this.f521542r;
        if (r103 == null) goto L5;
        this.f521437i.setColorFilter((ColorFilter) r103.e());
    L5:
        super.d(r100, r101, r102);
    }
}
