package bs3;

import android.os.IBinder;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.constant.UploadTypeInf;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k extends a<cs3.d> implements zr3.b {
    @Override // zr3.b
    public final String g() {
        return "android.os.IPowerManager";
    }

    public k() {
        super(BatteryTypeInf.BATTERY_POWER_LOCK);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void q(Object[] r5) {
        l();
        Object r0 = vr3.b.C;
        if (vr3.b.e.a.p == true) goto L5;
        return;
    L5:
        if (r5.length <= 7) goto L7;
        return;
    L7:
        if (r5.length < 4) goto L37;
        Object r1 = r5[0];
        if (r1 != null) goto L12;
        return;
    L12:
        if ((r1 instanceof IBinder) == false) goto L36;
        int r2 = r1.hashCode();
        if (this.e.containsKey(Integer.valueOf(r2)) == true) goto L25;
        cs3.d r3 = new cs3.d();
        Object r4 = r5[1];
        if (r4 != null) goto L18;
        return;
    L18:
        if ((r4 instanceof Integer) == false) goto L30;
        r3.e = ((Integer) r4).intValue();
        Object r6 = r5[2];
        if (r6 != null) goto L22;
        return;
    L22:
        if ((r6 instanceof String) == false) goto L32;
        r3.f = (String) r6;
        r3.b = -1;
    L28:
        r3.d = ThreadMethodProxy.currentThread().getStackTrace();
        r3.c = ThreadMethodProxy.currentThread().getName();
        r3.a = System.currentTimeMillis();
        this.e.put(Integer.valueOf(r2), r3);
        return;
    L32:
        return;
    L30:
        return;
    L25:
        r3 = (cs3.d) this.e.get(Integer.valueOf(r2));
        if (r3 != null) goto L28;
        return;
    L36:
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void r(Object[] r4) {
        n();
        Object r0 = vr3.b.C;
        if (vr3.b.e.a.p == true) goto L5;
        return;
    L5:
        if (r4.length == 2) goto L7;
        return;
    L7:
        Object r5 = r4[0];
        if (r5 != null) goto L10;
        return;
    L10:
        if ((r5 instanceof IBinder) == false) goto L17;
        int r6 = r5.hashCode();
        cs3.d r1 = (cs3.d) this.e.get(Integer.valueOf(r6));
        if (r1 == null) goto L18;
        r1.b = System.currentTimeMillis();
        this.e.put(Integer.valueOf(r6), r1);
        return;
    L18:
        return;
    }

    @Override // bs3.l
    public final void a(as3.c r5, ms3.a r6) {
        if (getType().equals(r6.d) == true) goto L5;
        return;
    L5:
        if (r6.b == false) goto L7;
        r5.g += r6.g;
        return;
    L7:
        r5.p += r6.g;
    }

    @Override // zr3.b
    public final synchronized void e(Method r2, Object[] r3) {
        monitor-enter(this);
        String r4 = r2.getName();     // Catch: Throwable -> L10 Exception -> L15
        if ("acquireWakeLock".equals(r4) == false) goto L7;
        q(r3);     // Catch: Throwable -> L10 Exception -> L15
    L16:
        goto L13
    L7:
        if ("releaseWakeLock".equals(r4) == false) goto L16;
        r(r3);     // Catch: Throwable -> L10 Exception -> L15
    L10:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(this);
    }

    @Override // bs3.a
    public final void o(double r6, double r8) {
        if (r6 < wr3.a.c) goto L5;
        int r1 = 17;
    L7:
        if (r8 < wr3.a.b) goto L9;
        r1 = r1 | 18;
    L9:
        if (r1 != 0) goto L25;
        return;
    L25:
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L24
        r2.put("issue_type", r1).put("total_hold_time", r6).put("total_acquire_count", r8);     // Catch: Throwable -> L24
        ConcurrentHashMap<Integer, T> r7 = this.e;     // Catch: Throwable -> L24
        if (r7 != 0) goto L14;
    L27:
        Object r9 = vr3.b.C;     // Catch: Throwable -> L23
        vr3.b.e.a.getClass();     // Catch: Throwable -> L23
    L21:
        ss3.b.a(r2);     // Catch: Throwable -> L24
        is3.a.h().b(new js3.c(UploadTypeInf.BATTERY_EXCEPTION_TRACE, r2));     // Catch: Throwable -> L24
        return;
    L14:
        if (r7.size() <= 0) goto L27;
        JSONArray r10 = new JSONArray();     // Catch: Throwable -> L24
        Iterator r11 = this.e.values().iterator();     // Catch: Throwable -> L24
    L17:
        if (r11.hasNext() == false) goto L19;
        r10.put(((cs3.d) r11.next()).b());     // Catch: Throwable -> L24
        goto L17
    L19:
        r2.put("detail", r10);     // Catch: Throwable -> L24
    L30:
        return;
    L5:
        r1 = 0;
        goto L7
    }

    @Override // bs3.a
    public final void p(cs3.b r5, long r6) {
        cs3.d r7 = (cs3.d) r5;
        if (r6 < wr3.a.a) goto L15;
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L10
        r1.put("event_type", UploadTypeInf.BATTERY_EXCEPTION_TRACE);     // Catch: JSONException -> L10
        r1.put("issue_type", 16).put("single_hold_time", r6).put("wake_lock_info", r7.toString());     // Catch: JSONException -> L10
        Object r8 = vr3.b.C;     // Catch: Throwable -> L9
        vr3.b.e.a.getClass();     // Catch: Throwable -> L9
    L7:
        ss3.b.a(r1);     // Catch: JSONException -> L10
        is3.a.h().b(new js3.c(UploadTypeInf.BATTERY_EXCEPTION_TRACE, r1));     // Catch: JSONException -> L10
        return;
    L16:
        return;
    }
}
