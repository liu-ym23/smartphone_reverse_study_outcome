package com.bytedance.android.shopping.card_list.eventcenter.event;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends com.bytedance.kmp.ec.yata.event.common.b {
    public final com.bytedance.android.shopping.card_list.components.g a;
    public final CardListObjectContainer b;

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r14) {
        Intrinsics.checkNotNullParameter(r14, "input");
        Map r0 = r14.q();
        com.bytedance.kmp.ec.yata.chain.event.b r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.get("btm");
    L7:
        if ((r2 instanceof String) == true) goto L9;
        r2 = null;
    L9:
        String r3 = (String) r2;
        if (r0 == null) goto L12;
        Object r4 = r0.get("bcm");
    L14:
        if ((r4 instanceof Map) == true) goto L16;
        r4 = null;
    L16:
        Map r5 = (Map) r4;
        if (r0 == null) goto L19;
        Object r6 = r0.get("schema");
    L21:
        if ((r6 instanceof String) == true) goto L23;
        r6 = null;
    L23:
        String r7 = (String) r6;
        Context r8 = this.b.getContext();
        boolean r9 = false;
        if (r7 == null) goto L60;
        if (r8 == null) goto L60;
        if (r7.length() != 0) goto L29;
        boolean r10 = true;
    L30:
        if (r10 == false) goto L33;
        int r15 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        com.bytedance.kmp.ec.yata.chain.event.b r16 = com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "schema is empty", null, null, 57);
    L32:
        r1 = r16;
        goto L60
    L33:
        if (r3 != null) goto L35;
    L38:
        boolean r11 = true;
    L39:
        String r12 = "";
        if (r11 == true) goto L50;
        int r13 = com.bytedance.android.shopping.card_list.eventcenter.event.invalidrecommend.a.a;
        Uri r17 = com.bytedance.android.shopping.card_list.eventcenter.event.invalidrecommend.a.a(r8, r7, r3, r5, this.b.e.g);
        Function2<String, String, Unit> r18 = this.a.a;
        String r19 = r17.toString();
        com.bytedance.kmp.ec.yata.store.node.c r110 = r14.j();
        if (r110 == null) goto L47;
        String r111 = r110.getKey();
        if (r111 == null) goto L47;
        r12 = r111;
    L47:
        r18.invoke(r19, r12);
        int r112 = ECSdk.a;
        IAdapterService r113 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r113 == null) goto L59;
        IAdapterService.a.a(r113, r8, r17, true, 8);
    L59:
        int r114 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r16 = com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
        goto L32
    L50:
        Function2<String, String, Unit> r20 = this.a.a;
        com.bytedance.kmp.ec.yata.store.node.c r115 = r14.j();
        if (r115 == null) goto L56;
        String r116 = r115.getKey();
        if (r116 == null) goto L56;
        r12 = r116;
    L56:
        r20.invoke(r7, r12);
        int r117 = ECSdk.a;
        IAdapterService r118 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r118 == null) goto L59;
        IAdapterService.a.a(r118, r8, UriProtector.parse(r7), true, 8);
        goto L59
    L35:
        if (r3.length() == 0) goto L38;
        r11 = false;
        goto L39
    L29:
        r10 = false;
    L60:
        if (r1 != null) goto L70;
        if (r7 != null) goto L63;
    L64:
        r9 = true;
    L65:
        if (r9 == false) goto L67;
        String r119 = "schema is null";
    L68:
        String r21 = r119;
        int r120 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, r21, null, null, 57);
    L67:
        r119 = "context is null";
        goto L68
    L63:
        if (r7.length() != 0) goto L65;
    L70:
        return r1;
    L19:
        r6 = null;
        goto L21
    L12:
        r4 = null;
        goto L14
    L5:
        r2 = null;
        goto L7
    }

    public d(com.bytedance.android.shopping.card_list.components.g r2, CardListObjectContainer r3) {
        Intrinsics.checkNotNullParameter(r2, "actions");
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        this.a = r2;
        this.b = r3;
    }
}
