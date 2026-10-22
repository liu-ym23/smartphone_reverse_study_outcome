package com.bytedance.ee.bear.middleground.comment.audio;

import android.view.View;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ RecordPanelView a;

    public h(RecordPanelView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        com.bytedance.ee.bear.middleground.comment.uitls.h r6 = this.a.getCommentAnalytic();
        if (r6 == null) goto L5;
        r6.m("switch_lan");
    L5:
        RecordPanelView r7 = this.a;
        com.bytedance.ee.bear.widgets.a r1 = new com.bytedance.ee.bear.widgets.a(r7.getContext());
        r1.e(2131887607, new i(r7));
        r1.e(2131887618, new j(r7));
        int r8 = r7.getContext().getResources().getColor(2131102093);
        cp5.b r0 = new cp5.b();
        r0.a = null;
        r0.d = false;
        r0.e = null;
        r0.f = null;
        r0.c = false;
        r0.b = r8;
        r0.g = true;
        r0.h = 1.0f;
        r0.i = true;
        r1.c(r0);
        LKUIDialog r9 = r1.l();
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(r9);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
    }
}
