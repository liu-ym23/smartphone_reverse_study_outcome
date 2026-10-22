package rw3;

import android.text.TextUtils;
import com.bytedance.applog.log.m;
import com.bytedance.applog.log.n;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.ss.android.common.applog.e0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import jx3.b;
import jx3.f;
import org.json.JSONArray;
import org.json.JSONObject;
import vw3.a;
import zw3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j extends a {
    public static final List<String> g = null;
    public final a f;

    public final String d() {
        return "ForwardSender";
    }

    public final boolean f() {
        return true;
    }

    static {
        g = Collections.singletonList("ForwardSender");
    }

    public final long g() {
        a r0 = this.f;
        if (r0 == null) goto L7;
        return r0.b;
    L7:
        return ((a) this).a.d.b();
    }

    public final long[] e() {
        return a.e;
    }

    public final synchronized boolean c(int r10) {
        monitor-enter(this);
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L23
        f r2 = ((a) this).a;     // Catch: Throwable -> L23
        n r3 = r2.k;     // Catch: Throwable -> L23
        n r4 = r2.c.t0;     // Catch: Throwable -> L23
        List<String> r5 = g;     // Catch: Throwable -> L23
        Object[] r6 = new Object[4];     // Catch: Throwable -> L23
        boolean r8 = false;
        r6[0] = "ForwardSender";     // Catch: Throwable -> L23
        r6[1] = Long.valueOf(r0);     // Catch: Throwable -> L23
        if (r3 == null) goto L6;
        String r1 = r3.i;     // Catch: Throwable -> L23
    L7:
        r6[2] = r1;     // Catch: Throwable -> L23
        r6[3] = Integer.valueOf(r10);     // Catch: Throwable -> L23
        r4.k(0, r5, "{} start doWork curTs={}, curSid={}, requestFrom={}", r6);     // Catch: Throwable -> L23
        b r7 = ((a) this).a.f();     // Catch: Throwable -> L23
        d r9 = ((a) this).a.h;     // Catch: Throwable -> L23
        if (r9.c == true) goto L10;
    L21:
        monitor-exit(this);
        return r8;
    L10:
        if (this.f == null) goto L21;
        JSONObject r11 = r9.a();     // Catch: Throwable -> L23
        nx3.i.a(r11);     // Catch: Throwable -> L23
        e0.b r12 = ((a) this).a.c.q;     // Catch: Throwable -> L23
        if (r12 != null) goto L28;
    L17:
        List<f> r13 = r7.u();     // Catch: Throwable -> L23
        if (((ArrayList) r13).isEmpty() == true) goto L20;
        r7.d(r13);     // Catch: Throwable -> L23
        h(r13, r11, r10);     // Catch: Throwable -> L23
    L20:
        r8 = true;
        goto L21
    L28:
        r12.a(r11);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        ((a) this).a.c.W.b(StatsCountKeys.PACK_ERROR_COUNT, 1);     // Catch: Throwable -> L23
        ((a) this).a.c.W.h("HeaderCustomTimelyCallback update header failed", th, true);     // Catch: Throwable -> L23
        ((a) this).a.c.t0.s(g, "header custom callback updateHeader error", th, new Object[0]);     // Catch: Throwable -> L23
        goto L17
    L6:
        r1 = "null";
    L23:
        th = move-exception;
        throw th;
    }

    public j(f r1, a r2) {
        super(r1);
        this.f = r2;
    }

    public final void h(List<f> r27, JSONObject r28, int r29) {
        if (this.f != null) goto L5;
        return;
    L5:
        Iterator r0 = ((ArrayList) r27).iterator();
        ArrayList r2 = new ArrayList();
        HashSet r3 = new HashSet();
    L6:
        int r5 = 2;
        boolean r9 = true;
        if (r0.hasNext() == false) goto L19;
        JSONArray r4 = new JSONArray();
        jx3.i r15 = new jx3.i();
        r15.x(((a) this).a.c.j, r28, null, null, null, new JSONArray[]{null, r4, null}, new long[]{0, 0, 0}, null, null, r29);
    L10:
        if (r0.hasNext() == false) goto L18;
        f r6 = (f) r0.next();
        r4.put(r6.o());
        if (m.b() == true) goto L17;
        long r10 = ((jx3.a) r6).q;
        if (r10 <= 0) goto L17;
        r3.add(Long.valueOf(r10));
    L17:
        if (r4.length() != 200) goto L10;
    L18:
        r15.y();
        r2.add(r15);
        goto L6
    L19:
        List r1 = this.f.b();
        if (r1 != null) goto L22;
    L57:
        boolean r8 = false;
    L58:
        String r7 = ((a) this).a.c.j;
        if (m.b() == false) goto L62;
        return;
    L62:
        if (r3.isEmpty() == true) goto L77;
        m.c("event_upload_eid", new i(r7, r3, r8));
        return;
    L77:
        return;
    L22:
        if (r1.isEmpty() == true) goto L57;
        Iterator r11 = r1.iterator();
        boolean r12 = true;
    L26:
        if (r11.hasNext() == false) goto L56;
        String r13 = (String) r11.next();
        com.bytedance.applog.b r14 = ((a) this).a.c;
        String r16 = r14.e.a(r14.getContext(), r13);
        Iterator r17 = r2.iterator();
        boolean r18 = r12;
    L29:
        if (r17.hasNext() == false) goto L55;
        jx3.i r19 = (jx3.i) r17.next();
        com.bytedance.applog.b r110 = ((a) this).a.c;
        ix3.a r111 = r110.f;
        ConcurrentHashMap r112 = r110.i0;
        r111.getClass();
        if (r19 != null) goto L34;
    L51:
        boolean r113 = true;
    L54:
        r18 = r18 & r113;
        r5 = 2;
        r9 = true;
        goto L29
    L34:
        if (TextUtils.isEmpty(r16) == true) goto L51;
        HashMap r20 = r111.e(r9, r19.O, r19.P);
        if (r112 != null) goto L39;
    L41:
        String r114 = UUID.randomUUID().toString();
        r111.i(r16, r114, r19.y, r20);
        r111.b.W.b(StatsCountKeys.REPORT_REQUEST_COUNT, r9 ? 1 : 0);
        n r115 = r111.b.t0;     // Catch: Throwable -> L52
        List r21 = ix3.a.d;     // Catch: Throwable -> L52
        Object[] r22 = new Object[r5];     // Catch: Throwable -> L52
        r22[0] = r114;     // Catch: Throwable -> L52
        r22[1] = r16;     // Catch: Throwable -> L52
        r115.k(11, r21, "trySendForward start requestId={}, url={}", r22);     // Catch: Throwable -> L52
        String r23 = r111.b.getNetClient().post(r16, r19.y, r20);     // Catch: Throwable -> L52
        r111.b.t0.k(11, r21, "trySendForward resp:{} ", new Object[]{r23});     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r23) == false) goto L45;
        int r24 = -1;
    L47:
        if (TextUtils.isEmpty(r23) == false) goto L49;
        byte[] r25 = null;
    L50:
        r111.h(r114, r24, r25, null);     // Catch: Throwable -> L52
        goto L51
    L49:
        r25 = r23.getBytes("UTF-8");     // Catch: Throwable -> L52
        goto L50
    L45:
        r24 = 200;
    L52:
        th = move-exception;
        r111.b.t0.r(11, ix3.a.d, "trySendForward failed ", th, new Object[0]);
        r111.b.W.b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);
        r111.b.W.b(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT, 1);
        r111.b.W.h("api send forward log failed", th, true);
        r111.h(r114, -1, null, "Send forward log error");
        r113 = false;
        goto L54
    L39:
        if (r112.isEmpty() == true) goto L41;
        r20.putAll(r112);
        goto L41
    L55:
        r12 = r18;
        goto L26
    L56:
        r8 = r12;
        goto L58
    }
}
