package qfc;

import android.animation.ValueAnimator;
import android.graphics.RectF;
import com.ss.android.lark.log.Log;
import com.ss.android.photoeditor.crop_rotate.PhotoClipView;

/* JADX INFO: loaded from: classes38.dex */
public final class p implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RectF f532808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RectF f532809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RectF f532810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w f532811d;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r110) {
        if (this.f532811d.f532837t == true) goto L5;
        return;
    L5:
        float r111 = r110.getAnimatedFraction();
        RectF r100 = this.f532808a;
        RectF r101 = this.f532809b;
        float r102 = r101.left;
        RectF r103 = this.f532810c;
        float r104 = r103.left;
        r100.left = ((r102 - r104) * r111) + r104;
        float r105 = r101.right;
        float r106 = r103.right;
        r100.right = ((r105 - r106) * r111) + r106;
        float r107 = r101.top;
        float r108 = r103.top;
        r100.top = ((r107 - r108) * r111) + r108;
        float r109 = r101.bottom;
        float r112 = r103.bottom;
        r100.bottom = ((r109 - r112) * r111) + r112;
        this.f532811d.f532827j.set(r100);
        this.f532811d.h();
        Log.i("PhotoClipRect", "onAnimationUpdate, temp = " + this.f532808a);
        w.d r113 = this.f532811d.f532833p;
        RectF r114 = this.f532808a;
        x.f r115 = (x.f) r113;
        r115.getClass();
        Log.i("PhotoClipView", "onTransitionUpdate : locationBeforeTransition = " + r115.f532851a + " mStartClipRect = " + r115.f532852b.f532845b.f449179h);
        a r116 = r115.f532852b.f532845b.f449177f;
        r116.f532762d.d(r115.f532851a);
        PhotoClipView r117 = r115.f532852b.f532845b;
        y r118 = r117.f449183l;
        a r119 = r117.f449177f;
        RectF r120 = r117.f449179h;
        r119.getClass();
        float r121 = r114.width() / r120.width();
        float r122 = r114.height() / r120.height();
        float r123 = Math.round(r121 * 1000.0f) / 1000.0f;
        float r124 = Math.round(r122 * 1000.0f) / 1000.0f;
        r119.f532762d.c(r123, r124, r120.centerX(), r120.centerY());
        RectF r125 = new RectF(r120);
        com.ss.android.photoeditor.util.b.f(r125, r125.centerX(), r125.centerY(), r123, r124);
        r119.f532762d.f532856c.offset(r114.centerX() - r125.centerX(), r114.centerY() - r125.centerY());
        r118.d(r119.f532762d);
        r115.f532852b.f532845b.invalidate();
        w r126 = this.f532811d;
        w.c r127 = r126.f532832o;
        ((x.e) r127).f532850a.f532845b.f449176e.set(r126.f532827j);
    }

    public p(w r100, RectF r101, RectF r102, RectF r103) {
        this.f532811d = r100;
        this.f532808a = r101;
        this.f532809b = r102;
        this.f532810c = r103;
    }
}
