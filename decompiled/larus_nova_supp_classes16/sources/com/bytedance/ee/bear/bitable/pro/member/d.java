package com.bytedance.ee.bear.bitable.pro.member;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.q;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ BitableRoleMemberManagerFragment a;

    public d(BitableRoleMemberManagerFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        tt5.a.e("BitableRoleMemberManagerFragment", "removeMember()...error", (Throwable) r4, false);
        Toast.showFailureText(this.a.getActivity(), 2131888209);
        BitableRoleMemberManagerFragment r5 = this.a;
        int r0 = BitableRoleMemberManagerFragment.s;
        ((q) r5.r.getValue()).a();
    }
}
