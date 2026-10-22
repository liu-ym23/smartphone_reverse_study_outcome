package uw3;

import com.bytedance.applog.log.g$b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class i$a implements g$b {
    public final /* synthetic */ rw3.f a;
    public final /* synthetic */ gx3.c b;

    @Override // com.bytedance.applog.log.g$b
    public final Object fetch() {
        JSONObject r0 = new JSONObject();
        r0.put("appId", this.a.c.j);     // Catch: Throwable -> L5
        r0.put("config", this.b.c);     // Catch: Throwable -> L5
    L4:
        return r0;
    }

    public i$a(rw3.f r1, gx3.c r2) {
        this.a = r1;
        this.b = r2;
    }
}
