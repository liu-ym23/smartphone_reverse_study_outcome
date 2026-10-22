package com.ss.android.eventbus.collector;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.eventbus.EventBus;
import com.ss.android.eventbus.LRUCache;
import com.xiaomi.mipush.sdk.MiPushClient;
import el9.a;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class CollectorCompileImpl implements ICollector {
    private static final String TAG = "CollectorCompileImpl";
    private static final Map<String, Method> sClassName2RegisterMethodMap = null;

    public CollectorCompileImpl() {
    }

    static {
        sClassName2RegisterMethodMap = new LRUCache(10);
    }

    private static Class<?> getSuperclass(Class<?> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Class<? super Object> r101 = r100.getSuperclass();
        String r102 = r101.getName();
        if (r102.startsWith("java.") == false) goto L8;
        return null;
    L8:
        if (r102.startsWith("javax.") == false) goto L10;
        return null;
    L10:
        if (r102.startsWith("android.") == false) goto L13;
        return null;
    L13:
        return r101;
    }

    @Override // com.ss.android.eventbus.collector.ICollector
    public void register(Object r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Class<?> r101 = r100.getClass();
    L5:
        if (r101 == null) goto L7;
        registerInternal(r100, r101.getName());
        r101 = getSuperclass(r101);
        goto L5
    }

    @Override // com.ss.android.eventbus.collector.ICollector
    public void unRegister(Object r100) {
        EventBus.getDefault().unregister(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_ss_android_eventbus_collector_CollectorCompileImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    private void registerInternal(Object r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L6;
        return;
    L6:
        Method r102 = sClassName2RegisterMethodMap.get(r101);
        if (r102 == null) goto L26;
        r102.invoke(null, new Object[]{r100});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    L26:
        Class r103 = INVOKEVIRTUAL_com_ss_android_eventbus_collector_CollectorCompileImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r100.getClass().getClassLoader(), r101 + "_Subscriber");     // Catch: Throwable -> L21
        if (r103 != null) goto L16;
        return;
    L16:
        Method r104 = r103.getDeclaredMethod(MiPushClient.COMMAND_REGISTER, new Class[]{Object.class});     // Catch: Throwable -> L21
        if (r104 != null) goto L19;
        return;
    L19:
        r104.invoke(null, new Object[]{r100});     // Catch: Throwable -> L21
        sClassName2RegisterMethodMap.put(r101, r104);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
    }
}
