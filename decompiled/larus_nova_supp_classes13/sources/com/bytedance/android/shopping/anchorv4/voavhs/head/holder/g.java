package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ View a;

    public g(View r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.setContentDescription(com.bytedance.android.shopping.extensions.j.c(2131913861));
    }
}
