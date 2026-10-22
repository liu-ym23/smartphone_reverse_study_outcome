package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.PhoneInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class w implements j<PhoneInfo> {
    public w() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r100, ncc.g r101, SpanInfo r102, com.ss.android.lark.widget.light.e r103) {
        PhoneInfo r104 = (PhoneInfo) r102;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanBuilder");
        Intrinsics.checkNotNullParameter(r104, "spanInfo");
        Intrinsics.checkNotNullParameter(r103, "params");
        String r105 = r104.text;
        Intrinsics.checkNotNull(r105);
        r101.b(r105, new com.ss.android.lark.widget.light.span.n(r100, r105), 33);
    }
}
