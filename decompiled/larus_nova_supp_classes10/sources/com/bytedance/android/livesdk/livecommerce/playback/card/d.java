package com.bytedance.android.livesdk.livecommerce.playback.card;

import android.content.Context;
import cf.l;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.utils.LiveSettingKeys;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import si2.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements jf.c {
    public final /* synthetic */ ExplainPlaybackCardPresenter a;
    public final /* synthetic */ l b;

    public final void a() {
    }

    public final void b() {
    }

    public final void h() {
    }

    public final void l() {
    }

    public final void m() {
    }

    public final boolean k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r2, "schema");
        return false;
    }

    public d(ExplainPlaybackCardPresenter r1, l r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void d(Context r1, com.bytedance.android.btm.api.model.d r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    public final void e(Context r1, com.bytedance.android.btm.api.model.d r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    public final void f(String r2, com.bytedance.android.ec.common.api.jump.model.g r3) {
        Intrinsics.checkNotNullParameter(r2, "clickArea");
        Intrinsics.checkNotNullParameter(r3, "promotionParams");
        cj2.a.c(r2, "1");
    }

    public final boolean i(String r1, com.bytedance.android.btm.api.model.d r2) {
        Intrinsics.checkNotNullParameter(r1, "clickArea");
        Intrinsics.checkNotNullParameter(r1, "clickArea");
        return false;
    }

    public final Map<String, String> j(String r9, Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r9, "eventName");
        Intrinsics.checkNotNullParameter(r10, "eventParams");
        ECUIPromotion r11 = this.a.n;
        if (r11 == null) goto L48;
        cj2.c r1 = cj2.a.a;
        String r12 = (String) ((HashMap) r10).get("click_area");
        if (r12 != null) goto L7;
        r12 = "";
    L7:
        Intrinsics.checkNotNullParameter(r11, "promotion");
        Intrinsics.checkNotNullParameter(r12, "clickArea");
        Map r2 = new LinkedHashMap();
        cj2.c r3 = cj2.a.a;
        if (r3 == null) goto L12;
        HashMap<String, String> r4 = r3.a;
        if (r4 == null) goto L12;
        r2.putAll(r4);
    L12:
        boolean r5 = cj2.a.b;
        String r6 = BDLocationException.ERROR_TIMEOUT;
        if (r5 == false) goto L15;
        Object r7 = "1";
    L16:
        r2.put("subtitle_status", r7);
        cj2.c r8 = cj2.a.a;
        if (r8 == null) goto L19;
        r2.put("system_volume_pct", String.valueOf(Double.valueOf(r8.b).doubleValue()));
    L19:
        r2.put("end_volume_pct", String.valueOf(com.bytedance.android.ec.core.utils.g.a()));
        HashMap r13 = new HashMap();
        String r14 = String.valueOf(r11.getLocalNum());
        if (r14 == null) goto L22;
        r13.put("local_num", r14);
    L22:
        String r15 = String.valueOf(r11.getIronIndex());
        if (r15 == null) goto L25;
        r13.put("list_num", r15);
    L25:
        String r16 = r11.getIsGroupBuying();
        if (r16 == null) goto L28;
        r13.put("is_groupbuying", r16);
    L28:
        ECUIAskExplainInfo r17 = r11.getAskExplainInfo();
        if (r17 != null) goto L31;
    L33:
        Object r18 = BDLocationException.ERROR_TIMEOUT;
    L34:
        r13.put("is_explain_apply", r18);
        if (q.a(r11) == false) goto L37;
        String r19 = "seckill";
    L38:
        r13.put("product_activity_type", r19);
        String r20 = r11.getRealPrice();
        if (r20 == null) goto L41;
        r13.put("real_price", r20);
    L41:
        String r21 = r11.getCostPrice();
        if (r21 == null) goto L45;
        r13.put("cost_price", r21);
    L45:
        if (r11.isOnExplain() == false) goto L47;
        r6 = "1";
    L47:
        r13.put("is_explaining", r6);
        r13.put("card_status", "1");
        r13.put("click_area", r12);
        r13.put("ecom_entrance_form", "replay_popup_card");
        r2.putAll(r13);
    L49:
        if (r2 != null) goto L51;
        r2 = MapsKt.emptyMap();
    L51:
        LinkedHashMap r22 = new LinkedHashMap();
        Iterator r110 = r2.entrySet().iterator();
    L53:
        if (r110.hasNext() == false) goto L60;
        Map.Entry r23 = (Map.Entry) r110.next();
        if (((CharSequence) r23.getValue()).length() <= 0) goto L57;
        boolean r24 = true;
    L58:
        if (r24 == false) goto L53;
        r22.put(r23.getKey(), r23.getValue());
        goto L53
    L57:
        r24 = false;
        goto L58
    L60:
        return r22;
    L37:
        r19 = "nonactivity";
        goto L38
    L31:
        if (r17.isAsked() != true) goto L33;
        r18 = "1";
        goto L34
    L15:
        r7 = BDLocationException.ERROR_TIMEOUT;
        goto L16
    L48:
        r2 = null;
        goto L49
    }

    public final void n(String r2, com.bytedance.android.ec.common.api.jump.model.g r3) {
        Intrinsics.checkNotNullParameter(r2, "clickArea");
        Intrinsics.checkNotNullParameter(r3, "promotionParams");
        jf.c.a.b(r2, r3);
    }

    public final boolean c(Context r1, com.bytedance.android.btm.api.model.d r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (this.a.h0().isFromProductDetail() == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L10;
    L13:
        return r4;
    L10:
        if (this.a.h0().isFromLive() == true) goto L12;
        this.b.La();
    L12:
        com.bytedance.android.ec.sdk.plugin.e.getActivity(this.a.Y().c()).finish();
        this.a.h0().setClosePageByUser(true);
        goto L13
    L5:
        if (LiveSettingKeys.getEC_LIVE_PLAYBACK_DETAIL_CLOSE_PAGE() == false) goto L7;
        r4 = true;
        goto L8
    }

    public final void g(String r2, ql.a r3, BtmItemBuilder r4) {
        Intrinsics.checkNotNullParameter(r2, "clickArea");
        Intrinsics.checkNotNullParameter(r3, "promotion");
        Intrinsics.checkNotNullParameter(r2, "clickArea");
        Intrinsics.checkNotNullParameter(r3, "promotion");
    }
}
