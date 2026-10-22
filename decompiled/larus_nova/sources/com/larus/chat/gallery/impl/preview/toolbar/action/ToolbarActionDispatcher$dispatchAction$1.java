package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.ToolbarActionDispatcher$dispatchAction$1", f = "ToolbarActionDispatcher.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
public final class ToolbarActionDispatcher$dispatchAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ o $action;
    final /* synthetic */ l0 $contextWithOverflow;
    final /* synthetic */ ToolbarButtonType $type;
    private /* synthetic */ Object L$0;
    int label;

    public ToolbarActionDispatcher$dispatchAction$1(o r100, l0 r101, ToolbarButtonType r102, Continuation<? super ToolbarActionDispatcher$dispatchAction$1> r103) {
        this.$action = r100;
        this.$contextWithOverflow = r101;
        this.$type = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ToolbarActionDispatcher$dispatchAction$1 r102 = new ToolbarActionDispatcher$dispatchAction$1(this.$action, this.$contextWithOverflow, this.$type, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ToolbarActionDispatcher$dispatchAction$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
    L13:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        ToolbarButtonType r104 = this.$type;
        Throwable r105 = Result.m9452exceptionOrNullimpl(r103);
        if (r105 == null) goto L21;
        FLogger.f375446a.w("ToolbarActionDispatcher", "Action " + r104 + " failed: " + r105.getMessage(), r105);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r106 = (CoroutineScope) this.L$0;
        o r107 = this.$action;
        l0 r108 = this.$contextWithOverflow;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (r107.a(r108, this) != r101) goto L13;
        return r101;
    L15:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
