package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class MutexImpl extends SemaphoreImpl implements a {
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = null;
    private volatile /* synthetic */ Object owner$volatile;

    static {
        h = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner$volatile");
    }

    @Override // kotlinx.coroutines.sync.a
    public final boolean isLocked() {
        if (Math.max(SemaphoreImpl.g.get(this), 0) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final String toString() {
        return "Mutex@" + b0.a(this) + "[isLocked=" + isLocked() + ",owner=" + h.get(this) + ']';
    }

    public MutexImpl(boolean r2) {
        super(1, r2 ? 1 : 0);
        if (r2 == false) goto L5;
        kotlinx.coroutines.internal.b0 r3 = null;
    L6:
        this.owner$volatile = r3;
        new MutexImpl$onSelectCancellationUnlockConstructor$1(this);
        return;
    L5:
        r3 = b.a;
        goto L6
    }

    @Override // kotlinx.coroutines.sync.a
    public final boolean b(Object r6) {
    L2:
        AtomicIntegerFieldUpdater r0 = SemaphoreImpl.g;
        int r1 = r0.get(this);
        if (r1 > this.a) goto L4;
        if (r1 <= 0) goto L11;
        if (r0.compareAndSet(this, r1, r1 - 1) == false) goto L2;
        boolean r2 = true;
    L16:
        if (r2 == true) goto L17;
        if (r6 == null) goto L31;
    L21:
        if (isLocked() == false) goto L22;
        Object r3 = h.get(this);
        if (r3 == b.a) goto L21;
        if (r3 != r6) goto L27;
        char r4 = 1;
    L28:
        if (r4 == 1) goto L32;
        if (r4 == 2) goto L31;
    L32:
        char r5 = 2;
    L33:
        if (r5 == 0) goto L40;
        if (r5 == 1) goto L59;
        if (r5 == 2) goto L39;
        throw new IllegalStateException("unexpected".toString());
    L39:
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + r6).toString());
    L59:
        return false;
    L40:
        return true;
    L27:
        r4 = 2;
        goto L28
    L22:
        r4 = 0;
    L31:
        r5 = 1;
        goto L33
    L17:
        h.set(this, r6);
        r5 = 0;
        goto L33
    L11:
        r2 = false;
    L4:
        AtomicIntegerFieldUpdater r7 = SemaphoreImpl.g;
        int r8 = r7.get(this);
        int r9 = this.a;
        if (r8 <= r9) goto L2;
        if (r7.compareAndSet(this, r8, r9) == false) goto L4;
        goto L2
    }

    @Override // kotlinx.coroutines.sync.a
    public final void unlock(Object r7) {
    L3:
        if (isLocked() == false) goto L25;
        AtomicReferenceFieldUpdater r0 = h;
        Object r1 = r0.get(this);
        kotlinx.coroutines.internal.b0 r2 = b.a;
        if (r1 == r2) goto L3;
        boolean r3 = true;
        if (r1 == r7) goto L11;
        if (r7 == null) goto L11;
        boolean r5 = false;
    L12:
        if (r5 == false) goto L23;
    L14:
        if (r0.compareAndSet(this, r1, r2) == true) goto L19;
        if (r0.get(this) == r1) goto L14;
        r3 = false;
    L19:
        if (r3 == false) goto L3;
        release();
        return;
    L23:
        throw new IllegalStateException(("This mutex is locked by " + r1 + ", but " + r7 + " is expected").toString());
    L11:
        r5 = true;
        goto L12
    L25:
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    @Override // kotlinx.coroutines.sync.a
    public final Object a(Object r3, Continuation<? super Unit> r4) {
        if (b(r3) == true) goto L24;
        j r0 = l.a(IntrinsicsKt.intercepted(r4));
        d(new a(this, r0, r3));     // Catch: Throwable -> L19
        Object r5 = r0.B();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L11:
        if (r5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        r5 = Unit.INSTANCE;
    L15:
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r5;
    L18:
        return Unit.INSTANCE;
    L19:
        th = move-exception;
        r0.H();
        throw th;
    L24:
        return Unit.INSTANCE;
    }
}
