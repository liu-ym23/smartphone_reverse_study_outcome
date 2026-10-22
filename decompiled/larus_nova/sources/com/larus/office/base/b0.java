package com.larus.office.base;

import android.content.Context;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b0 implements itb.c {
    public b0() {
    }

    @Override // itb.c
    public final void V(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ExposureTrackerExtKt.d(r100);
        ExposeXTrackerExtKt.d(r100);
    }
}
