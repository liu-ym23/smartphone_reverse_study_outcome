package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.common.api.debugtool.IVisitUnit;
import com.bytedance.android.ec.common.api.debugtool.VisitActions;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv4.bottom.EnterCartMeta;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class EnterCartComponent {
    public final View a;
    public final d b;
    public final Activity c;
    public final EnterCartMeta d;

    public final void a() {
        final String r0 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b8094.c7963.d3567", Boolean.FALSE).withView(this.a).build());
        this.b.d(new EnterCartComponent$doRealAction$1(this, r0));
        com.bytedance.android.ec.sdk.helper.p r1 = com.bytedance.android.ec.sdk.helper.p.a;
        Activity r2 = this.c;
        String r3 = this.d.getCartUrl();
        if (r3 == null) goto L5;
        String r4 = com.bytedance.android.ec.core.btm.c.c(r3, this.a, "a1.b8094.c7963.d3567", new Pair[0]);
    L6:
        r1.openSchema(r2, r4);
        int r5 = ECSdk.a;
        IVisitUnit r6 = (IVisitUnit) ECSdk.a(IVisitUnit.class);
        if (r6 == null) goto L9;
        r6.hookToSchema(VisitActions.PDP_OUT_CART.getKey(), new EnterCartComponent$doRealAction$2(this));
    L9:
        Set r7 = ECProcessMonitor.a;
        ECProcessMonitor.c("ec_product_detail", "enter_cart").g();
        return;
    L5:
        r4 = null;
        goto L6
    }

    public EnterCartComponent(View r2, d r3, Activity r4, EnterCartMeta r5) {
        Intrinsics.checkNotNullParameter(r2, "btmView");
        Intrinsics.checkNotNullParameter(r3, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r5, "enterCartMeta");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
