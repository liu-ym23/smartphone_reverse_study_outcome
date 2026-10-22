package com.bytedance.tools.kcp.modelx.runtime.internal.reflect;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b {
    public static final boolean a(Method r100, Method r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$matches");
        Intrinsics.checkNotNullParameter(r101, "other");
        if ((!Intrinsics.areEqual(r100.getName(), r101.getName())) == false) goto L5;
        return false;
    L5:
        if (r102 == false) goto L10;
        if ((!Intrinsics.areEqual(r100.getReturnType(), r101.getReturnType())) == false) goto L10;
        return false;
    L10:
        if (r100.getParameterTypes().length == r101.getParameterTypes().length) goto L12;
        return false;
    L12:
        int r103 = 0;
    L14:
        if (r103 >= r100.getParameterTypes().length) goto L19;
        if ((!Intrinsics.areEqual(r100.getParameterTypes()[r103], r101.getParameterTypes()[r103])) == true) goto L17;
        r103 = r103 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    }
}
