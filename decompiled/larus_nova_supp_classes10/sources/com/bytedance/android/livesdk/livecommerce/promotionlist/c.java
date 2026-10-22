package com.bytedance.android.livesdk.livecommerce.promotionlist;

import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements ti.j {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    public final void a(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        LivePromotionListViewModel r3 = this.a.n.f();
        if (r3 == null) goto L5;
        r3.updateHintBannerInfo();
    L5:
        LivePromotionListViewModel r4 = this.a.n.f();
        if (r4 == null) goto L11;
        LivePromotionListViewModel r5 = r4.getSecondViewModel();
        if (r5 == null) goto L12;
        r5.updateHintBannerInfo();
        return;
    L12:
        return;
    }
}
