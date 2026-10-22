package com.bytedance.android.shopping.store.aggregate;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ ShopAggregatePageFragment a;

    public a(ShopAggregatePageFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        if (this.a.S90().getStoreParam().isSplitMode() == false) goto L5;
        Lazy r2 = ECStoreFoldPhoneHelper.a;
        ECStoreFoldPhoneHelper.a(this.a);
        return;
    L5:
        FragmentActivity r3 = this.a.getActivity();
        if (r3 == null) goto L10;
        r3.finish();
        return;
    }
}
