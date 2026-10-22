package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ ECShopHorizonSortBarPresenter a;
    public final /* synthetic */ View b;

    public e(ECShopHorizonSortBarPresenter r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        ej3.f r5 = (ej3.f) this.a.h0().getSortsVO().getValue();
        if (r5 == null) goto L5;
        String r6 = r5.e;
    L6:
        com.bytedance.android.ec.sdk.helper.p r1 = com.bytedance.android.ec.sdk.helper.p.a;
        FragmentActivity r2 = this.a.Y().a();
        ECStoreFoldPhoneHelper.b(r6);
        r1.openSchema(r2, r6);
        this.a.k0("click_ecom_component", null);
        this.a.k0("click_ecom_element", MapsKt.mapOf(TuplesKt.to("detail", "openlayer")));
        return;
    L5:
        r6 = null;
        goto L6
    }
}
