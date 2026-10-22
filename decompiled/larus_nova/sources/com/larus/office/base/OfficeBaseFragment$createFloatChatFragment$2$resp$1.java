package com.larus.office.base;

import androidx.viewbinding.ViewBinding;
import com.larus.network.bean.BizResponse;
import com.larus.office.base.net.OfficeApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/office/base/net/GetSubConversationRespV2;", "Lcom/larus/office/base/net/OfficeApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.OfficeBaseFragment$createFloatChatFragment$2$resp$1", f = "OfficeBaseFragment.kt", i = {}, l = {257}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeBaseFragment$createFloatChatFragment$2$resp$1 extends SuspendLambda implements Function2<OfficeApi, Continuation<? super BizResponse<com.larus.office.base.net.g>>, Object> {
    final /* synthetic */ boolean $isFromSpaceList;
    final /* synthetic */ String $token;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OfficeBaseFragment<ViewBinding> this$0;

    public OfficeBaseFragment$createFloatChatFragment$2$resp$1(OfficeBaseFragment<ViewBinding> r100, boolean r101, String r102, Continuation<? super OfficeBaseFragment$createFloatChatFragment$2$resp$1> r103) {
        this.this$0 = r100;
        this.$isFromSpaceList = r101;
        this.$token = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        OfficeBaseFragment$createFloatChatFragment$2$resp$1 r102 = new OfficeBaseFragment$createFloatChatFragment$2$resp$1(this.this$0, this.$isFromSpaceList, this.$token, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(OfficeApi r100, Continuation<? super BizResponse<com.larus.office.base.net.g>> r101) {
        return ((OfficeBaseFragment$createFloatChatFragment$2$resp$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(OfficeApi r100, Continuation<? super BizResponse<com.larus.office.base.net.g>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L15:
        return r110;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        OfficeApi r111 = (OfficeApi) this.L$0;
        int r102 = this.this$0.Y90();
        if (this.$isFromSpaceList == false) goto L11;
        Integer r103 = null;
    L12:
        String r104 = this.$token;
        com.larus.office.base.net.f r105 = new com.larus.office.base.net.f(r104, r102, r103, true, this.$isFromSpaceList);
        this.label = 1;
        r110 = r111.getSubConversationV2(r105, this);
        if (r110 != r100) goto L15;
        return r100;
    L11:
        r103 = Boxing.boxInt(1);
        goto L12
    }
}
