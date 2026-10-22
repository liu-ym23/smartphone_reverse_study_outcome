package com.bytedance.locallife.dito.common.lynx;

import android.content.res.Resources;
import com.bytedance.locallife.dito.utils.ApplicationUtil;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class g {
    public static final int a(Number r100, boolean r101) {
        if (Intrinsics.areEqual(r100, 0) == true) goto L10;
        if (r101 == false) goto L7;
        float r102 = r100.floatValue();
        Resources r103 = ApplicationUtil.a().getResources();
        int r104 = (int) ((r102 / WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density) + 0.5f);
    L9:
        return r104;
    L7:
        r104 = r100.intValue();
        goto L9
    L10:
        return 0;
    }
}
