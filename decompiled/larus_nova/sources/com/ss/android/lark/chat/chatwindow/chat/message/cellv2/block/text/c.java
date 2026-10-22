package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text;

import android.view.ViewTreeObserver;
import com.larksuite.framework.ui.BasePopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements ViewTreeObserver.OnScrollChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g7b.a f413273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextClickListenerProviderV2 f413274b;

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        BasePopupWindow r100 = this.f413273a.f480363e;
        if (r100 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
    L5:
        this.f413274b.f413261b.getViewTreeObserver().removeOnScrollChangedListener(this);
    }

    public c(g7b.a r100, TextClickListenerProviderV2 r101) {
        this.f413273a = r100;
        this.f413274b = r101;
    }
}
