package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class h0 {
    public static final void a(TextView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setTypeface(b(r100.getContext(), r101));
    }

    public static final Typeface b(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Typeface r102 = h18.e.a(r100);
        int r103 = 0;
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Typeface r104 = Typeface.create(r102, r101, false);
        Intrinsics.checkNotNull(r104);
        return r104;
    L6:
        if (r101 < 500) goto L9;
        r103 = 1;
    L9:
        return h18.e.b(r100, r103);
    }
}
