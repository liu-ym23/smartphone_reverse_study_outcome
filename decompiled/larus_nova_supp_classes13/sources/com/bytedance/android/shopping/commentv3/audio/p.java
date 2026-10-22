package com.bytedance.android.shopping.commentv3.audio;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p implements a {
    public final Function0<fc3.a> a;

    public p(Function0<fc3.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContextProvider");
        this.a = r2;
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.a
    public final void a(IAction r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        fc3.a r0 = (fc3.a) this.a.invoke();
        if (r0 == null) goto L6;
        r0.a(new fc3.c(r5, null, null, 14));
        return;
    }
}
