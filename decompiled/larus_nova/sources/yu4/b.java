package yu4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.m;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f569223a = null;

    static {
        f569223a = org.koin.java.a.d(m.class);
    }

    public static m a() {
        return (m) f569223a.getValue();
    }

    public static void c(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel r102 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "panel_show_failed", r101, true, 8);
        a().addNormalPoint(r100, r102);
    }

    public static void d(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel r102 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "panel_show_success", r101, true, 8);
        a().addNormalPoint(r100, r102);
    }

    public static void b(String r100, long r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel.Companion.getClass();
        BitableStatisticEventModel$NormalPointModel r103 = BitableStatisticEventModel$NormalPointModel.a.a(r101, "start");
        Iterator r104 = ((HashMap) r102).entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry r105 = (Map.Entry) r104.next();
        a().addTraceExtra(r100, (String) r105.getKey(), (Serializable) r105.getValue());
        goto L4
    L6:
        a().addNormalPoint(r100, r103);
    }
}
