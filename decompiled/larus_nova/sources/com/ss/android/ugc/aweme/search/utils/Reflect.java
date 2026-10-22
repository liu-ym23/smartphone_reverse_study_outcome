package com.ss.android.ugc.aweme.search.utils;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class Reflect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f453416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f453417b;

    public static class NULL {
        private NULL() {
        }
    }

    public Reflect() {
        throw null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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
        return this.f453417b.hashCode();
    }

    public final String toString() {
        return String.valueOf(this.f453417b);
    }

    public static Class<?> e(Class<?> r100) {
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

    public Reflect call(String r100) throws ReflectException {
        return call(r100, new Object[0]);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof Reflect) == true) goto L5;
        return false;
    L5:
        return this.f453417b.equals(((Reflect) r100).f453417b);
    }

    public Reflect(Class<?> r100, Object r101) {
        this.f453416a = r100;
        this.f453417b = r101;
    }

    public Reflect call(String r100, Object... r101) throws ReflectException {
        int r102 = 0;
        if (r101 != null) goto L5;
        Class<?>[] r103 = new Class[0];
    L31:
        Class<?> r104 = this.f453416a;     // Catch: NoSuchMethodException -> L25
        Method r105 = r104.getMethod(r100, r103);     // Catch: NoSuchMethodException -> L30
    L19:
        return c(r105, this.f453417b, r101);
    L32:
        r105 = r104.getDeclaredMethod(r100, r103);     // Catch: NoSuchMethodException -> L20
    L20:
        r104 = r104.getSuperclass();     // Catch: NoSuchMethodException -> L25
        if (r104 != null) goto L32;
        throw new NoSuchMethodException();     // Catch: NoSuchMethodException -> L25
    L25:
        return c(d(r100, r103), this.f453417b, r101);
    L27:
        e = move-exception;
        throw new ReflectException(e);
    L5:
        Class<?>[] r106 = new Class[r101.length];
    L7:
        if (r102 >= r101.length) goto L13;
        Object r107 = r101[r102];
        if (r107 != null) goto L11;
        Class<?> r108 = NULL.class;
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

    public final Method d(String r100, Class<?>[] r101) throws NoSuchMethodException {
        Class<?> r102 = this.f453416a;
        Method[] r103 = r102.getMethods();
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        Method r106 = r103[r105];
        if (b(r106, r100, r101) == true) goto L6;
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
        if (b(r110, r100, r101) == true) goto L12;
        r109 = r109 + 1;
        goto L9
    L12:
        return r110;
    L14:
        r102 = r102.getSuperclass();
        if (r102 != null) goto L8;
        throw new NoSuchMethodException("No similar method " + r100 + " with params " + Arrays.toString(r101) + " could be found on type " + this.f453416a + ".");
    }

    public static boolean b(Method r100, String r101, Class[] r102) {
        if (r100.getName().equals(r101) == false) goto L29;
        Class<?>[] r103 = r100.getParameterTypes();
        if (r103.length != r102.length) goto L19;
        int r104 = 0;
    L8:
        if (r104 >= r102.length) goto L18;
        if (r102[r104] == NULL.class) goto L17;
        Class<?> r105 = e(r103[r104]);
        Class<?> r106 = e(r102[r104]);
        if (r105 == null) goto L19;
        if (r106 == null) goto L19;
        if (r105.isAssignableFrom(r106) == false) goto L19;
    L17:
        r104 = r104 + 1;
        goto L8
    L18:
        boolean r107 = true;
    L20:
        if (r107 == false) goto L30;
        return true;
    L30:
        return false;
    L19:
        r107 = false;
        goto L20
    L29:
        return false;
    }

    public static Reflect c(Method r100, Object r101, Object... r102) throws ReflectException {
        if (r100 == null) goto L13;
    L26:
        e = move-exception;
        throw new ReflectException(e);
    L5:
        if (Modifier.isPublic(r100.getModifiers()) == false) goto L10;
        if (Modifier.isPublic(r100.getDeclaringClass().getModifiers()) == true) goto L13;
    L10:
        if (r100.isAccessible() == true) goto L13;
        r100.setAccessible(true);     // Catch: Exception -> L26
    L13:
        if (r100.getReturnType() != Void.TYPE) goto L20;
        r100.invoke(r101, r102);     // Catch: Exception -> L26
        if (r101 != null) goto L17;
        Class<?> r103 = Object.class;
    L19:
        return new Reflect(r103, r101);
    L17:
        r103 = r101.getClass();     // Catch: Exception -> L26
        goto L19
    L20:
        Object r104 = r100.invoke(r101, r102);     // Catch: Exception -> L26
        if (r104 != null) goto L23;
        Class<?> r105 = Object.class;
    L25:
        return new Reflect(r105, r104);
    L23:
        r105 = r104.getClass();     // Catch: Exception -> L26
        goto L25
    }
}
