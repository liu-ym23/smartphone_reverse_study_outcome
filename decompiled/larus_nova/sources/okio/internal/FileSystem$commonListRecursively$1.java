package okio.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import okio.b0;
import okio.l;

/* JADX INFO: renamed from: okio.internal.-FileSystem$commonListRecursively$1, reason: invalid class name */
/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "okio.internal.-FileSystem$commonListRecursively$1", f = "FileSystem.kt", i = {0, 0}, l = {96}, m = "invokeSuspend", n = {"$this$sequence", "stack"}, s = {"L$0", "L$1"})
final class FileSystem$commonListRecursively$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super b0>, Continuation<? super Unit>, Object> {
    final /* synthetic */ b0 $dir;
    final /* synthetic */ boolean $followSymlinks;
    final /* synthetic */ l $this_commonListRecursively;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public FileSystem$commonListRecursively$1(b0 r100, l r101, boolean r102, Continuation<? super FileSystem$commonListRecursively$1> r103) {
        this.$dir = r100;
        this.$this_commonListRecursively = r101;
        this.$followSymlinks = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        FileSystem$commonListRecursively$1 r102 = new FileSystem$commonListRecursively$1(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super b0> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super b0> r100, Continuation<? super Unit> r101) {
        return ((FileSystem$commonListRecursively$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        Iterator<b0> r102 = (Iterator) this.L$2;
        ArrayDeque r103 = (ArrayDeque) this.L$1;
        SequenceScope r104 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r110);
        ArrayDeque r111 = r103;
        SequenceScope r112 = r104;
    L10:
        if (r102.hasNext() == false) goto L15;
        b0 r105 = r102.next();
        l r106 = this.$this_commonListRecursively;
        boolean r107 = this.$followSymlinks;
        this.L$0 = r112;
        this.L$1 = r111;
        this.L$2 = r102;
        this.label = 1;
        if (FileSystem.a(r112, r106, r111, r105, r107, false, this) != r100) goto L10;
        return r100;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        SequenceScope r113 = (SequenceScope) this.L$0;
        ArrayDeque r108 = new ArrayDeque();
        r108.addLast(this.$dir);
        r112 = r113;
        r111 = r108;
        r102 = this.$this_commonListRecursively.b(this.$dir).iterator();
        goto L10
    }
}
