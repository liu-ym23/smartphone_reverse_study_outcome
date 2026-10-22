package com.larus.bmhome.view.actionbar.bot;

import com.larus.bmhome.chat.api.ActionBarApi;
import com.larus.bmhome.chat.api.ActionBarTempData;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/chat/api/ActionBarTempData;", "Lcom/larus/bmhome/chat/api/ActionBarApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.bot.ActionBarViewModel$executeApiCall$2$result$1", f = "ActionBarViewModel.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
public final class ActionBarViewModel$executeApiCall$2$result$1 extends SuspendLambda implements Function2<ActionBarApi, Continuation<? super BizResponse<ActionBarTempData>>, Object> {
    final /* synthetic */ Boolean $isColdStart;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ActionBarViewModel this$0;

    public ActionBarViewModel$executeApiCall$2$result$1(ActionBarViewModel r100, Boolean r101, Continuation<? super ActionBarViewModel$executeApiCall$2$result$1> r102) {
        this.this$0 = r100;
        this.$isColdStart = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ActionBarViewModel$executeApiCall$2$result$1 r102 = new ActionBarViewModel$executeApiCall$2$result$1(this.this$0, this.$isColdStart, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ActionBarApi r100, Continuation<? super BizResponse<ActionBarTempData>> r101) {
        return ((ActionBarViewModel$executeApiCall$2$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ActionBarApi r100, Continuation<? super BizResponse<ActionBarTempData>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L11:
        return r110;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        ActionBarApi r102 = (ActionBarApi) this.L$0;
        long r103 = this.this$0.getCursor();
        String r104 = ActionBarViewModel.access$getLang$p(this.this$0);
        Boolean r105 = this.$isColdStart;
        this.label = 1;
        r110 = r102.getTemplates(r103, 20, r104, r105, this);
        if (r110 != r100) goto L11;
        return r100;
    }
}
