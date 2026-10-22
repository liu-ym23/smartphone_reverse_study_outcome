package com.bytedance.android.shopping.router;

import android.app.Activity;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r8, Activity r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "orderUrl");
        Intrinsics.checkNotNullParameter(r9, "activity");
        Intrinsics.checkNotNullParameter(r10, "packLogId");
        ECLiveHybridUtil.k(r9, r8, false, false, false, null, 252);
        com.bytedance.android.ec.core.monitor.j.a(r8, r10, "");
    }
}
