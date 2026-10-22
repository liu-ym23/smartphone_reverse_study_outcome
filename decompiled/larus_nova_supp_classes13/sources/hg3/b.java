package hg3;

import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final Map<String, Object> a;
    public final WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.b> b;
    public final com.bytedance.android.shopping.orderlist.common.monitor.error.b c;

    public final void a(a r3) {
        Intrinsics.checkNotNullParameter(r3, "logModel");
        WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.b> r0 = this.b;
        if (r0 == null) goto L6;
        com.bytedance.android.shopping.orderlist.common.monitor.error.b r1 = r0.get();
        if (r1 == null) goto L6;
    L7:
        if (r1 == null) goto L10;
        r1.b("ies_ecommerce_fe_custom_log", MapsKt.plus(r3.a, this.a));
        return;
    L10:
        return;
    L6:
        r1 = this.c;
        goto L7
    }

    public b(WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.b> r1, com.bytedance.android.shopping.orderlist.common.monitor.error.b r2) {
        this.b = r1;
        this.c = r2;
        this.a = new LinkedHashMap();
    }
}
