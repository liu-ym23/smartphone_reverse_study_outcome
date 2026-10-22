package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel;
import com.bytedance.android.window.shop.innerflow.widget.ECWindowInnerFlowTextTagGroup;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowInnerFlowTagListElementPresenter extends d<wp3.f> {
    public final Lazy g;
    public final Lazy h;

    public final ECWindowInnerFlowTextTagGroup F() {
        return (ECWindowInnerFlowTextTagGroup) this.g.getValue();
    }

    public ECWindowInnerFlowTagListElementPresenter() {
        super(yp3.d.a);
        this.g = LazyKt.lazy(new ECWindowInnerFlowTagListElementPresenter$tagGroup$2(this));
        this.h = LazyKt.lazy(new ECWindowInnerFlowTagListElementPresenter$viewModel$2(this));
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void E() {
        List r0 = com.bytedance.commerce.base.view.b.a(F());
        F().removeAllViews();
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        View r2 = (View) r1.next();
        if ((r2 instanceof TextView) == true) goto L8;
        r2 = null;
    L8:
        TextView r3 = (TextView) r2;
        if (r3 == null) goto L4;
        ((ECWindowInnerFlowViewModel) this.h.getValue()).getFlyWeight().f.b(r3);
        goto L4
    }

    @Override // com.bytedance.android.window.shop.innerflow.holder.element.presenter.d
    public final void D(wp3.f r5) {
        wp3.f r6 = r5;
        if (F().getChildCount() <= 0) goto L5;
        F().removeAllViews();
    L5:
        if (r6 == null) goto L12;
        List<String> r7 = r6.a;
        if (r7 == null) goto L14;
        Iterator<T> r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L15;
        final String r0 = (String) r8.next();
        F().addView((View) ((ECWindowInnerFlowViewModel) this.h.getValue()).getFlyWeight().f.a(new ECWindowInnerFlowTagListElementPresenter$onElementBind$$inlined$forEach$lambda$1(r0, this)));
        goto L10
    L15:
        return;
    L14:
        return;
    }
}
