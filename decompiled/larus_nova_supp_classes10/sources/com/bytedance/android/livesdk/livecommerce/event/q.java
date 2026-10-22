package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q extends ECEventV3 {
    public q(boolean r3, boolean r4) {
        super("livesdk_commerce_cart_success");
        d("is_new_slot", EComABUtils.isEnableLiveOptSlot() ? 1 : 0);
        d("is_anchor", r3 ? 1 : 0);
        d("is_first_load", r4 ? 1 : 0);
    }
}
