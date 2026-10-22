package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.MentionInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class s implements j<MentionInfo> {
    public s() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r100, ncc.g r110, SpanInfo r111, com.ss.android.lark.widget.light.e r112) {
        MentionInfo r113 = (MentionInfo) r111;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "spanBuilder");
        Intrinsics.checkNotNullParameter(r113, "spanInfo");
        Intrinsics.checkNotNullParameter(r112, "params");
        String r114 = r113.text;
        if (r113.type != 11) goto L5;
        String r115 = r113.f448580id;
        Intrinsics.checkNotNull(r114);
        r110.b(r114, new com.ss.android.lark.widget.light.span.f(r115, r114), 33);
        return;
    L5:
        String r101 = r113.f448580id;
        Intrinsics.checkNotNull(r114);
        r110.b(r114, new com.ss.android.lark.widget.light.span.i(r100, r101, r114, r113.isAuthorized, r113.url), 33);
    }
}
