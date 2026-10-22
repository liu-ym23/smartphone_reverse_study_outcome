package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends qf3.e {
    public final String d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.feed.jsb.a$a, reason: collision with other inner class name */
    public static final class C0086a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public a(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mallAdReport";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r6, IBDXBridgeContext r7, Map<String, ? extends Object> r8, Map<String, Object> r9) {
        Intrinsics.checkNotNullParameter(r6, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "result");
        Logger.d("puffone-NativeCommerceHomePage.initListEngine()", "ad广告上报");
        ECHybridListEngine r10 = r6.b.J;
        Intrinsics.checkNotNullParameter(r8, "params");
        if (r8.containsKey("actionName") == true) goto L5;
    L71:
        MapsKt.emptyMap();
    L73:
        return qf3.e.f(this);
    L5:
        if (r8.containsKey("section") == false) goto L71;
        if (r8.containsKey("index") == false) goto L71;
        Object r1 = r8.get("section");
        Object r3 = null;
        if ((r1 instanceof Integer) == true) goto L12;
        r1 = null;
    L12:
        Integer r2 = (Integer) r1;
        if (r2 == null) goto L70;
        int r4 = r2.intValue();
        int r5 = 0;
        if (r10 == null) goto L21;
        com.bytedance.android.ec.hybrid.list.entity.k r11 = r10.c.g;
        if (r11 == null) goto L21;
        ArrayList r12 = r11.c;
        if (r12 == null) goto L21;
        int r13 = r12.size();
    L22:
        if (r4 < 0) goto L69;
        if (r13 <= r4) goto L69;
        if (r10 == null) goto L39;
        com.bytedance.android.ec.hybrid.list.entity.k r14 = r10.c.g;
        if (r14 == null) goto L39;
        ArrayList r15 = r14.c;
        if (r15 == null) goto L39;
        Object r16 = r8.get("section");
        if ((r16 instanceof Integer) == true) goto L33;
        r16 = null;
    L33:
        Integer r17 = (Integer) r16;
        if (r17 == null) goto L36;
        r5 = r17.intValue();
    L36:
        com.bytedance.android.ec.hybrid.list.entity.i r18 = (com.bytedance.android.ec.hybrid.list.entity.i) ListProtector.get(r15, r5);
        if (r18 == null) goto L39;
        ArrayList r19 = r18.i;
    L40:
        if (r19 != null) goto L42;
    L68:
        MapsKt.emptyMap();
        goto L73
    L42:
        if ((!r19.isEmpty()) != true) goto L68;
        Object r0 = r8.get("index");
        if ((r0 instanceof Integer) == true) goto L46;
        r0 = null;
    L46:
        Integer r20 = (Integer) r0;
        if (r20 == null) goto L67;
        int r21 = r20.intValue();
        int r22 = r19.size();
        if (r21 < 0) goto L66;
        if (r22 <= r21) goto L66;
        Object r23 = r8.get("actionName");
        if ((r23 instanceof String) == true) goto L55;
        r23 = null;
    L55:
        String r24 = (String) r23;
        if (r24 != null) goto L58;
        r24 = "";
    L58:
        com.bytedance.android.ec.hybrid.list.entity.n r25 = ((ECHybridListItemVO) ListProtector.get(r19, r21)).o;
        Object r26 = r8.get("adExtraData");
        if ((r26 instanceof Map) == false) goto L62;
        r3 = r26;
    L62:
        Map r27 = (Map) r3;
        if (r27 != null) goto L65;
        r27 = MapsKt.emptyMap();
    L65:
        com.bytedance.android.shopping.mall.homepage.card.live.a.d(r25, r24, r27, (k93.g) r10.getAbility(k93.g.class));
    L66:
        MapsKt.emptyMap();
        goto L73
    L67:
        MapsKt.emptyMap();
    L39:
        r19 = null;
    L69:
        MapsKt.emptyMap();
    L21:
        r13 = 0;
        goto L22
    L70:
        MapsKt.emptyMap();
        goto L73
    }
}
