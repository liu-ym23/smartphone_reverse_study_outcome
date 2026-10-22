package com.ss.android.lark.locationmessage.ui.navigation;

import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public final class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NavigateView f431374a;

    public q(NavigateView r100) {
        this.f431374a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        NavigateView r101 = this.f431374a;
        String[] r102 = NavigateView.f431337p;
        r101.getClass();
        com.larksuite.component.ui.dialog.i r103 = new com.larksuite.component.ui.dialog.i(r101.f431340b);
        r103.n(r101.f431352n);
        r103.m(R.layout.location_dialog_navigate_menu_item);
        r103.f284126f = new v(r101);
        r103.i();
    }
}
