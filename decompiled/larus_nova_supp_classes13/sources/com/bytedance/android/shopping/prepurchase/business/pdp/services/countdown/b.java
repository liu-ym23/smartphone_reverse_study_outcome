package com.bytedance.android.shopping.prepurchase.business.pdp.services.countdown;

import android.os.SystemClock;
import com.bytedance.android.ec.core.utils.ActivityCountDownTimer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public long a;
    public final ActivityCountDownTimer b;

    public static final class a {
    }

    static {
    }

    public b(ActivityCountDownTimer r2) {
        Intrinsics.checkNotNullParameter(r2, "activityTimer");
        this.b = r2;
    }

    public final void a(long r8, com.bytedance.android.shopping.prepurchase.business.pdp.services.countdown.a r10, long r11) {
        this.b.a((SystemClock.elapsedRealtime() / 1000) + this.a, r8, r10, Long.valueOf(r11));
    }
}
