package zf4;

import com.bytedance.commerce.base.reflect.ReflectException;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f571755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f571756b;

    /* JADX INFO: renamed from: zf4.a$a, reason: collision with other inner class name */
    public static class C8450a {
        public C8450a() {
        }
    }

    public a() {
        throw null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.ActivityThread");
    }

    public final int hashCode() {
        return this.f571756b.hashCode();
    }

    public final String toString() {
        return String.valueOf(this.f571756b);
    }

    public static <T extends AccessibleObject> T b(T r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Member) == false) goto L13;
        Member r101 = (Member) r100;
        if (Modifier.isPublic(r101.getModifiers()) == false) goto L13;
        if (Modifier.isPublic(r101.getDeclaringClass().getModifiers()) == false) goto L13;
        return r100;
    L13:
        if (r100.isAccessible() == true) goto L15;
        r100.setAccessible(true);
    L15:
        return r100;
    }

    public static Class<?> f(Class<?> r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.isPrimitive() == true) goto L8;
        return r100;
    L8:
        if (Boolean.TYPE != r100) goto L12;
        return Boolean.class;
    L12:
        if (Integer.TYPE != r100) goto L16;
        return Integer.class;
    L16:
        if (Long.TYPE != r100) goto L20;
        return Long.class;
    L20:
        if (Short.TYPE != r100) goto L24;
        return Short.class;
    L24:
        if (Byte.TYPE != r100) goto L28;
        return Byte.class;
    L28:
        if (Double.TYPE != r100) goto L32;
        return Double.class;
    L32:
        if (Float.TYPE != r100) goto L36;
        return Float.class;
    L36:
        if (Character.TYPE != r100) goto L40;
        return Character.class;
    L40:
        if (Void.TYPE != r100) goto L44;
        return Void.class;
    L44:
        return r100;
    }

    public a call(String r100) throws ReflectException {
        return call(r100, new Object[0]);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a) == true) goto L5;
        return false;
    L5:
        return this.f571756b.equals(((a) r100).f571756b);
    }

    public a(Class<?> r100, Object r101) {
        this.f571755a = r100;
        this.f571756b = r101;
    }

    public a call(String r100, Object... r101) throws ReflectException {
        int r102 = 0;
        if (r101 != null) goto L5;
        Class<?>[] r103 = new Class[0];
    L31:
        Class<?> r104 = this.f571755a;     // Catch: NoSuchMethodException -> L25
        Method r105 = r104.getMethod(r100, r103);     // Catch: NoSuchMethodException -> L30
    L19:
        return d(r105, this.f571756b, r101);
    L32:
        r105 = r104.getDeclaredMethod(r100, r103);     // Catch: NoSuchMethodException -> L20
    L20:
        r104 = r104.getSuperclass();     // Catch: NoSuchMethodException -> L25
        if (r104 != null) goto L32;
        throw new NoSuchMethodException();     // Catch: NoSuchMethodException -> L25
    L25:
        return d(e(r100, r103), this.f571756b, r101);
    L27:
        e = move-exception;
        throw new ReflectException(e);
    L5:
        Class<?>[] r106 = new Class[r101.length];
    L7:
        if (r102 >= r101.length) goto L13;
        Object r107 = r101[r102];
        if (r107 != null) goto L11;
        Class<?> r108 = C8450a.class;
    L12:
        r106[r102] = r108;
        r102 = r102 + 1;
        goto L7
    L11:
        r108 = r107.getClass();
        goto L12
    L13:
        r103 = r106;
        goto L31
    }

    public final Method e(String r100, Class<?>[] r101) throws NoSuchMethodException {
        Class<?> r102 = this.f571755a;
        Method[] r103 = r102.getMethods();
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        Method r106 = r103[r105];
        if (c(r106, r100, r101) == true) goto L6;
        r105 = r105 + 1;
        goto L3
    L6:
        return r106;
    L8:
        Method[] r107 = r102.getDeclaredMethods();
        int r108 = r107.length;
        int r109 = 0;
    L9:
        if (r109 >= r108) goto L14;
        Method r110 = r107[r109];
        if (c(r110, r100, r101) == true) goto L12;
        r109 = r109 + 1;
        goto L9
    L12:
        return r110;
    L14:
        r102 = r102.getSuperclass();
        if (r102 != null) goto L8;
        throw new NoSuchMethodException("No similar method " + r100 + " with params " + Arrays.toString(r101) + " could be found on type " + this.f571755a + ".");
    }

    public static boolean c(Method r100, String r101, Class[] r102) {
        if (r100.getName().equals(r101) == false) goto L24;
        Class<?>[] r103 = r100.getParameterTypes();
        if (r103.length != r102.length) goto L16;
        int r104 = 0;
    L8:
        if (r104 >= r102.length) goto L15;
        if (r102[r104] == C8450a.class) goto L14;
        if (f(r103[r104]).isAssignableFrom(f(r102[r104])) == false) goto L16;
    L14:
        r104 = r104 + 1;
        goto L8
    L15:
        boolean r105 = true;
    L17:
        if (r105 == false) goto L25;
        return true;
    L25:
        return false;
    L16:
        r105 = false;
        goto L17
    L24:
        return false;
    }

    public static a d(Method r100, Object r101, Object... r102) throws ReflectException {
        b(r100);     // Catch: Exception -> L16
        if (r100.getReturnType() != Void.TYPE) goto L10;
        r100.invoke(r101, r102);     // Catch: Exception -> L16
        if (r101 != null) goto L7;
        Class<?> r103 = Object.class;
    L9:
        return new a(r103, r101);
    L7:
        r103 = r101.getClass();     // Catch: Exception -> L16
        goto L9
    L10:
        Object r104 = r100.invoke(r101, r102);     // Catch: Exception -> L16
        if (r104 != null) goto L13;
        Class<?> r105 = Object.class;
    L15:
        return new a(r105, r104);
    L13:
        r105 = r104.getClass();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        throw new ReflectException(e);
    }
}
