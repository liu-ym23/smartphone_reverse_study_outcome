package com.ss.android.lark.mention.base.impl.atselector.view;

import android.view.View;
import com.ss.android.lark.ui.IActionTitlebar$TextAction;

/* JADX INFO: loaded from: classes36.dex */
public final class g extends IActionTitlebar$TextAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtView f431845a;

    @Override // com.ss.android.lark.ui.IActionTitlebar$BaseAction, com.ss.android.lark.ui.IActionTitlebar$Action
    public final void performAction(View r100) {
        AtView r101 = this.f431845a;
        r101.f431818i.V2(r101.f431817h);
    }

    public g(AtView r100, String r101) {
        this.f431845a = r100;
        super(r101);
    }
}
