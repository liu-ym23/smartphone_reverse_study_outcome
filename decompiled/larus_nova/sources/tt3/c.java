package tt3;

import android.content.SharedPreferences;
import android.os.Process;
import com.bytedance.apm6.cpu.CgroupFetcher;
import com.bytedance.monitor.collector.MonitorJni;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f547544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.apm6.cpu.collect.b f547545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.apm6.cpu.collect.a f547546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SharedPreferences f547547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public uu3.a f547548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bq7.a f547549f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f547550a = null;

        static {
            f547550a = new c();
        }
    }

    public final void a() {
        Map<String, ?> r100 = this.f547547d.getAll();
        if (r100 == null) goto L24;
        Iterator<Map.Entry<String, ?>> r101 = r100.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L42;
        Map.Entry<String, ?> r102 = r101.next();
        String r103 = r102.getKey();     // Catch: Throwable -> L23
        PolarisFileWrapper r104 = new PolarisFileWrapper("/proc/" + ((String) r102.getValue()).split(",")[0] + "/stat");     // Catch: Throwable -> L23
        String r105 = "";
        BufferedReader r106 = null;
        BufferedReader r107 = new BufferedReader(new PolarisFileReaderWrapper(r104.getPath()), 100);     // Catch: Throwable -> L25
        r105 = r107.readLine();     // Catch: Throwable -> L13
        r107.close();     // Catch: Throwable -> L23
    L17:
        if (r105.isEmpty() == true) goto L18;
        String r108 = r105.split(" ")[1];     // Catch: Throwable -> L23
        if (r103.endsWith(r108.substring(1, r108.length() - 1)) == true) goto L6;
        this.f547547d.edit().remove(r103).apply();     // Catch: Throwable -> L23
        goto L6
    L18:
        this.f547547d.edit().remove(r103).apply();     // Catch: Throwable -> L23
    L13:
        r106 = r107;
    L14:
        if (r106 == null) goto L17;
        r106.close();     // Catch: Throwable -> L23
        goto L17
    L42:
        return;
    }

    public final boolean b() {
        if (this.f547548e.isForeground() == false) goto L6;
        this.f547547d.edit().putString(du3.a.e(), Process.myPid() + "," + this.f547548e.isForeground()).apply();
        return true;
    L6:
        Map<String, ?> r100 = this.f547547d.getAll();
        if (r100 == null) goto L16;
        Iterator<Map.Entry<String, ?>> r101 = r100.entrySet().iterator();
    L10:
        if (r101.hasNext() == false) goto L16;
        if (((String) r101.next().getValue()).split(",")[1].equals("true") == false) goto L10;
        boolean r102 = true;
    L17:
        int r103 = CgroupFetcher.f190761a;
        com.bytedance.monitor.collector.c r104 = com.bytedance.monitor.collector.c.e();
        int r105 = CgroupFetcher.f190761a;
        r104.getClass();
        CgroupFetcher.CGROUP_LEVEL r106 = CgroupFetcher.CGROUP_LEVEL.valueOf(MonitorJni.getProcCGroup(r105));
        if (r102 == false) goto L20;
        return true;
    L20:
        if (this.f547548e.isForeground() == false) goto L22;
        return true;
    L22:
        if (r106 != CgroupFetcher.CGROUP_LEVEL.TOP_APP) goto L24;
        return true;
    L24:
        if (r106 == CgroupFetcher.CGROUP_LEVEL.FOREGROUND) goto L39;
        return false;
    L39:
        return true;
    L16:
        r102 = false;
        goto L17
    }

    public c() {
        this.f547544a = new AtomicBoolean(false);
        this.f547549f = aq7.b.a(com.bytedance.apm.d.getContext());     // Catch: Throwable -> L6
    L4:
        com.bytedance.apm6.cpu.collect.a r100 = new com.bytedance.apm6.cpu.collect.a(this.f547549f);
        this.f547546c = r100;
        this.f547545b = new com.bytedance.apm6.cpu.collect.b(r100, this.f547549f);
    }
}
