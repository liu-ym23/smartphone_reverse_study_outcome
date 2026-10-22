package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.PersonInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class v implements j<PersonInfo> {
    public v() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r100, ncc.g r101, SpanInfo r102, com.ss.android.lark.widget.light.e r103) {
        PersonInfo r104 = (PersonInfo) r102;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanBuilder");
        Intrinsics.checkNotNullParameter(r104, "spanInfo");
        Intrinsics.checkNotNullParameter(r103, "params");
        SpannableStringBuilder r105 = new SpannableStringBuilder(r104.text);
        r105.setSpan(new com.ss.android.lark.widget.codeblock.theme.b(UIHelper.dp2px(r104.getLineHeight())), 0, r105.length(), 33);
        r105.setSpan(new ncc.h(r104), 0, r105.length(), 33);
        Drawable r106 = UIHelper.getDrawable(R.drawable.card_avatar_placeholder);
        Intrinsics.checkNotNull(r106);
        r105.setSpan(new com.ss.android.lark.widget.light.span.m(r100, r104, r106), 0, r105.length(), 33);
        r105.setSpan(new com.ss.android.lark.widget.light.span.l(r104), 0, r105.length(), 33);
        r101.a(r105);
    }
}
