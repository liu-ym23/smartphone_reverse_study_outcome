package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.internal.AwaitingSlot", f = "AwaitingSlot.kt", i = {0}, l = {57}, m = "trySuspend", n = {"suspended"}, s = {"I$0"})
final class AwaitingSlot$trySuspend$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public AwaitingSlot$trySuspend$1(a r100, Continuation<? super AwaitingSlot$trySuspend$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        a r101 = this.this$0;
        AtomicReferenceFieldUpdater r102 = a.f492065a;
        return r101.a(this);
    }
}
