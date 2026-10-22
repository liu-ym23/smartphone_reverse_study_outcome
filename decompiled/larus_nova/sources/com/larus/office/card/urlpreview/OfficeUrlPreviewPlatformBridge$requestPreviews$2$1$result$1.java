package com.larus.office.card.urlpreview;

import com.larus.network.bean.BizResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/office/card/urlpreview/OfficeUrlPreviewResponse;", "Lcom/larus/office/card/urlpreview/OfficeUrlPreviewApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.card.urlpreview.OfficeUrlPreviewPlatformBridge$requestPreviews$2$1$result$1", f = "OfficeUrlPreviewPlatformBridge.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeUrlPreviewPlatformBridge$requestPreviews$2$1$result$1 extends SuspendLambda implements Function2<OfficeUrlPreviewApi, Continuation<? super BizResponse<f2>>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ List<String> $requestUrls;
    private /* synthetic */ Object L$0;
    int label;

    public OfficeUrlPreviewPlatformBridge$requestPreviews$2$1$result$1(List<String> r100, String r101, Continuation<? super OfficeUrlPreviewPlatformBridge$requestPreviews$2$1$result$1> r102) {
        this.$requestUrls = r100;
        this.$messageId = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        OfficeUrlPreviewPlatformBridge$requestPreviews$2$1$result$1 r102 = new OfficeUrlPreviewPlatformBridge$requestPreviews$2$1$result$1(this.$requestUrls, this.$messageId, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(OfficeUrlPreviewApi r100, Continuation<? super BizResponse<f2>> r101) {
        return ((OfficeUrlPreviewPlatformBridge$requestPreviews$2$1$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(OfficeUrlPreviewApi r100, Continuation<? super BizResponse<f2>> r101) {
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
        OfficeUrlPreviewApi r103 = (OfficeUrlPreviewApi) this.L$0;
        b2 r104 = new b2(this.$requestUrls, this.$messageId);
        this.label = 1;
        r100 = r103.getOrCreatePreview(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
