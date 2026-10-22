package com.bytedance.android.shopping.api.mall.common.tools;

import com.ss.android.common.lib.AppLogNewUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r3, String r4, String r5, Long r6) {
        Intrinsics.checkNotNullParameter(r3, "apiKey");
        if (Intrinsics.areEqual(r3, "homepage") == false) goto L6;
        String r7 = "ies_ecommerce_client_homepage_request";
    L9:
        if (r7 != null) goto L11;
        return;
    L11:
        JSONObject r0 = new JSONObject();
        r0.putOpt("EVENT_ORIGIN_FEATURE", "TEMAI");
        r0.putOpt("status_type", 2);
        r0.putOpt("error_code", "-998");
        r0.putOpt("error_detail", r4);
        r0.putOpt("log_id", r5);
        r0.putOpt("res_version", String.valueOf(r6));
        AppLogNewUtils.onEventV3(r7, r0);
        return;
    L6:
        if (Intrinsics.areEqual(r3, "favorite_feed") == false) goto L8;
        r7 = "ies_ecommerce_client_favorite_feed_request";
        goto L9
    L8:
        r7 = null;
        goto L9
    }
}
