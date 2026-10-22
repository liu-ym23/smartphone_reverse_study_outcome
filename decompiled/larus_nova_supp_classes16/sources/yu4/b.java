package yu4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.m;
import com.bytedance.ee.bear.document.analytic.BatterySceneData;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final Lazy a = null;

    static {
        a = org.koin.java.a.d(m.class);
    }

    public static m a() {
        return (m) a.getValue();
    }

    public static void c(String r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        BitableStatisticEventModel$NormalPointModel r9 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "panel_show_failed", r8, true, 8);
        a().addNormalPoint(r7, r9);
    }

    public static void d(String r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        BitableStatisticEventModel$NormalPointModel r9 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "panel_show_success", r8, true, 8);
        a().addNormalPoint(r7, r9);
    }

    public static void b(String r2, long r3, Map r5) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        BitableStatisticEventModel$NormalPointModel.Companion.getClass();
        BitableStatisticEventModel$NormalPointModel r4 = BitableStatisticEventModel$NormalPointModel.a.a(r3, BatterySceneData.OPT_START);
        Iterator r6 = ((HashMap) r5).entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r7 = (Map.Entry) r6.next();
        a().addTraceExtra(r2, (String) r7.getKey(), (Serializable) r7.getValue());
        goto L4
    L6:
        a().addNormalPoint(r2, r4);
    }
}
