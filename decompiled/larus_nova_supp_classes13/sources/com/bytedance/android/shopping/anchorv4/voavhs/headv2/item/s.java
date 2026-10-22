package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.j {
    public final /* synthetic */ w a;
    public final /* synthetic */ int b;

    /* JADX WARN: Type inference failed for: r15v0, types: [android.widget.FrameLayout, com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.w, java.lang.Object] */
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.j
    public final void a(Function0<Unit> r17) {
        Intrinsics.checkNotNullParameter(r17, "endCallback");
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s.a.b(this.a.getHeadAbility(), Integer.valueOf(this.b), 2) == false) goto L22;
        ?? r15 = this.a;
        int r5 = this.b;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r17, "callback");
        RecyclerView r1 = r15.m.getRecyclerView();
        if (r1 == null) goto L7;
        int r10 = r1.getHeight();
    L8:
        float r7 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b.k(r15.n, r5, null, null, Boolean.TRUE, 6);
        int r6 = r15.getHeight();
        int r8 = r15.getWidth();
        int r9 = r15.n.n();
        ViewGroup.LayoutParams r2 = r15.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L11;
        r2 = null;
    L11:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        if (r3 == null) goto L14;
        int r11 = r3.topMargin;
    L15:
        if (r3 == null) goto L17;
        int r12 = r3.bottomMargin;
    L18:
        if (r3 == null) goto L20;
        int r13 = r3.leftMargin;
    L21:
        ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r14.setDuration(400);
        r14.addUpdateListener(new q(r14, r15, r10, r7, r6, r7, r8, r9, r13, r11, r12, r17));
        r14.addListener(new r(r15, r17));
        r14.start();
        return;
    L20:
        r13 = 0;
        goto L21
    L17:
        r12 = 0;
        goto L18
    L14:
        r11 = 0;
        goto L15
    L7:
        r10 = 0;
        goto L8
    L22:
        r17.invoke();
    }

    public s(w r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
