package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.AtUserGroupInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements j<AtUserGroupInfo> {
    public e() {
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r100, ncc.g r101, SpanInfo r110, com.ss.android.lark.widget.light.e r111) {
        AtUserGroupInfo r112 = (AtUserGroupInfo) r110;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spanBuilder");
        Intrinsics.checkNotNullParameter(r112, "spanInfo");
        Intrinsics.checkNotNullParameter(r111, "params");
        String r102 = r112.text;
        SpannableStringBuilder r103 = new SpannableStringBuilder(r102);
        int r104 = r103.length();
        boolean r105 = true;
        if (r112.getPermissionStatus() != 1) goto L5;
    L8:
        boolean r106 = true;
    L10:
        if (r106 == true) goto L12;
    L15:
        r105 = false;
    L16:
        if (r105 == false) goto L18;
        Intrinsics.checkNotNull(r102);
        r103.setSpan(new com.ss.android.lark.widget.light.span.p(r112, r102), 0, r103.length(), 33);
    L18:
        r103.setSpan(new ncc.h(r112), 0, r103.length(), 33);
        r101.a(r103);
        return;
    L12:
        if (r111.O == false) goto L15;
        r103.setSpan(new com.ss.android.lark.widget.light.span.c(r112, UIUtils.getColor(r100, R.color.imtoken_message_text_bubbles_blue)), 0, r104, 33);
        goto L16
    L5:
        if (r112.getPermissionStatus() == 2) goto L8;
        r106 = false;
        goto L10
    }
}
