package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ BottomNavigationComponentV2 a;

    public b(BottomNavigationComponentV2 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r4) {
        float r5 = ((Number) r4).floatValue();
        BottomNavigationComponentV2 r0 = this.a;
        r0.getClass();
        if (r5 <= 0.0f) goto L6;
        r5 = 0.0f;
    L6:
        if (r0.q == r5) goto L9;
        r0.q = r5;
        r0.e2().setTranslationY((-((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r0.O1())).b.b) * r0.q);
        return;
    }
}
