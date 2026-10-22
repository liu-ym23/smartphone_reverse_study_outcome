package kotlinx.coroutines.flow.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes6.dex */
public final class r extends SharedFlowImpl<Integer> implements i1<Integer> {
    @Override // kotlinx.coroutines.flow.i1
    public final Integer getValue() {
        monitor-enter(this);
        Object[] r100 = this.f504812h;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L6
        Integer r101 = Integer.valueOf(((Number) SharedFlowKt.access$getBufferAt(r100, (this.f504813i + ((long) ((int) ((l() + ((long) this.f504815k)) - this.f504813i)))) - 1)).intValue());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public r(int r100) {
        super(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
        tryEmit(Integer.valueOf(r100));
    }

    public final void s(int r100) {
        monitor-enter(this);
        Object[] r101 = this.f504812h;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L6
        tryEmit(Integer.valueOf(((Number) SharedFlowKt.access$getBufferAt(r101, (this.f504813i + ((long) ((int) ((l() + ((long) this.f504815k)) - this.f504813i)))) - 1)).intValue() + r100));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
