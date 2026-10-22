package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes5.dex */
public final class j<E> extends f<E> implements k<E> {
    @Override // kotlinx.coroutines.channels.k
    public final SendChannel getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.a
    public final void m0(Unit r100) {
        SendChannel.a.a(this.f504695d);
    }

    public j(CoroutineContext r100, Channel<E> r101) {
        super(r100, r101, true, true);
    }

    @Override // kotlinx.coroutines.a
    public final void l0(Throwable r100, boolean r101) {
        if (this.f504695d.close(r100) == true) goto L7;
        if (r101 == true) goto L8;
        y.a(getContext(), r100);
        return;
    L8:
        return;
    }
}
