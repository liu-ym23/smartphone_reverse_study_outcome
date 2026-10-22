package com.bytedance.android.shopping.store.tabkit.container;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements DialogInterface.OnKeyListener {
    public final /* synthetic */ TabKitDialogFragment a;

    public h(TabKitDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
        if (r2 != 4) goto L11;
        TabKitDialogFragment r4 = this.a;
        TabKitFragment r5 = r4.d;
        if (r5 == null) goto L8;
        r5.S90();
    L8:
        if (r4.d == null) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }
}
