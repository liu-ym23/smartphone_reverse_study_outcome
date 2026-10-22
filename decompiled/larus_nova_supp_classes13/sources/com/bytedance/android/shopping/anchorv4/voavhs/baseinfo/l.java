package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.content.Context;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.response.anchorv3.GroupAvatarTimeStruct;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedCouponResult;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l {
    public static final SimpleDraweeView a(Context r4, GroupAvatarTimeStruct r5) {
        SimpleDraweeView r0 = new SimpleDraweeView(r4);
        RoundingParams r6 = RoundingParams.asCircle();
        boolean r1 = true;
        r6.setBorderWidth(vf4.a.b(1));
        r6.setBorderColor(-1);
        r0.getHierarchy().setRoundingParams(r6);
        GenericDraweeHierarchy r7 = r0.getHierarchy();
        ScalingUtils.ScaleType r2 = ScalingUtils.ScaleType.CENTER_CROP;
        r7.setActualImageScaleType(r2);
        r0.getHierarchy().setPlaceholderImage(2131234538, r2);
        r0.setLayoutParams(new LinearLayout.LayoutParams(vf4.a.b(24), vf4.a.b(24)));
        String r8 = r5.getUrl();
        if (r8 != null) goto L5;
    L8:
        if (r1 == false) goto L10;
        r8 = DeepFeedCouponResult.FAIL;
    L10:
        y.d(r0, r8);
        return r0;
    L5:
        if (r8.length() == 0) goto L8;
        r1 = false;
        goto L8
    }
}
