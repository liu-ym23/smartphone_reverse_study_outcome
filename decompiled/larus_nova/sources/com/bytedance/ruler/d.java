package com.bytedance.ruler;

import android.util.LruCache;
import com.bytedance.express.ExprRunner;
import com.bytedance.express.cache.CacheManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.ruler.utils.ALogWrapper;
import com.bytedance.ruler.utils.AppLogWrapper;
import com.bytedance.ruler.utils.g;
import com.bytedance.ruler.utils.j;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f267677a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f267678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ExprRunner f267679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f267680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f267681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static com.bytedance.ruler.utils.d f267682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f267683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AppLogWrapper f267684h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ALogWrapper f267685i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static g f267686j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final j f267687k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f267688l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f267689m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f267690n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static boolean f267691o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final boolean f267692p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f267693q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f267694r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final HashMap<String, e> f267695s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f267696t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static long f267697u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static long f267698v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static long f267699w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static long f267700x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final d f267701y = null;

    public d() {
    }

    static {
        f267701y = new d();
        f267677a = new AtomicBoolean(false);
        f267680d = 100;
        f267684h = new AppLogWrapper();
        f267685i = new ALogWrapper();
        f267687k = new j();
        f267688l = true;
        f267689m = true;
        f267692p = true;
        f267695s = new HashMap();
        new ConcurrentHashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.ruler.debug.DebugToolImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.ruler.debug.DebugToolImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.ruler.debug.DebugToolImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.ruler.debug.DebugToolImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.ruler.debug.DebugToolImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.ruler.debug.DebugToolImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.ruler.debug.DebugToolImpl");
    }

    @JvmStatic
    public static final ExprRunner b() {
        if (f267679c != null) goto L5;
        int r100 = f267680d;
        ev5.d r101 = ev5.d.f474254b;
        f267679c = new ExprRunner(r100, ev5.d.f474254b);
    L5:
        ExprRunner r102 = f267679c;
        if (r102 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        return r102;
    }

    @JvmStatic
    public static final com.bytedance.ruler.utils.e c() {
        a r100 = f267678b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f267616b;
    }

    @JvmStatic
    public static final void e() {
        if (f267681e == true) goto L5;
        return;
    L5:
        if (f267682f != null) goto L16;
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
        Object r101 = a().newInstance();     // Catch: Throwable -> L11
        if (r101 == null) goto L10;
        com.bytedance.ruler.utils.d r102 = (com.bytedance.ruler.utils.d) r101;     // Catch: Throwable -> L11
        f267682f = r102;     // Catch: Throwable -> L11
        r102.init();     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L10:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.ruler.utils.IDebugTool");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    }

    @JvmStatic
    public static final e d(String r100) {
        e r101 = f267695s.get(r100);
        if (r101 != null) goto L7;
        e r102 = e.f267702e;
        return e.f267702e;
    L7:
        return r101;
    }

    @JvmStatic
    public static final void f(v97.d<?> r100) {
        HashMap<String, v97.d<?>> r101 = ga7.e.f480575a;
        monitor-enter(r101);
        v97.d<?> r102 = r101.put(r100.name(), r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void g(int r100) {
        monitor-enter(d.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (f267680d == r100) goto L15;
        f267680d = r100;     // Catch: Throwable -> L17
        ExprRunner r101 = b();     // Catch: Throwable -> L17
        if (r101 == null) goto L15;
        CacheManager r102 = r101.f243178a.f243184c;     // Catch: Throwable -> L17
        if (r100 != 0) goto L11;
        r102.f243190a = null;     // Catch: Throwable -> L17
        goto L15
    L11:
        LruCache<String, List<com.bytedance.express.command.b>> r103 = r102.f243190a;     // Catch: Throwable -> L17
        if (r103 != null) goto L14;
        r102.f243190a = new LruCache(r100);     // Catch: Throwable -> L17
        goto L15
    L14:
        r103.resize(r100);     // Catch: Throwable -> L17
    L15:
        monitor-exit(d.class);
    }
}
