package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements com.bytedance.android.ecom.arch.slice.render.b {
    public final t a;

    public h(t r2) {
        Intrinsics.checkNotNullParameter(r2, "finder");
        this.a = r2;
    }

    public final void a(com.bytedance.android.ecom.arch.slice.action.r r4) {
        Intrinsics.checkNotNullParameter(r4, "actionInfo");
        IAction r0 = r4.a;
        View r5 = r4.d;
        v r1 = this.a.a(r0.getType());
        if (r1 == null) goto L6;
        r1.m(r0, r5);
        return;
    }
}
