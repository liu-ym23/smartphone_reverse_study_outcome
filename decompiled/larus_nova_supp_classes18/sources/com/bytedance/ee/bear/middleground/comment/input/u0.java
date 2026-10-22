package com.bytedance.ee.bear.middleground.comment.input;

import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u0 implements kn4.g.b {
    public final /* synthetic */ InputComment a;

    public final void a(int r1, int r2) {
    }

    public u0(InputComment r1) {
        this.a = r1;
    }

    public final void b(boolean r2) {
        if (r2 == true) goto L8;
        ImageView r3 = this.a.q;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("atView");
        r3 = null;
    L6:
        r3.setSelected(false);
        return;
    }
}
