package com.obric.oui.sheet.v2;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f {
    public static final float a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r100.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return 0.5f;
    L8:
        return 0.16f;
    L5:
        r101 = false;
        goto L6
    }
}
