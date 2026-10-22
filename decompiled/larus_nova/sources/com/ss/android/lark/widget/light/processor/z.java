package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.SpacingInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import com.ss.android.lark.widget.span.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class z implements j<SpacingInfo> {
    public z() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r100, ncc.g r101, SpanInfo r102, com.ss.android.lark.widget.light.e r103) {
        SpacingInfo r104 = (SpacingInfo) r102;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanBuilder");
        Intrinsics.checkNotNullParameter(r104, "spanInfo");
        Intrinsics.checkNotNullParameter(r103, "params");
        String r105 = r104.text;
        e0.a r106 = new e0.a();
        r106.f448672a = r104.spacingHeight;
        r101.b(r105, new e0(r106), 33);
        if (r104.needRemoveWhenCopy == false) goto L9;
        int r107 = r104.start;
        if (r104.removePrevChangeLineOnCopy == false) goto L7;
        r107 = Math.max(r107 - 1, 0);
    L7:
        Object r108 = new y();
        r101.setSpan(r108, r107, r104.end, 33);
        Intrinsics.checkNotNull(r105);
        r101.setSpan(new com.ss.android.lark.widget.light.span.p(r108, r105), r104.start, r104.end, 33);
        return;
    }
}
