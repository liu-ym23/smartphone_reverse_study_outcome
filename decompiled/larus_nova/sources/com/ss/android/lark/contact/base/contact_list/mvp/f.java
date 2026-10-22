package com.ss.android.lark.contact.base.contact_list.mvp;

import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes35.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f418598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w8b.a f418599b;

    public /* synthetic */ f(g r100, w8b.a r101) {
        this.f418598a = r100;
        this.f418599b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r100 = this.f418598a;
        final w8b.a r101 = this.f418599b;
        r100.getClass();
        Log.i("ExternalContactView2", "long click chatterId: " + r101.f558707e);
        final ExternalContactView2 r102 = r100.f418600a;
        r102.getClass();
        new UDDialogBuilder(r102.f418577a).title(R.string.Lark_Contacts_DeleteNewContactHistory).addActionButton(R.id.ud_dialog_btn_primary, R.string.Lark_Legacy_ConfirmTip, new c(r102, r101)).addActionButton(R.id.ud_dialog_btn_secondary, R.string.Lark_Legacy_Cancel, null).show();
    }
}
