package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ SimpleDraweeView a;

    public i(SimpleDraweeView r1) {
        this.a = r1;
    }

    public final void onFailure(String r1, Throwable r2) {
        super.onFailure(r1, r2);
        b0.e(this.a);
    }

    public final void onFinalImageSet(String r6, Object r7, Animatable r8) {
        ImageInfo r9 = (ImageInfo) r7;
        super.onFinalImageSet(r6, r9, r8);
        if (r9 == null) goto L22;
        if (r8 != null) goto L6;
        return;
    L6:
        if ((r8 instanceof AnimatedDrawable2) == false) goto L20;
        ViewGroup.LayoutParams r10 = this.a.getLayoutParams();
        if (r10 != null) goto L10;
        r10 = new ViewGroup.LayoutParams(r9.getWidth(), r9.getHeight());
    L10:
        r10.width = r9.getWidth();
        r10.height = r9.getHeight();
        AnimatedDrawable2 r11 = (AnimatedDrawable2) r8;
        if (r11.isRunning() == false) goto L14;
        r8.stop();
    L14:
        if (r11.getLoopDurationMs() <= 0) goto L16;
        this.a.postDelayed(new g(this), r11.getLoopDurationMs());
    L16:
        AnimationBackend r0 = r11.getAnimationBackend();
        if (r0 == null) goto L19;
        r11.setAnimationBackend(new c(r0));
    L19:
        this.a.setLayoutParams(r10);
        r11.setAnimationListener(new h(r8, this));
        r8.start();
        return;
    L20:
        b0.e(this.a);
        return;
    }
}
