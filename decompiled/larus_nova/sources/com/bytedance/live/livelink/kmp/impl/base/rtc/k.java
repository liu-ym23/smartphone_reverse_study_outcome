package com.bytedance.live.livelink.kmp.impl.base.rtc;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class k implements InvocationHandler {
    public k() {
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r101, Object[] r102) {
        Intrinsics.checkNotNullParameter(r100, "proxy");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        boolean r103 = false;
        if (r102 != null) goto L6;
        r102 = new Object[0];
    L6:
        if (r102.length != 0) goto L8;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L18;
        if (Intrinsics.areEqual(r101.getName(), "EglContextDestoryStart") == false) goto L18;
        int r105 = ej6.a.f472874a;
        ej6.a.a("CommonRTCEngineManager", "invoke method: " + r101.getName());
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r106 = ILiveWrappedLivePusher.a.b();
        if (r106 == null) goto L16;
        r106.getGLThreadManager();
    L16:
        return r100;
    L18:
        if (r102.length != 0) goto L20;
        boolean r107 = true;
    L21:
        if (r107 == false) goto L29;
        if (Intrinsics.areEqual(r101.getName(), "EglContextDestoryEnd") == false) goto L29;
        int r108 = ej6.a.f472874a;
        ej6.a.a("CommonRTCEngineManager", "invoke method: " + r101.getName());
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r109 = ILiveWrappedLivePusher.a.b();
        if (r109 == null) goto L27;
        r109.getGLThreadManager();
    L27:
        return r100;
    L29:
        if (r102.length != 0) goto L31;
        boolean r110 = true;
    L32:
        if (r110 == false) goto L38;
        if (Intrinsics.areEqual(r101.getName(), "hashCode") == false) goto L38;
        return Integer.valueOf(hashCode());
    L38:
        if (r102.length != 1) goto L66;
        if (Intrinsics.areEqual(r101.getName(), "equals") == false) goto L66;
        if (Intrinsics.areEqual(r101.getParameterTypes()[0], Object.class) == false) goto L66;
        Object r111 = r102[0];
        if (r111 == null) goto L46;
        if (r100 == r111) goto L49;
        Class<?> r112 = r100.getClass();
        if (r112.isInstance(r111) == false) goto L53;
    L58:
        boolean r113 = true;
    L59:
        if (r113 == false) goto L64;
        if (equals(Proxy.getInvocationHandler(r111)) == false) goto L64;
        r103 = true;
    L64:
        return Boolean.valueOf(r103);
    L53:
        if (Proxy.isProxyClass(r111.getClass()) == true) goto L55;
    L57:
        r113 = false;
        goto L59
    L55:
        if (Arrays.equals(r111.getClass().getInterfaces(), r112.getInterfaces()) == false) goto L57;
    L49:
        return Boolean.TRUE;
    L46:
        return Boolean.FALSE;
    L66:
        if (r102.length != 0) goto L68;
        r103 = true;
    L68:
        if (r103 == true) goto L70;
        return r100;
    L70:
        if (Intrinsics.areEqual(r101.getName(), "toString") == true) goto L72;
        return r100;
    L72:
        return toString();
    L31:
        r110 = false;
        goto L32
    L20:
        r107 = false;
        goto L21
    L8:
        r104 = false;
        goto L10
    }
}
