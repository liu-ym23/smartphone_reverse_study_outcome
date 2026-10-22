package o53;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.bytedance.android.shopping.widget.flow.TagFlowLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import ih3.g;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes12.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f522100a = 0;

    static {
    }

    public static void a(Context r100, TextView r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "textView");
        g r102 = g.f489807b;
        r102.d0(r101);
        float r103 = r102.getFontScale();
        r101.setTextSize(1, MathKt.roundToInt(14.0f * r103));
        int r104 = MathKt.roundToInt(21.0f * r103);
        int r105 = r104 / 4;
        int r106 = r105 * 4;
        int r107 = (r105 + 1) * 4;
        if ((r104 * 2) < (r106 + r107)) goto L6;
        r106 = r107;
    L6:
        int r108 = TagFlowLayout.f187431j;
        Resources r109 = r100.getResources();
        r101.setLineSpacing((int) ((r106 * WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics()).density) + 0.5f), 0.0f);
    }
}
