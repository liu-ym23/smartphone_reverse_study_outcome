package av4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.m;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static String a;
    public static final Lazy b = null;

    static {
        b = org.koin.java.a.d(m.class);
    }

    public static void b() {
        String r0 = a;
        if (r0 == null) goto L5;
        c().stopTrace(r0, Boolean.TRUE);
    L5:
        String r1 = c().createNormalTrace(null);
        a = r1;
        if (r1 == null) goto L9;
        c().addNormalConsumer(r1, new a());
        return;
    }

    public static m c() {
        return (m) b.getValue();
    }

    public static void a(Map r4) {
        Intrinsics.checkNotNullParameter(r4, "param");
        String r0 = a;
        if (r0 == null) goto L8;
        Iterator r5 = r4.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r5.next();
        c().addTraceExtra(r0, (String) r1.getKey(), (Serializable) r1.getValue());
        goto L6
    L10:
        return;
    }

    public static void d(String r16, long r17, String r18, String r19) {
        String r0 = r16;
        Intrinsics.checkNotNullParameter(r16, "jsbName");
        Intrinsics.checkNotNullParameter(r19, "invokeFrom");
        String r7 = a;
        if (r7 == null) goto L13;
        m r8 = c();
        BitableStatisticEventModel$NormalPointModel.a r9 = BitableStatisticEventModel$NormalPointModel.Companion;
        long r10 = System.currentTimeMillis();
        Pair[] r12 = new Pair[4];
        if (StringsKt.contains$default(r16, "javascript:", false, 2, null) == false) goto L7;
        r0 = StringsKt.replace$default(r16, "javascript:", "", false, 4, null);
    L7:
        r12[0] = TuplesKt.to("jsb_name", r0);
        r12[1] = TuplesKt.to("cost_time", Long.valueOf(r17));
        if (r18 != null) goto L10;
        String r1 = "";
    L11:
        r12[2] = TuplesKt.to("msg", r1);
        r12[3] = TuplesKt.to("invoke_from", r19);
        HashMap r2 = MapsKt.hashMapOf(r12);
        r9.getClass();
        r8.addNormalPoint(r7, BitableStatisticEventModel$NormalPointModel.a.b("JSB_REPORT_POINT_NAME", r10, false, r2));
        return;
    L10:
        r1 = r18;
        goto L11
    }
}
