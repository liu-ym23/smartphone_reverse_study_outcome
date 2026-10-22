package e27;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f470834a = null;

    static {
        HashMap r100 = new HashMap();
        f470834a = r100;
        Class r101 = Boolean.TYPE;
        r100.put(Boolean.class, r101);
        r100.put(Byte.class, Byte.TYPE);
        r100.put(Character.class, Character.TYPE);
        r100.put(Short.class, Short.TYPE);
        Class r102 = Integer.TYPE;
        r100.put(Integer.class, r102);
        Class r103 = Float.TYPE;
        r100.put(Float.class, r103);
        Class r104 = Long.TYPE;
        r100.put(Long.class, r104);
        r100.put(Double.class, Double.TYPE);
        r100.put(r101, r101);
        Class r105 = Byte.TYPE;
        r100.put(r105, r105);
        Class r106 = Character.TYPE;
        r100.put(r106, r106);
        Class r107 = Short.TYPE;
        r100.put(r107, r107);
        r100.put(r102, r102);
        r100.put(r103, r103);
        r100.put(r104, r104);
        Class r108 = Double.TYPE;
        r100.put(r108, r108);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.FileUtils");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.FileUtils");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.FileUtils");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.FileUtils");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.FileUtils");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.FileUtils");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.FileUtils");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Method b(Class r110, Class... r111) throws NoSuchMethodException, SecurityException {
        Method[] r100 = r110.getDeclaredMethods();
        int r101 = r100.length;
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L35;
        Method r103 = r100[r102];
        if (r103.getName().equals("setPermissions") == false) goto L34;
        Class<?>[] r104 = r103.getParameterTypes();
        if (r104 != 0) goto L13;
        if (r111 != null) goto L11;
    L31:
        boolean r105 = true;
    L32:
        if (r105 == false) goto L34;
    L36:
        if (r103 == null) goto L38;
        r103.setAccessible(true);
        return r103;
    L38:
        if (r110.getSuperclass() == null) goto L42;
        return b(r110.getSuperclass(), r111);
    L42:
        throw new NoSuchMethodException();
    L11:
        if (r111.length == 0) goto L31;
    L29:
        r105 = false;
        goto L32
    L13:
        if (r111 != null) goto L18;
        if (r104.length != 0) goto L29;
    L18:
        if (r104.length != r111.length) goto L29;
        int r106 = 0;
    L22:
        if (r106 >= r104.length) goto L31;
        if (r104[r106].isAssignableFrom(r111[r106]) == true) goto L30;
        Map<Class<?>, Class<?>> r107 = f470834a;
        HashMap r108 = (HashMap) r107;
        if (r108.containsKey(r104[r106]) == false) goto L29;
        if (((Class) r108.get(r104[r106])).equals(r108.get(r111[r106])) == false) goto L29;
    L30:
        r106 = r106 + 1;
    L34:
        r102 = r102 + 1;
        goto L4
    L35:
        r103 = null;
        goto L36
    }
}
