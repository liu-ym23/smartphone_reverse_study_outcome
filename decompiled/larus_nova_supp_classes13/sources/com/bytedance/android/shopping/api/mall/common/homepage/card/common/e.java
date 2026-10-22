package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ View a;

    public e(SimpleDraweeView r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
        if (r4 == null) goto L22;
        int r5 = r4.getHeight();     // Catch: Exception -> L15
        int r6 = (int) ((this.a.getWidth() * r5) / r4.getWidth());     // Catch: Exception -> L15
        if (r6 > 0) goto L8;
        r6 = this.a.getWidth();     // Catch: Exception -> L15
    L8:
        ViewGroup.LayoutParams r7 = this.a.getLayoutParams();     // Catch: Exception -> L15
        if (r7 != null) goto L12;
        return;
    L12:
        if (r7.height == r6) goto L21;
        r7.height = r6;     // Catch: Exception -> L15
        this.a.requestLayout();     // Catch: Exception -> L15
        return;
    L21:
        return;
    L15:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        return;
    }
}
