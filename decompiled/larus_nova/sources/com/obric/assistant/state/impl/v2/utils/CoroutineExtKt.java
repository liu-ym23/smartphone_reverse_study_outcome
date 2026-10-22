package com.obric.assistant.state.impl.v2.utils;

import android.os.SystemClock;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes33.dex */
public final class CoroutineExtKt {
    public static final Object a(long r100, Continuation<? super Unit> r110) {
        if ((r110 instanceof CoroutineExtKt$delayAwareOfSleep$1) == false) goto L7;
        CoroutineExtKt$delayAwareOfSleep$1 r101 = (CoroutineExtKt$delayAwareOfSleep$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        long r105 = r101.J$1;
        long r106 = r101.J$0;
        ResultKt.throwOnFailure(r111);
        long r107 = r106;
    L20:
        if (JobKt.isActive(r101.getContext()) == false) goto L28;
        long r108 = SystemClock.elapsedRealtime() - r105;
        if (r108 >= r107) goto L28;
        long r109 = Math.min(2000, r107 - r108);
        r101.J$0 = r107;
        r101.J$1 = r105;
        r101.label = 1;
        if (DelayKt.delay(r109, r101) != r103) goto L20;
        return r103;
    L28:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        if (r100 <= 0) goto L17;
        r107 = r100;
        r105 = SystemClock.elapsedRealtime();
        goto L20
    L17:
        return Unit.INSTANCE;
    L7:
        r101 = new CoroutineExtKt$delayAwareOfSleep$1(r110);
        goto L8
    }
}
