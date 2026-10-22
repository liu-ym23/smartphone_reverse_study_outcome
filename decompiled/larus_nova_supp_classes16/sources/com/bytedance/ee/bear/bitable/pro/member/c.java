package com.bytedance.ee.bear.bitable.pro.member;

import android.content.Context;
import com.bytedance.ee.bear.bitable.pro.BitableProViewModel;
import com.bytedance.ee.bear.bitable.pro.PermissionUpdateStatus;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.q;
import com.larksuite.component.universe_design.toast.UDToast;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ BitableRoleMemberManagerFragment a;
    public final /* synthetic */ UserInfo b;

    public c(BitableRoleMemberManagerFragment r1, UserInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        SimpleRequestResult r6 = (SimpleRequestResult) r5;
        int r7 = com.bytedance.ee.bear.bitable.pro.e.a;
        BitableProViewModel r1 = null;
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("base.advanced_permission.role_inheritance") == false) goto L12;
        BitableProViewModel r8 = this.a.k;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r8 = null;
    L8:
        if (r8.isOverPermission(this.a.j, this.b) == false) goto L12;
        Context r9 = this.a.getContext();
        if (r9 == null) goto L13;
        UDToast.show(r9, 2131886213, 2131256189);
    L13:
        BitableRoleMemberManagerFragment r10 = this.a;
        int r2 = BitableRoleMemberManagerFragment.s;
        ((q) r10.r.getValue()).a();
        BitableProViewModel r11 = this.a.k;
        if (r11 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r11 = null;
    L16:
        r11.fetchProData();
        sk5.c r12 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
        BitableRoleMemberManagerFragment r3 = this.a;
        if (r3.q == false) goto L31;
        BitableProViewModel r4 = r3.k;
        if (r4 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L22:
        if (r4.getUpdateStatus().getValue() == PermissionUpdateStatus.Updated) goto L24;
        return;
    L24:
        if (r12.f("bitable_permission_upgrade_ssc") == true) goto L33;
        BitableProViewModel r13 = this.a.k;
        if (r13 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L29:
        r1.fetchUpdateEffectData();
        return;
    L28:
        r1 = r13;
        goto L29
    L33:
        return;
    L31:
        return;
    L12:
        Toast.showSuccessText(this.a.getActivity(), 2131887838);
        goto L13
    }
}
