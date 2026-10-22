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
@DebugMetadata(c = "androidx.collection.MutableSetWrapper$iterator$1$iterator$1", f = "ScatterSet.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {1188}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$3", "I$0", "I$1", "J$0", "I$2", "I$3"})
public final class MutableSetWrapper$iterator$1$iterator$1<E> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super E>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MutableSetWrapper<E> this$0;
    final /* synthetic */ MutableSetWrapper.AnonymousClass1 this$1;

    public MutableSetWrapper$iterator$1$iterator$1(MutableSetWrapper<E> r1, MutableSetWrapper.AnonymousClass1 r2, Continuation<? super MutableSetWrapper$iterator$1$iterator$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MutableSetWrapper$iterator$1$iterator$1 r0 = new MutableSetWrapper$iterator$1$iterator$1(this.this$0, this.this$1, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((SequenceScope) r1, (Continuation) r2);
    }

    public final Object invoke(SequenceScope<? super E> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0062 -> B:28:0x00d4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0064 -> B:14:0x007e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00bb -> B:24:0x00bf). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r26) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r3 = 8;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        int r4 = this.I$3;
        int r6 = this.I$2;
        long r7 = this.J$0;
        int r9 = this.I$1;
        int r10 = this.I$0;
        long[] r11 = (long[]) this.L$3;
        MutableSetWrapper<E> r12 = (MutableSetWrapper) this.L$2;
        MutableSetWrapper.AnonymousClass1 r13 = (MutableSetWrapper.AnonymousClass1) this.L$1;
        SequenceScope r14 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r26);
        MutableSetWrapper$iterator$1$iterator$1<E> r5 = this;
    L24:
        SequenceScope r15 = r14;
        MutableSetWrapper.AnonymousClass1 r16 = r13;
        MutableSetWrapper<E> r17 = r12;
        MutableSetWrapper$iterator$1$iterator$1<E> r18 = r5;
        r3 = 8;
    L25:
        r7 = r7 >> r3;
        r4 = r4 + 1;
    L14:
        if (r4 < r6) goto L16;
        if (r6 != r3) goto L31;
        long[] r8 = r11;
        MutableSetWrapper$iterator$1$iterator$1<E> r19 = r18;
        MutableSetWrapper<E> r20 = r17;
        MutableSetWrapper.AnonymousClass1 r21 = r16;
        SequenceScope r22 = r15;
        int r23 = r10;
        int r110 = r9;
        int r24 = r23;
    L28:
        if (r110 == r24) goto L31;
        r110 = r110 + 1;
    L11:
        long r111 = r8[r110];
        if (((((~r111) << 7) & r111) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L28;
        r15 = r22;
        r4 = 0;
        MutableSetWrapper$iterator$1$iterator$1<E> r25 = r19;
        r11 = r8;
        r6 = 8 - ((~(r110 - r24)) >>> 31);
        r16 = r21;
        r17 = r20;
        r18 = r25;
        r7 = r111;
        int r27 = r110;
        r10 = r24;
        r9 = r27;
    L31:
        return Unit.INSTANCE;
    L16:
        if ((r7 & 255) >= 128) goto L32;
        if (1 == 0) goto L25;
        int r28 = (r9 << 3) + r4;
        r16.setCurrent(r28);
        Object r29 = MutableSetWrapper.access$getParent$p(r17).elements[r28];
        r18.L$0 = r15;
        r18.L$1 = r16;
        r18.L$2 = r17;
        r18.L$3 = r11;
        r18.I$0 = r10;
        r18.I$1 = r9;
        r18.J$0 = r7;
        r18.I$2 = r6;
        r18.I$3 = r4;
        r18.label = 1;
        if (r15.yield(r29, r18) != r1) goto L23;
        return r1;
    L23:
        r5 = r18;
        r12 = r17;
        r13 = r16;
        r14 = r15;
        goto L24
    L32:
        if (0 == 0) goto L25;
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r26);
        r22 = (SequenceScope) this.L$0;
        MutableScatterSet r30 = MutableSetWrapper.access$getParent$p(this.this$0);
        r21 = this.this$1;
        r20 = this.this$0;
        r8 = r30.metadata;
        r24 = r8.length - 2;
        if (r24 < 0) goto L31;
        r19 = this;
        r110 = 0;
        goto L11
    }
}
