package com.bytedance.android.shopping.feed.widget;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l implements ti.j {
    public final /* synthetic */ InflowBottomMemberView a;

    public l(InflowBottomMemberView r1) {
        this.a = r1;
    }

    public final void a(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (ld3.c.f() == false) goto L8;
        if (com.bytedance.android.shopping.feed.utils.t.b == this.a.hashCode()) goto L9;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == false) goto L18;
        rd3.a r5 = this.a.d;
        if (r5 == null) goto L17;
        ProductFeedViewModel r6 = r5.c;
        if (r6 == null) goto L17;
        r6.syncDynamic(true);
    L17:
        com.bytedance.android.shopping.feed.utils.t.a = true;
        this.a.performClick();
    L18:
        ti.j r7 = this.a.c;
        if (r7 == null) goto L21;
        ECLiveHybridUtil.p("shop_member_open_success", r7);
    L21:
        this.a.c = null;
        return;
    L9:
        r4 = true;
        goto L11
    L8:
        if (com.bytedance.android.shopping.feed.utils.t.b != hashCode()) goto L10;
        goto L9
    }
}
