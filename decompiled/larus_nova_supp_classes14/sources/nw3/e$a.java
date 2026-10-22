package nw3;

import com.bytedance.applog.log.g$b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class e$a implements g$b {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ e d;

    @Override // com.bytedance.applog.log.g$b
    public final Object fetch() {
        JSONObject r0 = new JSONObject();
        r0.put("appId", this.d.a.d.j);     // Catch: Throwable -> L5
        r0.put("did", this.a);     // Catch: Throwable -> L5
        r0.put("ssid", this.b);     // Catch: Throwable -> L5
        r0.put("installId", this.c);     // Catch: Throwable -> L5
    L4:
        return r0;
    }

    public e$a(e r1, String r2, String r3, String r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
