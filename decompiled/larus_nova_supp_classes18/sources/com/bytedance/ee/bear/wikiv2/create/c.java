package com.bytedance.ee.bear.wikiv2.create;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ WikiCreateSelectPanelDialog a;

    public c(WikiCreateSelectPanelDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        WikiCreateSelectView r0 = this.a.Z90();
        Intrinsics.checkNotNull(r3);
        r0.setEnable(r3.booleanValue());
    }
}
