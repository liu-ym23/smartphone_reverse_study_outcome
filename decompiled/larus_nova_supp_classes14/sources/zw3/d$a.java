package zw3;

import com.bytedance.applog.log.g$b;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import nx3.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class d$a implements g$b {
    public final /* synthetic */ d a;

    @Override // com.bytedance.applog.log.g$b
    public final Object fetch() {
        JSONObject r0 = new JSONObject();
        f.b(this.a.e, r0);
        r0.put("appId", this.a.g.j);     // Catch: Throwable -> L5
    L6:
        return r0;
    L5:
        this.a.g.W.b(StatsCountKeys.JSON_ERROR_COUNT, 1);
        goto L6
    }

    public d$a(d r1) {
        this.a = r1;
    }
}
