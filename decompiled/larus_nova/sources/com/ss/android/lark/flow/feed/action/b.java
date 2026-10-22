package com.ss.android.lark.flow.feed.action;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import dfb.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements c {
    public b() {
    }

    @Override // dfb.c
    public final a createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new a(r100);
    }
}
