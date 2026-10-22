package com.bytedance.android.shopping.orderlist.common.monitor.error;

import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final Map<String, Object> a;
    public final WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.a> b;

    public static final class a {
    }

    static {
    }

    public c(WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.a> r3) {
        Intrinsics.checkNotNullParameter(r3, "reporter");
        this.b = r3;
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("type", "COMMON_LOG");
        Unit r0 = Unit.INSTANCE;
        this.a = r4;
    }

    public final void a(Map r5) {
        Intrinsics.checkNotNullParameter("custom_event_fields_error", "desc");
        Intrinsics.checkNotNullParameter("selfSaveTrigger", "errorEventName");
        Intrinsics.checkNotNullParameter(r5, "extraParams");
        this.a.put("desc", "custom_event_fields_error");
        this.a.put("error_event_name", "selfSaveTrigger");
        this.a.putAll(r5);
        com.bytedance.android.shopping.orderlist.common.monitor.error.a r6 = this.b.get();
        if (r6 == null) goto L6;
        r6.b("ies_ecommerce_fe_custom_log", this.a);
        return;
    }

    public final void b(String r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "desc");
        Intrinsics.checkNotNullParameter(r4, "extraParams");
        this.a.put("desc", r3);
        this.a.putAll(r4);
        com.bytedance.android.shopping.orderlist.common.monitor.error.a r5 = this.b.get();
        if (r5 == null) goto L6;
        r5.b("ies_ecommerce_fe_custom_log", this.a);
        return;
    }
}
