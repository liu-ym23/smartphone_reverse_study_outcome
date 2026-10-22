package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import android.widget.TextView;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel;
import com.bytedance.android.window.shop.innerflow.widget.ECExpandableTextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowInnerFlowRecommendTextElementPresenter extends d<wp3.e> {
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;

    public final ECExpandableTextView F() {
        return (ECExpandableTextView) this.h.getValue();
    }

    public ECWindowInnerFlowRecommendTextElementPresenter() {
        super(yp3.g.a);
        this.g = LazyKt.lazy(new ECWindowInnerFlowRecommendTextElementPresenter$viewModel$2(this));
        this.h = LazyKt.lazy(new ECWindowInnerFlowRecommendTextElementPresenter$tvRecommend$2(this));
        this.i = LazyKt.lazy(new ECWindowInnerFlowRecommendTextElementPresenter$tvTitle$2(this));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.TextView, com.bytedance.android.window.shop.innerflow.widget.ECExpandableTextView] */
    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void E() {
        ?? r0 = F();
        r0.b = true;
        r0.invalidate();
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void D(wp3.e r5) {
        wp3.e r6 = r5;
        if (r6 == null) goto L18;
        ECWindowInnerFlowViewModel r0 = (ECWindowInnerFlowViewModel) this.g.getValue();
        if (r0.getFlyWeight().b != null) goto L8;
        ECWindowInnerFlowViewModel.a r1 = r0.getFlyWeight();
        r1.b = F().getBitmapFixedHeight();
    L8:
        F().setBitmapCache(((ECWindowInnerFlowViewModel) this.g.getValue()).getFlyWeight().b);
        if (r6.a == null) goto L11;
        F().setText(r6.a);
        F().setVisibility(0);
    L12:
        String r7 = a2.d(r6.b);
        if (r7 != null) goto L15;
        ((TextView) this.i.getValue()).setVisibility(8);
        return;
    L15:
        ((TextView) this.i.getValue()).setText(r7);
        ((TextView) this.i.getValue()).setVisibility(0);
        return;
    L11:
        F().setVisibility(8);
        Unit r2 = Unit.INSTANCE;
        goto L12
    }
}
