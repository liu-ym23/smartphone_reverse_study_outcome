package com.bytedance.lynx.webview.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Trace;
import android.text.TextUtils;
import android.util.SparseArray;
import android.webkit.WebViewFactoryProvider;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.locallife.cube.bridge.POINativeModule;
import com.bytedance.lynx.webview.IntegrityChecker;
import com.bytedance.lynx.webview.bean.LoadInfo;
import com.bytedance.lynx.webview.bean.LoadType;
import com.bytedance.lynx.webview.bean.PrepareInfo;
import com.bytedance.lynx.webview.glue.TTWebProviderWrapper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class LibraryLoader {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final HashSet<String> f265128o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final f17.a f265129p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final AtomicReference<Boolean> f265130q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final AtomicReference<Boolean> f265131r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final AtomicBoolean f265132s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final AtomicBoolean f265133t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final AtomicBoolean f265134u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final AtomicBoolean f265135v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f265136w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static String f265137x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MappedByteBuffer f265138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RandomAccessFile f265139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FileChannel f265140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FileLock f265141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FileChannel f265142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f265143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PthreadHandlerThreadV2 f265144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WebViewFactoryProvider f265145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TTWebProviderWrapper f265146i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f265147j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f265148k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile i17.b f265149l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ClassLoader f265150m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SharedPreferences f265151n;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LibraryLoader f265152a;

        public final void a() {
            r.d("[PreInit] Start ttwebview kernel pre init.");
            if (TTWebContext.h().f265223i.get() == false) goto L5;
            l17.k.d(new String[]{"PreInitTask scheduled after first webview created"});
            EventStatistics.e(EventType.LOAD_PRELOAD_FAILED, null);
        L5:
            LibraryLoader r100 = this.f265152a;
            ClassLoader r101 = r100.f265150m;
            Trace.beginSection("LibraryLoader.doPreInit.loadClass");     // Catch: Throwable -> L13 Exception -> L15
            boolean r102 = i0.f265323a;     // Catch: Throwable -> L13 Exception -> L15
            i0.f265329g = System.currentTimeMillis();     // Catch: Throwable -> L13 Exception -> L15
            if (r100.f265149l.preloadClasses() == true) goto L17;
            Iterator<String> r103 = LibraryLoader.f265128o.iterator();     // Catch: Throwable -> L13 Exception -> L15
        L10:
            if (r103.hasNext() == false) goto L17;
            LibraryLoader.c(r101, r103.next());     // Catch: Throwable -> L13 Exception -> L15
        L17:
            LibraryLoader.v();
            boolean r104 = i0.f265323a;
            EventStatistics.e(EventType.DO_PRE_INIT_TIME, Long.valueOf(System.currentTimeMillis() - i0.f265329g));
            Trace.endSection();
            Context r105 = TTWebContext.h().getContext();
            this.f265152a.getClass();
            Setting r106 = Setting.c();
            String r107 = l17.n.b(r105);
            int r108 = ProcessFeatureIndex.ENABLE_WARMUP_RENDER_PROCESS.value();
            r106.getClass();
            if (Setting.f(r107, r108, false) == false) goto L21;
            TTWebContext.w(new k(), ((long) Setting.c().d("sdk_warmup_render_process_delay_second", 10)) * 1000);
        L21:
            this.f265152a.i(r105, false);
            this.f265152a.getClass();
            TTWebContext.w(new j(r105), 2000);
            return;
        L13:
            th = move-exception;
            LibraryLoader.v();
            boolean r109 = i0.f265323a;
            EventStatistics.e(EventType.DO_PRE_INIT_TIME, Long.valueOf(System.currentTimeMillis() - i0.f265329g));
            Trace.endSection();
            throw th;
        L15:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L13
            l17.k.b(new String[]{"doPreInit error:" + e.toString()});     // Catch: Throwable -> L13
            goto L17
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

        public a(LibraryLoader r100) {
            this.f265152a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c0 f265153a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f265153a.o("0620010001", "", "Any");     // Catch: Throwable -> L4
            l17.g.d(null);     // Catch: Throwable -> L4
            TTWebContext.h().p().k(false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(c0 r100) {
            this.f265153a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LibraryLoader f265154a;

        public final void a() {
            l17.k.d(new String[]{"TT_WEBVIEW", "doStartWebEngine startWebEngineOnUiThread"});
            Trace.beginSection("LibraryLoader.doStartWebEngine");
            this.f265154a.f("com.bytedance.webview.chromium.WebViewChromiumFactoryProviderWrapper", true).getMethod("startWebEngineOnUiThread", new Class[0]).invoke(this.f265154a.f265145h, new Object[0]);     // Catch: Throwable -> L5 Exception -> L7
        L4:
            Trace.endSection();
            return;
        L5:
            th = move-exception;
            Trace.endSection();
            throw th;
        L7:
            e = move-exception;
            l17.k.b(new String[]{"TT_WEBVIEW", "doStartWebEngine error:" + e.toString()});     // Catch: Throwable -> L5
            e.printStackTrace();     // Catch: Throwable -> L5
            goto L4
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

        public c(LibraryLoader r100) {
            this.f265154a = r100;
        }
    }

    public interface d {
    }

    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LoadEventType f265155a;

        public e(LoadEventType r100) {
            this.f265155a = r100;
        }
    }

    public final boolean C() {
        int r100 = 0;
    L4:
        if (r100 >= 200) goto L18;
        FileLock r101 = this.f265140c.lock(0, 1, true);     // Catch: IOException -> L9
        this.f265141d = r101;     // Catch: IOException -> L9
        if (r101 != null) goto L7;
    L20:
        Thread.sleep(10);     // Catch: InterruptedException -> L15
    L17:
        r100 = r100 + 1;
    L15:
        e = move-exception;
        r.c("[Load] waitForContentLock sleep Failed!", e);
        goto L17
    L7:
        return true;
    L9:
        e = move-exception;
        if (r100 != 0) goto L20;
        r.c("[Load] waitForContentLock lock Failed!", e);
        goto L20
    L18:
        r.b("[Load] waitForContentLock TimeOut!");
        return false;
    }

    public final synchronized TTWebProviderWrapper m() {
        monitor-enter(this);
        TTWebProviderWrapper r100 = this.f265146i;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean z() {
        monitor-enter(this);
        this.f265145h = null;     // Catch: Throwable -> L8 Exception -> L10
        v();     // Catch: Throwable -> L8 Exception -> L10
        monitor-exit(this);     // Catch: Throwable -> L8
        return true;
    L10:
        e = move-exception;
        r.c("[Load] setStatusToSystem error: ", e);     // Catch: Throwable -> L8
        return false;
    L8:
        th = move-exception;
        throw th;
    }

    static {
        new AnonymousClass1();
        f265128o = new AnonymousClass2();
        f265129p = new f17.a();
        Boolean r100 = Boolean.FALSE;
        f265130q = new AtomicReference(r100);
        f265131r = new AtomicReference(r100);
        f265132s = new AtomicBoolean(false);
        f265133t = new AtomicBoolean(false);
        f265134u = new AtomicBoolean();
        f265135v = new AtomicBoolean(false);
        f265136w = true;
        f265137x = "";
    }

    public static boolean e() {
        if (f265130q.get().booleanValue() == false) goto L8;
        c0 r100 = TTWebContext.h().p();
        r100.getClass();
        if (r100.f265273b.getBoolean(r100.f265272a + "crashUptoLimit", false) == false) goto L8;
        TTWebContext.z(new b(r100));
        r.b("[Load] CrashTime upto limits, use system WebView");
        TTWebContext.j().f265229b = -113;
        com.bytedance.lynx.webview.a.d(EventType.LOAD_CRASH_FALLBACK);
        return true;
    L8:
        return false;
    }

    public static void v() {
        l17.k.d(new String[]{"preInitFinish"});
        TTWebContext r100 = TTWebContext.h();
        if (r100.f265220f == null) goto L6;
        TTWebContext.f265204p.post(new s0(r100));
        return;
    }

    public static void w() {
        if (f265129p.f() == true) goto L5;
        return;
    L5:
        if (TTWebContext.t() == false) goto L25;
        f265132s.compareAndSet(false, true);
        TTWebProviderWrapper r100 = TTWebContext.h().f265216b.m();
        if (r100 == null) goto L16;
        l17.k.d(new String[]{"LibraryLoader", "ttwebview prepared, start to hot reload."});
        c0 r101 = TTWebContext.h().p();
        monitor-enter(r101);
        r.d("[Load] resetAllLoadInfoFor Builtin");     // Catch: Throwable -> L13
        r101.f265275d = null;     // Catch: Throwable -> L13
        r101.f265274c = null;     // Catch: Throwable -> L13
        monitor-exit(r101);
        r100.ensureFactoryProviderCreated(true);
    L13:
        th = move-exception;
        throw th;
    L16:
        LibraryLoader r102 = TTWebContext.h().f265216b;
        i17.b r103 = r102.f265149l;
        WebViewFactoryProvider r104 = r102.f265146i.getSystemProvider();
        if (r103 != null) goto L19;
        return;
    L19:
        if (r103.setSysClassLoader(r104.getClass().getClassLoader()) == true) goto L27;
        l17.k.d(new String[]{"Builtin setSysClassLoader Failed!"});
        return;
    L27:
        return;
    }

    public final void s() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(l17.m.a());     // Catch: Exception -> L21
        if (r100.exists() == true) goto L8;
        r100.mkdirs();     // Catch: Exception -> L21
    L8:
        if (this.f265139b != null) goto L15;
        PolarisFileWrapper r101 = new PolarisFileWrapper(l17.m.a() + "com.bytedance.webview.chromium.shm.lock");     // Catch: Exception -> L21
        StringBuilder r102 = new StringBuilder("[Load] initializeShm ShareMemoryFile ");     // Catch: Exception -> L21
        if (r101.exists() == false) goto L12;
        String r103 = "";
    L13:
        r102.append(r103);     // Catch: Exception -> L21
        r102.append(POINativeModule.RESP_EXIST);     // Catch: Exception -> L21
        r.d(r102.toString());     // Catch: Exception -> L21
        this.f265139b = new RandomAccessFile(r101, "rw");     // Catch: Exception -> L21
        goto L15
    L12:
        r103 = "not ";
    L15:
        if (this.f265138a != null) goto L18;
        FileChannel r104 = this.f265139b.getChannel();     // Catch: Exception -> L21
        this.f265140c = r104;     // Catch: Exception -> L21
        MappedByteBuffer r105 = r104.map(FileChannel.MapMode.READ_WRITE, 0, 1024);     // Catch: Exception -> L21
        this.f265138a = r105;     // Catch: Exception -> L21
        r105.load();     // Catch: Exception -> L21
    L18:
        if (this.f265142e != null) goto L26;
        this.f265142e = new RandomAccessFile(new PolarisFileWrapper(l17.m.a() + "com.bytedance.webview.chromium.shm.lock.ensure"), "rw").getChannel();     // Catch: Exception -> L21
        return;
    L26:
        return;
    L21:
        e = move-exception;
        r.c("initializeShm Failed! ", e);
    }

    public final String y() {
        byte[] r100 = new byte[1024];     // Catch: Exception -> L11
        int r101 = 0;
    L4:
        if (r101 >= 1024) goto L9;
        byte r102 = this.f265138a.get(r101);     // Catch: Exception -> L11
        if (r102 == 0) goto L9;
        r100[r101] = r102;     // Catch: Exception -> L11
        r101 = r101 + 1;     // Catch: Exception -> L11
    L9:
        return new String(r100, 0, r101);
    L11:
        e = move-exception;
        l17.k.b(new String[]{"read shm error:" + e.toString()});
        return null;
    }

    public LibraryLoader() {
        this.f265145h = null;
        this.f265146i = null;
        this.f265148k = "";
        this.f265149l = null;
        this.f265150m = null;
        this.f265151n = null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static void h(String r100) {
        if (f265135v.compareAndSet(false, true) == false) goto L28;
        TTWebContext r101 = TTWebContext.h();
        TTWebContext.j().b();
        Context r102 = r101.getContext();
        c0 r103 = TTWebContext.h().p();
    L17:
        th = move-exception;
        l17.k.b(new String[]{"preloadProvider:" + th.toString()});
        th.toString();
        r103.p(EventType.LOAD_CRASHED);
    L19:
        boolean r104 = false;
    L21:
        if (r104 == true) goto L31;
        l17.k.d(new String[]{"LibraryLoader", "dex preload error!"});
        TTWebContext.j().d(3);
        EventStatistics.e(EventType.LOAD_PRELOAD_ERROR, null);
    L27:
        f265135v.set(false);
        return;
    L31:
        new PolarisFileWrapper(l17.m.c(r100)).createNewFile();     // Catch: Throwable -> L24
        EventStatistics.e(EventType.LOAD_PRELOAD_SUCCESS, null);     // Catch: Throwable -> L24
        l17.k.d(new String[]{"LibraryLoader", "dex preload success!"});     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        l17.k.b(new String[]{"Create compile finish file error :" + th.toString()});
        TTWebContext.j().d(3);
        EventStatistics.e(EventType.LOAD_PRELOAD_ERROR, null);
        goto L27
    L6:
        if (new PolarisFileWrapper(l17.m.d(r100)).exists() == false) goto L19;
        int r105 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L17
        if (r105 >= 26) goto L12;
        new DexClassLoader(l17.m.d(r100), l17.m.l(r100), null, r102.getClassLoader());     // Catch: Throwable -> L17
    L16:
        r104 = true;
        goto L21
    L12:
        if (r105 >= 30) goto L16;
        if (DexFile.loadDex(l17.m.d(r100), l17.m.l(r100) + "classes.dex", 0) == null) goto L19;
    L28:
        l17.k.d(new String[]{"someone doing dex compile at same time!"});
    }

    public static void j(Context r100) {
        int r101 = 0;
        if (Setting.c().b("sdk_isolate_ttwebview_resources_enabled", false) == false) goto L27;
        l17.k.b(new String[]{"LibraryLoader", "Add TTWebView resources to WebViewContextWrapper only."});
        return;
    L27:
        AssetManager r102 = r100.getResources().getAssets();     // Catch: Exception -> L13
        SparseArray r103 = (SparseArray) AssetManager.class.getMethod("getAssignedPackageIdentifiers", new Class[0]).invoke(r102, new Object[0]);     // Catch: Exception -> L13
    L8:
        if (r101 >= r103.size()) goto L15;
        if (r103.valueAt(r101).toString().equals("com.bytedance.webview") == true) goto L11;
        r101 = r101 + 1;
        goto L8
    L11:
        return;
    L15:
        String r104 = l17.m.j(f265129p.f475075b);
        if (new PolarisFileWrapper(r104).exists() == true) goto L18;
        l17.k.b(new String[]{"LibraryLoader", "No ttwebview resource for app."});
        return;
    L18:
        if (l17.f.a(r100, r104) == true) goto L22;
        l17.k.b(new String[]{"LibraryLoader", "add resource error!"});
        return;
    L22:
        if (l17.f.a(r100.getApplicationContext(), r104) == true) goto L31;
        l17.k.b(new String[]{"LibraryLoader", "add resource error!"});
        return;
    L31:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static Object k(Object r100) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field r101 = r100.getClass().getDeclaredField("dexElements");
        r101.setAccessible(true);
        return r101.get(r100);
    }

    public static Object l(BaseDexClassLoader r100) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field r101 = BaseDexClassLoader.class.getDeclaredField("pathList");
        r101.setAccessible(true);
        return r101.get(r100);
    }

    public static boolean t(LoadInfo r100) {
        e r101 = new e(LoadEventType.Default_Type);
        boolean r102 = false;
        if (l17.f.d() == true) goto L5;
        TTWebContext.h().p().p(EventType.DISABLED_BY_ABI);
        r.b("[Load] LoadPreCheck failed!!! cpu_abi::" + Build.CPU_ABI);
        TTWebContext.j().f265229b = -5;
        com.bytedance.lynx.webview.a.d(EventType.LOAD_ABI_CHECK_FAILED);
    L53:
        l17.b.a(r101.f265155a);
        if (r102 == false) goto L56;
        String r103 = "success";
    L57:
        r.d("[Load] Before loading, check the current env. result:".concat(r103));
        return r102;
    L56:
        r103 = "failed";
        goto L57
    L5:
        r101.f265155a = LoadEventType.LoadPreCheck_abi_enbale;
        if (TTWebContext.b(l17.n.b(TTWebContext.h().f265215a)) == false) goto L11;
        r101.f265155a = LoadEventType.CheckSwitch_enable_ttwebview;
        c0 r104 = TTWebContext.h().p();
        r104.getClass();
        if (r104.f265273b.getBoolean(r104.f265272a + "enabled", true) == true) goto L12;
        r.b("[Load] TTWebView disable by sdk");
        TTWebContext.j().f265229b = -100;
        com.bytedance.lynx.webview.a.d(EventType.LOAD_SWITCH_FROM_PREF);
        goto L11
    L12:
        boolean r105 = true;
    L13:
        if (r105 == true) goto L15;
        StringBuilder r106 = new StringBuilder("[Load] LoadPreCheck failed!!! checkSwitch failed.");
        c0 r107 = TTWebContext.h().p();
        r107.getClass();
        r106.append(r107.f265273b.getString(r107.f265272a + "switch_disable_reason", "default"));
        r.b(r106.toString());
        TTWebContext.j().f265229b = -100;
        goto L53
    L15:
        r101.f265155a = LoadEventType.LoadPreCheck_switch_enable;
        if (r100.c(r101) == true) goto L18;
        r.b("[Load] LoadPreCheck failed!!! soVersion is unsuited." + r100.f475074a);
        TTWebContext.j().f265229b = 100;
        goto L53
    L18:
        r101.f265155a = LoadEventType.LoadPreCheck_soVersion_suited;
        if (r100.f475075b.isEmpty() == false) goto L21;
        r.b("[Load] LoadPreCheck failed!!! md5 is empty.");
        r101.f265155a = LoadEventType.LoadPreCheck_decompress_md5_empty;
        TTWebContext.j().f265229b = 102;
        com.bytedance.lynx.webview.a.d(EventType.LOAD_MD5_IS_EMPTY);
        goto L53
    L21:
        r101.f265155a = LoadEventType.LoadPreCheck_md5_not_empty;
        if (r100.a() == true) goto L27;
        r.b("[Load] LoadPreCheck failed!!! finish file not exits.");
        if (l17.n.d(TTWebContext.h().getContext()) == false) goto L26;
        EventStatistics.g(EventType.DOWNLOAD_RESULT, null, false);
    L26:
        TTWebContext.j().f265229b = 103;
        com.bytedance.lynx.webview.a.d(EventType.LOAD_PREPARE_NOT_FINISHED);
        goto L53
    L27:
        r101.f265155a = LoadEventType.LoadPreCheck_so_exits;
        if (TTWebContext.g().equals(TTWebContext.h().p().f265273b.getString("supportHostAbi", BDLocationException.ERROR_CONNECT_GOOGLE_FAIL)) == true) goto L30;
        r.b("[Load] LoadPreCheck failed!!! hostAbi is disable! setHostAbi:" + TTWebContext.g() + " supportHostAbi:" + TTWebContext.h().p().f265273b.getString("supportHostAbi", BDLocationException.ERROR_CONNECT_GOOGLE_FAIL));
        TTWebContext.j().f265229b = -102;
        com.bytedance.lynx.webview.a.d(EventType.LOAD_ABI_NOT_SUPPORT);
        goto L53
    L30:
        r101.f265155a = LoadEventType.LoadPreCheck_hostabi_enable;
        if (r100.b() == true) goto L35;
        r.b("[Load] LoadPreCheck failed!!! Dex Compiled finish file not exits!");
        TTWebContext.j().f265229b = 105;
        com.bytedance.lynx.webview.a.d(EventType.LOAD_DEX_COMPILE_UNFINISHED);
        if (l17.n.d(TTWebContext.h().getContext()) == false) goto L53;
        EventStatistics.g(EventType.DOWNLOAD_RESULT, null, true);
        goto L53
    L35:
        r101.f265155a = LoadEventType.LoadPreCheck_dex_compiled;
        if (r100.d() > 99) goto L38;
    L40:
        boolean r108 = true;
    L41:
        if (r108 == true) goto L43;
        r.b("[Load] LoadPreCheck failed!!! Kernel version above 99 But disable TTWebClassLoader.");
        TTWebContext.j().f265229b = 106;
        com.bytedance.lynx.webview.a.d(EventType.LOAD_RS_NO_CLASSLOADER);
        goto L53
    L43:
        r101.f265155a = LoadEventType.LoadPreCheck_rs_kernel;
        if (r100.d() <= 62) goto L46;
        boolean r109 = true;
    L47:
        if (r109 == true) goto L49;
        r.b("[Load] LoadPreCheck failed!!! kernel version 62 is not supported by refactor SDK.");
        TTWebContext.j().f265229b = 107;
        com.bytedance.lynx.webview.a.d(EventType.LOAD_CHECK_62_UNSUPPORTED);
        goto L53
    L49:
        r101.f265155a = LoadEventType.LoadPreCheck_not_support_core;
        if (IntegrityChecker.a(r100.f475075b) == true) goto L52;
        r.b("[Load] LoadPreCheck failed!!! TTWebView integrity check failed.");
        TTWebContext.j().f265229b = 108;
        com.bytedance.lynx.webview.a.d(EventType.LOAD_INTEGRITY_CHECK_FAILED);
        goto L53
    L52:
        r101.f265155a = LoadEventType.LoadPreCheck_integrity_check;
        r102 = true;
        goto L53
    L46:
        r109 = false;
        goto L47
    L38:
        if (Setting.c().b("sdk_enable_use_ttweb_classloader", false) == true) goto L40;
        r108 = false;
    L11:
        r105 = false;
        goto L13
    }

    public static void x(PrepareInfo r100) {
        l17.k.d(new String[]{"LibraryLoader", "onPreloadFinish", r100.f475075b});
        if (r100.a() == true) goto L7;
        l17.k.d(new String[]{"LibraryLoader", "onPreloadFinish but no finish file"});
        return;
    L7:
        if (r100.b() == true) goto L10;
        l17.k.d(new String[]{"LibraryLoader", "onPreloadFinish but dex not compiled"});
        return;
    }

    public final void A(Context r110) {
        r.d("[Load] startRendererProcess");
        Bundle r100 = i0.f265324b;     // Catch: Throwable -> L32
        monitor-enter(r100);     // Catch: Throwable -> L32
        r100.putLong("tick_render_start_render_process_start", System.currentTimeMillis());     // Catch: Throwable -> L36
        monitor-exit(r100);     // Catch: Throwable -> L36
        x.b(new TTWebProviderWrapper(true));     // Catch: Throwable -> L32
        i0.i();     // Catch: Throwable -> L32
        s();     // Catch: Throwable -> L32
        if (C() == false) goto L34;
        String r101 = y();     // Catch: Throwable -> L32
        r.d("[Load] Read type from shm: " + r101);     // Catch: Throwable -> L32
        String[] r102 = r101.split("-", 3);     // Catch: Throwable -> L32
        if (r102.length != 3) goto L19;
        LoadType r103 = LoadType.getLoadTypeByValue(r102[0]);     // Catch: Throwable -> L32
        String r104 = r102[1];     // Catch: Throwable -> L32
        String r105 = r102[2];     // Catch: Throwable -> L32
        f17.a r106 = f265129p;     // Catch: Throwable -> L32
        monitor-enter(r106);     // Catch: Throwable -> L32
        r106.f475074a = r104;     // Catch: Throwable -> L16
        r106.f475075b = r105;     // Catch: Throwable -> L16
        r106.f475073c = r103;     // Catch: Throwable -> L16
        monitor-exit(r106);     // Catch: Throwable -> L32
    L20:
        String r107 = f265129p.f475075b;     // Catch: Throwable -> L32
        i0.j();     // Catch: Throwable -> L32
        this.f265150m = r110.getClassLoader();     // Catch: Throwable -> L32
        if (d(new String[]{l17.m.j(r107), l17.m.d(r107)}, l17.m.l(r107), r110) == true) goto L23;
        r.b("[Load] startRendererProcess addClassesToClassLoader error.");     // Catch: Throwable -> L32
        EventStatistics.e(EventType.RENDERER_PROCESS_HOOK_ERROR, null);     // Catch: Throwable -> L32
    L23:
        String r108 = l17.m.b(r107);     // Catch: Throwable -> L32
        String r109 = r110.getClassLoader().toString();     // Catch: Throwable -> L32
        if (r109.contains(r107) == true) goto L31;
        boolean r111 = new PolarisFileWrapper(r108).exists();     // Catch: Throwable -> L32
        boolean r112 = new PolarisFileWrapper(l17.m.d(r107)).exists();     // Catch: Throwable -> L32
        if (r111 == false) goto L30;
        if (r112 == false) goto L30;
        r.b("[Load] The classloader inject directory exists ALL, what's wrong?");     // Catch: Throwable -> L32
    L30:
        r.b("[Load] The classloader inject directory exists " + r111 + " dex file exists " + r112);     // Catch: Throwable -> L32
    L31:
        r.d("[Load] The classloader that has been injected into classes.dex: (" + r110.getClassLoader().hashCode() + ")" + r109);     // Catch: Throwable -> L32
        this.f265148k = r108;     // Catch: Throwable -> L32
        i0.l();     // Catch: Throwable -> L32
        this.f265149l = new i17.b();     // Catch: Throwable -> L32
        i0.k();     // Catch: Throwable -> L32
        this.f265149l.loadLibrary(r108);     // Catch: Throwable -> L32
        i0.h();     // Catch: Throwable -> L32
        Setting.c().getClass();     // Catch: Throwable -> L32
        Setting.a();     // Catch: Throwable -> L32
        i0.n();     // Catch: Throwable -> L32
        r.d("[Load] startRenderProcess finish.");     // Catch: Throwable -> L32
    L48:
        a("org.chromium.content.app.SandboxedProcessService0");     // Catch: ClassNotFoundException -> L42
        b0.a().f265270a.storeInt("count_renderer_unable_to_start", 0);     // Catch: ClassNotFoundException -> L42
        return;
    L50:
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L19:
        l17.k.b(new String[]{"LibraryLoader", "Parse shm string error."});     // Catch: Throwable -> L32
        goto L20
    L34:
        r.b("[Load] startRendererProcess get md5 failed.");     // Catch: Throwable -> L32
        EventStatistics.e(EventType.RENDERER_PROCESS_HOOK_ERROR, null);     // Catch: Throwable -> L32
        return;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        r.c("startRendererProcess error:", th);
        EventStatistics.e(EventType.RENDERER_PROCESS_HOOK_ERROR, null);
        goto L48
    }

    public final void D(String r100) {
        this.f265139b.setLength(1024);     // Catch: Exception -> L10
        byte[] r101 = r100.getBytes(Charset.defaultCharset());     // Catch: Exception -> L10
        int r102 = 0;
    L5:
        if (r102 >= Math.min(r101.length, 1024)) goto L7;
        this.f265138a.put(r102, r101[r102]);     // Catch: Exception -> L10
        r102 = r102 + 1;     // Catch: Exception -> L10
    L7:
        if (r102 >= 1024) goto L17;
        this.f265138a.put(r102, (byte) 0);     // Catch: Exception -> L10
        r102 = r102 + 1;
        goto L7
    L17:
        return;
    L10:
        e = move-exception;
        l17.k.b(new String[]{"write shm error: ", e.toString()});
    }

    public final boolean g(LoadInfo r110) {
        l17.b.a(LoadEventType.DoCreateHookProvider_begin);
        String r100 = TTWebContext.i();     // Catch: Throwable -> L12
        if (r100.isEmpty() == true) goto L15;
        l17.k.d(new String[]{"tt_webview", "Create data path with suffix : ".concat(r100)});     // Catch: Throwable -> L12
        String r101 = TTWebContext.h().getContext().getDir(r100, 0).getPath();     // Catch: Throwable -> L12
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101 + "/data/");     // Catch: Throwable -> L12
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101 + "/database/");     // Catch: Throwable -> L12
        if (r102.exists() == true) goto L9;
        r102.mkdirs();     // Catch: Throwable -> L12
    L9:
        if (r103.exists() == true) goto L15;
        r103.mkdirs();     // Catch: Throwable -> L12
    L15:
        if (Setting.c().b("sdk_enable_upload_v8_plugin_status", false) == false) goto L37;
        int r104 = TTWebContext.h().p().f265273b.getInt("start_time_by_version", 0);
        PolarisFileWrapper r105 = new PolarisFileWrapper(l17.m.f() + "/plugins/com.tt.appbrand.appbrandso/");
        if (r105.exists() == true) goto L19;
    L28:
        boolean r106 = false;
    L29:
        if (r106 == false) goto L33;
        if (r104 > 2) goto L32;
        String r107 = "0";
    L36:
        EventStatistics.e(EventType.V8_PLUGIN_STATUS, r107);
        goto L37
    L32:
        r107 = "1";
        goto L36
    L33:
        if (r104 > 2) goto L35;
        r107 = "2";
        goto L36
    L35:
        r107 = "3";
        goto L36
    L19:
        if (r105.isDirectory() == false) goto L28;
        String[] r108 = r105.list();
        if (r108 == null) goto L28;
        int r109 = r108.length;
        int r111 = 0;
    L23:
        if (r111 >= r109) goto L28;
        if (new PolarisFileWrapper(r105.getAbsolutePath() + HTTP.URL_DEFAULT + r108[r111] + "/lib/libv8_libfull.cr.so").exists() == true) goto L26;
        r111 = r111 + 1;
        goto L23
    L26:
        r106 = true;
    L37:
        monitor-enter(this);
        this.f265148k = l17.m.b(r110.f475075b);     // Catch: Throwable -> L46
        c0 r112 = TTWebContext.h().p();     // Catch: Throwable -> L46
        WebViewFactoryProvider r113 = q(r110);     // Catch: Throwable -> L46
        this.f265145h = r113;     // Catch: Throwable -> L46
        if (r113 != null) goto L42;
        monitor-exit(this);     // Catch: Throwable -> L46
        return false;
    L42:
        r112.p(EventType.LOAD_END);     // Catch: Throwable -> L46
        monitor-exit(this);     // Catch: Throwable -> L46
        l17.b.a(LoadEventType.DoCreateHookProvider_initProvider_success);
        l17.k.d(new String[]{"mTTProvider construct complete."});
        Setting.c().getClass();
        Setting.a();
        TTWebContext.A(new a(this));
        return true;
    L46:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        r.c("[Load] Failed to create data suffix path!!!", th);
        goto L15
    }

    public final boolean n(boolean r100) {
        FileLock r101 = this.f265140c.tryLock(0, 1, r100);     // Catch: IOException -> L6
        this.f265141d = r101;     // Catch: IOException -> L6
        if (r101 != null) goto L12;
        return false;
    L12:
        return true;
    L6:
        e = move-exception;
        r.c("[Load] getShmContentLock failed !! " + r100, e);
        return false;
    }

    public final boolean o(LoadInfo r110) {
        if (r110.e() == false) goto L39;
        l17.k.d(new String[]{"call TTWebContext startImpl tryLoadTTWebView => doCrossProcessInitialization => getTypeCrossProcess end"});
        return true;
    L39:
        l17.k.d(new String[]{"call TTWebContext startImpl tryLoadTTWebView => doCrossProcessInitialization => getTypeCrossProcess begin"});     // Catch: Throwable -> L33
        s();     // Catch: Throwable -> L33
        FileLock r100 = this.f265142e.tryLock(0, 1, false);     // Catch: IOException -> L10 Throwable -> L33
    L13:
        if (r100 != null) goto L15;
        r.b("[Load] getEnsure Lock Failed!");     // Catch: Throwable -> L33
    L23:
        boolean r101 = false;
    L24:
        if (r101 == false) goto L26;
    L35:
        l17.k.d(new String[]{"call TTWebContext startImpl tryLoadTTWebView => doCrossProcessInitialization => getTypeCrossProcess end"});
        return true;
    L26:
        if (C() == true) goto L28;
        return false;
    L28:
        f265131r.set(Boolean.TRUE);     // Catch: Throwable -> L33
        String r102 = y();     // Catch: Throwable -> L33
        r.d("[Load] Read type from shm: " + r102);     // Catch: Throwable -> L33
        String[] r103 = r102.split("-", 3);     // Catch: Throwable -> L33
        if (r103.length != 3) goto L31;
        LoadType.getLoadTypeByValue(r103[0]);     // Catch: Throwable -> L33
        String r104 = r103[1];     // Catch: Throwable -> L33
        String r105 = r103[2];     // Catch: Throwable -> L33
        r110.f475074a = r104;     // Catch: Throwable -> L33
        r110.f475075b = r105;     // Catch: Throwable -> L33
        f265137x = r105;     // Catch: Throwable -> L33
        goto L35
    L31:
        l17.k.b(new String[]{"LibraryLoader", "Parse shm string error."});     // Catch: Throwable -> L33
        goto L35
    L15:
        if (n(false) == false) goto L21;
        f265130q.set(Boolean.TRUE);     // Catch: Throwable -> L33
        String r106 = "" + LoadType.TTWEBVIEW.getName() + '-' + r110.f475074a + '-' + r110.f475075b;     // Catch: Throwable -> L33
        f265137x = r110.f475075b;     // Catch: Throwable -> L33
        D(r106);     // Catch: Throwable -> L33
        r.d("[Load] getTypeCrossProcess Set webview type to shm: " + r106);     // Catch: Throwable -> L33
        this.f265141d.release();     // Catch: Throwable -> L33
        if (n(true) == true) goto L20;
        r.b("[Load] getShmContentLock Failed ! return false! ");     // Catch: Throwable -> L33
        r100.release();     // Catch: Throwable -> L33
        return false;
    L20:
        r100.release();     // Catch: Throwable -> L33
        r101 = true;
        goto L24
    L21:
        r100.release();     // Catch: Throwable -> L33
    L10:
        e = move-exception;
        r.c("[Load] getEnsureLock Failed! ", e);     // Catch: Throwable -> L33
        r100 = null;
    L33:
        th = move-exception;
        r.c("[Load] getTypeCrossProcess faild !", th);
        r110.f475074a = "0620010001";
        r110.f475075b = "";
        goto L35
    }

    public final WebViewFactoryProvider q(LoadInfo r110) {
        c0 r100 = TTWebContext.h().p();
        Context r101 = TTWebContext.h().getContext();
        String r102 = r110.f475075b;
        Bundle r103 = i0.f265324b;     // Catch: Throwable -> L32
        monitor-enter(r103);     // Catch: Throwable -> L32
        r103.putLong("tick_init_ttwebview_classloader_start", System.currentTimeMillis());     // Catch: Throwable -> L34
        monitor-exit(r103);     // Catch: Throwable -> L34
        int r104 = r110.d();     // Catch: Throwable -> L32
        String r105 = l17.m.l(r102);     // Catch: Throwable -> L32
        if (r104 <= 99) goto L10;
        this.f265150m = new z0(r105, r101.getClassLoader());     // Catch: Throwable -> L32
        Object[] r106 = new Object[1];     // Catch: Throwable -> L32
        u(new String[]{l17.m.d(r102)}, r105, r101, r106);     // Catch: Throwable -> L32
        Object r107 = l((BaseDexClassLoader) this.f265150m);     // Catch: Throwable -> L32
        Field r108 = r107.getClass().getDeclaredField("dexElements");     // Catch: Throwable -> L32
        r108.setAccessible(true);     // Catch: Throwable -> L32
        r108.set(r107, r106[0]);     // Catch: Throwable -> L32
        l17.m.b(r102);     // Catch: Throwable -> L32
    L14:
        l17.b.a(LoadEventType.InitProvider_addClasses_success);     // Catch: Throwable -> L32
        long r109 = System.currentTimeMillis();     // Catch: Throwable -> L32
        i0.b();     // Catch: Throwable -> L32
        this.f265149l = new i17.b();     // Catch: Throwable -> L32
        i0.a();     // Catch: Throwable -> L32
        i17.b r111 = this.f265149l;     // Catch: Throwable -> L32
        String r112 = k17.a.f501380a;     // Catch: Throwable -> L32
        if (r111.CheckSdkVersion(r112) == true) goto L19;
        EventStatistics.e(EventType.SDK_LOAD_ERRO_SdkCheck, "");     // Catch: Throwable -> L32
        TTWebContext.j().f265229b = 100;     // Catch: Throwable -> L32
        com.bytedance.lynx.webview.a.d(EventType.LOAD_CHECK_SDK_FAILED);     // Catch: Throwable -> L32
        r.b("[Load] mSdkToGlue.CheckSdkVersion Failed! version:" + r112);     // Catch: Throwable -> L32
        return null;
    L19:
        if (this.f265149l.CheckGlueVersion(r110.f475074a) == true) goto L23;
        EventStatistics.e(EventType.SDK_LOAD_ERRO_GlueCheck, "");     // Catch: Throwable -> L32
        TTWebContext.j().f265229b = -103;     // Catch: Throwable -> L32
        com.bytedance.lynx.webview.a.d(EventType.LOAD_CHECK_GLUE_FAILED);     // Catch: Throwable -> L32
        r.b("[Load] mSdkToGlue.CheckGlueVersion Failed! sVersion:" + r110.f475074a);     // Catch: Throwable -> L32
        return null;
    L23:
        if (this.f265149l.checkSoRuntimeEnvironment(r101) == true) goto L27;
        EventStatistics.e(EventType.SDK_LOAD_ERRO_RuntimeEnvironment, "");     // Catch: Throwable -> L32
        TTWebContext.j().f265229b = -105;     // Catch: Throwable -> L32
        com.bytedance.lynx.webview.a.d(EventType.LOAD_CHECK_RUNTIME_FAILED);     // Catch: Throwable -> L32
        r.b("[Load] mSdkToGlue.checkSoRuntimeEnvironment Failed!");     // Catch: Throwable -> L32
        return null;
    L27:
        if (this.f265149l.isSupportAndroidX() == true) goto L30;
        EventStatistics.e(EventType.SDK_LOAD_ERRO_SupportAndroidX, "");     // Catch: Throwable -> L32
        TTWebContext.j().f265229b = -104;     // Catch: Throwable -> L32
        com.bytedance.lynx.webview.a.d(EventType.LOAD_CHECK_ANDROIDX_FAILED);     // Catch: Throwable -> L32
        r.b("[Load] mSdkToGlue.isSupportAndroidX Failed!");     // Catch: Throwable -> L32
        return null;
    L30:
        l17.b.a(LoadEventType.InitProvider_checkGlueVersion_success);     // Catch: Throwable -> L32
        i0.c();     // Catch: Throwable -> L32
        WebViewFactoryProvider r113 = this.f265149l.getProviderInstance(l17.m.b(r102));     // Catch: Throwable -> L32
        r.d("[Load] InitAndGet FactoryProvider success. duration:" + (System.currentTimeMillis() - r109));     // Catch: Throwable -> L32
        return r113;
    L10:
        this.f265150m = r101.getClassLoader();     // Catch: Throwable -> L32
        if (d(new String[]{l17.m.j(r102), l17.m.d(r102)}, r105, r101) == true) goto L14;
        EventStatistics.e(EventType.SDK_LOAD_ERRO_Dexpath, "");     // Catch: Throwable -> L32
        com.bytedance.lynx.webview.a.d(EventType.LOAD_ADD_CLASSLOADER_FAILED);     // Catch: Throwable -> L32
        return null;
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        r.c("[Load] initProvider err.", th);
        com.bytedance.lynx.webview.a.d(EventType.LOAD_INIT_PROVIDER_EXCEPTION);
        th.toString();
        r100.p(EventType.LOAD_CRASHED);
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static void c(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.loadClass(r101);
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    public final void B(LoadInfo r110, TTWebContext.f r111) {
        String r100 = r110.f475075b;
        boolean r101 = false;
        if (TextUtils.isEmpty(r100) == true) goto L9;
        Context r102 = TTWebContext.h().getContext();
        if (this.f265151n != null) goto L8;
        this.f265151n = r102.getSharedPreferences("CrossProcessesMd5", 0);
    L8:
        this.f265151n.edit().putString(l17.n.b(r102), r100).commit();
    L9:
        r.d("[Load-tmp] LibraryLoader doCrossProcessInitialization loadmd5 " + r110.f475075b + " version " + r110.f475074a);
        l17.b.a(LoadEventType.DoCrossProcessInitialization_begin);
        long r103 = System.currentTimeMillis();
        boolean r104 = true;
        Bundle r105 = i0.f265324b;     // Catch: Throwable -> L53
        monitor-enter(r105);     // Catch: Throwable -> L53
        r105.putLong("tick_load_precheck_start", System.currentTimeMillis());     // Catch: Throwable -> L55
        monitor-exit(r105);     // Catch: Throwable -> L55
    L15:
        if (r110.e() == false) goto L18;
        com.bytedance.lynx.webview.a.d(EventType.LOAD_NO_SO_INFO);     // Catch: Throwable -> L53
    L43:
        if (r104 == false) goto L45;
        f265129p.i();
        TTWebContext.j().f265229b = 200;
    L45:
        f17.a r112 = f265129p;
        if (r112.f() == true) goto L48;
    L52:
        r112.h();
        TTWebContext.z(new i(r111, r104));
        EventStatistics.e(EventType.LOAD_TRACE_EVENT_CALLBACK, Long.valueOf(System.currentTimeMillis() - r103));
        l17.k.d(new String[]{"call TTWebContext startImpl tryLoadTTWebView => doCrossProcessInitialization End"});
        return;
    L48:
        if (z() == true) goto L52;
        throw new RuntimeException("Create system provider error.");
    L18:
        if (t(r110) == false) goto L43;
        EventStatistics.e(EventType.LOAD_TRACE_EVENT_CREATE_PROVIDER, Long.valueOf(System.currentTimeMillis() - r103));     // Catch: Throwable -> L53
        i0.d();     // Catch: Throwable -> L53
        String r106 = r110.f475075b;     // Catch: Throwable -> L53
        if (o(r110) == false) goto L23;
        EventStatistics.e(EventType.LOAD_TRACE_EVENT_SYNC_PROCESS, Long.valueOf(System.currentTimeMillis() - i0.f265328f));     // Catch: Throwable -> L53
    L24:
        r103 = System.currentTimeMillis();     // Catch: Throwable -> L53
        f17.a r107 = f265129p;     // Catch: Throwable -> L53
        r107.j(r110);     // Catch: Throwable -> L53
        if ((!r110.e()) == false) goto L43;
        if (r107.g() == false) goto L43;
        l17.b.a(LoadEventType.DoCrossProcessInitialization_load_ttwebview);     // Catch: Throwable -> L53
        if (r106.equals(r110.f475075b) == true) goto L31;
        boolean r108 = true;
    L32:
        i0.g();     // Catch: Throwable -> L53
        if (e() == true) goto L39;
        if (r108 == false) goto L38;
        if (r110.c(new e(LoadEventType.Default_Type)) == false) goto L39;
    L38:
        if (g(r110) == false) goto L39;
    L40:
        if (r101 == false) goto L42;
        EventStatistics.e(EventType.LOAD_SYNC_SO_VERSION_ERROR, r110.f475074a + ':' + r107.f475074a);     // Catch: Throwable -> L53
    L42:
        r104 = r101;
    L39:
        r101 = true;
        goto L40
    L31:
        r108 = false;
        goto L32
    L23:
        l17.k.b(new String[]{"Sync process state failed."});     // Catch: Throwable -> L53
        EventStatistics.e(EventType.LOAD_ERROR_SYNC_PROCESS, null);     // Catch: Throwable -> L53
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        r.c("[Load] doCrossProcessInitialization error:", th);     // Catch: Throwable -> L68
        f17.a r113 = f265129p;
        r113.i();
        TTWebContext.j().f265229b = 200;
        if (r113.f() == true) goto L62;
    L66:
        r113.h();
        TTWebContext.z(new i(r111, true));
        EventStatistics.e(EventType.LOAD_TRACE_EVENT_CALLBACK, Long.valueOf(System.currentTimeMillis() - r103));
        l17.k.d(new String[]{"call TTWebContext startImpl tryLoadTTWebView => doCrossProcessInitialization End"});
        return;
    L62:
        if (z() == true) goto L66;
        throw new RuntimeException("Create system provider error.");
    L68:
        th = move-exception;
        f17.a r109 = f265129p;
        r109.i();
        TTWebContext.j().f265229b = 200;
        if (r109.f() == true) goto L72;
    L76:
        r109.h();
        TTWebContext.z(new i(r111, true));
        EventStatistics.e(EventType.LOAD_TRACE_EVENT_CALLBACK, Long.valueOf(System.currentTimeMillis() - r103));
        l17.k.d(new String[]{"call TTWebContext startImpl tryLoadTTWebView => doCrossProcessInitialization End"});
        throw th;
    L72:
        if (z() == true) goto L76;
        throw new RuntimeException("Create system provider error.");
    }

    public final Class<?> f(String r100, boolean r101) throws ClassNotFoundException {
        ClassLoader r102 = this.f265150m;
        if (f265129p.d() <= 104) goto L11;
        if (r100.startsWith("com.bytedance.org.chromium") == false) goto L8;
        return b(r100.replace("com.bytedance.org.chromium", "org.chromium"), r101, r102);
    L8:
        if (r100.startsWith("com.bytedance.webview.chromium") == false) goto L11;
        return b(r100.replace("com.bytedance.webview.chromium", "com.android.webview.chromium"), r101, r102);
    L11:
        return b(r100, r101, r102);
    }

    public final void i(Context r100, boolean r101) {
        Setting r102 = Setting.c();
        String r103 = l17.n.b(r100);
        int r104 = ProcessFeatureIndex.ENABLE_WARMUP.value();
        r102.getClass();
        if (Setting.f(r103, r104, false) == true) goto L6;
        if (r101 == true) goto L6;
        return;
    L6:
        c r105 = new c(this);
        int r106 = Setting.c().d("sdk_warmup_delay_second", 1);
        if (r101 == false) goto L9;
        r105.run();
        return;
    L9:
        TTWebContext.w(r105, ((long) r106) * 1000);
    }

    public final boolean p(TTWebContext.c r100, TTWebContext.d r110) {
        boolean r101 = true;
        boolean r102 = false;
        if (f265134u.getAndSet(true) == false) goto L5;
        r.b("[Load] hookProviderWrapper has been call more than once!");
        boolean r103 = false;
    L30:
        if (r102 == true) goto L36;
        EventStatistics.e(EventType.LOAD_HOOK_AFTER_SYSTEM, null);
        this.f265146i = null;
        if (f265136w == false) goto L36;
        throw new RuntimeException("Before calling all WebView interfaces, TTWebView must be initialized.");
    L36:
        return r103;
    L5:
        boolean r104 = i0.f265323a;
        i0.f265326d = System.currentTimeMillis();
        Bundle r105 = i0.f265324b;
        monitor-enter(r105);
        r105.putLong("tick_hook_provider_wrapper_start", i0.f265326d);     // Catch: Throwable -> L37
        monitor-exit(r105);     // Catch: Throwable -> L37
        TTWebProviderWrapper r106 = r(r100, r110);     // Catch: Throwable -> L26
        this.f265146i = r106;     // Catch: Throwable -> L26
        boolean r107 = x.c(r106);     // Catch: Throwable -> L26
        this.f265147j = r107;     // Catch: Throwable -> L24
        if (r107 == false) goto L22;
        l17.k.d(new String[]{"sProviderInstance set in first position success."});     // Catch: Throwable -> L24
        TTWebProviderWrapper r111 = this.f265146i;     // Catch: Throwable -> L24
        if (r111 != null) goto L16;
        r101 = false;
    L16:
        if (r111 != null) goto L43;
    L21:
        r102 = r101;
    L23:
        i0.f265327e = System.currentTimeMillis();
    L29:
        boolean r108 = r102;
        r102 = r107;
        r103 = r108;
        goto L30
    L43:
        r111.asyncTriggerEnsure();     // Catch: Throwable -> L19
    L19:
        Throwable th10 = th;
        r102 = r101;
    L28:
        EventStatistics.e(EventType.LOAD_UNASSIGNED, null);
        th10.toString();
        r.c("[Load] hookProviderWrapper failed.", th10);
        goto L29
    L22:
        TTWebContext.j().f265229b = -111;     // Catch: Throwable -> L24
        com.bytedance.lynx.webview.a.d(EventType.LOAD_HOOK_TOO_LATE);     // Catch: Throwable -> L24
        r.b("hook late check init time");     // Catch: Throwable -> L24
    L24:
        th10 = th;
    L26:
        th = move-exception;
        th10 = th;
        r107 = false;
    L37:
        th = move-exception;
        throw th;
    }

    public final TTWebProviderWrapper r(TTWebContext.c r100, TTWebContext.d r101) {
        l17.k.d(new String[]{"LibraryLoader initProviderWrapper"});
        if (TTWebContext.f265210v == false) goto L5;
    L6:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.f265144g != null) goto L13;
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2("library-loader-io", -1);     // Catch: Throwable -> L10
        this.f265144g = r102;     // Catch: Throwable -> L10
        ThreadMethodProxy.start(r102);     // Catch: Throwable -> L10
    L13:
        if (this.f265143f != null) goto L15;
        this.f265143f = new Handler(this.f265144g.getLooper());     // Catch: Throwable -> L10
    L15:
        monitor-exit(this);     // Catch: Throwable -> L10
    L17:
        return new TTWebProviderWrapper(this.f265143f, r100, r101, new l(this), new m());
    L5:
        if (TTWebContext.h().v() == false) goto L17;
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class b(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r105 = Class.forName(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r106 = Class.forName(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static boolean d(String[] r110, String r111, Context r112) {
        a("dalvik.system.BaseDexClassLoader");     // Catch: Throwable -> L33
        int r100 = r110.length;     // Catch: Throwable -> L30
        Object[] r101 = new Object[r100];     // Catch: Throwable -> L30
        int r113 = u(r110, r111, r112, r101);     // Catch: Throwable -> L30
        ClassLoader r114 = r112.getClassLoader();     // Catch: Throwable -> L30
        PathClassLoader r102 = null;
        Object r103 = null;
        int r104 = 0;
    L5:
        if (r114 == null) goto L12;
        if ((r114 instanceof PathClassLoader) == false) goto L11;
        r102 = (PathClassLoader) r114;     // Catch: Throwable -> L30
        r103 = k(l(r102));     // Catch: Throwable -> L30
        r104 = Array.getLength(r103);     // Catch: Throwable -> L30
        if (r104 > 0) goto L12;
    L11:
        r114 = r114.getParent();     // Catch: Throwable -> L30
    L12:
        r.d("[Load] Start add this path to AppClassloader(" + r114.hashCode() + "): " + r110[1]);     // Catch: Throwable -> L30
        if (r104 <= 0) goto L28;
        if (r102 == null) goto L28;
        Object r115 = Array.newInstance(Array.get(r103, 0).getClass(), r104 + r113);     // Catch: Throwable -> L30
        int r105 = 0;
        int r106 = 0;
    L17:
        if (r105 >= r100) goto L22;
        Object r107 = r101[r105];     // Catch: Throwable -> L30
        int r108 = Array.getLength(r107);     // Catch: Throwable -> L30
        int r109 = 0;
    L19:
        if (r109 >= r108) goto L21;
        Array.set(r115, r106, Array.get(r107, r109));     // Catch: Throwable -> L30
        r109 = r109 + 1;     // Catch: Throwable -> L30
        r106 = r106 + 1;     // Catch: Throwable -> L30
        goto L19
    L21:
        r105 = r105 + 1;     // Catch: Throwable -> L30
        goto L17
    L22:
        int r116 = 0;
    L24:
        if (r116 >= Array.getLength(r103)) goto L26;
        Array.set(r115, r113 + r116, Array.get(r103, r116));     // Catch: Throwable -> L30
        r116 = r116 + 1;     // Catch: Throwable -> L30
        goto L24
    L26:
        Object r117 = l(r102);     // Catch: Throwable -> L30
        Field r118 = r117.getClass().getDeclaredField("dexElements");     // Catch: Throwable -> L30
        r118.setAccessible(true);     // Catch: Throwable -> L30
        r118.set(r117, r115);     // Catch: Throwable -> L30
        return true;
    L28:
        r.b("[Load] addClassesToClassLoader can't find right classloader!");     // Catch: Throwable -> L30
        return false;
    L30:
        th = move-exception;
        th.printStackTrace();
        r.c("addClassesToClassLoader error. ", th);
        th.toString();
        return false;
    L33:
        r.b("Can't find BaseDexClassLoader");
        return false;
    }

    public static int u(String[] r110, String r111, Context r112, Object[] r113) throws NoSuchFieldException, IllegalAccessException {
        int r100 = 0;
        if (Build.VERSION.SDK_INT < 30) goto L11;
        int r114 = 0;
        int r101 = 0;
    L16:
    L9:
        e = move-exception;
        r.c("makeDexElements error:", e);
    L15:
        return r101;
    L6:
        if (r114 >= r110.length) goto L15;
        Constructor r102 = a("dalvik.system.DexPathList").getDeclaredConstructor(new Class[]{ClassLoader.class, String.class, String.class, File.class});     // Catch: Exception -> L9
        r102.setAccessible(true);     // Catch: Exception -> L9
        new PolarisFileWrapper(r110[r114]).setReadOnly();     // Catch: Exception -> L9
        Object r103 = k(r102.newInstance(new Object[]{r112.getClassLoader(), r110[r114], null, null}));     // Catch: Exception -> L9
        r113[r114] = r103;     // Catch: Exception -> L9
        r101 = r101 + Array.getLength(r103);
        r114 = r114 + 1;
        goto L16
    L11:
        r101 = 0;
    L13:
        if (r100 >= r110.length) goto L15;
        Object r104 = k(l(new DexClassLoader(r110[r100], r111, null, r112.getClassLoader())));
        r113[r100] = r104;
        r101 = r101 + Array.getLength(r104);
        r100 = r100 + 1;
        goto L13
    }
}
