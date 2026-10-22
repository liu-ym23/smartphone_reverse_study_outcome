package bs3;

import android.text.TextUtils;
import com.bytedance.apm.constant.UploadTypeInf;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends a<cs3.c> implements zr3.b {
    public final List<String> k;

    @Override // zr3.b
    public final String g() {
        return "android.location.ILocationManager";
    }

    public g() {
        super("location");
        this.k = new ArrayList();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void q(Object[] r4) {
        Object r5 = r4[0];
        if (r5 == null) goto L13;
        int r6 = r5.hashCode();
        String r0 = String.valueOf(r6);
        if (((ArrayList) this.k).contains(r0) == false) goto L7;
        n();
        ((ArrayList) this.k).remove(r0);
    L7:
        Object r1 = vr3.b.C;
        if (vr3.b.e.a.p == false) goto L14;
        cs3.c r2 = (cs3.c) this.e.get(Integer.valueOf(r6));
        if (r2 == null) goto L15;
        r2.b = System.currentTimeMillis();
        this.e.put(Integer.valueOf(r6), r2);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // bs3.l
    public final void a(as3.c r5, ms3.a r6) {
        if (getType().equals(r6.d) == true) goto L5;
        return;
    L5:
        if (r6.b == false) goto L7;
        r5.f += r6.g;
        return;
    L7:
        r5.o += r6.g;
    }

    @Override // zr3.b
    public final void e(Method r3, Object[] r4) {
        String r5 = r3.getName();     // Catch: Exception -> L22
        if (TextUtils.equals(r5, "requestLocationUpdates") == false) goto L10;
        if (r4[0] == null) goto L23;
        Object r0 = r4[1];     // Catch: Exception -> L22
        if (r0 == null) goto L23;
        r(r0.hashCode(), r4[0].toString());     // Catch: Exception -> L22
    L23:
        return;
    L10:
        if (TextUtils.equals(r5, "registerLocationListener") == false) goto L17;
        if (r4[1] == null) goto L23;
        Object r6 = r4[2];     // Catch: Exception -> L22
        if (r6 == null) goto L23;
        r(r6.hashCode(), r4[1].toString());     // Catch: Exception -> L22
        goto L23
    L17:
        if (TextUtils.equals(r5, "removeUpdates") == false) goto L19;
    L20:
        q(r4);     // Catch: Exception -> L22
        goto L23
    L19:
        if (TextUtils.equals(r5, "unregisterLocationListener") == false) goto L23;
    }

    @Override // bs3.a
    public final void o(double r6, double r8) {
        if (r6 < wr3.a.h) goto L5;
        int r1 = 33;
    L7:
        if (r8 < wr3.a.g) goto L9;
        r1 = r1 | 34;
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
        r10.put(((cs3.c) r11.next()).b());     // Catch: Throwable -> L24
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
        cs3.c r7 = (cs3.c) r5;
        if (r6 < wr3.a.f) goto L15;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L10
        r1.put("issue_type", 32).put("single_hold_time", r6);     // Catch: Throwable -> L10
        JSONArray r8 = new JSONArray();     // Catch: Throwable -> L10
        r8.put(r7.b());     // Catch: Throwable -> L10
        r1.put("detail", r8);     // Catch: Throwable -> L10
        Object r9 = vr3.b.C;     // Catch: Throwable -> L9
        vr3.b.e.a.getClass();     // Catch: Throwable -> L9
    L7:
        ss3.b.a(r1);     // Catch: Throwable -> L10
        is3.a.h().b(new js3.c(UploadTypeInf.BATTERY_EXCEPTION_TRACE, r1));     // Catch: Throwable -> L10
        return;
    L16:
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void r(int r4, String r5) {
        String r0 = String.valueOf(r4);
        if (((ArrayList) this.k).contains(r0) == true) goto L5;
        l();
        ((ArrayList) this.k).add(r0);
    L5:
        Object r1 = vr3.b.C;
        if (vr3.b.e.a.p == false) goto L12;
        cs3.c r2 = (cs3.c) this.e.get(Integer.valueOf(r4));
        if (r2 != null) goto L10;
        r2 = new cs3.c();
        r2.e = r5;
    L10:
        r2.a = System.currentTimeMillis();
        r2.b = -1;
        r2.d = ThreadMethodProxy.currentThread().getStackTrace();
        r2.c = ThreadMethodProxy.currentThread().getName();
        this.e.put(Integer.valueOf(r4), r2);
        return;
    }
}
