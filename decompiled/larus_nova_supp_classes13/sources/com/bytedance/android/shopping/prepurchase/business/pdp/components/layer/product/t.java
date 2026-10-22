package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
    public final /* synthetic */ ProductDetailInfoComponent c;

    @Override // java.lang.Runnable
    public final void run() {
        ProductDetailInfoComponent r0 = this.c;
        r0.getClass();
        int r1 = PdpPendantHandler.f;     // Catch: Throwable -> L10
        AnchorV4Param r2 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) r0.O1().f().b).a;     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");     // Catch: Throwable -> L10
        V4NativeParams r3 = r2.getNativeParams();     // Catch: Throwable -> L10
        if (r3 == null) goto L6;
        JSONObject r4 = r3.getTaskRequestParams();     // Catch: Throwable -> L10
    L7:
        if (r4 == null) goto L15;
        new PdpPendantHandler(r0, r0.O1(), r0.R1()).b(r4);     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L6:
        r4 = null;
    L10:
        th = move-exception;
        r0.O1().c().ensureNotReachHere(th);
    }

    public t(ProductDetailInfoComponent r1) {
        this.c = r1;
        super("parseAndShowPendantParams");
    }
}
