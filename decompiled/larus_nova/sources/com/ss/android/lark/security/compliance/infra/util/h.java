package com.ss.android.lark.security.compliance.infra.util;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.security.compliance.infra.dependency.IScsInfraDependency;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: classes38.dex */
public final class h {
    public static final long a() {
        String r100 = ((IScsInfraDependency) ApiUtils.getApi(IScsInfraDependency.class)).getTenantId();     // Catch: Exception -> L7
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        return CastLongProtector.parseLong(r100);
    L7:
        e = move-exception;
        int r101 = ScsLogger.f440428a;
        ScsLogger.c("UserUtil", e.getMessage());
        return 0;
    }

    public static final long b() {
        String r100 = ((IScsInfraDependency) ApiUtils.getApi(IScsInfraDependency.class)).getUserId();     // Catch: Exception -> L7
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        return CastLongProtector.parseLong(r100);
    L7:
        e = move-exception;
        int r101 = ScsLogger.f440428a;
        ScsLogger.c("UserUtil", e.getMessage());
        return 0;
    }
}
