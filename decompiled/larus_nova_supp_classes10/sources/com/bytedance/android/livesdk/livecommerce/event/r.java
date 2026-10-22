package com.bytedance.android.livesdk.livecommerce.event;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.response.ECCategoryData;
import com.bytedance.android.ec.model.response.ECCategoryDataForAi;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(ql.a r12) {
        Intrinsics.checkNotNullParameter(r12, "promotion");
        ArrayList r0 = new ArrayList();
        ECCategoryData r1 = r12.getCategoryData();
        if (r1 == null) goto L18;
        long r2 = r1.getFirstCid();
        long r4 = r1.getSecondCid();
        long r6 = r1.getThirdCid();
        long r8 = r1.getFourthCid();
        if (r2 == 0) goto L13;
        r0.add(Long.valueOf(r2));
        if (r4 == 0) goto L13;
        r0.add(Long.valueOf(r4));
        if (r6 == 0) goto L13;
        r0.add(Long.valueOf(r6));
        if (r8 == 0) goto L13;
        r0.add(Long.valueOf(r8));
    L13:
        ECCategoryDataForAi r3 = new ECCategoryDataForAi(r12.getLeafCategory(), r0);
        int r13 = com.bytedance.android.ec.core.utils.t0.a;     // Catch: Exception -> L16
        return com.bytedance.android.ec.core.utils.t0.a.b.toJson(r3);
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L18:
        return "";
    }
}
