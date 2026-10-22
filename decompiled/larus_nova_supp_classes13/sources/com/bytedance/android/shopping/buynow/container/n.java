package com.bytedance.android.shopping.buynow.container;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.bytedance.android.shopping.buynow.controller.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements DialogInterface.OnKeyListener {
    public final /* synthetic */ BuyNowHalfScreenDialogFragment a;

    public n(BuyNowHalfScreenDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r2, int r3, KeyEvent r4) {
        BuyNowFragment r5 = this.a.d;
        if (r5 == null) goto L10;
        q r6 = r5.o;
        if (r6 == null) goto L10;
        if (r6.b == true) goto L10;
        return true;
    L10:
        if (r4.getKeyCode() == 4) goto L12;
        return false;
    L12:
        if (r4.getAction() != 0) goto L22;
        BuyNowFragment r7 = this.a.d;
        if (r7 == null) goto L16;
        Boolean r8 = Boolean.valueOf(r7.Z90());
    L18:
        if (com.bytedance.android.shopping.extensions.k.i(r8) == false) goto L23;
        return true;
    L23:
        return false;
    L16:
        r8 = null;
        goto L18
    L22:
        return false;
    }
}
