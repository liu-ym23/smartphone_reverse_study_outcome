package com.bytedance.sdk.xbridge.cn.protocol;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public final class XBridge3MethodFinder extends MethodFinder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f270057d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final String f() {
        return "xbridge3";
    }

    public XBridge3MethodFinder() {
        this.f270057d = LazyKt.lazy(XBridge3MethodFinder$creatorClassCacheWithBiz$2.INSTANCE);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class k(String r100) throws ClassNotFoundException {
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

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        if (Intrinsics.areEqual("webcast", r100) == false) goto L5;
        return true;
    L5:
        if (Intrinsics.areEqual("host", r100) == false) goto L8;
        return true;
    L8:
        return gd7.a.f480945a.contains(r100);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final IDLXBridgeMethod h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        return m("", r100);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final IDLXBridgeMethod i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "namespace");
        Intrinsics.checkNotNullParameter(r101, "methodName");
        if (Intrinsics.areEqual("webcast", r100) == true) goto L10;
        if (Intrinsics.areEqual("host", r100) == true) goto L10;
        return m(r100, r101);
    L10:
        return m("", r101);
    }

    public final Class<?> l(String r110, String r111) {
        if (((ConcurrentHashMap) this.f270057d.getValue()).get(r110) != null) goto L5;
        ConcurrentHashMap r100 = new ConcurrentHashMap(100);
        ((ConcurrentHashMap) this.f270057d.getValue()).put(r110, r100);
    L6:
        Class<?> r101 = (Class) r100.get(r111);
        Class<Object> r102 = MethodFinder.f270054c;
        if (r101 != null) goto L22;
        if (r110 != null) goto L10;
    L13:
        boolean r103 = true;
    L14:
        if (r103 == false) goto L16;
        String r112 = com.bytedance.sdk.xbridge.cn.protocol.a.a(r111, "xbridge3");
    L25:
        Class<?> r113 = k(r112);     // Catch: Throwable -> L19
        r100.put(r111, r113);     // Catch: Throwable -> L19
        return r113;
    L19:
        r100.put(r111, r102);
        return null;
    L16:
        int r104 = com.bytedance.sdk.xbridge.cn.protocol.a.f270058a;
        Intrinsics.checkNotNullParameter(r110, "namespace");
        Intrinsics.checkNotNullParameter(r111, "methodName");
        r112 = "com.bytedance.xbridge.cn.gen.xbridge3_" + r110 + "_Creator_" + StringsKt.replace$default(r111, ".", "_", false, 4, null);
        goto L25
    L10:
        if (r110.length() == 0) goto L13;
        r103 = false;
        goto L14
    L22:
        if (Intrinsics.areEqual(r101, r102) == false) goto L24;
        return null;
    L24:
        return r101;
    L5:
        Object r105 = ((ConcurrentHashMap) this.f270057d.getValue()).get(r110);
        Intrinsics.checkNotNull(r105);
        r100 = (ConcurrentHashMap) r105;
        goto L6
    }

    public final IDLXBridgeMethod m(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "namespace");
        Intrinsics.checkNotNullParameter(r101, "methodName");
        Class<?> r102 = l(r100, r101);     // Catch: Throwable -> L8
        if (r102 != null) goto L6;
        return null;
    L6:
        Method r103 = r102.getDeclaredMethod("create", new Class[0]);     // Catch: Throwable -> L8
        r103.setAccessible(true);     // Catch: Throwable -> L8
        return (IDLXBridgeMethod) r103.invoke(null, new Object[0]);
    L9:
        return null;
    }
}
