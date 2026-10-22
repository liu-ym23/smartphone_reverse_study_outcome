package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.graphics.drawable.Animatable;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ DeepFeedProductBannerImageVH a;
    public final /* synthetic */ ECUrlModel b;
    public final /* synthetic */ int c;

    public j(DeepFeedProductBannerImageVH r1, InFeedUrlModel r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
        ImageInfo r6 = (ImageInfo) r4;
        DeepFeedProductBannerImageVH r7 = this.a;
        ECUrlModel r8 = this.b;
        int r9 = this.c;
        int r0 = DeepFeedProductBannerImageVH.k;
        if (r9 == 0) goto L5;
        r7.getClass();
        return;
    L5:
        ((RecyclerView.ViewHolder) r7).itemView.post(new k(r7, r8, r9));
    }
}
