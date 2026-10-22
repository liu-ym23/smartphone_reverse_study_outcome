package com.bytedance.bpea.entry.common;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.TypeCastException;
import me.ele.lancet.base.annotations.Skip;
import qc4.f;

/* JADX INFO: loaded from: classes8.dex */
public final class d {
    static {
        Field r100 = a().getDeclaredField("INSTANCE");     // Catch: Throwable -> L8
        r100.setAccessible(true);     // Catch: Throwable -> L8
        Object r101 = r100.get(null);     // Catch: Throwable -> L8
        if (r101 == null) goto L7;
        ((f) r101).a();     // Catch: Throwable -> L8
        int r102 = qc4.a.f532465a;     // Catch: Throwable -> L8
    L10:
        int r103 = qc4.a.f532465a;
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.bpea.basics.ICorePowerProvider");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.bpea.core.checker.CorePowerProvider");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.bpea.core.checker.CorePowerProvider");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.bpea.core.checker.CorePowerProvider");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.bpea.core.checker.CorePowerProvider");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.bpea.core.checker.CorePowerProvider");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.bpea.core.checker.CorePowerProvider");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.bpea.core.checker.CorePowerProvider");
    }

    public static void b(qc4.c r100) throws BPEAException {
        Iterator<b> r101 = c.f202198a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().c();
        goto L4
    L6:
        CopyOnWriteArraySet<b> r102 = c.f202198a;
        CertCheckerHolder$check$1 r103 = CertCheckerHolder$check$1.INSTANCE;
        b.a r104 = new b.a("invokeStartSuccess");
        Iterator<b> r105 = c.f202198a.iterator();
        String r106 = "";
    L7:
        int r107 = 0;
        boolean r108 = false;
    L9:
        if (r105.hasNext() == false) goto L17;
        r104 = r105.next().a();
        if (r104.a() == false) goto L13;
        r106 = r106 + '_' + r104.f202197b;
    L13:
        if (r108 == true) goto L16;
        if (r104.a() == false) goto L7;
    L16:
        r108 = true;
        goto L9
    L17:
        if (r108 == true) goto L19;
        return;
    L19:
        if (r104.a() == true) goto L22;
        r107 = -1;
    L22:
        r103.invoke(Integer.valueOf(r107), r106);
    }
}
