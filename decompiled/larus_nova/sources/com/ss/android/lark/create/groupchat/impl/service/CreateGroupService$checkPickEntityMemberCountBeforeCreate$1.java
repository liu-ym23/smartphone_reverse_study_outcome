package com.ss.android.lark.create.groupchat.impl.service;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.m;
import com.ss.android.lark.pb.chats.PullChangeGroupMemberAuthorizationResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/pb/chats/PullChangeGroupMemberAuthorizationResponse;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.create.groupchat.impl.service.CreateGroupService$checkPickEntityMemberCountBeforeCreate$1", f = "CreateGroupService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreateGroupService$checkPickEntityMemberCountBeforeCreate$1 extends SuspendLambda implements Function2<PullChangeGroupMemberAuthorizationResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<m> $callback;
    /* synthetic */ Object L$0;
    int label;

    public CreateGroupService$checkPickEntityMemberCountBeforeCreate$1(IGetDataCallback<m> r100, Continuation<? super CreateGroupService$checkPickEntityMemberCountBeforeCreate$1> r101) {
        this.$callback = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CreateGroupService$checkPickEntityMemberCountBeforeCreate$1 r102 = new CreateGroupService$checkPickEntityMemberCountBeforeCreate$1(this.$callback, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(PullChangeGroupMemberAuthorizationResponse r100, Continuation<? super Unit> r101) {
        return ((CreateGroupService$checkPickEntityMemberCountBeforeCreate$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(PullChangeGroupMemberAuthorizationResponse r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        PullChangeGroupMemberAuthorizationResponse r101 = (PullChangeGroupMemberAuthorizationResponse) this.L$0;
        IGetDataCallback<m> r102 = this.$callback;
        int r103 = m.f410320e;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        boolean r104 = r101.mpass.booleanValue();
        String r105 = r101.mmsg_description;
        if (r105 != null) goto L7;
        r105 = "";
    L7:
        r102.onSuccess(new m(r104, r105, r101.mneed_apply_for_incr.booleanValue(), r101.mis_cross_tenant.booleanValue()));
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
