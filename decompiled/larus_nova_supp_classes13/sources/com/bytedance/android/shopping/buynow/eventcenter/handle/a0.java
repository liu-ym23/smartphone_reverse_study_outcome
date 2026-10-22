package com.bytedance.android.shopping.buynow.eventcenter.handle;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a0 implements Action {
    public final /* synthetic */ z a;

    public a0(z r1) {
        this.a = r1;
    }

    public final void run() {
        this.a.h.setSubmitStatusFlag(true);
    }
}
