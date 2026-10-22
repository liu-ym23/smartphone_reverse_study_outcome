package com.bytedance.android.shopping.mall.homepage.card.common.feedback;

import com.bytedance.android.ec.hybrid.card.event.e;
import com.bytedance.android.ec.hybrid.list.ability.v;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.common.tools.p;
import com.google.gson.Gson;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements e {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    public final void a(com.bytedance.android.ec.hybrid.card.event.d r8) {
        Intrinsics.checkNotNullParameter(r8, "jsEvent");
        b r0 = this.a;
        final BaseViewHolder r1 = r0.e;
        Map r2 = r8.b;
        final int r3 = -1;
        if (r2 == null) goto L5;
        Object r4 = b0.d(r2, "index", -1);
    L7:
        if ((r4 instanceof Integer) == true) goto L9;
        r4 = null;
    L9:
        Integer r5 = (Integer) r4;
        if (r5 == null) goto L12;
        int r6 = r5.intValue();
    L13:
        Map r9 = r8.b;
        if (r9 == null) goto L16;
        Object r10 = b0.d(r9, "triggerBy", -1);
    L18:
        if ((r10 instanceof Integer) == true) goto L20;
        r10 = null;
    L20:
        Integer r11 = (Integer) r10;
        if (r11 == null) goto L23;
        r3 = r11.intValue();
    L23:
        com.bytedance.android.ec.hybrid.list.ability.a r12 = r1.b;
        if (r12 == null) goto L28;
        v r13 = (v) r12.getAbility(v.class);
        if (r13 == null) goto L28;
        Integer r14 = Integer.valueOf(r13.Qc(r1.getAdapterPosition()));
    L29:
        if (r14 != null) goto L32;
    L34:
        r0.a();
        Function1<FeedbackData, Unit> r15 = new FeedBackWidget$onReceiveFeedbackGlobalEvent$1(r1, r3);
        Object r7 = r1.U3("negfeedback", null, null, null);
        if (r7 == null) goto L41;
        Gson r16 = p.a;     // Catch: Exception -> L38
        r15.invoke((FeedbackData) p.a(r7.toString(), FeedbackData.class));     // Catch: Exception -> L38
        return;
    L43:
        return;
    L41:
        return;
    L32:
        if (r14.intValue() != r6) goto L34;
        return;
    L28:
        r14 = null;
        goto L29
    L16:
        r10 = null;
        goto L18
    L12:
        r6 = -1;
        goto L13
    L5:
        r4 = null;
        goto L7
    }
}
