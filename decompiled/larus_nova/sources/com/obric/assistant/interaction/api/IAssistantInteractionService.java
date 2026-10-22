package com.obric.assistant.interaction.api;

import com.obric.assistant.interaction.api.lifecycle.ILifecycleService;
import com.obric.assistant.interaction.api.service.IAuthenticationOnLockScreenService;
import com.obric.assistant.interaction.api.service.IInteractionStateApi;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0014H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/interaction/api/IAssistantInteractionService;", "", "_interactionStateService", "Lcom/obric/assistant/interaction/api/service/IInteractionStateService;", "get_interactionStateService", "()Lcom/obric/assistant/interaction/api/service/IInteractionStateService;", "_interactionStateApi", "Lcom/obric/assistant/interaction/api/service/IInteractionStateApi;", "get_interactionStateApi", "()Lcom/obric/assistant/interaction/api/service/IInteractionStateApi;", "_authenOnLockScreenService", "Lcom/obric/assistant/interaction/api/service/IAuthenticationOnLockScreenService;", "get_authenOnLockScreenService", "()Lcom/obric/assistant/interaction/api/service/IAuthenticationOnLockScreenService;", "lifecycleServices", "", "Lcom/obric/assistant/interaction/api/lifecycle/ILifecycleService;", "getLifecycleServices", "()Ljava/util/List;", "systemStateInit", "", "soundEffectInit", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAssistantInteractionService {
    List<ILifecycleService> getLifecycleServices();

    IAuthenticationOnLockScreenService get_authenOnLockScreenService();

    IInteractionStateApi get_interactionStateApi();

    IInteractionStateService get_interactionStateService();

    void soundEffectInit();

    void systemStateInit();
}
