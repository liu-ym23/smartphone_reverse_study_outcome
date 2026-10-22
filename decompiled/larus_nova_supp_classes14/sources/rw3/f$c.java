package rw3;

import com.bytedance.applog.log.g$b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class f$c implements g$b {
    public final /* synthetic */ f a;

    @Override // com.bytedance.applog.log.g$b
    public final Object fetch() {
        JSONObject r0 = new JSONObject();
        r0.put("appId", this.a.c.j);     // Catch: Throwable -> L5
        r0.put("isMainProcess", this.a.d.e());     // Catch: Throwable -> L5
    L4:
        return r0;
    }

    public f$c(f r1) {
        this.a = r1;
    }
}
