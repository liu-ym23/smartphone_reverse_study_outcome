package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.DialogInterface;
import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f242514a;

    public m() {
        this.f242514a = null;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        View.OnClickListener r102 = this.f242514a;
        if (r102 == null) goto L6;
        r102.onClick(null);
        return;
    }
}
