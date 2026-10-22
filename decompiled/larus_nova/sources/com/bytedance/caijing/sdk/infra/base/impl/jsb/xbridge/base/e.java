package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements md4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IXPayBaseMethod f202624a;

    @Override // md4.a
    public final boolean H() {
        cd4.e r100 = this.f202624a.f();
        if (r100 == null) goto L7;
        com.bytedance.caijing.sdk.infra.base.impl.container.a r101 = r100.getContainerAbility();
        if (r101 == null) goto L7;
        return r101.H();
    L7:
        return false;
    }

    public e(IXPayBaseMethod r100) {
        this.f202624a = r100;
    }
}
