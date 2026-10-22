package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ j a;

    public i(j r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        fd2.a r3 = (fd2.a) r2;
        if ((r3 instanceof fd2.a.b) == false) goto L5;
    L8:
        this.a.c();
        return;
    L5:
        if ((r3 instanceof fd2.a.c) == true) goto L8;
        if ((r3 instanceof fd2.a.d) == true) goto L8;
    }
}
