package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.DialogInterface;
import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class q implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f242540a;

    public q(tq5.a r100) {
        this.f242540a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f242540a.onClick(null);
    }
}
