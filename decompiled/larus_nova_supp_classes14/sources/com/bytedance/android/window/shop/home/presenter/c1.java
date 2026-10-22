package com.bytedance.android.window.shop.home.presenter;

import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.android.window.shop.widget.ClickSeparatedTabSelectListener;
import java.util.LinkedHashMap;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c1 implements ECTabLayout.OnTabSelectedListener {
    public final /* synthetic */ ECWindowHybridSubTabsPresenter a;

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(ECTabLayout.Tab r1) {
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final /* synthetic */ void onTabSelected(ECTabLayout.Tab r1, boolean r2) {
        ECTabLayout.BaseOnTabSelectedListener.CC.$default$onTabSelected(this, r1, r2);
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(ECTabLayout.Tab r1) {
    }

    public c1(ECWindowHybridSubTabsPresenter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(ECTabLayout.Tab r4) {
        if (this.a.O().isCroppedStyle() == true) goto L5;
    L7:
        Object r0 = null;
        if (r4 == null) goto L10;
        ECTabLayout.TabView r1 = r4.view;
    L11:
        if (r1 == null) goto L29;
        Object r2 = r1.getTag();
        if ((r2 instanceof ClickSeparatedTabSelectListener.ActionType) == false) goto L17;
        r0 = r2;
    L17:
        if (((ClickSeparatedTabSelectListener.ActionType) r0) != ClickSeparatedTabSelectListener.ActionType.NONE) goto L20;
        return;
    L20:
        if (ECWindowHybridSubTabsPresenter.c0(this.a, r4) == null) goto L22;
        this.a.O().getSelectedTabLocation().c(TuplesKt.to(0, 0));
    L22:
        Integer r5 = com.bytedance.android.ec.core.utils.s.b((String) ((LinkedHashMap) this.a.o).get(String.valueOf(r4.getText())));
        if (r5 == null) goto L25;
        int r6 = r5.intValue();
    L26:
        this.a.e0().setSelectedTabIndicatorColor(r6);
        return;
    L25:
        r6 = com.bytedance.android.ec.window.base.utils.c.c(this.a.u().c(), 2131101821);
        goto L26
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L10:
        r1 = null;
        goto L11
    L5:
        if (this.a.O().isVideoTrailerOrSplitOpt() == true) goto L7;
    }
}
