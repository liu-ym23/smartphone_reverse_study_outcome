package com.bytedance.salamander.anniex;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f267973a;

    public final Context getContext() {
        Context r100 = this.f267973a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    public b0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f267973a = r100;
    }
}
