package com.bytedance.ee.bear.document.setting;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ DocumentPermTyeActivity a;

    public a(DocumentPermTyeActivity r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Integer r3 = (Integer) r2;
        DocumentPermTyeActivity r0 = this.a;
        Intrinsics.checkNotNull(r3);
        DocumentPermTyeActivity.C1(r0, r3.intValue());
    }
}
