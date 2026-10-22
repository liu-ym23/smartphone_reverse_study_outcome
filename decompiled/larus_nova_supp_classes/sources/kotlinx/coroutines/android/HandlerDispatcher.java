package kotlinx.coroutines.android;

import android.util.EventsUtils;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/android/HandlerContext;", "kotlinx-coroutines-android"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public abstract class HandlerDispatcher extends MainCoroutineDispatcher implements f0 {
    public /* synthetic */ HandlerDispatcher(DefaultConstructorMarker r1) {
        this();
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public abstract HandlerDispatcher getImmediate();

    public abstract /* synthetic */ void scheduleResumeAfterDelay(long r1, i<? super Unit> r3);

    private HandlerDispatcher() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    public Object delay(long r4, Continuation<? super Unit> r6) {
        if (r4 <= 0) goto L13;
        j r0 = new j(IntrinsicsKt.intercepted(r6), 1);
        r0.C();
        scheduleResumeAfterDelay(r4, r0);
        Object r5 = r0.B();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L9:
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r5;
    L12:
        return Unit.INSTANCE;
    L13:
        return Unit.INSTANCE;
    }

    public m0 invokeOnTimeout(long r2, Runnable r4, CoroutineContext r5) {
        return d0.a.invokeOnTimeout(r2, r4, r5);
    }
}
