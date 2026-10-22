package com.bytedance.android.livesdk.livecommerce.promotionlist;

import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements ti.j {
    public final /* synthetic */ b a;

    public k(b r1) {
        this.a = r1;
    }

    public final void a(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        LivePromotionListViewModel r0 = this.a.n.f();
        if (r0 == null) goto L6;
        r0.updatePromotionsFromSettlement(r2);
        return;
    }
}
