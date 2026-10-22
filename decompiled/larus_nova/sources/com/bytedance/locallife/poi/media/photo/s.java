package com.bytedance.locallife.poi.media.photo;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes21.dex */
public final class s {
    public static void a(ViewPager2 r100, int r101, long r102, Function0 r103, Function0 r104) {
        AccelerateDecelerateInterpolator r105 = new AccelerateDecelerateInterpolator();
        int r106 = r100.getWidth();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r105, "interpolator");
        ValueAnimator r107 = ValueAnimator.ofInt(new int[]{0, r106 * (r101 - r100.getCurrentItem())});
        r107.addUpdateListener(new q(new Ref.IntRef(), r100));
        r107.addListener(new r(r100, r103, r104));
        r107.setInterpolator(r105);
        r107.setDuration(r102);
        r107.start();
    }
}
