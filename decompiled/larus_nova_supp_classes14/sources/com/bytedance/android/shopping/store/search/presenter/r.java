package com.bytedance.android.shopping.store.search.presenter;

import android.view.View;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r implements View.OnClickListener {
    public final /* synthetic */ ShopSearchResultTopBarPresenter a;

    public r(ShopSearchResultTopBarPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (this.a.F().getSearchParam().isSplitMode() == false) goto L5;
        Lazy r4 = ECStoreFoldPhoneHelper.a;
        ECStoreFoldPhoneHelper.a(this.a.u().d().i());
        return;
    L5:
        this.a.F().getData().putExtra("sug_enter_type", 2);
        ShopSearchResultTopBarPresenter.E(this.a, 10);
    }
}
