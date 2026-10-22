package ix3;

import com.bytedance.applog.log.g$b;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class a$c implements g$b {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ byte[] c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;
    public final /* synthetic */ a f;

    @Override // com.bytedance.applog.log.g$b
    public final Object fetch() {
        JSONObject r0 = new JSONObject();
        r0.put("appId", this.f.b.j);     // Catch: Throwable -> L5
        r0.put("nid", this.a);     // Catch: Throwable -> L5
        r0.put("statusCode", this.b);     // Catch: Throwable -> L5
        r0.put("responseByte", this.c);     // Catch: Throwable -> L5
        r0.put("responseString", this.d);     // Catch: Throwable -> L5
        r0.put("time", this.e);     // Catch: Throwable -> L5
    L6:
        return r0;
    L5:
        this.f.b.W.b(StatsCountKeys.JSON_ERROR_COUNT, 1);
        goto L6
    }

    public a$c(a r1, String r2, int r3, byte[] r4, String r5, long r6) {
        this.f = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
