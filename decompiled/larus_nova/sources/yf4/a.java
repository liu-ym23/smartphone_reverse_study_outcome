package yf4;

import android.graphics.PointF;
import android.graphics.RectF;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f567445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f567446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f567447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f567448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView.ScaleType f567449e;

    public a(RectF r100, RectF r101, RectF r102, RectF r103, PointF r110, float r111, ImageView.ScaleType r112) {
        RectF r104 = new RectF();
        this.f567445a = r104;
        RectF r105 = new RectF();
        this.f567446b = r105;
        RectF r106 = new RectF();
        this.f567447c = r106;
        RectF r107 = new RectF();
        PointF r108 = new PointF();
        r104.set(r100);
        r105.set(r101);
        r106.set(r102);
        this.f567449e = r112;
        this.f567448d = r111;
        r107.set(r103);
        r108.set(r110);
    }
}
