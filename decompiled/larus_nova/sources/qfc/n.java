package qfc;

import android.animation.ValueAnimator;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes38.dex */
public final class n implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RectF f532803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RectF f532804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RectF f532805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w f532806d;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        if (this.f532806d.f532837t == true) goto L5;
        return;
    L5:
        float r101 = r100.getAnimatedFraction();
        RectF r102 = this.f532803a;
        RectF r103 = this.f532804b;
        float r104 = r103.left;
        RectF r105 = this.f532805c;
        float r106 = r105.left;
        r102.left = ((r104 - r106) * r101) + r106;
        float r107 = r103.right;
        float r108 = r105.right;
        r102.right = ((r107 - r108) * r101) + r108;
        float r109 = r103.top;
        float r110 = r105.top;
        r102.top = ((r109 - r110) * r101) + r110;
        float r111 = r103.bottom;
        float r112 = r105.bottom;
        r102.bottom = ((r111 - r112) * r101) + r112;
        this.f532806d.f532827j.set(r102);
        this.f532806d.h();
        w r113 = this.f532806d;
        w.c r114 = r113.f532832o;
        RectF r115 = r113.f532827j;
        ((x.e) r114).f532850a.f532845b.f449176e.set(r115);
        ((x.d) this.f532806d.f532831n).f532849a.f532845b.invalidate();
    }

    public n(w r100, RectF r101, RectF r102, RectF r103) {
        this.f532806d = r100;
        this.f532803a = r101;
        this.f532804b = r102;
        this.f532805c = r103;
    }
}
