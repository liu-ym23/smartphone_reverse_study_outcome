package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.DialogInterface;
import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class s implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f242549a;

    public s(tq5.w.b r100) {
        this.f242549a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f242549a.onClick(null);
    }
}
