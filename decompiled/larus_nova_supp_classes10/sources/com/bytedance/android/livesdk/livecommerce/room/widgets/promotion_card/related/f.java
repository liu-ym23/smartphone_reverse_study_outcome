package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f extends BaseRequestListener {
    public f() {
    }

    public final void onRequestSuccess(ImageRequest r1, String r2, boolean r3) {
        super.onRequestSuccess(r1, r2, r3);
        OptCardUtil.b("image", "botton prefetch success");
    }

    public final void onRequestStart(ImageRequest r1, Object r2, String r3, boolean r4) {
        super.onRequestStart(r1, r2, r3, r4);
        OptCardUtil.b("image", "botton prefetch start");
    }
}
