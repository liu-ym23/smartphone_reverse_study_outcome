package su4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.m;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final Lazy a = null;

    static {
        a = org.koin.java.a.d(m.class);
    }

    @JvmStatic
    public static final void c(String r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        BitableStatisticEventModel$NormalPointModel r9 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "BASE_ADD_RECORD_SUBMIT_SUCCESS", r8, false, 12);
        r9.addExtras(null);
        ((m) a.getValue()).addNormalPoint(r7, r9);
    }

    @JvmStatic
    public static final void a(String r7, long r8, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        BitableStatisticEventModel$NormalPointModel r9 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "BASE_ADD_RECORD_APPLY_END", r8, false, 12);
        r9.addExtras(r10);
        ((m) a.getValue()).addNormalPoint(r7, r9);
    }

    @JvmStatic
    public static final void b(String r7, long r8, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        BitableStatisticEventModel$NormalPointModel r9 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "BASE_ADD_RECORD_SUBMIT_FAIL", r8, false, 12);
        r9.addExtras(r10);
        ((m) a.getValue()).addNormalPoint(r7, r9);
    }
}
