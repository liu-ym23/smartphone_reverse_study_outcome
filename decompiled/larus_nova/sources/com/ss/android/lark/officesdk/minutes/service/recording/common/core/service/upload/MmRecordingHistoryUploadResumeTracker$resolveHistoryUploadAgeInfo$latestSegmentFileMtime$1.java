package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$latestSegmentFileMtime$1", f = "MmRecordingHistoryUploadResumeTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$latestSegmentFileMtime$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ List<File> $segmentFiles;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$latestSegmentFileMtime$1(List<? extends File> r100, Continuation<? super MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$latestSegmentFileMtime$1> r101) {
        this.$segmentFiles = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$latestSegmentFileMtime$1(this.$segmentFiles, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Long> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Long> r101) {
        return ((MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$latestSegmentFileMtime$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        List<File> r101 = this.$segmentFiles;
        Intrinsics.checkNotNullParameter(r101, "segmentFiles");
        return (Long) SequencesKt.maxOrNull(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(r101), MmRecordingHistoryUploadResumeTrackerKt$resolveLatestSegmentFileMtime$1.INSTANCE), MmRecordingHistoryUploadResumeTrackerKt$resolveLatestSegmentFileMtime$2.INSTANCE));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
