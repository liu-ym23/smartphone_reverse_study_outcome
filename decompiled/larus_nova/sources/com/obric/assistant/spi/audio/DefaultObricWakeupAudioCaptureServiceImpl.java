package com.obric.assistant.spi.audio;

import hga.c;
import hga.e;
import hga.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/spi/audio/DefaultObricWakeupAudioCaptureServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricWakeupAudioCaptureService;", "<init>", "()V", "isCaptureEnabled", "", "hasActiveCapture", "onWakeupTrigger", "", "trigger", "Lcom/obric/assistant/spi/audio/WakeupAudioCaptureTrigger;", "openReader", "Lcom/obric/assistant/spi/audio/IObricWakeupAudioCaptureReader;", "request", "Lcom/obric/assistant/spi/audio/WakeupAudioCaptureReadRequest;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricWakeupAudioCaptureServiceImpl implements IObricWakeupAudioCaptureService {
    public DefaultObricWakeupAudioCaptureServiceImpl() {
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService
    public final boolean a() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService
    public final void b(f r100) {
        Intrinsics.checkNotNullParameter(r100, "trigger");
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService
    public final c c(e r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        return null;
    }
}
