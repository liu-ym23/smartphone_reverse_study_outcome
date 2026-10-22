package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements ControllerListener<ImageInfo> {
    public final /* synthetic */ TopCategoryView a;

    public final void onIntermediateImageFailed(String r1, Throwable r2) {
    }

    public final void onRelease(String r1) {
    }

    public final void onSubmit(String r1, Object r2) {
    }

    public h(TopCategoryView r1) {
        this.a = r1;
    }

    public final void onFailure(String r1, Throwable r2) {
        this.a.a.setVisibility(0);
        this.a.d.setVisibility(8);
    }

    public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String r1, Object r2) {
        ImageInfo r3 = (ImageInfo) r2;
    }

    public final /* bridge */ /* synthetic */ void onFinalImageSet(String r1, Object r2, Animatable r3) {
        ImageInfo r4 = (ImageInfo) r2;
    }
}
