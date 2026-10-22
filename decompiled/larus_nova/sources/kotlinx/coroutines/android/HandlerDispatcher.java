package kotlinx.coroutines.android;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.f0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/android/HandlerContext;", "kotlinx-coroutines-android"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class HandlerDispatcher extends MainCoroutineDispatcher implements f0 {
    public /* synthetic */ HandlerDispatcher(DefaultConstructorMarker r100) {
        this();
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public abstract HandlerDispatcher getImmediate();

    public abstract /* synthetic */ void scheduleResumeAfterDelay(long r100, i<? super Unit> r101);

    private HandlerDispatcher() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    public Object delay(long r100, Continuation<? super Unit> r101) {
        if (r100 <= 0) goto L13;
        j r102 = new j(IntrinsicsKt.intercepted(r101), 1);
        r102.C();
        scheduleResumeAfterDelay(r100, r102);
        Object r103 = r102.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L9:
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r103;
    L12:
        return Unit.INSTANCE;
    L13:
        return Unit.INSTANCE;
    }

    public m0 invokeOnTimeout(long r100, Runnable r101, CoroutineContext r102) {
        return d0.f504706a.invokeOnTimeout(r100, r101, r102);
    }
}
