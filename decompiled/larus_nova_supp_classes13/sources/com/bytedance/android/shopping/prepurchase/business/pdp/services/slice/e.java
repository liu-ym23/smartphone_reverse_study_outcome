package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ PdpDynamicFeatureService a;

    public e(PdpDynamicFeatureService r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r2) {
        if (((Boolean) r2).booleanValue() == false) goto L14;
        PdpDynamicFeatureService r3 = this.a;
        if (r3.q == false) goto L7;
        r3.Y0(true);
        return;
    L7:
        c r4 = r3.o;
        if (r4 == null) goto L16;
        e73.a r0 = r4.a;
        if (r0 == null) goto L17;
        r4.b(r0.e());
        return;
    L17:
        return;
    L16:
        return;
    }
}
