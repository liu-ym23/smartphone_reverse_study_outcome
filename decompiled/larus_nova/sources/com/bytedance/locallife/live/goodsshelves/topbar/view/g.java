package com.bytedance.locallife.live.goodsshelves.topbar.view;

import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: classes21.dex */
public final class g implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLocalLifeTopBarFunctionView f259958a;

    @Override // com.bytedance.locallife.live.goodsshelves.topbar.view.h.a
    public final void a() {
        xl4.a r100 = this.f259958a.f259938g;
        if (r100 == null) goto L6;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
        return;
    }

    public g(LiveLocalLifeTopBarFunctionView r100) {
        this.f259958a = r100;
    }
}
