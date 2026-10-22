package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ FormBitableShareFragmentDelegate a;

    public c(FormBitableShareFragmentDelegate r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Toast.showText(this.a.p().requireContext(), 2131886525);
    }
}
