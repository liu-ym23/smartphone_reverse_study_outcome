package com.obric.assistant.audio.service;

import com.obric.assistant.state.impl.v2.power.ObricPowerManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/audio/service/IObricIntentStatusService;", "", "notifyAutoGuiInProgress", "", "cvsId", "", "questionId", "registerAutoGuiProgressCallback", "callback", "Lcom/obric/assistant/audio/callback/IAutoGuiProgressCallback;", "unregisterAutoGuiProgressCallback", "notifyObricIntentStatusChanged", "isActive", "", "registerObricIntentStatusChangedObserver", "Lcom/obric/assistant/audio/callback/IObricIntentStatusChangedObserver;", "unregisterObricIntentStatusChangedObserver", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricIntentStatusService {
    void a(String r100, String r101);

    void b(boolean r100);

    void c(ObricPowerManager.a r100);
}
