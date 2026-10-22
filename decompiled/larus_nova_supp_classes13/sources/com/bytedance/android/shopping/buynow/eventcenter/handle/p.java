package com.bytedance.android.shopping.buynow.eventcenter.handle;

import android.content.Context;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.hybrid.list.util.ECHybridGsonUtil;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.android.shopping.sku.common.utils.SkuBuyNowPanelHeightHelper;
import com.bytedance.android.shopping.utils.l0;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p extends com.bytedance.kmp.ec.yata.event.common.b {
    public final Context a;
    public final BuyNowViewModel b;
    public final BuyNowFragment c;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v4 */
    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r19) {
        Intrinsics.checkNotNullParameter(r19, "input");
        BuyNowLog.d("selfOpenSchema", "selfOpenSchema starts");
        com.bytedance.kmp.ec.yata.store.node.c r3 = r19.j();
        if (r3 == null) goto L5;
        String r4 = r3.getKey();
    L6:
        com.bytedance.android.shopping.buynow.controller.e.a = r4;
        Object r5 = r19.q();
        if (r5 != null) goto L109;
    L14:
        JSONObject r6 = null;
    L15:
        Object r7 = r19.y();
        if ((r7 instanceof Map) == true) goto L18;
        r7 = null;
    L18:
        Map r8 = (Map) r7;
        if (r6 != null) goto L21;
    L22:
        if (r8 != null) goto L24;
    L25:
        BuyNowLog.d("selfOpenSchema", "yata fields and data are both nullOrEmpty");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.b.getTracker(), "selfOpenSchema", "yata fields and data are both nullOrEmpty", r19);
    L27:
        if (r8 == null) goto L29;
        Object r9 = r8.get("schema");
    L31:
        if ((r9 instanceof String) == true) goto L33;
        r9 = null;
    L33:
        String r10 = (String) r9;
        if (r10 != null) goto L40;
        if (r6 == null) goto L37;
        r10 = r6.optString("schema");
    L38:
        if (r10 != null) goto L40;
        r10 = "";
        goto L40
    L37:
        r10 = null;
    L40:
        if (r6 == null) goto L42;
        Object r11 = r6.opt("append_keys");
    L44:
        if ((r11 instanceof JSONArray) == true) goto L46;
        r11 = null;
    L46:
        JSONArray r12 = (JSONArray) r11;
        if (r12 == null) goto L51;
        Intrinsics.checkNotNullParameter(r12, "$this$toArrayList");
        ?? r13 = new ArrayList();
        int r14 = r12.length();
        int r15 = 0;
    L49:
        if (r15 >= r14) goto L52;
        r13.add(JSONArrayProtectorUtils.getString(r12, r15));
        r15 = r15 + 1;
    L52:
        if (r6 == null) goto L54;
        Object r16 = r6.opt("mega_object");
    L56:
        if ((r16 instanceof JSONObject) == true) goto L58;
        r16 = null;
    L58:
        JSONObject r17 = (JSONObject) r16;
        if (r17 != null) goto L62;
        r17 = new JSONObject();
    L62:
        if (r10.length() != 0) goto L64;
        boolean r18 = true;
    L65:
        if (r18 == false) goto L67;
        BuyNowLog.d("selfOpenSchema", "schema is empty");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.b.getTracker(), "selfOpenSchema", "schema is empty", r19);
    L67:
        boolean r20 = !((Collection) r13).isEmpty();
        ?? r21 = r13;
        if (r20 == true) goto L71;
        r21 = 0;
    L71:
        if (r21 == 0) goto L88;
        Iterator r22 = ((Iterable) r21).iterator();
    L74:
        if (r22.hasNext() == false) goto L88;
        String r23 = (String) r22.next();
        com.bytedance.kmp.ec.yata.store.node.c r110 = r19.j();
        if (r110 == null) goto L78;
        Map r111 = r110.s();
    L79:
        if (r23 == null) goto L81;
        List r112 = StringsKt.split$default(r23, new String[]{"."}, false, 0, 6, null);
    L82:
        Object r24 = com.bytedance.android.shopping.buynow.utils.n.a(r111, r112, 0);
        if (r24 == null) goto L85;
        String r25 = r24.toString();
    L86:
        r10 = l0.a(r10, r23, r25);
        goto L74
    L85:
        r25 = null;
        goto L86
    L81:
        r112 = null;
        goto L82
    L78:
        r111 = null;
    L88:
        if (r17.keys().hasNext() == false) goto L90;
        String r1 = UUID.randomUUID().toString();
        HashMap r26 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        com.bytedance.android.ec.core.hybrid.utils.j.h(r1, r17);
        r10 = l0.a(r10, "mega_object_id", r1);
    L90:
        if (r6 == null) goto L94;
        String r2 = r6.optString("btm");
        if (r2 == null) goto L94;
        BtmSDK r27 = BtmSDK.INSTANCE;
        PageFinder r28 = PageFinder.via(this.c);
        BcmParams.a r29 = BcmParams.Companion;
        String r30 = r6.optString("bcm");
        r29.getClass();
        r10 = l0.a(r10, "source_btm_token", r27.createJumpSourceBtmToken(r2, r28, BcmParams.a.a(r30)));
    L94:
        Float r31 = this.b.getStaticState().f;
        if (r31 == null) goto L97;
        float r32 = r31.floatValue();
    L98:
        BuyNowLog.d("selfOpenSchema", "ECLiveHybridUtil opening schema");
        Context r113 = this.a;
        Lazy r33 = SkuBuyNowPanelHeightHelper.a;
        ECLiveHybridUtil.k(r113, SkuBuyNowPanelHeightHelper.d(r10, Integer.valueOf((int) (r32 * 100.0f))), false, true, this.b.getStaticState().m, null, 204);
        com.bytedance.android.shopping.buynow.tracker.a r34 = this.b.getTracker();
        r34.getClass();
        List r35 = StringsKt.split$default(r10, new String[]{"&url="}, false, 0, 6, null);
        if (r35 == null) goto L101;
        String r36 = (String) CollectionsKt.getOrNull(r35, 1);
    L102:
        Pair[] r37 = new Pair[2];
        r37[0] = TuplesKt.to("type", "selfOpenSchema_run");
        if (r36 == null) goto L106;
        r10 = r36;
    L106:
        r37[1] = TuplesKt.to("desc", r10);
        r34.b("ies_ecommerce_fe_custom_log", MapsKt.mapOf(r37));
        BuyNowLog.d("selfOpenSchema", "selfOpenSchema finishes");
        int r38 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L101:
        r36 = null;
        goto L102
    L97:
        r32 = 0.0f;
        goto L98
    L64:
        r18 = false;
        goto L65
    L54:
        r16 = null;
        goto L56
    L51:
        r13 = CollectionsKt.emptyList();
        goto L52
    L42:
        r11 = null;
        goto L44
    L29:
        r9 = null;
        goto L31
    L24:
        if (r8.isEmpty() == false) goto L27;
    L21:
        if (r6.length() != 0) goto L27;
    L109:
    L13:
        BuyNowLog.d("selfOpenSchema", "error transforming fields to json");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.b.getTracker(), "selfOpenSchema", "error when transform yata fields to JSON", r19);
        goto L14
    L9:
        if ((r5 instanceof String) == false) goto L11;
        r6 = new JSONObject((String) r5);     // Catch: Exception -> L13
    L108:
        goto L15
    L11:
        r6 = tv5.a.a(ECHybridGsonUtil.a(), r5);     // Catch: Exception -> L13
        goto L108
    L5:
        r4 = null;
        goto L6
    }

    public p(Context r2, BuyNowViewModel r3, BuyNowFragment r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "buyNowViewModel");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
