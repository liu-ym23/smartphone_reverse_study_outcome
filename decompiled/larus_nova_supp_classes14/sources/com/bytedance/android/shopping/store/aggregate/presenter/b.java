package com.bytedance.android.shopping.store.aggregate.presenter;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateParam;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ ShopAggregatePageGroupPresenter a;

    public b(ShopAggregatePageGroupPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        ShopAggregatePageGroupPresenter r9 = this.a;
        ShopAggregateParam r0 = r9.D().getStoreParam();
        if (r0 == null) goto L21;
        qi3.b r1 = new qi3.b();
        r1.g = r0.getStoreAccountParam().getUserId();
        r1.b = r0.getEntranceLocation();
        if (r0.isPreview() == false) goto L8;
        int r2 = 1;
    L9:
        r1.d = r2;
        r1.e = "shop";
        r1.f = r0.getPageName();
        r1.a = "store_page";
        r1.c = r0.getTempId();
        Activity r3 = null;
        r1.post(null, null);
        JSONObject r4 = new JSONObject();
        if (r0.isEcShare() == false) goto L12;
        r4.put("is_ec_shopping", 1);
        r4.put("share_content", r0.getShareContent());
        r4.put("share_object", r0.getShareObject());
    L13:
        String r5 = r4.toString();
        m0 r6 = new m0("sslocal://goods/store/search");
        r6.a("uid", r0.getStoreAccountParam().getUserId());
        r6.a("sec_uid", r0.getStoreAccountParam().getSecUserId());
        r6.a("sec_shop_id", r0.getSecShopId());
        r6.a("shop_id", r0.getShopId());
        r6.a("enter_from", r0.getEnterFrom());
        r6.a("enter_method", r0.getEnterMethod());
        r6.a("which_account", r0.getWhichAccount());
        r6.a("share_params", r5);
        p r7 = p.a;
        int r10 = com.bytedance.android.ec.store.utils.b.a;
        String r11 = com.bytedance.android.ec.store.utils.b.b(r6.c(), "a1.b56317.c587067.d88494", PageFinder.via(r9.f), null);
        QContext r12 = r9.u();
        Activity r13 = l0.c(r12.c());
        if ((r13 instanceof FragmentActivity) == false) goto L17;
        r3 = r13;
    L17:
        if (r3 != null) goto L19;
        r3 = r12.a();
    L19:
        r7.d(r11, r3);
        return;
    L12:
        r4.put("is_ec_shopping", 0);
        goto L13
    L8:
        r2 = 0;
        goto L9
    }
}
