package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live;

import com.bytedance.android.shopping.anchorv4.dto.Control;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ LiveSearchComponent a;

    public e(LiveSearchComponent r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r4) {
        if (((Boolean) r4).booleanValue() == false) goto L22;
        LiveSearchComponent r5 = this.a;
        CommonMeta r0 = r5.O1().d().getData().a().a();
        Control r6 = r5.O1().d().getData().c();
        if (r0 == null) goto L7;
        String r1 = r0.getLastEcomSceneId();
    L8:
        boolean r2 = com.bytedance.android.shopping.anchorv4.helper.e.d(r1);
        boolean r3 = false;
        if (r6 == null) goto L11;
        boolean r7 = r6.getShouldOptimizeHalfContainerCloseInteraction();
    L13:
        if (r7 == false) goto L16;
        if (r2 == true) goto L16;
        r3 = true;
    L16:
        if (r3 == false) goto L23;
        LiveSearchComponent r8 = this.a;
        if (r8.u == true) goto L24;
        r8.u = true;
        ExtensionsKt.gone(r8.e2());
        return;
    L24:
        return;
    L23:
        return;
    L11:
        r7 = false;
        goto L13
    L7:
        r1 = null;
        goto L8
    }
}
