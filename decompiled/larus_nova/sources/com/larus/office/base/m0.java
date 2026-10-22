package com.larus.office.base;

import android.content.Context;
import com.larus.larkfeed.IOfficeSocialBridge;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class m0 implements qza.b {
    public m0() {
    }

    @Override // qza.b
    public final void b1(Context r100, qza.c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "data");
        IOfficeSocialBridge.f355120a.o(r101);
    }
}
