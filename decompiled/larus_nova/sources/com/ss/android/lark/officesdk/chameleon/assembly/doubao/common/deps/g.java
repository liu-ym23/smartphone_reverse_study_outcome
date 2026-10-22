package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import android.content.Context;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g implements ntb.f {
    public g() {
    }

    @Override // ntb.f
    public final void e0() {
    }

    @Override // ntb.f
    public final boolean J(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Boolean r101 = OfficeSDKManager.isDebug();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.booleanValue();
    }

    @Override // ntb.f
    public final boolean V(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Boolean r101 = OfficeSDKManager.isDebug();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.booleanValue();
    }
}
