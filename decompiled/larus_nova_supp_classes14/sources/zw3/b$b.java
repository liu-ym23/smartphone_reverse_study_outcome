package zw3;

import com.bytedance.applog.log.g$b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class b$b implements g$b {
    public final /* synthetic */ b a;

    @Override // com.bytedance.applog.log.g$b
    public final Object fetch() {
        JSONObject r0 = new JSONObject();
        r0.put("appId", this.a.n.j);     // Catch: Throwable -> L5
        r0.put("config", this.a.o.a());     // Catch: Throwable -> L5
    L4:
        return r0;
    }

    public b$b(b r1) {
        this.a = r1;
    }
}
