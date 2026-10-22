package com.bytedance.android.livesdk.livecommerce.promotionlist;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements ti.j {
    public final /* synthetic */ b a;

    public j(b r1) {
        this.a = r1;
    }

    public final void a(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r4.optBoolean("force_close_list") == false) goto L18;
        ViewGroup r0 = this.a.n.getRootView();
        if (r0 == null) goto L18;
        if (r0.getTranslationY() < r0.getMeasuredHeight()) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        r0 = null;
    L13:
        if (r0 == null) goto L18;
        LivePromotionListViewModel r5 = this.a.n.f();
        if (r5 == null) goto L20;
        r5.closePromotionListFragmentNow();
        return;
    L20:
        return;
    L9:
        r1 = false;
    L18:
        b.a(this.a, r4.optBoolean("show"));
    }
}
