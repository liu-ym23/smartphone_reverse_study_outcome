package com.bytedance.ee.bear.middleground.permission.apply;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFragment;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@UserScope
public final class OfficePermissionPageFactory implements c0 {
    public static final /* synthetic */ int c = 0;
    public final Lazy a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public final boolean g() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }

    @Inject
    public OfficePermissionPageFactory() {
        this.a = LazyKt.lazy(OfficePermissionPageFactory$defaultFactory$2.INSTANCE);
        this.b = LazyKt.lazy(new OfficePermissionPageFactory$enable$2(this));
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final j1 c() {
        if (g() == false) goto L6;
        return new j1(2131564064, 2131244666, 2131244706, 2131244665);
    L6:
        return ((a0) this.a.getValue()).c();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final au5.a b(NoPermission r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        if (g() == false) goto L6;
        int r0 = OfficeApplyPermissionFragment.l;
        return OfficeApplyPermissionFragment.a.a(r2, ApplyPermissionPageMode.AUDIT_CONTROL);
    L6:
        return ((a0) this.a.getValue()).b(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final au5.a d(NoPermission r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        if (g() == false) goto L5;
        int r1 = OfficeBitableApplyPermissionFragment.r;
        Intrinsics.checkNotNullParameter(r6, "params");
        OfficeBitableApplyPermissionFragment r2 = new OfficeBitableApplyPermissionFragment();
        Bundle r3 = new Bundle();
        r3.putSerializable("params", r6);
        r2.setArguments(r3);
        return r2;
    L5:
        int r4 = BitableApplyProFragment.u;
        Intrinsics.checkNotNullParameter(r6, "params");
        BitableApplyProFragment r5 = new BitableApplyProFragment();
        String r0 = r6.getOwnerName();
        String r7 = r6.getOwnerId();
        String r8 = r6.getToken();
        Bundle r9 = new Bundle();
        r9.putString("owner_name", r0);
        r9.putString("owner_id", r7);
        r9.putString(ResourceData.KEY_TOKEN, r8);
        r5.setArguments(r9);
        return r5;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final au5.a f(NoPermission r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        if (g() == false) goto L6;
        int r0 = OfficeApplyPermissionFragment.l;
        return OfficeApplyPermissionFragment.a.a(r2, ApplyPermissionPageMode.NORMAL);
    L6:
        return ((a0) this.a.getValue()).f(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final DialogFragment a(FragmentActivity r8, int r9, String r10, boolean r11, Runnable r12) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        return ((a0) this.a.getValue()).a(r8, r9, r10, r11, r12);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final BaseFragment e(FragmentManager r9, String r10, int r11, int r12, boolean r13, Runnable r14) {
        Intrinsics.checkNotNullParameter(r9, "fm");
        return ((a0) this.a.getValue()).e(r9, r10, r11, r12, r13, r14);
    }
}
