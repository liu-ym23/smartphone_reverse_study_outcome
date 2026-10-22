package su4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.m;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f543589a = null;

    static {
        f543589a = org.koin.java.a.d(m.class);
    }

    @JvmStatic
    public static final void c(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel r102 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "BASE_ADD_RECORD_SUBMIT_SUCCESS", r101, false, 12);
        r102.addExtras(null);
        ((m) f543589a.getValue()).addNormalPoint(r100, r102);
    }

    @JvmStatic
    public static final void a(String r100, long r101, Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel r102 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "BASE_ADD_RECORD_APPLY_END", r101, false, 12);
        r102.addExtras(r110);
        ((m) f543589a.getValue()).addNormalPoint(r100, r102);
    }

    @JvmStatic
    public static final void b(String r100, long r101, Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel r102 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "BASE_ADD_RECORD_SUBMIT_FAIL", r101, false, 12);
        r102.addExtras(r110);
        ((m) f543589a.getValue()).addNormalPoint(r100, r102);
    }
}
