package com.bytedance.dux.dialog.alert;

import android.content.DialogInterface;
import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f204924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ButtonStyleController f204925b;

    public b(ButtonStyleController r100) {
        this.f204924a = null;
        this.f204925b = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        DialogInterface.OnClickListener r101 = this.f204924a;
        if (r101 == null) goto L5;
        r101.onClick(this.f204925b.f204917g, -3);
    L5:
        ButtonStyleController.b(this.f204925b);
    }
}
