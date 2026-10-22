package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.MmRtcWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MmRecordingAudioService$startAudioCapture$2 extends FunctionReferenceImpl implements Function1<sub.a, Unit> {
    public MmRecordingAudioService$startAudioCapture$2(Object r100) {
        super(1, r100, MmRtcWrapper.class, "pushExternalEncodedAudioFrame", "pushExternalEncodedAudioFrame(Lcom/ss/android/lark/officesdk/minutes/api/recording/common/external_audio/ExternalEncodedAudioFrame;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(sub.a r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((MmRtcWrapper) this.receiver).i(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(sub.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
