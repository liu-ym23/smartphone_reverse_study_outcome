package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.PrefixInfo;
import com.ss.android.lark.widget.span.PrefixSpan;
import com.ss.android.lark.widget.span.SpanInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes38.dex */
public final class x implements j<PrefixInfo> {
    public x() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r100, ncc.g r101, SpanInfo r102, com.ss.android.lark.widget.light.e r103) {
        PrefixInfo r104 = (PrefixInfo) r102;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanBuilder");
        Intrinsics.checkNotNullParameter(r104, "spanInfo");
        Intrinsics.checkNotNullParameter(r103, "params");
        Object r105 = new PrefixSpan(r104.prefixParams);
        int r106 = RangesKt.coerceAtMost(r101.length(), r104.end);
        r101.setSpan(r105, r104.start, r106, 33);
        com.ss.android.lark.widget.light.span.p r107 = new com.ss.android.lark.widget.light.span.p(r104, r101.subSequence(r104.start, r106).toString());
        r107.f446282d = false;
        r101.setSpan(r107, r104.start, r106, 33);
    }
}
