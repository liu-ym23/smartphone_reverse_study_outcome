package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.SpanInfo;
import com.ss.android.lark.widget.span.TextStyleInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a0 implements j<TextStyleInfo> {

    public static final class a {
    }

    static {
    }

    public a0() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r100, ncc.g r101, SpanInfo r102, com.ss.android.lark.widget.light.e r103) {
        TextStyleInfo r104 = (TextStyleInfo) r102;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanBuilder");
        Intrinsics.checkNotNullParameter(r104, "spanInfo");
        Intrinsics.checkNotNullParameter(r103, "params");
        String r105 = r104.text;
        Object r106 = new ncc.h(r104);
        if (r104.isIndependent == false) goto L5;
        r101.b(r105, r106, 33);
        return;
    L5:
        int r107 = r104.end;
        int r108 = RangesKt.coerceAtMost(r101.length(), r107);
        int r109 = r104.start;
        if (r109 <= r108) goto L9;
        Log.i("TextStyleSpanProcessor", "occurs text style start > end!, span text size = " + r105.length() + ", span start = " + r109 + ", end = " + r107);
        return;
    L9:
        if (TextUtils.equals(r101.subSequence(r109, r108).toString(), r105) == false) goto L14;
        r101.setSpan(r106, r104.start, r108, 33);
        return;
    }
}
