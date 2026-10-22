package com.bytedance.ee.bear.bitable.pro;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ BitableProFragment a;

    public p(BitableProFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Boolean r5 = (Boolean) r4;
        BitableProFragment r0 = this.a;
        Intrinsics.checkNotNull(r5);
        boolean r1 = r5.booleanValue();
        int r2 = BitableProFragment.N;
        r0.ga0().setCheckedIgnoreEvent(r1);
        BitableProViewModel r3 = this.a.D;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L5:
        r3.updateRolesPro(r5.booleanValue());
        this.a.ma0(r5.booleanValue());
    }
}
