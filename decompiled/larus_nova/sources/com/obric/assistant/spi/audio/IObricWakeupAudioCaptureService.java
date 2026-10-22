package com.obric.assistant.spi.audio;

import hga.c;
import hga.e;
import hga.f;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/obric/assistant/spi/audio/IObricWakeupAudioCaptureService;", "", "isCaptureEnabled", "", "hasActiveCapture", "onWakeupTrigger", "", "trigger", "Lcom/obric/assistant/spi/audio/WakeupAudioCaptureTrigger;", "openReader", "Lcom/obric/assistant/spi/audio/IObricWakeupAudioCaptureReader;", "request", "Lcom/obric/assistant/spi/audio/WakeupAudioCaptureReadRequest;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricWakeupAudioCaptureService {
    boolean a();

    void b(f r100);

    c c(e r100);
}
