package com.bytedance.sdk.xbridge.cn.protocol;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public abstract class MethodFinder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Class<Object> f270054c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f270055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f270056b;

    public static final class a {
    }

    public boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        return true;
    }

    public abstract String f();

    public abstract IDLXBridgeMethod h(String r100);

    static {
        f270054c = Object.class;
    }

    public final ConcurrentHashMap<String, Class<?>> e() {
        return (ConcurrentHashMap) this.f270055a.getValue();
    }

    public final i g() {
        return (i) this.f270056b.getValue();
    }

    public MethodFinder() {
        this.f270055a = LazyKt.lazy(MethodFinder$creatorClassCache$2.INSTANCE);
        this.f270056b = LazyKt.lazy(MethodFinder$statefulMethodCache$2.INSTANCE);
    }

    public void j() {
        g().c();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
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

    public final Class<?> c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Class<?> r101 = e().get(r100);
        Class<?> r102 = f270054c;
        if (r101 != null) goto L10;
        Class<?> r103 = a(com.bytedance.sdk.xbridge.cn.protocol.a.a(r100, f()));     // Catch: Throwable -> L7
        e().put(r100, r103);     // Catch: Throwable -> L7
        return r103;
    L7:
        e().put(r100, r102);
        f();
        return null;
    L10:
        if (Intrinsics.areEqual(r101, r102) == false) goto L12;
        return null;
    L12:
        return r101;
    }

    public IDLXBridgeMethod d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        Intrinsics.checkNotNullParameter(r101, "methodName");
        IDLXBridgeMethod r102 = g().a(r100, r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        if (b(r100) == true) goto L8;
        return null;
    L8:
        IDLXBridgeMethod r103 = i(r100, r101);
        if (r103 != null) goto L11;
        return null;
    L11:
        if ((r103 instanceof h) == false) goto L13;
        g().b(r100, r103);
    L14:
        return r103;
    L13:
        j.f270076c.b(r100, r103);
        goto L14
    }

    public IDLXBridgeMethod i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "namespace");
        Intrinsics.checkNotNullParameter(r101, "methodName");
        return h(r101);
    }
}
