package com.google.gson.internal;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public abstract class UnsafeAllocator {
    public static final UnsafeAllocator INSTANCE = null;

    public UnsafeAllocator() {
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public abstract <T> T newInstance(Class<T> r100) throws Exception;

    private static UnsafeAllocator create() {
        Class r100 = INVOKESTATIC_com_google_gson_internal_UnsafeAllocator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("sun.misc.Unsafe");     // Catch: Exception -> L5
        Field r101 = r100.getDeclaredField("theUnsafe");     // Catch: Exception -> L5
        r101.setAccessible(true);     // Catch: Exception -> L5
        final Object r102 = r101.get(null);     // Catch: Exception -> L5
        final Method r103 = r100.getMethod("allocateInstance", new Class[]{Class.class});     // Catch: Exception -> L5
        return new AnonymousClass1(r103, r102);
    L14:
        Method r104 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});     // Catch: Exception -> L8
        r104.setAccessible(true);     // Catch: Exception -> L8
        final int r105 = ((Integer) r104.invoke(null, new Object[]{Object.class})).intValue();     // Catch: Exception -> L8
        final Method r106 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});     // Catch: Exception -> L8
        r106.setAccessible(true);     // Catch: Exception -> L8
        return new AnonymousClass2(r106, r105);
    L8:
        final Method r107 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});     // Catch: Exception -> L10
        r107.setAccessible(true);     // Catch: Exception -> L10
        return new AnonymousClass3(r107);
    L11:
        return new AnonymousClass4();
    }

    static {
        INSTANCE = create();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_google_gson_internal_UnsafeAllocator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static /* synthetic */ void access$000(Class r100) {
        assertInstantiable(r100);
    }

    private static void assertInstantiable(Class<?> r100) {
        String r101 = ConstructorConstructor.checkInstantiable(r100);
        if (r101 != null) goto L6;
        return;
    L6:
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(r101));
    }
}
