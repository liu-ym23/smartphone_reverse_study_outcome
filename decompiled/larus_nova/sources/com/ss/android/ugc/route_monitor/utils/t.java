package com.ss.android.ugc.route_monitor.utils;

import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f454783a = 0;

    static {
    }

    public static Object a(Object r100, String r101) {
        Class<?> r102 = r100.getClass();     // Catch: Throwable -> L19
        Field r103 = null;
    L5:
        if (r102 == null) goto L15;
        if ((!Intrinsics.areEqual(r102.getName(), Object.class.getName())) == false) goto L15;
        r103 = r102.getDeclaredField(r101);     // Catch: Exception -> L11 Throwable -> L19
    L12:
        if (r103 != null) goto L15;
        r102 = r102.getSuperclass();     // Catch: Throwable -> L19
    L11:
        r103 = null;
    L15:
        if (r103 == null) goto L18;
        r103.setAccessible(true);     // Catch: Throwable -> L19
        return r103.get(r100);
    L18:
        return null;
    }
}
