package vec;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.widget.timepicker.monthview.MonthViewContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MonthViewContainer f554557a;

    public i(MonthViewContainer r100) {
        this.f554557a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
        int r102 = ((Integer) r101).intValue();
        ViewGroup.LayoutParams r103 = this.f554557a.getLookMonthLayoutFromXml().getLayoutParams();
        MonthViewContainer r104 = this.f554557a;
        r103.height = r104.f449030g + r102;
        r104.getLookMonthLayoutFromXml().setLayoutParams(r103);
    }
}
