package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class MmRecordingUploadDiagnosisReporter$1 extends FunctionReferenceImpl implements Function0<Long> {
    public static final MmRecordingUploadDiagnosisReporter$1 INSTANCE = null;

    static {
        INSTANCE = new MmRecordingUploadDiagnosisReporter$1();
    }

    public MmRecordingUploadDiagnosisReporter$1() {
        super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return Long.valueOf(System.currentTimeMillis());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }
}
