package yx5;

import com.bytedance.frameworks.baselib.network.utils.TTReflectException;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Method> f569420c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f569421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f569422b;

    public static class a {
        public a() {
        }
    }

    static {
        new ConcurrentHashMap();
        f569420c = new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public final int hashCode() {
        return this.f569421a.hashCode();
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("TTReflect{target=");
        r100.append(this.f569421a);
        r100.append(", isClassTarget=");
        r100.append(this.f569422b);
        r100.append(", targetClass=");
        if (this.f569422b == false) goto L5;
        Class<?> r101 = (Class) this.f569421a;
    L6:
        r100.append(r101.getName());
        r100.append('}');
        return r100.toString();
    L5:
        r101 = this.f569421a.getClass();
        goto L6
    }

    public b(Class<?> r100) {
        this.f569421a = r100;
        this.f569422b = true;
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

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(AccessibleObject r100) {
        if ((r100 instanceof Member) == false) goto L17;
        Member r101 = (Member) r100;
        if (Modifier.isPublic(r101.getModifiers()) == false) goto L17;
        if (Modifier.isPublic(r101.getDeclaringClass().getModifiers()) == false) goto L17;
        return;
    L17:
    L14:
        e = move-exception;
        throw new TTReflectException("Failed to set accessible for " + r100, e, new String[]{r100.getClass().getSimpleName()});
    L11:
        if (r100.isAccessible() == true) goto L19;
        r100.setAccessible(true);     // Catch: SecurityException -> L14
        return;
    }

    public static b g(String r100) throws TTReflectException {
        Class r101 = a(r100);     // Catch: Exception -> L9 ClassNotFoundException -> L12
        if (r101 == null) goto L8;
        return new b(r101);
    L8:
        throw new TTReflectException("Class object cannot be null");
    L12:
        e = move-exception;
        throw new TTReflectException("Class not found: ".concat(r100), e, new String[]{r100});
    L9:
        e = move-exception;
        throw new TTReflectException("Failed to load class: ".concat(r100), e, new String[]{r100});
    }

    public static Class<?> h(Class<?> r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.isPrimitive() == true) goto L8;
        return r100;
    L8:
        if (Boolean.TYPE != r100) goto L12;
        return Boolean.class;
    L12:
        if (Byte.TYPE != r100) goto L16;
        return Byte.class;
    L16:
        if (Character.TYPE != r100) goto L20;
        return Character.class;
    L20:
        if (Double.TYPE != r100) goto L24;
        return Double.class;
    L24:
        if (Float.TYPE != r100) goto L28;
        return Float.class;
    L28:
        if (Integer.TYPE != r100) goto L32;
        return Integer.class;
    L32:
        if (Long.TYPE != r100) goto L36;
        return Long.class;
    L36:
        if (Short.TYPE != r100) goto L40;
        return Short.class;
    L40:
        if (Void.TYPE != r100) goto L44;
        return Void.class;
    L44:
        return r100;
    }

    public b call(String r100) throws TTReflectException {
        return call(r100, new Object[0]);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (b.class == r100.getClass()) goto L10;
        return false;
    L10:
        return this.f569421a.equals(((b) r100).f569421a);
    }

    public b(Object r100) {
        this.f569421a = r100;
        this.f569422b = false;
    }

    public b call(String r100, Object... r101) throws TTReflectException {
        int r102 = 0;
        if (r101 != null) goto L5;
        Class<?>[] r103 = new Class[0];
    L15:
        return call(r100, r103, r101);
    L5:
        Class<?>[] r104 = new Class[r101.length];
    L7:
        if (r102 >= r101.length) goto L13;
        Object r105 = r101[r102];
        if (r105 != null) goto L11;
        Class<?> r106 = a.class;
    L12:
        r104[r102] = r106;
        r102 = r102 + 1;
        goto L7
    L11:
        r106 = r105.getClass();
        goto L12
    L13:
        r103 = r104;
        goto L15
    }

    public final Method d(String r100, Class<?>[] r101) throws NoSuchMethodException {
        if (this.f569422b == false) goto L5;
        Class<?> r102 = (Class) this.f569421a;
    L6:
        String r103 = c(r102.getName(), r100, r101);
        Method r104 = (Method) ((ConcurrentHashMap) f569420c).get(r103);
        if (r104 == null) goto L10;
        return r104;
    L10:
        if (this.f569422b == false) goto L12;
        Class<?> r105 = (Class) this.f569421a;
    L13:
        Method r106 = null;
    L14:
        if (r105 == null) goto L21;
        if (r106 != null) goto L21;
        r106 = r105.getMethod(r100, r101);     // Catch: NoSuchMethodException -> L18
    L18:
        r106 = r105.getDeclaredMethod(r100, r101);     // Catch: NoSuchMethodException -> L20
    L20:
        r105 = r105.getSuperclass();
    L21:
        if (r106 == null) goto L25;
        b(r106);
        ((ConcurrentHashMap) f569420c).put(r103, r106);
        return r106;
    L25:
        throw new NoSuchMethodException();
    L12:
        r105 = this.f569421a.getClass();
        goto L13
    L5:
        r102 = this.f569421a.getClass();
        goto L6
    }

    public final Method e(String r110, Class<?>[] r111) throws NoSuchMethodException {
        if (this.f569422b == false) goto L5;
        Class<?> r100 = (Class) this.f569421a;
    L6:
        Method r101 = null;
    L7:
        if (r100 == null) goto L37;
        if (r101 != null) goto L37;
        Method[] r102 = r100.getDeclaredMethods();
        int r103 = r102.length;
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L35;
        Method r105 = r102[r104];
        if (r105.getName().equals(r110) == false) goto L34;
        if (r105.getParameterTypes().length != r111.length) goto L34;
        Class<?>[] r106 = r105.getParameterTypes();
        if (r106.length != r111.length) goto L29;
        int r107 = 0;
    L20:
        if (r107 >= r106.length) goto L31;
        Class<?> r112 = h(r106[r107]);
        Class<?> r113 = r111[r107];
        if (r113 != a.class) goto L24;
        Class<?> r114 = null;
    L25:
        if (r114 == null) goto L30;
        if (r112.isAssignableFrom(r114) == false) goto L29;
    L30:
        r107 = r107 + 1;
        goto L20
    L24:
        r114 = h(r113);
        goto L25
    L31:
        boolean r108 = true;
    L32:
        if (r108 == false) goto L34;
        r101 = r105;
    L29:
        r108 = false;
    L34:
        r104 = r104 + 1;
    L35:
        if (r101 != null) goto L7;
        r100 = r100.getSuperclass();
    L37:
        if (r101 == null) goto L45;
        b(r101);
        if (this.f569422b == false) goto L41;
        Class<?> r109 = (Class) this.f569421a;
    L42:
        ((ConcurrentHashMap) f569420c).put(c(r109.getName(), r110, r111), r101);
        return r101;
    L41:
        r109 = this.f569421a.getClass();
        goto L42
    L45:
        throw new NoSuchMethodException();
    L5:
        r100 = this.f569421a.getClass();
        goto L6
    }

    public final b f(Method r100, Object... r101) throws TTReflectException {
        b(r100);     // Catch: Exception -> L10
        Object r102 = r100.invoke(this.f569421a, r101);     // Catch: Exception -> L10
        if (r100.getReturnType() == Void.TYPE) goto L18;
        if (r102 == null) goto L9;
        return new b(r102);
    L9:
        throw new TTReflectException("Instance object cannot be null");     // Catch: Exception -> L10
    L18:
        return this;
    L10:
        e = move-exception;
        String r103 = "Failed to invoke method: " + r100.getName();
        String[] r104 = new String[3];
        if (this.f569422b == false) goto L14;
        Class<?> r105 = (Class) this.f569421a;
    L15:
        r104[0] = r105.getName();
        r104[1] = r100.getName();
        r104[2] = Arrays.toString(r100.getParameterTypes());
        throw new TTReflectException(r103, e, r104);
    L14:
        r105 = this.f569421a.getClass();
        goto L15
    }

    public static String c(String r100, String r101, Class... r102) {
        StringBuilder r103 = new StringBuilder(r100);
        r103.append("#");
        r103.append(r101);
        if (r102 == null) goto L19;
        if (r102.length <= 0) goto L19;
        r103.append("[");
        int r104 = 0;
    L8:
        if (r104 >= r102.length) goto L17;
        Class r105 = r102[r104];
        if (r105 == null) goto L12;
        String r106 = r105.getName();
    L13:
        r103.append(r106);
        if (r104 == (r102.length - 1)) goto L16;
        r103.append(",");
    L16:
        r104 = r104 + 1;
        goto L8
    L12:
        r106 = "null";
        goto L13
    L17:
        r103.append("]");
    L19:
        return r103.toString();
    }

    public b call(String r100, Class<?>[] r101, Object... r102) throws TTReflectException {
        return f(d(r100, r101), r102);
    L4:
        return f(e(r100, r101), r102);
    L6:
        e = move-exception;
        String r103 = "No method found: " + r100;
        String[] r104 = new String[3];
        if (this.f569422b == false) goto L10;
        Class<?> r105 = (Class) this.f569421a;
    L11:
        r104[0] = r105.getName();
        r104[1] = r100;
        r104[2] = Arrays.toString(r101);
        throw new TTReflectException(r103, e, r104);
    L10:
        r105 = this.f569421a.getClass();
        goto L11
    }
}
