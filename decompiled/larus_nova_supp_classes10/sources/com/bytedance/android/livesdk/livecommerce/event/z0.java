package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z0 extends u0 {
    public z0(boolean r3) {
        if (r3 == false) goto L4;
        String r0 = "show_search";
    L5:
        super(r0);
        f("source_page", l0.n());
        f("enter_from", "search_live_product");
        f("enter_method", l0.i("enter_method"));
        f("enter_from_method", l0.i("enter_method"));
        f("enter_from_second", l0.d());
        f("author_id", l0.i("anchor_id"));
        if (r3 == true) goto L8;
        f("is_search_button", "1");
        f("page_name", "live_product_detail");
    L8:
        f("group_id", l0.i("room_id"));
        return;
    L4:
        r0 = "search_box_click";
        goto L5
    }

    public final void o(String r3) {
        ECLiveABUtils r0 = ECLiveABUtils.INSTANCE;
        if (r0.getEC_LIVE_EVENT_ATTRIBUTION_PARAMS_UPLOAD() == false) goto L9;
        if (r3 == null) goto L6;
        String r4 = StringsKt.take(r3, r0.getEC_LIVE_REPORT_PLATFORM_MAX_LENGTH().intValue());
    L7:
        f("schema", r4);
        return;
    L6:
        r4 = null;
        goto L7
    }
}
