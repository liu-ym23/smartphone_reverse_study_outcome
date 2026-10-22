package com.larus.business.markdown.impl.widget;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.business.markdown.impl.widget.MarkdownWidgetHelper$updateWidgetFromNode$1$1", f = "MarkdownWidgetHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MarkdownWidgetHelper$updateWidgetFromNode$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ pw8.a $callback;
    final /* synthetic */ ViewGroup $currentParentViewGroup;
    final /* synthetic */ int $index;
    int label;

    public MarkdownWidgetHelper$updateWidgetFromNode$1$1(pw8.a r100, int r101, ViewGroup r102, Continuation<? super MarkdownWidgetHelper$updateWidgetFromNode$1$1> r103) {
        this.$callback = r100;
        this.$index = r101;
        this.$currentParentViewGroup = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MarkdownWidgetHelper$updateWidgetFromNode$1$1(this.$callback, this.$index, this.$currentParentViewGroup, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MarkdownWidgetHelper$updateWidgetFromNode$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        pw8.a r101 = this.$callback;
        if (r101 == null) goto L8;
        r101.b(this.$index, this.$currentParentViewGroup);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
