package kotlinx.coroutines.selects;

import java.util.Collections;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl$initSelectResult$1", f = "SelectOld.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
final class UnbiasedSelectBuilderImpl$initSelectResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ o<Object> this$0;

    public UnbiasedSelectBuilderImpl$initSelectResult$1(o<Object> r100, Continuation<? super UnbiasedSelectBuilderImpl$initSelectResult$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new UnbiasedSelectBuilderImpl$initSelectResult$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((UnbiasedSelectBuilderImpl$initSelectResult$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L10;
        if (r101 != 1) goto L6;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
        o<Object> r102 = this.this$0;
        int r103 = o.f505122g;
        r102.getClass();
        throw null;
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r100);
        o<Object> r104 = this.this$0;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r104.getClass();     // Catch: Throwable -> L15
        Collections.shuffle(null);     // Catch: Throwable -> L14
        throw null;     // Catch: Throwable -> L14
    L21:
        throw null;     // Catch: Throwable -> L15
    L14:
        throw null;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        o<Object> r105 = this.this$0;
        int r106 = o.f505122g;
        r105.getClass();
        n.a(null, th);
        throw null;
    }
}
