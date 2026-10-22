package com.bytedance.dux.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f205857a = 0;

    static {
    }

    public static int a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        TypedValue r101 = new TypedValue();
        if (r100.getTheme().resolveAttribute(R.attr.duxPanelDefaultHeaderHeight, r101, true) == true) goto L6;
        r101 = null;
    L6:
        if (r101 != null) goto L8;
    L11:
        float r102 = r100.getResources().getDimension(R.dimen.dux_panel_default_header_height);
    L13:
        return (int) r102;
    L8:
        if (r101.type != 5) goto L11;
        Resources r103 = r100.getResources();
        r102 = r101.getDimension(WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()));
        goto L13
    }
}
