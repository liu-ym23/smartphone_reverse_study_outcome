package ct3;

import android.text.TextUtils;
import com.bytedance.apm.agent.tracing.AutoLaunchTraceHelper;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.util.e$a;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ns3.a;
import ns3.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements Runnable {
    public final /* synthetic */ ns3.e.b a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ f e;

    /* JADX WARN: Type inference failed for: r3v9, types: [ct3.a$a] */
    public final void a() {
        if (this.e.c() == false) goto L15;
        a r2 = a.a.a;
        monitor-enter(r2);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r2.b != null) goto L9;
        final a$a.a r0 = new a$a.a();     // Catch: Throwable -> L12
        r2.b = new a$a(r0);     // Catch: Throwable -> L12
    L9:
        a$a r1 = r2.b;     // Catch: Throwable -> L12
        monitor-exit(r2);
        r1.getClass();
    L15:
        f r3 = this.e;
        int r4 = this.b;
        String r5 = this.c;
        String r6 = this.d;
        long r7 = r3.b;
        ns3.e.b r8 = this.a;
        JSONArray r12 = new JSONArray();
    L48:
        e = e;
        String r20 = r5;
        ns3.e.b r18 = r8;
    L50:
        e.printStackTrace();
    L51:
        ConcurrentHashMap r9 = r3.c;
        if (r9 == null) goto L54;
        r9.clear();
    L54:
        JSONObject r10 = new JSONObject();
        r10.put("name", r3.e);     // Catch: JSONException -> L62
        r10.put("page_type", r3.e);     // Catch: JSONException -> L62
        r10.put(UploadTypeInf.START, r3.a);     // Catch: JSONException -> L62
        r10.put("end", r7);     // Catch: JSONException -> L62
        r10.put("spans", r12);     // Catch: JSONException -> L62
        r10.put("collect_from", 2);     // Catch: JSONException -> L62
        r10.put("page_name", r6);     // Catch: JSONException -> L62
        if (r4 == (-1)) goto L59;
        r10.put("launch_mode", r4);     // Catch: JSONException -> L62
    L59:
        if (r20.isEmpty() == true) goto L64;
        r10.put("custom_launch_mode", r20);     // Catch: JSONException -> L62
    L64:
        if (r3.c() == true) goto L66;
    L69:
        JSONObject r11 = new JSONObject();
        r11.put("trace", r10);     // Catch: JSONException -> L91
        if (r18 == null) goto L75;
        JSONObject r13 = b.b(r18);     // Catch: JSONException -> L91
        if (r13 == null) goto L75;
        r11.put("perf_data", r13);     // Catch: JSONException -> L91
    L75:
        js3.e r14 = new js3.e(r3.d, "", null, null, r11);
        r14.f = ou3.a.a().c(false);
        if (com.bytedance.apm.d.j() == false) goto L88;
        String r15 = "reportAsync: " + r11;
        if (r15 == null) goto L88;
        if (r15.length() == 0) goto L88;
        if (r15.length() <= 3072) goto L88;
    L86:
        if (r15.length() <= 3072) goto L88;
        r15 = r15.replace(r15.substring(0, 3072), "");
    L88:
        is3.a.h().b(r14);
        return;
    L66:
        if (a.a.a.a().b == false) goto L69;
        JSONObject r16 = new JSONObject();
        com.bytedance.apm.util.e r17 = e$a.a;
        r17.b(r16, true);
        r17.a(r16, true);
        r10.put("device_info_data", r16);     // Catch: Throwable -> L90
        goto L69
    L17:
        if (TextUtils.equals(r6, AutoLaunchTraceHelper.sLauncherActivityName) == false) goto L19;
        r12 = AutoLaunchTraceHelper.assemblySpan();     // Catch: JSONException -> L48
    L19:
        ConcurrentHashMap r19 = r3.c;     // Catch: JSONException -> L48
        if (r19 != null) goto L22;
    L47:
        r20 = r5;
        r18 = r8;
        goto L51
    L22:
        if (r19.isEmpty() == true) goto L47;
        Iterator r21 = r3.c.entrySet().iterator();     // Catch: JSONException -> L48
    L24:
        if (r21.hasNext() == false) goto L47;
        Map.Entry r110 = (Map.Entry) r21.next();     // Catch: JSONException -> L48
        String r111 = (String) r110.getKey();     // Catch: JSONException -> L48
        ms3.b r112 = (ms3.b) r110.getValue();     // Catch: JSONException -> L48
        if (r112.b == 0) goto L24;
        JSONObject r113 = new JSONObject();     // Catch: JSONException -> L48
        Iterator r114 = r21;
        String[] r22 = r111.split("#");     // Catch: JSONException -> L48
        r18 = r8;
        if (r22.length == 2) goto L104;
        r20 = r5;
        if (r22.length != 1) goto L102;
        r113.put("span_name", r22[0]);     // Catch: JSONException -> L45
    L102:
        r113.put(UploadTypeInf.START, r112.a);     // Catch: JSONException -> L45
        r113.put("end", r112.b);     // Catch: JSONException -> L45
        r113.put("thread", r112.c);     // Catch: JSONException -> L45
        r12.put(r113);     // Catch: JSONException -> L45
        r8 = r18;
        r21 = r114;
        r5 = r20;
    L45:
        e = e;
        goto L50
    L104:
    L38:
        e = e;
        r20 = r5;
        goto L50
    L33:
        if ("page_load_trace".equals(r3.d) == false) goto L36;
        r113.put("name", r22[1]);     // Catch: JSONException -> L38
        r20 = r5;
        goto L102
    L36:
        r20 = r5;
        r113.put("module_name", r22[0]);     // Catch: JSONException -> L45
        r113.put("span_name", r22[1]);     // Catch: JSONException -> L45
        goto L102
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

    public d(f r1, ns3.e.b r2, int r3, String r4) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = "";
        this.d = r4;
    }
}
