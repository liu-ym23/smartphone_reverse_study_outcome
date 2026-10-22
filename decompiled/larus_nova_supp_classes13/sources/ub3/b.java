package ub3;

import com.bytedance.android.shopping.collect.container.CollectYataViewModel;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.kmp.ec.yata.store.core.a {
    public final CollectYataViewModel a;

    public final void d() {
    }

    public final void e() {
    }

    public b(CollectYataViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "collectYataViewModel");
        this.a = r2;
    }

    public final void b(com.bytedance.kmp.ec.yata.store.core.a.a r2) {
        Intrinsics.checkNotNullParameter(r2, "modifier");
        r2.c();
    }

    public final void c(com.bytedance.kmp.ec.yata.store.core.a.a r4) {
        Intrinsics.checkNotNullParameter(r4, "modifier");
        String r0 = r4.b();
        Map r5 = r4.a();
        if (r0 == null) goto L9;
        if (r5 == null) goto L10;
        a r1 = this.a.getCollectCustomDataCenter();
        if (r1 == null) goto L11;
        Intrinsics.checkNotNullParameter(r0, "nodeKey");
        Intrinsics.checkNotNullParameter(r5, "map");
        r1.a.put(r0, MapsKt.toMutableMap(r5));
        return;
    L11:
        return;
    L10:
        return;
    }
}
