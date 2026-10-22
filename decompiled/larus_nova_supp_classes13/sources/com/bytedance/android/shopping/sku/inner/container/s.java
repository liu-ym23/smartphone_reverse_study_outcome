package com.bytedance.android.shopping.sku.inner.container;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s implements DialogInterface.OnKeyListener {
    public final /* synthetic */ SkuYataFragment a;

    public s(SkuYataFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
        return SkuYataFragment.V90(this.a);
    }
}
