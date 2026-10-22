package com.bytedance.android.shopping.feed.utils;

import android.view.View;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i {
    public static WeakReference<View> a;

    public static void a() {
        WeakReference<View> r0 = a;
        View r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.get();
    L7:
        if ((r2 instanceof ECLottieAnimationView) == false) goto L10;
        r1 = r2;
    L10:
        ECLottieAnimationView r3 = (ECLottieAnimationView) r1;
        if (r3 == null) goto L14;
        r3.clearAnimation();
        r3.playAnimation();
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L7
    }

    static {
    }
}
