package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class z implements ntb.x {
    public z() {
    }

    @Override // ntb.x
    public final void show(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "message");
        UDToast.show(r100, r101);
    }
}
