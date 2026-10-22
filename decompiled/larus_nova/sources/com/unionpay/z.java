package com.unionpay;

import android.view.View;

/* JADX INFO: loaded from: classes41.dex */
public final class z implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPPayWapActivity f462205a;

    public z(UPPayWapActivity r100) {
        this.f462205a = r100;
    }

    @Override // com.unionpay.f
    public final void a(String r100, c r101) {
        boolean r102 = Boolean.parseBoolean(r100);
        View r103 = this.f462205a.f462124g;
        if (r103 == null) goto L8;
        if (r102 == false) goto L6;
        int r104 = 0;
    L7:
        r103.setVisibility(r104);
        goto L8
    L6:
        r104 = 8;
    L8:
        if (r101 == null) goto L11;
        r101.a(UPPayWapActivity.b("0", "success", null));
        return;
    }
}
