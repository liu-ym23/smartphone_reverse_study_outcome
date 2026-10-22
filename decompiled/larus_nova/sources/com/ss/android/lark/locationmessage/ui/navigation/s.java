package com.ss.android.lark.locationmessage.ui.navigation;

import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.LocationInfo;

/* JADX INFO: loaded from: classes36.dex */
public final class s extends kqb.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NavigateView f431376b;

    @Override // kqb.a
    public final void a() {
        if (this.f431376b.f431342d.isAdminGpsEnabled() == true) goto L6;
        UDToast.show(this.f431376b.f431340b, R.string.Lark_Core_AdminSettingNoGPSPermission_Toast);
        return;
    L6:
        NavigateView r100 = this.f431376b;
        Double r101 = r100.f431349k;
        if (r101 != null) goto L9;
    L21:
        r100.h(new r(this));
        return;
    L9:
        if (r100.f431350l == null) goto L21;
        r100.f431353o.l(r101.doubleValue(), this.f431376b.f431350l.doubleValue());
        NavigateView r102 = this.f431376b;
        LocationInfo r103 = r102.f431347i;
        double r104 = r102.f431349k.doubleValue();
        double r105 = this.f431376b.f431350l.doubleValue();
        boolean r106 = false;
        if (r103 != null) goto L14;
    L18:
        if (r106 == false) goto L20;
        this.f431376b.mIvLocatePosition.setImageResource(R.drawable.location_ic_locate_position_clicked);
        return;
    L20:
        this.f431376b.mIvLocatePosition.setImageResource(R.drawable.location_navigate_position_selector);
        return;
    L14:
        if (oqb.b.a(r103.getLatitude(), r104) == false) goto L18;
        if (oqb.b.a(r103.getLongitude(), r105) == false) goto L18;
        r106 = true;
        goto L18
    }

    public s(NavigateView r100) {
        this.f431376b = r100;
    }
}
