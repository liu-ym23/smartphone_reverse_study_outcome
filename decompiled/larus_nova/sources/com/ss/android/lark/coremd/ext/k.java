package com.ss.android.lark.coremd.ext;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<?>, Object> f419620a = null;

    static {
        f419620a = new ConcurrentHashMap();
    }

    public static Object a(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        ConcurrentHashMap<Class<?>, Object> r101 = f419620a;
        Object r102 = r101.get(r100);
        if (r102 != null) goto L9;
        Object r103 = r100.getConstructor(new Class[0]).newInstance(new Object[0]);
        Object r104 = r101.putIfAbsent(r100, r103);
        if (r104 != null) goto L8;
        return r103;
    L8:
        return r104;
    L9:
        return r102;
    }
}
