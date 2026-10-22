package p0;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.Layer;

/* JADX INFO: loaded from: classes28.dex */
public final class c extends com.airbnb.lottie.model.layer.a {
    @Override // com.airbnb.lottie.model.layer.a
    public final void k(Canvas r100, Matrix r101, int r102) {
    }

    public c(LottieDrawable r100, Layer r101) {
        super(r100, r101);
    }

    @Override // com.airbnb.lottie.model.layer.a, i0.e
    public final void c(RectF r100, Matrix r101) {
        super.c(r100, r101);
        r100.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // com.airbnb.lottie.model.layer.a
    public final void l(RectF r100, Matrix r101) {
        super.l(r100, r101);
        r100.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
