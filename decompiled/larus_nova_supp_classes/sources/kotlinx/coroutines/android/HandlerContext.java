package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.i;
import kotlinx.coroutines.l1;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class HandlerContext extends HandlerDispatcher {
    public final Handler a;
    public final String b;
    public final boolean c;
    public final HandlerContext d;

    public HandlerContext() {
        throw null;
    }

    public final int hashCode() {
        int r0 = System.identityHashCode(this.a);
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 ^ r1;
    L5:
        r1 = 1237;
        goto L7
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        String r0 = toStringInternalImpl();
        if (r0 != null) goto L11;
        String r1 = this.b;
        if (r1 != null) goto L8;
        r1 = this.a.toString();
    L8:
        if (this.c == true) goto L10;
        return r1;
    L10:
        return r1 + ".immediate";
    L11:
        return r0;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public final MainCoroutineDispatcher getImmediate() {
        return this.d;
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.MainCoroutineDispatcher
    public final HandlerDispatcher getImmediate() {
        return this.d;
    }

    public HandlerContext(Handler r3) {
        this(r3, null, false);
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof HandlerContext) == false) goto L9;
        HandlerContext r4 = (HandlerContext) r3;
        if (r4.a != this.a) goto L9;
        if (r4.c != this.c) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isDispatchNeeded(CoroutineContext r2) {
        if (this.c == true) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(Looper.myLooper(), this.a.getLooper()) == false) goto L8;
        return false;
    }

    public final void d(CoroutineContext r4, Runnable r5) {
        JobKt.cancel(r4, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        Dispatchers.getIO().dispatch(r4, r5);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext r2, Runnable r3) {
        if (this.a.post(r3) == true) goto L6;
        d(r2, r3);
        return;
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.f0
    public final void scheduleResumeAfterDelay(long r5, i<? super Unit> r7) {
        Runnable r0 = new a(r7, this);
        if (this.a.postDelayed(r0, RangesKt.coerceAtMost(r5, 4611686018427387903L)) == false) goto L5;
        r7.i(new scheduleResumeAfterDelay.1(this, r0));
        return;
    L5:
        d(r7.getContext(), r0);
    }

    public HandlerContext(Handler r2, String r3, boolean r4) {
        super(null);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        if (r4 == false) goto L5;
        HandlerContext r5 = this;
    L6:
        this.d = r5;
        return;
    L5:
        r5 = new HandlerContext(r2, r3, true);
        goto L6
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.f0
    public final m0 invokeOnTimeout(long r4, Runnable r6, CoroutineContext r7) {
        if (this.a.postDelayed(r6, RangesKt.coerceAtMost(r4, 4611686018427387903L)) == true) goto L5;
        d(r7, r6);
        return l1.a;
    L5:
        return new c(this, r6);
    }
}
