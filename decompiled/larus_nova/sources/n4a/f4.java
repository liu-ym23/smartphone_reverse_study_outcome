package n4a;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public final class f4 {
    public static Object b(Object r100, Class<?> r101, String r102, Object... r103) throws Exception {
        Class<?>[] r104 = new Class[r103.length];
        int r105 = r103.length;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L14;
        Class<?> r107 = r103[r106].getClass();
        r104[r106] = r107;
        if (r107 != Integer.class) goto L8;
        r104[r106] = Integer.TYPE;
    L8:
        if (r104[r106] != Boolean.class) goto L11;
        r104[r106] = Boolean.TYPE;
    L11:
        if (r104[r106] != Double.class) goto L13;
        r104[r106] = Double.TYPE;
    L13:
        r106 = r106 + 1;
        goto L3
    L14:
        Method r108 = r101.getDeclaredMethod(r102, r104);
        if (r108.isAccessible() == true) goto L26;
        r108.setAccessible(true);
    L26:
        return r108.invoke(r100, r103);
    L19:
        th = move-exception;
        if ((th instanceof InvocationTargetException) == false) goto L23;
        c4.g(th.getTargetException(), "Reflect", "invokeMethod ".concat(r102));     // Catch: Throwable -> L25
    L23:
        return null;
    }

    public static Object c(Object r100, String r101, Object... r102) {
        return b(r100, r100.getClass(), r101, r102);
    L4:
        return null;
    }

    public static Object d(String r100, String r101) throws Exception {
        Class r102 = a(r100);
        Field r103 = r102.getField(r101);
        r103.setAccessible(true);
        return r103.get(r102);
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

    public static Object e(String r100, String r101, Object[] r102, Class<?>[] r103) throws Exception {
        Method r104 = a(r100).getDeclaredMethod(r101, r103);
        if (r104.isAccessible() == true) goto L6;
        r104.setAccessible(true);
    L6:
        return r104.invoke(null, r102);
    }
}
