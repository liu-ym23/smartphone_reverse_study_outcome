package com.ss.android.lark.compose.chatsetting.report;

import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.compose.chatsetting.service.FlowChatSettingService;
import com.ss.android.lark.pb.messages.GenLarkReportUrlResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larksuite/rucket/job/base/RucketResult;", "Lcom/ss/android/lark/pb/messages/GenLarkReportUrlResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.report.FlowReportManager$report$1$response$1", f = "FlowReportManager.kt", i = {}, l = {40, 40}, m = "invokeSuspend", n = {}, s = {})
public final class FlowReportManager$report$1$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larksuite.rucket.job.base.b<? extends GenLarkReportUrlResponse>>, Object> {
    final /* synthetic */ String $chatId;
    int label;

    public FlowReportManager$report$1$response$1(String r100, Continuation<? super FlowReportManager$report$1$response$1> r101) {
        this.$chatId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FlowReportManager$report$1$response$1(this.$chatId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super com.larksuite.rucket.job.base.b<? extends GenLarkReportUrlResponse>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super com.larksuite.rucket.job.base.b<GenLarkReportUrlResponse>> r101) {
        return ((FlowReportManager$report$1$response$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L16:
        return r100;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L13:
        this.label = 2;
        r100 = ((RucketJob) r100).awaitGet(this);
        if (r100 != r101) goto L16;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        FlowChatSettingService r103 = FlowChatSettingService.f417519a;
        String r104 = this.$chatId;
        this.label = 1;
        r100 = r103.a(r104, this);
        if (r100 != r101) goto L13;
        return r101;
    }
}
