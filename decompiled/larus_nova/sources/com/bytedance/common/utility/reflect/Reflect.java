package com.bytedance.common.utility.reflect;

import com.bytedance.common.utility.Logger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class Reflect {
    private final boolean isClass;
    private final Object object;

    /* JADX INFO: loaded from: classes15.dex */
    public static class NULL {
        public NULL() {
        }
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public Reflect create() throws ReflectException {
        return create(new Object[0]);
    }

    public Map<String, Reflect> fields() {
        LinkedHashMap r100 = new LinkedHashMap();
        Class<?> r101 = type();
    L3:
        Field[] r102 = r101.getDeclaredFields();
        int r103 = r102.length;
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L11;
        Field r105 = r102[r104];
        if (((!this.isClass) ^ Modifier.isStatic(r105.getModifiers())) == false) goto L10;
        String r106 = r105.getName();
        if (r100.containsKey(r106) == true) goto L10;
        r100.put(r106, field(r106, new Class[0]));
    L10:
        r104 = r104 + 1;
        goto L4
    L11:
        r101 = r101.getSuperclass();
        if (r101 != null) goto L3;
        return r100;
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public String toString() {
        return this.object.toString();
    }

    public Class<?> type() {
        if (this.isClass == false) goto L7;
        return (Class) this.object;
    L7:
        return this.object.getClass();
    }

    public <T> T get() {
        return (T) this.object;
    }

    private Reflect(Class<?> r100) {
        this.object = r100;
        this.isClass = true;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_utility_reflect_Reflect_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
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

    public static /* synthetic */ Class[] access$000(Object[] r100) {
        return types(r100);
    }

    public static /* synthetic */ Object access$100(Reflect r100) {
        return r100.object;
    }

    public static /* synthetic */ String access$200(String r100) {
        return property(r100);
    }

    public static <T extends AccessibleObject> T accessible(T r100) {
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

    private static Class<?> forName(String r100) throws ReflectException {
        return INVOKESTATIC_com_bytedance_common_utility_reflect_Reflect_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    public static Reflect on(String r100) throws ReflectException {
        return on(forName(r100));
    }

    private static String property(String r100) {
        int r101 = r100.length();
        if (r101 != 0) goto L7;
        return "";
    L7:
        if (r101 != 1) goto L11;
        return r100.toLowerCase(Locale.getDefault());
    L11:
        return r100.substring(0, 1).toLowerCase(Locale.getDefault()) + r100.substring(1);
    }

    private static Class<?>[] types(Object... r100) {
        int r101 = 0;
        if (r100 == null) goto L5;
        Class<?>[] r102 = new Class[r100.length];
    L8:
        if (r101 >= r100.length) goto L14;
        Object r103 = r100[r101];
        if (r103 != null) goto L12;
        Class<?> r104 = NULL.class;
    L13:
        r102[r101] = r104;
        r101 = r101 + 1;
        goto L8
    L12:
        r104 = r103.getClass();
        goto L13
    L14:
        return r102;
    L5:
        return new Class[0];
    }

    private static Object unwrap(Object r100) {
        if ((r100 instanceof Reflect) == true) goto L5;
        return r100;
    L5:
        return ((Reflect) r100).get();
    }

    public static Class<?> wrapper(Class<?> r100) {
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

    public <P> P as(Class<P> r100) {
        final boolean r101 = this.object instanceof Map;
        InvocationHandler r102 = new AnonymousClass1(this, r101);
        return (P) Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, r102);
    }

    public Reflect call(String r100) throws ReflectException {
        return call(r100, null, new Object[0]);
    }

    public Reflect create(Object... r100) throws ReflectException {
        Class<?>[] r101 = types(r100);
        return on(type().getDeclaredConstructor(r101), r100);
    L5:
        e = move-exception;
        Constructor<?>[] r102 = type().getDeclaredConstructors();
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L14;
        Constructor<?> r105 = r102[r104];
        if (match(r105.getParameterTypes(), r101) == true) goto L11;
        r104 = r104 + 1;
        goto L7
    L11:
        return on(r105, r100);
    L14:
        throw new ReflectException(e);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof Reflect) == true) goto L5;
        return false;
    L5:
        return this.object.equals(((Reflect) r100).get());
    }

    private Reflect(Object r100) {
        this.object = r100;
        this.isClass = false;
    }

    public static Reflect on(Class<?> r100) {
        return new Reflect(r100);
    }

    public static Reflect on(Object r100) {
        return new Reflect(r100);
    }

    private Field field0(String r100, Class<?>... r110) throws ReflectException {
        Class<?> r101 = type();
        if (r110 != null) goto L5;
    L39:
        return r101.getField(r100);
    L26:
        e = move-exception;
    L37:
        return (Field) accessible(r101.getDeclaredField(r100));
    L29:
        e = move-exception;
        e.printStackTrace();
        r101 = r101.getSuperclass();
        if (r101 != null) goto L37;
        throw new ReflectException(e);
    L5:
        if (r110.length <= 0) goto L39;
    L35:
        Field[] r102 = r101.getDeclaredFields();     // Catch: Exception -> L17
        int r103 = r102.length;     // Catch: Exception -> L17
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L19;
        Field r105 = r102[r104];     // Catch: Exception -> L17
        Class<?> r106 = r105.getType();     // Catch: Exception -> L17
        if (r106 == null) goto L16;
        if (r106.getName().equals(r110[0].getName()) == false) goto L16;
        if (r105.getName().equals(r100) == false) goto L16;
        return (Field) accessible(r105);
    L16:
        r104 = r104 + 1;
    L19:
        r101 = r101.getSuperclass();
        if (r101 != null) goto L35;
        throw new ReflectException("NoSuchFieldException");
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    private boolean match(Class<?>[] r100, Class<?>[] r101) {
        if (r100.length != r101.length) goto L19;
        int r102 = 0;
    L6:
        if (r102 >= r101.length) goto L17;
        if (r101[r102] == NULL.class) goto L15;
        Class<?> r103 = wrapper(r100[r102]);
        Class<?> r104 = wrapper(r101[r102]);
        if (r103 == null) goto L16;
        if (r104 == null) goto L16;
        if (r103.isAssignableFrom(r104) == true) goto L15;
    L16:
        return false;
    L15:
        r102 = r102 + 1;
        goto L6
    L17:
        return true;
    L19:
        return false;
    }

    private static Reflect on(Constructor<?> r100, Object... r101) throws ReflectException {
        return on(((Constructor) accessible(r100)).newInstance(r101));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    private Method similarMethod(String r100, Class<?>[] r101) throws NoSuchMethodException {
        Class<?> r102 = type();
        Method[] r103 = r102.getMethods();
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        Method r106 = r103[r105];
        if (isSimilarSignature(r106, r100, r101) == true) goto L6;
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
        if (isSimilarSignature(r110, r100, r101) == true) goto L12;
        r109 = r109 + 1;
        goto L9
    L12:
        return r110;
    L14:
        r102 = r102.getSuperclass();
        if (r102 != null) goto L8;
        throw new NoSuchMethodException("No similar method " + r100 + " with params " + Arrays.toString(r101) + " could be found on type " + type() + ".");
    }

    public Field exactField(String r100, Class<?>... r101) throws ReflectException {
        return field0(r100, r101);
    }

    public Reflect field(String r100, Class<?>... r101) throws ReflectException {
        return on(field0(r100, r101).get(this.object));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    public <T> T get(String r100, Class<?>... r101) throws ReflectException {
        return (T) field(r100, r101).get();
    }

    public Reflect set(String r100, Object r101) throws ReflectException {
        field0(r100, new Class[0]).set(this.object, unwrap(r101));     // Catch: Exception -> L5
        return this;
    L5:
        e = move-exception;
        throw new ReflectException(e);
    }

    private boolean isSimilarSignature(Method r100, String r101, Class<?>[] r102) {
        if (r100.getName().equals(r101) == true) goto L5;
    L7:
        return false;
    L5:
        if (match(r100.getParameterTypes(), r102) == false) goto L7;
        return true;
    }

    private static Reflect on(Method r100, Object r101, Object... r102) throws ReflectException {
        accessible(r100);     // Catch: Exception -> L8
        if (r100.getReturnType() != Void.TYPE) goto L7;
        r100.invoke(r101, r102);     // Catch: Exception -> L8
        return on(r101);
    L7:
        return on(r100.invoke(r101, r102));
    L8:
        e = move-exception;
        throw new ReflectException(e);
    }

    public Reflect call(String r100, Class<?>[] r101, Object... r102) throws ReflectException {
        return on(exactMethod(r100, r101, r102), this.object, r102);
    L4:
        return on(similarMethod(r100, r101), this.object, r102);
    L6:
        e = move-exception;
        throw new ReflectException(e);
    }

    public Method exactMethod(String r110, Class<?>[] r111, Object... r112) throws NoSuchMethodException {
        String r100 = r110;
        Class<?> r101 = type();
        return r101.getMethod(r100, r111);
    L28:
        return r101.getDeclaredMethod(r100, r111);
    L7:
        r101 = r101.getSuperclass();
        if (r101 != null) goto L28;
        Class<?> r102 = type();
        Method[] r103 = r102.getMethods();
        int r104 = r103.length;
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L24;
        Method r106 = r103[r105];
        if (r100.equals(r106.getName()) == false) goto L22;
        Class<?>[] r107 = r106.getParameterTypes();
        if (Logger.debug() == false) goto L18;
        int r108 = r107.length;
        int r113 = 0;
        int r114 = 1;
    L16:
        if (r113 >= r108) goto L18;
        Logger.d("Plugin", "Reflect type = " + r102 + " method = " + r100 + " paramTypes " + r114 + " = " + r107[r113].getName());
        r114 = r114 + 1;
        r113 = r113 + 1;
    L18:
        if (r107 == null) goto L22;
        if (r107.length != r111.length) goto L22;
        return r106;
    L22:
        r105 = r105 + 1;
        goto L10
    L24:
        throw new NoSuchMethodException();
    }
}
