package io.ktor.utils.io.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.internal.WriteSessionImpl", f = "WriteSessionImpl.kt", i = {0}, l = {86}, m = "tryAwaitJoinSwitch", n = {"this"}, s = {"L$0"})
public final class WriteSessionImpl$tryAwaitJoinSwitch$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WriteSessionImpl this$0;

    public WriteSessionImpl$tryAwaitJoinSwitch$1(WriteSessionImpl r100, Continuation<? super WriteSessionImpl$tryAwaitJoinSwitch$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(0, this);
    }
}
