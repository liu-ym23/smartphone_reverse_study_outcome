package com.bytedance.android.window.shop.home.presenter;

import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.tab.WindowTabEventReporter;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.widget.ClickSeparatedTabSelectListener;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y1 extends ClickSeparatedTabSelectListener {
    public final /* synthetic */ ECWindowSubTabsPresenter b;

    public y1(ECWindowSubTabsPresenter r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.window.shop.widget.ClickSeparatedTabSelectListener
    public final void a(ECTabLayout.Tab r8, ClickSeparatedTabSelectListener.ActionType r9) {
        Intrinsics.checkNotNullParameter(r9, "actionType");
        Intrinsics.checkNotNullParameter(r9, "actionType");
        if (r8 != null) goto L5;
        return;
    L5:
        String r10 = ECWindowSubTabsPresenter.a0(this.b, r8);
        if (r10 != null) goto L8;
        return;
    L8:
        int r0 = WindowTabEventReporter.a;
        WindowTabEventReporter.e(this.b.y(), this.b.O(), this.b.O().getShopParam(), r10, this.b.b0(r10), r9);
        Function1<hp3.b, Boolean> r11 = this.b.O().getEventDeliverer();
        if (r11 == null) goto L12;
        Boolean r12 = (Boolean) r11.invoke(new hp3.d(r10));
        return;
    }

    @Override // com.bytedance.android.window.shop.widget.ClickSeparatedTabSelectListener
    public final void b(ECTabLayout.Tab r4, ClickSeparatedTabSelectListener.ActionType r5) {
        Intrinsics.checkNotNullParameter(r5, "actionType");
        if (r4 != null) goto L5;
        return;
    L5:
        String r6 = ECWindowSubTabsPresenter.a0(this.b, r4);
        if (r6 != null) goto L9;
        return;
    L9:
        if (r5 != ClickSeparatedTabSelectListener.ActionType.CLICK) goto L11;
        int r7 = WindowTabEventReporter.a;
        ECWindowViewModel r8 = this.b.O();
        ECWindowParam r0 = this.b.O().getShopParam();
        Integer r1 = this.b.b0(r6);
        Intrinsics.checkNotNullParameter(r8, "reporter");
        Intrinsics.checkNotNullParameter(r0, "shopParam");
        Intrinsics.checkNotNullParameter(r6, "categoryId");
        r8.doEventAction("store_lift_click", WindowTabEventReporter.c(r0, r6, r1), new Pair[0]);
    L11:
        com.bytedance.android.ec.sdk.helper.c r9 = com.bytedance.android.ec.sdk.helper.c.a;
        r9.b("WINDOW", "[onTabSelected]tabId:".concat(r6));
        r9.b("WINDOW", "[onTabSelected]secAuthorId:" + this.b.O().getShopParam().getSecAuthorId());
    }
}
