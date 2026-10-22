package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.DialogInterface;
import android.widget.TextView;
import com.larksuite.component.universe_design.dialog.UDDialog;

/* JADX INFO: loaded from: classes35.dex */
public final class z implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f418398a;

    public z(com.ss.android.lark.conditional.access.nopermission.manager.v r100) {
        this.f418398a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        TextView r102 = null;
        if ((r100 instanceof UDDialog) == false) goto L5;
        UDDialog r103 = (UDDialog) r100;
    L6:
        if (r103 == null) goto L8;
        r102 = (TextView) r103.findViewById(r101);
    L8:
        if (r102 == null) goto L10;
        r102.setEnabled(false);
    L10:
        DialogInterface.OnClickListener r104 = this.f418398a;
        if (r104 == null) goto L14;
        r104.onClick(r100, r101);
        return;
    L14:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
