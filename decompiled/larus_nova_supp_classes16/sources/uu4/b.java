package uu4;

import android.util.Pair;
import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.m;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
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

    @JvmStatic
    public static final void b(String r5, long r6, f r8) {
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r8, "params");
        BitableStatisticEventModel$NormalPointModel.Companion.getClass();
        BitableStatisticEventModel$NormalPointModel r7 = BitableStatisticEventModel$NormalPointModel.a.a(r6, "OPEN_RECORD_START");
        Pair<Long, Long> r9 = r8.f;
        if (r9 == null) goto L12;
        Long r0 = (Long) r9.first;
        long r1 = 0;
        if (r0 == null) goto L7;
        long r3 = r0.longValue();
    L8:
        r7.addExtra("prefetch_meta_begin", Long.valueOf(r3));
        Long r10 = (Long) r9.second;
        if (r10 == null) goto L11;
        r1 = r10.longValue();
    L11:
        r7.addExtra("prefetch_meta_end", Long.valueOf(r1));
        goto L12
    L7:
        r3 = 0;
    L12:
        m r11 = a();
        if (r8.b == false) goto L16;
        String r2 = "share_record";
    L19:
        r11.addTraceExtra(r5, "open_type", r2);
        a().addTraceExtra(r5, "is_ready", Boolean.valueOf(r8.d));
        m r12 = a();
        if (r8.a == false) goto L22;
        ETableType r4 = ETableType.CARD;
    L24:
        String r13 = r4.getValue();
    L26:
        r12.addTraceExtra(r5, "table_type", r13);
        m r14 = a();
        if (r8.f == null) goto L29;
        boolean r16 = true;
    L30:
        r14.addTraceExtra(r5, "is_merge_data", Boolean.valueOf(r16));
        a().addNormalPoint(r5, r7);
        return;
    L29:
        r16 = false;
        goto L30
    L22:
        r4 = r8.e;
        if (r4 != null) goto L24;
        r13 = null;
        goto L26
    L16:
        if (r8.c == false) goto L18;
        r2 = "base_add";
        goto L19
    L18:
        r2 = "main";
        goto L19
    }
}
