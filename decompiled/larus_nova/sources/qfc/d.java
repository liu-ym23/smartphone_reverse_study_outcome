package qfc;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RectF f532781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RectF f532782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y f532783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ y f532784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ PointF f532785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ a f532786f;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r110) {
        int r100 = ((Integer) r110.getAnimatedValue()).intValue();
        a.e r101 = this.f532786f.f532763e;
        RectF r102 = this.f532781a;
        RectF r103 = this.f532782b;
        float r104 = r110.getAnimatedFraction();
        w r105 = ((x.a) r101).f532846a.f532845b.f449175d;
        r105.getClass();
        r105.f532830m = new RectF(r102);
        r105.f532838u = true;
        r105.f532841x = ((-90) * r104) + 0.0f;
        float r106 = (((r103.width() - r102.height()) * r104) / r102.height()) + 1.0f;
        RectF r107 = new RectF(r102);
        float r108 = r102.centerX();
        float r109 = r102.centerY();
        r107.left = ((r107.left - r108) * r106) + r108;
        r107.right = ((r107.right - r108) * r106) + r108;
        r107.top = ((r107.top - r109) * r106) + r109;
        r107.bottom = ((r107.bottom - r109) * r106) + r109;
        r105.f532830m = r107;
        if (r104 != 1.0f) goto L5;
        r105.f532838u = false;
    L5:
        float r111 = (((this.f532782b.width() - this.f532781a.height()) * r110.getAnimatedFraction()) / this.f532781a.height()) + 1.0f;
        this.f532783c.d(this.f532784d);
        y r112 = this.f532783c;
        PointF r113 = this.f532785e;
        r112.c(r111, r111, r113.x, r113.y);
        PointF r114 = this.f532785e;
        r112.f532855b += r100;
        com.ss.android.photoeditor.util.b.c(r112.f532856c, r114.x, r114.y, r100);
        ((x.a) this.f532786f.f532763e).a(this.f532783c);
    }

    public d(a r100, RectF r101, RectF r102, y r103, y r104, PointF r105) {
        this.f532786f = r100;
        this.f532781a = r101;
        this.f532782b = r102;
        this.f532783c = r103;
        this.f532784d = r104;
        this.f532785e = r105;
    }
}
