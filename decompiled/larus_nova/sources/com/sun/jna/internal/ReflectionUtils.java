package com.sun.jna.internal;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class ReflectionUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Constructor CONSTRUCTOR_LOOKUP_CLASS;
    private static final Logger LOG = null;
    private static final Method METHOD_HANDLES_BIND_TO = null;
    private static final Method METHOD_HANDLES_INVOKE_WITH_ARGUMENTS = null;
    private static final Method METHOD_HANDLES_LOOKUP = null;
    private static final Method METHOD_HANDLES_LOOKUP_FIND_SPECIAL = null;
    private static final Method METHOD_HANDLES_LOOKUP_IN = null;
    private static final Method METHOD_HANDLES_LOOKUP_UNREFLECT_SPECIAL = null;
    private static final Method METHOD_HANDLES_PRIVATE_LOOKUP_IN = null;
    private static final Method METHOD_IS_DEFAULT = null;
    private static final Method METHOD_TYPE = null;

    public ReflectionUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        LOG = Logger.getLogger(ReflectionUtils.class.getName());
        Class r100 = lookupClass("java.lang.invoke.MethodHandles");
        Class r101 = lookupClass("java.lang.invoke.MethodHandle");
        Class r102 = lookupClass("java.lang.invoke.MethodHandles$Lookup");
        Class r103 = lookupClass("java.lang.invoke.MethodType");
        METHOD_IS_DEFAULT = lookupMethod(Method.class, "isDefault", new Class[0]);
        METHOD_HANDLES_LOOKUP = lookupMethod(r100, "lookup", new Class[0]);
        METHOD_HANDLES_LOOKUP_IN = lookupMethod(r102, "in", new Class[]{Class.class});
        METHOD_HANDLES_LOOKUP_UNREFLECT_SPECIAL = lookupMethod(r102, "unreflectSpecial", new Class[]{Method.class, Class.class});
        METHOD_HANDLES_LOOKUP_FIND_SPECIAL = lookupMethod(r102, "findSpecial", new Class[]{Class.class, String.class, r103, Class.class});
        METHOD_HANDLES_BIND_TO = lookupMethod(r101, "bindTo", new Class[]{Object.class});
        METHOD_HANDLES_INVOKE_WITH_ARGUMENTS = lookupMethod(r101, "invokeWithArguments", new Class[]{Object[].class});
        METHOD_HANDLES_PRIVATE_LOOKUP_IN = lookupMethod(r100, "privateLookupIn", new Class[]{Class.class, r102});
        METHOD_TYPE = lookupMethod(r103, "methodType", new Class[]{Class.class, Class[].class});
    }

    private static Object createLookup() throws Exception {
        return METHOD_HANDLES_LOOKUP.invoke(null, new Object[0]);
    }

    private static Constructor getConstructorLookupClass() {
        if (CONSTRUCTOR_LOOKUP_CLASS != null) goto L6;
        CONSTRUCTOR_LOOKUP_CLASS = lookupDeclaredConstructor(lookupClass("java.lang.invoke.MethodHandles$Lookup"), new Class[]{Class.class});
    L6:
        return CONSTRUCTOR_LOOKUP_CLASS;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_sun_jna_internal_ReflectionUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    public static Object getMethodHandle(Method r100) throws Exception {
        return mhViaFindSpecial(createPrivateLookupIn(r100.getDeclaringClass(), createLookup()), r100);
    L6:
        return mhViaUnreflectSpecial(getConstructorLookupClass().newInstance(new Object[]{r100.getDeclaringClass()}), r100);
    }

    public static boolean isDefault(Method r100) {
        Method r101 = METHOD_IS_DEFAULT;
        if (r101 != null) goto L23;
        return false;
    L23:
        return ((Boolean) r101.invoke(r100, new Object[0])).booleanValue();
    L20:
        e = e;
    L22:
        throw new RuntimeException(e);
    L18:
        e = e;
    L7:
        e = move-exception;
        Throwable r102 = e.getCause();
        if ((r102 instanceof RuntimeException) == true) goto L17;
        if ((r102 instanceof Error) == false) goto L15;
        throw ((Error) r102);
    L15:
        throw new RuntimeException(r102);
    L17:
        throw ((RuntimeException) r102);
    }

    private static Class lookupClass(String r100) {
        return INVOKESTATIC_com_sun_jna_internal_ReflectionUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);
    L4:
        e = move-exception;
        LOG.log(Level.FINE, "Failed to lookup class: " + r100, e);
        return null;
    }

    private static Object createPrivateLookupIn(Class r100, Object r101) throws Exception {
        return METHOD_HANDLES_PRIVATE_LOOKUP_IN.invoke(null, new Object[]{r100, r101});
    }

    private static Constructor lookupDeclaredConstructor(Class r100, Class... r101) {
        if (r100 != null) goto L10;
        LOG.log(Level.FINE, "Failed to lookup method: <init>#{1}({2})", new Object[]{r100, Arrays.toString(r101)});
        return null;
    L10:
        Constructor r102 = r100.getDeclaredConstructor(r101);     // Catch: Exception -> L8
        r102.setAccessible(true);     // Catch: Exception -> L8
        return r102;
    L8:
        LOG.log(Level.FINE, "Failed to lookup method: <init>#{1}({2})", new Object[]{r100, Arrays.toString(r101)});
        return null;
    }

    private static Object mhViaFindSpecial(Object r100, Method r101) throws Exception {
        return METHOD_HANDLES_LOOKUP_FIND_SPECIAL.invoke(r100, new Object[]{r101.getDeclaringClass(), r101.getName(), METHOD_TYPE.invoke(null, new Object[]{r101.getReturnType(), r101.getParameterTypes()}), r101.getDeclaringClass()});
    }

    private static Object mhViaUnreflectSpecial(Object r100, Method r101) throws Exception {
        Object r102 = METHOD_HANDLES_LOOKUP_IN.invoke(r100, new Object[]{r101.getDeclaringClass()});
        return METHOD_HANDLES_LOOKUP_UNREFLECT_SPECIAL.invoke(r102, new Object[]{r101, r101.getDeclaringClass()});
    }

    public static Object invokeDefaultMethod(Object r100, Object r101, Object... r102) throws Throwable {
        Object r103 = METHOD_HANDLES_BIND_TO.invoke(r101, new Object[]{r100});
        return METHOD_HANDLES_INVOKE_WITH_ARGUMENTS.invoke(r103, new Object[]{r102});
    }

    private static Method lookupMethod(Class r100, String r101, Class... r110) {
        if (r100 != null) goto L10;
        LOG.log(Level.FINE, "Failed to lookup method: {0}#{1}({2})", new Object[]{r100, r101, Arrays.toString(r110)});
        return null;
    L10:
        return r100.getMethod(r101, r110);
    L8:
        LOG.log(Level.FINE, "Failed to lookup method: {0}#{1}({2})", new Object[]{r100, r101, Arrays.toString(r110)});
        return null;
    }
}
