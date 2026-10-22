package com.bytedance.ee.bear.middleground.comment.card;

import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i0 implements kn4.g.b {
    public final /* synthetic */ HalfScreenCardComment a;

    public final void a(int r1, int r2) {
    }

    public i0(HalfScreenCardComment r1) {
        this.a = r1;
    }

    public final void b(boolean r2) {
        ImageView r0 = this.a.Q;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("atButton");
        r0 = null;
    L5:
        r0.setSelected(r2);
        this.a.getClass();
    }
}
