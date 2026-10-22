package com.bytedance.ee.bear.more.protocol3.extension;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ a a;

    public h(a r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Boolean r4 = (Boolean) r3;
        tt5.a.h("DefMoreInfoBehavior", "feedShortcutFlow ok. ");
        a r0 = this.a;
        oj5.a r1 = r0.c();
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r4);
        r1.e = r4.booleanValue();
    L6:
        r0.e(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
