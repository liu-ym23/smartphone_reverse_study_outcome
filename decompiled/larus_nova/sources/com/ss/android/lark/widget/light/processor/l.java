package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.ImageGalleryInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class l implements j<ImageGalleryInfo> {
    public l() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r100, ncc.g r101, SpanInfo r102, com.ss.android.lark.widget.light.e r103) {
        ImageGalleryInfo r104 = (ImageGalleryInfo) r102;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanBuilder");
        Intrinsics.checkNotNullParameter(r104, "spanInfo");
        Intrinsics.checkNotNullParameter(r103, "params");
        k r105 = new k(r104);
        int r106 = r101.length();
        SpannableStringBuilder r107 = new SpannableStringBuilder(r104.text);
        r107.setSpan(r105, 0, r107.length(), 33);
        r101.a(r107);
        r101.setSpan(new com.ss.android.lark.widget.light.span.p(r104, r104.text), r106, r101.length(), 33);
    }
}
