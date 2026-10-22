package com.bytedance.android.window.shop.holder.presenter;

import android.view.View;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q implements Action {
    public final /* synthetic */ View a;

    public q(View r1) {
        this.a = r1;
    }

    public final void run() {
        View r0 = this.a;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }
}
