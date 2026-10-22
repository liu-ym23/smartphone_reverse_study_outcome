package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.widget.ImageView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements fj2.a<ECDraweeView> {
    public final /* synthetic */ Context a;

    @Override // fj2.a
    public final String type() {
        return "label_item_image";
    }

    @Override // fj2.a
    public final ECDraweeView create() {
        ECDraweeView r6 = new ECDraweeView(this.a, null, 0, 6, null);
        r6.setScaleType(ImageView.ScaleType.FIT_XY);
        return r6;
    }

    public e(Context r1) {
        this.a = r1;
    }
}
