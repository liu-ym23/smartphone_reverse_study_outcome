package iy5;

import com.bytedance.common.utility.reflect.ReflectException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f496561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f496562b;

    public static class a {
        public a() {
        }
    }

    public final int hashCode() {
        return this.f496561a.hashCode();
    }

    public final Class<?> i() {
        if (this.f496562b == false) goto L7;
        return (Class) this.f496561a;
    L7:
        return this.f496561a.getClass();
    }

    public final String toString() {
        return this.f496561a.toString();
    }

    public k(Class<?> r100) {
        this.f496561a = r100;
        this.f496562b = true;
    }

    public static <T extends AccessibleObject> T a(T r100) {
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

    public static Class<?> j(Class<?> r100) {
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

    public k call(String r100) throws ReflectException {
        return call(r100, null, new Object[0]);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof k) == true) goto L5;
        return false;
    L5:
        return this.f496561a.equals(((k) r100).f496561a);
    }

    public k(Object r100) {
        this.f496561a = r100;
        this.f496562b = false;
    }

    public final Method b(String r100, Class<?>[] r101) throws NoSuchMethodException {
        Class<?> r102 = i();
        return r102.getMethod(r100, r101);
    L24:
        return r102.getDeclaredMethod(r100, r101);
    L7:
        r102 = r102.getSuperclass();
        if (r102 != null) goto L24;
        Method[] r103 = i().getMethods();
        int r104 = r103.length;
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L20;
        Method r106 = r103[r105];
        if (r100.equals(r106.getName()) == false) goto L18;
        Class<?>[] r107 = r106.getParameterTypes();
        if (r107 == null) goto L18;
        if (r107.length != r101.length) goto L18;
        return r106;
    L18:
        r105 = r105 + 1;
        goto L10
    L20:
        throw new NoSuchMethodException();
    }

    public final k c(String r100, Class<?>... r101) throws ReflectException {
        return new k(d(r100, r101).get(this.f496561a));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    public final Field d(String r100, Class<?>... r110) throws ReflectException {
        Class<?> r101 = i();
        if (r110.length <= 0) goto L37;
    L33:
        Field[] r102 = r101.getDeclaredFields();     // Catch: Exception -> L15
        int r103 = r102.length;     // Catch: Exception -> L15
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L17;
        Field r105 = r102[r104];     // Catch: Exception -> L15
        Class<?> r106 = r105.getType();     // Catch: Exception -> L15
        if (r106 == null) goto L14;
        if (r106.getName().equals(r110[0].getName()) == false) goto L14;
        if (r105.getName().equals(r100) == false) goto L14;
        return (Field) a(r105);
    L14:
        r104 = r104 + 1;
    L17:
        r101 = r101.getSuperclass();
        if (r101 != null) goto L33;
        throw new ReflectException("NoSuchFieldException");
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L37:
        return r101.getField(r100);
    L24:
        e = move-exception;
    L35:
        return (Field) a(r101.getDeclaredField(r100));
    L27:
        e = move-exception;
        e.printStackTrace();
        r101 = r101.getSuperclass();
        if (r101 != null) goto L35;
        throw new ReflectException(e);
    }

    public final Method f(String r100, Class<?>[] r101) throws ReflectException {
        return b(r100, r101);
    L4:
        return h(r100, r101);
    L6:
        e = move-exception;
        throw new ReflectException(e);
    }

    public final Method h(String r100, Class<?>[] r101) throws NoSuchMethodException {
        Class<?> r102 = i();
        Method[] r103 = r102.getMethods();
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        Method r106 = r103[r105];
        if (e(r106, r100, r101) == true) goto L6;
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
        if (e(r110, r100, r101) == true) goto L12;
        r109 = r109 + 1;
        goto L9
    L12:
        return r110;
    L14:
        r102 = r102.getSuperclass();
        if (r102 != null) goto L8;
        throw new NoSuchMethodException("No similar method " + r100 + " with params " + Arrays.toString(r101) + " could be found on type " + i() + ".");
    }

    public static boolean e(Method r100, String r101, Class[] r102) {
        if (r100.getName().equals(r101) == false) goto L24;
        Class<?>[] r103 = r100.getParameterTypes();
        if (r103.length != r102.length) goto L16;
        int r104 = 0;
    L8:
        if (r104 >= r102.length) goto L15;
        if (r102[r104] == a.class) goto L14;
        if (j(r103[r104]).isAssignableFrom(j(r102[r104])) == false) goto L16;
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

    public static k g(Method r100, Object r101, Object... r102) throws ReflectException {
        a(r100);     // Catch: Exception -> L8
        if (r100.getReturnType() != Void.TYPE) goto L7;
        r100.invoke(r101, r102);     // Catch: Exception -> L8
        return new k(r101);
    L7:
        return new k(r100.invoke(r101, r102));
    L8:
        e = move-exception;
        throw new ReflectException(e);
    }

    public k call(String r100, Class<?>[] r101, Object... r102) throws ReflectException {
        return g(b(r100, r101), this.f496561a, r102);
    L4:
        return g(h(r100, r101), this.f496561a, r102);
    L6:
        e = move-exception;
        throw new ReflectException(e);
    }
}
