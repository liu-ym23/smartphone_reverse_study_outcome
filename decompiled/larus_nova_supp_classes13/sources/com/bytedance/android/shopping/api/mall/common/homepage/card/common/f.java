package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ View a;

    public f(SimpleDraweeView r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        if (r4 == null) goto L16;
        int r5 = r4.getHeight();
        int r6 = (int) ((this.a.getWidth() * r5) / r4.getWidth());
        if (r6 > 0) goto L8;
        r6 = this.a.getWidth();
    L8:
        ViewGroup.LayoutParams r7 = this.a.getLayoutParams();
        if (r7 != null) goto L12;
        return;
    L12:
        if (r7.height == r6) goto L15;
        r7.height = r6;
        this.a.requestLayout();
        return;
    L15:
        return;
    }
}
