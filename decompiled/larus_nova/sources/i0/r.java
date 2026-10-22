package i0;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public final class r extends a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.a f487836o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f487837p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final j0.b f487838q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public j0.p f487839r;

    @Override // i0.c
    public final String getName() {
        return this.f487837p;
    }

    @Override // i0.a, m0.f
    public final <T> void g(T r100, v0.c<T> r101) {
        super.g(r100, r101);
        if (r100 != com.airbnb.lottie.k.f24787b) goto L6;
        this.f487838q.k(r101);
        return;
    L6:
        if (r100 == com.airbnb.lottie.k.C) goto L8;
        return;
    L8:
        if (r0.c.a.f535397a == false) goto L12;
        j0.p r102 = this.f487839r;
        if (r102 == null) goto L12;
        ((ArrayList) this.f487836o.f24906t).remove(r102);
    L12:
        if (r101 != null) goto L14;
        this.f487839r = null;
        return;
    L14:
        j0.p r103 = new j0.p(r101);
        this.f487839r = r103;
        r103.a(this);
        this.f487836o.e(this.f487838q);
    }

    public r(LottieDrawable r110, com.airbnb.lottie.model.layer.a r111, ShapeStroke r112) {
        super(r110, r111, r112.f24840g.toPaintCap(), r112.f24841h.toPaintJoin(), r112.f24842i, r112.f24838e, r112.f24839f, r112.f24836c, r112.f24835b);
        this.f487836o = r111;
        this.f487837p = r112.f24834a;
        j0.a<Integer, Integer> r113 = r112.f24837d.a();
        this.f487838q = (j0.b) r113;
        r113.a(this);
        r111.e(r113);
    }

    @Override // i0.a, i0.e
    public final void d(Canvas r100, Matrix r101, int r102) {
        this.f487729i.setColor(this.f487838q.g().intValue());
        j0.p r103 = this.f487839r;
        if (r103 == null) goto L5;
        this.f487729i.setColorFilter((ColorFilter) r103.g());
    L5:
        super.d(r100, r101, r102);
    }
}
