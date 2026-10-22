package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import android.text.style.ForegroundColorSpan;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.InlineCodeCenterSpan;
import com.ss.android.lark.widget.span.InlineCodeInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class o implements j<InlineCodeInfo> {
    public o() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r100, ncc.g r101, SpanInfo r102, com.ss.android.lark.widget.light.e r110) {
        InlineCodeInfo r103 = (InlineCodeInfo) r102;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanBuilder");
        Intrinsics.checkNotNullParameter(r103, "spanInfo");
        Intrinsics.checkNotNullParameter(r110, "params");
        if (r103.getUseTextStyle() == false) goto L5;
        ncc.h r111 = new ncc.h(r103);
        r101.b(r103.text, r111, 33);
    L6:
        int r112 = UIUtils.getColor(r100, R.color.transparent);
        if (r103.isLeftSpanIndexValid() == false) goto L10;
        com.ss.android.lark.widget.span.p r104 = new com.ss.android.lark.widget.span.p(r100, r103);
        r101.setSpan(r104, r103.getLeftSpanStart(), r103.getLeftSpanEnd(), 33);
        r101.setSpan(new ForegroundColorSpan(r112), r103.getLeftSpanStart(), r103.getLeftSpanEnd(), 33);
        r101.setSpan(new com.ss.android.lark.widget.light.span.p(r104, InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER), r103.getLeftSpanStart(), r103.getLeftSpanEnd(), 33);
    L10:
        if (r103.isRightSpanIndexValid() == false) goto L13;
        com.ss.android.lark.widget.span.o r105 = new com.ss.android.lark.widget.span.o(r100, r103);
        r101.setSpan(r105, r103.getRightSpanStart(), r103.getRightSpanEnd(), 33);
        r101.setSpan(new ForegroundColorSpan(r112), r103.getRightSpanStart(), r103.getRightSpanEnd(), 33);
        r101.setSpan(new com.ss.android.lark.widget.light.span.p(r105, InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER), r103.getRightSpanStart(), r103.getRightSpanEnd(), 33);
    L13:
        if (r103.isCenterSpanIndexValid() == false) goto L16;
        r101.setSpan(new InlineCodeCenterSpan(r100, r103), r103.getCenterSpanStart(), r103.getCenterSpanEnd(), 33);
        return;
    L16:
        return;
    L5:
        r101.a(r103.text);
        goto L6
    }
}
