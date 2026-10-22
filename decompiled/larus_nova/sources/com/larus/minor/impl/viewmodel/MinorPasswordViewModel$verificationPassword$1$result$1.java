package com.larus.minor.impl.viewmodel;

import com.larus.minor.impl.api.MinorApi;
import com.larus.minor.impl.api.QuitMinotRequest;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/minor/impl/api/MinorApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.minor.impl.viewmodel.MinorPasswordViewModel$verificationPassword$1$result$1", f = "MinorPasswordViewModel.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
public final class MinorPasswordViewModel$verificationPassword$1$result$1 extends SuspendLambda implements Function2<MinorApi, Continuation<? super BizResponse<Unit>>, Object> {
    final /* synthetic */ String $passwordSHA;
    private /* synthetic */ Object L$0;
    int label;

    public MinorPasswordViewModel$verificationPassword$1$result$1(String r100, Continuation<? super MinorPasswordViewModel$verificationPassword$1$result$1> r101) {
        this.$passwordSHA = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MinorPasswordViewModel$verificationPassword$1$result$1 r102 = new MinorPasswordViewModel$verificationPassword$1$result$1(this.$passwordSHA, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(MinorApi r100, Continuation<? super BizResponse<Unit>> r101) {
        return ((MinorPasswordViewModel$verificationPassword$1$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(MinorApi r100, Continuation<? super BizResponse<Unit>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        MinorApi r103 = (MinorApi) this.L$0;
        QuitMinotRequest r104 = new QuitMinotRequest(this.$passwordSHA);
        this.label = 1;
        r100 = r103.requestQuitMinor(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
