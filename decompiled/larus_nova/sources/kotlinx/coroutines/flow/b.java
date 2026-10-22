package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: classes5.dex */
public final class b<T> extends kotlinx.coroutines.flow.internal.d<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f504836f = null;
    private volatile /* synthetic */ int consumed$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReceiveChannel<T> f504837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f504838e;

    static {
        f504836f = AtomicIntegerFieldUpdater.newUpdater(b.class, "consumed$volatile");
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final String b() {
        return "channel=" + this.f504837d;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final Flow<T> e() {
        return new b(this.f504837d, this.f504838e);
    }

    public final void g() {
        if (this.f504838e == false) goto L12;
        boolean r100 = true;
        if (f504836f.getAndSet(this, 1) == 0) goto L8;
        r100 = false;
    L8:
        if (r100 == false) goto L11;
        return;
    L11:
        throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final ReceiveChannel<T> f(CoroutineScope r100) {
        g();
        if (this.f504883b != (-3)) goto L6;
        return this.f504837d;
    L6:
        return super.f(r100);
    }

    public /* synthetic */ b(ReceiveChannel r100, boolean r101) {
        this(r100, r101, EmptyCoroutineContext.INSTANCE, -3, BufferOverflow.SUSPEND);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final Object c(kotlinx.coroutines.channels.k<? super T> r100, Continuation<? super Unit> r101) {
        Object r102 = FlowKt__ChannelsKt.a(new kotlinx.coroutines.flow.internal.p(r100), this.f504837d, this.f504838e, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.d, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super T> r100, Continuation<? super Unit> r101) {
        if (this.f504883b != (-3)) goto L9;
        g();
        Object r102 = FlowKt__ChannelsKt.a(r100, this.f504837d, this.f504838e, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r102;
    L8:
        return Unit.INSTANCE;
    L9:
        Object r103 = super.collect(r100, r101);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r103;
    L13:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final kotlinx.coroutines.flow.internal.d<T> d(CoroutineContext r100, int r101, BufferOverflow r110) {
        return new b(this.f504837d, this.f504838e, r100, r101, r110);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(ReceiveChannel<? extends T> r100, boolean r101, CoroutineContext r102, int r103, BufferOverflow r104) {
        super(r102, r103, r104);
        this.f504837d = r100;
        this.f504838e = r101;
        this.consumed$volatile = 0;
    }
}
