package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.DialogInterface;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n implements DialogInterface.OnClickListener {
    public final /* synthetic */ View.OnClickListener a;

    public n(tq5.k r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        this.a.onClick(null);
    }
}
