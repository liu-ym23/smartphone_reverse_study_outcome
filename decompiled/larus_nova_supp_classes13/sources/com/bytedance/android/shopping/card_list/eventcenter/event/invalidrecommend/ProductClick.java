package com.bytedance.android.shopping.card_list.eventcenter.event.invalidrecommend;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.utils.g;
import com.bytedance.kmp.ec.yata.event.common.b;
import com.bytedance.kmp.ec.yata.store.node.c;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ProductClick extends b {
    public final Lazy a;
    public final CardListObjectContainer b;

    public ProductClick(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.b = r2;
        this.a = LazyKt.lazy(new ProductClick$trackerComponent$2(this));
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r18) {
        Intrinsics.checkNotNullParameter(r18, "input");
        int r1 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        boolean r2 = false;
        Unit r3 = null;
        com.bytedance.kmp.ec.yata.chain.event.b r5 = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
        c r4 = r18.j();
        if (r4 == null) goto L6;
        Map r6 = r4.s();
        if (r6 == null) goto L6;
    L7:
        Object r7 = g.a(r6, "invalid_recommend_info");
        if (r7 == null) goto L10;
        Object r8 = g.a(r7, "product_list");
    L12:
        if ((r8 instanceof List) == true) goto L14;
        r8 = null;
    L14:
        List r9 = (List) r8;
        if (r9 == null) goto L19;
        Object r10 = CollectionsKt.firstOrNull(r9);
        if (r10 == null) goto L19;
        Object r11 = g.a(r10, "log_data_struct");
    L21:
        if ((r11 instanceof Map) == true) goto L23;
        r11 = null;
    L23:
        Map r12 = (Map) r11;
        if (r12 != null) goto L26;
        r12 = MapsKt.emptyMap();
    L26:
        Object r13 = r12.get("btm");
        if ((r13 instanceof String) == true) goto L29;
        r13 = null;
    L29:
        String r14 = (String) r13;
        Object r15 = r12.get("bcm");
        if ((r15 instanceof Map) == true) goto L32;
        r15 = null;
    L32:
        Map r16 = (Map) r15;
        CardListTrackerComponent r17 = (CardListTrackerComponent) this.a.getValue();
        if (r17 == null) goto L35;
        CardListTrackerComponent.h(r17, "click_product", r12, 4);
    L35:
        Object r19 = g.a(g.a(r6, "invalid_recommend_info"), "product_list");
        if ((r19 instanceof List) == true) goto L38;
        r19 = null;
    L38:
        List r20 = (List) r19;
        if (r20 == null) goto L41;
        Object r21 = CollectionsKt.firstOrNull(r20);
    L42:
        Object r22 = g.a(r21, "detail_url");
        if ((r22 instanceof String) == true) goto L45;
        r22 = null;
    L45:
        String r23 = (String) r22;
        Context r24 = this.b.getContext();
        if (r23 == null) goto L77;
        if (r24 == null) goto L77;
        if (r23.length() != 0) goto L51;
        boolean r25 = true;
    L52:
        if (r25 == false) goto L55;
        com.bytedance.kmp.ec.yata.chain.event.b r26 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "schema is empty", null, null, 57);
    L54:
        r5 = r26;
        r3 = Unit.INSTANCE;
        goto L77
    L55:
        if (r14 != null) goto L57;
    L60:
        boolean r27 = true;
    L61:
        if (r27 == true) goto L63;
        int r28 = a.a;
        Uri r29 = a.a(r24, r23, r14, r16, this.b.e.g);
    L72:
        int r30 = ECSdk.a;
        IAdapterService r31 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r31 == null) goto L75;
        IAdapterService.a.a(r31, r24, r29, true, 8);
    L75:
        r26 = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
        goto L54
    L63:
        if (r14 == null) goto L68;
        BtmSDK r32 = BtmSDK.INSTANCE;
        BtmItemBuilder r33 = new BtmItemBuilder(r14, Boolean.TRUE).withPageFinder(this.b.e.g);
        BcmParams.a r110 = BcmParams.Companion;
        Object r34 = g.a(r12, "bcm_description");
        if ((r34 instanceof Map) == true) goto L67;
        r34 = null;
    L67:
        r110.getClass();
        r33.internalSetUnitParams("description", BcmParams.a.c((Map) r34));
        r32.createBtmChain(r33.build());
    L68:
        PageFinder r35 = this.b.e.g;
        if (r35 == null) goto L71;
        com.bytedance.android.bcm.api.b.f(r35, MapsKt.emptyMap());
    L71:
        r29 = UriProtector.parse(r23);
        goto L72
    L57:
        if (r14.length() == 0) goto L60;
        r27 = false;
        goto L61
    L51:
        r25 = false;
    L77:
        if (r3 != null) goto L87;
        if (r23 != null) goto L80;
    L81:
        r2 = true;
    L82:
        if (r2 == false) goto L84;
        String r36 = "schema is null";
    L85:
        com.bytedance.kmp.ec.yata.chain.event.b r37 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, r36, null, null, 57);
        Unit r38 = Unit.INSTANCE;
        return r37;
    L84:
        r36 = "context is null";
        goto L85
    L80:
        if (r23.length() != 0) goto L82;
    L87:
        return r5;
    L41:
        r21 = null;
    L19:
        r11 = null;
        goto L21
    L10:
        r8 = null;
    L6:
        r6 = MapsKt.emptyMap();
        goto L7
    }
}
