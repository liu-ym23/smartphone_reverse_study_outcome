package vh4;

import com.bytedance.crash.i;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.bytedance.crash.util.h;
import com.bytedance.crash.util.p;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends oh4.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f554957i = 819200;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f554958j = 512000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static a f554959k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static a f554960l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static c f554961m;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f554962h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f554963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f554964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f554965c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f554966d;

        public a() {
            this.f554963a = false;
            this.f554964b = true;
            this.f554965c = false;
            this.f554966d = 0;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class b extends oh4.b.AbstractC7056b {
        public b(com.bytedance.crash.monitor.a r100, PolarisFileWrapper r101) {
            super(r100, r101);
        }

        @Override // oh4.b.AbstractC7056b
        public final void h(Map<String, String> r100, oh4.b.c r101) {
            super.h(r100, r101);
            HashMap r102 = (HashMap) r100;
            String r103 = "true";
            r102.put("mmap_monitor", "true");
            r102.put("has_mmap_leak", "true");
            if (com.bytedance.crash.general.a.f() == true) goto L6;
            r103 = "false";
        L6:
            r102.put("is_root", r103);
            r102.put("mmap_leak_app", i.getContext().getPackageName());
        }

        @Override // oh4.b.AbstractC7056b
        public final boolean i(File r110, oh4.b.c r111) {
            PolarisFileWrapper r100 = new PolarisFileWrapper(r110, "tombstone.txt");
            PolarisFileWrapper r101 = new PolarisFileWrapper(r110, "javastack.txt");
            if (r100.exists() == true) goto L47;
            return false;
        L47:
        L43:
            return false;
        L6:
            if (r101.exists() == false) goto L8;
            r111.f523285a = h.d(r101.getAbsolutePath());     // Catch: Throwable -> L43
        L8:
            JSONArray r112 = h.f(r100.getAbsolutePath());     // Catch: Throwable -> L43
            if (r112 != null) goto L12;
            p.e("stack content is null");     // Catch: Throwable -> L43
            return false;
        L12:
            int r102 = oh4.b.AbstractC7056b.b(r112, 0, "pid:");     // Catch: Throwable -> L43
            if (r102 < 0) goto L21;
            String[] r103 = r112.optString(r102, null).trim().split("\\s");     // Catch: Throwable -> L43
            int r104 = 0;
        L16:
            if (r104 >= r103.length) goto L21;
            if ("name:".equals(r103[r104]) == true) goto L19;
            r104 = r104 + 1;     // Catch: Throwable -> L43
            goto L16
        L19:
            r111.f523287c = r103[r104 + 1];     // Catch: Throwable -> L43
        L21:
            StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L43
            int r106 = oh4.b.AbstractC7056b.b(r112, r102 + 1, "Signal ");     // Catch: Throwable -> L43
            if (r106 < 0) goto L24;
            r105.append(r112.optString(r106, null));     // Catch: Throwable -> L43
            r105.append('\n');     // Catch: Throwable -> L43
        L24:
            int r107 = oh4.b.AbstractC7056b.b(r112, r106 + 1, "Abort message:");     // Catch: Throwable -> L43
            if (r107 < 0) goto L33;
            String r108 = r112.optString(r107, null).replace("Abort message:", "abort message:");     // Catch: Throwable -> L43
            r111.f523288d = r108;     // Catch: Throwable -> L43
            r105.append(r108);     // Catch: Throwable -> L43
            r105.append('\n');     // Catch: Throwable -> L43
            if (r111.f523288d.startsWith("abort message:") == false) goto L33;
            Matcher r109 = PatternProtector.compile("^.*:\\s+(\\S+):.*,.*,.*:\\s+(\\S+)\\(.*:(\\S+)\\s+(\\S+)\\).*$").matcher(r111.f523288d);     // Catch: Throwable -> L44
            if (r109.find() == false) goto L33;
            Map<String, String> r113 = r111.f523292h;     // Catch: Throwable -> L44
            HashMap r114 = (HashMap) r113;     // Catch: Throwable -> L44
            r114.put("mmap_leak_lib", r109.group(1));     // Catch: Throwable -> L44
            Map<String, String> r115 = r111.f523292h;     // Catch: Throwable -> L44
            HashMap r116 = (HashMap) r115;     // Catch: Throwable -> L44
            r116.put("mmap_leak_reason", r109.group(2));     // Catch: Throwable -> L44
            Map<String, String> r117 = r111.f523292h;     // Catch: Throwable -> L44
            HashMap r118 = (HashMap) r117;     // Catch: Throwable -> L44
            r118.put("mmap_leak_size", oh4.b.AbstractC7056b.c(r109.group(3), r109.group(4)));     // Catch: Throwable -> L44
        L33:
            int r119 = oh4.b.AbstractC7056b.b(r112, r107 + 1, "backtrace:");     // Catch: Throwable -> L43
            if (r119 < 0) goto L42;
            int r120 = r119 + 1;     // Catch: Throwable -> L43
        L37:
            if (r120 >= r112.length()) goto L41;
            String r121 = r112.optString(r120, null);     // Catch: Throwable -> L43
            if (r121.startsWith("    #") == false) goto L41;
            r105.append(r121.trim());     // Catch: Throwable -> L43
            r105.append('\n');     // Catch: Throwable -> L43
            r120 = r120 + 1;     // Catch: Throwable -> L43
        L41:
            r111.f523286b = r105.toString();     // Catch: Throwable -> L43
        L42:
            return true;
        }
    }

    @Override // oh4.b
    public final void a() {
        f554959k = new a();
        f554960l = new a();
        if ((this.f554962h.f554971l & 1) == 0) goto L12;
        f554957i = Math.max(0, NativeResourceMonitor.i(7, 0));
        if (f(0) == false) goto L12;
        a r100 = f554959k;
        if (r100.f554965c == false) goto L10;
        p.a("VmMonitor: execute water line mode Already running");
        goto L12
    L10:
        r100.f554965c = true;
        r100.f554966d = 0;
        ThreadMethodProxy.start(new vh4.a(this));
    L12:
        if ((this.f554962h.f554971l & 2) == 0) goto L15;
        h(1);
        return;
    }

    public c() {
    }

    public static long e(boolean r100) {
        if (r100 == false) goto L13;
        int r101 = NativeResourceMonitor.i(8, 0);
        if (r101 >= 0) goto L9;
        a r102 = f554959k;
        if (r102 == null) goto L9;
        r102.f554966d = -1;
    L9:
        long r103 = Math.max(0, r101);
        if (r103 >= f554958j) goto L20;
        f554958j = r103;
    L20:
        return r103 - f554958j;
    L13:
        int r104 = NativeResourceMonitor.i(6, 0);
        if (r104 >= 0) goto L19;
        a r105 = f554959k;
        if (r105 == null) goto L19;
        r105.f554966d = -1;
    L19:
        return Math.max(0, r104);
    }

    public static boolean f(int r100) {
        if (r100 != 0) goto L4;
        a r101 = f554959k;
    L6:
        if (r101 == null) goto L15;
        int r102 = r101.f554966d;
        if (r102 == 4) goto L15;
        if (r102 == (-1)) goto L15;
        if (r102 == 5) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == true) goto L19;
        return false;
    L19:
        if (r101.f554963a == true) goto L35;
        if (r101.f554964b == false) goto L35;
        p.a("VmMonitor: start hook: " + r100);
        if (r100 != 0) goto L25;
        a r104 = f554959k;
    L27:
        if (r104.f554963a == true) goto L35;
        int r105 = NativeResourceMonitor.i(1, r100);
        if (r105 != 0) goto L32;
        boolean r106 = true;
    L33:
        r104.f554963a = r106;
        r104.f554964b = false;
        g(r100, 1, r105);
        goto L35
    L32:
        r106 = false;
        goto L33
    L25:
        r104 = f554960l;
    L35:
        return r101.f554963a;
    L15:
        r103 = false;
        goto L16
    L4:
        r101 = f554960l;
        goto L6
    }

    public static void h(int r100) {
        p.a("VmMonitor: start monitor native");
        if (f(r100) == true) goto L5;
        return;
    L5:
        g(r100, 3, NativeResourceMonitor.i(3, r100));
    }

    public static void g(int r100, int r101, int r102) {
        if (r102 == 0) goto L30;
        if (r100 != 0) goto L5;
        a r103 = f554959k;
    L6:
        r103.f554966d = -1;
        StringBuilder r104 = new StringBuilder("VmMonitor: ");
        if (r101 != 0) goto L9;
        String r105 = "recover";
    L28:
        r104.append(r105);
        r104.append(": ");
        r104.append(r102);
        p.a(r104.toString());
        return;
    L9:
        if (r101 != 1) goto L11;
        r105 = DownloadSettingKeys.KEY_HOOK;
        goto L28
    L11:
        if (r101 != 3) goto L13;
        r105 = "start_monitor";
        goto L28
    L13:
        if (r101 != 4) goto L15;
        r105 = "stop_monitor";
        goto L28
    L15:
        if (r101 != 5) goto L17;
        r105 = "dump";
        goto L28
    L17:
        if (r101 != 6) goto L19;
        r105 = "get_leak_size";
        goto L28
    L19:
        if (r101 == 7) goto L21;
        r105 = "unknown command";
        goto L28
    L21:
        r105 = "get_vm_size";
        goto L28
    L5:
        r103 = f554960l;
        goto L6
    }
}
