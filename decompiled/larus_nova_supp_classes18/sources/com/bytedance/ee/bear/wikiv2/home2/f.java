package com.bytedance.ee.bear.wikiv2.home2;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ WikiHomeFragment2 a;

    public f(WikiHomeFragment2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        com.bytedance.ee.bear.wikiv2.home2.model.l r4 = (com.bytedance.ee.bear.wikiv2.home2.model.l) r3;
        if (r4.a.isEmpty() == false) goto L5;
        this.a.Y90().setVisibility(8);
        return;
    L5:
        this.a.Y90().setVisibility(0);
        WikiHomeTopSpaceView r0 = this.a.Y90();
        Intrinsics.checkNotNull(r4);
        r0.setData(r4);
    }
}
