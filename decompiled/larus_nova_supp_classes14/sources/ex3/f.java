package ex3;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.log.i;
import com.bytedance.applog.log.n;
import com.bytedance.applog.monitor.v3.impl.LatencyMonitor;
import com.bytedance.applog.monitor.v3.impl.d;
import com.bytedance.applog.monitor.v3.impl.e;
import com.bytedance.bdinstall.g0;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.applog.e0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pw3.b;
import rw3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;
    public final /* synthetic */ g0 c;
    public final /* synthetic */ String d;
    public final /* synthetic */ e e;

    public final void a() {
        String r2 = "gzip";
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r4 >= this.a) goto L82;
        if (r5 >= 2) goto L7;
        Thread.sleep(3000);     // Catch: InterruptedException -> L83
    L11:
        long r8 = this.b;
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L77
        a r11 = this.e.i.g;     // Catch: Throwable -> L77
        if (r11 != null) goto L86;
    L30:
        e r12 = this.e;     // Catch: Throwable -> L77
        r12.g.put("feature_options", r12.l);     // Catch: Throwable -> L77
        r10.put("header", this.e.g);     // Catch: Throwable -> L77
        JSONArray r13 = new JSONArray();     // Catch: Throwable -> L77
        Pair r14 = this.e.c.c(r8);     // Catch: Throwable -> L77
        Object r15 = r14.first;     // Catch: Throwable -> L77
        if (r15 == null) goto L33;
        this.e.c.getClass();     // Catch: Throwable -> L28
        d.b((Map) r15, r13);     // Catch: Throwable -> L28
        r8 = ((Long) r14.second).longValue();     // Catch: Throwable -> L28
    L33:
        Pair r16 = this.e.d.b(r8);     // Catch: Throwable -> L77
        Object r17 = r16.first;     // Catch: Throwable -> L77
        if (r17 == null) goto L36;
        this.e.d.getClass();     // Catch: Throwable -> L28
        e.a((Map) r17, r13);     // Catch: Throwable -> L28
        r8 = ((Long) r16.second).longValue();     // Catch: Throwable -> L28
    L36:
        Pair r18 = this.e.b.a(r8);     // Catch: Throwable -> L77
        Object r19 = r18.first;     // Catch: Throwable -> L77
        if (r19 == null) goto L43;
        this.e.b.getClass();     // Catch: Throwable -> L28
        Iterator r9 = ((Map) r19).values().iterator();     // Catch: Throwable -> L28
    L40:
        if (r9.hasNext() == false) goto L42;
        r13.put((JSONObject) r9.next());     // Catch: Throwable -> L28
        goto L40
    L42:
        r8 = ((Long) r18.second).longValue();     // Catch: Throwable -> L28
    L43:
        Pair r110 = this.e.e.a(r8);     // Catch: Throwable -> L77
        Object r7 = r110.first;     // Catch: Throwable -> L77
        if (r7 == null) goto L50;
        this.e.e.getClass();     // Catch: Throwable -> L28
        Iterator r20 = ((Map) r7).values().iterator();     // Catch: Throwable -> L28
    L47:
        if (r20.hasNext() == false) goto L49;
        r13.put((JSONObject) r20.next());     // Catch: Throwable -> L28
        goto L47
    L49:
        r8 = ((Long) r110.second).longValue();     // Catch: Throwable -> L28
    L50:
        Pair r21 = this.e.f.b(r8);     // Catch: Throwable -> L77
        Object r0 = r21.first;     // Catch: Throwable -> L77
        if (r0 == null) goto L54;
        this.e.f.getClass();     // Catch: Throwable -> L28
        com.bytedance.applog.monitor.v3.impl.c.a((Map) r0, r13);     // Catch: Throwable -> L28
        r8 = ((Long) r21.second).longValue();     // Catch: Throwable -> L28
    L54:
        if (r13.length() != 0) goto L58;
        n.w().k(8, e.m, "report break for no any event!", new Object[r3]);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Throwable r111 = th;
        String r112 = r2;
    L80:
        n.w().r(8, e.m, "report to server failed!", r111, new Object[0]);
        r5 = r5 + 1;
    L81:
        r4 = r4 + 1;
        r2 = r112;
        r3 = 0;
        goto L4
    L56:
        return;
    L58:
        r10.put("event_v3", r13);     // Catch: Throwable -> L77
        byte[] r1 = b.a(r10.toString().getBytes("UTF-8"));     // Catch: Throwable -> L77
        HashMap r113 = new HashMap();     // Catch: Throwable -> L77
        r113.put("log-encode-type", r2);     // Catch: Throwable -> L77
        r113.put("Content-Encoding", r2);     // Catch: Throwable -> L77
        r113.put("Content-Type", "application/octet-stream;tt-data=b");     // Catch: Throwable -> L77
        r113.put("x-tt-request-tag", "t=0;n=0");     // Catch: Throwable -> L77
        String r6 = this.c.post(this.d, r1, r113);     // Catch: Throwable -> L77
        i r22 = n.w();     // Catch: Throwable -> L77
        List r114 = e.m;     // Catch: Throwable -> L77
        r112 = r2;
        r22.k(8, r114, "report with left body size left: {} and response: {}.", new Object[]{Long.valueOf(r8), r6});     // Catch: Throwable -> L75
        if (TextUtils.isEmpty(r6) == false) goto L63;
    L73:
        r5 = r5 + 1;
        goto L81
    L63:
        if ("success".equals(JSONObjectProtectorUtils.getString(new JSONObject(r6), "message")) == false) goto L73;
        n.w().g(8, r114, "report to server success!", new Object[0]);     // Catch: Throwable -> L75
        this.e.c.g((Map) r14.first);     // Catch: Throwable -> L75
        this.e.d.f((Map) r16.first);     // Catch: Throwable -> L75
        com.bytedance.applog.monitor.v3.impl.a r23 = this.e.b;     // Catch: Throwable -> L75
        Map r24 = (Map) r18.first;     // Catch: Throwable -> L75
        r23.getClass();     // Catch: Throwable -> L75
        LatencyMonitor r25 = this.e.e;     // Catch: Throwable -> L75
        Map r26 = (Map) r110.first;     // Catch: Throwable -> L75
        r25.getClass();     // Catch: Throwable -> L75
        com.bytedance.applog.monitor.v3.impl.c r27 = this.e.f;     // Catch: Throwable -> L75
        Map r28 = (Map) r21.first;     // Catch: Throwable -> L75
        r27.getClass();     // Catch: Throwable -> L75
        if (r28 == null) goto L71;
        if (r28.isEmpty() == true) goto L71;
        r27.b.post(new com.bytedance.applog.monitor.v3.impl.b(r27, r28));     // Catch: Throwable -> L75
    L71:
        if (r8 <= 0) goto L81;
        return;
    L75:
        th = th;
    L79:
        r111 = th;
        goto L80
    L86:
        h r115 = (h) r11;     // Catch: Throwable -> L28
        JSONObject r116 = r115.a.c.getHeader();     // Catch: Throwable -> L28
        e0.b r117 = r115.a.c.q;     // Catch: Throwable -> L28
        if (r117 == null) goto L84;
        r117.a(r116);     // Catch: Throwable -> L28
    L84:
        JSONObject r118 = new JSONObject(r116, new String[]{"carrier_region", "region", "app_region"});     // Catch: JSONException -> L19 Throwable -> L28
    L20:
        if (r118 == null) goto L30;
        if (r118.length() <= 0) goto L30;
        Iterator<String> r119 = r118.keys();     // Catch: Throwable -> L28
    L25:
        if (r119.hasNext() == false) goto L30;
        String r120 = r119.next();     // Catch: Throwable -> L28
        this.e.g.put(r120, r118.opt(r120));     // Catch: Throwable -> L28
    L19:
        r118 = null;
    L77:
        th = th;
        r112 = r2;
        goto L79
    L7:
        n.w().k(8, e.m, "report failed and break with try 2 times: {}.", new Object[r3]);
        this.e.c("monitor_report_failed_2_tries", 1);
        return;
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

    public f(e r1, int r2, long r3, g0 r5, String r6) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
    }
}
