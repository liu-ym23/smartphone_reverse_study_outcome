package com.bytedance.android.window.shop.home.tab.presenter;

import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.android.window.shop.holder.footer.FooterStatus;
import com.bytedance.android.window.shop.widget.ECShopRecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s implements ECTabLayout.OnTabSelectedListener {
    public final /* synthetic */ ECWindowTabPresenter a;

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

    public s(ECWindowTabPresenter r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(ECTabLayout.Tab r4) {
        ECWindowTabPresenter r0 = this.a;
        int r1 = ECWindowTabPresenter.C;
        r0.getClass();
        if (r4 == null) goto L7;
        Object r5 = r4.getTag();
        if (r5 == null) goto L7;
        String r6 = r5.toString();
    L8:
        ECShopRecyclerView r2 = r0.m;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L11:
        r2.scrollToPosition(0);
        if (r6 == null) goto L16;
        r0.l0(FooterStatus.NOTHING);
        r0.i0().refreshAndLoadData(r6, r0.e0().g);
        return;
    L16:
        return;
    L7:
        r6 = null;
        goto L8
    }
}
