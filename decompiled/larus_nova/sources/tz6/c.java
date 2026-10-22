package tz6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.model.layer.Layer;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends com.bytedance.lottie.model.layer.a {
    @Override // com.bytedance.lottie.model.layer.a
    public final void j(Canvas r100, Matrix r101, int r102) {
    }

    public c(LottieDrawable r100, Layer r101) {
        super(r100, r101);
    }

    @Override // com.bytedance.lottie.model.layer.a, nz6.d
    public final void c(RectF r100, Matrix r101) {
        super.c(r100, r101);
        r100.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
