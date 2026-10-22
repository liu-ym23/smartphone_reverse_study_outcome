package com.bytedance.android.shopping.deepfeed.weights;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductBannerVideoVH;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements fd3.b {
    public final /* synthetic */ DeepFeedProductHeaderView a;
    public final /* synthetic */ ConstraintLayout b;

    @Override // fd3.b
    public final void d() {
    }

    @Override // fd3.b
    public final void e() {
    }

    @Override // fd3.b
    public final void b() {
        if (this.a.z == true) goto L5;
    L11:
        this.a.i();
        return;
    L5:
        if (tc3.f.f() == true) goto L11;
        if (this.a.h() == true) goto L11;
        ConstraintLayout r0 = this.b;
        if (r0 == null) goto L11;
        r0.setVisibility(0);
        goto L11
    }

    @Override // fd3.b
    public final void c() {
        ConstraintLayout r0 = this.b;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        com.bytedance.android.shopping.deepfeed.action.i r1 = this.a.I;
        if (r1 == null) goto L9;
        r1.z1(com.bytedance.android.shopping.deepfeed.action.a.i.a);
        return;
    }

    @Override // fd3.b
    public final void a(float r3) {
        DeepFeedProductHeaderView r0 = this.a;
        float r4 = r3 * 100;
        if (r0.e() == false) goto L17;
        RecyclerView.ViewHolder r1 = r0.a.findViewHolderForAdapterPosition(0);
        if (r1 != null) goto L7;
        return;
    L7:
        if ((r1 instanceof DeepFeedProductBannerVideoVH) == false) goto L19;
        View r2 = ((RecyclerView.ViewHolder) ((DeepFeedProductBannerVideoVH) r1)).itemView;
        if ((r2 instanceof c) == true) goto L11;
        r2 = null;
    L11:
        c r5 = (c) r2;
        if (r5 == null) goto L20;
        ECVideoPlayerView r6 = r5.getVideoPlayerView();
        if (r6 == null) goto L21;
        r6.v(r4);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    public i(DeepFeedProductHeaderView r1, ConstraintLayout r2) {
        this.a = r1;
        this.b = r2;
    }
}
