package tz6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.model.layer.Layer;
import java.util.Collections;
import java.util.List;
import sz6.i;

/* JADX INFO: loaded from: classes21.dex */
public final class d extends com.bytedance.lottie.model.layer.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final nz6.c f548058v;

    public d(LottieDrawable r100, Layer r101) {
        super(r100, r101);
        nz6.c r102 = new nz6.c(r100, this, new i("__container", r101.f264502a));
        this.f548058v = r102;
        r102.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.bytedance.lottie.model.layer.a, nz6.d
    public final void c(RectF r100, Matrix r101) {
        super.c(r100, r101);
        this.f548058v.c(r100, this.f264536l);
    }

    @Override // com.bytedance.lottie.model.layer.a
    public final void j(Canvas r100, Matrix r101, int r102) {
        this.f548058v.d(r100, r101, r102);
    }

    @Override // com.bytedance.lottie.model.layer.a
    public final void m(qz6.e r100, int r101, List<qz6.e> r102, qz6.e r103) {
        this.f548058v.g(r100, r101, r102, r103);
    }
}
