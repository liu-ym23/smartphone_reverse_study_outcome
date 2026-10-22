package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import android.animation.AnimatorSet;
import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ PromotionCardImageComponent a;

    public h(PromotionCardImageComponent r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3, ImageRequest r4, Map r5) {
        ImageInfo r6 = (ImageInfo) r2;
        AnimatorSet r7 = this.a.A;
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.isRunning() != true) goto L10;
        if (r3 == null) goto L11;
        r3.start();
        return;
    L11:
        return;
    }
}
