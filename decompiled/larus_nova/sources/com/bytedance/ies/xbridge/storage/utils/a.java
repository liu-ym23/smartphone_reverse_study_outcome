package com.bytedance.ies.xbridge.storage.utils;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p56.d;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @JvmStatic
    public static final d a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        NativeStorageImpl.Companion r101 = NativeStorageImpl.f249535c;
        Context r102 = r100.getApplicationContext();
        ?? r103 = r101.f249540b;
        if (r103 != 0) goto L13;
        monitor-enter(r101);
        Object r104 = r101.f249540b;     // Catch: Throwable -> L14
        if (r104 == null) goto L9;
        r103 = r104;
    L11:
        monitor-exit(r101);
        goto L13
    L9:
        Function1 r105 = r101.f249539a;     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L14
        ?? r106 = r105.invoke(r102);     // Catch: Throwable -> L14
        r101.f249540b = r106;     // Catch: Throwable -> L14
        r101.f249539a = null;     // Catch: Throwable -> L14
        r103 = r106;
    L14:
        th = move-exception;
        throw th;
    L13:
        return (d) r103;
    }
}
