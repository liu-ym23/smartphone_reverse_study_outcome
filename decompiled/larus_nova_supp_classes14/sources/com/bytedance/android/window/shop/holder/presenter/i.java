package com.bytedance.android.window.shop.holder.presenter;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i implements com.bytedance.android.ec.window.base.common.bubble.g {
    public final /* synthetic */ j a;

    public final void onShow() {
    }

    public final void onDismiss() {
        Function0 r0 = this.a.e;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    public i(j r1) {
        this.a = r1;
    }
}
