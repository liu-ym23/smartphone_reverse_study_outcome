package ui3;

import com.bytedance.android.ec.store.product.EventActionImplOpt;
import com.bytedance.android.shopping.store.lifecycle.m;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends EventActionImplOpt {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f550152c;

    public f() {
    }

    @Override // com.bytedance.android.ec.store.product.EventActionImplOpt, com.bytedance.android.ec.core.event.c
    public final void bindMonitorId(Long r100) {
        this.f550152c = r100;
    }

    @Override // com.bytedance.android.ec.store.product.EventActionImplOpt, com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, Pair<String, String>... r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "params");
        super.doEventAction(r100, (Pair[]) Arrays.copyOf(r101, r101.length));
        Map<Long, m> r102 = com.bytedance.android.shopping.store.lifecycle.a.f185441a;
        m r103 = com.bytedance.android.shopping.store.lifecycle.a.a(this.f550152c);
        if (r103 == null) goto L6;
        com.bytedance.android.shopping.store.lifecycle.c.a.a(r103, r100, MapsKt.plus(MapsKt.toMap(r101), b()), null, 4);
        return;
    }

    @Override // com.bytedance.android.ec.store.product.EventActionImplOpt, com.bytedance.android.ec.core.event.c
    public final void doAnyEventAction(String r100, Map<String, ? extends Object> r101, Pair<String, ? extends Object>... r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        super.doAnyEventAction(r100, r101, (Pair[]) Arrays.copyOf(r102, r102.length));
        Map<Long, m> r103 = com.bytedance.android.shopping.store.lifecycle.a.f185441a;
        m r104 = com.bytedance.android.shopping.store.lifecycle.a.a(this.f550152c);
        if (r104 == null) goto L8;
        if (r101 != null) goto L6;
        r101 = MapsKt.emptyMap();
    L6:
        com.bytedance.android.shopping.store.lifecycle.c.a.a(r104, r100, MapsKt.plus(MapsKt.plus(r101, r102), b()), null, 4);
        return;
    }

    @Override // com.bytedance.android.ec.store.product.EventActionImplOpt, com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, Map<String, String> r101, Pair<String, String>... r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        super.doEventAction(r100, r101, (Pair[]) Arrays.copyOf(r102, r102.length));
        Map<Long, m> r103 = com.bytedance.android.shopping.store.lifecycle.a.f185441a;
        m r104 = com.bytedance.android.shopping.store.lifecycle.a.a(this.f550152c);
        if (r104 == null) goto L8;
        if (r101 != null) goto L6;
        r101 = MapsKt.emptyMap();
    L6:
        com.bytedance.android.shopping.store.lifecycle.c.a.a(r104, r100, MapsKt.plus(MapsKt.plus(r101, r102), b()), null, 4);
        return;
    }
}
