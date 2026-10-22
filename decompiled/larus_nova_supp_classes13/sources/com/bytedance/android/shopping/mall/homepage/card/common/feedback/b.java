package com.bytedance.android.shopping.mall.homepage.card.common.feedback;

import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.list.ability.v;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedConstraintLayout;
import com.bytedance.android.shopping.api.mall.common.tools.p;
import com.bytedance.android.shopping.mall.homepage.card.AbstractNativeCard;
import com.google.gson.Gson;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public String a;
    public FeedbackView b;
    public Boolean c;
    public final a d;
    public final BaseViewHolder e;
    public final int f;

    public final void a() {
        ConstraintLayout r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewParent r1 = r0.getParent();
        if ((r1 instanceof ViewGroup) == true) goto L8;
        r1 = null;
    L8:
        ViewGroup r2 = (ViewGroup) r1;
        if (r2 == null) goto L11;
        r2.removeView(this.b);
    L11:
        this.b = null;
        ECEventCenter.f("negfeedback_hide_notification", this.d);
    }

    public b(AbstractNativeCard r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        this.e = r2;
        this.f = r3;
        this.a = "";
        this.d = new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.view.View, com.bytedance.android.shopping.mall.homepage.card.common.feedback.FeedbackView] */
    public final void b(String r11, ECRoundedConstraintLayout r12, ConstraintLayout.LayoutParams r13, final float r14) {
        Intrinsics.checkNotNullParameter(r11, "sceneID");
        Intrinsics.checkNotNullParameter(r12, "parent");
        Intrinsics.checkNotNullParameter(r13, "layoutParams");
        if (this.b == null) goto L5;
        return;
    L5:
        ECEventCenter.e("negfeedback_hide_notification", this.d, r11);
        ?? r0 = new FeedbackView(r12.getContext());
        if (Intrinsics.areEqual(this.c, Boolean.TRUE) == false) goto L8;
        r0.U5();
    L8:
        Unit r1 = Unit.INSTANCE;
        this.b = r0;
        r12.addView(r0, r13);
        com.bytedance.android.ec.hybrid.list.ability.a r15 = this.e.b;
        if (r15 == null) goto L13;
        v r16 = (v) r15.getAbility(v.class);
        if (r16 == null) goto L13;
        Integer r17 = Integer.valueOf(r16.Qc(this.e.getAdapterPosition()));
    L14:
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("negfeedback_hide_notification", System.currentTimeMillis(), r11, false, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("triggerBy", 2), TuplesKt.to("index", r17)}), false, 32));
        BaseViewHolder r18 = this.e;
        Function1<FeedbackData, Unit> r19 = new FeedBackWidget$showFeedbackView$2(this, r14);
        Object r110 = r18.U3("negfeedback", null, null, null);
        if (r110 == null) goto L21;
        Gson r111 = p.a;     // Catch: Exception -> L18
        r19.invoke((FeedbackData) p.a(r110.toString(), FeedbackData.class));     // Catch: Exception -> L18
        return;
    L22:
        return;
    L21:
        return;
    L13:
        r17 = null;
        goto L14
    }
}
