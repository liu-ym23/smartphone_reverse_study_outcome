package com.bytedance.locallife.poi.poidetail.container.component.view.dcd;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.locallife.model.poi.resp.PoiProduct;
import com.bytedance.locallife.model.poi.resp.PoiSpu;
import com.bytedance.locallife.poi.poidetail.container.mob.PoiMobHelper;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiProduct f263820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PoiExpDcdProductViewHolder f263821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PoiBundle f263822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f263823d;

    public b(PoiProduct r100, PoiExpDcdProductViewHolder r101, PoiBundle r102, String r103) {
        this.f263820a = r100;
        this.f263821b = r101;
        this.f263822c = r102;
        this.f263823d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PoiSpu r101 = this.f263820a.detailInfo;
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101.getUrl()) == true) goto L36;
        int r102 = a.f263819a;
        Context r103 = this.f263821b.itemView.getContext();
        PoiSpu r104 = this.f263820a.detailInfo;
        String r105 = null;
        if (r104 == null) goto L10;
        String r106 = r104.getUrl();
    L11:
        a.a(r103, r106);
        mq6.c r107 = new mq6.c();
        mq6.a r108 = mq6.c.a.f514894a;
        r107.g("enter_from", "poi_page");
        PoiBundle r109 = this.f263822c;
        if (r109 == null) goto L14;
        String r110 = r109.previousEnterFrom;
    L15:
        r107.g("previous_enter_from", r110);
        r107.g("product_id", this.f263820a.extId);
        PoiBundle r111 = this.f263822c;
        if (r111 == null) goto L18;
        String r112 = r111.poiId;
    L19:
        r107.g("poi_id", r112);
        PoiBundle r113 = this.f263822c;
        if (r113 == null) goto L22;
        String r114 = r113.enterId;
    L23:
        r107.g("poi_enter_id", r114);
        r107.g("content_type", this.f263823d);
        PoiBundle r115 = this.f263822c;
        if (r115 == null) goto L26;
        r105 = r115.awemeid;
    L26:
        r107.g("video_id", r105);
        PoiExpDcdProductViewHolder r116 = this.f263821b;
        PoiProduct r117 = this.f263820a;
        int r118 = PoiExpDcdProductViewHolder.f263799a;
        r116.getClass();
        int r119 = r117.houseType;
        if (r119 != 1) goto L29;
        r107.d("house_type", "new");
    L33:
        PoiMobHelper.c(this.f263822c, "project_click_card", r107);
        return;
    L29:
        if (r119 != 2) goto L33;
        r107.d("house_type", "old");
        goto L33
    L22:
        r114 = null;
        goto L23
    L18:
        r112 = null;
        goto L19
    L14:
        r110 = null;
        goto L15
    L10:
        r106 = null;
        goto L11
    }
}
