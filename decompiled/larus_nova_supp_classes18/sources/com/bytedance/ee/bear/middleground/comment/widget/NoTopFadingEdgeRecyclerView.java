package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class NoTopFadingEdgeRecyclerView extends PointRecoderRecyclerView {
    public float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float getBottomFadingEdgeStrength() {
        return super/*android.view.ViewGroup*/.getBottomFadingEdgeStrength() * 0.9f;
    }

    public NoTopFadingEdgeRecyclerView(Context r1) {
        super(r1);
    }

    public NoTopFadingEdgeRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public NoTopFadingEdgeRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
