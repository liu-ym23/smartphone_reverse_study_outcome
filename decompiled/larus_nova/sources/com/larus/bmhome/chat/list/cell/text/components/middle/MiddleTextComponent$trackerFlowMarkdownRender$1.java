package com.larus.bmhome.chat.list.cell.text.components.middle;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tx9.x1;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.components.middle.MiddleTextComponent$trackerFlowMarkdownRender$1", f = "MiddleTextComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MiddleTextComponent$trackerFlowMarkdownRender$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $parseCharCount;
    final /* synthetic */ lw8.m $performance;
    int label;

    public MiddleTextComponent$trackerFlowMarkdownRender$1(int r100, lw8.m r101, Continuation<? super MiddleTextComponent$trackerFlowMarkdownRender$1> r102) {
        this.$parseCharCount = r100;
        this.$performance = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MiddleTextComponent$trackerFlowMarkdownRender$1(this.$parseCharCount, this.$performance, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MiddleTextComponent$trackerFlowMarkdownRender$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        Long r101 = Boxing.boxLong(this.$parseCharCount);
        lw8.m r102 = this.$performance;
        if (r102 == null) goto L7;
        Long r103 = r102.f511088a;
    L8:
        if (r102 == null) goto L10;
        Long r104 = r102.f511089b;
    L11:
        x1.a(r101, null, r103, r104, null, 114);
        return Unit.INSTANCE;
    L10:
        r104 = null;
        goto L11
    L7:
        r103 = null;
        goto L8
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
