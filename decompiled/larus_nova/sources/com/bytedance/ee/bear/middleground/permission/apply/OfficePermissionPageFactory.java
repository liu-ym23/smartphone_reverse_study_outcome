package com.bytedance.ee.bear.middleground.permission.apply;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFragment;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.larus.nova.R;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@UserScope
public final class OfficePermissionPageFactory implements c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f232952c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f232953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f232954b;

    public static final class a {
    }

    static {
    }

    public final boolean g() {
        return ((Boolean) this.f232954b.getValue()).booleanValue();
    }

    @Inject
    public OfficePermissionPageFactory() {
        this.f232953a = LazyKt.lazy(OfficePermissionPageFactory$defaultFactory$2.INSTANCE);
        this.f232954b = LazyKt.lazy(new OfficePermissionPageFactory$enable$2(this));
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final j1 c() {
        if (g() == false) goto L6;
        return new j1(R.layout.office_permission_forbid, R.drawable.office_drive_error_warning, R.drawable.office_permission_lock, R.drawable.office_drive_error_link_broken);
    L6:
        return ((a0) this.f232953a.getValue()).c();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final au5.a b(NoPermission r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (g() == false) goto L6;
        int r101 = OfficeApplyPermissionFragment.f232929l;
        return OfficeApplyPermissionFragment.a.a(r100, ApplyPermissionPageMode.AUDIT_CONTROL);
    L6:
        return ((a0) this.f232953a.getValue()).b(r100);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final au5.a d(NoPermission r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (g() == false) goto L5;
        int r101 = OfficeBitableApplyPermissionFragment.f232937r;
        Intrinsics.checkNotNullParameter(r100, "params");
        OfficeBitableApplyPermissionFragment r102 = new OfficeBitableApplyPermissionFragment();
        Bundle r103 = new Bundle();
        r103.putSerializable("params", r100);
        r102.setArguments(r103);
        return r102;
    L5:
        int r104 = BitableApplyProFragment.f215126u;
        Intrinsics.checkNotNullParameter(r100, "params");
        BitableApplyProFragment r105 = new BitableApplyProFragment();
        String r106 = r100.getOwnerName();
        String r107 = r100.getOwnerId();
        String r108 = r100.getToken();
        Bundle r109 = new Bundle();
        r109.putString("owner_name", r106);
        r109.putString("owner_id", r107);
        r109.putString("token", r108);
        r105.setArguments(r109);
        return r105;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final au5.a f(NoPermission r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (g() == false) goto L6;
        int r101 = OfficeApplyPermissionFragment.f232929l;
        return OfficeApplyPermissionFragment.a.a(r100, ApplyPermissionPageMode.NORMAL);
    L6:
        return ((a0) this.f232953a.getValue()).f(r100);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final DialogFragment a(FragmentActivity r100, int r101, String r110, boolean r111, Runnable r112) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return ((a0) this.f232953a.getValue()).a(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.c0
    public final BaseFragment e(FragmentManager r100, String r110, int r111, int r112, boolean r113, Runnable r114) {
        Intrinsics.checkNotNullParameter(r100, "fm");
        return ((a0) this.f232953a.getValue()).e(r100, r110, r111, r112, r113, r114);
    }
}
