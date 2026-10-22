package com.bytedance.ee.bear.middleground.comment.audio;

import android.view.View;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecordPanelView f230340a;

    public h(RecordPanelView r100) {
        this.f230340a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.ee.bear.middleground.comment.uitls.h r101 = this.f230340a.getCommentAnalytic();
        if (r101 == null) goto L5;
        r101.m("switch_lan");
    L5:
        RecordPanelView r102 = this.f230340a;
        com.bytedance.ee.bear.widgets.a r103 = new com.bytedance.ee.bear.widgets.a(r102.getContext());
        r103.e(R.string.Doc_Comment_Chinese, new i(r102));
        r103.e(R.string.Doc_Comment_English, new j(r102));
        int r104 = r102.getContext().getResources().getColor(R.color.function_danger_fill_default);
        cp5.b r105 = new cp5.b();
        r105.f464689a = null;
        r105.f464692d = false;
        r105.f464693e = null;
        r105.f464694f = null;
        r105.f464691c = false;
        r105.f464690b = r104;
        r105.f464695g = true;
        r105.f464696h = 1.0f;
        r105.f464697i = true;
        r103.c(r105);
        LKUIDialog r106 = r103.l();
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(r106);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
    }
}
