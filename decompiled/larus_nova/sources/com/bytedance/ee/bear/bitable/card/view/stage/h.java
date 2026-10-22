package com.bytedance.ee.bear.bitable.card.view.stage;

import android.view.View;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larksuite.component.universe_design.menu.c f208723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f208724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ StageDataViewHolder f208725c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StageDataViewHolder f208726a;

        public a(StageDataViewHolder r100) {
            this.f208726a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            rcb.c.d(r100);
            this.f208726a.f208670a.g();
        }
    }

    public h(com.larksuite.component.universe_design.menu.c r100, View r101, StageDataViewHolder r102) {
        this.f208723a = r100;
        this.f208724b = r101;
        this.f208725c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f208723a.a();
        com.bytedance.ee.bear.widgets.a r101 = new com.bytedance.ee.bear.widgets.a(this.f208724b.getContext());
        r101.j(R.string.Bitable_Flow_RecordCard_ConfirmEndFlow_PopUp_Title);
        r101.h(R.string.Bitable_Flow_RecordCard_EndStep_Text, new a(this.f208725c));
        r101.a();
        LKUIDialog r102 = r101.l();
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r102);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
    }
}
