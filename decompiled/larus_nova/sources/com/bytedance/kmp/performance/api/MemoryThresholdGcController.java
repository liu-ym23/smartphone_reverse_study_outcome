package com.bytedance.kmp.performance.api;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import md6.f1;

/* JADX INFO: loaded from: classes19.dex */
public final class MemoryThresholdGcController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f252595a;

    public static final class a {
    }

    static {
    }

    public MemoryThresholdGcController() {
        this.f252595a = -1;
    }

    public final Object a(f1 r110, com.bytedance.kmp.performance.r r111, gb6.c r210, Continuation<? super Unit> r211) {
        f1 r100 = r110;
        com.bytedance.kmp.performance.r r101 = r111;
        gb6.c r102 = r210;
        if ((r211 instanceof MemoryThresholdGcController$triggerIfNeeded$1) == false) goto L7;
        MemoryThresholdGcController$triggerIfNeeded$1 r103 = (MemoryThresholdGcController$triggerIfNeeded$1) r211;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        String r108 = null;
        if (r107 == 0) goto L18;
        if (r107 != 1) goto L17;
        long r109 = r103.J$0;
        r102 = (gb6.c) r103.L$2;
        com.bytedance.kmp.performance.r r112 = (com.bytedance.kmp.performance.r) r103.L$1;
        f1 r113 = (f1) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L14
        String r114 = "last_threshold_gc_timestamp";
        long r115 = r109;
        r100 = r113;
        r101 = r112;
    L44:
        Object r116 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L46
        final com.bytedance.kmp.performance.r r117 = r101;
        final long r118 = r115;
        final f1 r119 = r100;
    L50:
        if (Result.m9455isFailureimpl(r116) == false) goto L56;
        ld6.a r120 = ld6.b.f508697a;
        StringBuilder r121 = new StringBuilder("KPerf: ");
        StringBuilder r122 = new StringBuilder("memory threshold GC failed: ");
        Throwable r123 = Result.m9452exceptionOrNullimpl(r116);
        if (r123 == null) goto L54;
        r108 = r123.getMessage();
    L54:
        r122.append(r108);
        r121.append(r122.toString());
        System.out.println(r121.toString());
        return Unit.INSTANCE;
    L56:
        final long r124 = com.bytedance.kmp.performance.utils.c.b();
        this.f252595a = r124;
        if (r102 == null) goto L59;
        r102.storeLong(r114, r124);
    L59:
        ld6.a.a(ld6.b.f508697a, new t(r119, r117, r124, r118));
        return Unit.INSTANCE;
    L46:
        Throwable th10 = th;
        r113 = r100;
        r112 = r101;
        r109 = r115;
    L48:
        Result.Companion r125 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        r118 = r109;
        r119 = r113;
        r117 = r112;
    L14:
        th10 = th;
        r114 = "last_threshold_gc_timestamp";
        goto L48
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r105);
        long r126 = com.bytedance.kmp.performance.utils.c.b();
        long r127 = -1;
        if (r102 == null) goto L21;
        r127 = r102.getLong("last_threshold_gc_timestamp", -1);
    L21:
        r114 = "last_threshold_gc_timestamp";
        long r128 = Math.max(this.f252595a, r127);
        Intrinsics.checkNotNullParameter(r100, "memoryInfo");
        Intrinsics.checkNotNullParameter(r101, "config");
        if (r101.f252829d == false) goto L36;
        Intrinsics.checkNotNullParameter(r100, "memoryInfo");
        long r129 = 1024;
        if (((r100.f513338m / r129) / r129) < r101.f252827b) goto L26;
        boolean r130 = true;
    L27:
        if (r130 == false) goto L36;
        if (r128 >= 0) goto L33;
    L34:
        boolean r131 = true;
    L37:
        if (r131 == false) goto L39;
        r115 = com.bytedance.kmp.performance.utils.c.b();
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L46
        CoroutineDispatcher r133 = Dispatchers.getDefault();     // Catch: Throwable -> L46
        MemoryThresholdGcController$triggerIfNeeded$result$1$1 r134 = new MemoryThresholdGcController$triggerIfNeeded$result$1$1(null);     // Catch: Throwable -> L46
        r103.L$0 = r100;     // Catch: Throwable -> L46
        r103.L$1 = r101;     // Catch: Throwable -> L46
        r103.L$2 = r102;     // Catch: Throwable -> L46
        r103.J$0 = r115;     // Catch: Throwable -> L46
        r103.label = 1;     // Catch: Throwable -> L46
        if (BuildersKt.withContext(r133, r134, r103) != r106) goto L44;
        return r106;
    L39:
        return Unit.INSTANCE;
    L33:
        if ((r126 - r128) < (((long) RangesKt.coerceAtLeast(r101.f252830e, 0)) * 60000)) goto L36;
    L26:
        r130 = false;
    L36:
        r131 = false;
    L7:
        r103 = new MemoryThresholdGcController$triggerIfNeeded$1(this, r211);
        goto L8
    }
}
