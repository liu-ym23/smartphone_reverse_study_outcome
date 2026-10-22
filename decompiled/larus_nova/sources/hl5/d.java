package hl5;

import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends CommonActionPanelLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f485677a;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void b() {
        this.f485677a.f485680b.dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L12;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public d(f r100) {
        this.f485677a = r100;
    }
}
