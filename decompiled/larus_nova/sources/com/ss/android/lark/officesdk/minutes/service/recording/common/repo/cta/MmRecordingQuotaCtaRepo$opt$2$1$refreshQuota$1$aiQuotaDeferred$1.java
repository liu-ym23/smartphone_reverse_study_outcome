package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmQuotaData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$aiQuotaDeferred$1", f = "MmRecordingQuotaCtaRepo.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$aiQuotaDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends MmQuotaData>>, Object> {
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a $netHelper;
    final /* synthetic */ String $token;
    int label;
    final /* synthetic */ MmRecordingQuotaCtaRepo this$0;

    public MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$aiQuotaDeferred$1(com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a r100, String r101, MmRecordingQuotaCtaRepo r102, Continuation<? super MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$aiQuotaDeferred$1> r103) {
        this.$netHelper = r100;
        this.$token = r101;
        this.this$0 = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$aiQuotaDeferred$1(this.$netHelper, this.$token, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Result<? extends MmQuotaData>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Result<MmQuotaData>> r101) {
        return ((MmRecordingQuotaCtaRepo$opt$2$1$refreshQuota$1$aiQuotaDeferred$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
        Object r103 = ((Result) r100).m9458unboximpl();
    L12:
        return Result.m9448boximpl(r103);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.a r104 = this.$netHelper;
        String r105 = this.$token;
        MmQuotaType r106 = MmQuotaType.AI_SUMMARY;
        MmRecordingSource r107 = this.this$0.f434904k;
        this.label = 1;
        r103 = r104.a(r105, r106, r107, "minutes_recording_notes_page", this);
        if (r103 != r101) goto L12;
        return r101;
    }
}
