package com.obric.assistant.audio.service;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/audio/service/ObricAssistantBaseServiceDelegate;", "Lcom/obric/assistant/audio/service/IObricAssistantBaseService;", "<init>", "()V", "interruptCurrentConversation", "", "interruptTts", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAssistantBaseServiceDelegate implements IObricAssistantBaseService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricAssistantBaseServiceDelegate f385667b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricAssistantBaseService f385668a;

    static {
        f385667b = new ObricAssistantBaseServiceDelegate();
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantBaseService
    public final void a() {
        this.f385668a.a();
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantBaseService
    public final void b() {
        this.f385668a.b();
    }

    private ObricAssistantBaseServiceDelegate() {
        this.f385668a = (IObricAssistantBaseService) ServiceManager.get().getService(IObricAssistantBaseService.class);
    }
}
