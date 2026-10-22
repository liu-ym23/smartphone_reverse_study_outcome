package ix3;

import com.bytedance.applog.log.g$b;
import nx3.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class a$a implements g$b {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ a b;

    @Override // com.bytedance.applog.log.g$b
    public final Object fetch() {
        JSONObject r0 = new JSONObject();
        f.b(this.a, r0);
        r0.put("appId", this.b.b.j);     // Catch: Throwable -> L5
    L4:
        return r0;
    }

    public a$a(a r1, JSONObject r2) {
        this.b = r1;
        this.a = r2;
    }
}
