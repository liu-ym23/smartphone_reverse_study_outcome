package tu4;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$OpenFile$OpenType;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.m;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import java.io.Serializable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f547622a = null;

    static {
        f547622a = org.koin.java.a.d(m.class);
    }

    public static m c() {
        return (m) f547622a.getValue();
    }

    @JvmStatic
    public static final String b(DocViewModel r100) {
        if (r100 == null) goto L7;
        MutableLiveData<Map<String, Object>> r101 = r100.getDocExtra();
        if (r101 == null) goto L7;
        Map<String, Object> r102 = r101.getValue();
    L8:
        if (r102 != null) goto L10;
        return null;
    L10:
        return (String) r102.get("OPEN_FILE_TRACE_ID");
    L7:
        r102 = null;
        goto L8
    }

    @JvmStatic
    public static final void d(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel r102 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_CREATE_UI_END", r101, false, 12);
        c().addNormalPoint(r100, r102);
    }

    @JvmStatic
    public static final void e(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel r102 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_CREATE_UI_START", r101, false, 12);
        c().addNormalPoint(r100, r102);
    }

    @JvmStatic
    public static final void a(String r100, String r101, Serializable r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        BitableStatisticEventModel$NormalPointModel r103 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "POINT_ADD_END_STAGE_EXTRA", System.currentTimeMillis(), false, 8);
        r103.addExtra(r101, r102);
        c().addNormalPoint(r100, r103);
    }

    @JvmStatic
    public static final void f(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "key");
        BitableStatisticEventModel$NormalPointModel r103 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "POINT_MID_STAGE_COST", r102, false, 8);
        r103.addExtras(MapsKt.mapOf(TuplesKt.to(r101, Long.valueOf(r102))));
        c().addNormalPoint(r100, r103);
    }

    @JvmStatic
    public static final void g(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "key");
        BitableStatisticEventModel$NormalPointModel r103 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "POINT_NATIVE_LOAD_COST", r102, false, 8);
        r103.addExtras(MapsKt.mapOf(TuplesKt.to(r101, Long.valueOf(r102))));
        c().addNormalPoint(r100, r103);
    }

    public static void h(String r100, Long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel.a r103 = BitableStatisticEventModel$NormalPointModel.Companion;
        if (r101 == null) goto L5;
        long r104 = r101.longValue();
    L6:
        BitableStatisticEventModel$NormalPointModel r105 = BitableStatisticEventModel$NormalPointModel.a.c(r103, "OPEN_FILE_CANCEL", r104, false, 12);
        r105.addExtra("reason", r102);
        c().addNormalPoint(r100, r105);
        return;
    L5:
        r104 = System.currentTimeMillis();
        goto L6
    }

    @JvmStatic
    public static final void i(String r100, Long r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel.a r103 = BitableStatisticEventModel$NormalPointModel.Companion;
        if (r101 == null) goto L5;
        long r104 = r101.longValue();
    L6:
        BitableStatisticEventModel$NormalPointModel r105 = BitableStatisticEventModel$NormalPointModel.a.c(r103, "OPEN_FILE_FAIL", r104, false, 12);
        r105.addExtras(r102);
        c().addNormalPoint(r100, r105);
        return;
    L5:
        r104 = System.currentTimeMillis();
        goto L6
    }

    public static void k(String r100, long r101, Function1 r110) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel r102 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_TTU", r101, false, 12);
        if (r110 == null) goto L5;
        r110.invoke(r102);
    L5:
        c().addNormalPoint(r100, r102);
    }

    public static void l(String r100, long r101, Function1 r110) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel r102 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_TTV", r101, false, 12);
        if (r110 == null) goto L5;
        r110.invoke(r102);
    L5:
        c().addNormalPoint(r100, r102);
    }

    @JvmStatic
    public static final void m(String r100, long r101, Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableStatisticEventModel$NormalPointModel r102 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "POINT_SDK_LOAD_COST", r101, false, 8);
        r102.addExtras(r110);
        c().addNormalPoint(r100, r102);
    }

    @JvmStatic
    public static final void j(String r100, Long r101, BearUrl r102, BitableStatisticConstant$OpenFile$OpenType r103) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r103, "openType");
        BitableStatisticEventModel$NormalPointModel.a r104 = BitableStatisticEventModel$NormalPointModel.Companion;
        if (r101 == null) goto L5;
        long r105 = r101.longValue();
    L6:
        r104.getClass();
        BitableStatisticEventModel$NormalPointModel r106 = BitableStatisticEventModel$NormalPointModel.a.a(r105, "OPEN_FILE_START");
        if (r101 != null) goto L9;
        int r107 = 1;
    L10:
        r106.addExtra("time_from_native", Integer.valueOf(r107));
        m r108 = c();
        String r109 = null;
        if (r102 == null) goto L13;
        String r110 = r102.f222567h;
    L14:
        r108.addTraceExtra(r100, "from", r110);
        if (r102 == null) goto L17;
        String r111 = r102.f222568i;
    L18:
        r108.addTraceExtra(r100, "subFrom", r111);
        if (r102 == null) goto L21;
        r109 = r102.f222561b;
    L21:
        r108.addTraceExtra(r100, "file_id", du5.b.g(r109));
        r108.addTraceExtra(r100, "open_type", r103.getValue());
        r108.addNormalPoint(r100, r106);
        return;
    L17:
        r111 = null;
        goto L18
    L13:
        r110 = null;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r105 = System.currentTimeMillis();
        goto L6
    }
}
