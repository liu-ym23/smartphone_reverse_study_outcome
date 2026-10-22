package com.bytedance.android.shopping.orderlist.common.controller;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p {
    public final Map<String, Map<String, o>> a;
    public final Map<String, ti.j> b;
    public final AndroidYaTaInstance c;
    public final ig3.a d;

    public static final class a {
    }

    static {
    }

    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "sceneType");
        Iterator r0 = ((LinkedHashMap) this.b).keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = (String) r0.next();
        ti.j r2 = (ti.j) ((LinkedHashMap) this.b).get(r1);
        if (r2 == null) goto L4;
        ECLiveHybridUtil.p(r1, r2);
        goto L4
    L8:
        ((LinkedHashMap) this.b).clear();
        ((LinkedHashMap) this.a).clear();
        ig3.a r3 = this.d;
        if (r3 == null) goto L19;
        com.bytedance.android.shopping.orderlist.common.monitor.error.c r5 = r3.f;
        if (r5 == null) goto L20;
        r5.b("unsubscribe_save_listener", MapsKt.mapOf(TuplesKt.to("scene_type", r4)));
        return;
    L20:
        return;
    }

    public p(AndroidYaTaInstance r1, ig3.a r2) {
        this.c = r1;
        this.d = r2;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
    }

    public final void b(String r6, String r7) {
        Map r0 = (Map) ((LinkedHashMap) this.a).get(r6);
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return;
    L11:
        ti.j r2 = this.b.remove(r6);
        if (r2 == null) goto L20;
        ECLiveHybridUtil.p(r6, r2);
        if (a2.b(r7) == false) goto L20;
        ig3.a r3 = this.d;
        if (r3 == null) goto L20;
        com.bytedance.android.shopping.orderlist.common.monitor.error.c r4 = r3.f;
        if (r4 == null) goto L20;
        r4.b("unsubscribe_save_trigger", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene_type", r7), TuplesKt.to("listener_name", r6)}));
    L20:
        this.a.remove(r6);
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
