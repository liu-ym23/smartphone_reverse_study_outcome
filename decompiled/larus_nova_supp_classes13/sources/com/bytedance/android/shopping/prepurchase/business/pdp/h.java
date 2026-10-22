package com.bytedance.android.shopping.prepurchase.business.pdp;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements DialogInterface.OnKeyListener {
    public final /* synthetic */ ProductDetailHalfFragmentV2 a;

    public h(ProductDetailHalfFragmentV2 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r2, int r3, KeyEvent r4) {
        if (r3 == 4) goto L5;
        return false;
    L5:
        if (r4.getAction() != 1) goto L11;
        com.bytedance.android.shopping.prepurchase.arch.container.a<e, PdpDataStore> r5 = this.a.f;
        if (r5 != null) goto L9;
        return false;
    L9:
        return r5.a();
    L11:
        return false;
    }
}
