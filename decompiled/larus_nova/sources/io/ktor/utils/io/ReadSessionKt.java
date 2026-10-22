package io.ktor.utils.io;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes41.dex */
public final class ReadSessionKt {
    public static final Object b(ByteReadChannel r100, int r101, ContinuationImpl r102) {
        if ((r100 instanceof t) == false) goto L6;
        t r103 = (t) r100;
    L9:
        if (r103 == null) goto L16;
        io.ktor.utils.io.core.internal.a r104 = r103.a(RangesKt.coerceAtMost(r101, 8));
        if (r104 == null) goto L14;
        return r104;
    L14:
        return d(r103, r101, r102);
    L16:
        return c(r100, r101, r102);
    L6:
        if ((r100 instanceof n) == false) goto L8;
        r103 = ((n) r100).H();
        goto L9
    L8:
        r103 = null;
        goto L9
    }

    public static final Object c(ByteReadChannel r110, int r111, Continuation<? super io.ktor.utils.io.core.internal.a> r112) {
        if ((r112 instanceof ReadSessionKt$requestBufferFallback$1) == false) goto L7;
        ReadSessionKt$requestBufferFallback$1 r100 = (ReadSessionKt$requestBufferFallback$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ReadSessionKt$requestBufferFallback$1 r102 = r100;
        Object r113 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        io.ktor.utils.io.core.internal.a r114 = (io.ktor.utils.io.core.internal.a) r102.L$0;
        ResultKt.throwOnFailure(r113);
    L18:
        r114.a((int) ((Number) r113).longValue());
        return r114;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        AtomicReferenceFieldUpdater r115 = io.ktor.utils.io.core.internal.a.f492027j;
        io.ktor.utils.io.core.internal.a r116 = io.ktor.utils.io.core.c.f492026a.Q5();
        ByteBuffer r105 = r116.f492020a;
        int r106 = r116.f492022c;
        long r117 = r116.f492024e - r106;
        r102.L$0 = r116;
        r102.label = 1;
        Object r118 = r110.i(r105, r106, r111, r117, r102);
        if (r118 != r103) goto L17;
        return r103;
    L17:
        r113 = r118;
        r114 = r116;
    L7:
        r100 = new ReadSessionKt$requestBufferFallback$1(r112);
        goto L8
    }

    public static final Object d(t r100, int r101, Continuation<? super io.ktor.utils.io.core.a> r102) {
        if ((r102 instanceof ReadSessionKt$requestBufferSuspend$1) == false) goto L7;
        ReadSessionKt$requestBufferSuspend$1 r103 = (ReadSessionKt$requestBufferSuspend$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r100 = (t) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L18:
        return r100.a(1);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.label = 1;
        if (r100.f(r101, r103) != r106) goto L18;
        return r106;
    L7:
        r103 = new ReadSessionKt$requestBufferSuspend$1(r102);
        goto L8
    }

    public static final Object a(ByteReadChannel r100, io.ktor.utils.io.core.a r101, int r102, ContinuationImpl r103) {
        if (r102 < 0) goto L4;
        boolean r104 = true;
    L5:
        if (r104 == false) goto L28;
        boolean r105 = r100 instanceof n;
        if (r105 == false) goto L9;
        t r106 = ((n) r100).H();
    L10:
        if (r106 == null) goto L17;
        r106.b(r102);
        if (r105 == false) goto L15;
        ((n) r100).C();
    L15:
        return Unit.INSTANCE;
    L17:
        if ((r101 instanceof io.ktor.utils.io.core.internal.a) == false) goto L26;
        if (r101 == io.ktor.utils.io.core.internal.a.f492030m) goto L26;
        ((io.ktor.utils.io.core.internal.a) r101).k(io.ktor.utils.io.core.c.f492026a);
        Object r107 = r100.p(r102, r103);
        if (r107 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        return r107;
    L24:
        return Unit.INSTANCE;
    L26:
        return Unit.INSTANCE;
    L9:
        r106 = null;
        goto L10
    L28:
        throw new IllegalStateException(("bytesRead shouldn't be negative: " + r102).toString());
    L4:
        r104 = false;
        goto L5
    }
}
