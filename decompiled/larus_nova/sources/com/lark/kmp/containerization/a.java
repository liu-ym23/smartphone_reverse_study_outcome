package com.lark.kmp.containerization;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<d<?>, c<?>> f278584a = null;

    static {
        f278584a = new LinkedHashMap();
    }

    public static c a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Object r101 = ((LinkedHashMap) f278584a).get(r100);
        if ((r101 instanceof c) == false) goto L5;
        c r102 = (c) r101;
    L6:
        if (r102 == null) goto L9;
        return r102;
    L9:
        throw new IllegalArgumentException("Scope " + Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName() + " not initialize");
    L5:
        r102 = null;
        goto L6
    }
}
