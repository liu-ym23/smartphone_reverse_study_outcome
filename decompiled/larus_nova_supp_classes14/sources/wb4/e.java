package wb4;

import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.livedetect.LiveDetectService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static volatile e b;
    public final List<d> a;

    public final synchronized void a() {
        monitor-enter(this);
        List<d> r0 = this.a;     // Catch: Throwable -> L9
        if (r0 != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (((ArrayList) r0).size() <= 0) goto L11;
        ((ArrayList) this.a).clear();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void d() {
        monitor-enter(this);
        List<d> r0 = this.a;     // Catch: Throwable -> L20
        if (r0 != null) goto L6;
    L22:
        monitor-exit(this);
        return;
    L6:
        if (((ArrayList) r0).size() <= 0) goto L22;
        JSONArray r1 = new JSONArray();     // Catch: Throwable -> L20
        int r2 = 0;
    L9:
        if (r2 >= ((ArrayList) this.a).size()) goto L14;
        d r3 = (d) ListProtector.get(this.a, r2);     // Catch: Throwable -> L20
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L20
        if (r3 == null) goto L13;
        r4.put("eventName", r3.a);     // Catch: Throwable -> L20
        r4.put("msg", r3.c);     // Catch: Throwable -> L20
        r4.put("ts", r3.b);     // Catch: Throwable -> L20
    L13:
        r1.put(r4);     // Catch: Throwable -> L20
        r2 = r2 + 1;     // Catch: Throwable -> L20
        goto L9
    L14:
        String r5 = r1.toString();     // Catch: Throwable -> L20
        jc4.a r6 = LiveDetectService.getInstance().getRequest();     // Catch: Throwable -> L20
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L17 Throwable -> L20
        r7.put("key", "live_camera_state");     // Catch: Exception -> L17 Throwable -> L20
        r7.put("custom", r5);     // Catch: Exception -> L17 Throwable -> L20
        EventReport.w("turing_verify_sdk", r7, r6);     // Catch: Exception -> L17 Throwable -> L20
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public static e b() {
        if (b != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public e() {
        this.a = new ArrayList();
    }

    public final synchronized void c(String r4, String r5) {
        monitor-enter(this);
        List<d> r0 = this.a;     // Catch: Throwable -> L12
        if (r0 != null) goto L6;
    L14:
        monitor-exit(this);
        return;
    L6:
        if (((ArrayList) r0).size() >= 100) goto L14;
        d r1 = new d();     // Catch: Throwable -> L12
        r1.a = r4;     // Catch: Throwable -> L12
        r1.b = System.currentTimeMillis();     // Catch: Throwable -> L12
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r1.c = r5;     // Catch: Throwable -> L12
        ((ArrayList) this.a).add(r1);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }
}
