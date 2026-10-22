package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import android.os.Handler;
import android.os.SystemClock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q {
    public static boolean a;

    static {
        a = true;
    }

    public static boolean a(long r3, long r5) {
        Handler r0 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        long r1 = SystemClock.elapsedRealtime();
        if (r5 > r3) goto L5;
    L9:
        return false;
    L5:
        if (r1 < r3) goto L9;
        if (r1 > r5) goto L9;
        return true;
    }
}
