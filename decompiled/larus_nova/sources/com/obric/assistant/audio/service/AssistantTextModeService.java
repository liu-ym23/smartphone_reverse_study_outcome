package com.obric.assistant.audio.service;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.IObricInteractionModeService;
import com.obric.assistant.state.api.multitask.ObricInteractionModeServiceDelegate;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/audio/service/AssistantTextModeService;", "Lcom/obric/assistant/audio/service/IAssistantTextModeService;", "<init>", "()V", "start", "", "botId", "", "conversationId", "hasAttachment", "", "stop", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantTextModeService implements IAssistantTextModeService {

    public static final class a {
    }

    static {
    }

    public AssistantTextModeService() {
    }

    @Override // com.obric.assistant.audio.service.IAssistantTextModeService
    public final void t8(String r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "botId");
        Intrinsics.checkNotNullParameter(r111, "conversationId");
        FLogger.f375446a.d("AssistantTextModeService", "start botId:" + r110 + " convId:" + r111 + " hasAttachment:" + r112);
        IObricInteractionModeService.a.b(ObricInteractionModeServiceDelegate.f392941b, r110, r111, ObricInteractionType.TextMode, MapsKt.mapOf(TuplesKt.to("has_attachment", Boolean.valueOf(r112))), 8);
    }
}
