package com.unionpay;

import android.app.AlertDialog;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes41.dex */
public final class s implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPPayWapActivity f462172a;

    public s(UPPayWapActivity r100) {
        this.f462172a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        UPPayWapActivity r101 = this.f462172a;
        int r102 = UPPayWapActivity.f462117i;
        AlertDialog.Builder r103 = new AlertDialog.Builder(r101);
        r101.f462120c = r103.create();
        r103.setMessage(com.unionpay.utils.h.a().f462197a);
        r103.setTitle(com.unionpay.utils.h.a().f462200d);
        r103.setPositiveButton(com.unionpay.utils.h.a().f462198b, new t(r101));
        r103.setNegativeButton(com.unionpay.utils.h.a().f462199c, new u(r101));
        AlertDialog r104 = r103.create();
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r104);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r104);
        r104.show();
        DialogLancet.afterDialogShow(r104);
    }
}
