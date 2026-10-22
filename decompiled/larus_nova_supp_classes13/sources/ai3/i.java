package ai3;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.PageInfo;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(PageInfo r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "pageInfo");
        Intrinsics.checkNotNullParameter(r4, "value");
        ConcurrentHashMap r0 = a43.a.a;
        Object r1 = l43.a.a("ec_sku_height_percent");
        if ((r1 instanceof Integer) == true) goto L5;
        r1 = null;
    L5:
        Integer r2 = (Integer) r1;
        if (r2 == null) goto L9;
        String r5 = String.valueOf(r2.intValue());
        if (r5 == null) goto L9;
    L10:
        String r6 = r3.getSchemaModel().getQueryParam("scene_type");
        String r7 = r3.getSchemaModel().getQueryParam("force_height");
        if (BuyNowPerformanceOpt.m() == true) goto L31;
        if (BuyNowPerformanceOpt.p() == false) goto L19;
        ECSettingKeys.j.getClass();
        if (CollectionsKt.contains(ECSettingKeys.W(), r6) == true) goto L31;
        return r4;
    L19:
        if (BuyNowPerformanceOpt.o() == false) goto L24;
        ECSettingKeys.j.getClass();
        if (CollectionsKt.contains(ECSettingKeys.W(), r6) == false) goto L31;
        return r4;
    L24:
        if (BuyNowPerformanceOpt.n() == false) goto L29;
        if ((!Intrinsics.areEqual(r7, "1")) == true) goto L31;
        return r4;
    L29:
        if (Intrinsics.areEqual(r7, "1") == true) goto L31;
        return r4;
    L31:
        return r5;
    L9:
        r5 = "83";
        goto L10
    }
}
