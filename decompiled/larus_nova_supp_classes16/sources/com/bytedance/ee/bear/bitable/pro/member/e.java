package com.bytedance.ee.bear.bitable.pro.member;

import android.content.DialogInterface;
import com.bytedance.ee.bear.bitable.pro.BitableProViewModel;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.q;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements DialogInterface.OnClickListener {
    public final /* synthetic */ BitableRoleMemberManagerFragment a;
    public final /* synthetic */ UserInfo b;

    public e(BitableRoleMemberManagerFragment r1, UserInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        BitableRoleMemberManagerFragment r6 = this.a;
        UserInfo r7 = this.b;
        int r0 = BitableRoleMemberManagerFragment.s;
        ((q) r6.r.getValue()).e();
        BitableProViewModel r1 = r6.k;
        Disposable r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L5:
        Flowable<SimpleRequestResult> r3 = r1.removeMember(r6.j, r7);
        if (r3 == null) goto L8;
        r2 = r3.subscribe(new c(r6, r7), new d(r6));
    L8:
        if (r2 == null) goto L10;
        r6.o.add(r2);
    L10:
        com.bytedance.ee.bear.bitable.pro.d.c(true);
    }
}
