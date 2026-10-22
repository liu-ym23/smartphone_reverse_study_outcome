package com.larus.office.plugins.inputv2.adapter;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "status", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.plugins.inputv2.adapter.OfficeChatInputAdapter$configureInputInteractions$4", f = "OfficeChatInputAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OfficeChatInputAdapter$configureInputInteractions$4 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $generation;
    final /* synthetic */ Function0<Unit> $onTextInputReady;
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ g this$0;

    public OfficeChatInputAdapter$configureInputInteractions$4(g r100, long r101, Function0<Unit> r102, Continuation<? super OfficeChatInputAdapter$configureInputInteractions$4> r103) {
        this.this$0 = r100;
        this.$generation = r101;
        this.$onTextInputReady = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        OfficeChatInputAdapter$configureInputInteractions$4 r102 = new OfficeChatInputAdapter$configureInputInteractions$4(this.this$0, this.$generation, this.$onTextInputReady, r101);
        r102.I$0 = ((Number) r100).intValue();
        return r102;
    }

    public final Object invoke(int r100, Continuation<? super Unit> r101) {
        return ((OfficeChatInputAdapter$configureInputInteractions$4) create(Integer.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer r100, Continuation<? super Unit> r101) {
        return invoke(r100.intValue(), r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r100);
        if (this.I$0 != 1) goto L10;
        g r101 = this.this$0;
        long r102 = this.$generation;
        int r103 = g.f362677s;
        if (r101.h(r102) == false) goto L10;
        this.$onTextInputReady.invoke();
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
