package com.obric.assistant.interaction.api;

import com.obric.assistant.interaction.api.service.IAuthenticationOnLockScreenService;
import com.obric.assistant.interaction.api.service.IInteractionStateApi;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"AssistantInteractionServiceProxy", "Lcom/obric/assistant/interaction/api/IAssistantInteractionService;", "getAssistantInteractionServiceProxy", "()Lcom/obric/assistant/interaction/api/IAssistantInteractionService;", "AssistantInteractionServiceProxy$delegate", "Lkotlin/Lazy;", "interactionStateService", "Lcom/obric/assistant/interaction/api/service/IInteractionStateService;", "getInteractionStateService", "()Lcom/obric/assistant/interaction/api/service/IInteractionStateService;", "interactionStateApi", "Lcom/obric/assistant/interaction/api/service/IInteractionStateApi;", "getInteractionStateApi", "()Lcom/obric/assistant/interaction/api/service/IInteractionStateApi;", "authenOnLockScreenService", "Lcom/obric/assistant/interaction/api/service/IAuthenticationOnLockScreenService;", "getAuthenOnLockScreenService", "()Lcom/obric/assistant/interaction/api/service/IAuthenticationOnLockScreenService;", "api_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class IAssistantInteractionServiceKt {
    private static final Lazy AssistantInteractionServiceProxy$delegate = null;

    public static /* synthetic */ IAssistantInteractionService a() {
        return AssistantInteractionServiceProxy_delegate$lambda$0();
    }

    static {
        AssistantInteractionServiceProxy$delegate = LazyKt.lazy(new b());
    }

    private static final IAssistantInteractionService AssistantInteractionServiceProxy_delegate$lambda$0() {
        Object r100 = ServiceManager.get().getService(IAssistantInteractionService.class);
        Intrinsics.checkNotNull(r100);
        return (IAssistantInteractionService) r100;
    }

    public static final IAssistantInteractionService getAssistantInteractionServiceProxy() {
        return (IAssistantInteractionService) AssistantInteractionServiceProxy$delegate.getValue();
    }

    public static final IAuthenticationOnLockScreenService getAuthenOnLockScreenService() {
        return getAssistantInteractionServiceProxy().get_authenOnLockScreenService();
    }

    public static final IInteractionStateApi getInteractionStateApi() {
        return getAssistantInteractionServiceProxy().get_interactionStateApi();
    }

    public static final IInteractionStateService getInteractionStateService() {
        return getAssistantInteractionServiceProxy().get_interactionStateService();
    }
}
