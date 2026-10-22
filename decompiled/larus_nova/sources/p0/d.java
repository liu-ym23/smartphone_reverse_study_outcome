package p0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.Layer;
import java.util.Collections;
import java.util.List;
import o0.i;

/* JADX INFO: loaded from: classes28.dex */
public final class d extends com.airbnb.lottie.model.layer.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i0.d f527265w;

    public d(LottieDrawable r100, Layer r101) {
        super(r100, r101);
        i0.d r102 = new i0.d(r100, this, new i("__container", r101.f24864a));
        this.f527265w = r102;
        r102.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.a, i0.e
    public final void c(RectF r100, Matrix r101) {
        super.c(r100, r101);
        this.f527265w.c(r100, this.f24898l);
    }

    @Override // com.airbnb.lottie.model.layer.a
    public final void l(RectF r100, Matrix r101) {
        super.l(r100, r101);
        this.f527265w.c(r100, this.f24898l);
    }

    @Override // com.airbnb.lottie.model.layer.a
    public final void k(Canvas r100, Matrix r101, int r102) {
        this.f527265w.d(r100, r101, r102);
    }

    @Override // com.airbnb.lottie.model.layer.a
    public final void p(m0.e r100, int r101, List<m0.e> r102, m0.e r103) {
        this.f527265w.f(r100, r101, r102, r103);
    }
}
