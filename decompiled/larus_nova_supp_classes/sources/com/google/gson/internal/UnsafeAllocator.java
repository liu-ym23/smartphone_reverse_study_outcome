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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class UnsafeAllocator {
    public static final UnsafeAllocator INSTANCE = null;

    public UnsafeAllocator() {
    }

    public static /* synthetic */ Class access$001(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public abstract <T> T newInstance(Class<T> r1) throws Exception;

    private static UnsafeAllocator create() {
        Class r4 = INVOKESTATIC_com_google_gson_internal_UnsafeAllocator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("sun.misc.Unsafe");     // Catch: Exception -> L5
        Field r5 = r4.getDeclaredField("theUnsafe");     // Catch: Exception -> L5
        r5.setAccessible(true);     // Catch: Exception -> L5
        final Object r6 = r5.get(null);     // Catch: Exception -> L5
        final Method r7 = r4.getMethod("allocateInstance", new Class[]{Class.class});     // Catch: Exception -> L5
        return new AnonymousClass1(r7, r6);
    L14:
        Method r8 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});     // Catch: Exception -> L8
        r8.setAccessible(true);     // Catch: Exception -> L8
        int r1 = ((Integer) r8.invoke(null, new Object[]{Object.class})).intValue();     // Catch: Exception -> L8
        Method r9 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});     // Catch: Exception -> L8
        r9.setAccessible(true);     // Catch: Exception -> L8
        return new 2(r9, r1);
    L8:
        Method r0 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});     // Catch: Exception -> L10
        r0.setAccessible(true);     // Catch: Exception -> L10
        return new 3(r0);
    L11:
        return new 4();
    }

    static {
        INSTANCE = create();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_google_gson_internal_UnsafeAllocator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$001(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$001(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static /* synthetic */ void access$000(Class r0) {
        assertInstantiable(r0);
    }

    private static void assertInstantiable(Class<?> r2) {
        String r3 = ConstructorConstructor.checkInstantiable(r2);
        if (r3 != null) goto L6;
        return;
    L6:
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(r3));
    }
}
