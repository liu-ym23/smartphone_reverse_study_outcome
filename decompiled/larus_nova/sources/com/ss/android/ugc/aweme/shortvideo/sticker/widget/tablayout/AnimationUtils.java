package com.ss.android.ugc.aweme.shortvideo.sticker.widget.tablayout;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* JADX INFO: loaded from: classes40.dex */
class AnimationUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FastOutSlowInInterpolator f454193a = null;

    static {
        new LinearInterpolator();
        f454193a = new FastOutSlowInInterpolator();
        new FastOutLinearInInterpolator();
        new LinearOutSlowInInterpolator();
        new DecelerateInterpolator();
    }
}
