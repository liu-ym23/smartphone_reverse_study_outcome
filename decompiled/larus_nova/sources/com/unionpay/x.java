package com.unionpay;

import com.unionpay.utils.UPUtils;

/* JADX INFO: loaded from: classes41.dex */
public final class x implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPPayWapActivity f462203a;

    public x(UPPayWapActivity r100) {
        this.f462203a = r100;
    }

    @Override // com.unionpay.f
    public final void a(String r100, c r101) {
        String r102 = UPUtils.a(this.f462203a, r100);
        if (r101 == null) goto L6;
        r101.a(UPPayWapActivity.b("0", "success", r102));
        return;
    }
}
