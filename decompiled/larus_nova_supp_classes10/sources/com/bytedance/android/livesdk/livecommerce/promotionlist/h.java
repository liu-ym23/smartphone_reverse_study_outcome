package com.bytedance.android.livesdk.livecommerce.promotionlist;

import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements ti.j {
    public final /* synthetic */ b a;

    public h(b r1) {
        this.a = r1;
    }

    public final void a(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        LivePromotionListViewModel r5 = this.a.n.f();
        if (r5 == null) goto L5;
        LivePromotionListViewModel.updateWhenBackFromOtherPage$default(r5, null, false, 3, null);
    L5:
        LivePromotionListViewModel r6 = this.a.n.f();
        if (r6 == null) goto L11;
        LivePromotionListViewModel r7 = r6.getSecondViewModel();
        if (r7 == null) goto L12;
        LivePromotionListViewModel.updateWhenBackFromOtherPage$default(r7, null, false, 3, null);
        return;
    L12:
        return;
    }
}
