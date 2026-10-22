package com.obric.sva.sdk.lightup;

import com.obric.sva.sdk.utils.LogUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.sva.sdk.lightup.LightUpManager$lightUpSurpress$1", f = "LightUpManager.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
public final class LightUpManager$lightUpSurpress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Boolean>>, Object> {
    final /* synthetic */ Ref.BooleanRef $r;
    Object L$0;
    Object L$1;
    int label;

    public LightUpManager$lightUpSurpress$1(Ref.BooleanRef r100, Continuation<? super LightUpManager$lightUpSurpress$1> r101) {
        this.$r = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LightUpManager$lightUpSurpress$1(this.$r, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Result<? extends Boolean>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Result<Boolean>> r101) {
        return ((LightUpManager$lightUpSurpress$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 != 1) goto L9;
        Ref.BooleanRef r103 = (Ref.BooleanRef) this.L$1;
        Ref.BooleanRef r104 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L17
    L15:
        r103.element = ((Boolean) r100).booleanValue();     // Catch: Throwable -> L17
        Object r105 = Result.m9449constructorimpl(Boxing.boxBoolean(r104.element));     // Catch: Throwable -> L17
    L19:
        Ref.BooleanRef r106 = this.$r;
        if (Result.m9456isSuccessimpl(r105) == false) goto L22;
        ((Boolean) r105).booleanValue();
        LogUtils.d(LightUpManager.TAG, "lightUpSurpress, success surpress with final state " + r106.element, new Object[0]);
    L22:
        Ref.BooleanRef r107 = this.$r;
        if (Result.m9452exceptionOrNullimpl(r105) == null) goto L26;
        LogUtils.d(LightUpManager.TAG, "lightUpSurpress, failed surpress with final state " + r107.element, new Object[0]);
    L26:
        return Result.m9448boximpl(r105);
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r100);
        Ref.BooleanRef r108 = this.$r;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L17
        LightUpManager$lightUpSurpress$1$1$1 r110 = new LightUpManager$lightUpSurpress$1$1$1(null);     // Catch: Throwable -> L17
        this.L$0 = r108;     // Catch: Throwable -> L17
        this.L$1 = r108;     // Catch: Throwable -> L17
        this.label = 1;     // Catch: Throwable -> L17
        Object r111 = TimeoutKt.b(300, r110, this);     // Catch: Throwable -> L17
        if (r111 != r101) goto L14;
        return r101;
    L14:
        r103 = r108;
        r100 = r111;
        r104 = r103;
    L17:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
