package com.bytedance.android.livesdk.livecommerce.promotionlist;

import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements ti.j {
    public final /* synthetic */ b a;

    public d(b r1) {
        this.a = r1;
    }

    public final void a(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        LivePromotionListViewModel r3 = this.a.n.f();
        if (r3 == null) goto L6;
        r3.closePromotionListFragmentNow();
        return;
    }
}
