package ix3;

import com.bytedance.applog.log.g$b;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class a$b implements g$b {
    public final /* synthetic */ Map a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ JSONObject d;
    public final /* synthetic */ int e;
    public final /* synthetic */ long f;
    public final /* synthetic */ a g;

    @Override // com.bytedance.applog.log.g$b
    public final Object fetch() {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        Map r2 = this.a;
        if (r2 != null) goto L16;
    L14:
        r0.put("appId", this.g.b.j);     // Catch: Throwable -> L12
        r0.put("nid", this.b);     // Catch: Throwable -> L12
        r0.put("url", this.c);     // Catch: Throwable -> L12
        r0.put("data", this.d);     // Catch: Throwable -> L12
        r0.put("header", r1);     // Catch: Throwable -> L12
        r0.put("method", this.e);     // Catch: Throwable -> L12
        r0.put("time", this.f);     // Catch: Throwable -> L12
    L13:
        return r0;
    L12:
        this.g.b.W.b(StatsCountKeys.JSON_ERROR_COUNT, 1);
        goto L13
    L16:
        Iterator r3 = r2.entrySet().iterator();     // Catch: Throwable -> L9
    L6:
        if (r3.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) r3.next();     // Catch: Throwable -> L9
        r1.put((String) r4.getKey(), r4.getValue());     // Catch: Throwable -> L9
    L9:
        this.g.b.W.b(StatsCountKeys.JSON_ERROR_COUNT, 1);
        goto L14
    }

    public a$b(a r1, Map r2, String r3, String r4, JSONObject r5, int r6, long r7) {
        this.g = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
