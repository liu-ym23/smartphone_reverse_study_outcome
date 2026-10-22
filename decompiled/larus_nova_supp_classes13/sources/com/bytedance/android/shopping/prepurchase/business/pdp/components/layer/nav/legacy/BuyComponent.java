package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.view.View;
import com.bytedance.android.ec.model.BuyNowPreloadParams;
import com.bytedance.android.ec.model.BuyNowServiceTag;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.anchorv4.bottom.BuyHelper;
import com.bytedance.android.shopping.anchorv4.bottom.BuyMeta;
import com.bytedance.android.shopping.anchorv4.bottom.SkuMeta;
import com.bytedance.android.shopping.verify.AuthUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BuyComponent {
    public final d a;
    public final View b;
    public final SkuMeta c;
    public final BuyMeta d;
    public final com.bytedance.android.shopping.anchorv4.bottom.m e;
    public final com.bytedance.android.shopping.anchorv4.bottom.o f;
    public final sc3.b g;

    public final boolean b() {
        SkuMeta r0 = this.c;
        if (r0 == null) goto L9;
        com.bytedance.android.shopping.anchorv4.bottom.m r2 = this.e;
        IAction r1 = r0.getSchemaSkuAction(false, r2.f, r2.g);
        if (r1 == null) goto L9;
        this.a.m(r1, this.b);
        return true;
    L9:
        return false;
    }

    public final void a(final BuyMeta r17, boolean r18) {
        if (r17.getUseNativeBuy() == false) goto L5;
        boolean r1 = com.bytedance.android.shopping.utils.i.a;
    L7:
        if (r17.getUseNativeBuy() == false) goto L9;
        String r7 = r17.getShopName();
        final BuyNowPreloadParams r2 = new BuyNowPreloadParams(true, r17.getShopCover(), r7, null, r17.getGoodTitleTags(), r17.getGoodTitle(), null, null, new BuyNowServiceTag(r17.getSubtitle(), r17.getIcon(), r17.getSubTitleTextColor()), 200, null);
    L10:
        if (r1 == false) goto L14;
        if (r18 == true) goto L14;
        int r3 = AuthUtils.a;
        AuthUtils.a(d0.a.getActivity(this.b), r17.getPromotionSource(), null, new BuyComponent$doRealActionAndLog$1(this, r17, r2));
        return;
    L14:
        if (b() == true) goto L18;
        new BuyHelper().h(this.a, r17, this.e, this.f, null, this.g);
        return;
    L18:
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = com.bytedance.android.shopping.utils.i.a();
        goto L7
    }

    public BuyComponent(d r2, View r3, SkuMeta r4, BuyMeta r5, com.bytedance.android.shopping.anchorv4.bottom.m r6, com.bytedance.android.shopping.anchorv4.bottom.o r7, sc3.b r8) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r3, "theView");
        Intrinsics.checkNotNullParameter(r5, "buyMeta");
        Intrinsics.checkNotNullParameter(r6, "buyNativeParam");
        Intrinsics.checkNotNullParameter(r7, "buyTrackParam");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
