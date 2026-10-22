package com.larus.av_call.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.larus.common_ui.view.CustomBarCountAudioVisualizer;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\f\u0010\n\u001a\u00020\u000b*\u00020\u000bH\u0002¨\u0006\r"}, d2 = {"Lcom/larus/av_call/view/RealtimeCallStatusAudioVisualizer;", "Lcom/larus/common_ui/view/CustomBarCountAudioVisualizer;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dpToPx", "", "Companion", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallStatusAudioVisualizer extends CustomBarCountAudioVisualizer {

    public static final class a {
    }

    static {
    }

    public RealtimeCallStatusAudioVisualizer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RealtimeCallStatusAudioVisualizer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final float f(float r100) {
        Resources r101 = getResources();
        return r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density;
    }

    public RealtimeCallStatusAudioVisualizer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setVisualizerHeight(f(18.0f));
        setBarWidth(f(3.69231f));
        setGapWidth(f(2.4615f));
        setMinBarHeight(0.0f);
        setMaxBarHeight(f(14.30769f));
    }

    public /* synthetic */ RealtimeCallStatusAudioVisualizer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
