package com.ss.android.lark.create.groupchat.impl.service.interceptor;

import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.create.groupchat.impl.service.interceptor.ExceedGroupLimitInterceptor$intercept$1", f = "ExceedGroupLimitInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ExceedGroupLimitInterceptor$intercept$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ErrorResult $err;
    int label;
    final /* synthetic */ ExceedGroupLimitInterceptor this$0;

    public ExceedGroupLimitInterceptor$intercept$1(ErrorResult r100, Context r101, ExceedGroupLimitInterceptor r102, Continuation<? super ExceedGroupLimitInterceptor$intercept$1> r103) {
        this.$err = r100;
        this.$context = r101;
        this.this$0 = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ExceedGroupLimitInterceptor$intercept$1(this.$err, this.$context, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ExceedGroupLimitInterceptor$intercept$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        String r101 = this.$err.getDisplayMsg(this.$context.getString(R.string.Lark_IM_AddGroupMembers_MaximumNumberReachedUnableToAddNewMembers_Text));
        ExceedGroupLimitInterceptor r102 = this.this$0;
        Context r103 = this.$context;
        Intrinsics.checkNotNull(r101);
        r102.getClass();
        new UDDialogBuilder(r103).message(r101).addActionButton(R.id.ud_dialog_btn_primary, R.string.Lark_Legacy_IKnow, null).show();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
