package com.larus.commercecredit.impl.component;

import com.larus.commercecredit.api.ICommerceCreditService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/larus/commercecredit/impl/component/ChatCommerceCreditLogicComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "<init>", "()V", "onResume", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatCommerceCreditLogicComponent extends ComponentFeature {

    public static final class a {
    }

    static {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        FLogger.f375446a.d("ChatCommerceCreditLogicComponent", "onResume triggerZlinkClipboardCheck");
        ICommerceCreditService.f325667a.getClass();
        ICommerceCreditService r100 = ICommerceCreditService.a.a();
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.o("ChatCommerceCreditLogicComponent_onResume") != true) goto L7;
    L8:
        if (r101 == false) goto L12;
        ICommerceCreditService r102 = ICommerceCreditService.a.a();
        if (r102 == null) goto L12;
        r102.e("ChatCommerceCreditLogicComponent_onResume");
    L12:
        ICommerceCreditService r103 = ICommerceCreditService.a.a();
        if (r103 == null) goto L16;
        r103.f("", "ChatCommerceCreditLogicComponent_onResume");
        return;
    L16:
        return;
    L7:
        r101 = false;
        goto L8
    }

    public ChatCommerceCreditLogicComponent() {
    }
}
