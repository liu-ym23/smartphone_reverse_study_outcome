package is0;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ILivePlayerService f495580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f495581b;

    @JvmStatic
    public static final ILivePlayerService c() {
        if (f495580a == null) goto L11;
    L9:
        ILivePlayerService r100 = f495580a;
        Intrinsics.checkNotNull(r100);
        return r100;
    L11:
        Object r101 = b(a("com.bytedance.android.livesdk.player.LivePlayerService"));     // Catch: Exception -> L7
    L8:
        f495580a = (ILivePlayerService) r101;
    L7:
        r101 = null;
        goto L8
    }

    static {
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

    public static Object b(Class r100) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Constructor<?>[] r101 = r100.getDeclaredConstructors();
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L19;
        Constructor<?> r103 = r101[0];
        r103.setAccessible(true);
        Class<?>[] r104 = r103.getParameterTypes();
        if (r104 == null) goto L17;
        if (r104.length == 0) goto L17;
        throw new ClassNotFoundException("not found ".concat(r100.getSimpleName()));
    L17:
        return r103.newInstance(new Object[0]);
    L19:
        throw new IllegalArgumentException(("Can't get even one available constructor for " + r100).toString());
    L5:
        if (r101.length == 0) goto L7;
        r102 = true;
        goto L8
    }
}
