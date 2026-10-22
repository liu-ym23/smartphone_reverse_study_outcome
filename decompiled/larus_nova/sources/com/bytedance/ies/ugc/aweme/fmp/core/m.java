package com.bytedance.ies.ugc.aweme.fmp.core;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class m {
    public static final float a(Context r100, float r101) {
        if (r100 == null) goto L5;
        Resources r102 = r100.getResources();
        return (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f;
    L5:
        return 0.0f;
    }

    public static final void b(byte[] r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
        if (r100.length == r101.length) goto L5;
        return;
    L5:
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        r101[r103] = (byte) (r100[r103] | r101[r103]);
        r103 = r103 + 1;
        goto L6
    }

    public static final int c(byte[] r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "oldShadowArray");
        Intrinsics.checkNotNullParameter(r101, "newShadowArray");
        int r102 = r100.length;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if (((byte) (r100[r103] ^ r101[r103])) == 0) goto L7;
        r104 = r104 + 1;
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        return r104;
    }
}
