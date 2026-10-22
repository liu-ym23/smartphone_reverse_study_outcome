package ui3;

import com.bytedance.android.ec.store.product.EventActionImplOpt;
import com.bytedance.android.shopping.store.lifecycle.m;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends EventActionImplOpt {
    public Long c;

    public f() {
    }

    public final void bindMonitorId(Long r1) {
        this.c = r1;
    }

    public final void doEventAction(String r4, Pair<String, String>... r5) {
        Intrinsics.checkNotNullParameter(r4, "actionName");
        Intrinsics.checkNotNullParameter(r5, "params");
        super.doEventAction(r4, (Pair[]) Arrays.copyOf(r5, r5.length));
        Map<Long, m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
        m r1 = com.bytedance.android.shopping.store.lifecycle.a.a(this.c);
        if (r1 == null) goto L6;
        com.bytedance.android.shopping.store.lifecycle.c.a.a(r1, r4, MapsKt.plus(MapsKt.toMap(r5), b()), null, 4);
        return;
    }

    public final void doAnyEventAction(String r3, Map<String, ? extends Object> r4, Pair<String, ? extends Object>... r5) {
        Intrinsics.checkNotNullParameter(r3, "actionName");
        Intrinsics.checkNotNullParameter(r5, "params");
        super.doAnyEventAction(r3, r4, (Pair[]) Arrays.copyOf(r5, r5.length));
        Map<Long, m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
        m r1 = com.bytedance.android.shopping.store.lifecycle.a.a(this.c);
        if (r1 == null) goto L8;
        if (r4 != null) goto L6;
        r4 = MapsKt.emptyMap();
    L6:
        com.bytedance.android.shopping.store.lifecycle.c.a.a(r1, r3, MapsKt.plus(MapsKt.plus(r4, r5), b()), null, 4);
        return;
    }

    public final void doEventAction(String r3, Map<String, String> r4, Pair<String, String>... r5) {
        Intrinsics.checkNotNullParameter(r3, "actionName");
        Intrinsics.checkNotNullParameter(r5, "params");
        super.doEventAction(r3, r4, (Pair[]) Arrays.copyOf(r5, r5.length));
        Map<Long, m> r0 = com.bytedance.android.shopping.store.lifecycle.a.a;
        m r1 = com.bytedance.android.shopping.store.lifecycle.a.a(this.c);
        if (r1 == null) goto L8;
        if (r4 != null) goto L6;
        r4 = MapsKt.emptyMap();
    L6:
        com.bytedance.android.shopping.store.lifecycle.c.a.a(r1, r3, MapsKt.plus(MapsKt.plus(r4, r5), b()), null, 4);
        return;
    }
}
