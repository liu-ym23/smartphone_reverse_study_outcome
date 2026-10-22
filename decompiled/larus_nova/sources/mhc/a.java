package mhc;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRuleList;
import com.ss.android.ugc.route_monitor.utils.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f514025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ControlRuleList f514026b;

    /* JADX INFO: renamed from: mhc.a$a, reason: collision with other inner class name */
    public static final class C6816a {
    }

    static {
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put("status", this.f514025a);     // Catch: Throwable -> L5
        r100.put("rule_list", this.f514026b.toJsonArray$route_monitor_release().toString());     // Catch: Throwable -> L5
    L7:
        return r100;
    L5:
        th = move-exception;
        Logger.f454747c.d(th);
        goto L7
    }

    public a() {
        this.f514025a = 1;
        this.f514026b = new ControlRuleList();
    }

    public final String toString() {
        return a().toString();
    }
}
