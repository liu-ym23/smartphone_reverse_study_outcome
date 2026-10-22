package s93;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import yj.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "key");
        String r0 = HybridAppInfoService.p.getAppId();
        if (r0 != null) goto L5;
    L18:
        Object r1 = 0;
        IHybridHostService r3 = com.bytedance.android.ec.hybrid.a.h();
        if (r3 == null) goto L26;
        g r4 = r3.getHostAB();
        if (r4 == null) goto L26;
        Object r6 = r4.a(r5, r1);
        if (r6 == null) goto L26;
        r1 = r6;
    L26:
        Lazy r7 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : " + r5 + ", Value: " + r1);
        return ((Number) r1).intValue();
    L5:
        if (Intrinsics.areEqual(r0, "1128") == false) goto L7;
    L8:
        Object r2 = 1;
        IHybridHostService r8 = com.bytedance.android.ec.hybrid.a.h();
        if (r8 == null) goto L16;
        g r9 = r8.getHostAB();
        if (r9 == null) goto L16;
        Object r10 = r9.a(r5, r2);
        if (r10 == null) goto L16;
        r2 = r10;
    L16:
        Lazy r11 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : " + r5 + ", Value: " + r2);
        return ((Number) r2).intValue();
    L7:
        if (Intrinsics.areEqual(r0, "2329") == false) goto L18;
        goto L8
    }
}
