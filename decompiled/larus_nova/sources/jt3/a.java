package jt3;

import android.text.TextUtils;
import com.bytedance.apm.constant.UploadTypeInf;
import java.util.Set;
import kt3.b;
import nu3.c;
import org.json.JSONObject;
import xu3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f500287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile kt3.a f500288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f500289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final yu3.a<c> f500290d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f500291e;

    /* JADX INFO: renamed from: jt3.a$a, reason: collision with other inner class name */
    public static class C6484a implements yu3.a.InterfaceC8387a<c> {
        public C6484a() {
        }
    }

    static {
        yu3.a<c> r100 = new yu3.a(1000);
        f500290d = r100;
        f500291e = true;
        r100.f569221c = new C6484a();
    }

    public static synchronized void a() {
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f500289c == true) goto L9;
        b r100 = (b) qu3.c.a(b.class);     // Catch: Throwable -> L11
        if (r100 == null) goto L9;
        h(r100.getConfig());     // Catch: Throwable -> L11
        f500289c = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);
    }

    public static void c(lt3.b r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (f500288b != null) goto L11;
        f500290d.c(r100);
        if (xu3.a.a() == false) goto L9;
        av3.b.a("APM-CommonEvent", "Cached CommonLog: " + r100);
    L9:
        a();
        return;
    L11:
        kt3.a r101 = f500288b;
        String r102 = r100.f510666a;
        Set<String> r103 = r101.f506045b;
        if (r103 != null) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L23;
        r100.f510667b = d.h(r100.f510667b);
        if (xu3.a.a() == false) goto L21;
        av3.b.a("APM-CommonEvent", "Sampled CommonLog:" + r100);
    L21:
        nu3.b.a(r100);
        return;
    L23:
        if (xu3.a.a() == false) goto L27;
        r100.f510667b = d.h(r100.f510667b);
        ls3.a.a(r100.f510666a, r100.a(), false);
        av3.b.a("APM-CommonEvent", "UnSampled CommonLog:" + r100);
        return;
    L27:
        return;
    L14:
        if (r103.contains(r102) == false) goto L16;
        r104 = true;
        goto L17
    }

    public static void d(lt3.a r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (f500288b != null) goto L11;
        f500290d.c(r100);
        if (xu3.a.a() == false) goto L9;
        av3.b.a("APM-CommonEvent", "cached CommonEvent:" + r100);
    L9:
        a();
        return;
    L11:
        kt3.a r101 = f500288b;
        String r102 = r100.f510660a;
        Set<String> r103 = r101.f506044a;
        if (r103 != null) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L22;
        r100.b();
        nu3.b.a(r100);
        if (xu3.a.a() == false) goto L28;
        av3.b.a("APM-CommonEvent", "Sampled CommonEvent:" + r100);
        return;
    L28:
        return;
    L22:
        if (xu3.a.a() == false) goto L25;
        av3.b.a("APM-CommonEvent", "UnSampled CommonEvent:" + r100);
    L25:
        if (xu3.a.a() == false) goto L30;
        r100.b();
        ls3.a.a(UploadTypeInf.SERVICE_MONITOR, r100.a(), false);
        return;
    L30:
        return;
    L14:
        if (r103.contains(r102) == false) goto L16;
        r104 = true;
        goto L17
    }

    public static void f(lt3.d r100) {
        if (xu3.a.a() == false) goto L5;
        av3.b.a("APM-CommonEvent", "trace_data:" + r100.a());
    L5:
        nu3.b.a(r100);
    }

    public static synchronized void h(kt3.a r100) {
        monitor-enter(a.class);
        if (r100 != null) goto L28;
    L26:
        monitor-exit(a.class);
        return;
    L28:
    L23:
        th = move-exception;
        throw th;
    L6:
        if (f500288b == r100) goto L26;
        if (xu3.a.a() == false) goto L11;
        av3.b.a("APM-CommonEvent", "updateConfig " + r100);     // Catch: Throwable -> L23
    L11:
        f500288b = r100;     // Catch: Throwable -> L23
    L12:
        yu3.a<c> r101 = f500290d;     // Catch: Throwable -> L23
        if (r101.a() == true) goto L21;
        c r102 = r101.b();     // Catch: Throwable -> L23
        if ((r102 instanceof lt3.a) == true) goto L16;
        if ((r102 instanceof lt3.b) == false) goto L12;
        c((lt3.b) r102);     // Catch: Throwable -> L23
        goto L12
    L16:
        d((lt3.a) r102);     // Catch: Throwable -> L23
        goto L12
    L21:
        monitor-exit(a.class);
    }

    public static void b(String r100, JSONObject r101) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        c(new lt3.b(r100, r101));
        return;
    L5:
        if (xu3.a.a() == false) goto L10;
        av3.b.a("APM-CommonEvent", "logType must be not empty");
        return;
    }

    public static boolean g(String r100, Boolean r101) {
        if (f500287a == true) goto L5;
        return false;
    L5:
        if (f500288b != null) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return false;
    L10:
        if (r101.booleanValue() == false) goto L19;
        Set<String> r102 = f500288b.f506044a;
        if (r102 != null) goto L14;
    L16:
        boolean r103 = false;
    L17:
        if (r103 == true) goto L32;
    L26:
        return true;
    L32:
        return false;
    L14:
        if (r102.contains(r100) == false) goto L16;
        r103 = true;
        goto L17
    L19:
        Set<String> r104 = f500288b.f506045b;
        if (r104 != null) goto L22;
    L24:
        boolean r105 = false;
    L25:
        if (r105 == false) goto L26;
        return false;
    L22:
        if (r104.contains(r100) == false) goto L24;
        r105 = true;
        goto L25
    }

    public static void e(String r100, int r101, JSONObject r110, JSONObject r111, JSONObject r112) {
        d(new lt3.a(r100, r101, null, r110, r111, r112));
    }
}
