package com.bytedance.android.livesdk.livecommerce.room.controller.related;

import com.bytedance.android.ec.local.api.ab.ECLiveSettingPanel;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    @ECLiveSettingPanel(desc = "端智能种草信号开关", key = "ec_live_show_smart_product")
    public static int a() {
        return ((Number) EComABUtils.getLiveSettingValue("ec_live_show_smart_product", 0)).intValue();
    }

    static {
    }
}
