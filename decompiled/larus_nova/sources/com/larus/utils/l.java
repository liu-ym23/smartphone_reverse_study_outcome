package com.larus.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<Object, Map<String, Object>> f375429a = null;

    static {
        f375429a = new WeakHashMap();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Extras.kt uses a process-global weak-key cache, but values are strongly referenced and may leak lifecycle-bound objects. Do not add new usages. Use explicit fields, lifecycle-bound state, View.setTag(id, value), or a module-owned cache with clear cleanup instead.")
    public static final void a(rt8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Result.m9449constructorimpl(f375429a.remove(r100));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Extras.kt uses a process-global weak-key cache, but values are strongly referenced and may leak lifecycle-bound objects. Do not add new usages. Use explicit fields, lifecycle-bound state, View.setTag(id, value), or a module-owned cache with clear cleanup instead.")
    public static final <T> T b(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        WeakHashMap<Object, Map<String, Object>> r102 = f375429a;
        monitor-enter(r102);
        Map<String, Object> r103 = r102.get(r100);     // Catch: Throwable -> L12
        if (r103 == null) goto L9;
        T r104 = (T) r103.get(r101);
        if (r104 == null) goto L9;
    L10:
        monitor-exit(r102);
        return r104;
    L9:
        r104 = null;
    L12:
        th = move-exception;
        throw th;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Extras.kt uses a process-global weak-key cache, but values are strongly referenced and may leak lifecycle-bound objects. Do not add new usages. Use explicit fields, lifecycle-bound state, View.setTag(id, value), or a module-owned cache with clear cleanup instead.")
    public static final void d(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        WeakHashMap<Object, Map<String, Object>> r102 = f375429a;
        monitor-enter(r102);
        Map<String, Object> r103 = r102.get(r100);     // Catch: Throwable -> L11
        if (r103 == null) goto L8;
        r103.remove(r101);     // Catch: Throwable -> L11
    L8:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r102);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Extras.kt uses a process-global weak-key cache, but values are strongly referenced and may leak lifecycle-bound objects. Do not add new usages. Use explicit fields, lifecycle-bound state, View.setTag(id, value), or a module-owned cache with clear cleanup instead.")
    public static final void c(Object r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        WeakHashMap<Object, Map<String, Object>> r103 = f375429a;
        monitor-enter(r103);
        Map<String, Object> r104 = r103.get(r100);     // Catch: Throwable -> L10
        if (r104 != null) goto L7;
        r104 = new LinkedHashMap();     // Catch: Throwable -> L10
        r103.put(r100, r104);     // Catch: Throwable -> L10
    L7:
        r104.put(r101, r102);     // Catch: Throwable -> L10
        monitor-exit(r103);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
