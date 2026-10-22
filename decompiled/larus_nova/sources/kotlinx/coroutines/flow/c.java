package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes5.dex */
public class c<T> extends kotlinx.coroutines.flow.internal.d<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<kotlinx.coroutines.channels.k<? super T>, Continuation<? super Unit>, Object> f504842d;

    @Override // kotlinx.coroutines.flow.internal.d
    public final String toString() {
        return "block[" + this.f504842d + "] -> " + super.toString();
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public Object c(kotlinx.coroutines.channels.k<? super T> r100, Continuation<? super Unit> r101) {
        Object r102 = this.f504842d.invoke(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public kotlinx.coroutines.flow.internal.d<T> d(CoroutineContext r100, int r101, BufferOverflow r102) {
        return new c(this.f504842d, r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function2<? super kotlinx.coroutines.channels.k<? super T>, ? super Continuation<? super Unit>, ? extends Object> r100, CoroutineContext r101, int r102, BufferOverflow r103) {
        super(r101, r102, r103);
        this.f504842d = r100;
    }
}
