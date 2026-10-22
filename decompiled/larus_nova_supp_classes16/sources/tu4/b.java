package tu4;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$OpenFile$OpenType;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.m;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final Lazy a = null;

    static {
        a = org.koin.java.a.d(m.class);
    }

    public static m c() {
        return (m) a.getValue();
    }

    @JvmStatic
    public static final String b(DocViewModel r1) {
        if (r1 == null) goto L7;
        MutableLiveData<Map<String, Object>> r2 = r1.getDocExtra();
        if (r2 == null) goto L7;
        Map r3 = (Map) r2.getValue();
    L8:
        if (r3 != null) goto L10;
        return null;
    L10:
        return (String) r3.get("OPEN_FILE_TRACE_ID");
    L7:
        r3 = null;
        goto L8
    }

    @JvmStatic
    public static final void d(String r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        BitableStatisticEventModel$NormalPointModel r9 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_CREATE_UI_END", r8, false, 12);
        c().addNormalPoint(r7, r9);
    }

    @JvmStatic
    public static final void e(String r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        BitableStatisticEventModel$NormalPointModel r9 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_CREATE_UI_START", r8, false, 12);
        c().addNormalPoint(r7, r9);
    }

    @JvmStatic
    public static final void a(String r7, String r8, Serializable r9) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r9, "value");
        BitableStatisticEventModel$NormalPointModel r0 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "POINT_ADD_END_STAGE_EXTRA", System.currentTimeMillis(), false, 8);
        r0.addExtra(r8, r9);
        c().addNormalPoint(r7, r0);
    }

    @JvmStatic
    public static final void f(String r7, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        Intrinsics.checkNotNullParameter(r8, "key");
        BitableStatisticEventModel$NormalPointModel r0 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "POINT_MID_STAGE_COST", r9, false, 8);
        r0.addExtras(MapsKt.mapOf(TuplesKt.to(r8, Long.valueOf(r9))));
        c().addNormalPoint(r7, r0);
    }

    @JvmStatic
    public static final void g(String r7, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        Intrinsics.checkNotNullParameter(r8, "key");
        BitableStatisticEventModel$NormalPointModel r0 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "POINT_NATIVE_LOAD_COST", r9, false, 8);
        r0.addExtras(MapsKt.mapOf(TuplesKt.to(r8, Long.valueOf(r9))));
        c().addNormalPoint(r7, r0);
    }

    public static void h(String r7, Long r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        BitableStatisticEventModel$NormalPointModel.a r1 = BitableStatisticEventModel$NormalPointModel.Companion;
        if (r8 == null) goto L5;
        long r3 = r8.longValue();
    L6:
        BitableStatisticEventModel$NormalPointModel r10 = BitableStatisticEventModel$NormalPointModel.a.c(r1, "OPEN_FILE_CANCEL", r3, false, 12);
        r10.addExtra("reason", r9);
        c().addNormalPoint(r7, r10);
        return;
    L5:
        r3 = System.currentTimeMillis();
        goto L6
    }

    @JvmStatic
    public static final void i(String r7, Long r8, Map<String, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        BitableStatisticEventModel$NormalPointModel.a r1 = BitableStatisticEventModel$NormalPointModel.Companion;
        if (r8 == null) goto L5;
        long r3 = r8.longValue();
    L6:
        BitableStatisticEventModel$NormalPointModel r10 = BitableStatisticEventModel$NormalPointModel.a.c(r1, "OPEN_FILE_FAIL", r3, false, 12);
        r10.addExtras(r9);
        c().addNormalPoint(r7, r10);
        return;
    L5:
        r3 = System.currentTimeMillis();
        goto L6
    }

    public static void k(String r7, long r8, Function1 r10) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        BitableStatisticEventModel$NormalPointModel r9 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_TTU", r8, false, 12);
        if (r10 == null) goto L5;
        r10.invoke(r9);
    L5:
        c().addNormalPoint(r7, r9);
    }

    public static void l(String r7, long r8, Function1 r10) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        BitableStatisticEventModel$NormalPointModel r9 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_TTV", r8, false, 12);
        if (r10 == null) goto L5;
        r10.invoke(r9);
    L5:
        c().addNormalPoint(r7, r9);
    }

    @JvmStatic
    public static final void m(String r7, long r8, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        BitableStatisticEventModel$NormalPointModel r9 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "POINT_SDK_LOAD_COST", r8, false, 8);
        r9.addExtras(r10);
        c().addNormalPoint(r7, r9);
    }

    @JvmStatic
    public static final void j(String r4, Long r5, BearUrl r6, BitableStatisticConstant$OpenFile$OpenType r7) {
        Intrinsics.checkNotNullParameter(r4, "traceId");
        Intrinsics.checkNotNullParameter(r7, "openType");
        BitableStatisticEventModel$NormalPointModel.a r0 = BitableStatisticEventModel$NormalPointModel.Companion;
        if (r5 == null) goto L5;
        long r1 = r5.longValue();
    L6:
        r0.getClass();
        BitableStatisticEventModel$NormalPointModel r2 = BitableStatisticEventModel$NormalPointModel.a.a(r1, "OPEN_FILE_START");
        if (r5 != null) goto L9;
        int r8 = 1;
    L10:
        r2.addExtra("time_from_native", Integer.valueOf(r8));
        m r9 = c();
        String r3 = null;
        if (r6 == null) goto L13;
        String r10 = r6.h;
    L14:
        r9.addTraceExtra(r4, DocRedirectToDocxPlugin.FROM, r10);
        if (r6 == null) goto L17;
        String r11 = r6.i;
    L18:
        r9.addTraceExtra(r4, "subFrom", r11);
        if (r6 == null) goto L21;
        r3 = r6.b;
    L21:
        r9.addTraceExtra(r4, "file_id", du5.b.g(r3));
        r9.addTraceExtra(r4, "open_type", r7.getValue());
        r9.addNormalPoint(r4, r2);
        return;
    L17:
        r11 = null;
        goto L18
    L13:
        r10 = null;
        goto L14
    L9:
        r8 = 0;
        goto L10
    L5:
        r1 = System.currentTimeMillis();
        goto L6
    }
}
