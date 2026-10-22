package com.obric.assistant.interaction.api.keyguard;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/api/keyguard/IKeyguardBiometricSetting;", "", "init", "", "requestBiometricState", "requestSource", "Lcom/obric/assistant/interaction/api/keyguard/RequestSource;", "state", "Lcom/obric/assistant/interaction/api/keyguard/BiometricState;", "cancelRequestBiometricState", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKeyguardBiometricSetting {
    void cancelRequestBiometricState(RequestSource r100);

    void init();

    void requestBiometricState(RequestSource r100, BiometricState r101);
}
