package com.bytedance.ee.bear.facade.common.empty;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Observer<EmptyStateSource.b> {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        c r0 = this.a;
        r0.a((EmptyStateSource.b) r2);
    }
}
