package com.bytedance.android.shopping.card_list.eventcenter.event;

import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SelfChangeCounterActive extends com.bytedance.kmp.ec.yata.event.common.b {
    public final String a;
    public final Lazy b;
    public final CardListObjectContainer c;

    public SelfChangeCounterActive(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.c = r2;
        CardPassThroughData r3 = r2.e.a;
        if (r3 == null) goto L5;
        String r4 = r3.getMonitorId();
    L6:
        this.a = r4;
        this.b = LazyKt.lazy(new SelfChangeCounterActive$monitorManager$2(this));
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        com.bytedance.kmp.ec.yata.store.node.c r8 = r7.j();
        if (r8 == null) goto L5;
        String r9 = r8.getKey();
    L6:
        hb3.a r1 = this.c.e.l;
        if (r9 == null) goto L15;
        if (r1 == null) goto L15;
        Boolean r2 = Boolean.TRUE;
        Intrinsics.checkNotNullParameter(r9, "nodeKey");
        Intrinsics.checkNotNullParameter("counter_active", "name");
        Intrinsics.checkNotNullParameter(r2, "value");
        if (((LinkedHashMap) r1.a).get(r9) != null) goto L12;
        r1.a.put(r9, new HashMap());
    L12:
        Map r10 = (Map) ((LinkedHashMap) r1.a).get(r9);
        if (r10 == null) goto L15;
        r10.put("counter_active", r2);
    L15:
        CardListRunCatchExtKt.a(this.a, "SelfChangeCounterActive", new SelfChangeCounterActive$onExecuteSync$2(this));
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L5:
        r9 = null;
        goto L6
    }
}
