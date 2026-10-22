package com.bytedance.android.shopping.deepfeed.utlis;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.Locale;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(Context r4) {
        String r0 = Build.BRAND;
        if (r0 == null) goto L5;
        String r1 = r0.toLowerCase(Locale.ROOT);
    L7:
        if (Intrinsics.areEqual(r1, "huawei") == false) goto L12;
        if (r4 == null) goto L12;
        return k1.h(r4);
    L12:
        if (k1.s(k1.t(r4)) == false) goto L19;
        boolean r2 = true;
        if (Settings.Secure.getInt(r4.getContentResolver(), "navigation_gesture_on", 0) == 0) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == true) goto L19;
    L20:
        if (r2 == true) goto L22;
        return 0;
    L22:
        if (r4 == null) goto L35;
        Resources r5 = th.a.f(r4);
        int r6 = r5.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r6 <= 0) goto L36;
        return r5.getDimensionPixelSize(r6);
    L27:
        e = move-exception;
        String r7 = e.getMessage();
        if (r7 != null) goto L31;
        r7 = "";
    L31:
        ECExceptionMonitor.c(r7);
        return 0;
    L36:
        return 0;
    L35:
        return 0;
    L16:
        r3 = false;
    L19:
        r2 = false;
        goto L20
    L5:
        r1 = null;
        goto L7
    }

    public static Pair b(View r2) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        int[] r0 = new int[2];
        r2.getLocationOnScreen(r0);
        int r3 = r0[0];
        int r1 = r0[1];
        return new Pair(Integer.valueOf(r3), Integer.valueOf(r1));
    }
}
