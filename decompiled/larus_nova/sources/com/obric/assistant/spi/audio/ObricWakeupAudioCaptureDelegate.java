package com.obric.assistant.spi.audio;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hga.c;
import hga.e;
import hga.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/spi/audio/ObricWakeupAudioCaptureDelegate;", "Lcom/obric/assistant/spi/audio/IObricWakeupAudioCaptureService;", "<init>", "()V", "hasActiveCapture", "", "isCaptureEnabled", "onWakeupTrigger", "", "trigger", "Lcom/obric/assistant/spi/audio/WakeupAudioCaptureTrigger;", "openReader", "Lcom/obric/assistant/spi/audio/IObricWakeupAudioCaptureReader;", "request", "Lcom/obric/assistant/spi/audio/WakeupAudioCaptureReadRequest;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWakeupAudioCaptureDelegate implements IObricWakeupAudioCaptureService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricWakeupAudioCaptureDelegate f392843b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricWakeupAudioCaptureService f392844a;

    static {
        f392843b = new ObricWakeupAudioCaptureDelegate();
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService
    public final boolean a() {
        return this.f392844a.a();
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService
    public final void b(f r100) {
        Intrinsics.checkNotNullParameter(r100, "trigger");
        this.f392844a.b(r100);
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService
    public final c c(e r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        return this.f392844a.c(r100);
    }

    private ObricWakeupAudioCaptureDelegate() {
        this.f392844a = (IObricWakeupAudioCaptureService) ServiceManager.get().getService(IObricWakeupAudioCaptureService.class);
    }
}
