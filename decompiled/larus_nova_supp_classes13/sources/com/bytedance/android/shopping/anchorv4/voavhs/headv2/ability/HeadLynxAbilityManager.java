package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class HeadLynxAbilityManager {
    public Map<String, com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c> a;
    public Map<String, Boolean> b;
    public final Lazy c;
    public final s d;

    public HeadLynxAbilityManager(s r2) {
        Intrinsics.checkNotNullParameter(r2, "headAbilityManager");
        this.d = r2;
        this.c = LazyKt.lazy(HeadLynxAbilityManager$itemViewLynxListener$2.INSTANCE);
    }

    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Map<String, com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c> r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c) ((LinkedHashMap) r0).get(r2);
    }

    public final boolean b(com.bytedance.android.shopping.anchorv4.voavhs.headv2.j r4) {
        if (r4 == null) goto L5;
        String r0 = r4.a();
        if (r0 == null) goto L5;
    L6:
        Intrinsics.checkNotNullParameter(r0, "key");
        Map<String, Boolean> r1 = this.b;
        Boolean r2 = null;
        if (r1 == null) goto L9;
        Boolean r3 = (Boolean) ((LinkedHashMap) r1).get(r0);
    L10:
        if (r3 != null) goto L13;
        if (r4 == null) goto L14;
        r2 = Boolean.valueOf(r4.f());
    L14:
        if (r2 != null) goto L18;
        return false;
    L18:
        return r2.booleanValue();
    L13:
        r2 = r3;
        goto L14
    L9:
        r3 = null;
    L5:
        r0 = "";
        goto L6
    }

    public final void c(String r3, ti.j r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r4 != null) goto L5;
        return;
    L5:
        List r0 = (List) ((Map) this.c.getValue()).get(r3);
        if (r0 != null) goto L8;
        r0 = new ArrayList();
        ((Map) this.c.getValue()).put(r3, r0);
    L8:
        r0.add(r4);
        ECLiveHybridUtil.m(r3, r4);
    }

    public final void d(String r2, com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        if (r3 == null) goto L10;
        Map<String, com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c> r0 = this.a;
        if (r0 == null) goto L11;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.c r4 = r0.put(r2, r3);
        return;
    L11:
        return;
    }

    public final void e(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (this.b != null) goto L5;
        this.b = new LinkedHashMap();
    L5:
        Map<String, Boolean> r0 = this.b;
        if (r0 == null) goto L9;
        Boolean r4 = r0.put(r2, Boolean.valueOf(r3));
        return;
    }

    public final void f(String r2, ti.j r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        ECLiveHybridUtil.p(r2, r3);
        List r4 = (List) ((Map) this.c.getValue()).get(r2);
        if (r4 != null) goto L5;
        return;
    L5:
        r4.remove(r3);
    }
}
