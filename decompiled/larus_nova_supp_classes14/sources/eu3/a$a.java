package eu3;

import com.bytedance.apm6.foundation.safety.ApmInternalException;
import com.larus.apm.impl.protector.RunnableProtector;
import cv3.a;
import du3.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONArray;
import org.json.JSONObject;
import xu3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class a$a extends a {
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Throwable f;

    public final void a() {
        String r0 = this.d;
        String r1 = this.e;
        ApmInternalException r4 = new ApmInternalException("tag=" + r0 + " message=" + r1, this.f);
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L16
        r2.put("event_type", "exception");     // Catch: Throwable -> L16
        r2.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L16
        StringWriter r6 = new StringWriter();     // Catch: Throwable -> L16
        PrintWriter r7 = new PrintWriter(r6);     // Catch: Throwable -> L16
        r4.printStackTrace(r7);     // Catch: Throwable -> L16
        Throwable r5 = r4.getCause();     // Catch: Throwable -> L16
        if (r5 == null) goto L8;
        r5.printStackTrace(r7);     // Catch: Throwable -> L16
        Throwable r8 = r5.getCause();     // Catch: Throwable -> L16
        if (r8 == null) goto L8;
        r8.printStackTrace(r7);     // Catch: Throwable -> L16
    L8:
        String r9 = r6.toString();     // Catch: Throwable -> L16
        r7.close();     // Catch: Throwable -> L16
        r2.put("stack", r9);     // Catch: Throwable -> L16
        r2.put("exception_type", 1);     // Catch: Throwable -> L16
        r2.put("message", r0 + "_" + r1);     // Catch: Throwable -> L16
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L16
        r3.put("apm_sdk", "apm6_error");     // Catch: Throwable -> L16
        r3.put("host_aid", String.valueOf(du3.a.b()));     // Catch: Throwable -> L16
        r2.put("filters", r3);     // Catch: Throwable -> L16
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L16
        JSONArray r11 = new JSONArray();     // Catch: Throwable -> L16
        r11.put(r2);     // Catch: Throwable -> L16
        r10.put("data", r11);     // Catch: Throwable -> L16
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L16
        d.a(r12, du3.a.j());     // Catch: Throwable -> L16
        b r13 = du3.a.c;     // Catch: Throwable -> L16
        if (r13 == null) goto L11;
        r13.c();     // Catch: Throwable -> L16
        d.a(r12, null);     // Catch: Throwable -> L16
    L11:
        r12.put("os", "Android");     // Catch: Throwable -> L16
        r12.put("aid", 2085);     // Catch: Throwable -> L16
        r12.put("device_id", du3.a.f());     // Catch: Throwable -> L16
        r12.put("channel", du3.a.d());     // Catch: Throwable -> L16
        r12.put("version_code", du3.a.n());     // Catch: Throwable -> L16
        r12.put("update_version_code", du3.a.l());     // Catch: Throwable -> L16
        r12.put("device_id", du3.a.f());     // Catch: Throwable -> L16
        r12.put("uid", du3.a.c.getUid());     // Catch: Throwable -> L16
        r12.put("process_name", du3.a.e());     // Catch: Throwable -> L16
        r10.put("header", r12);     // Catch: Throwable -> L16
        if (xu3.a.a() == true) goto L14;
    L14:
        a.c(a.c, r10.toString().getBytes());     // Catch: Throwable -> L16
        return;
    }

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

    public a$a(String r1, String r2, Throwable r3) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
    }
}
