package uu4;

import android.util.Pair;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.m;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f551743a = null;

    static {
        f551743a = org.koin.java.a.d(m.class);
    }

    public static m a() {
        return (m) f551743a.getValue();
    }

    @JvmStatic
    public static final void b(String r100, long r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r102, "params");
        BitableStatisticEventModel$NormalPointModel.Companion.getClass();
        BitableStatisticEventModel$NormalPointModel r103 = BitableStatisticEventModel$NormalPointModel.a.a(r101, "OPEN_RECORD_START");
        Pair<Long, Long> r104 = r102.f551752f;
        if (r104 == null) goto L12;
        Long r105 = (Long) r104.first;
        long r106 = 0;
        if (r105 == null) goto L7;
        long r107 = r105.longValue();
    L8:
        r103.addExtra("prefetch_meta_begin", Long.valueOf(r107));
        Long r108 = (Long) r104.second;
        if (r108 == null) goto L11;
        r106 = r108.longValue();
    L11:
        r103.addExtra("prefetch_meta_end", Long.valueOf(r106));
        goto L12
    L7:
        r107 = 0;
    L12:
        m r109 = a();
        if (r102.f551748b == false) goto L16;
        String r110 = "share_record";
    L19:
        r109.addTraceExtra(r100, "open_type", r110);
        a().addTraceExtra(r100, "is_ready", Boolean.valueOf(r102.f551750d));
        m r111 = a();
        if (r102.f551747a == false) goto L22;
        ETableType r112 = ETableType.CARD;
    L24:
        String r113 = r112.getValue();
    L26:
        r111.addTraceExtra(r100, "table_type", r113);
        m r114 = a();
        if (r102.f551752f == null) goto L29;
        boolean r115 = true;
    L30:
        r114.addTraceExtra(r100, "is_merge_data", Boolean.valueOf(r115));
        a().addNormalPoint(r100, r103);
        return;
    L29:
        r115 = false;
        goto L30
    L22:
        r112 = r102.f551751e;
        if (r112 != null) goto L24;
        r113 = null;
        goto L26
    L16:
        if (r102.f551749c == false) goto L18;
        r110 = "base_add";
        goto L19
    L18:
        r110 = PullConfiguration.PROCESS_NAME_MAIN;
        goto L19
    }
}
