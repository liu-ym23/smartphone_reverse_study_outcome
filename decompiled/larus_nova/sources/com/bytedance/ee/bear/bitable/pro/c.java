package com.bytedance.ee.bear.bitable.pro;

import android.view.View;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Role f215161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BitableProAdapter f215162d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        if (this.f215161c.disableAddMembers() == true) goto L5;
        i0 r101 = this.f215162d.f215049a;
        if (r101 == null) goto L11;
        r101.I00(this.f215161c);
    L11:
        int r102 = d.f215166a;
        d.d(this.f215161c.getRoleId(), Boolean.TRUE);
        return;
    L5:
        if (this.f215161c.isPro() == true) goto L7;
        UDToast.show(BitableProAdapter.y2(this.f215162d), R.string.Bitable_AdavancedPermission_TurnOnToAddMember_Mobile, R.drawable.ud_icon_warning_outlined);
        return;
    L7:
        UDToast.show(BitableProAdapter.y2(this.f215162d), R.string.Bitable_AdvancedPermission_PremiumFeatureIncludedInRoleTip, R.drawable.ud_icon_warning_outlined);
        int r103 = d.f215166a;
        d.d(this.f215161c.getRoleId(), Boolean.FALSE);
    }

    public c(Role r100, BitableProAdapter r101) {
        this.f215161c = r100;
        this.f215162d = r101;
    }
}
