package com.ss.android.lark.keyboard.biz.mention;

import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.mention.AtDoubaoSlotElement$createView$1$1$1", f = "AtDoubaoSlotElement.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
final class AtDoubaoSlotElement$createView$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ a this$0;

    public AtDoubaoSlotElement$createView$1$1$1(a r100, Continuation<? super AtDoubaoSlotElement$createView$1$1$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AtDoubaoSlotElement$createView$1$1$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AtDoubaoSlotElement$createView$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L12;
        if (r101 != 1) goto L11;
        ResultKt.throwOnFailure(r100);
        Chatter r102 = (Chatter) r100;
        if (r102 == null) goto L8;
        r102.getId();
    L8:
        com.ss.android.lark.chat.utils.m.b(r102, ChatterNameDisplayRule.ALIAS_NAME, false);
        com.ss.android.lark.chat.utils.m.b(r102, ChatterNameDisplayRule.NAME, false);
        this.this$0.getClass();
        throw null;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r100);
        this.this$0.getClass();
        throw null;
    }
}
