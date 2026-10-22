package com.bytedance.android.shopping.widget.legacy;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class RemoteRoundImageView extends SimpleDraweeView {
    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        RoundingParams r0 = new RoundingParams();
        r0.setCornersRadius(UIUtils.dip2Px(getContext(), 2.0f));
        getHierarchy().setRoundingParams(r0);
        getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
    }

    public RemoteRoundImageView(Context r1) {
        super(r1);
        f();
    }

    public RemoteRoundImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
        f();
    }

    public RemoteRoundImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        f();
    }
}
