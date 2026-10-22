package com.bytedance.android.livesdk.livebuild;

import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.room.m;
import com.bytedance.common.utility.UIUtils;
import org.json.JSONObject;
import rg2.a;
import rg2.d;
import rg2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LottiePlayService implements m {
    private g lottieHelper;

    public LottiePlayService() {
    }

    public void startLotteryAnimation(JSONObject r2, LottieAnimationView r3) {
        if (this.lottieHelper != null) goto L5;
        this.lottieHelper = new g();
    L5:
        this.lottieHelper.getClass();
        if (r2 == null) goto L15;
        if (r3 == null) goto L16;
        UIUtils.setViewVisibility(r3, 0);
        r3.cancelAnimation();
        r3.setProgress(0.0f);
        d r4 = (d) a.a(d.class);     // Catch: Exception -> L12
        r3.getContext();     // Catch: Exception -> L12
        r4.a();     // Catch: Exception -> L12
        return;
    L17:
        return;
    L16:
        return;
    }

    public void startLotteryFullAnimation(vl2.m r2, LottieAnimationView r3, boolean r4) {
        if (this.lottieHelper != null) goto L5;
        this.lottieHelper = new g();
    L5:
        this.lottieHelper.a(r2, r3, r4);
    }
}
