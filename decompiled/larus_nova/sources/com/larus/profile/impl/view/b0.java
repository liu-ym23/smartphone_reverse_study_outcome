package com.larus.profile.impl.view;

import android.content.Context;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b0 {
    static {
    }

    public static void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = xp9.o.f564776a;
        if ((r101 instanceof OfficeSDKUserApi) == false) goto L5;
        OfficeSDKUserApi r102 = (OfficeSDKUserApi) r101;
    L6:
        if (r102 == null) goto L11;
        ktb.a r103 = (ktb.a) r102.getService(ktb.a.class);
        if (r103 == null) goto L12;
        r103.F1(r100, new mtb.l());
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
