package com.bytedance.ee.bear.middleground.comment.card;

import com.larksuite.component.ui.button.LKUICheckBox2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h1 implements LKUICheckBox2.b {
    public final /* synthetic */ HalfScreenCardComment a;

    public h1(HalfScreenCardComment r1) {
        this.a = r1;
    }

    public final void a(LKUICheckBox2 r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "buttonView");
        HalfScreenCardComment r6 = this.a;
        com.bytedance.ee.bear.middleground.comment.uitls.h r0 = r6.a.d0;
        if (r5 == false) goto L5;
        String r7 = "reading_authority";
    L6:
        r0.g(r7, r6.UT(), "", null);
        return;
    L5:
        r7 = "cancel_reading_authority";
        goto L6
    }
}
