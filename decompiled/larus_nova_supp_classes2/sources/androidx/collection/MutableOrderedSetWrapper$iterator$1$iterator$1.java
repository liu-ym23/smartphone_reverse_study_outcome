package androidx.collection;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "E", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.collection.MutableOrderedSetWrapper$iterator$1$iterator$1", f = "OrderedScatterSet.kt", i = {0, 0, 0}, l = {1489}, m = "invokeSuspend", n = {"$this$iterator", "nodes$iv", "previousNode$iv"}, s = {"L$0", "L$3", "I$0"})
public final class MutableOrderedSetWrapper$iterator$1$iterator$1<E> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super E>, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MutableOrderedSetWrapper<E> this$0;
    final /* synthetic */ MutableOrderedSetWrapper.AnonymousClass1 this$1;

    public MutableOrderedSetWrapper$iterator$1$iterator$1(MutableOrderedSetWrapper<E> r1, MutableOrderedSetWrapper.AnonymousClass1 r2, Continuation<? super MutableOrderedSetWrapper$iterator$1$iterator$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MutableOrderedSetWrapper$iterator$1$iterator$1 r0 = new MutableOrderedSetWrapper$iterator$1$iterator$1(this.this$0, this.this$1, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((SequenceScope) r1, (Continuation) r2);
    }

    public final Object invoke(SequenceScope<? super E> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$0;
        long[] r3 = (long[]) this.L$3;
        MutableOrderedSetWrapper<E> r4 = (MutableOrderedSetWrapper) this.L$2;
        MutableOrderedSetWrapper.AnonymousClass1 r5 = (MutableOrderedSetWrapper.AnonymousClass1) this.L$1;
        SequenceScope r6 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r13);
    L10:
        if (r2 == Integer.MAX_VALUE) goto L16;
        int r8 = (int) ((r3[r2] >> 31) & SieveCacheKt.NodeLinkMask);
        r5.setCurrent(r2);
        Object r7 = MutableOrderedSetWrapper.access$getParent$p(r4).elements[r2];
        this.L$0 = r6;
        this.L$1 = r5;
        this.L$2 = r4;
        this.L$3 = r3;
        this.I$0 = r8;
        this.label = 1;
        if (r6.yield(r7, this) == r0) goto L13;
        r2 = r8;
        goto L10
    L13:
        return r0;
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        SequenceScope r14 = (SequenceScope) this.L$0;
        MutableOrderedScatterSet r9 = MutableOrderedSetWrapper.access$getParent$p(this.this$0);
        MutableOrderedSetWrapper.AnonymousClass1 r10 = this.this$1;
        r4 = this.this$0;
        long[] r11 = r9.nodes;
        r2 = r9.tail;
        r6 = r14;
        r5 = r10;
        r3 = r11;
        goto L10
    }
}
