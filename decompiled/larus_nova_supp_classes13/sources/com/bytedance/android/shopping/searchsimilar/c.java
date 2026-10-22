package com.bytedance.android.shopping.searchsimilar;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ SimilarProductFragment a;

    public c(SimilarProductFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        SimilarProductFragment r4 = this.a;
        int r0 = SimilarProductFragment.M;
        r4.Y90().loadSimilarProduct();
        SimilarProductFragment r5 = this.a;
        if (r5.L == false) goto L7;
        RelativeLayout r6 = r5.x;
        if (r6 == null) goto L10;
        r6.setVisibility(0);
    L10:
        LinearLayout r7 = this.a.D;
        if (r7 == null) goto L14;
        r7.setVisibility(8);
        return;
    L14:
        return;
    L7:
        LinearLayout r8 = r5.y;
        if (r8 == null) goto L10;
        r8.setVisibility(0);
        goto L10
    }
}
