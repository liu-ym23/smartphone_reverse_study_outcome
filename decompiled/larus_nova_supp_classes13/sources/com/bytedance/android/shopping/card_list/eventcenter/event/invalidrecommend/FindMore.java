package com.bytedance.android.shopping.card_list.eventcenter.event.invalidrecommend;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.utils.g;
import com.bytedance.kmp.ec.yata.event.common.b;
import com.bytedance.kmp.ec.yata.store.node.c;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class FindMore extends b {
    public final Lazy a;
    public final CardListObjectContainer b;

    public FindMore(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.b = r2;
        this.a = LazyKt.lazy(new FindMore$trackerComponent$2(this));
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
        if (r7 == null) goto L12;
        Object r8 = g.a(r7, "find_more");
        if (r8 == null) goto L12;
        Object r9 = g.a(r8, "log_data_struct");
    L14:
        if ((r9 instanceof Map) == true) goto L16;
        r9 = null;
    L16:
        Map r10 = (Map) r9;
        if (r10 != null) goto L19;
        r10 = MapsKt.emptyMap();
    L19:
        Object r11 = r10.get("btm");
        if ((r11 instanceof String) == true) goto L22;
        r11 = null;
    L22:
        String r12 = (String) r11;
        Object r13 = r10.get("bcm");
        if ((r13 instanceof Map) == true) goto L25;
        r13 = null;
    L25:
        Map r14 = (Map) r13;
        CardListTrackerComponent r15 = (CardListTrackerComponent) this.a.getValue();
        if (r15 == null) goto L28;
        CardListTrackerComponent.h(r15, this.b.f.getStandardClickEventName(), r10, 4);
    L28:
        Object r16 = g.a(g.a(g.a(r6, "invalid_recommend_info"), "find_more"), "link");
        if ((r16 instanceof String) == true) goto L31;
        r16 = null;
    L31:
        String r17 = (String) r16;
        Context r19 = this.b.getContext();
        if (r17 == null) goto L60;
        if (r19 == null) goto L60;
        if (r17.length() != 0) goto L37;
        boolean r20 = true;
    L38:
        if (r20 == false) goto L41;
        com.bytedance.kmp.ec.yata.chain.event.b r21 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "schema is empty", null, null, 57);
    L40:
        r5 = r21;
        r3 = Unit.INSTANCE;
        goto L60
    L41:
        if (r12 != null) goto L43;
    L46:
        boolean r22 = true;
    L47:
        if (r22 == true) goto L49;
        int r23 = a.a;
        Uri r24 = a.a(r19, r17, r12, r14, this.b.e.g);
    L55:
        int r25 = ECSdk.a;
        IAdapterService r26 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r26 == null) goto L58;
        IAdapterService.a.a(r26, r19, r24, true, 8);
    L58:
        r21 = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
        goto L40
    L49:
        if (r12 == null) goto L54;
        BtmSDK r27 = BtmSDK.INSTANCE;
        BtmItemBuilder r28 = new BtmItemBuilder(r12, Boolean.TRUE).withPageFinder(this.b.e.g);
        BcmParams.a r110 = BcmParams.Companion;
        Object r29 = g.a(r10, "bcm_description");
        if ((r29 instanceof Map) == true) goto L53;
        r29 = null;
    L53:
        r110.getClass();
        r28.internalSetUnitParams("description", BcmParams.a.c((Map) r29));
        r27.createBtmChain(r28.build());
    L54:
        r24 = UriProtector.parse(r17);
        goto L55
    L43:
        if (r12.length() == 0) goto L46;
        r22 = false;
        goto L47
    L37:
        r20 = false;
    L60:
        if (r3 != null) goto L70;
        if (r17 != null) goto L63;
    L64:
        r2 = true;
    L65:
        if (r2 == false) goto L67;
        String r30 = "schema is null";
    L68:
        com.bytedance.kmp.ec.yata.chain.event.b r31 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, r30, null, null, 57);
        Unit r32 = Unit.INSTANCE;
        return r31;
    L67:
        r30 = "context is null";
        goto L68
    L63:
        if (r17.length() != 0) goto L65;
    L70:
        return r5;
    L12:
        r9 = null;
    L6:
        r6 = MapsKt.emptyMap();
        goto L7
    }
}
