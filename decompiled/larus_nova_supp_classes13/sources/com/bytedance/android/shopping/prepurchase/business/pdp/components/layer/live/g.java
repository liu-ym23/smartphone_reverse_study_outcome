package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live;

import com.bytedance.android.ec.model.live.r;
import com.bytedance.android.livesdk.livecommerce.model.ECV2HotAtmosphere;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements r {
    public final /* synthetic */ LiveSearchComponent a;
    public final /* synthetic */ String b;

    public final String f() {
        return this.b;
    }

    public g(LiveSearchComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void g(String r2, ECV2HotAtmosphere r3) {
        Intrinsics.checkNotNullParameter(r2, "promotionId");
        CommonMeta r0 = this.a.O1().d().getData().a().a();
        if (r0 == null) goto L5;
        String r1 = r0.getPromotionId();
    L7:
        if (Intrinsics.areEqual(r2, r1) == false) goto L13;
        if (r3 != null) goto L10;
        return;
    L10:
        if (this.a.i2(r3) == false) goto L15;
        LiveSearchComponent r4 = this.a;
        r4.o = r3;
        LiveSearchComponent.h2(r4, r4.p, r4.r);
        return;
    L15:
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L7
    }
}
