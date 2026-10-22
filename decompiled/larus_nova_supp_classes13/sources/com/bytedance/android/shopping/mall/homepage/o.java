package com.bytedance.android.shopping.mall.homepage;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.lifecycle.Observer;
import com.bytedance.android.shopping.mall.homepage.pendant.anchor.AnchorPendantManager;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o<T> implements Observer {
    public final /* synthetic */ ECMallFragment a;

    public o(ECMallFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Integer r7 = (Integer) r6;
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.intValue() <= 0) goto L24;
        ECMallFragment r0 = this.a;
        int r1 = ECMallFragment.h4;
        r0.getClass();
        int r2 = com.bytedance.android.ec.hybrid.list.util.c.a;
        Context r3 = this.a.requireContext();
        Intrinsics.checkNotNullParameter(r3, "context");
        Integer r4 = d0.a;
        if (r4 == null) goto L9;
        int r5 = r4.intValue();
    L19:
        int r8 = com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(r5));
        ECMallFragment r9 = this.a;
        int r10 = r8 + r7.intValue();
        AnchorPendantManager r11 = r9.N2;
        if (r11 == null) goto L25;
        r11.f = r10;
        return;
    L25:
        return;
    L9:
        int r12 = UIUtils.getStatusBarHeight(r3);
        float r13 = r12;
        int r14 = 0;
        if (r3 == null) goto L18;
        Resources r15 = r3.getResources();
        if (r15 == null) goto L18;
        DisplayMetrics r16 = WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics());
        if (r16 == null) goto L18;
        float r17 = r16.density;
        if (r17 <= 0) goto L18;
        r14 = (int) ((r13 / r17) + 0.5f);
    L18:
        d0.a = Integer.valueOf(r14);
        r5 = r12;
        goto L19
    }
}
