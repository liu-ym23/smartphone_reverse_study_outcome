package bs3;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends c<cs3.a> implements zr3.b {
    public int[] f;
    public int g;
    public final List<Long> h;
    public int i;
    public final Object j;
    public final List<Long> k;

    @Override // bs3.l
    public final void d(boolean r1) {
    }

    @Override // zr3.b
    public final String g() {
        return "android.app.IAlarmManager";
    }

    @Override // bs3.l
    public final void i(boolean r1) {
    }

    public d() {
        super(BatteryTypeInf.BATTERY_ALARM);
        this.h = new ArrayList();
        this.j = new Object();
        this.k = new ArrayList();
    }

    @Override // bs3.c, bs3.l
    public final void f(boolean r4) {
        this.c = false;
        long r0 = System.currentTimeMillis();
        Object r5 = this.j;
        monitor-enter(r5);
        List<Long> r2 = this.h;     // Catch: Throwable -> L7
        ArrayList r3 = (ArrayList) r2;     // Catch: Throwable -> L7
        r3.add(Long.valueOf(r0));     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // bs3.c, bs3.l
    public final void h(boolean r4) {
        this.c = true;
        long r0 = System.currentTimeMillis();
        Object r5 = this.j;
        monitor-enter(r5);
        List<Long> r2 = this.h;     // Catch: Throwable -> L7
        ArrayList r3 = (ArrayList) r2;     // Catch: Throwable -> L7
        r3.add(Long.valueOf(r0));     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void l(Object[] r12) {
        cs3.a r0 = new cs3.a();
        int r1 = r12.length;
        int r2 = 0;
        boolean r4 = false;
        int r5 = 0;
        int r6 = -1;
    L3:
        if (r2 >= r1) goto L30;
        Object r7 = r12[r2];
        if ((r7 instanceof Integer) == false) goto L9;
        if (r4 == true) goto L9;
        r0.e = ((Integer) r7).intValue();
        r4 = true;
    L29:
        r2 = r2 + 1;
    L9:
        if ((r7 instanceof Long) == false) goto L22;
        if (r5 != 0) goto L18;
        long r8 = ((Long) r7).longValue();
        r0.a = r8;
        int r10 = r0.e;
        if (r10 == 1) goto L16;
        if (r10 == 0) goto L16;
        r8 = (r8 + System.currentTimeMillis()) - SystemClock.elapsedRealtime();
    L16:
        r0.a = r8;
    L20:
        r5 = r5 + 1;
        goto L29
    L18:
        if (r5 != 2) goto L20;
        r0.f = ((Long) r7).longValue();
        goto L20
    L22:
        if ((r7 instanceof PendingIntent) == false) goto L29;
        PendingIntent r9 = (PendingIntent) r7;
        if (Build.VERSION.SDK_INT > 23) goto L27;
        if (r9 == null) goto L27;
        String r11 = ((Intent) Reflect.on(r9).call("getIntent").get()).toString();
    L28:
        r0.g = r11;
        r6 = r9.hashCode();
    L27:
        r11 = "";
        goto L28
    L30:
        if (r6 != (-1)) goto L32;
        return;
    L32:
        if (r0.f != 0) goto L34;
        long r3 = r0.a;
    L35:
        r0.b = r3;
        Object r13 = vr3.b.C;
        if (vr3.b.e.a.p == false) goto L38;
        r0.c = ThreadMethodProxy.currentThread().getName();
        r0.d = ThreadMethodProxy.currentThread().getStackTrace();
    L38:
        this.e.put(Integer.valueOf(r6), r0);
        return;
    L34:
        r3 = -1;
        goto L35
    }

    @Override // bs3.l
    public final void a(as3.c r5, ms3.a r6) {
        if (getType().equals(r6.d) == true) goto L6;
        return;
    L6:
        if ((!r6.b) == false) goto L8;
        r5.q += r6.g;
        return;
    L8:
        r5.h += r6.g;
    }

    @Override // bs3.l
    public final void c(boolean r1, boolean r2) {
        this.d = r1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // zr3.b
    public final void e(Method r6, Object[] r7) {
        String r8 = r6.getName();     // Catch: Exception -> L19
        if ("set".equals(r8) == false) goto L6;
        l(r7);     // Catch: Exception -> L19
        return;
    L6:
        if ("remove".equals(r8) == false) goto L22;
        Object r9 = r7[0];     // Catch: Exception -> L19
        if (r9 != null) goto L10;
    L12:
        int r10 = -1;
    L13:
        cs3.a r11 = (cs3.a) this.e.get(Integer.valueOf(r10));     // Catch: Exception -> L19
        if (r11 != null) goto L16;
        return;
    L16:
        if (r11.f <= 0) goto L24;
        r11.b = System.currentTimeMillis();     // Catch: Exception -> L19
        this.e.put(Integer.valueOf(r10), r11);     // Catch: Exception -> L19
        return;
    L24:
        return;
    L10:
        if ((r9 instanceof PendingIntent) == false) goto L12;
        r10 = r9.hashCode();     // Catch: Exception -> L19
        goto L13
    L22:
        return;
    }

    @Override // bs3.c
    public final void j(cs3.b r10, long r11, long r13) {
        cs3.a r12 = (cs3.a) r10;
        long r0 = r12.f;
        boolean r2 = true;
        if (r0 > 0) goto L9;
        long r1 = r12.a;
        if (r11 <= r1) goto L7;
        return;
    L7:
        if (r1 > r13) goto L31;
        int r14 = 1;
    L21:
        int r15 = r12.e;
        if (r15 == 2) goto L26;
        if (r15 == 0) goto L26;
        r2 = false;
    L26:
        if (r2 == false) goto L28;
        int[] r16 = this.f;
        int r17 = this.i % 2;
        r16[r17] = r16[r17] + r14;
        return;
    L28:
        this.g += r14;
        return;
    L31:
        return;
    L9:
        long r5 = r12.a;
        if (r5 >= r11) goto L12;
        r5 = (r11 + r0) - ((r11 - r5) % r0);
    L12:
        long r18 = r12.b;
        if (r18 <= r13) goto L15;
    L18:
        long r19 = r13 - r5;
        if (r19 <= 0) goto L32;
        r14 = ((int) (r19 / r0)) + 1;
        goto L21
    L32:
        return;
    L15:
        if (r18 <= 0) goto L18;
        r13 = r18;
        goto L18
    }

    @Override // bs3.c
    public final void k(long r20, long r22, boolean r24) {
        int r0 = 0;
        this.g = 0;
        this.f = new int[2];
        ((ArrayList) this.k).add(Long.valueOf(r20));
        Object r1 = this.j;
        monitor-enter(r1);
        ((ArrayList) this.k).addAll(this.h);     // Catch: Throwable -> L42
        ((ArrayList) this.h).clear();     // Catch: Throwable -> L42
        monitor-exit(r1);     // Catch: Throwable -> L42
        ((ArrayList) this.k).add(Long.valueOf(r22));
        this.i = 1;
    L8:
        if (this.i >= ((ArrayList) this.k).size()) goto L10;
        super.k(((Long) ListProtector.get(this.k, this.i - 1)).longValue(), ((Long) ListProtector.get(this.k, this.i)).longValue(), r24);
        this.i++;
        goto L8
    L10:
        int[] r2 = this.f;
        if ((r2[0] + r2[1]) == 0) goto L22;
        int r3 = ((ArrayList) this.k).size();
        long r4 = System.currentTimeMillis();
        if (this.c == false) goto L17;
        if ((r3 % 2) != 0) goto L17;
    L20:
        as3.b r5 = as3.b.a.a;
        r5.g(new ms3.a(false, r4, getType(), this.d, r2[0], null));
        r5.g(new ms3.a(true, r4, getType(), this.d, r2[1], null));
    L17:
        if (this.c == false) goto L19;
    L21:
        as3.b r6 = as3.b.a.a;
        r6.g(new ms3.a(true, r4, getType(), this.d, r2[0], null));
        r6.g(new ms3.a(false, r4, getType(), this.d, r2[1], null));
        goto L22
    L19:
        if ((r3 % 2) != 1) goto L21;
    L22:
        ((ArrayList) this.k).clear();
        long r7 = System.currentTimeMillis();
        int[] r8 = this.f;
        double r9 = (((((double) r8[0]) + ((double) r8[1])) / (r7 - this.b)) * 60000.0d) * 10.0d;
        double r12 = ((((double) this.g) / (r7 - this.b)) * 60000.0d) * 10.0d;
        if (r9 < wr3.a.d) goto L26;
        r0 = 49;
    L26:
        if (r12 < wr3.a.e) goto L28;
        r0 = r0 | 50;
    L28:
        if (r0 == 0) goto L55;
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L46
        r10.put("issue_type", r0).put("wake_up_count", r9).put("normal_count", r12);     // Catch: Throwable -> L46
        ConcurrentHashMap<Integer, T> r11 = this.e;     // Catch: Throwable -> L46
        if (r11 != 0) goto L33;
    L49:
        Object r13 = vr3.b.C;     // Catch: Throwable -> L45
        vr3.b.e.a.getClass();     // Catch: Throwable -> L45
    L40:
        ss3.b.a(r10);     // Catch: Throwable -> L46
        is3.a.h().b(new js3.c(UploadTypeInf.BATTERY_EXCEPTION_TRACE, r10));     // Catch: Throwable -> L46
        return;
    L33:
        if (r11.size() <= 0) goto L49;
        JSONArray r14 = new JSONArray();     // Catch: Throwable -> L46
        Iterator r15 = this.e.values().iterator();     // Catch: Throwable -> L46
    L36:
        if (r15.hasNext() == false) goto L38;
        r14.put(((cs3.a) r15.next()).b());     // Catch: Throwable -> L46
        goto L36
    L38:
        r10.put("detail", r14);     // Catch: Throwable -> L46
    L56:
        return;
    L55:
        return;
    L42:
        th = move-exception;
        throw th;
    }
}
