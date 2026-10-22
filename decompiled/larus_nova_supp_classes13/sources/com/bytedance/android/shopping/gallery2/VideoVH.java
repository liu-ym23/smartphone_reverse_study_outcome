package com.bytedance.android.shopping.gallery2;

import android.view.View;
import com.bytedance.android.ec.model.k;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/gallery2/VideoVH;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoVH extends TransitionViewHolder {
    public final ECVideoView a;
    public final ECVideoPlayer b;
    public k c;

    public VideoVH(View r3) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super(r3);
        ECVideoView r0 = r3.findViewById(2131392337);
        this.a = r0;
        ECVideoPlayer r1 = new ECVideoPlayer(r3.getContext());
        this.b = r1;
        r0.setPlayer(r1);
        r0.setScaleType(0);
        r1.n(true);
    }

    public final void T3(k r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryMediaModel");
        this.b.q();
        this.c = r2;
        String r3 = r2.f;
        if (r3 == null) goto L6;
        this.a.setCoverUrl(r3);
        return;
    }
}
