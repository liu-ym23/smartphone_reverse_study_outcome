package com.bytedance.ee.bear.middleground.permission.apply;

import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s extends CommonActionPanelLayout.b {
    public final /* synthetic */ ApplyPermissionPanel a;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void b() {
        tt5.a.h("ApplyPermissionPanel", "onClickLeftIcon()...");
        if (com.bytedance.ee.util.ui.b.a(this.a.getActivity()) == true) goto L12;
        return;
    L12:
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L15;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public s(ApplyPermissionPanel r1) {
        this.a = r1;
    }
}
