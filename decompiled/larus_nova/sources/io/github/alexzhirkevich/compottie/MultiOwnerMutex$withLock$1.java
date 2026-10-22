package io.github.alexzhirkevich.compottie;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.github.alexzhirkevich.compottie.MultiOwnerMutex", f = "MultiOwnerMutex.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {38, 54, 24, 64, 64}, m = "withLock", n = {"key", "action", "$this$withLock_u24default$iv", "key", "action", "keyLock", "$this$withLock$iv", "key", "keyLock", "$this$withLock$iv", "key", "keyLock", "$this$withLock_u24default$iv", "key", "keyLock", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
public final class MultiOwnerMutex$withLock$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiOwnerMutex this$0;

    public MultiOwnerMutex$withLock$1(MultiOwnerMutex r100, Continuation<? super MultiOwnerMutex$withLock$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
