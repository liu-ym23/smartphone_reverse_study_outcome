package com.bytedance.android.shopping.widget.buybutton;

import android.net.Uri;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.utils.k2;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ButtonType;
import com.bytedance.android.ec.model.ClickButtonParam;
import com.bytedance.android.ec.model.SingleClickParam;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductLink;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.shopping.utils.p;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jd3.b0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static final /* synthetic */ int u = 0;
    public final d a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final List<PromotionDiscountLabel> s;
    public final List<k> t;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L46;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r4.m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r4.n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r4.o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.p, r4.p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.q, r4.q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.r, r4.r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.s, r4.s) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.t, r4.t) == true) goto L70;
        return false;
    L70:
        return true;
    L46:
        return false;
    }

    public final int hashCode() {
        d r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.h;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.i;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.j;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.k;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.l;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.m;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.n;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.o;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.p;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        String r49 = this.q;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        String r52 = this.r;
        if (r52 == null) goto L73;
        int r53 = r52.hashCode();
    L74:
        int r54 = (r51 + r53) * 31;
        List<PromotionDiscountLabel> r55 = this.s;
        if (r55 == null) goto L77;
        int r56 = r55.hashCode();
    L78:
        int r57 = (r54 + r56) * 31;
        List<k> r58 = this.t;
        if (r58 == null) goto L82;
        r1 = r58.hashCode();
    L82:
        return r57 + r1;
    L77:
        r56 = 0;
        goto L78
    L73:
        r53 = 0;
        goto L74
    L69:
        r50 = 0;
        goto L70
    L65:
        r47 = 0;
        goto L66
    L61:
        r44 = 0;
        goto L62
    L57:
        r41 = 0;
        goto L58
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ShoppingPurchaseButtonModel(presenter=" + this.a + ", name=" + this.b + ", schema=" + this.c + ", productId=" + this.d + ", promotionId=" + this.e + ", shopId=" + this.f + ", authorId=" + this.g + ", secAuthorId=" + this.h + ", groupId=" + this.i + ", marketingChannel=" + this.j + ", roomId=" + this.k + ", itemId=" + this.l + ", metaParams=" + this.m + ", entranceInfo=" + this.n + ", promotionSource=" + this.o + ", enterFrom=" + this.p + ", logExtra=" + this.q + ", trackAdditions=" + this.r + ", discountLabels=" + this.s + ", buttonModelList=" + this.t + ")";
    }

    public static Map b(String r4) {
        if (r4 != null) goto L4;
    L14:
        JSONObject r0 = new JSONObject();
    L15:
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<String> r1 = r0.keys();
    L17:
        if (r1.hasNext() == false) goto L19;
        String r2 = r1.next();
        r5.put(r2, r0.optString(r2));
        goto L17
    L19:
        return r5;
    L4:
        if (r4.length() <= 0) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == true) goto L10;
        r4 = null;
    L10:
        if (r4 == null) goto L14;
        r0 = new JSONObject(r4);     // Catch: JSONException -> L13
    L13:
        r0 = new JSONObject();
        goto L15
    L6:
        r3 = false;
        goto L7
    }

    public static String a(int r25, ClickButtonParam r26) {
        Intrinsics.checkNotNullParameter(r26, "param");
        SingleClickParam r0 = (SingleClickParam) CollectionsKt.getOrNull(r26.getSingleClickParams(), r25);
        if (r0 == null) goto L7;
        PromotionProductLink r1 = r0.getLinks();
        if (r1 == null) goto L7;
        String r14 = r1.getH5Url();
    L8:
        SingleClickParam r2 = (SingleClickParam) CollectionsKt.getOrNull(r26.getSingleClickParams(), r25);
        if (r2 == null) goto L13;
        ButtonType r3 = r2.getButtonType();
        if (r3 == null) goto L13;
        Boolean r4 = Boolean.valueOf(com.bytedance.android.ec.model.b.a(r3));
    L15:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L19;
        Uri.Builder r5 = UriProtector.parse(r14).buildUpon();
        JSONObject r6 = new JSONObject();
        r6.put("entrance_info", EcomBcmTracker.b(null, r26.getEntranceInfo()));
        Unit r7 = Unit.INSTANCE;
        r5.appendQueryParameter("mega_object", r6.toString());
        return r5.build().toString();
    L19:
        if (r14 == null) goto L119;
        int r8 = ECSdk.a;
        IECCommonService r9 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r9 == null) goto L26;
        mf.a r10 = r9.getOpenOrderSchemaHelper(m.class, ShoppingPurchaseButtonModel$buildNewOrderSchema$1.INSTANCE);
        if (r10 == null) goto L26;
        String r11 = r10.a(r14, new nl.e(null, null, null, false, null, r25, r26, null, 415));
        if (r11 == null) goto L26;
    L27:
        Map r12 = com.bytedance.android.ec.core.monitor.c.a;
        String r13 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_JSON_DEAL_DURATION, null);
        com.bytedance.android.ec.core.monitor.c.e(r13, "type", "entrance_info");
        com.bytedance.android.ec.core.monitor.c.e(r13, "scene", "video");
        com.bytedance.android.ec.core.monitor.c.f(r13, "url", r14);
        com.bytedance.android.ec.core.monitor.c.h(r13, MetricNames.DEAL_DURATION, null);
        Intrinsics.checkNotNullParameter(r26, "param");
        JSONObject r15 = new JSONObject(r26.getEntranceInfo());
        SingleClickParam r16 = com.bytedance.android.ec.model.c.a(r26, r25);
        r15.put("source_3d", r26.getEnterFrom());
        r15.put("auto_coupon", r16.getApplyCoupon() ? 1 : 0);
        r15.put("coupon_id", r16.getApplyCouponIds());
        if (r16.getNeedCheckSku() == false) goto L30;
        Object r17 = CommentScene.COMMENTSCENE_NO_AWEME;
    L31:
        r15.put("with_sku", r17);
        r15.put("commodity_id", r26.getPromotionId());
        r15.put("commodity_type", r26.getPromotionSource());
        r15.put("product_id", r26.getProductId());
        ButtonType r18 = r16.getButtonType();
        Intrinsics.checkNotNullParameter(r18, "$this$isSecKillProduct");
        String r19 = r11;
        boolean r20 = false;
        if (r18 != ButtonType.Seckill) goto L34;
        boolean r21 = true;
    L35:
        if (r21 == true) goto L37;
        Object r22 = null;
    L41:
        r15.put("product_activity_type", r22);
        Intrinsics.checkNotNullParameter(r26, "param");
        SingleClickParam r23 = com.bytedance.android.ec.model.c.a(r26, r25);
        JSONObject r24 = new JSONObject();
        r24.put("auto_coupon", r23.getApplyCoupon() ? 1 : 0);
        r24.put("coupon_id", r23.getApplyCouponIds());
        List r27 = r26.getDiscountLabels();
        if (r27 != null) goto L44;
    L55:
        Object r28 = null;
    L56:
        r24.put("cash_rebate", r28);
        if (r23.getNeedCheckSku() == false) goto L59;
        Object r29 = CommentScene.COMMENTSCENE_NO_AWEME;
    L60:
        r24.put("with_sku", r29);
        ButtonType r30 = r23.getButtonType();
        Intrinsics.checkNotNullParameter(r30, "$this$isGroupBuy");
        if (r30 != ButtonType.GroupBuy) goto L63;
        boolean r31 = true;
    L64:
        if (r31 == false) goto L66;
        Object r32 = CommentScene.COMMENTSCENE_NO_AWEME;
    L67:
        r24.put("is_groupbuying", r32);
        r24.put("is_explain_apply", z1.f(r26.getEntranceInfo()).optString("is_explain_apply", "0"));
        r24.put("author_id", r26.getAuthorId());
        r24.put("item_id", r26.getItemId());
        List r33 = r26.getDiscountLabels();
        StringBuilder r34 = new StringBuilder();
        if (r33 == null) goto L78;
        Iterator r35 = r33.iterator();
    L71:
        if (r35.hasNext() == false) goto L78;
        PromotionDiscountLabel r36 = (PromotionDiscountLabel) r35.next();
        if (r36.getType() != 1) goto L71;
        if (r36.getId() == null) goto L71;
        r34.append(Intrinsics.stringPlus(r36.getId(), ","));
    L78:
        if (r34.length() != 0) goto L80;
        boolean r37 = true;
    L81:
        if (r37 == false) goto L83;
        String r38 = r34.toString();
    L84:
        r24.put("coupon_id", r38);
        if (BuyNowPerformanceOpt.j() == true) goto L87;
        JSONObject r39 = new JSONObject();
        r39.put("biometric_params", CommentScene.COMMENTSCENE_NO_AWEME);
        int r40 = p.a;
        r39.put("is_jailbreak", "2");
        r39.put("cj_sdk", p.b());
        r39.put("bio_type", CommentScene.COMMENTSCENE_NO_AWEME);
    L89:
        if (UriProtector.getQueryParameter(UriProtector.parse(r14), "rifle_mega_object") == null) goto L91;
        boolean r210 = true;
    L92:
        int r41 = p0.a;
        String r42 = p0.g(p0.g(r14, "entrance_info", r15.toString()), "log_data", r24.toString());
        if (r39 == null) goto L95;
        String r110 = p0.g(r42, "cj_info", r39.toString());
    L96:
        Map r43 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r13, MetricNames.DEAL_DURATION);
        com.bytedance.android.ec.core.monitor.c.d(r13);
        String r211 = r15.toString();
        String r44 = r26.getGroupId();
        if (r44 == null) goto L99;
        Long r212 = StringsKt.toLongOrNull(r44);
    L100:
        String r45 = com.bytedance.android.shopping.anchorv3.utils.k.a(r110, null, null, r211, r212, r210);
        String r46 = k2.a(r45, null);
        if (r46 == null) goto L104;
        r45 = r46;
    L104:
        String r47 = r26.getMarketingChannel();
        if (r47 != null) goto L107;
        r47 = "";
    L107:
        String r48 = p0.d(r45, "marketing_channel", r47);
        int r49 = com.bytedance.android.shopping.anchorv3.track.b.a;
        b0 r50 = new b0();
        r50.a = r19;
        r50.b = r48;
        r50.c = "3d";
        r50.post(null, null);
        if (zg.a.a() == 1) goto L110;
    L115:
        if (r20 == true) goto L118;
        return r48;
    L118:
        return r19;
    L110:
        if (r19.length() <= 0) goto L112;
        boolean r51 = true;
    L113:
        if (r51 == false) goto L115;
        r20 = true;
        goto L115
    L112:
        r51 = false;
        goto L113
    L99:
        r212 = null;
        goto L100
    L95:
        r110 = r42;
        goto L96
    L91:
        r210 = false;
        goto L92
    L87:
        r39 = null;
        goto L89
    L83:
        r38 = r34.substring(0, r34.length() - 1);
        goto L84
    L80:
        r37 = false;
        goto L81
    L66:
        r32 = "0";
        goto L67
    L63:
        r31 = false;
        goto L64
    L59:
        r29 = "0";
        goto L60
    L44:
        if ((!r27.isEmpty()) == true) goto L47;
        r27 = null;
    L47:
        if (r27 == null) goto L55;
        int r52 = ((PromotionDiscountLabel) ListProtector.get(r27, 0)).getType();
        if (r52 != 2) goto L51;
        r28 = CommentScene.COMMENTSCENE_NO_AWEME;
        goto L56
    L51:
        if (r52 == 3) goto L53;
        r28 = "0";
        goto L56
    L53:
        r28 = "2";
        goto L56
    L37:
        if (r16.isInSecKillActivity() == false) goto L39;
        r22 = "seckill";
        goto L41
    L39:
        r22 = "pre_seckill";
        goto L41
    L34:
        r21 = false;
        goto L35
    L30:
        r17 = "0";
    L26:
        r11 = "";
        goto L27
    L119:
        return "";
    L13:
        r4 = null;
    L7:
        r14 = null;
        goto L8
    }

    public e(d r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, List<PromotionDiscountLabel> r29, List<k> r30) {
        Intrinsics.checkNotNullParameter(r11, "presenter");
        Intrinsics.checkNotNullParameter(r14, "productId");
        Intrinsics.checkNotNullParameter(r15, "promotionId");
        Intrinsics.checkNotNullParameter(r16, "shopId");
        Intrinsics.checkNotNullParameter(r17, "authorId");
        Intrinsics.checkNotNullParameter(r18, "secAuthorId");
        Intrinsics.checkNotNullParameter(r20, "marketingChannel");
        Intrinsics.checkNotNullParameter(r30, "buttonModelList");
        this.a = r11;
        this.b = r12;
        this.c = r13;
        this.d = r14;
        this.e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r20;
        this.k = r21;
        this.l = r22;
        this.m = r23;
        this.n = r24;
        this.o = r25;
        this.p = r26;
        this.q = r27;
        this.r = r28;
        this.s = r29;
        this.t = r30;
    }
}
