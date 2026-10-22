package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.EmptyHolderInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements j<EmptyHolderInfo> {
    public g() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r100, ncc.g r101, SpanInfo r102, com.ss.android.lark.widget.light.e r103) {
        EmptyHolderInfo r104 = (EmptyHolderInfo) r102;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanBuilder");
        Intrinsics.checkNotNullParameter(r104, "spanInfo");
        Intrinsics.checkNotNullParameter(r103, "params");
        com.ss.android.lark.widget.span.h r105 = new com.ss.android.lark.widget.span.h(r104.holderText);
        r101.b(r104.text, r105, 33);
    }
}
