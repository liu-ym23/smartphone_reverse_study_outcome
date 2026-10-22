package ws3;

import android.text.TextUtils;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.d;
import com.bytedance.apm.k;
import com.bytedance.apm.util.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import js3.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ps3.b;
import ss3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ k b;

    public final void a() {
        Map r1 = this.b.r;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.containsKey(this.a) == false) goto L72;
        long r2 = ((Long) ((n) this.b.r.get(this.a)).a).longValue();
        long r3 = this.b.v.a() - ((Long) ((n) this.b.r.get(this.a)).b).longValue();
        long r5 = this.b.v.a.e() - ((Long) ((n) this.b.s.get(this.a)).b).longValue();
        long r7 = this.b.v.a.g() - ((Long) ((n) this.b.t.get(this.a)).b).longValue();
        this.b.r.remove(this.a);
        this.b.s.remove(this.a);
        this.b.t.remove(this.a);
        if (r3 >= 0) goto L14;
        d r0 = d.b.a;
        String r4 = this.a;
        Map r6 = r0.k;
        if (r6 == null) goto L67;
        ((HashMap) r6).remove(r4);
        return;
    L67:
        return;
    L14:
        d r9 = d.b.a;
        String r10 = this.a;
        if (r9.k != null) goto L17;
    L20:
        Map r11 = null;
    L63:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L59
        r12.put("init_ts", r2);     // Catch: Exception -> L59
        r12.put("usage_ts", System.currentTimeMillis());     // Catch: Exception -> L59
        if (r11 != null) goto L24;
    L31:
        d r8 = d.b.a;     // Catch: Exception -> L59
        String r13 = this.a;     // Catch: Exception -> L59
        Map r14 = r8.k;     // Catch: Exception -> L59
        if (r14 == null) goto L35;
        ((HashMap) r14).remove(r13);     // Catch: Exception -> L59
    L35:
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L59
        r15.put(this.a, r3);     // Catch: Exception -> L59
        r15.put(this.a + "$wifi", r5);     // Catch: Exception -> L59
        r15.put(this.a + "$mobile", r7);     // Catch: Exception -> L59
        e r16 = new e();     // Catch: Exception -> L59
        r16.a = ((a) this.b).e;     // Catch: Exception -> L59
        r16.d = r15;     // Catch: Exception -> L59
        r16.g = r12;     // Catch: Exception -> L59
        JSONObject r17 = r16.a();     // Catch: Exception -> L59
        lt3.c r18 = new lt3.c(UploadTypeInf.PERFORMANCE, r17);     // Catch: Exception -> L59
        k r19 = this.b;     // Catch: Exception -> L59
        if (r19.w != null) goto L40;
        k.z.c(r18);     // Catch: Exception -> L59
        k.A.c(this.a);     // Catch: Exception -> L59
        if (d.j() == false) goto L69;
        b.a(new String[]{"config==null:"});     // Catch: Exception -> L59
        return;
    L69:
        return;
    L40:
        boolean r20 = zs3.c.a(((a) r19).e);     // Catch: Exception -> L59
        boolean r21 = true;
        if (r20 == false) goto L43;
    L48:
        boolean r22 = jt3.a.a;     // Catch: Exception -> L59
        nu3.b.a(r18);     // Catch: Exception -> L59
    L50:
        if (d.j() == false) goto L71;
        String[] r23 = new String[1];     // Catch: Exception -> L59
        StringBuilder r24 = new StringBuilder();     // Catch: Exception -> L59
        r24.append("isSample:");     // Catch: Exception -> L59
        if (r20 == false) goto L54;
    L57:
        r24.append(r21);     // Catch: Exception -> L59
        r23[0] = r24.toString();     // Catch: Exception -> L59
        b.a(r23);     // Catch: Exception -> L59
        return;
    L54:
        if (this.b.w.optInt(this.a, 0) == 1) goto L57;
        r21 = false;
        goto L57
    L71:
        return;
    L43:
        if (this.b.w.optInt(this.a, 0) == 1) goto L48;
        if (d.j() == false) goto L50;
        ls3.a.a(UploadTypeInf.PERFORMANCE, r17, false);     // Catch: Exception -> L59
        goto L50
    L24:
        if (r11.size() <= 0) goto L31;
        JSONObject r25 = new JSONObject();     // Catch: Exception -> L59
        JSONArray r26 = new JSONArray();     // Catch: Exception -> L59
        Iterator r27 = r11.entrySet().iterator();     // Catch: JSONException -> L62 Exception -> L59
    L28:
        if (r27.hasNext() == false) goto L30;
        JSONObject r110 = ((d.a) ((Map.Entry) r27.next()).getValue()).b();     // Catch: JSONException -> L62 Exception -> L59
        r110.put("traffic_category", this.a);     // Catch: JSONException -> L62 Exception -> L59
        r26.put(r110);     // Catch: JSONException -> L62 Exception -> L59
        goto L28
    L30:
        r25.put("usage", r26);     // Catch: JSONException -> L62 Exception -> L59
        r12.put("detail", r25);     // Catch: JSONException -> L62 Exception -> L59
    L59:
        e = move-exception;
        k.b.a.c(e, "apm_error");
        return;
    L17:
        if (TextUtils.isEmpty(r10) == true) goto L20;
        r11 = (Map) ((HashMap) r9.k).get(r10);
        goto L63
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

    public j(k r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
