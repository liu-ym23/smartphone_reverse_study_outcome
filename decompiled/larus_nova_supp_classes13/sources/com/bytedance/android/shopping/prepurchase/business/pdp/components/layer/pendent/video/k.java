package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements g {
    public final /* synthetic */ i a;

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.g
    public final boolean a() {
        vg3.l r0 = this.a.g;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video.g
    public final vg3.z m() {
        vg3.w r0 = this.a.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m();
    }

    public k(i r1) {
        this.a = r1;
    }
}
