package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.bottom.EnterShopMeta;
import com.bytedance.android.shopping.anchorv4.components.ShopFloatEntryVO;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.log.AdLogUtils;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.shop.AnchorV4ShopAndStoreBusinessMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.shop.AnchorV4ShopAndStoreMeta;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ ShopFloatEntryComponent a;
    public final /* synthetic */ ShopFloatEntryVO b;
    public final /* synthetic */ LongContentLabelComponentView c;

    public o(ShopFloatEntryComponent r1, ShopFloatEntryVO r2, LongContentLabelComponentView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r18) {
        ShopFloatEntryComponent r1 = this.a;
        ShopFloatEntryVO r2 = this.b;
        LongContentLabelComponentView r4 = this.c;
        r1.getClass();
        AnchorV4ShopAndStoreMeta r5 = r2.getMeta();
        if (r5 == null) goto L7;
        AnchorV4ShopAndStoreBusinessMeta r6 = r5.getBusinessMeta();
        if (r6 == null) goto L7;
        String r7 = r6.getShopPortfolioUrl();
    L8:
        AnchorV4ShopAndStoreMeta r3 = r2.getMeta();
        if (r3 == null) goto L11;
        LinkedTreeMap<String, Object> r8 = r3.getTrackMeta();
    L12:
        com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.j.a(new com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.j(new EnterShopMeta(r7, r8, false, null, null, null, null, 124, null).fillCommonMeta(r1.h2()), r1.q), r4, "a1.b8094.c45662.d99516", "product_detail_float", "click_store_entrance", 32);
        CommonMeta r9 = this.a.h2();
        if (r9 == null) goto L19;
        String r10 = r9.getEntranceInfo();
        if (r10 == null) goto L19;
        JSONObject r11 = com.bytedance.android.shopping.extensions.k.w(r10);
        if (r11 == null) goto L19;
        String r12 = r11.optString("log_extra");
    L20:
        if (r9 == null) goto L24;
        Map r13 = h73.a.a(r9);
        if (r13 == null) goto L24;
        r13.put("module", "进店逛逛");
    L25:
        if (r9 == null) goto L30;
        String r14 = h73.a.b(r9);
        if (r14 == null) goto L31;
        AdLogUtils.h(r14, r13, r12);
        return;
    L31:
        return;
    L30:
        return;
    L24:
        r13 = null;
    L19:
        r12 = null;
        goto L20
    L11:
        r8 = null;
    L7:
        r7 = null;
        goto L8
    }
}
