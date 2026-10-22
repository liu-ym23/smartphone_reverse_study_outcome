package s93;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import yj.g;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f541066a = 0;

    static {
    }

    public static int a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = HybridAppInfoService.f47545p.getAppId();
        if (r101 != null) goto L5;
    L18:
        Object r102 = 0;
        IHybridHostService r103 = com.bytedance.android.ec.hybrid.a.h();
        if (r103 == null) goto L26;
        g r104 = r103.getHostAB();
        if (r104 == null) goto L26;
        Object r105 = r104.a(r100, r102);
        if (r105 == null) goto L26;
        r102 = r105;
    L26:
        Lazy r106 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.f47463b, "Key : " + r100 + ", Value: " + r102);
        return ((Number) r102).intValue();
    L5:
        if (Intrinsics.areEqual(r101, "1128") == false) goto L7;
    L8:
        Object r107 = 1;
        IHybridHostService r108 = com.bytedance.android.ec.hybrid.a.h();
        if (r108 == null) goto L16;
        g r109 = r108.getHostAB();
        if (r109 == null) goto L16;
        Object r110 = r109.a(r100, r107);
        if (r110 == null) goto L16;
        r107 = r110;
    L16:
        Lazy r111 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.f47463b, "Key : " + r100 + ", Value: " + r107);
        return ((Number) r107).intValue();
    L7:
        if (Intrinsics.areEqual(r101, "2329") == false) goto L18;
        goto L8
    }
}
