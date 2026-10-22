package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i0 extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public i0(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mallScrollToFavoriteCell";
    }

    @Override // qf3.e
    public final void realHandle(IBDXBridgeContext r20, Map<String, ? extends Object> r21, IDLXBridgeMethod.a r22) {
        Intrinsics.checkNotNullParameter(r20, "bridgeContext");
        Intrinsics.checkNotNullParameter(r21, "params");
        Intrinsics.checkNotNullParameter(r22, "callback");
        LinkedHashMap r3 = new LinkedHashMap();
        if (r21.isEmpty() == false) goto L5;
        r3.put("code", 0);
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("err_message", "params is empty");
        Unit r5 = Unit.INSTANCE;
        r3.put("data", r4);
    L68:
        r22.invoke(r3);
        a(r21, r3);
        return;
    L5:
        Object r6 = r21.get("sectionID");
        if ((r6 instanceof String) == true) goto L8;
        r6 = null;
    L8:
        String r13 = (String) r6;
        Object r7 = r21.get("itemID");
        if ((r7 instanceof String) == true) goto L11;
        r7 = null;
    L11:
        String r14 = (String) r7;
        Object r8 = r21.get("itemIndex");
        if ((r8 instanceof Integer) == true) goto L14;
        r8 = null;
    L14:
        Integer r15 = (Integer) r8;
        int r9 = com.bytedance.android.ec.hybrid.list.util.c.a;
        Object r10 = r21.get("offset");
        if ((r10 instanceof Integer) == true) goto L17;
        r10 = null;
    L17:
        Integer r11 = (Integer) r10;
        if (r11 == null) goto L20;
        int r12 = r11.intValue();
    L21:
        int r16 = com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(r12));
        Object r17 = r21.get("animated");
        if ((r17 instanceof Boolean) == true) goto L24;
        r17 = null;
    L24:
        Boolean r18 = Boolean.TRUE;
        boolean r19 = Intrinsics.areEqual((Boolean) r17, r18);
        Object r23 = r21.get("forceScroll");
        if ((r23 instanceof Boolean) == true) goto L27;
        r23 = null;
    L27:
        boolean r110 = Intrinsics.areEqual((Boolean) r23, r18);
        Object r24 = r21.get("ignoreRepeatScroll");
        if ((r24 instanceof Boolean) == true) goto L30;
        r24 = null;
    L30:
        boolean r25 = Intrinsics.areEqual((Boolean) r24, r18);
        Object r111 = r21.get("onlyWhenHeaderCardVisible");
        if ((r111 instanceof Boolean) == true) goto L33;
        r111 = null;
    L33:
        boolean r1 = Intrinsics.areEqual((Boolean) r111, r18);
        if (r13 != null) goto L36;
    L39:
        boolean r112 = true;
    L40:
        if (r112 == false) goto L42;
        r3.put("code", 0);
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("err_message", "section_id is null or empty");
        Unit r26 = Unit.INSTANCE;
        r3.put("data", r2);
        goto L68
    L42:
        ECHybridListEngine r27 = this.c.b.J;
        if (r1 == false) goto L50;
        if (r27 == null) goto L50;
        com.bytedance.android.ec.hybrid.list.ability.h0 r28 = (com.bytedance.android.ec.hybrid.list.ability.h0) r27.getAbility(com.bytedance.android.ec.hybrid.list.ability.h0.class);
        if (r28 == null) goto L50;
        if (r28.a() == true) goto L50;
        boolean r29 = false;
    L66:
        boolean r30 = false;
    L67:
        r3.put("code", 1);
        LinkedHashMap r31 = new LinkedHashMap();
        r31.put("is_success", Boolean.valueOf(r30));
        r31.put("scroll", Boolean.valueOf(r29));
        Unit r32 = Unit.INSTANCE;
        r3.put("data", r31);
    L50:
        if (r14 != null) goto L59;
        if (r15 != null) goto L59;
        if (r27 == null) goto L65;
        com.bytedance.android.ec.hybrid.list.ability.e0 r33 = (com.bytedance.android.ec.hybrid.list.ability.e0) r27.getAbility(com.bytedance.android.ec.hybrid.list.ability.e0.class);
        if (r33 == null) goto L65;
        if (r33.a(r13, r16, r19, new zj.b(r25)) != true) goto L65;
    L64:
        r29 = true;
        r30 = true;
    L65:
        r29 = true;
    L59:
        if (r27 == null) goto L65;
        com.bytedance.android.ec.hybrid.list.ability.e0 r34 = (com.bytedance.android.ec.hybrid.list.ability.e0) r27.getAbility(com.bytedance.android.ec.hybrid.list.ability.e0.class);
        if (r34 == null) goto L65;
        if (r34.b(new zj.a(r13, r14, r15, r16, r19, r110)) != true) goto L65;
    L36:
        if (r13.length() == 0) goto L39;
        r112 = false;
        goto L40
    L20:
        r12 = 0;
        goto L21
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        return qf3.e.f(this);
    }
}
