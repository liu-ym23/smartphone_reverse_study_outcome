package com.larus.avlink.record.util;

import com.larus.avlink.n1;
import com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.record.util.LarkRecordMinutesManager$reportRecordingIdToGlasses$1", f = "LarkRecordMinutesManager.kt", i = {}, l = {584}, m = "invokeSuspend", n = {}, s = {})
final class LarkRecordMinutesManager$reportRecordingIdToGlasses$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $recordingId;
    final /* synthetic */ IDoraOfflineRecordSyncService $syncService;
    final /* synthetic */ String $wakeupId;
    private /* synthetic */ Object L$0;
    int label;

    public LarkRecordMinutesManager$reportRecordingIdToGlasses$1(String r100, String r101, IDoraOfflineRecordSyncService r102, Continuation<? super LarkRecordMinutesManager$reportRecordingIdToGlasses$1> r103) {
        this.$recordingId = r100;
        this.$wakeupId = r101;
        this.$syncService = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        LarkRecordMinutesManager$reportRecordingIdToGlasses$1 r102 = new LarkRecordMinutesManager$reportRecordingIdToGlasses$1(this.$recordingId, this.$wakeupId, this.$syncService, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((LarkRecordMinutesManager$reportRecordingIdToGlasses$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
    L13:
        Object r103 = Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r100).booleanValue()));     // Catch: Throwable -> L15
    L17:
        String r104 = this.$recordingId;
        String r105 = this.$wakeupId;
        Throwable r106 = Result.m9452exceptionOrNullimpl(r103);
        if (r106 == null) goto L20;
        n1.b("LarkRecordMinutesManager", "report recordingId to glasses failed, id=" + r104 + ", wakeupId=" + r105 + ", err=" + r106.getMessage());
    L20:
        Boolean r107 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r103) == false) goto L23;
        r103 = r107;
    L23:
        n1.d("LarkRecordMinutesManager", "report recordingId to glasses done, success=" + ((Boolean) r103).booleanValue() + ", id=" + this.$recordingId + ", wakeupId=" + this.$wakeupId);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r108 = (CoroutineScope) this.L$0;
        IDoraOfflineRecordSyncService r109 = this.$syncService;
        String r110 = this.$wakeupId;
        String r111 = this.$recordingId;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r100 = r109.a(r110, r111, this);     // Catch: Throwable -> L15
        if (r100 != r101) goto L13;
        return r101;
    L15:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
