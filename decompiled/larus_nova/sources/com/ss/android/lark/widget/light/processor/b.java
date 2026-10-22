package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import android.text.style.AlignmentSpan;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.AlignInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements j<AlignInfo> {
    public b() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r100, ncc.g r101, SpanInfo r102, com.ss.android.lark.widget.light.e r103) {
        AlignInfo r104 = (AlignInfo) r102;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanBuilder");
        Intrinsics.checkNotNullParameter(r104, "spanInfo");
        Intrinsics.checkNotNullParameter(r103, "params");
        AlignmentSpan.Standard r105 = new AlignmentSpan.Standard(r104.mAlignment);
        int r106 = RangesKt.coerceAtMost(r101.length(), r104.end);
        int r107 = r104.start;
        int r108 = r106 - AlignInfo.getPlaceHolder().length();
        r101.setSpan(new com.ss.android.lark.widget.light.span.o(), r108, r106, 33);
        r101.setSpan(r105, r107, r108, 33);
    }
}
