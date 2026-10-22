package com.bytedance.android.shopping.feed.utils;

import com.bytedance.android.ec.core.utils.l1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class InflowRedPacketTimer {
    public static final Lazy b = null;
    public l1 a;

    public static final class a {
    }

    public InflowRedPacketTimer() {
    }

    static {
        b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, InflowRedPacketTimer$Companion$instance$2.INSTANCE);
    }
}
