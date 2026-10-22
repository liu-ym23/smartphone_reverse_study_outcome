package com.bytedance.android.shopping.widget.legacy;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class SquareImageView extends SimpleDraweeView {
    public SquareImageView(Context r1) {
        super(r1);
        setAspectRatio(1.0f);
    }

    public SquareImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
        setAspectRatio(1.0f);
    }

    public SquareImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setAspectRatio(1.0f);
    }
}
