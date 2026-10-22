package com.obric.assistant.chat;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.ui.arch.component.external.api.Component;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/chat/ObricChatCommonComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "<init>", "()V", "onAttach", "", LiveCommonConstants.REASON_ON_DEDTROY, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatCommonComponent extends Component {
    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        IObricChatService.f386556a.getClass();
        IObricChatService r100 = IObricChatService.a.a();
        if (r100 == null) goto L6;
        r100.b(this);
        return;
    }

    @Override // com.larus.ui.arch.component.external.api.Component, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        IObricChatService.f386556a.getClass();
        IObricChatService r100 = IObricChatService.a.a();
        if (r100 == null) goto L6;
        r100.a(this);
        return;
    }

    public ObricChatCommonComponent() {
    }
}
