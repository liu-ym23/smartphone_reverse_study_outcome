package com.obric.assistant.spi.audio;

import com.obric.sva.sdk.utils.InteractConst;
import hga.g;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH&J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/spi/audio/IObricWakeupTruthUploadService;", "", "onVoiceWakeupCaptureStarted", "", "onVoiceWakeupAudioCaptured", "data", "Lcom/obric/assistant/spi/audio/WakeupTruthUploadData;", "clearRegisterDataIdForUid", "uid", "", "reason", "markVoiceprintRecordedForNextWakeup", "consumeFirstWakeupAfterVoiceprintRecord", "", "markWakeupPocketMode", InteractConst.WAKEUP_WAKEUP_ID, "", "pocketMode", "consumeWakeupPocketMode", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricWakeupTruthUploadService {
    void a();

    void b();

    boolean c();

    void d(int r100, boolean r101);

    void e(g r100);

    void f(String r100, String r101);

    boolean g(int r100);
}
