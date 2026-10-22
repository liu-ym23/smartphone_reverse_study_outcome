package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends com.bytedance.kmp.ec.yata.event.common.a {
    public final com.bytedance.android.ec.core.async.b a;
    public final BuyNowViewModel b;

    public static final class a {
    }

    static {
    }

    public g(com.bytedance.android.ec.core.async.b r2, BuyNowViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "disposableScope");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.a = r2;
        this.b = r3;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Intrinsics.checkNotNullParameter(r8, "chainNextCallback");
        BuyNowLog.d("selfDelay", "selfDelay starts");
        Map r1 = r7.q();
        Long r2 = null;
        if (r1 == null) goto L5;
        Object r3 = r1.get("duration");
    L7:
        if ((r3 instanceof Integer) == true) goto L9;
        r3 = null;
    L9:
        Integer r4 = (Integer) r3;
        if (r4 == null) goto L12;
        r2 = Long.valueOf(r4.intValue());
    L12:
        long r5 = com.bytedance.android.shopping.extensions.k.h(r2);
        if (r5 != 0) goto L15;
        BuyNowLog.d("selfDelay", "duration is 0");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.b.getTracker(), "selfDelay", "duration is null", r7);
    L15:
        com.bytedance.android.ec.core.async.a.a(Completable.timer(r5, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new h(r8)), this.a);
        return;
    L5:
        r3 = null;
        goto L7
    }
}
