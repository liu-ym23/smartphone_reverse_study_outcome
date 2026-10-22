package com.bytedance.android.shopping.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class RemoteRoundImageView extends SimpleDraweeView {
    public RemoteRoundImageView(Context r1) {
        super(r1);
    }

    public void setCornersRadius(float r2) {
        RoundingParams r0 = new RoundingParams();
        r0.setCornersRadius(r2);
        getHierarchy().setRoundingParams(r0);
    }

    public RemoteRoundImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public RemoteRoundImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
