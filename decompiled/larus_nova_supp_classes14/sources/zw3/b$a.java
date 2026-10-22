package zw3;

import com.bytedance.applog.log.g$b;
import com.bytedance.applog.priority.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class b$a implements g$b {
    public final /* synthetic */ a a;
    public final /* synthetic */ b b;

    @Override // com.bytedance.applog.log.g$b
    public final Object fetch() {
        JSONObject r0 = new JSONObject();
        r0.put("appId", this.b.n.j);     // Catch: Throwable -> L5
        r0.put("config", this.a.g);     // Catch: Throwable -> L5
        r0.put("version", this.a.a);     // Catch: Throwable -> L5
        r0.put("baseInterval", this.a.b);     // Catch: Throwable -> L5
    L4:
        return r0;
    }

    public b$a(b r1, a r2) {
        this.b = r1;
        this.a = r2;
    }
}
