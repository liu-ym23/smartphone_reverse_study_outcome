package com.bytedance.android.shopping.store.tabkit.container;

import android.content.DialogInterface;
import android.view.KeyEvent;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements DialogInterface.OnKeyListener {
    public final /* synthetic */ ABSTabkitBottomSheetFragment a;

    public b(ABSTabkitBottomSheetFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r2, int r3, KeyEvent r4) {
        if (r3 == 4) goto L5;
        return false;
    L5:
        if (r4.getAction() != 1) goto L13;
        Function0<Boolean> r5 = this.a.f;
        if (r5 == null) goto L14;
        Boolean r6 = (Boolean) r5.invoke();
        if (r6 != null) goto L11;
        return false;
    L11:
        return r6.booleanValue();
    L14:
        return false;
    L13:
        return false;
    }
}
