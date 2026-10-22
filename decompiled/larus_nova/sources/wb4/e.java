package wb4;

import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.livedetect.LiveDetectService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f558944b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f558945a;

    public final synchronized void a() {
        monitor-enter(this);
        List<d> r100 = this.f558945a;     // Catch: Throwable -> L9
        if (r100 != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (((ArrayList) r100).size() <= 0) goto L11;
        ((ArrayList) this.f558945a).clear();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void d() {
        monitor-enter(this);
        List<d> r100 = this.f558945a;     // Catch: Throwable -> L20
        if (r100 != null) goto L6;
    L22:
        monitor-exit(this);
        return;
    L6:
        if (((ArrayList) r100).size() <= 0) goto L22;
        JSONArray r101 = new JSONArray();     // Catch: Throwable -> L20
        int r102 = 0;
    L9:
        if (r102 >= ((ArrayList) this.f558945a).size()) goto L14;
        d r103 = (d) ListProtector.get(this.f558945a, r102);     // Catch: Throwable -> L20
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L20
        if (r103 == null) goto L13;
        r104.put("eventName", r103.f558941a);     // Catch: Throwable -> L20
        r104.put("msg", r103.f558943c);     // Catch: Throwable -> L20
        r104.put("ts", r103.f558942b);     // Catch: Throwable -> L20
    L13:
        r101.put(r104);     // Catch: Throwable -> L20
        r102 = r102 + 1;     // Catch: Throwable -> L20
        goto L9
    L14:
        String r105 = r101.toString();     // Catch: Throwable -> L20
        jc4.a r106 = LiveDetectService.getInstance().getRequest();     // Catch: Throwable -> L20
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L17 Throwable -> L20
        r107.put("key", "live_camera_state");     // Catch: Exception -> L17 Throwable -> L20
        r107.put("custom", r105);     // Catch: Exception -> L17 Throwable -> L20
        EventReport.w("turing_verify_sdk", r107, r106);     // Catch: Exception -> L17 Throwable -> L20
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
        if (f558944b != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f558944b != null) goto L9;
        f558944b = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f558944b;
    }

    public e() {
        this.f558945a = new ArrayList();
    }

    public final synchronized void c(String r100, String r101) {
        monitor-enter(this);
        List<d> r102 = this.f558945a;     // Catch: Throwable -> L12
        if (r102 != null) goto L6;
    L14:
        monitor-exit(this);
        return;
    L6:
        if (((ArrayList) r102).size() >= 100) goto L14;
        d r103 = new d();     // Catch: Throwable -> L12
        r103.f558941a = r100;     // Catch: Throwable -> L12
        r103.f558942b = System.currentTimeMillis();     // Catch: Throwable -> L12
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        r103.f558943c = r101;     // Catch: Throwable -> L12
        ((ArrayList) this.f558945a).add(r103);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }
}
