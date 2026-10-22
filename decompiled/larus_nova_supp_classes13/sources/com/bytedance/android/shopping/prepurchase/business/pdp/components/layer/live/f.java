package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live;

import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ LiveSearchComponent a;

    public f(LiveSearchComponent r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r3) {
        float r4 = ((Number) r3).floatValue();
        LiveSearchComponent r0 = this.a;
        if (r0.u == false) goto L6;
        return;
    L6:
        if (r4 >= 0) goto L8;
        ExtensionsKt.gone(r0.e2());
        return;
    L8:
        ExtensionsKt.visible(r0.e2());
    }
}
