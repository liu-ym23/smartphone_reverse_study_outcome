package com.bytedance.android.shopping.widget.legacy;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.core.widget.CircleImageView;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class AvatarImageView extends CircleImageView {
    public final void f() {
        super.f();
        getHierarchy().setPlaceholderImage(2131234538, ScalingUtils.ScaleType.CENTER_CROP);
    }

    public AvatarImageView(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBorderWidth(int r3) {
        if (getHierarchy().getRoundingParams() == null) goto L6;
        getHierarchy().getRoundingParams().setBorderWidth(UIUtils.dip2Px(getContext(), r3));
        return;
    }

    public void setBorderWidthPx(int r2) {
        if (getHierarchy().getRoundingParams() == null) goto L6;
        getHierarchy().getRoundingParams().setBorderWidth(r2);
        return;
    }

    public void setRoundingParamsPadding(float r2) {
        if (getHierarchy().getRoundingParams() == null) goto L6;
        getHierarchy().getRoundingParams().setPadding(r2);
        return;
    }

    public AvatarImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public AvatarImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
