package com.larus.audio.call.arch;

import com.larus.audio.call.plugins.s0;
import com.larus.audio.call.plugins.t0;
import com.larus.audio.call.plugins.v0;
import com.larus.audio.call.plugins.y0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes24.dex */
public final class b {
    public static final t0 a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (t0) r100.b(Reflection.getOrCreateKotlinClass(t0.class), null);
    }

    public static final v0 b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (v0) r100.c(Reflection.getOrCreateKotlinClass(v0.class), null);
    }

    public static final s0 c(c r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (s0) r100.b(Reflection.getOrCreateKotlinClass(s0.class), null);
    }

    public static final y0 d(c r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (y0) r100.c(Reflection.getOrCreateKotlinClass(y0.class), null);
    }

    public static final void e(c r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        CoroutineScope r102 = r100.r();
        if (r102 != null) goto L6;
        com.larus.audio.call.util.e.f289645a.e("RealtimePluginKtx", "runInMain called, scope == null");
        return;
    L6:
        BuildersKt.launch$default(r102, Dispatchers.getMain(), null, new CommonLLMPluginKtxKt$runInMain$1(r101, null), 2, null);
    }
}
