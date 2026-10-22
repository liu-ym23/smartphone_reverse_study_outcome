package lx3;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.EventType;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.priority.PriorityWrapper;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.common.applog.e0;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<String> f511123e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f511124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jx3.b f511125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zw3.d f511126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.applog.b f511127d;

    static {
        f511123e = Collections.singletonList("BgSessionTaskModel");
    }

    public final void a() {
        this.f511127d.f192434t0.k(0, f511123e, "[Task] clear task session sp", new Object[0]);
        SharedPreferences.Editor r100 = this.f511124a.getSharedPreferences(b(), 0).edit();     // Catch: Throwable -> L5
        r100.putString("key_task_session", "");     // Catch: Throwable -> L5
        r100.apply();     // Catch: Throwable -> L5
        return;
    }

    public final String b() {
        if (this.f511127d.getInitConfig() == null) goto L6;
        return this.f511127d.getInitConfig().f192834z;
    L6:
        return "applog_task@" + this.f511127d.f192413j;
    }

    public final boolean c(k r110) {
        if (r110 != null) goto L51;
        return false;
    L51:
        final jx3.k r100 = new jx3.k();     // Catch: Throwable -> L48
        com.bytedance.applog.b r101 = this.f511127d;     // Catch: Throwable -> L48
        if (r101.f192421n == null) goto L9;
        r101.f192421n.f539611k.a(r100);     // Catch: Throwable -> L48
    L9:
        r100.f500758b = r110.f511155a;     // Catch: Throwable -> L48
        r100.f500760d = r110.f511156b;     // Catch: Throwable -> L48
        r100.E = 1;     // Catch: Throwable -> L48
        if ((!TextUtils.isEmpty(r110.f511158d)) == false) goto L13;
        r100.D = r110.f511158d;     // Catch: Throwable -> L48
    L13:
        if ((!TextUtils.isEmpty(r110.f511160f)) == false) goto L15;
        r100.C = r110.f511160f;     // Catch: Throwable -> L48
    L15:
        r100.f500812y = Math.max(0, (r110.f511162h - r110.f511155a) - r110.f511163i);     // Catch: Throwable -> L48
        r100.f500813z = r110.f511162h;     // Catch: Throwable -> L48
        boolean r102 = r110.f511157c;     // Catch: Throwable -> L48
        boolean r103 = r110.f511159e;     // Catch: Throwable -> L48
        if (r102 == true) goto L19;
        if (r103 == true) goto L19;
        int r104 = 1;
    L25:
        r100.B = Integer.valueOf(r104);     // Catch: Throwable -> L48
        JSONObject r105 = r110.f511161g;     // Catch: Throwable -> L48
        if (r105 == null) goto L29;
        r100.F = r105.toString();     // Catch: Throwable -> L48
    L29:
        if (this.f511127d.D == false) goto L39;
        if (this.f511127d.S1() == null) goto L39;
        PriorityWrapper r106 = this.f511127d.S1();     // Catch: Throwable -> L48
        EventType r107 = EventType.Terminate;     // Catch: Throwable -> L48
        if (r106.f(r107.value()) == false) goto L39;
        if (this.f511127d.S1().h(r107.value(), EventVerify.TYPE_TERMINATE, new b(r100)) == false) goto L39;
        this.f511127d.f192434t0.g(0, f511123e, "[Task] save session terminate to priority success", new Object[0]);     // Catch: Throwable -> L48
        return true;
    L39:
        if (this.f511126c.f573833c == false) goto L50;
        JSONObject r108 = this.f511126c.a();     // Catch: Throwable -> L48
        nx3.i.a(r108);     // Catch: Throwable -> L48
        com.bytedance.applog.k r109 = this.f511127d.f192427q;     // Catch: Throwable -> L48
        if (r109 != null) goto L52;
    L46:
        this.f511127d.f192434t0.k(0, f511123e, "[Task] save task session to db : {}", new Object[]{r110});     // Catch: Throwable -> L48
        jx3.i r111 = new jx3.i();     // Catch: Throwable -> L48
        r111.x(this.f511127d.f192413j, r108, null, r100, null, new JSONArray[]{null, null, null}, new long[]{-1, -1, -1}, null, null, 9);     // Catch: Throwable -> L48
        this.f511125b.y(r111, true, null, null);     // Catch: Throwable -> L48
        return true;
    L52:
        ((e0.b) r109).a(r108);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        this.f511127d.W.b(StatsCountKeys.PACK_ERROR_COUNT, 1);     // Catch: Throwable -> L48
        this.f511127d.f192434t0.s(f511123e, "header custom callback updateHeader error", th, new Object[0]);     // Catch: Throwable -> L48
    L50:
        return false;
    L19:
        if (r102 == false) goto L22;
        if (r103 == true) goto L22;
        r104 = 2;
    L22:
        if (r102 == true) goto L24;
        r104 = 3;
        goto L25
    L24:
        r104 = 4;
    L48:
        th = move-exception;
        this.f511127d.f192434t0.s(f511123e, "[Task] Save task session to pack failed", th, new Object[0]);
        goto L50
    }

    public final void d(k r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f511127d.f192434t0.k(0, f511123e, "[Task] saveTaskSessionToSp : {}", new Object[]{r100});
        String r101 = r100.a();
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        SharedPreferences.Editor r102 = this.f511124a.getSharedPreferences(b(), 0).edit();     // Catch: Throwable -> L9
        r102.putString("key_task_session", r101);     // Catch: Throwable -> L9
        r102.apply();     // Catch: Throwable -> L9
        return;
    }

    public d(com.bytedance.applog.b r100, jx3.b r101, zw3.d r102) {
        this.f511125b = r101;
        this.f511126c = r102;
        this.f511127d = r100;
        this.f511124a = r100.getContext();
        l.d().b(new c(this));
    }
}
