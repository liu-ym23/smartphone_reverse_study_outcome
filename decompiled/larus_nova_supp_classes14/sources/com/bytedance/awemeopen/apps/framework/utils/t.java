package com.bytedance.awemeopen.apps.framework.utils;

import com.bytedance.applet.debugger.DebuggerSessionViewModel;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t {
    public static String a(long r5) {
        if (r5 >= 0) goto L6;
        return String.valueOf(0);
    L6:
        if (r5 >= DebuggerSessionViewModel.MODE_SWITCH_TIMEOUT_MS) goto L9;
        return String.valueOf(r5);
    L9:
        if (r5 >= 100000000) goto L15;
        String r6 = b(r5, DebuggerSessionViewModel.MODE_SWITCH_TIMEOUT_MS, "");
        if (r6.equals("10000.0") == false) goto L19;
        return "1.0亿";
    L19:
        return r6.concat("万");
    L15:
        return b(r5, 100000000, "亿");
    }

    public static String b(long r1, long r3, String r5) {
        return new BigDecimal(r1).divide(new BigDecimal(r3), 1, RoundingMode.HALF_UP).toString() + r5;
    }
}
