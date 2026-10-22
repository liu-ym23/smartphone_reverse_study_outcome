package com.bytedance.ee.bear.drive.biz.preview.vc;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class VCFollowLinearSmoothScroller extends LinearSmoothScroller {
    public int a;

    public final int getVerticalSnapPreference() {
        return -1;
    }

    public VCFollowLinearSmoothScroller(Context r1) {
        super(r1);
    }

    public final void setTargetPosition(int r1) {
        super/*androidx.recyclerview.widget.RecyclerView.SmoothScroller*/.setTargetPosition(r1);
    }

    public final int calculateDtToFit(int r1, int r2, int r3, int r4, int r5) {
        if (r1 < r3) goto L4;
        if (r1 <= r3) goto L9;
        return (this.a + r3) - r1;
    L9:
        return this.a;
    L4:
        return (r3 - r1) + this.a;
    }
}
