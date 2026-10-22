package bc4;

import android.text.TextUtils;
import com.bytedance.applet.debugger.DebuggerSessionViewModel;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.setting.e;
import ec4.c;
import ec4.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import qb4.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static volatile b e;
    public final List<JSONObject> a;
    public String b;
    public int c;
    public com.bytedance.bdturing.senseless.a d;

    public class a implements c {
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ b b;

        @Override // ec4.c
        public final void a(xb4.a r4) {
            if (r4.a != 200) goto L5;
            EventReport.W(true, "");
            return;
        L5:
            EventReport.W(false, r4.c);
            b r5 = this.b;
            int r0 = r5.c;
            if (r0 >= 1) goto L10;
            r5.c = r0 + 1;
            r5.b(this.a);
            return;
        }

        @Override // ec4.c
        public final void onError(Throwable r3) {
            EventReport.W(false, "net work error:" + r3);
            b r4 = this.b;
            int r0 = r4.c;
            if (r0 >= 1) goto L6;
            r4.c = r0 + 1;
            r4.b(this.a);
            return;
        }

        public a(b r1, JSONArray r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static b a() {
        if (e != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return e;
    }

    public final void c() {
        com.bytedance.bdturing.senseless.a r0 = this.d;
        int r1 = 0;
        if (r0 == null) goto L10;
        if (r0.b == false) goto L10;
        r0.b = false;
        c0.b r2 = c0.a.a.b;
        if (r2 == null) goto L10;
        r2.removeCallbacks(r0);
    L10:
        if (((ArrayList) this.a).isEmpty() == false) goto L12;
        return;
    L12:
        this.c = 0;
        monitor-enter(b.class);
        JSONArray r3 = new JSONArray();     // Catch: Throwable -> L21
    L16:
        if (r1 >= ((ArrayList) this.a).size()) goto L18;
        r3.put(((ArrayList) this.a).get(r1));     // Catch: Throwable -> L21
        r1 = r1 + 1;     // Catch: Throwable -> L21
        goto L16
    L18:
        ((ArrayList) this.a).clear();     // Catch: Throwable -> L21
        b(r3);     // Catch: Throwable -> L21
        monitor-exit(b.class);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public b() {
        this.a = new ArrayList();
    }

    public final void b(JSONArray r8) {
        if (TextUtils.isEmpty(this.b) == false) goto L13;
        e r0 = e.a;
        String r1 = e.d("verify");
        StringBuilder r2 = new StringBuilder();
        if (TextUtils.isEmpty(r1) == false) goto L7;
    L12:
        r2.append("captcha/report_client_status");
        this.b = r2.toString();
        goto L13
    L7:
        if (r1.startsWith("https://") == true) goto L9;
        r2.append("https://");
    L9:
        r2.append(r1);
        if (r1.endsWith("/") == true) goto L12;
        r2.append("/");
    L13:
        String r3 = this.b;
        HashMap r6 = new HashMap();
        r6.put("Content-Type", "application/json; charset=utf-8");
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L16
        r5.put("data_type", "verify_conflict");     // Catch: Exception -> L16
        r5.put("data", r8);     // Catch: Exception -> L16
        new j(r3, null, null, r5, r6).c(new a(this, r8));     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
    }

    public final void d(jc4.a r4) {
        if (r4 != null) goto L29;
        return;
    L29:
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L24
        r0.put("log_id", r4.d);     // Catch: Exception -> L24
        r0.put("subtype", r4.g());     // Catch: Exception -> L24
        r0.put("detail", r4.j);     // Catch: Exception -> L24
        monitor-enter(b.class);     // Catch: Exception -> L24
        ((ArrayList) this.a).add(r0);     // Catch: Throwable -> L21
        monitor-exit(b.class);     // Catch: Throwable -> L21
    L9:
        if (((ArrayList) this.a).size() < 5) goto L11;
        c();     // Catch: Exception -> L24
        return;
    L11:
        com.bytedance.bdturing.senseless.a r5 = this.d;     // Catch: Exception -> L24
        if (r5 != null) goto L14;
    L16:
        com.bytedance.bdturing.senseless.a r6 = new com.bytedance.bdturing.senseless.a(new bc4.a(this));     // Catch: Exception -> L24
        this.d = r6;     // Catch: Exception -> L24
        if (r6.b == true) goto L32;
        r6.b = true;     // Catch: Exception -> L24
        c0.a.a.b(r6, DebuggerSessionViewModel.MODE_SWITCH_TIMEOUT_MS);     // Catch: Exception -> L24
        return;
    L32:
        return;
    L14:
        if (r5.b == false) goto L16;
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Exception -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
    }
}
