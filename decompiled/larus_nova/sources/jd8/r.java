package jd8;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
public final class r {
    static {
    }

    public static float a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r101 = r100.getResources();
        return RangesKt.coerceAtLeast(TypedValue.applyDimension(1, 0.5f, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())), 1.0f);
    }
}
