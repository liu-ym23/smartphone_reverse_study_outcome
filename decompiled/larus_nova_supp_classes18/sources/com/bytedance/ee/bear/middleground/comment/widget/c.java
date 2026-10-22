package com.bytedance.ee.bear.middleground.comment.widget;

import android.view.View;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements View.OnLayoutChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ BotAtHintView b;

    public c(int r1, BotAtHintView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        r3.removeOnLayoutChangeListener(this);
        int r12 = this.a;
        BotAtHintView r13 = this.b;
        if (r12 != r13.m) goto L43;
        b r14 = r13.l;
        if (r14 == null) goto L44;
        r13.l = null;
        a r15 = r13.b;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r14, "hintInfo");
        Iterator<j0> r16 = r15.y2().iterator();
        boolean r17 = false;
        int r18 = 0;
    L10:
        if (r16.hasNext() == false) goto L29;
        j0 r19 = r16.next();
        BotAtHintActionType r20 = r14.c;
        int r21 = a.C0074a.a[r20.ordinal()];
        if (r21 == 1) goto L21;
        if (r21 != 2) goto L19;
        if (r19.a.a == r14.a) goto L24;
    L25:
        boolean r22 = false;
    L26:
        if (r22 == true) goto L30;
        r18 = r18 + 1;
    L30:
        int r23 = this.b.b.getItemCount();
        if (this.b.a.isAttachedToWindow() == false) goto L42;
        if (r18 < 0) goto L35;
        if (r18 >= r23) goto L35;
        r17 = true;
    L35:
        if (r17 == false) goto L45;
        this.b.a.smoothScrollToPosition(r18);
        return;
    L45:
        return;
    L42:
        return;
    L24:
        r22 = true;
        goto L26
    L19:
        throw new NoWhenBranchMatchedException();
    L21:
        if (r19.a.c != BotAtHintActionType.LEARN_MORE) goto L25;
        if (r19.b.contains(r14.b) == false) goto L25;
    L29:
        r18 = -1;
        goto L30
    L44:
        return;
    }
}
