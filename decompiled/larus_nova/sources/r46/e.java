package r46;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f536061a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap<Class<?>, HashMap<String, ?>> f536062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<?>, Object> f536063c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<?>, c> f536064d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f536065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final s46.a f536066f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CopyOnWriteArrayList<b> f536067g = null;

    public e() {
    }

    static {
        f536061a = new e();
        f536063c = new ConcurrentHashMap();
        f536064d = new ConcurrentHashMap();
        f536067g = new CopyOnWriteArrayList();
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        Object r101 = a().newInstance();     // Catch: Throwable -> L9
        if ((r101 instanceof s46.a) == false) goto L6;
        s46.a r102 = (s46.a) r101;     // Catch: Throwable -> L9
    L7:
        f536066f = r102;     // Catch: Throwable -> L9
        d(s46.a.class, r102);     // Catch: Throwable -> L9
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L6:
        r102 = null;
    L9:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.ies.stark.framework.impl.HybridDevToolService");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.ies.stark.framework.impl.HybridDevToolService");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.ies.stark.framework.impl.HybridDevToolService");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.ies.stark.framework.impl.HybridDevToolService");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.ies.stark.framework.impl.HybridDevToolService");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.ies.stark.framework.impl.HybridDevToolService");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.ies.stark.framework.impl.HybridDevToolService");
    }

    public final void b(Class<?> r110) {
        Class<?>[] r111 = r110.getInterfaces();
        int r100 = r111.length;
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L9;
        Class<?> r102 = r111[r101];
        if (Intrinsics.areEqual(r102, a.class) == true) goto L11;
        r101 = r101 + 1;
    L11:
        if (r102 == null) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L69;
        ClassLoader r104 = e.class.getClassLoader();
        monitor-enter(this);
        s46.a r105 = f536066f;     // Catch: Throwable -> L66
        if (r105 != null) goto L20;
    L22:
        boolean r106 = false;
    L23:
        if (r106 == true) goto L72;
        monitor-exit(this);
        return;
    L72:
    L62:
        th = move-exception;
        com.bytedance.ies.stark.framework.b.a(th);     // Catch: Throwable -> L66
    L64:
        monitor-exit(this);
        return;
    L27:
        if (Intrinsics.areEqual(r104, e.class.getClassLoader()) == true) goto L29;
    L33:
        Iterator r107 = ServiceLoader.load(a.class, r104).iterator();     // Catch: Throwable -> L62
    L34:
        if (r107.hasNext() == false) goto L64;
        final a r108 = (a) r107.next();     // Catch: Throwable -> L59
        Class<?>[] r109 = r108.getClass().getInterfaces();     // Catch: Throwable -> L59
        int r112 = r109.length;     // Catch: Throwable -> L59
        int r113 = 0;
    L37:
        if (r113 >= r112) goto L42;
        Class<?> r114 = r109[r113];     // Catch: Throwable -> L59
        if ((!Intrinsics.areEqual(r114, a.class)) == true) goto L43;
        r113 = r113 + 1;     // Catch: Throwable -> L59
    L43:
        com.bytedance.ies.stark.framework.b.a(String.valueOf(r108.getClass().getInterfaces()));     // Catch: Throwable -> L59
        if (r114 == null) goto L45;
        String r115 = r108.getName();     // Catch: Throwable -> L59
        if (r115 != null) goto L50;
    L53:
        boolean r116 = true;
    L54:
        if (r116 == false) goto L56;
        d(r114, r108);     // Catch: Throwable -> L59
    L57:
        new Handler(Looper.getMainLooper()).post(new d(r108));     // Catch: Throwable -> L59
        goto L34
    L56:
        e(r114, r108, r108.getName());     // Catch: Throwable -> L59
        goto L57
    L50:
        if (r115.length() == 0) goto L53;
        r116 = false;
        goto L54
    L45:
        monitor-exit(this);
        return;
    L42:
        r114 = null;
    L59:
        th = move-exception;
        com.bytedance.ies.stark.framework.b.a(th);     // Catch: Throwable -> L62
        goto L34
    L29:
        if (f536065e == false) goto L32;
        monitor-exit(this);
        return;
    L32:
        f536065e = true;     // Catch: Throwable -> L62
        goto L33
    L20:
        if (r105.b() != true) goto L22;
        r106 = true;
    L66:
        th = move-exception;
        throw th;
    L69:
        return;
    L13:
        r103 = false;
        goto L14
    L9:
        r102 = null;
        goto L11
    }

    public final <T> T c(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        b(r100);
        ConcurrentHashMap<Class<?>, Object> r101 = f536063c;
        Object r102 = r101.get(r100);
        Object r103 = null;
        if (r102 != null) goto L5;
        r102 = (T) null;
    L5:
        if (r102 != null) goto L27;
        monitor-enter(r101);
        Object r104 = r101.get(r100);     // Catch: Throwable -> L24
        if (r104 == null) goto L11;
        r103 = r104;
    L11:
        if (r103 != null) goto L21;
        ConcurrentHashMap<Class<?>, c> r105 = f536064d;     // Catch: Throwable -> L24
        c r106 = r105.get(r100);     // Catch: Throwable -> L24
        if (r106 == null) goto L21;
        r103 = r106.create();     // Catch: Throwable -> L24
        if (r103 == null) goto L17;
        r101.put(r100, r103);     // Catch: Throwable -> L24
    L17:
        r105.remove(r100);     // Catch: Throwable -> L24
        Iterator<b> r107 = f536067g.iterator();     // Catch: Throwable -> L24
    L19:
        if (r107.hasNext() == false) goto L21;
        r107.next().onRegister();     // Catch: Throwable -> L24
    L21:
        r102 = (T) r103;
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r101);
    L24:
        th = move-exception;
        throw th;
    L27:
        return (T) r102;
    }

    public static void d(Class r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        f536063c.put(r100, r101);
        Iterator<b> r102 = f536067g.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onRegister();
        goto L4
    }

    public final synchronized void e(Class r100, a r101, String r102) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "clazz");     // Catch: Throwable -> L27
        if (r102 != null) goto L6;
    L9:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L15;
        d(r100, r101);     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L15:
        if (f536062b != null) goto L17;
        f536062b = new HashMap();     // Catch: Throwable -> L27
    L17:
        HashMap<Class<?>, HashMap<String, ?>> r104 = f536062b;     // Catch: Throwable -> L27
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L27
        HashMap<String, ?> r105 = r104.get(r100);     // Catch: Throwable -> L27
        if (r105 != null) goto L20;
        r105 = new HashMap();     // Catch: Throwable -> L27
        HashMap<Class<?>, HashMap<String, ?>> r106 = f536062b;     // Catch: Throwable -> L27
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L27
        r106.put(r100, r105);     // Catch: Throwable -> L27
    L20:
        r105.put(r102, r101);     // Catch: Throwable -> L27
        Iterator<b> r107 = f536067g.iterator();     // Catch: Throwable -> L27
    L22:
        if (r107.hasNext() == false) goto L25;
        r107.next().onRegister();     // Catch: Throwable -> L27
        goto L22
    L25:
        monitor-exit(this);
        return;
    L6:
        if (r102.length() == 0) goto L9;
        r103 = false;
    L27:
        th = move-exception;
        throw th;
    }
}
