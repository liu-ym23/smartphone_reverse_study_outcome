package com.ss.android.dypay.views;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements DialogInterface.OnKeyListener {
    public a() {
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        if (r101 == 4) goto L5;
    L7:
        return false;
    L5:
        if (r102.getRepeatCount() != 0) goto L7;
        return true;
    }
}
