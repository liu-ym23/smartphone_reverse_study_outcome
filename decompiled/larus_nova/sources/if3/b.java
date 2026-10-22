package if3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.shopping.mall.homepage.card.headercard.widget.BadgeView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BadgeView f489568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f489569b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        BadgeView r101 = this.f489568a;
        View r102 = this.f489569b;
        int r103 = BadgeView.f177918p;
        r101.getClass();
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{1.0f, 1.3f, 0.8f, 1.0f});
        r104.setDuration(600);
        r104.setInterpolator(new AccelerateDecelerateInterpolator());
        r104.setStartDelay(1000);
        r104.addUpdateListener(new c(r102));
        r104.addListener(new d(r101, r102));
        Unit r105 = Unit.INSTANCE;
        r101.f177933o = r104;
        r104.start();
    }

    public b(BadgeView r100, View r101) {
        this.f489568a = r100;
        this.f489569b = r101;
    }
}
