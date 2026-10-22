package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallUtil {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(MallUtil$mallHybridMonitorVid$2.INSTANCE);
    }

    public static Map a(ECLynxCard r2, Map r3) {
        Intrinsics.checkNotNullParameter(r2, "lynxCard");
        HashMap r0 = new HashMap();
        r0.put("ec.lynxCardSetData", new com.bytedance.android.ec.hybrid.card.bridge.a(r2));
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L11;
        r0.putAll(r3);
    L11:
        return r0;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r4 = false;
        goto L9
    }
}
