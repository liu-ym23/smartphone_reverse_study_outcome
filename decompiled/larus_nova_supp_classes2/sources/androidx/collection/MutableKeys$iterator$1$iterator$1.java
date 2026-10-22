package androidx.collection;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.collection.MutableKeys$iterator$1$iterator$1", f = "ScatterMap.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {1626}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$1", "I$0", "I$1", "J$0", "I$2", "I$3"})
public final class MutableKeys$iterator$1$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MutableKeys<K, V> this$0;

    public MutableKeys$iterator$1$iterator$1(MutableKeys<K, V> r1, Continuation<? super MutableKeys$iterator$1$iterator$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MutableKeys$iterator$1$iterator$1 r0 = new MutableKeys$iterator$1$iterator$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((SequenceScope) r1, (Continuation) r2);
    }

    public final Object invoke(SequenceScope<? super Integer> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0056 -> B:28:0x00af). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0058 -> B:14:0x006d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x009b -> B:24:0x00a0). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        int r3 = this.I$3;
        int r6 = this.I$2;
        long r7 = this.J$0;
        int r9 = this.I$1;
        int r10 = this.I$0;
        long[] r11 = (long[]) this.L$1;
        SequenceScope r12 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r23);
        SequenceScope r13 = r12;
        long[] r14 = r11;
        MutableKeys$iterator$1$iterator$1 r15 = this;
    L24:
        MutableKeys$iterator$1$iterator$1 r19 = r15;
        int r16 = r10;
        MutableKeys$iterator$1$iterator$1 r17 = r19;
    L25:
        r7 = r7 >> 8;
        r3 = r3 + 1;
    L14:
        if (r3 < r6) goto L16;
        if (r6 != 8) goto L31;
        int r8 = r9;
        MutableKeys$iterator$1$iterator$1 r18 = r17;
        int r20 = r16;
        long[] r21 = r14;
        SequenceScope r4 = r13;
    L28:
        if (r8 == r20) goto L31;
        r8 = r8 + 1;
    L11:
        long r110 = r21[r8];
        if (((((~r110) << 7) & r110) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L28;
        r13 = r4;
        r3 = 0;
        r14 = r21;
        r6 = 8 - ((~(r8 - r20)) >>> 31);
        r16 = r20;
        r17 = r18;
        r9 = r8;
        r7 = r110;
    L31:
        return Unit.INSTANCE;
    L16:
        if ((255 & r7) >= 128) goto L32;
        if (1 == 0) goto L25;
        Integer r111 = Boxing.boxInt((r9 << 3) + r3);
        r17.L$0 = r13;
        r17.L$1 = r14;
        r17.I$0 = r16;
        r17.I$1 = r9;
        r17.J$0 = r7;
        r17.I$2 = r6;
        r17.I$3 = r3;
        r17.label = 1;
        if (r13.yield(r111, r17) != r1) goto L23;
        return r1;
    L23:
        int r112 = r16;
        r15 = r17;
        r10 = r112;
        goto L24
    L32:
        if (0 == 0) goto L25;
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r23);
        r4 = (SequenceScope) this.L$0;
        r21 = MutableKeys.access$getParent$p(this.this$0).metadata;
        r20 = r21.length - 2;
        if (r20 < 0) goto L31;
        r18 = this;
        r8 = 0;
        goto L11
    }
}
