package ix3;

import com.bytedance.applog.log.g$b;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import java.util.Iterator;
import java.util.Map;
import nx3.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements g$b {
    public final /* synthetic */ Map a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ long f;
    public final /* synthetic */ a g;

    @Override // com.bytedance.applog.log.g$b
    public final Object fetch() {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        Map r2 = this.a;
        if (r2 != null) goto L35;
    L10:
        byte[] r3 = this.b;
        if (r3 != null) goto L13;
    L30:
        JSONObject r4 = null;
    L37:
        r0.put("appId", this.g.b.j);     // Catch: Throwable -> L33
        r0.put("nid", this.c);     // Catch: Throwable -> L33
        r0.put("url", this.d);     // Catch: Throwable -> L33
        r0.put("data", r4);     // Catch: Throwable -> L33
        r0.put("header", r1);     // Catch: Throwable -> L33
        r0.put("method", this.e);     // Catch: Throwable -> L33
        r0.put("time", this.f);     // Catch: Throwable -> L33
    L34:
        return r0;
    L33:
        this.g.b.W.b(StatsCountKeys.JSON_ERROR_COUNT, 1);
        goto L34
    L13:
        if (r3.length <= 0) goto L30;
        String r5 = new String(r3);
        boolean r6 = false;
        if (k.g(r5) == false) goto L18;
    L26:
        if (r6 == false) goto L30;
        r4 = new JSONObject(r5);     // Catch: Throwable -> L29
    L29:
        this.g.b.W.b(StatsCountKeys.JSON_ERROR_COUNT, 1);
        goto L30
    L18:
        if (r5.startsWith("{") == false) goto L22;
        if (r5.startsWith("}") == false) goto L22;
    L25:
        r6 = true;
    L22:
        if (r5.startsWith("[") == false) goto L26;
        if (r5.endsWith("]") == false) goto L26;
    L35:
        Iterator r7 = r2.entrySet().iterator();     // Catch: Throwable -> L9
    L6:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r8 = (Map.Entry) r7.next();     // Catch: Throwable -> L9
        r1.put((String) r8.getKey(), r8.getValue());     // Catch: Throwable -> L9
        goto L6
    }

    public b(a r1, Map r2, byte[] r3, String r4, String r5, long r6) {
        this.g = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = 1;
        this.f = r6;
    }
}
