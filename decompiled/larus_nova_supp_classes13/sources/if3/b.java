package if3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.BadgeView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ BadgeView a;
    public final /* synthetic */ View b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        BadgeView r6 = this.a;
        View r0 = this.b;
        int r1 = BadgeView.p;
        r6.getClass();
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{1.0f, 1.3f, 0.8f, 1.0f});
        r2.setDuration(600);
        r2.setInterpolator(new AccelerateDecelerateInterpolator());
        r2.setStartDelay(1000);
        r2.addUpdateListener(new c(r0));
        r2.addListener(new d(r6, r0));
        Unit r3 = Unit.INSTANCE;
        r6.o = r2;
        r2.start();
    }

    public b(BadgeView r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
