package com.bytedance.android.shopping.inflow.compat;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements DialogInterface.OnKeyListener {
    public final /* synthetic */ ToggleBottomSheetFragment a;

    public c(ToggleBottomSheetFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r2, int r3, KeyEvent r4) {
        if (r3 == 4) goto L5;
    L7:
        return false;
    L5:
        if (r4.getAction() != 1) goto L7;
        this.a.getClass();
        goto L7
    }
}
