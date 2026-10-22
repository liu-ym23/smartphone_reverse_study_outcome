package com.unionpay;

/* JADX INFO: loaded from: classes41.dex */
public final class v implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPPayWapActivity f462201a;

    public v(UPPayWapActivity r100) {
        this.f462201a = r100;
    }

    @Override // com.unionpay.f
    public final void a(String r100, c r101) {
        String r102 = a.b(this.f462201a, true, "0");
        if (r101 == null) goto L6;
        r101.a(UPPayWapActivity.b("0", "success", r102));
        return;
    }
}
