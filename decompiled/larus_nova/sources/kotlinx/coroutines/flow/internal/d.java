package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d<T> implements l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f504882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f504883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BufferOverflow f504884c;

    public String b() {
        return null;
    }

    public abstract Object c(kotlinx.coroutines.channels.k<? super T> r100, Continuation<? super Unit> r101);

    public abstract d<T> d(CoroutineContext r100, int r101, BufferOverflow r102);

    public Flow<T> e() {
        return null;
    }

    public String toString() {
        ArrayList r100 = new ArrayList(4);
        String r101 = b();
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        if (this.f504882a == EmptyCoroutineContext.INSTANCE) goto L9;
        r100.add("context=" + this.f504882a);
    L9:
        if (this.f504883b == (-3)) goto L12;
        r100.add("capacity=" + this.f504883b);
    L12:
        if (this.f504884c == BufferOverflow.SUSPEND) goto L15;
        r100.add("onBufferOverflow=" + this.f504884c);
    L15:
        return getClass().getSimpleName() + '[' + CollectionsKt.joinToString$default(r100, ", ", null, null, 0, null, null, 62, null) + ']';
    }

    public ReceiveChannel<T> f(CoroutineScope r100) {
        CoroutineContext r101 = this.f504882a;
        int r102 = this.f504883b;
        if (r102 != (-3)) goto L5;
        int r103 = -2;
    L7:
        return ProduceKt.b(r100, r101, r103, this.f504884c, CoroutineStart.ATOMIC, null, new ChannelFlow$collectToFun$1(this, null));
    L5:
        r103 = r102;
        goto L7
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> r100, Continuation<? super Unit> r101) {
        Object r102 = CoroutineScopeKt.coroutineScope(new ChannelFlow$collect$2(r100, this, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public d(CoroutineContext r100, int r101, BufferOverflow r102) {
        this.f504882a = r100;
        this.f504883b = r101;
        this.f504884c = r102;
    }

    @Override // kotlinx.coroutines.flow.internal.l
    public final Flow<T> a(CoroutineContext r100, int r101, BufferOverflow r102) {
        CoroutineContext r103 = r100.plus(this.f504882a);
        if (r102 != BufferOverflow.SUSPEND) goto L21;
        int r104 = this.f504883b;
        if (r104 == (-3)) goto L19;
        if (r101 != (-3)) goto L11;
    L17:
        r101 = r104;
        goto L19
    L11:
        if (r104 == (-2)) goto L19;
        if (r101 == (-2)) goto L17;
        r104 = r104 + r101;
        if (r104 >= 0) goto L17;
        r101 = Integer.MAX_VALUE;
    L19:
        r102 = this.f504884c;
    L21:
        if (Intrinsics.areEqual(r103, this.f504882a) == false) goto L28;
        if (r101 != this.f504883b) goto L28;
        if (r102 != this.f504884c) goto L28;
        return this;
    L28:
        return d(r103, r101, r102);
    }
}
