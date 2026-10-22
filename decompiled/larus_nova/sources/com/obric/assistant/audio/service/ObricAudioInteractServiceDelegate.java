package com.obric.assistant.audio.service;

import com.obric.assistant.chat.component.interaction.a;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\u0005H\u0096\u0001¨\u0006\t"}, d2 = {"Lcom/obric/assistant/audio/service/ObricAudioInteractServiceDelegate;", "Lcom/obric/assistant/audio/service/IObricAudioInteractService;", "<init>", "()V", "readLatestMessage", "", "start", "Lkotlin/Function0;", "stop", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAudioInteractServiceDelegate implements IObricAudioInteractService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricAudioInteractServiceDelegate f385672b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricAudioInteractService f385673a;

    static {
        f385672b = new ObricAudioInteractServiceDelegate();
    }

    @Override // com.obric.assistant.audio.service.IObricAudioInteractService
    public final void a() {
        this.f385673a.a();
    }

    @Override // com.obric.assistant.audio.service.IObricAudioInteractService
    public final void b(a r100) {
        this.f385673a.b(r100);
    }

    @Override // com.obric.assistant.audio.service.IObricAudioInteractService
    public final void stop() {
        this.f385673a.stop();
    }

    private ObricAudioInteractServiceDelegate() {
        this.f385673a = (IObricAudioInteractService) ServiceManager.get().getService(IObricAudioInteractService.class);
    }
}
