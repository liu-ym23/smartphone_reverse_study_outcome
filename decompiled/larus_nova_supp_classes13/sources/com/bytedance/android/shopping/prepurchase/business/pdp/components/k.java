package com.bytedance.android.shopping.prepurchase.business.pdp.components;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ LastPageVideoZoomer a;

    public k(LastPageVideoZoomer r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r2) {
        boolean r3 = ((Boolean) r2).booleanValue();
        cf.p r0 = this.a.c();
        if (r0 == null) goto L6;
        r0.a(r3);
        return;
    }
}
