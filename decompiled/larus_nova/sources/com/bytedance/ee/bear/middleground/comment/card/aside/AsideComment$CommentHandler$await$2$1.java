package com.bytedance.ee.bear.middleground.comment.card.aside;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AsideComment$CommentHandler$await$2$1", f = "AsideComment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AsideComment$CommentHandler$await$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.i<Unit> $it;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AsideComment$CommentHandler$await$2$1(kotlinx.coroutines.i<? super Unit> r100, Continuation<? super AsideComment$CommentHandler$await$2$1> r101) {
        this.$it = r100;
        super(1, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new AsideComment$CommentHandler$await$2$1(this.$it, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((AsideComment$CommentHandler$await$2$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        kotlinx.coroutines.i<Unit> r101 = this.$it;
        Result.Companion r102 = Result.Companion;
        Unit r103 = Unit.INSTANCE;
        r101.resumeWith(Result.m9449constructorimpl(r103));
        return r103;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
