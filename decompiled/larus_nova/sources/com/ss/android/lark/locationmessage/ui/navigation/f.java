package com.ss.android.lark.locationmessage.ui.navigation;

import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.LocationInfo;
import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.statistics.Statistics;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements com.ss.android.lark.location.service.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NavigateView.a f431362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f431363b;

    @Override // com.ss.android.lark.location.service.g.a
    public final void a(LarkLocation r110) {
        if (r110 != null) goto L4;
    L24:
        ((u) this.f431362a).getClass();
        if (lqb.b.f510384a.isGooglePlay() == false) goto L31;
        Statistics.sendEvent("lark_message_location_google_poi_no_response");
        return;
    L31:
        return;
    L4:
        if (r110.f431181g != 0) goto L24;
        g r100 = this.f431363b;
        r100.f431365a = new cqb.a(r110.getLatitude(), r110.getLongitude());
        NavigateView.a r111 = this.f431362a;
        cqb.a r101 = this.f431363b.f431365a;
        double r102 = r101.f465027a;
        double r103 = r101.f465028b;
        u r112 = (u) r111;
        NavigateView r104 = r112.f431379b;
        r104.f431349k = Double.valueOf(r102);
        NavigateView r105 = r112.f431379b;
        r105.f431350l = Double.valueOf(r103);
        NavigateView r106 = r112.f431379b;
        r106.f431353o.a(r106.f431349k.doubleValue(), r112.f431379b.f431350l.doubleValue());
        if (r112.f431378a == false) goto L8;
        NavigateView r107 = r112.f431379b;
        r107.f431353o.l(r107.f431349k.doubleValue(), r112.f431379b.f431350l.doubleValue());
    L8:
        NavigateView r108 = r112.f431379b;
        LocationInfo r109 = r108.f431347i;
        double r113 = r108.f431349k.doubleValue();
        double r114 = r112.f431379b.f431350l.doubleValue();
        boolean r115 = false;
        if (r109 != null) goto L12;
    L16:
        if (r115 == false) goto L18;
        r112.f431379b.mIvLocatePosition.setImageResource(R.drawable.location_ic_locate_position_clicked);
    L20:
        if (lqb.b.f510384a.isGooglePlay() == false) goto L22;
        return;
    L22:
        if (com.ss.android.lark.location.service.f.a().isInHouse(r102, r103) == true) goto L29;
        Statistics.sendEvent("feishu_message_location_outside_mainlandchina");
        return;
    L29:
        return;
    L18:
        r112.f431379b.mIvLocatePosition.setImageResource(R.drawable.location_navigate_position_selector);
        goto L20
    L12:
        if (oqb.b.a(r109.getLatitude(), r113) == false) goto L16;
        if (oqb.b.a(r109.getLongitude(), r114) == false) goto L16;
        r115 = true;
        goto L16
    }

    public f(g r100, u r101) {
        this.f431363b = r100;
        this.f431362a = r101;
    }
}
