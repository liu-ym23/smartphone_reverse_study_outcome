package com.obric.assistant.audio.service;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J!\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0096\u0001¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/audio/service/ManualHalfDuplexModeServiceDelegate;", "Lcom/obric/assistant/audio/service/IManualHalfDuplexModeService;", "<init>", "()V", "onCanceled", "", "botId", "", "onFailed", "onQueryEnd", "text", "onQueryEndSession", "sessionId", "onStarted", "start", "conversationId", "hasAttachment", "", "startSession", "stop", "stopSession", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ManualHalfDuplexModeServiceDelegate implements IManualHalfDuplexModeService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ManualHalfDuplexModeServiceDelegate f385663b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IManualHalfDuplexModeService f385664a;

    static {
        f385663b = new ManualHalfDuplexModeServiceDelegate();
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f385664a.a(r100, r101);
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        this.f385664a.b(r100);
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final String c(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        return this.f385664a.c(r100, r101, r102);
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        this.f385664a.d(r100);
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final void stop(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        this.f385664a.stop(r100);
    }

    private ManualHalfDuplexModeServiceDelegate() {
        this.f385664a = (IManualHalfDuplexModeService) ServiceManager.get().getService(IManualHalfDuplexModeService.class);
    }
}
