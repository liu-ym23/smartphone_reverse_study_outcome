package yma;

import android.animation.ValueAnimator;
import com.obric.oui.widget.VerticalFadeFrameLayout;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f568394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f568395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f568396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f568397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ VerticalFadeFrameLayout f568398e;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        float r101 = ((Float) r100.getAnimatedValue()).floatValue();
        VerticalFadeFrameLayout r102 = this.f568398e;
        float r103 = this.f568394a;
        r102.f403737k = r103 + ((this.f568395b - r103) * r101);
        float r104 = this.f568396c;
        r102.f403738l = r104 + ((this.f568397d - r104) * r101);
        r102.a();
    }

    public a(VerticalFadeFrameLayout r100, float r101, float r102, float r103, float r104) {
        this.f568398e = r100;
        this.f568394a = r101;
        this.f568395b = r102;
        this.f568396c = r103;
        this.f568397d = r104;
    }
}
