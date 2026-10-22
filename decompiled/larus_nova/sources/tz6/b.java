package tz6;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.model.layer.Layer;
import com.bytedance.lottie.n;
import oz6.p;
import wz6.h;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends com.bytedance.lottie.model.layer.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Paint f548054v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Rect f548055w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Rect f548056x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public p f548057y;

    public b(LottieDrawable r100, Layer r101) {
        super(r100, r101);
        this.f548054v = new Paint(3);
        this.f548055w = new Rect();
        this.f548056x = new Rect();
    }

    @Override // com.bytedance.lottie.model.layer.a, nz6.d
    public final void c(RectF r100, Matrix r101) {
        super.c(r100, r101);
        Bitmap r102 = this.f264537m.d(this.f264538n.f264508g);
        if (r102 == null) goto L6;
        r100.set(r100.left, r100.top, Math.min(r100.right, r102.getWidth()), Math.min(r100.bottom, r102.getHeight()));
        this.f264536l.mapRect(r100);
        return;
    }

    @Override // com.bytedance.lottie.model.layer.a, qz6.f
    public final <T> void f(T r100, xz6.c<T> r101) {
        super.f(r100, r101);
        if (r100 != n.f264576x) goto L8;
        if (r101 != null) goto L6;
        this.f548057y = null;
        return;
    L6:
        this.f548057y = new p(r101);
        return;
    }

    @Override // com.bytedance.lottie.model.layer.a
    public final void j(Canvas r100, Matrix r101, int r102) {
        Bitmap r103 = this.f264537m.d(this.f264538n.f264508g);     // Catch: Exception -> L12
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.isRecycled() == true) goto L19;
        float r104 = h.d();     // Catch: Exception -> L12
        this.f548054v.setAlpha(r102);     // Catch: Exception -> L12
        p r105 = this.f548057y;     // Catch: Exception -> L12
        if (r105 == null) goto L10;
        this.f548054v.setColorFilter((ColorFilter) r105.e());     // Catch: Exception -> L12
    L10:
        r100.save();     // Catch: Exception -> L12
        r100.concat(r101);     // Catch: Exception -> L12
        this.f548055w.set(0, 0, r103.getWidth(), r103.getHeight());     // Catch: Exception -> L12
        this.f548056x.set(0, 0, (int) (r103.getWidth() * r104), (int) (r103.getHeight() * r104));     // Catch: Exception -> L12
        r100.drawBitmap(r103, this.f548055w, this.f548056x, this.f548054v);     // Catch: Exception -> L12
        r100.restore();     // Catch: Exception -> L12
        return;
    L19:
        return;
    L12:
        e = move-exception;
        e.toString();
    }
}
