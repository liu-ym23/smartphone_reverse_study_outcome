package com.ss.android.ainote.util;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f407220a = 0;

    static {
    }

    @JvmStatic
    public static final int a(Context r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r102 = r100.getResources();
        return MathKt.roundToInt(r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density);
    }

    @JvmStatic
    public static final int b(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return a(r100, r101);
    }
}
