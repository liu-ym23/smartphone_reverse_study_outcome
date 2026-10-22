package s17;

import android.content.SharedPreferences;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.apm.util.g;
import com.bytedance.crash.Npth;
import com.bytedance.memory.heap.HeapDump;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import r17.e;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile d f540165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static c f540166e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f540167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f540168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences f540169c;

    /* JADX INFO: loaded from: classes21.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f540170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f540171b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f540171b.e(this.f540170a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(d r100, int r101) {
            this.f540171b = r100;
            this.f540170a = r101;
        }
    }

    public static boolean a() {
        if (TextUtils.isEmpty(q17.a.e().f531306h) == true) goto L7;
        long r100 = new StatFs(new PolarisFileWrapper(q17.a.e().f531306h).getPath()).getAvailableBytes();     // Catch: Throwable -> L30
    L33:
        if (com.bytedance.apm.util.b.f190642d == (-1)) goto L31;
    L15:
        long r101 = com.bytedance.apm.util.b.f190642d;     // Catch: Exception -> L25
        if (r100 > 0) goto L18;
    L23:
        x17.a.f562123j.c("StorageNotEnough");     // Catch: Exception -> L25
        return false;
    L18:
        if (r101 <= 0) goto L23;
        if (r100 <= (r101 * 0.2f)) goto L23;
        return true;
    L31:
        com.bytedance.apm.util.b.f190642d = Runtime.getRuntime().maxMemory();     // Catch: Exception -> L29
    L25:
        e = move-exception;
        x17.a.f562123j.c("checkStorage_error");
        e.printStackTrace();
        return false;
    L7:
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L10;
        r100 = new StatFs(g.c(com.bytedance.apm.d.getContext()).getPath()).getAvailableBytes();     // Catch: Throwable -> L30
        goto L33
    L37:
        r100 = 0;
    L10:
        r100 = 0;
        goto L33
    }

    public static d f() {
        if (f540165d != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f540165d != null) goto L9;
        f540165d = new d();     // Catch: Throwable -> L11
        f540166e = c.b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f540165d;
    }

    public d() {
        this.f540167a = System.currentTimeMillis();
        this.f540168b = 1;
        q17.a.e().getContext();
    }

    public final void b(int r110) {
        x17.a.f562123j.c("dumpAndSave_start");
        long r100 = System.nanoTime();
        PolarisFileWrapper r101 = f540166e.f540159a;
        if (r101 != null) goto L5;
        return;
    L5:
        File r102 = r101.getParentFile();
        if (r102.exists() == true) goto L8;
        r102.mkdirs();
    L8:
        long r103 = System.currentTimeMillis();
        t17.a.c("dump_begin");
        PolarisFileWrapper r104 = new PolarisFileWrapper(c.b().f540162d, "info.txt");
        JSONObject r105 = com.bytedance.apm.d.d();
        PolarisFileWriterWrapper r111 = new PolarisFileWriterWrapper(r104);     // Catch: Throwable -> L30
        r111.append(r105.optString("app_version"));     // Catch: Throwable -> L13
        r111.append("\n");     // Catch: Throwable -> L13
        r111.append(r105.optString("update_version_code"));     // Catch: Throwable -> L13
        r111.append("\n");     // Catch: Throwable -> L13
        r111.append(String.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L13
        r111.close();     // Catch: Throwable -> L30
        goto L21
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r111.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: Throwable -> L30
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L30
    L21:
        q17.a.e().f().getDumpAndShrinkConfig();
        x17.a r106 = x17.a.f562123j;
        r106.c("dump_begin");
        r106.c("origin_dump_start");
        if (r110 != 2) goto L24;
        r17.c.b("Native dump", new Object[0]);     // Catch: Exception -> L27
        Npth.dumpHprof(r101.getAbsolutePath());     // Catch: Exception -> L27
        r17.c.b("Native dump exist ? " + new PolarisFileWrapper(r101.getAbsolutePath()).exists(), new Object[0]);     // Catch: Exception -> L27
    L25:
        com.bytedance.memory.heap.a.b().i(com.bytedance.apm.d.f190519g.optString("update_version_code"));     // Catch: Exception -> L27
    L28:
        r106.c("origin_dump_end");
        com.bytedance.memory.heap.a.b().h(false);
        long r107 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - r100);
        HeapDump.b r112 = HeapDump.newBuilder();
        r112.getClass();
        r17.g.a(r101, "heapDumpFile");
        r112.f265486b = r101;
        r112.f265491g = 0;
        r112.f265494j = this.f540167a;
        r101.length();
        r112.f265485a = e.f535675a;
        r112.f265492h = r107;
        r17.g.a(r112.f265486b, "heapDumpFile");
        HeapDump r108 = new HeapDump(r112, null);
        r17.c.b(r108.toString(), new Object[0]);
        com.bytedance.memory.heap.a.b().e(r108);
        t17.a.c("dump_end");
        HashMap<String, Object> r109 = new HashMap();
        r109.put("oom_dump_cost", Integer.valueOf(this.f540168b));
        r106.b("dump_end", r109);
        t17.a.d("dump_time", System.currentTimeMillis() - r103);
        com.bytedance.memory.heap.a r113 = com.bytedance.memory.heap.a.b();
        r113.d().edit().putLong("lastDumpTime", System.currentTimeMillis()).commit();
        r106.c("dumpAndSave_end");
        return;
    L24:
        Debug.dumpHprofData(r101.getAbsolutePath());     // Catch: Exception -> L27
    L27:
        x17.a.f562123j.c("realDump_error");
        r101 = null;
        goto L28
    }

    public final void c(long r100) {
        int r101 = 2;
        if (q17.a.e().f().getRunStrategy() == 2) goto L6;
        r101 = 1;
    L6:
        d(r100, r101);
    }

    public final void e(int r100) {
        x17.a.f562123j.c("dumpHeapInner");
    L7:
        x17.a.f562123j.c("dumpHeapInner_error");
        return;
    L4:
        if (a() == false) goto L11;
        b(r100);     // Catch: Exception -> L7
        y17.a.b().a();     // Catch: Exception -> L7
        return;
    }

    public final void d(long r100, int r101) {
        x17.a.f562123j.c("dumpHeap");
        this.f540167a = r100;
        com.bytedance.memory.heap.a.b().d();
        if (q17.a.e().f().getRunStrategy() != 2) goto L5;
        r17.b.f535670b.a(new a(this, r101), "HeapDumper-dumpHeap");
        return;
    L5:
        e(r101);
    }
}
