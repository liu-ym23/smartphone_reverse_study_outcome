package lx3;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.EventType;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.priority.PriorityWrapper;
import com.ss.android.common.applog.e0;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static final List<String> e = null;
    public final Context a;
    public final jx3.b b;
    public final zw3.d c;
    public final com.bytedance.applog.b d;

    static {
        e = Collections.singletonList("BgSessionTaskModel");
    }

    public final void a() {
        this.d.t0.k(0, e, "[Task] clear task session sp", new Object[0]);
        SharedPreferences.Editor r1 = this.a.getSharedPreferences(b(), 0).edit();     // Catch: Throwable -> L5
        r1.putString("key_task_session", "");     // Catch: Throwable -> L5
        r1.apply();     // Catch: Throwable -> L5
        return;
    }

    public final String b() {
        if (this.d.getInitConfig() == null) goto L6;
        return this.d.getInitConfig().z;
    L6:
        return "applog_task@" + this.d.j;
    }

    public final boolean c(k r19) {
        if (r19 != null) goto L51;
        return false;
    L51:
        final jx3.k r8 = new jx3.k();     // Catch: Throwable -> L48
        com.bytedance.applog.b r0 = this.d;     // Catch: Throwable -> L48
        if (r0.n == null) goto L9;
        r0.n.k.a(r8);     // Catch: Throwable -> L48
    L9:
        ((jx3.a) r8).b = r19.a;     // Catch: Throwable -> L48
        ((jx3.a) r8).d = r19.b;     // Catch: Throwable -> L48
        r8.E = 1;     // Catch: Throwable -> L48
        if ((!TextUtils.isEmpty(r19.d)) == false) goto L13;
        r8.D = r19.d;     // Catch: Throwable -> L48
    L13:
        if ((!TextUtils.isEmpty(r19.f)) == false) goto L15;
        r8.C = r19.f;     // Catch: Throwable -> L48
    L15:
        r8.y = Math.max(0, (r19.h - r19.a) - r19.i);     // Catch: Throwable -> L48
        r8.z = r19.h;     // Catch: Throwable -> L48
        boolean r1 = r19.c;     // Catch: Throwable -> L48
        boolean r4 = r19.e;     // Catch: Throwable -> L48
        if (r1 == true) goto L19;
        if (r4 == true) goto L19;
        int r2 = 1;
    L25:
        r8.B = Integer.valueOf(r2);     // Catch: Throwable -> L48
        JSONObject r3 = r19.g;     // Catch: Throwable -> L48
        if (r3 == null) goto L29;
        r8.F = r3.toString();     // Catch: Throwable -> L48
    L29:
        if (this.d.D == false) goto L39;
        if (this.d.S1() == null) goto L39;
        PriorityWrapper r5 = this.d.S1();     // Catch: Throwable -> L48
        EventType r6 = EventType.Terminate;     // Catch: Throwable -> L48
        if (r5.f(r6.value()) == false) goto L39;
        if (this.d.S1().h(r6.value(), "terminate", new b(r8)) == false) goto L39;
        this.d.t0.g(0, e, "[Task] save session terminate to priority success", new Object[0]);     // Catch: Throwable -> L48
        return true;
    L39:
        if (this.c.c == false) goto L50;
        JSONObject r7 = this.c.a();     // Catch: Throwable -> L48
        nx3.i.a(r7);     // Catch: Throwable -> L48
        e0.b r9 = this.d.q;     // Catch: Throwable -> L48
        if (r9 != null) goto L52;
    L46:
        this.d.t0.k(0, e, "[Task] save task session to db : {}", new Object[]{r19});     // Catch: Throwable -> L48
        jx3.i r10 = new jx3.i();     // Catch: Throwable -> L48
        r10.x(this.d.j, r7, null, r8, null, new JSONArray[]{null, null, null}, new long[]{-1, -1, -1}, null, null, 9);     // Catch: Throwable -> L48
        this.b.y(r10, true, null, null);     // Catch: Throwable -> L48
        return true;
    L52:
        r9.a(r7);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        this.d.W.b(StatsCountKeys.PACK_ERROR_COUNT, 1);     // Catch: Throwable -> L48
        this.d.t0.s(e, "header custom callback updateHeader error", th, new Object[0]);     // Catch: Throwable -> L48
    L50:
        return false;
    L19:
        if (r1 == false) goto L22;
        if (r4 == true) goto L22;
        r2 = 2;
    L22:
        if (r1 == true) goto L24;
        r2 = 3;
        goto L25
    L24:
        r2 = 4;
    L48:
        th = move-exception;
        this.d.t0.s(e, "[Task] Save task session to pack failed", th, new Object[0]);
        goto L50
    }

    public final void d(k r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        this.d.t0.k(0, e, "[Task] saveTaskSessionToSp : {}", new Object[]{r6});
        String r7 = r6.a();
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        SharedPreferences.Editor r0 = this.a.getSharedPreferences(b(), 0).edit();     // Catch: Throwable -> L9
        r0.putString("key_task_session", r7);     // Catch: Throwable -> L9
        r0.apply();     // Catch: Throwable -> L9
        return;
    }

    public d(com.bytedance.applog.b r1, jx3.b r2, zw3.d r3) {
        this.b = r2;
        this.c = r3;
        this.d = r1;
        this.a = r1.getContext();
        l.d().b(new c(this));
    }
}
