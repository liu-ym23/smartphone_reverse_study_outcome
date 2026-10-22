package com.bytedance.kmp.performance.api;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import md6.f1;

/* JADX INFO: loaded from: classes19.dex */
public final class MemoryCollect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MemoryCollect f252592a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f252593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f252594c = null;

    public MemoryCollect() {
    }

    static {
        f252592a = new MemoryCollect();
        f252593b = com.bytedance.kmp.performance.utils.c.b();
        f252594c = CoroutineScopeKt.MainScope();
    }

    public static void a(g r100, long r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        BuildersKt.launch$default(f252594c, null, null, new MemoryCollect$reportImmediately$1(r101, r100, null), 3, null);
    }

    public final Object b(f1 r110, boolean r111, g r112, Continuation<? super Unit> r113) {
        if ((r113 instanceof MemoryCollect$reportInner$1) == false) goto L7;
        MemoryCollect$reportInner$1 r100 = (MemoryCollect$reportInner$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r114);
    L44:
        f252593b = com.bytedance.kmp.performance.utils.c.b();
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r111 = r100.Z$0;
        r112 = (g) r100.L$1;
        r110 = (f1) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L19:
        com.bytedance.kmp.performance.q r115 = (com.bytedance.kmp.performance.q) r114;
        if (r115.f252819a == true) goto L24;
        return Unit.INSTANCE;
    L24:
        if (((com.bytedance.kmp.performance.utils.c.b() - f252593b) / ((long) 1000)) >= r115.f252822d) goto L29;
        if (r111 == true) goto L29;
        return Unit.INSTANCE;
    L29:
        if (Random.Default.nextDouble() > r115.f252821c) goto L31;
        if (r112 != null) goto L34;
        g r104 = j.f252643a;
        g r105 = j.f252643a;
    L35:
        String r106 = r105.f252637a;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r110.f513326a = r106;
        if (r112 != null) goto L38;
    L41:
        MainCoroutineDispatcher r116 = Dispatchers.getMain().getImmediate();
        MemoryCollect$reportInner$2 r117 = new MemoryCollect$reportInner$2(r112, r110, null);
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 2;
        if (BuildersKt.withContext(r116, r117, r100) != r102) goto L44;
        return r102;
    L38:
        if (r115.f252820b == false) goto L41;
        if (r111 == true) goto L41;
        r110.f513328c = r112.f252640d.c();
        goto L41
    L34:
        r105 = r112;
        goto L35
    L31:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r114);
        r100.L$0 = r110;
        r100.L$1 = r112;
        r100.Z$0 = r111;
        r100.label = 1;
        r114 = BuildersKt.withContext(Dispatchers.getMain(), new MemoryCollect$getConfigAsync$2(null), r100);
        if (r114 != r102) goto L19;
        return r102;
    L7:
        r100 = new MemoryCollect$reportInner$1(this, r113);
        goto L8
    }
}
