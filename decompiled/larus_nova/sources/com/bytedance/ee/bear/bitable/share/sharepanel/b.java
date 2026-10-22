package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FormBitableShareFragmentDelegate f215436a;

    public b(FormBitableShareFragmentDelegate r100) {
        this.f215436a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        FormBitableShareFragmentDelegate r102 = this.f215436a;
        if (r102.f215368n == false) goto L5;
        return;
    L5:
        gu4.b r103 = r102.f215360f;
        if (r103 == null) goto L9;
        r103.b(r101, "manualClick");
        return;
    }
}
