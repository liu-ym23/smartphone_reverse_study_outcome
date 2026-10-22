package hg3;

import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static final /* synthetic */ int c = 0;
    public final Map<String, Object> a;
    public final WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.a> b;

    public static final class a {
    }

    static {
    }

    public d(WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "reporter");
        this.b = r2;
        this.a = new LinkedHashMap();
    }

    public final void a(String r4, String r5, String r6, Map<String, ? extends Object> r7) {
        this.a.put("type", "COMMON_LOG");
        this.a.put("desc", "active_trigger_event");
        this.a.put("source_event_name", r4);
        this.a.put("event_name", r4);
        this.a.put("trigger_event_name", r5);
        this.a.put("trigger_node_key", r6);
        this.a.put("trigger_params", r7);
        com.bytedance.android.shopping.orderlist.common.monitor.error.a r8 = this.b.get();
        if (r8 == null) goto L5;
        r8.b("ies_ecommerce_fe_custom_log", this.a);
    L5:
        ((LinkedHashMap) this.a).clear();
    }

    public final void b(String r4, String r5, String r6, Boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "saveTriggerEventName");
        Intrinsics.checkNotNullParameter(r6, "nodeKey");
        this.a.put("type", "COMMON_LOG");
        this.a.put("desc", "custom_event_start");
        this.a.put("source_event_name", r4);
        this.a.put("event_name", r4);
        this.a.put("save_trigger_event_name", r5);
        this.a.put("node_key", r6);
        if (r7 == null) goto L9;
        Map<String, Object> r8 = this.a;
        if (r7.booleanValue() == false) goto L7;
        String r9 = "1";
    L8:
        r8.put("is_save_preload_task", r9);
        goto L9
    L7:
        r9 = "0";
    L9:
        com.bytedance.android.shopping.orderlist.common.monitor.error.a r10 = this.b.get();
        if (r10 == null) goto L12;
        r10.b("ies_ecommerce_fe_custom_log", this.a);
    L12:
        ((LinkedHashMap) this.a).clear();
    }
}
