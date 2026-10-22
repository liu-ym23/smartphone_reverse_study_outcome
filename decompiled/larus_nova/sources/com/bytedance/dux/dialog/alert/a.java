package com.bytedance.dux.dialog.alert;

import android.content.DialogInterface;
import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f204922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ButtonStyleController f204923b;

    public a(DialogInterface.OnClickListener r100, ButtonStyleController r101) {
        this.f204922a = r100;
        this.f204923b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        DialogInterface.OnClickListener r101 = this.f204922a;
        if (r101 == null) goto L5;
        r101.onClick(this.f204923b.f204917g, -2);
    L5:
        ButtonStyleController.b(this.f204923b);
    }
}
