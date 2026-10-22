package com.bytedance.lynx.webview.internal;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.camera.video.AudioStats;
import com.bytedance.lynx.webview.TTWebSdk;
import com.bytedance.lynx.webview.bean.LoadInfo;
import com.bytedance.lynx.webview.extension.TTWebViewExtension;
import com.bytedance.lynx.webview.glue.TTWebProviderWrapper;
import com.bytedance.lynx.webview.preparation.PrepareInfoNG;
import com.bytedance.lynx.webview.util.DeleteReason;
import com.bytedance.lynx.webview.util.broadcast.InfoReceiver;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class TTWebContext {
    public static TTWebSdk.LoadPolicy A;
    public static boolean B;
    public static String C;
    public static final AtomicBoolean D = null;
    public static int E;
    public static int F;
    public static String G;
    public static String H;
    public static boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static boolean f265201J;
    public static long K;
    public static boolean L;
    public static double M;
    public static boolean N;
    public static long O;
    public static final AtomicBoolean P = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AtomicInteger f265202n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static TTWebContext f265203o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static Handler f265204p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final AtomicBoolean f265205q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static String f265206r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f265207s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static com.bytedance.lynx.webview.internal.a f265208t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static String f265209u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f265210v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f265211w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f265212x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final KernelLoadListener f265213y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static TTWebSdk.QuickAppHandler f265214z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f265215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LibraryLoader f265216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile c0 f265217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile PthreadHandlerThreadV2 f265218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Handler f265219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TTWebSdk.h f265220f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TTAdblockContext f265221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f265222h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f265223i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f265224j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile String f265225k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f265226l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, List<TTWebSdk.j>> f265227m;

    public static class KernelLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TTWebSdk.LoadListener f265228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f265229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Type f265230c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f265231d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f265232e;

        public static final enum Type extends Enum<Type> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Type[] f265233a = null;
            public static final Type decompress = null;
            public static final Type dex2oat = null;
            public static final Type download = null;
            public static final Type normal = null;

            static {
                Type r100 = new Type("normal", 0);
                normal = r100;
                Type r101 = new Type("download", 1);
                download = r101;
                Type r102 = new Type("dex2oat", 2);
                dex2oat = r102;
                Type r103 = new Type("decompress", 3);
                decompress = r103;
                f265233a = new Type[]{r100, r101, r102, r103};
            }

            public static Type[] values() {
                return (Type[]) f265233a.clone();
            }

            public static Type valueOf(String r100) {
                return (Type) r27.a.a(Type.class, r100);
            }

            public Type(String r100, int r101) {
                super(r100, r101);
            }
        }

        public final void e() {
            TTWebContext.f265212x = false;
            this.f265230c = Type.normal;
            TTWebSdk.LoadListener r100 = this.f265228a;
            if (r100 == null) goto L10;
            com.bytedance.lynx.webview.internal.e.b(TTWebContext.h().getContext(), false);
            r100.onSuccess();     // Catch: Throwable -> L7
            this.f265228a = null;
            return;
        L7:
            th = move-exception;
            this.f265228a = null;
            throw th;
        }

        public final void a() {
            this.f265230c = Type.decompress;
            TTWebSdk.LoadListener r100 = this.f265228a;
            if (r100 == null) goto L6;
            r100.onDecompress();
            return;
        }

        public final void b() {
            this.f265230c = Type.dex2oat;
            TTWebSdk.LoadListener r100 = this.f265228a;
            if (r100 == null) goto L6;
            r100.onDex2Oat();
            return;
        }

        public KernelLoadListener() {
            this.f265228a = null;
            this.f265229b = 0;
            this.f265230c = Type.normal;
            this.f265231d = 0;
            this.f265232e = 0;
        }

        public final void d(int r100) {
            TTWebContext.f265212x = false;
            this.f265230c = Type.normal;
            TTWebSdk.LoadListener r101 = this.f265228a;
            if (r101 != null) goto L11;
            return;
        L11:
            r101.onFail(r100, TTWebSdk.FailMessage.getMessage(r100));     // Catch: Throwable -> L7
            this.f265228a = null;
            return;
        L7:
            th = move-exception;
            this.f265228a = null;
            throw th;
        }

        public final void f(TTWebSdk.LoadListener r100) {
            this.f265228a = r100;
            if (r100 != null) goto L5;
            return;
        L5:
            int r101 = a.f265234a[this.f265230c.ordinal()];
            if (r101 != 1) goto L8;
            r100.onDownloadProgress(this.f265231d, this.f265232e);
            return;
        L8:
            if (r101 != 2) goto L10;
            r100.onDex2Oat();
            return;
        L10:
            if (r101 != 3) goto L18;
            r100.onDecompress();
            return;
        }

        public final void c(long r100, long r101) {
            this.f265230c = Type.download;
            this.f265231d = r100;
            this.f265232e = r101;
            TTWebSdk.LoadListener r102 = this.f265228a;
            if (r102 == null) goto L6;
            r102.onDownloadProgress(r100, r101);
            return;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f265234a = null;

        static {
            int[] r100 = new int[KernelLoadListener.Type.values().length];
            f265234a = r100;
            r100[KernelLoadListener.Type.download.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f265234a[KernelLoadListener.Type.dex2oat.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f265234a[KernelLoadListener.Type.decompress.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f265235a;

        @Override // java.lang.Runnable
        public final void run() {
            TTWebContext.z(this.f265235a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(Runnable r100) {
            this.f265235a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TTWebContext f265236a;

        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        L18:
            return;
        L3:
            if (this.f265236a.f265216b.m() != null) goto L14;
            return;
        L14:
            Trace.beginSection("prepareBuiltin");     // Catch: Throwable -> L6
            this.f265236a.D();     // Catch: Throwable -> L6
            Trace.endSection();     // Catch: Throwable -> L9
            return;
        L6:
            th = move-exception;
            Trace.endSection();     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        }

        public c(TTWebContext r100) {
            this.f265236a = r100;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TTWebContext f265237a;

        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        L18:
            return;
        L3:
            if (Build.VERSION.SDK_INT < 26) goto L15;
            p.d();     // Catch: Throwable -> L10
        L15:
            Trace.beginSection("startImpl");     // Catch: Throwable -> L7
            this.f265237a.F();     // Catch: Throwable -> L7
            Trace.endSection();     // Catch: Throwable -> L10
            return;
        L7:
            th = move-exception;
            Trace.endSection();     // Catch: Throwable -> L10
            throw th;     // Catch: Throwable -> L10
        }

        public d(TTWebContext r100) {
            this.f265237a = r100;
        }
    }

    public class e implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            TTWebProviderWrapper r100 = TTWebContext.h().f265216b.m();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.ensureFactoryProviderCreated(false);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public e() {
        }
    }

    public class f implements LibraryLoader.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadInfo f265238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TTWebContext f265239b;

        public f(TTWebContext r100, LoadInfo r101) {
            this.f265239b = r100;
            this.f265238a = r101;
        }
    }

    public static class g implements TTWebSdk.QuickAppHandler {
        public g() {
        }
    }

    static {
        f265202n = new AtomicInteger(0);
        f265204p = null;
        f265205q = new AtomicBoolean(false);
        f265207s = false;
        f265208t = null;
        f265209u = null;
        f265210v = false;
        f265211w = 0;
        f265212x = false;
        f265213y = new KernelLoadListener();
        f265214z = new g();
        A = TTWebSdk.LoadPolicy.online_only;
        B = false;
        C = null;
        D = new AtomicBoolean(false);
        E = -1;
        F = -1;
        G = null;
        H = null;
        I = false;
        f265201J = true;
        K = -1;
        L = false;
        M = AudioStats.AUDIO_AMPLITUDE_NONE;
        N = false;
        O = -1;
        P = new AtomicBoolean(true);
    }

    public static boolean d() {
        if (L == true) goto L5;
        return false;
    L5:
        long r100 = System.currentTimeMillis();
        c0 r101 = h().p();
        long r102 = r101.f265273b.getLong("webview_last_used_time", 0);
        if (r102 != 0) goto L8;
        r102 = System.currentTimeMillis();
        r101.f265273b.edit().putLong("webview_last_used_time", r102).apply();
    L8:
        int r103 = Setting.c().d("sdk_auto_clear_threshold", 7);
        int r104 = Setting.c().d("sdk_auto_clear_sensitive_threshold", r103);
        double r105 = M;
        int r106 = l17.f.f507006a;
        if ((Environment.getDataDirectory().getFreeSpace() / Environment.getDataDirectory().getTotalSpace()) >= r105) goto L11;
        boolean r107 = true;
    L12:
        long r108 = r100 - r102;
        if (r107 == false) goto L18;
        if (r108 <= ((((((long) r104) * 24) * 60) * 60) * 1000)) goto L21;
    L19:
        return true;
    L21:
        return false;
    L18:
        if (r108 > ((((((long) r103) * 24) * 60) * 60) * 1000)) goto L19;
        return false;
    L11:
        r107 = false;
        goto L12
    }

    public static com.bytedance.lynx.webview.internal.a e() {
        monitor-enter(TTWebContext.class);
        com.bytedance.lynx.webview.internal.a r100 = f265208t;     // Catch: Throwable -> L7
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean f() {
        return f265205q.get();
    }

    public static String g() {
        String r100 = C;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Before initttwebview, must set hostabi !");
    }

    public static TTWebContext h() {
        TTWebContext r100 = f265203o;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("must call initialize first!");
    }

    public static String i() {
        String r100 = f265206r;
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.isEmpty() == false) goto L8;
        return "";
    L8:
        return "ttwebview_bytedance_" + f265206r;
    }

    public static KernelLoadListener j() {
        monitor-enter(TTWebContext.class);
        KernelLoadListener r100 = f265213y;     // Catch: Throwable -> L7
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static TTWebSdk.QuickAppHandler o() {
        monitor-enter(TTWebContext.class);
        TTWebSdk.QuickAppHandler r100 = f265214z;     // Catch: Throwable -> L7
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean r() {
        return LibraryLoader.f265129p.g();
    }

    public static boolean t() {
        if (A != TTWebSdk.LoadPolicy.builtin_and_online) goto L5;
    L8:
        return true;
    L5:
        if (A == TTWebSdk.LoadPolicy.builtin_only) goto L8;
        return false;
    }

    public final void D() {
        l17.k.d(new String[]{"TTWebContext prepareBuiltin check."});
        if (v() == false) goto L8;
        this.f265216b.f265146i.getSystemProvider();
        Setting r100 = Setting.c();
        r100.getClass();
        l17.k.d(new String[]{"Setting initBuiltin begin"});
        String r101 = l17.g.e().toString();
        if (TextUtils.isEmpty(r101) == true) goto L7;
        l17.k.d(new String[]{"Setting initBuiltin begin setSettingListener"});
        r100.o(null);
        com.bytedance.lynx.webview.internal.g.e().g(r101);
        return;
    L7:
        l17.k.b(new String[]{"Setting initBuiltin null local setting."});
        return;
    L8:
        e r102 = new e();
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L13
        h().q().post(r102);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void F() {
        r.d("[Load] Start ttwebview loading");
        if (D.compareAndSet(false, true) == false) goto L5;
    L11:
        Bundle r100 = i0.f265324b;
        monitor-enter(r100);
        r100.putLong("tick_start_impl_start", System.currentTimeMillis());     // Catch: Throwable -> L46
        monitor-exit(r100);     // Catch: Throwable -> L46
        long r101 = System.currentTimeMillis();
        L = Setting.c().b("sdk_enable_auto_clear", false);
        N = Setting.c().b("sdk_actively_delete_ttwebview", false);
        Setting r102 = Setting.c();
        if (r102.f265171b != null) goto L49;
    L25:
        double r103 = 0.2d;
    L26:
        M = r103;
        boolean r104 = b(l17.n.b(this.f265215a));
        StringBuffer r105 = l17.b.f506991a;
        C(new l17.a());
        l17.b.a(LoadEventType.StartImpl_begin);
        if (r104 == true) goto L30;
        p().p(EventType.DISABLED_BY_SWITCH);
    L30:
        if ((System.currentTimeMillis() - p().e()) <= 86400000) goto L33;
        p().l(true, null);
        p().f265273b.edit().putBoolean("sys_adblock_enabled", true).apply();
    L33:
        if (b0.a().f265270a.getInt("count_renderer_unable_to_start", 0) <= 3) goto L35;
        r.d("Call setRenderProcessStatus: false");
        com.bytedance.lynx.webview.internal.g.e().f265306d = 0;
    L35:
        LoadInfo r106 = p().h(l17.n.d(this.f265215a));
        l17.k.a(new String[]{"call TTWebContext startImpl tryLoadTTWebView " + r106.f475075b + " begin"});
        this.f265216b.B(r106, new f(this, r106));
        long r107 = System.currentTimeMillis() - r101;
        EventStatistics.e(EventType.LOAD_TRACE_EVENT_START_IMPL, Long.valueOf(r107));
        if (this.f265216b.f265147j == false) goto L38;
        EventStatistics.e(EventType.LOAD_HOOK_BEFORE_SYSTEM, null);
    L38:
        l17.k.a(new String[]{"call TTWebContext startImpl tryLoadEarly end cost " + r107});
        TTWebSdk.h r108 = this.f265220f;
        if (r108 == null) goto L42;
        r108.a();
    L42:
        if (Build.VERSION.SDK_INT >= 26) goto L44;
        p.d();
    L44:
        i0.m();
        return;
    L49:
        Object r109 = r102.e("sdk_disk_sensitive_ratio");     // Catch: Exception -> L23
        if (r109 == null) goto L25;
        r103 = CastDoubleProtector.parseDouble(r109.toString());     // Catch: Exception -> L23
    L23:
        e = move-exception;
        l17.k.d(new String[]{"getBooleanByKey error : " + e.toString()});
    L46:
        th = move-exception;
        throw th;
    L5:
        if (LibraryLoader.f265132s.get() == false) goto L7;
        boolean r110 = LibraryLoader.f265133t.getAndSet(true);
    L8:
        if (r110 == false) goto L11;
        EventStatistics.e(EventType.LOAD_INIT_TWICE, null);
        return;
    L7:
        r110 = true;
        goto L8
    }

    public final int k() {
        if (this.f265226l.get() != (-1120)) goto L5;
        String r100 = p().c();
        AtomicInteger r101 = this.f265226l;
        BufferedReader r102 = null;
        JSONObject r103 = null;
        r103 = null;
        r103 = null;
        BufferedReader r104 = new BufferedReader(new PolarisFileReaderWrapper(l17.m.e(r100)));     // Catch: Throwable -> L20 Exception -> L22
        StringBuilder r105 = new StringBuilder();     // Catch: Exception -> L18 Throwable -> L35
    L9:
        String r106 = r104.readLine();     // Catch: Exception -> L18 Throwable -> L35
        if (r106 == null) goto L12;
        r105.append(r106);     // Catch: Exception -> L18 Throwable -> L35
        goto L9
    L12:
        JSONObject r107 = new JSONObject(r105.toString());     // Catch: Exception -> L18 Throwable -> L35
        r104.close();     // Catch: IOException -> L15
    L17:
        r103 = r107;
    L30:
        if (r103 == null) goto L32;
        int r108 = r103.optInt("kernel_scc_version", -1);
    L33:
        r101.set(r108);
        return this.f265226l.get();
    L32:
        r108 = -2;
    L15:
        e = move-exception;
        l17.k.b(new String[]{e.toString()});
    L18:
        e = e;
    L24:
        l17.k.b(new String[]{e.toString()});     // Catch: Throwable -> L35
        if (r104 == null) goto L30;
        r104.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        l17.k.b(new String[]{e.toString()});
    L35:
        th = th;
        r102 = r104;
    L37:
        if (r102 != null) goto L45;
    L42:
        throw th;
    L45:
        r102.close();     // Catch: IOException -> L40
    L40:
        e = move-exception;
        l17.k.b(new String[]{e.toString()});
        goto L42
    L22:
        e = e;
        r104 = null;
    L20:
        th = th;
        goto L37
    L5:
        return this.f265226l.get();
    }

    public final c0 p() {
        if (this.f265217c != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f265217c != null) goto L8;
        l17.k.d(new String[]{"create TTWebContext SdkSharedPrefs"});     // Catch: Throwable -> L10
        this.f265217c = new c0(getContext());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f265217c;
    }

    public final Handler q() {
        if (this.f265218d != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f265218d != null) goto L8;
        this.f265218d = new PthreadHandlerThreadV2("library-prepare", 1);     // Catch: Throwable -> L10
        ThreadMethodProxy.start(this.f265218d);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        if (this.f265219e != null) goto L25;
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L17:
        if (this.f265219e != null) goto L19;
        this.f265219e = new Handler(this.f265218d.getLooper());     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);     // Catch: Throwable -> L21
    L25:
        return this.f265219e;
    }

    public final String m() {
        if (l17.n.d(getContext()) == false) goto L5;
    L8:
        l17.k.d(new String[]{"getLocalSettingValue, getting setting string from host app"});
        return this.f265225k;
    L5:
        if (B == true) goto L8;
        return "";
    }

    public final boolean v() {
        Context r100 = getContext();
        String[] r101 = new String[1];
        StringBuilder r102 = new StringBuilder("needsPrepareBuiltin isBuiltin ");
        r102.append(t());
        r102.append(" systemwebview ");
        f17.a r103 = LibraryLoader.f265129p;
        r102.append(r103.f());
        r102.append(" files exists ");
        if (l17.g.f(r100, "libbytedanceweb.so") == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        r102.append(r104);
        r101[0] = r102.toString();
        l17.k.d(r101);
        if (t() == true) goto L11;
    L25:
        return false;
    L11:
        if (r103.f() == false) goto L25;
        if (l17.g.f(r100, "libbytedanceweb.so") == false) goto L25;
        if (l17.g.f(r100, "ttwebview.json") == false) goto L25;
        String r105 = p().c();
        boolean r106 = p().f265273b.getBoolean("isBuiltin", false);
        String r107 = l17.g.e().optString("sdk_upto_so_md5", "");
        if (r105.isEmpty() == true) goto L23;
        if (r106 == true) goto L20;
    L22:
        l17.k.d(new String[]{"needsPrepareBuiltin sdk sharepref " + r106 + " builtinMd5 " + r107 + " sdk sharepref decompressfulMd5 " + r105});
        goto L25
    L20:
        if (r105.equals(r107) == true) goto L22;
    L23:
        l17.k.d(new String[]{"needsPrepareBuiltin isBuiltin return True"});
        return true;
    L5:
        if (l17.g.f(r100, "ttwebview.json") == false) goto L7;
        r104 = true;
        goto L8
    }

    public Context getContext() {
        return this.f265215a;
    }

    public TTWebContext(Context r100) {
        this.f265222h = new AtomicBoolean(false);
        this.f265223i = new AtomicBoolean(false);
        this.f265224j = 0;
        this.f265226l = new AtomicInteger(-1120);
        this.f265227m = new HashMap();
        this.f265215a = r100;
        this.f265216b = new LibraryLoader();
        this.f265221g = new TTAdblockContext();
    }

    public static void A(Runnable r100) {
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L7
        h().q().post(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void B(Runnable r100) {
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L7
        h().q().post(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void C(Runnable r100) {
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L9
        h().q().post(r100);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static boolean a(DeleteReason r100) {
        l17.g.c();
        boolean r101 = l17.g.d(null);
        if (r101 == false) goto L10;
        h().p().f265273b.edit().putString("last_delete_reason", r100.getDescription()).apply();
        if (r100 != DeleteReason.DELETE_BY_ACTIVE) goto L8;
        c0 r102 = h().p();
        long r103 = System.currentTimeMillis();
        r102.f265273b.edit().putLong("last_delete_time", r103).apply();
    L8:
        if (Setting.c().b("sdk_pre_download", false) == false) goto L10;
        com.bytedance.lynx.webview.preparation.a r104 = new com.bytedance.lynx.webview.preparation.a();
        j17.b.a().f496867a.edit().putBoolean("download_task_incomplete", true).apply();
        r104.e(10, false, PrepareInfoNG.PreparePhase.DOWNLOADED);
    L10:
        return r101;
    }

    public static boolean b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        l17.k.b(new String[]{"TTWebContext:enableTTWebView return false due to Empty_ProcessName"});
        com.bytedance.lynx.webview.a.d(EventType.LOAD_SWITCH_NULL_PROCESS);
        return false;
    L7:
        if (l17.n.d(h().getContext()) == true) goto L9;
    L16:
        boolean r101 = Setting.c().b("sdk_enable_ttwebview", false);
        if (r101 == true) goto L20;
        com.bytedance.lynx.webview.a.d(EventType.LOAD_SWITCH_SETTING_OFF);
        r.b("[Load] TTWebView disable by settings." + l17.b.b());
        return false;
    L20:
        Setting r102 = Setting.c();
        int r103 = ProcessFeatureIndex.ENABLE_USE_TTWEBVIEW.value();
        r102.getClass();
        boolean r104 = r101 & Setting.f(r100, r103, true);
        if (r104 == true) goto L23;
        com.bytedance.lynx.webview.a.d(EventType.LOAD_SWITCH_OFF_PROCESS);
        r.b("[Load] TTWebView disable by process-feature. process_name:" + r100);
    L23:
        return r104;
    L9:
        if (N == false) goto L13;
        r.b("[Load] Disable TTWebView because of actively deletion.");
        com.bytedance.lynx.webview.a.d(EventType.LOAD_SWITCH_OFF_BY_ACTIVELY_DELETE);
        return false;
    L13:
        if (d() == false) goto L16;
        r.b("[Load] Disable TTWebView because of exceeding the clear threshold.");
        com.bytedance.lynx.webview.a.d(EventType.LOAD_SWITCH_OFF_BY_USER_NOT_USE);
        return false;
    }

    public static synchronized TTWebContext c(Context r100) {
        monitor-enter(TTWebContext.class);
        if (r100 == null) goto L14;
        l17.k.d(new String[]{"call TTWebContext ensureCreateInstance"});     // Catch: Throwable -> L15
        if (f265203o != null) goto L10;
        boolean r101 = i0.f265323a;     // Catch: Throwable -> L15
        i0.f265325c = System.currentTimeMillis();     // Catch: Throwable -> L15
        f265203o = new TTWebContext(r100.getApplicationContext());     // Catch: Throwable -> L15
        f265204p = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L15
        if (i0.f265323a == false) goto L10;
        EventStatistics.e(EventType.LOAD_TRACE_EVENT_INIT, Long.valueOf(System.currentTimeMillis() - i0.f265325c));     // Catch: Throwable -> L15
    L10:
        TTWebContext r102 = f265203o;     // Catch: Throwable -> L15
        monitor-exit(TTWebContext.class);
        return r102;
    L14:
        throw new NullPointerException("context must not be null!");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public static String l(boolean r100) {
        String r101 = LibraryLoader.f265129p.f475074a;
        if (r100 == false) goto L5;
        l17.k.d(new String[]{"getLoadSoVersionCode: " + r101});
    L5:
        return r101;
    }

    public static boolean s(WebView r100) {
        if (r100 != null) goto L6;
        return r();
    L6:
        return new TTWebViewExtension(r100).isTTWebView();
    }

    public static void z(Runnable r100) {
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L9
        h().q().post(r100);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void E(TTWebSdk.h r100) {
        if (this.f265224j != 0) goto L5;
        this.f265224j = System.currentTimeMillis();
    L5:
        String r101 = l17.n.b(this.f265215a);
        boolean r102 = true;
        if (r101 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L14;
        l17.k.d(new String[]{"call TTWebContext start begin (renderprocess)"});
        p.d();
        this.f265216b.A(this.f265215a);
        return;
    L14:
        String r104 = l17.n.b(this.f265215a);
        if (r104 != null) goto L17;
    L19:
        r102 = false;
    L20:
        if (r102 == false) goto L23;
        l17.k.d(new String[]{"call TTWebContext start begin (gpu process)"});
        p.d();
        this.f265216b.A(this.f265215a);
        return;
    L23:
        l17.k.a(new String[]{"call TTWebContext start begin"});
        this.f265220f = r100;
        InfoReceiver.registerReceiver(getContext());
        LibraryLoader r105 = this.f265216b;
        c r106 = new c(this);
        d r107 = new d(this);
        r105.getClass();
        Trace.beginSection("LibraryLoader.tryLoadEarly");     // Catch: Throwable -> L31
        r.d("call TTWebContext start tryLoadEarly => hookProviderWrapper begin");     // Catch: Throwable -> L31
        if (r105.p(r106, r107) == false) goto L27;
        String r108 = "success";
    L28:
        r.d("[Load] HookProviderWrapper finish. result:".concat(r108));     // Catch: Throwable -> L31
        Trace.endSection();
        l17.k.d(new String[]{"call TTWebContext start end"});
        return;
    L27:
        r108 = "failed";
    L31:
        th = move-exception;
        Trace.endSection();
        throw th;
    L17:
        if (r104.contains("privileged_process") == false) goto L19;
    L8:
        if (r101.contains("sandboxed_process") == false) goto L10;
        r103 = true;
        goto L11
    }

    public final String n(boolean r100) {
        String r101 = p().g("uptoSoVersioncode", "0620010001");
        if (r100 == false) goto L5;
        l17.k.d(new String[]{"getLocalSoVersionCode: " + r101});
    L5:
        return r101;
    }

    public final boolean u(int r100) {
        if (l17.n.d(this.f265215a) == false) goto L5;
    L9:
        return true;
    L5:
        if (l17.n.e(this.f265215a) == true) goto L9;
        Setting r101 = Setting.c();
        String r102 = l17.n.b(this.f265215a);
        r101.getClass();
        return Setting.f(r102, r100, true);
    }

    public static void w(Runnable r100, long r101) {
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L7
        h().q().postDelayed(r100, r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void x(Runnable r100, long r101) {
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L7
        h().q().postDelayed(r100, r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void y(Runnable r100, long r101) {
        w(new b(r100), r101);
    }
}
