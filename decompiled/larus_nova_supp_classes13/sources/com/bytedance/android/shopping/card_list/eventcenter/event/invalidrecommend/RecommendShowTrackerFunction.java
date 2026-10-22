package com.bytedance.android.shopping.card_list.eventcenter.event.invalidrecommend;

import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.utils.g;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.kmp.ec.yata.event.common.b;
import com.bytedance.kmp.ec.yata.store.node.c;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class RecommendShowTrackerFunction extends b {
    public final Lazy a;
    public final CardListObjectContainer b;

    public RecommendShowTrackerFunction(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.b = r2;
        this.a = LazyKt.lazy(new RecommendShowTrackerFunction$trackerComponent$2(this));
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r15) {
        Intrinsics.checkNotNullParameter(r15, "input");
        c r0 = r15.j();
        if (r0 == null) goto L6;
        Map r1 = r0.s();
        if (r1 == null) goto L6;
    L7:
        c r16 = r15.j();
        String r2 = "";
        if (r16 == null) goto L11;
        String r17 = r16.getKey();
        if (r17 == null) goto L11;
    L12:
        Object r3 = g.a(g.a(r1, "basic_info"), PdpOpenThirdParam.KEY_PRODUCT_ID);
        if ((r3 instanceof String) == true) goto L15;
        r3 = null;
    L15:
        String r4 = (String) r3;
        if (r4 == null) goto L19;
        r2 = r4;
    L19:
        Object r5 = g.a(g.a(r1, "invalid_recommend_info"), "product_list");
        if ((r5 instanceof List) == true) goto L22;
        r5 = null;
    L22:
        List r6 = (List) r5;
        if (r6 == null) goto L25;
        Object r7 = CollectionsKt.firstOrNull(r6);
    L26:
        Object r8 = g.a(r7, "add_cart_schema");
        if ((r8 instanceof String) == true) goto L29;
        r8 = null;
    L29:
        String r9 = (String) r8;
        Object r10 = g.a(r1, "invalid_recommend_info");
        if (r10 == null) goto L32;
        Object r11 = g.a(r10, "find_more");
    L34:
        if ((r11 instanceof Map) == true) goto L36;
        r11 = null;
    L36:
        Map r12 = (Map) r11;
        if (r12 != null) goto L40;
        r12 = MapsKt.emptyMap();
    L40:
        if (r1.containsKey("invalid_recommend_info") == false) goto L81;
        Object r13 = g.a(r1, "invalid_recommend_info");
        if (r13 == null) goto L44;
        Object r14 = g.a(r13, "product_list");
    L46:
        if ((r14 instanceof List) == true) goto L48;
        r14 = null;
    L48:
        List r18 = (List) r14;
        if (r18 == null) goto L53;
        Object r19 = CollectionsKt.firstOrNull(r18);
        if (r19 == null) goto L53;
        Object r20 = g.a(r19, "log_data_struct");
    L55:
        if ((r20 instanceof Map) == true) goto L57;
        r20 = null;
    L57:
        Map<String, ? extends Object> r21 = (Map) r20;
        if (r21 != null) goto L60;
        r21 = MapsKt.emptyMap();
    L60:
        CardListTrackerComponent r22 = (CardListTrackerComponent) this.a.getValue();
        if (r22 == null) goto L63;
        r22.g("show_product", r21, "invalid_recommend_show_product:".concat(r17));
    L63:
        CardListTrackerComponent r23 = (CardListTrackerComponent) this.a.getValue();
        if (r23 == null) goto L66;
        r23.g(this.b.f.getStandardShowEventName(), MapsKt.mapOf(new Pair[]{TuplesKt.to("tab_name", "cart_invalid_similar_close"), TuplesKt.to("invalid_product_id", r2), TuplesKt.to("btm", "c0.d0")}), "invalid_recommend_show_product_close:".concat(r17));
    L66:
        if (r9 == null) goto L71;
        CardListTrackerComponent r24 = (CardListTrackerComponent) this.a.getValue();
        if (r24 == null) goto L71;
        r24.g("show_add_to_cart", MapsKt.mapOf(TuplesKt.to("btm", "c0.d0")), "invalid_recommend_show_product_add_cart:".concat(r17));
    L71:
        if ((!r12.isEmpty()) == false) goto L81;
        Object r25 = g.a(r12, "log_data_struct");
        if ((r25 instanceof Map) == true) goto L75;
        r25 = null;
    L75:
        Map<String, ? extends Object> r26 = (Map) r25;
        if (r26 != null) goto L78;
        r26 = MapsKt.emptyMap();
    L78:
        CardListTrackerComponent r27 = (CardListTrackerComponent) this.a.getValue();
        if (r27 == null) goto L81;
        r27.g(this.b.f.getStandardShowEventName(), r26, "invalid_recommend_show_product_find_more:".concat(r17));
    L53:
        r20 = null;
        goto L55
    L44:
        r14 = null;
    L81:
        int r110 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L32:
        r11 = null;
        goto L34
    L25:
        r7 = null;
    L11:
        r17 = "";
    L6:
        r1 = MapsKt.emptyMap();
        goto L7
    }
}
