package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MmStandaloneAIInterpretationStateHandler$onStateChanged$4 extends FunctionReferenceImpl implements Function0<Unit> {
    public MmStandaloneAIInterpretationStateHandler$onStateChanged$4(Object r100) {
        super(0, r100, MmRecordingUploadService.class, "checkNeedTransitionToUploaded", "checkNeedTransitionToUploaded()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((MmRecordingUploadService) this.receiver).d();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
