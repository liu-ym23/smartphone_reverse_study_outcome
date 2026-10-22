package com.bytedance.android.shopping.deepfeed.weights.common;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ SimpleDraweeView a;

    public c(SimpleDraweeView r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.getHeight() <= 0) goto L9;
        this.a.setAspectRatio(r4.getWidth() / r4.getHeight());
        return;
    }
}
