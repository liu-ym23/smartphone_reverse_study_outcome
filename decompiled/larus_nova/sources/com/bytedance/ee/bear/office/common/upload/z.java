package com.bytedance.ee.bear.office.common.upload;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class z {
    static {
    }

    public static void a(FragmentActivity r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "availability");
        if ((r101 instanceof b.d) == false) goto L5;
        b.d r102 = (b.d) r101;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        r102.f235341a.getCallback().a(r100, r102.f235341a);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
