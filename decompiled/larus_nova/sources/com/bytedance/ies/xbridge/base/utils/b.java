package com.bytedance.ies.xbridge.base.utils;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @JvmStatic
    public static final p56.d a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        NativeStorageImpl.Companion r101 = NativeStorageImpl.f249451b;
        ?? r102 = r101.f249455b;
        if (r102 != 0) goto L13;
        monitor-enter(r101);
        Object r103 = r101.f249455b;     // Catch: Throwable -> L14
        if (r103 == null) goto L9;
        r102 = r103;
    L11:
        monitor-exit(r101);
        goto L13
    L9:
        Function1 r104 = r101.f249454a;     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L14
        ?? r105 = r104.invoke(r100);     // Catch: Throwable -> L14
        r101.f249455b = r105;     // Catch: Throwable -> L14
        r101.f249454a = null;     // Catch: Throwable -> L14
        r102 = r105;
    L14:
        th = move-exception;
        throw th;
    L13:
        return (p56.d) r102;
    }
}
