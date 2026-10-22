package su7;

import android.animation.ValueAnimator;
import com.github.rahatarmanahmed.cpv.CircularProgressView;

/* JADX INFO: loaded from: classes23.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f543595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f543596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CircularProgressView f543597c;

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        CircularProgressView r101 = this.f543597c;
        r101.f274328q = ((Float) r100.getAnimatedValue()).floatValue();
        CircularProgressView r102 = this.f543597c;
        r102.f274319h = (this.f543595a - r102.f274328q) + this.f543596b;
        r102.invalidate();
    }

    public c(CircularProgressView r100, float r101, float r102) {
        this.f543597c = r100;
        this.f543595a = r101;
        this.f543596b = r102;
    }
}
