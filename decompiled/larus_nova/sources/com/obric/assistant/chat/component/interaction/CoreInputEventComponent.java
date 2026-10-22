package com.obric.assistant.chat.component.interaction;

import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.AssistantTextModeServiceDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/chat/component/interaction/CoreInputEventComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/ability/interaction/ICoreInputEventAbility;", "<init>", "()V", "start", "", "botId", "", "conversationId", "hasAttachment", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CoreInputEventComponent extends ComponentFeature implements uaa.a {

    public static final class a {
    }

    static {
    }

    public CoreInputEventComponent() {
    }

    @Override // uaa.a
    public final void t8(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        FLogger.f375446a.i("CoreInputEventComponent", "start");
        AssistantTextModeServiceDelegate.f385657b.t8(r100, r101, r102);
    }
}
