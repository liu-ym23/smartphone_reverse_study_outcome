package com.bytedance.ee.bear.middleground.comment.card;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v0 implements com.bytedance.ee.bear.facade.common.widget.d.b {
    public final /* synthetic */ HalfScreenCardComment a;

    public v0(HalfScreenCardComment r1) {
        this.a = r1;
    }

    public final void a(int r3) {
        a.b = r3;
        this.a.b.p1().invoke(Integer.valueOf(r3));
        d r0 = this.a.E;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r0 = null;
    L5:
        r0.g = Integer.valueOf(r3);
        if (r3 == 0) goto L8;
        return;
    L8:
        if (this.a.isShowing() == false) goto L12;
        this.a.Ni(false);
        return;
    }
}
