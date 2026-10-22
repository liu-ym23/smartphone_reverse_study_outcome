package ac4;

import android.app.Activity;
import com.bytedance.bdturing.BdTuringConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.text.Charsets;
import org.json.JSONObject;
import qb4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements Runnable {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ c b;
    public final /* synthetic */ e c;

    public final void a() {
        JSONObject r0 = new JSONObject();
        String r1 = this.a.optString("url");
        String r2 = this.a.optString("method");
        String r3 = this.a.optString("params");
        JSONObject r4 = this.a.optJSONObject("data");
        boolean r5 = this.a.optBoolean("needCommonParams");
        StringBuilder r6 = null;
        if (r3 != null) goto L37;
    L9:
        JSONObject r7 = null;
    L10:
        if (r5 == false) goto L41;
        if (r7 == null) goto L39;
    L14:
        BdTuringConfig r8 = qb4.b.c.a.a;     // Catch: Exception -> L13
        e r9 = this.c;     // Catch: Exception -> L13
        Activity r10 = r9.a;     // Catch: Exception -> L13
        e.b(r9, r7, r8);     // Catch: Exception -> L13
        goto L41
    L39:
        r7 = new JSONObject();     // Catch: Exception -> L13
    L41:
        if (r7 == null) goto L18;
        StringBuilder r11 = hc4.f.d(r1, r7);     // Catch: Throwable -> L31 Exception -> L36
    L19:
        HashMap r12 = new HashMap();     // Catch: Throwable -> L31 Exception -> L36
        r12.put("Content-Type", "application/x-www-form-urlencoded");     // Catch: Throwable -> L31 Exception -> L36
        ec4.b r13 = qb4.b.c.a.a.getHttpClient();     // Catch: Throwable -> L31 Exception -> L36
        if ("get".equals(r2) == false) goto L22;
        String r14 = new String(r13.get(r11.toString(), r12), Charsets.UTF_8);     // Catch: Throwable -> L31 Exception -> L36
    L29:
        r0.put("response", r14);     // Catch: Throwable -> L31 Exception -> L36
        goto L34
    L22:
        if (r4 == null) goto L24;
        r6 = hc4.f.e(r4);     // Catch: Throwable -> L31 Exception -> L36
    L24:
        String r15 = r11.toString();     // Catch: Throwable -> L31 Exception -> L36
        if (r6 == null) goto L27;
        String r16 = r6.toString();     // Catch: Throwable -> L31 Exception -> L36
    L28:
        r14 = new String(r13.post(r15, r12, r16.getBytes()), Charsets.UTF_8);     // Catch: Throwable -> L31 Exception -> L36
        goto L29
    L27:
        r16 = "";
        goto L28
    L18:
        r11 = new StringBuilder(r1);     // Catch: Throwable -> L31 Exception -> L36
    L31:
        th = move-exception;
        r0.toString();
        int r17 = n.a;
        this.b.d(1, r0);
        throw th;
    L34:
        r0.toString();
        int r18 = n.a;
        this.b.d(1, r0);
        return;
    L37:
    L8:
        r7 = null;
        goto L41
    L5:
        if (r3.isEmpty() == true) goto L9;
        r7 = new JSONObject(r3);     // Catch: Exception -> L8
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(e r1, JSONObject r2, c r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
