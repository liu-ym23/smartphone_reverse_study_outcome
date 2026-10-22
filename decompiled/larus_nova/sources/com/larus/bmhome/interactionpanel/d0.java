package com.larus.bmhome.interactionpanel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d0 implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainConversationInteractionPanelHostComponent f312341a;

    public d0(MainConversationInteractionPanelHostComponent r100) {
        this.f312341a = r100;
    }

    @Override // com.larus.bmhome.chat.component.cvs.y.a
    public final void c(wc9.e r100) {
        Intrinsics.checkNotNullParameter(r100, "new");
        MainConversationInteractionPanelHostComponent r101 = this.f312341a;
        int r102 = MainConversationInteractionPanelHostComponent.f312292u;
        r101.F2().post(new z(r101, "conversationChanged"));
    }
}
