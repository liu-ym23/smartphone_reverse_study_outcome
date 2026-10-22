package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e1 extends ECEventV3 {

    public static final class a {
    }

    static {
    }

    public /* synthetic */ e1() {
        this(0, "");
    }

    public e1(int r4, String r5) {
        Intrinsics.checkNotNullParameter("entry", "page");
        super("livesdk_coupon_load_status");
        d("status", r4);
        f("page", "entry");
        if (r5 == null) goto L6;
        f(LocationMonitorConst.ERROR_MSG, r5);
        return;
    }
}
