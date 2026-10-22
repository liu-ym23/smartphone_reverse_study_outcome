package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes42.dex */
public final class c1<T> extends AbstractFlow<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> f504844a;

    /* JADX WARN: Multi-variable type inference failed */
    public c1(Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> r100) {
        this.f504844a = r100;
    }
}
