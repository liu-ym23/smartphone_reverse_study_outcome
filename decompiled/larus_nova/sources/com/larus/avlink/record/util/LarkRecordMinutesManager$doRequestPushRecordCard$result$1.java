package com.larus.avlink.record.util;

import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/avlink/record/util/LarkRecordStartData;", "Lcom/larus/avlink/record/util/LarkRecordStartApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.record.util.LarkRecordMinutesManager$doRequestPushRecordCard$result$1", f = "LarkRecordMinutesManager.kt", i = {}, l = {1807}, m = "invokeSuspend", n = {}, s = {})
final class LarkRecordMinutesManager$doRequestPushRecordCard$result$1 extends SuspendLambda implements Function2<LarkRecordStartApi, Continuation<? super BizResponse<l>>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ Integer $productId;
    final /* synthetic */ String $recordingId;
    final /* synthetic */ int $startScene;
    private /* synthetic */ Object L$0;
    int label;

    public LarkRecordMinutesManager$doRequestPushRecordCard$result$1(String r100, String r101, Integer r102, String r103, int r104, Continuation<? super LarkRecordMinutesManager$doRequestPushRecordCard$result$1> r105) {
        this.$botId = r100;
        this.$cvsId = r101;
        this.$productId = r102;
        this.$recordingId = r103;
        this.$startScene = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        LarkRecordMinutesManager$doRequestPushRecordCard$result$1 r101 = new LarkRecordMinutesManager$doRequestPushRecordCard$result$1(this.$botId, this.$cvsId, this.$productId, this.$recordingId, this.$startScene, r110);
        r101.L$0 = r100;
        return r101;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(LarkRecordStartApi r100, Continuation<? super BizResponse<l>> r101) {
        return ((LarkRecordMinutesManager$doRequestPushRecordCard$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(LarkRecordStartApi r100, Continuation<? super BizResponse<l>> r101) {
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
        LarkRecordStartApi r111 = (LarkRecordStartApi) this.L$0;
        m r102 = new m(this.$botId, this.$cvsId, 3, this.$productId, this.$recordingId, this.$startScene);
        this.label = 1;
        r110 = r111.larkRecordStart(r102, this);
        if (r110 != r100) goto L11;
        return r100;
    }
}
