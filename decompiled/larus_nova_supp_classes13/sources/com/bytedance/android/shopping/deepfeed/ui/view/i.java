package com.bytedance.android.shopping.deepfeed.ui.view;

import android.graphics.drawable.Animatable;
import android.view.ViewPropertyAnimator;
import androidx.cardview.widget.CardView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ g a;
    public final /* synthetic */ String b;

    public i(g r1) {
        this.a = r1;
        this.b = "deep_feed_swipe_show_time";
    }

    public final void onFinalImageSet(String r4, Object r5, Animatable r6) {
        super.onFinalImageSet(r4, (ImageInfo) r5, r6);
        g r7 = this.a;
        CardView r8 = r7.b;
        if (r8 == null) goto L6;
        String r9 = this.b;
        ViewPropertyAnimator r10 = r8.animate().alpha(1.0f);
        int r1 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r10.translationY(-com.bytedance.android.ec.hybrid.list.util.c.d(10)).setDuration(280).setInterpolator(PathInterpolatorCompat.create(0.2f, 0.0f, 0.2f, 1.0f)).setListener(new h(r7, r9)).start();
        return;
    }
}
