package com.larus.aweme.impl.main_bot;

import android.view.View;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g {
    public static final ViewPager2FixLayout a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewPager2FixLayout r101 = new ViewPager2FixLayout(r100.getContext(), null, 0);
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r101.addView(r100, new FrameLayout.LayoutParams(-1, -1));
        return r101;
    }
}
