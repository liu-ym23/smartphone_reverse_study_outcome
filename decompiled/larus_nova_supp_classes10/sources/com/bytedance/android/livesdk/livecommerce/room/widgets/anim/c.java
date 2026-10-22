package com.bytedance.android.livesdk.livecommerce.room.widgets.anim;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements Interpolator {
    public c() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r4) {
        if (r4 <= 0.42857143f) goto L6;
        return 1.03f - (((r4 - 0.42857143f) * 1.03f) / (1 - 0.42857143f));
    L6:
        return 1 + ((r4 * 0.03f) / 0.42857143f);
    }
}
