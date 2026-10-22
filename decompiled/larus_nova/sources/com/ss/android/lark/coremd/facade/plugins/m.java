package com.ss.android.lark.coremd.facade.plugins;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.coremd.span.BlockQuoteSpan;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class m implements com.ss.android.lark.coremd.base.parse.f {
    public m() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void d(com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void f(com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void a(v7b.s r100, Spannable r101) {
        com.ss.android.lark.coremd.base.parse.f.a.b(r100, r101);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void b(com.ss.android.lark.coremd.impl.parse.d r100, v7b.s r101) {
        com.ss.android.lark.coremd.base.parse.f.a.a(r100, r101);
    }

    @Override // com.ss.android.lark.coremd.base.parse.f
    public final void g(com.ss.android.lark.coremd.impl.parse.d r110, SpannableStringBuilder r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "charSequence");
        Object[] r112 = r111.getSpans(0, r111.length(), BlockQuoteSpan.class);
        int r100 = r112.length;
        int r101 = -1;
        BlockQuoteSpan r102 = null;
        int r103 = 0;
    L4:
        if (r103 >= r100) goto L10;
        BlockQuoteSpan r104 = (BlockQuoteSpan) r112[r103];
        int r105 = r111.getSpanStart(r104);
        int r106 = r111.getSpanEnd(r104);
        if (r105 != (r101 + 1)) goto L9;
        if (r102 == null) goto L9;
        r104.f419927c = false;
        r102.f419928d = false;
    L9:
        r103 = r103 + 1;
        r102 = r104;
        r101 = r106;
        goto L4
    L10:
        if (r102 == null) goto L17;
        r102.f419928d = true;
        return;
    }
}
