package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView;

/* JADX INFO: loaded from: classes18.dex */
public class NoTopFadingEdgeRecyclerView extends PointRecoderRecyclerView {
    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return super.getBottomFadingEdgeStrength() * 0.9f;
    }

    public NoTopFadingEdgeRecyclerView(Context r100) {
        super(r100);
    }

    public NoTopFadingEdgeRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public NoTopFadingEdgeRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
