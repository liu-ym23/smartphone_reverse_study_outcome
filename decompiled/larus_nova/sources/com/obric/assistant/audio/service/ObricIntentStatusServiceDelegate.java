package com.obric.assistant.audio.service;

import com.obric.assistant.state.impl.v2.power.ObricPowerManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0010H\u0096\u0001¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/audio/service/ObricIntentStatusServiceDelegate;", "Lcom/obric/assistant/audio/service/IObricIntentStatusService;", "<init>", "()V", "notifyAutoGuiInProgress", "", "cvsId", "", "questionId", "notifyObricIntentStatusChanged", "isActive", "", "registerAutoGuiProgressCallback", "callback", "Lcom/obric/assistant/audio/callback/IAutoGuiProgressCallback;", "registerObricIntentStatusChangedObserver", "Lcom/obric/assistant/audio/callback/IObricIntentStatusChangedObserver;", "unregisterAutoGuiProgressCallback", "unregisterObricIntentStatusChangedObserver", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricIntentStatusServiceDelegate implements IObricIntentStatusService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricIntentStatusServiceDelegate f385674b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricIntentStatusService f385675a;

    static {
        f385674b = new ObricIntentStatusServiceDelegate();
    }

    @Override // com.obric.assistant.audio.service.IObricIntentStatusService
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "questionId");
        this.f385675a.a(r100, r101);
    }

    @Override // com.obric.assistant.audio.service.IObricIntentStatusService
    public final void b(boolean r100) {
        this.f385675a.b(r100);
    }

    @Override // com.obric.assistant.audio.service.IObricIntentStatusService
    public final void c(ObricPowerManager.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f385675a.c(r100);
    }

    private ObricIntentStatusServiceDelegate() {
        this.f385675a = (IObricIntentStatusService) ServiceManager.get().getService(IObricIntentStatusService.class);
    }
}
