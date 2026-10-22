package com.bytedance.android.shopping.card_list.eventcenter.event.invalidrecommend;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.utils.g;
import com.bytedance.kmp.ec.yata.event.common.b;
import com.bytedance.kmp.ec.yata.store.node.c;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AddToCart extends b {
    public final Lazy a;
    public final CardListObjectContainer b;

    public AddToCart(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.b = r2;
        this.a = LazyKt.lazy(new AddToCart$trackerComponent$2(this));
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r14) {
        Intrinsics.checkNotNullParameter(r14, "input");
        int r0 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        boolean r1 = false;
        Unit r2 = null;
        com.bytedance.kmp.ec.yata.chain.event.b r3 = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
        c r4 = r14.j();
        if (r4 == null) goto L6;
        Map r5 = r4.s();
        if (r5 == null) goto L6;
    L7:
        Object r6 = g.a(r5, "invalid_recommend_info");
        if (r6 == null) goto L12;
        Object r7 = g.a(r6, "find_more");
        if (r7 == null) goto L12;
        Object r8 = g.a(r7, "log_data_struct");
    L14:
        if ((r8 instanceof Map) == true) goto L17;
        r8 = null;
    L17:
        if (((Map) r8) != null) goto L19;
        MapsKt.emptyMap();
    L19:
        Map r15 = r14.q();
        if (r15 == null) goto L22;
        Object r16 = r15.get("btm");
    L24:
        if ((r16 instanceof String) == true) goto L26;
        r16 = null;
    L26:
        String r17 = (String) r16;
        Object r9 = g.a(g.a(r5, "invalid_recommend_info"), "product_list");
        if ((r9 instanceof List) == true) goto L29;
        r9 = null;
    L29:
        List r10 = (List) r9;
        if (r10 == null) goto L32;
        Object r11 = CollectionsKt.firstOrNull(r10);
    L33:
        Object r12 = g.a(r11, "add_cart_schema");
        if ((r12 instanceof String) == true) goto L36;
        r12 = null;
    L36:
        String r13 = (String) r12;
        CardListTrackerComponent r18 = (CardListTrackerComponent) this.a.getValue();
        if (r18 == null) goto L39;
        CardListTrackerComponent.h(r18, "click_add_to_cart", MapsKt.mapOf(TuplesKt.to("btm", r17)), 4);
    L39:
        Context r19 = this.b.getContext();
        if (r13 == null) goto L57;
        if (r19 == null) goto L57;
        if (r13.length() != 0) goto L45;
        boolean r20 = true;
    L46:
        if (r20 == false) goto L49;
        com.bytedance.kmp.ec.yata.chain.event.b r110 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "schema is empty", null, null, 57);
    L48:
        r3 = r110;
        r2 = Unit.INSTANCE;
        goto L57
    L49:
        int r21 = a.a;
        if (r17 != null) goto L52;
        r17 = "";
    L52:
        Uri r111 = a.a(r19, r13, r17, MapsKt.emptyMap(), this.b.e.g);
        int r22 = ECSdk.a;
        IAdapterService r23 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r23 == null) goto L55;
        IAdapterService.a.a(r23, r19, r111, true, 8);
    L55:
        r110 = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
        goto L48
    L45:
        r20 = false;
    L57:
        if (r2 != null) goto L67;
        if (r13 != null) goto L60;
    L61:
        r1 = true;
    L62:
        if (r1 == false) goto L64;
        String r112 = "schema is null";
    L65:
        com.bytedance.kmp.ec.yata.chain.event.b r24 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, r112, null, null, 57);
        Unit r113 = Unit.INSTANCE;
        return r24;
    L64:
        r112 = "context is null";
        goto L65
    L60:
        if (r13.length() != 0) goto L62;
    L67:
        return r3;
    L32:
        r11 = null;
        goto L33
    L22:
        r16 = null;
    L12:
        r8 = null;
    L6:
        r5 = MapsKt.emptyMap();
        goto L7
    }
}
