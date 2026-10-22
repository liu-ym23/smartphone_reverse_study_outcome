package com.ss.android.lark.chameleon.util;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
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
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes35.dex */
public final class ReflectUtils {
    private final Object object;
    private final Class<?> type;

    public static class NULL {
        private NULL() {
        }
    }

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = 858774075258496016L;

        public ReflectException(String r100) {
            super(r100);
        }

        public ReflectException(Throwable r100) {
            super(r100);
        }

        public ReflectException(String r100, Throwable r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static /* synthetic */ Class access$002(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    public ReflectUtils newInstance() {
        return newInstance(new Object[0]);
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public String toString() {
        return this.object.toString();
    }

    private Class<?> type() {
        return this.type;
    }

    public <T> T get() {
        return (T) this.object;
    }

    private ReflectUtils(Class<?> r100) {
        this(r100, r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_lark_chameleon_util_ReflectUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static /* synthetic */ Object access$000(ReflectUtils r100) {
        return r100.object;
    }

    public static /* synthetic */ String access$100(String r100) {
        return property(r100);
    }

    private <T extends AccessibleObject> T accessible(T r100) {
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

    private static Class<?> forName(String r100) {
        return INVOKESTATIC_com_ss_android_lark_chameleon_util_ReflectUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    private Field getAccessibleField(String r100) {
        Class<?> r101 = type();
        return (Field) accessible(r101.getField(r100));
    L5:
        e = move-exception;
    L13:
        return (Field) accessible(r101.getDeclaredField(r100));
    L8:
        r101 = r101.getSuperclass();
        if (r101 != null) goto L13;
        throw new ReflectException(e);
    }

    private Class<?>[] getArgsType(Object... r100) {
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

    private Field getField(String r100) throws IllegalAccessException {
        Field r101 = getAccessibleField(r100);
        if ((r101.getModifiers() & 16) == 16) goto L7;
    L5:
        return r101;
    L7:
        Field r102 = Field.class.getDeclaredField("modifiers");     // Catch: NoSuchFieldException -> L6
        r102.setAccessible(true);     // Catch: NoSuchFieldException -> L6
        r102.setInt(r101, r101.getModifiers() & (-17));     // Catch: NoSuchFieldException -> L6
        goto L5
    }

    public static <T> Class<T> getGenericClass(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Type r101 = r100.getClass().getGenericSuperclass();
        if ((r101 instanceof ParameterizedType) == false) goto L16;
        if (r101 != null) goto L9;
        Type[] r102 = null;
    L10:
        if (r102 != null) goto L12;
        return null;
    L12:
        if (r102.length > 0) goto L15;
        return null;
    L15:
        return (Class) r102[0];
    L9:
        r102 = ((ParameterizedType) r101).getActualTypeArguments();
        goto L10
    L16:
        return null;
    }

    public static <T> Class<T> getGenericInterfaceClass(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Class<?> r101 = r100.getClass();
    L6:
        if (r101 == null) goto L12;
        if (r101.getGenericInterfaces() == null) goto L11;
        if (r101.getGenericInterfaces().length != 0) goto L12;
    L11:
        r101 = r101.getSuperclass();
    L12:
        if (r101 != null) goto L14;
        return null;
    L14:
        Type[] r102 = r101.getGenericInterfaces();
        if (r102 != null) goto L17;
    L22:
        Type[] r103 = null;
    L23:
        if (r103 != null) goto L25;
        return null;
    L25:
        if (r103.length > 0) goto L28;
        return null;
    L28:
        return (Class) r103[0];
    L17:
        if (r102.length <= 0) goto L22;
        Type r104 = r102[0];
        if ((r104 instanceof ParameterizedType) == false) goto L22;
        r103 = ((ParameterizedType) r104).getActualTypeArguments();
        goto L23
    }

    private static String property(String r100) {
        int r101 = r100.length();
        if (r101 != 0) goto L7;
        return "";
    L7:
        if (r101 != 1) goto L11;
        return r100.toLowerCase();
    L11:
        return r100.substring(0, 1).toLowerCase() + r100.substring(1);
    }

    public static ReflectUtils reflect(Object r100) throws ReflectException {
        if (r100 != null) goto L5;
        Class<?> r101 = Object.class;
    L7:
        return new ReflectUtils(r101, r100);
    L5:
        r101 = r100.getClass();
        goto L7
    }

    private void sortConstructors(List<Constructor<?>> r100) {
        Collections.sort(r100, new AnonymousClass1(this));
    }

    private void sortMethods(List<Method> r100) {
        Collections.sort(r100, new AnonymousClass2(this));
    }

    private Object unwrap(Object r100) {
        if ((r100 instanceof ReflectUtils) == true) goto L5;
        return r100;
    L5:
        return ((ReflectUtils) r100).get();
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

    public boolean equals(Object r100) {
        if ((r100 instanceof ReflectUtils) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.object.equals(((ReflectUtils) r100).get()) == false) goto L7;
        return true;
    }

    public ReflectUtils field(String r100) {
        Field r101 = getField(r100);     // Catch: IllegalAccessException -> L4
        return new ReflectUtils(r101.getType(), r101.get(this.object));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    public ReflectUtils method(String r100) throws ReflectException {
        return method(r100, new Object[0]);
    }

    public ReflectUtils newInstance(Object... r110) {
        Class<?>[] r100 = getArgsType(r110);
        return newInstance(type().getDeclaredConstructor(r100), r110);
    L5:
        e = move-exception;
        ArrayList r101 = new ArrayList();
        Constructor<?>[] r102 = type().getDeclaredConstructors();
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L13;
        Constructor<?> r105 = r102[r104];
        if (match(r105.getParameterTypes(), r100) == false) goto L11;
        r101.add(r105);
    L11:
        r104 = r104 + 1;
        goto L7
    L13:
        if (r101.isEmpty() == true) goto L17;
        sortConstructors(r101);
        return newInstance((Constructor) ListProtector.get(r101, 0), r110);
    L17:
        throw new ReflectException(e);
    }

    public <P> P proxy(Class<P> r100) {
        final boolean r101 = this.object instanceof Map;
        InvocationHandler r102 = new AnonymousClass3(this, r101);
        return (P) Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, r102);
    }

    public static ReflectUtils reflect(String r100) throws ReflectException {
        return reflect(forName(r100));
    }

    public static ReflectUtils reflect(Class<?> r100) throws ReflectException {
        return new ReflectUtils(r100);
    }

    private ReflectUtils(Class<?> r100, Object r101) {
        this.type = r100;
        this.object = r101;
    }

    private Method exactMethod(String r100, Class<?>[] r101) throws NoSuchMethodException {
        Class<?> r102 = type();
        return r102.getMethod(r100, r101);
    L15:
        return r102.getDeclaredMethod(r100, r101);
    L7:
        r102 = r102.getSuperclass();
        if (r102 != null) goto L15;
        throw new NoSuchMethodException();
    }

    private static Class<?> forName(String r100, ClassLoader r101) {
        return INVOKESTATIC_com_ss_android_lark_chameleon_util_ReflectUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100, true, r101);
    L5:
        e = move-exception;
        throw new ReflectException(e);
    }

    private boolean match(Class<?>[] r100, Class<?>[] r101) {
        if (r100.length != r101.length) goto L16;
        int r102 = 0;
    L6:
        if (r102 >= r101.length) goto L14;
        if (r101[r102] == NULL.class) goto L13;
        if (wrapper(r100[r102]).isAssignableFrom(wrapper(r101[r102])) == true) goto L13;
        return false;
    L13:
        r102 = r102 + 1;
        goto L6
    L14:
        return true;
    L16:
        return false;
    }

    private ReflectUtils newInstance(Constructor<?> r100, Object... r101) {
        return new ReflectUtils(r100.getDeclaringClass(), ((Constructor) accessible(r100)).newInstance(r101));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    public static ReflectUtils reflect(String r100, ClassLoader r101) throws ReflectException {
        return reflect(forName(r100, r101));
    }

    private Method similarMethod(String r100, Class<?>[] r110) throws NoSuchMethodException {
        Class<?> r101 = type();
        ArrayList r102 = new ArrayList();
        Method[] r103 = r101.getMethods();
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L9;
        Method r106 = r103[r105];
        if (isSimilarSignature(r106, r100, r110) == false) goto L7;
        r102.add(r106);
    L7:
        r105 = r105 + 1;
        goto L3
    L9:
        if (r102.isEmpty() == true) goto L12;
        sortMethods(r102);
        return (Method) ListProtector.get(r102, 0);
    L12:
        Method[] r107 = r101.getDeclaredMethods();
        int r108 = r107.length;
        int r109 = 0;
    L13:
        if (r109 >= r108) goto L19;
        Method r111 = r107[r109];
        if (isSimilarSignature(r111, r100, r110) == false) goto L17;
        r102.add(r111);
    L17:
        r109 = r109 + 1;
        goto L13
    L19:
        if (r102.isEmpty() == false) goto L20;
        r101 = r101.getSuperclass();
        if (r101 != null) goto L12;
        throw new NoSuchMethodException("No similar method " + r100 + " with params " + Arrays.toString(r110) + " could be found on type " + type() + ".");
    L20:
        sortMethods(r102);
        return (Method) ListProtector.get(r102, 0);
    }

    public ReflectUtils field(String r100, Object r101) {
        getField(r100).set(this.object, unwrap(r101));     // Catch: Exception -> L4
        return this;
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    public ReflectUtils method(String r100, Object... r101) throws ReflectException {
        Class<?>[] r102 = getArgsType(r101);
        return method(exactMethod(r100, r102), this.object, r101);
    L5:
        return method(similarMethod(r100, r102), this.object, r101);
    L7:
        e = move-exception;
        throw new ReflectException(e);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_lark_chameleon_util_ReflectUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r105 = access$002(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$002(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    private boolean isSimilarSignature(Method r100, String r101, Class<?>[] r102) {
        if (r100.getName().equals(r101) == true) goto L5;
    L7:
        return false;
    L5:
        if (match(r100.getParameterTypes(), r102) == false) goto L7;
        return true;
    }

    private ReflectUtils method(Method r100, Object r101, Object... r102) {
        accessible(r100);     // Catch: Exception -> L8
        if (r100.getReturnType() != Void.TYPE) goto L7;
        r100.invoke(r101, r102);     // Catch: Exception -> L8
        return reflect(r101);
    L7:
        return reflect(r100.invoke(r101, r102));
    L8:
        e = move-exception;
        throw new ReflectException(e);
    }
}
