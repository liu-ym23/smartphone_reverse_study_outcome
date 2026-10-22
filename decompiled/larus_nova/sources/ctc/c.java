package ctc;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes41.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.a f465384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f465385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f465386c;

    public c(d.a r100, a r101, View r102) {
        this.f465384a = r100;
        this.f465385b = r101;
        this.f465386c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        if (this.f465384a.f465401b.computeScrollOffset() == false) goto L6;
        this.f465385b.b(this.f465384a.f465401b.getCurrX());
        ViewCompat.postInvalidateOnAnimation(this.f465386c);
        return;
    L6:
        if (r100.getAnimatedFraction() >= 1.0f) goto L10;
        r100.end();
        return;
    }
}
