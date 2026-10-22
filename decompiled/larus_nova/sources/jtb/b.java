package jtb;

import android.content.Context;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements itb.c {
    public b() {
    }

    @Override // itb.c
    public final void V(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        itb.c r101 = (itb.c) OfficeSDKManager.getHostGlobalService(itb.c.class);
        if (r101 == null) goto L6;
        r101.V(r100);
        return;
    }
}
