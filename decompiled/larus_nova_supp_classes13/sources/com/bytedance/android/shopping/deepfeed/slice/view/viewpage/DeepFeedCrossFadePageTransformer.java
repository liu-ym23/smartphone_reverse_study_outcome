package com.bytedance.android.shopping.deepfeed.slice.view.viewpage;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/viewpage/DeepFeedCrossFadePageTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedCrossFadePageTransformer implements ViewPager2.PageTransformer {
    public DeepFeedCrossFadePageTransformer() {
    }

    public final void transformPage(View r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "page");
        if (r4 >= (-1.0f)) goto L5;
    L7:
        float r0 = 0.0f;
    L8:
        r3.setAlpha(r0);
        return;
    L5:
        if (r4 > 1.0f) goto L7;
        r0 = 1.0f - Math.min(Math.abs(r4), 1.0f);
        goto L8
    }
}
