package com.bytedance.ee.bear.middleground.permission.apply;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.larksuite.component.universe_design.edittext.UDEditText;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z0<T> implements Consumer {
    public final /* synthetic */ OfficeBitableApplyPermissionFragment a;

    public z0(OfficeBitableApplyPermissionFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        int r3 = ((SimpleRequestResult) r2).getCode();
        OfficeBitableApplyPermissionFragment.U90(this.a, r3);
        if (r3 != 0) goto L7;
        UDEditText r4 = this.a.k;
        if (r4 == null) goto L7;
        r4.setText("");
    L7:
        this.a.setLoading(false);
    }
}
