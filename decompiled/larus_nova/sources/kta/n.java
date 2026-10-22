package kta;

import android.content.Context;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static n f506110b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f506111a;

    public final Map a() {
        long r100 = 100;
        if (jta.g.f() == true) goto L5;
        s r101 = s.b(this.f506111a);
        HashMap r102 = null;
        if (r101.f506127c == false) goto L28;
        r101.a();
        p r103 = r101.f506131g;
        if (r103 != null) goto L23;
        SystemClock.elapsedRealtime();
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        SystemClock.elapsedRealtime();
    L20:
        th = move-exception;
        SystemClock.elapsedRealtime();
        throw th;
    L13:
        if ((r101.f506125a instanceof i) == false) goto L15;
        r100 = 200;
    L15:
        p r104 = r101.f506130f.get(r100, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L17
        SystemClock.elapsedRealtime();
        r103 = r104;
    L23:
        if (r103 != null) goto L25;
        r103 = r101.f506131g;
    L25:
        if (r103 == null) goto L27;
        HashMap r105 = new HashMap();
        s.d(r105, "id", r103.f506115a);
        s.d(r105, "req_id", r103.f506116b);
        s.d(r105, "is_track_limited", String.valueOf(r103.f506117c));
        s.d(r105, "take_ms", String.valueOf(r103.f506118d));
        s.d(r105, "time", String.valueOf(r103.f506119e));
        s.d(r105, "query_times", String.valueOf(r103.f506120f));
        s.d(r105, "hw_id_version_code", String.valueOf(r103.f506121g));
        r102 = r105;
    L27:
        Objects.toString(r102);
    L28:
        return r102;
    L5:
        return e84.k.e(this.f506111a).b(100);
    }

    public final String b() {
        if (jta.g.f() == true) goto L5;
        s r100 = s.b(this.f506111a);
        r100.a();
        p r101 = r100.f506131g;
        if (r101 == null) goto L9;
        String r102 = r101.f506115a;
    L11:
        return r102;
    L9:
        r102 = null;
        goto L11
    L5:
        return e84.k.e(this.f506111a).c();
    }

    public n(Context r100) {
        this.f506111a = r100.getApplicationContext();
    }

    public static n c(Context r100) {
        if (f506110b != null) goto L15;
        monitor-enter(n.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f506110b != null) goto L9;
        f506110b = new n(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(n.class);     // Catch: Throwable -> L11
    L15:
        return f506110b;
    }
}
