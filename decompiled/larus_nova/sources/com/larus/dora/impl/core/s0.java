package com.larus.dora.impl.core;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes27.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s0 f332257a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f332258b = null;

    public s0() {
    }

    static {
        f332257a = new s0();
        f332258b = new AtomicInteger(0);
    }

    public final Object a(qk4.b r110, long r111, Continuation r112) {
        if ((r112 instanceof DoraRequestX$request$2) == false) goto L7;
        DoraRequestX$request$2 r100 = (DoraRequestX$request$2) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        long r105 = r100.J$0;
        int r106 = r100.I$0;
        qk4.e r107 = (qk4.e) r100.L$0;
        ResultKt.throwOnFailure(r102);
        long r108 = r105;
        int r109 = r106;
        qk4.e r113 = r107;
    L18:
        v39.b r114 = (v39.b) r102;
        if (r114 != null) goto L22;
        b(r109, r113, r108, true, "timeout");
        return v39.b.e.f552960b;
    L22:
        return r114;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        int r115 = f332258b.incrementAndGet();
        AtomicBoolean r116 = new AtomicBoolean(false);
        long r117 = SystemClock.elapsedRealtime();
        DoraRequestX$request$$inlined$suspendCoroutineWithTimeoutOrNull$1 r118 = new DoraRequestX$request$$inlined$suspendCoroutineWithTimeoutOrNull$1(null, r115, r110, r116, r117);
        r100.L$0 = r110;
        r100.I$0 = r115;
        r100.J$0 = r117;
        r100.label = 1;
        Object r119 = TimeoutKt.c(r111, r118, r100);
        if (r119 != r103) goto L17;
        return r103;
    L17:
        r109 = r115;
        r102 = r119;
        r113 = r110;
        r108 = r117;
    L7:
        r100 = new DoraRequestX$request$2(this, r112);
        goto L8
    }

    public static /* synthetic */ void c(int r100, qk4.e r101, long r102, String r110) {
        b(r100, r101, r102, false, r110);
    }

    public static final void b(int r100, qk4.e r101, long r102, boolean r103, String r104) {
        if (r103 == false) goto L5;
        g49.d.e("DoraRequestX", "id: " + r100 + ", " + r101 + ", " + r104 + ", cost: " + (SystemClock.elapsedRealtime() - r102));
        return;
    L5:
        g49.d.d("DoraRequestX", "id: " + r100 + ", " + r101 + ", " + r104 + ", cost: " + (SystemClock.elapsedRealtime() - r102));
    }
}
