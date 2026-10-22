package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ FormBitableShareFragmentDelegate a;

    public b(FormBitableShareFragmentDelegate r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r2, boolean r3) {
        FormBitableShareFragmentDelegate r4 = this.a;
        if (r4.n == false) goto L5;
        return;
    L5:
        gu4.b r5 = r4.f;
        if (r5 == null) goto L9;
        r5.b(r3, "manualClick");
        return;
    }
}
