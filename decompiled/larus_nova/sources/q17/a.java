package q17;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.memory.heap.HeapDump;
import com.bytedance.memory.model.MemoryWidgetConfig;
import com.bytedance.memory.upload.MemoryUploadService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;
import r17.c;
import r17.g;
import s17.d;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile a f531298i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f531299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MemoryWidgetConfig f531300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f531301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f531302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C7268a f531303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f531304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f531305g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f531306h;

    /* JADX INFO: renamed from: q17.a$a, reason: collision with other inner class name */
    public class C7268a implements r17.a {
        public C7268a() {
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f531307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f531308b;

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            if (this.f531308b.f531300b.getRunStrategy() != 2) goto L22;
            d.f().getClass();
            if (d.a() == false) goto L22;
            y17.a r100 = y17.a.b();
            a r101 = this.f531308b;
            MemoryWidgetConfig r102 = r101.f531300b;
            C7268a r103 = r101.f531303e;
            if (r100.f565661a == false) goto L9;
            c.b("startCheck canAnalyse", new Object[0]);
            goto L22
        L9:
            r100.f565662b = false;
            r100.f565666f = r102;
            if (r100.f565665e == null) goto L22;
            c.b("enter startCheck", new Object[0]);
            r100.f565664d = r103;
            r103.getClass();
            if (a.e().d() == false) goto L14;
            int r104 = 1;
        L15:
            long r105 = r104 * 1000;
            f27.d r106 = r100.f565665e;
            y17.a.C8296a r107 = r100.f565667g;
            r106.getClass();
            if (r107 == null) goto L22;
            g27.c r110 = r106.b(r107);     // Catch: Throwable -> L20
            r110.e(r107);     // Catch: Throwable -> L20
            r110.h(r110.scheduleWithFixedDelay(r107, r105, r105, TimeUnit.MILLISECONDS), r107.hashCode(), true);     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            r106.a(th, "Apm-Async-task-removeTask");
            goto L22
        L14:
            r104 = 30;
        L22:
            a r108 = this.f531308b;
            r108.getClass();
            com.bytedance.memory.heap.a r109 = com.bytedance.memory.heap.a.b();
            x.a r111 = 0;
            if (r109.f265498c != null) goto L58;
            String r112 = r109.d().getString("filePath", "");
            if (TextUtils.isEmpty(r112) == true) goto L58;
            PolarisFileWrapper r113 = new PolarisFileWrapper(r112);
            if (r113.exists() == true) goto L30;
            r109.d().edit().putString("filePath", "").commit();
        L52:
            HeapDump r114 = null;
        L53:
            c.b("cache heapdump %s", new Object[]{r114});
            r109.f265498c = r114;
            goto L58
        L30:
            StringBuilder r115 = new StringBuilder();
            PolarisFileInputStreamWrapper r116 = new PolarisFileInputStreamWrapper(r113);     // Catch: Throwable -> L42 Exception -> L44
        L81:
            int r117 = r116.read();     // Catch: Exception -> L38 Throwable -> L40
            if (r117 == (-1)) goto L35;
            r115.append((char) r117);     // Catch: Exception -> L38 Throwable -> L40
            goto L81
        L35:
            JSONObject r118 = new JSONObject(r115.toString());     // Catch: Exception -> L38 Throwable -> L40
            r114 = com.bytedance.memory.heap.a.l(r118, new PolarisFileWrapper(r118.optString("heapDumpFilePath")));     // Catch: Exception -> L38 Throwable -> L40
            r109.f265498c = r114;     // Catch: Exception -> L38 Throwable -> L40
            r116.close();     // Catch: IOException -> L78
        L38:
            e = e;
        L47:
            if (r113.delete() == false) goto L49;
            c.a(e, "Could not read result file %s, deleted it.", new Object[]{r113});     // Catch: Throwable -> L40
        L50:
            if (r116 == null) goto L52;
            r116.close();     // Catch: IOException -> L77
            goto L52
        L49:
            c.a(e, "Could not read result file %s, could not delete it either.", new Object[]{r113});     // Catch: Throwable -> L40
            goto L50
        L40:
            th = th;
            r111 = "filePath";
        L54:
            if (r111 != 0) goto L85;
        L56:
            throw th;
        L85:
            r111.close();     // Catch: IOException -> L79
        L44:
            e = e;
            r116 = null;
        L42:
            th = th;
        L58:
            if (r108.f531300b.clientAnalyse() == false) goto L71;
            c.b("client analyze mode", new Object[0]);
            if (r108.f531302d == false) goto L62;
        L72:
            this.f531308b.f531305g = false;
            c.b("MemoryApi stopService isApmMemoryUploadProcess=" + this.f531307a, new Object[0]);
            if (this.f531307a == true) goto L75;
            return;
        L75:
            int r119 = MemoryUploadService.f265503a;
            throw null;
        L62:
            if (s17.c.b().c() == false) goto L72;
            Context r120 = r108.f531299a;     // Catch: Throwable -> L69
            Class r121 = a.a();     // Catch: Throwable -> L69
            if (r121 == null) goto L67;
            r120.getPackageManager().setComponentEnabledSetting(new ComponentName(r120, r121), 1, 1);     // Catch: Throwable -> L69
        L67:
            Intent r122 = new Intent(r108.f531299a, a.a());     // Catch: Throwable -> L69
            r122.putExtra("hprofFilePath", s17.c.b().f540159a.getAbsolutePath());     // Catch: Throwable -> L69
            r122.putExtra("debug", r108.f531300b.isDebug());     // Catch: Throwable -> L69
            r108.f531299a.startService(r122);     // Catch: Throwable -> L69
            r108.f531301c = System.currentTimeMillis();     // Catch: Throwable -> L69
            c.b("start Service success", new Object[0]);     // Catch: Throwable -> L69
            r108.f531302d = true;     // Catch: Throwable -> L69
        L69:
            th = move-exception;
            c.b("start Service failed", new Object[0]);
            r108.f531300b.setClientAnalyse(false);
            th.printStackTrace();
            goto L72
        L71:
            c.b("upload mode", new Object[0]);
            com.bytedance.memory.upload.c.e();
            goto L72
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r100, boolean r101) {
            this.f531308b = r100;
            this.f531307a = r101;
        }
    }

    public final boolean d() {
        MemoryWidgetConfig r100 = this.f531300b;     // Catch: Exception -> L16
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.isDebug() == false) goto L25;
        if ((this.f531299a.getApplicationInfo().flags & 2) == 0) goto L13;
        boolean r101 = true;
    L14:
        if (r101 == false) goto L26;
        return true;
    L26:
        return false;
    L13:
        r101 = false;
        goto L14
    L25:
        return false;
    L16:
        e = move-exception;
        c.b(Log.getStackTraceString(e), new Object[0]);
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.apm.momory.analyzer.AnalyzerService");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.apm.momory.analyzer.AnalyzerService");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.apm.momory.analyzer.AnalyzerService");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.apm.momory.analyzer.AnalyzerService");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.apm.momory.analyzer.AnalyzerService");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.apm.momory.analyzer.AnalyzerService");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.apm.momory.analyzer.AnalyzerService");
    }

    public static a e() {
        if (f531298i != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f531298i != null) goto L9;
        f531298i = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f531298i;
    }

    public final MemoryWidgetConfig f() {
        g.a(this.f531300b, "MemoryWidgetConfig mustn't be null");
        return this.f531300b;
    }

    public Context getContext() {
        g.a(this.f531299a, "You must call init() first before using !!!");
        return this.f531299a;
    }

    public a() {
        this.f531301c = 0;
        this.f531303e = new C7268a();
    }

    public final void g(boolean r100) {
        if (this.f531305g == false) goto L5;
        return;
    L5:
        c.b("MemoryApi start", new Object[0]);
        this.f531305g = true;
        if (this.f531304f == false) goto L10;
        r17.b.f535670b.a(new b(this, r100), "MemoryApi-start");
        return;
    L10:
        throw new IllegalStateException("You must call init() first before using !!!");
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Context r100, q17.b r110, IntentFilter r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r111, 2);
        return;
    L38:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L22;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r111, 2, null, null, 3, r100).result;     // Catch: Exception -> L33
        if (r101 == 1) goto L19;
        if (r101 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r101 == 3) goto L40;
        r100.registerReceiver(r110, r111, 2);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L19:
        r100.registerReceiver(r110, r111, 2);     // Catch: Exception -> L33
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r110, r111, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r110, r111, 2);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r111) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r110, r111, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void c(Context r100, q17.b r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r102 == 3) goto L40;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
