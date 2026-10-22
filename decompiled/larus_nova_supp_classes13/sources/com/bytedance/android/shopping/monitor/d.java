package com.bytedance.android.shopping.monitor;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Choreographer;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.core.monitor.k;
import com.bytedance.apm.util.n;
import com.bytedance.crash.Npth;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static final d h = null;
    public static final Map<String, d> i = null;
    public final String a;
    public final boolean b;
    public final Map<String, Long> c;
    public final Map<String, Long> d;
    public final Map<String, String> e;
    public final Map<String, String> f;
    public final Map<String, n<Long, Long>> g;

    static {
        h = new d();
        i = new HashMap();
    }

    public final void g() {
        if (this.b == false) goto L5;
        return;
    L5:
        JSONObject r2 = new JSONObject(this.e);
        JSONObject r3 = new JSONObject();
        JSONObject r4 = new JSONObject(this.f);
        Long r0 = (Long) ((HashMap) this.d).get("duration");
        Iterator r6 = ((HashMap) this.d).entrySet().iterator();
        Long r7 = r0;
    L7:
        if (r6.hasNext() == false) goto L23;
        Map.Entry r1 = (Map.Entry) r6.next();
        Long r10 = (Long) r1.getValue();
        if (r10 == null) goto L15;
        if (r10.longValue() <= 0) goto L15;
        r3.put((String) r1.getKey(), String.valueOf(r10));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L15:
        if (r7 == null) goto L7;
        if (r7.longValue() <= 0) goto L7;
        if (TextUtils.equals((CharSequence) r1.getKey(), "duration") == true) goto L7;
        r7 = Long.valueOf(r7.longValue() - r10.longValue());     // Catch: Exception -> L13
        goto L7
    L23:
        if (r7 != null) goto L25;
    L61:
        if (r7 != null) goto L63;
    L70:
        int r5 = ECMonitorService.b;
        ECMonitorService.a.a(this.a, r2, r3, r4);
        ((HashMap) i).remove(toString());
        return;
    L63:
        if (r7.longValue() <= 0) goto L70;
        if (this.a.equals("ec_anchor_v3_detail_duration") == true) goto L70;
        r3.put("render_duration", String.valueOf(r7));     // Catch: Exception -> L68
    L68:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L70
    L25:
        if (r7.longValue() <= 0) goto L61;
        if (((HashMap) this.g).isEmpty() == true) goto L61;
        long r8 = r7.longValue();
        Long r9 = Long.valueOf(SystemClock.elapsedRealtime());
        Long r11 = Long.valueOf(SystemClock.elapsedRealtime());
        Iterator r12 = ((HashMap) this.g).entrySet().iterator();
        Object r13 = r11;
        long r14 = 0;
        Object r15 = r9;
    L30:
        if (r12.hasNext() == false) goto L60;
        Map.Entry r16 = (Map.Entry) r12.next();
        n r17 = (n) r16.getValue();
        if (((Long) r17.a).equals(r17.b) == true) goto L30;
        r3.put((String) r16.getKey(), String.valueOf(((Long) r17.b).longValue() - ((Long) r17.a).longValue()));     // Catch: Exception -> L57
        if (((Long) r15).longValue() > ((Long) r17.a).longValue()) goto L46;
        if (((Long) r13).longValue() < ((Long) r17.a).longValue()) goto L43;
        if (((Long) r13).longValue() >= ((Long) r17.b).longValue()) goto L43;
        Object r18 = r17.b;     // Catch: Exception -> L57
    L41:
        r13 = r18;
    L43:
        if (((Long) r13).longValue() >= ((Long) r17.a).longValue()) goto L30;
        r14 = r14 + (((Long) r17.a).longValue() - ((Long) r13).longValue());     // Catch: Exception -> L57
        r18 = r17.b;     // Catch: Exception -> L57
        goto L41
    L46:
        if (((Long) r15).longValue() > ((Long) r17.a).longValue()) goto L48;
    L55:
        r14 = r14 + (((Long) r15).longValue() - ((Long) r17.b).longValue());     // Catch: Exception -> L57
        Object r19 = r17.a;     // Catch: Exception -> L57
    L56:
        r15 = r19;
        goto L30
    L48:
        if (((Long) r15).longValue() > ((Long) r17.b).longValue()) goto L55;
        if (((Long) r13).longValue() > ((Long) r17.b).longValue()) goto L53;
        r15 = r17.a;     // Catch: Exception -> L57
        r18 = r17.b;     // Catch: Exception -> L57
        goto L41
    L53:
        if (((Long) r13).longValue() <= ((Long) r17.b).longValue()) goto L30;
        r19 = r17.a;     // Catch: Exception -> L57
    L57:
        e = move-exception;
        ECExceptionMonitor.g(e.toString());
        goto L30
    L60:
        ((HashMap) this.g).clear();
        r7 = Long.valueOf(r8 - ((((Long) r13).longValue() - ((Long) r15).longValue()) - r14));
        goto L61
    }

    public d() {
        this.b = false;
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
        this.b = true;
    }

    public final void h() {
        Choreographer.getInstance().postFrameCallback(new c(this));
        Map r0 = k.a;
        k.f("ec_perf_duration_anchor_v3_detail", null);
    }

    public d(String r2) {
        this.b = false;
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
        this.a = r2;
    }

    public static String c(String r2) {
        d r0 = new d(r2);
        String r3 = r0.toString();
        ((HashMap) i).put(r3, r0);
        return r3;
    }

    public static d f(String r2) {
        Map<String, d> r0 = i;
        if (((HashMap) r0).get(r2) != null) goto L7;
        return h;
    L7:
        return (d) ((HashMap) r0).get(r2);
    }

    public static void j(String r2) {
        HashMap r0 = new HashMap();
        r0.put("e_commerce", r2);
        Npth.addTags(r0);
    }

    public final void a(String r4) {
        Map<String, Long> r0 = this.c;
        HashMap r1 = (HashMap) r0;
        r1.put(r4, Long.valueOf(SystemClock.elapsedRealtime()));
    }

    public final void b(String r5) {
        Map<String, n<Long, Long>> r0 = this.g;
        HashMap r1 = (HashMap) r0;
        r1.put(r5, new n(Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(SystemClock.elapsedRealtime())));
    }

    public final void d(String r6) {
        long r0 = SystemClock.elapsedRealtime();
        Long r2 = (Long) ((HashMap) this.c).remove(r6);
        if (r2 != null) goto L5;
        return;
    L5:
        long r1 = r0 - r2.longValue();
        if (r1 <= 0) goto L13;
        Map<String, Long> r3 = this.d;
        HashMap r4 = (HashMap) r3;
        r4.put(r6, Long.valueOf(r1));
        if (TextUtils.equals(r6, "api_duration") == true) goto L10;
        return;
    L10:
        if (TextUtils.equals(this.a, "ec_anchor_v3_detail_duration") == false) goto L15;
        Map<String, Long> r7 = this.d;
        HashMap r8 = (HashMap) r7;
        r8.put("pack_api_duration", Long.valueOf(r1));
        ((HashMap) this.d).remove("api_duration");
        return;
    L15:
        return;
    }

    public final void e(String r6) {
        if (((HashMap) this.g).get(r6) != null) goto L5;
        return;
    L5:
        long r0 = SystemClock.elapsedRealtime();
        if (((Long) ((n) ((HashMap) this.g).get(r6)).a).longValue() >= r0) goto L9;
        n r7 = (n) ((HashMap) this.g).get(r6);
        r7.b = Long.valueOf(r0);
        return;
    }

    public final void i(String r2, String r3) {
        ((HashMap) this.e).put(r2, r3);
    }
}
