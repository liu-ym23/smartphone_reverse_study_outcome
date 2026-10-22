package com.bytedance.android.shopping.mall.homepage.card.live;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.ec.hybrid.ui.IHybridLiveBoxView;
import com.bytedance.android.shopping.api.mall.MallPageName;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import com.bytedance.android.shopping.mall.homepage.jsb.q;
import com.bytedance.android.shopping.mall.homepage.tools.LastActionRecorderKt;
import com.bytedance.android.shopping.mall.homepage.tools.a0;
import com.bytedance.android.shopping.mall.homepage.tools.c0;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ NativeLiveCard a;
    public final /* synthetic */ View b;

    public l(NativeLiveCard r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        int r13 = q.a;
        NativeLiveCard r14 = this.a;
        String r0 = r14.r;
        LiveCardData r15 = r14.u;
        if (r15 == null) goto L7;
        LiveCardData.Live r16 = r15.getLive();
        if (r16 == null) goto L7;
        String r17 = r16.getRoomId();
    L8:
        ECHybridListItemVO r2 = ((BaseViewHolder) this.a).c;
        if (r2 == null) goto L11;
        String r3 = r2.d;
    L12:
        q.a(r0, r17, r3);
        LastActionRecorderKt.a(this.a, false, null);
        a.e(this.a, true, System.currentTimeMillis() - this.a.V1);
        String r18 = "c9582.d6936_i" + (ToolsKt.g(this.a) + 1);
        o.d(this.a, true, r18);
        final NativeLiveCard r4 = this.a;
        if (((Boolean) r4.v2.getValue()).booleanValue() == true) goto L15;
    L24:
        Map<String, Object> r5 = c0.a;
        ECHybridListItemVO r6 = ((BaseViewHolder) r4).c;
        if (r6 == null) goto L30;
        ECNAMallCardExtra r7 = r6.c();
        if (r7 == null) goto L30;
        Map r8 = r7.getSchemaMap();
        if (r8 == null) goto L30;
    L31:
        String r9 = c0.a(r8, true, ToolsKt.g(r4), new NativeLiveCard$getLiveProductSchema$2(r4));
    L32:
        JsonObject r10 = new JsonObject();
        Lazy r11 = HybridAppInfoService.a;
        if (HybridAppInfoService.n() == false) goto L35;
    L38:
        String r19 = "order_center";
    L39:
        r10.addProperty(SimilarProductParam.ENTER_FROM, r19);
        r10.toString();
        com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostECSchemaMonitorService();
        if (BtmSDK.INSTANCE.useV2Api() == false) goto L42;
        int r20 = com.bytedance.android.shopping.api.mall.common.tools.b.a;
        r9 = com.bytedance.android.shopping.api.mall.common.tools.b.a(r9, MapsKt.mapOf(new Pair[]{TuplesKt.to("btm", r18), TuplesKt.to("bcm", MapsKt.mapOf(TuplesKt.to("type", "live")))}), PageFinder.via(this.b), this.b.getContext(), false);
    L43:
        NativeLiveCard r110 = this.a;
        IHybridLiveBoxView r21 = r110.Q1;
        if (r21 != null) goto L46;
    L48:
        com.bytedance.android.shopping.api.mall.common.tools.k.b.d(this.b.getContext(), r9, null);
        return;
    L46:
        if (r110.Q2 == false) goto L48;
        r110.E2 = true;
        r21.enterDetail(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("schema", r9)}));
        return;
    L42:
        ToolsKt.z(this.a, this.b, r18, new JSONObject().put("type", "live"));
        goto L43
    L35:
        if (Intrinsics.areEqual(ToolsKt.k(this.a).get(PdpOpenThirdParam.KEY_PAGE_NAME), "order_homepage") == true) goto L38;
        r19 = MallPageName.X_TAB_MALL;
    L30:
        r8 = MapsKt.emptyMap();
        goto L31
    L15:
        if (r4.e5() == false) goto L24;
        a0 r22 = new a0(ToolsKt.k(r4));
        ECHybridListItemVO r23 = ((BaseViewHolder) r4).c;
        if (r23 == null) goto L22;
        ECNAMallCardExtra r24 = r23.c();
        if (r24 == null) goto L22;
        Map<String, String> r25 = r24.getSchemaMap();
        if (r25 == null) goto L22;
    L23:
        r9 = r22.a(r25, true, ToolsKt.g(r4), null, new NativeLiveCard$getLiveProductSchema$1(r4));
    L22:
        r25 = MapsKt.emptyMap();
        goto L23
    L11:
        r3 = null;
    L7:
        r17 = null;
        goto L8
    }
}
