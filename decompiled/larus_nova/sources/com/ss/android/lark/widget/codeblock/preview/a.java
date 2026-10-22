package com.ss.android.lark.widget.codeblock.preview;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.e;
import com.ss.android.lark.widget.light.processor.j;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.span.SpanInfo;
import kotlin.jvm.internal.Intrinsics;
import ncc.g;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements j<CodeBlockV2Info> {
    public a() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r100, g r101, SpanInfo r102, e r103) {
        CodeBlockV2Info r104 = (CodeBlockV2Info) r102;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanBuilder");
        Intrinsics.checkNotNullParameter(r104, "spanInfo");
        Intrinsics.checkNotNullParameter(r103, "params");
        int r105 = r101.length();
        String r106 = r104.text;
        r101.a(r106);
        r101.setSpan(new CodeBlockV2Span(r100, r104.getLineContents(), r104.getProcessParams(), r103.f445994l), r105, r106.length() + r105, 33);
        Intrinsics.checkNotNull(r106);
        r101.setSpan(new p(r104, r106), r105, r106.length() + r105, 33);
        r101.setSpan(new CodeBlockV2ClickSpan(r104), r105, r106.length() + r105, 33);
    }
}
