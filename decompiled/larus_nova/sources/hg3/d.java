package hg3;

import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f485008c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f485009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.a> f485010b;

    public static final class a {
    }

    static {
    }

    public d(WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "reporter");
        this.f485010b = r100;
        this.f485009a = new LinkedHashMap();
    }

    public final void a(String r100, String r101, String r102, Map<String, ? extends Object> r103) {
        this.f485009a.put("type", "COMMON_LOG");
        this.f485009a.put(SocialConstants.PARAM_APP_DESC, "active_trigger_event");
        this.f485009a.put("source_event_name", r100);
        this.f485009a.put(ReportCardMonitorPlugin.EVENT_NAME, r100);
        this.f485009a.put("trigger_event_name", r101);
        this.f485009a.put("trigger_node_key", r102);
        this.f485009a.put("trigger_params", r103);
        com.bytedance.android.shopping.orderlist.common.monitor.error.a r104 = this.f485010b.get();
        if (r104 == null) goto L5;
        r104.b("ies_ecommerce_fe_custom_log", this.f485009a);
    L5:
        ((LinkedHashMap) this.f485009a).clear();
    }

    public final void b(String r100, String r101, String r102, Boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "saveTriggerEventName");
        Intrinsics.checkNotNullParameter(r102, "nodeKey");
        this.f485009a.put("type", "COMMON_LOG");
        this.f485009a.put(SocialConstants.PARAM_APP_DESC, "custom_event_start");
        this.f485009a.put("source_event_name", r100);
        this.f485009a.put(ReportCardMonitorPlugin.EVENT_NAME, r100);
        this.f485009a.put("save_trigger_event_name", r101);
        this.f485009a.put("node_key", r102);
        if (r103 == null) goto L9;
        Map<String, Object> r104 = this.f485009a;
        if (r103.booleanValue() == false) goto L7;
        String r105 = "1";
    L8:
        r104.put("is_save_preload_task", r105);
        goto L9
    L7:
        r105 = "0";
    L9:
        com.bytedance.android.shopping.orderlist.common.monitor.error.a r106 = this.f485010b.get();
        if (r106 == null) goto L12;
        r106.b("ies_ecommerce_fe_custom_log", this.f485009a);
    L12:
        ((LinkedHashMap) this.f485009a).clear();
    }
}
