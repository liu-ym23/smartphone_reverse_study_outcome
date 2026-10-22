package mhc;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.CertRuleStatusMap;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.ss.android.ugc.route_monitor.utils.Logger;
import com.ss.android.ugc.route_monitor.utils.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f514027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CertRuleStatusMap f514028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<ControlRule> f514029c;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        monitor-enter(this);
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L11
        r100.put("hook_version", 0);     // Catch: Throwable -> L6
        r100.put("customs_switch", "off");     // Catch: Throwable -> L6
        r100.put("cert_version", 0);     // Catch: Throwable -> L6
        r100.put("cert_data", this.f514028b.toJsonObject$route_monitor_release());     // Catch: Throwable -> L6
        r100.put("ignore_condition_key_list", p.b(this.f514027a));     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);
        return r100.toString();
    L6:
        th = move-exception;
        Logger.f454747c.d(th);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public b() {
        this.f514027a = CollectionsKt.emptyList();
        this.f514028b = new CertRuleStatusMap();
        this.f514029c = new ArrayList();
    }
}
