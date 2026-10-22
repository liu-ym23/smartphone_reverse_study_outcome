package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ FormBitableShareFragmentDelegate b;

    public d(boolean r1, FormBitableShareFragmentDelegate r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (this.a == false) goto L8;
        FormBitableShareFragmentDelegate r3 = this.b;
        gu4.b r0 = r3.f;
        if (r0 == null) goto L7;
        r0.c(r3.o().getBitableShareMeta().getShareToken());
    L7:
        this.b.p().X9();
        return;
    L8:
        Toast.showText(this.b.p().requireContext(), 2131886525);
    }
}
