package com.ss.android.lark.flow.feed.action.markunread;

import com.ss.android.lark.feed.export.feedcard.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements seb.c {
    public b() {
    }

    @Override // seb.c
    public final aeb.c a(d r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new a(r100);
    }
}
