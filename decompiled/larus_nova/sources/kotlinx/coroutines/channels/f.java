package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;

/* JADX INFO: loaded from: classes5.dex */
public class f<E> extends kotlinx.coroutines.a<Unit> implements Channel<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Channel<E> f504695d;

    public boolean close(Throwable r100) {
        return this.f504695d.close(r100);
    }

    public final Channel<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final kotlinx.coroutines.selects.g<E> getOnReceive() {
        return this.f504695d.getOnReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final kotlinx.coroutines.selects.g<g<E>> getOnReceiveCatching() {
        return this.f504695d.getOnReceiveCatching();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final kotlinx.coroutines.selects.g<E> getOnReceiveOrNull() {
        return this.f504695d.getOnReceiveOrNull();
    }

    public kotlinx.coroutines.selects.i<E, SendChannel<E>> getOnSend() {
        return this.f504695d.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void invokeOnClose(Function1<? super Throwable, Unit> r100) {
        this.f504695d.invokeOnClose(r100);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isClosedForReceive() {
        return this.f504695d.isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        return this.f504695d.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isEmpty() {
        return this.f504695d.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator<E> iterator() {
        return this.f504695d.iterator();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E r100) {
        return this.f504695d.offer(r100);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    public final E poll() {
        return this.f504695d.poll();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receive(Continuation<? super E> r100) {
        return this.f504695d.receive(r100);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU */
    public final Object mo10963receiveCatchingJP2dKIU(Continuation<? super g<? extends E>> r100) {
        Object r101 = this.f504695d.mo10963receiveCatchingJP2dKIU(r100);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r101;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public final Object receiveOrNull(Continuation<? super E> r100) {
        return this.f504695d.receiveOrNull(r100);
    }

    public Object send(E r100, Continuation<? super Unit> r101) {
        return this.f504695d.send(r100, r101);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk */
    public final Object mo10964tryReceivePtdJZtk() {
        return this.f504695d.mo10964tryReceivePtdJZtk();
    }

    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo10962trySendJP2dKIU(E r100) {
        return this.f504695d.mo10962trySendJP2dKIU(r100);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ void cancel() {
        u(new JobCancellationException(x(), null, this));
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(CancellationException r100) {
        if (isCancelled() == false) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        r100 = new JobCancellationException(x(), null, this);
    L7:
        u(r100);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void u(Throwable r100) {
        CancellationException r101 = JobSupport.h0(this, r100);
        this.f504695d.cancel(r101);
        s(r101);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean cancel(Throwable r100) {
        u(new JobCancellationException(x(), null, this));
        return true;
    }

    public f(CoroutineContext r100, Channel<E> r101, boolean r102, boolean r103) {
        super(r100, r102, r103);
        this.f504695d = r101;
    }
}
