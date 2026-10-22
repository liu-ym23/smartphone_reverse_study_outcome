package com.bytedance.android.livesdk.livecommerce.playback.card.widget;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e {
    public e() {
    }

    public static boolean a(String r1, String r2) {
        float r3 = CastFloatProtector.parseFloat(r1);     // Catch: Exception -> L9
        float r4 = CastFloatProtector.parseFloat(r2);     // Catch: Exception -> L9
        if (r4 != r3) goto L7;
        return false;
    L7:
        if (r4 <= 0) goto L18;
        return true;
    L18:
        return false;
    L9:
        e = move-exception;
        String r5 = e.getMessage();
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        ECExceptionMonitor.c(r5);
        return false;
    }
}
