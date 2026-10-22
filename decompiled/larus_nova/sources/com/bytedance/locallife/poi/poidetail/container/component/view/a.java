package com.bytedance.locallife.poi.poidetail.container.component.view;

import android.view.View;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.locallife.model.poi.resp.PoiDetail;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiExpCollectShareLayout f263787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PoiBundle f263788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PoiDetail f263789c;

    public a(PoiExpCollectShareLayout r100, PoiBundle r101, PoiDetail r102) {
        this.f263787a = r100;
        this.f263788b = r101;
        this.f263789c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PoiExpCollectShareLayout r101 = this.f263787a;
        int r102 = PoiExpCollectShareLayout.f263770p;
        r101.getClass();
        r101.post(new c(r101));
        int r103 = com.bytedance.locallife.biz.mob.a.f256703c;
        mq6.c r104 = new mq6.c();
        mq6.a r105 = mq6.c.a.f514894a;
        r104.g("enter_from", "poi_page");
        PoiBundle r106 = this.f263788b;
        String r107 = null;
        if (r106 == null) goto L5;
        String r108 = r106.from;
    L6:
        r104.g("poi_enter_page", r108);
        PoiBundle r109 = this.f263788b;
        if (r109 == null) goto L9;
        String r110 = r109.enterMethod;
    L10:
        r104.g(BdpAppEventConstant.PARAMS_POI_ENTER_METHOD, r110);
        PoiBundle r111 = this.f263788b;
        if (r111 == null) goto L13;
        String r112 = r111.sessionId;
    L14:
        r104.g("poi_enter_id", r112);
        PoiDetail r113 = this.f263789c;
        if (r113 == null) goto L17;
        String r114 = r113.getBackendType();
    L18:
        r104.g("poi_backend_type", r114);
        PoiDetail r115 = this.f263789c;
        if (r115 == null) goto L21;
        r107 = r115.getPoiId();
    L21:
        r104.g("poi_id", r107);
        r104.g(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "share_type");
        com.bytedance.locallife.biz.mob.a.C3646a.c("close_poi_bar", r104.f514893a);
        return;
    L17:
        r114 = null;
        goto L18
    L13:
        r112 = null;
        goto L14
    L9:
        r110 = null;
        goto L10
    L5:
        r108 = null;
        goto L6
    }
}
