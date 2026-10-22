package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.HRInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements j<HRInfo> {
    public i() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r100, ncc.g r101, SpanInfo r102, com.ss.android.lark.widget.light.e r103) {
        HRInfo r104 = (HRInfo) r102;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanBuilder");
        Intrinsics.checkNotNullParameter(r104, "spanInfo");
        Intrinsics.checkNotNullParameter(r103, "params");
        r101.a(r104.text);
        if (r104.getAddEnterBeforeSpan() == false) goto L9;
        int r105 = r104.start;
        if (r105 <= 0) goto L9;
        if (Intrinsics.areEqual(r101.subSequence(r105 - 1, r105).toString(), "\n") == false) goto L9;
        h r106 = new h();
        int r107 = r104.start;
        r101.setSpan(r106, r107 - 1, r107, 33);
        com.ss.android.lark.widget.light.span.p r108 = new com.ss.android.lark.widget.light.span.p(r106, "\n");
        int r109 = r104.start;
        r101.setSpan(r108, r109 - 1, r109, 33);
    L9:
        int r110 = r104.start;
        if (r110 >= 0) goto L12;
        return;
    L12:
        if (r104.end < r110) goto L17;
        r101.setSpan(new com.ss.android.lark.widget.span.j(r100), r104.start, r104.end, 33);
        r101.setSpan(new com.ss.android.lark.widget.light.span.p(r104, r104.text), r104.start, r104.end, 33);
        return;
    }
}
