package com.bytedance.ee.bear.middleground.comment.widget;

import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {
    public y() {
    }

    public final void a(com.ss.android.lark.coremd.impl.parse.k r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        com.ss.android.lark.coremd.base.parse.s r0 = r4.g;
        StringBuilder r1 = new StringBuilder("`");
        String r5 = r4.d.j;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r1.append(r5);
        r1.append('`');
        r0.d(r1.toString());
    }
}
