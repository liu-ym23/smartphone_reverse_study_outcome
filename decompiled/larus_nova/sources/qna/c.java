package qna;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Object f534117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f534118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f534119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f534120d = null;

    static {
        f534120d = LazyKt.lazy(new b());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == false) goto L34;
        Class<?> r102 = Class.forName("sun.misc.Unsafe");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("sun.misc.Unsafe");     // Catch: Throwable -> L17
    L16:
        return r102;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("sun.misc.Unsafe");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("sun.misc.Unsafe");
    L34:
        Class<?> r103 = Class.forName("sun.misc.Unsafe");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("sun.misc.Unsafe");     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("sun.misc.Unsafe");
    L12:
        throw th;
    }

    public static int b(Thread r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Field r101 = f534119c;
        if (r101 != null) goto L23;
    L7:
        long r102 = 0;
    L9:
        if (r102 == 0) goto L25;
        Method r103 = f534118b;     // Catch: Throwable -> L20
        Integer r104 = null;
        if (r103 == null) goto L13;
        Object r105 = r103.invoke(f534117a, new Object[]{Long.valueOf(r102 + ((long) ((Number) f534120d.getValue()).intValue()))});     // Catch: Throwable -> L20
    L15:
        if ((r105 instanceof Integer) == false) goto L17;
        r104 = (Integer) r105;     // Catch: Throwable -> L20
    L17:
        if (r104 == null) goto L26;
        return r104.intValue();
    L26:
        return 0;
    L13:
        r105 = null;
    L27:
        return 0;
    L25:
        return 0;
    L23:
        Object r106 = r101.get(r100);     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Long");     // Catch: Throwable -> L6
        r102 = ((Long) r106).longValue();     // Catch: Throwable -> L6
        goto L9
    }
}
