package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.EmojiconInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements j<EmojiconInfo> {
    public f() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r110, ncc.g r111, SpanInfo r112, com.ss.android.lark.widget.light.e r113) {
        EmojiconInfo r114 = (EmojiconInfo) r112;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "spanBuilder");
        Intrinsics.checkNotNullParameter(r114, "spanInfo");
        Intrinsics.checkNotNullParameter(r113, "params");
        String r100 = r114.text;
        int r101 = r114.emojiSize;
        if (r101 > 0) goto L6;
        r101 = r113.f445992j;
    L6:
        int r102 = r113.f445993k;
        Drawable r103 = r114.drawable;
        String r104 = r114.key;
        Object r105 = new com.ss.android.lark.widget.linked_emojicon.base.a(r110, r103, r104, r101, r102, r113.f445989g);
        int r115 = r111.length();
        r111.a(r100);
        r111.setSpan(r105, r115, r100.length() + r115, 33);
        Intrinsics.checkNotNull(r100);
        r111.setSpan(new com.ss.android.lark.widget.light.span.p(r114, r100), r115, r100.length() + r115, 33);
    }
}
