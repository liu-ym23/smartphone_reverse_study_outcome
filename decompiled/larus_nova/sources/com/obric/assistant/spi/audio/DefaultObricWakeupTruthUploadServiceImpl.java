package com.obric.assistant.spi.audio;

import com.obric.sva.sdk.utils.InteractConst;
import hga.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/spi/audio/DefaultObricWakeupTruthUploadServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricWakeupTruthUploadService;", "<init>", "()V", "onVoiceWakeupCaptureStarted", "", "onVoiceWakeupAudioCaptured", "data", "Lcom/obric/assistant/spi/audio/WakeupTruthUploadData;", "clearRegisterDataIdForUid", "uid", "", "reason", "markVoiceprintRecordedForNextWakeup", "consumeFirstWakeupAfterVoiceprintRecord", "", "markWakeupPocketMode", InteractConst.WAKEUP_WAKEUP_ID, "", "pocketMode", "consumeWakeupPocketMode", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricWakeupTruthUploadServiceImpl implements IObricWakeupTruthUploadService {
    public DefaultObricWakeupTruthUploadServiceImpl() {
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void a() {
        Intrinsics.checkNotNullParameter("voiceprint enroll success", "reason");
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void b() {
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final boolean c() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void d(int r100, boolean r101) {
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void e(g r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "reason");
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final boolean g(int r100) {
        return false;
    }
}
