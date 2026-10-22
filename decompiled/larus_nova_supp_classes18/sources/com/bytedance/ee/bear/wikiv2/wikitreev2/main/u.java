package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u<T> implements Observer {
    public final /* synthetic */ WikiTreeFragment a;

    public u(WikiTreeFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        SpaceCoverView r0 = this.a.W90();
        Intrinsics.checkNotNull(r3);
        r0.setFavorite(r3.booleanValue());
    }
}
