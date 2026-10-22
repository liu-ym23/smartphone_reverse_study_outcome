package com.ss.android.lark.location_ui.picklocation;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.location.dto.POIInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes36.dex */
public final class o extends LocationView.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ POIInfo f431273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationView f431274b;

    @Override // com.ss.android.lark.location_ui.picklocation.LocationView.i, com.ss.android.lark.location_ui.picklocation.LocationView.h
    public final void a(com.ss.android.lark.location.service.k r100) {
        this.f431274b.mNearByListView.setVisibility(0);
        this.f431274b.mNearbyLoading.setVisibility(8);
        this.f431273a.setIsCurrent(true);
        iqb.a r101 = this.f431274b.f431232l;
        POIInfo r102 = this.f431273a;
        if (r102 != null) goto L6;
        r101.getClass();
    L9:
        kqb.c.a(this.f431274b.mNearByListView);
        this.f431274b.T();
        return;
    L6:
        if (r101.f495408b != null) goto L8;
        r101.f495408b = new ArrayList();
    L8:
        r101.f495408b.add(r102);
        r101.notifyDataSetChanged();
        goto L9
    }

    @Override // com.ss.android.lark.location_ui.picklocation.LocationView.h
    public final void b(List<POIInfo> r100) {
        this.f431273a.setIsCurrent(true);
        this.f431274b.mNearByListView.setVisibility(0);
        this.f431274b.mNearbyLoading.setVisibility(8);
        if (r100 != null) goto L5;
    L25:
        iqb.a r101 = this.f431274b.f431232l;
        POIInfo r102 = this.f431273a;
        if (r102 != null) goto L29;
        r101.getClass();
    L32:
        kqb.c.a(this.f431274b.mNearByListView);
        this.f431274b.T();
        return;
    L29:
        if (r101.f495408b != null) goto L31;
        r101.f495408b = new ArrayList();
    L31:
        r101.f495408b.add(r102);
        r101.notifyDataSetChanged();
        goto L32
    L5:
        if (((ArrayList) r100).size() <= 0) goto L25;
        LocationView r103 = this.f431274b;
        POIInfo r104 = this.f431273a;
        r103.getClass();
        if (r104 == null) goto L18;
        CopyOnWriteArrayList r105 = new CopyOnWriteArrayList(r100);
        Iterator r106 = r105.iterator();
    L11:
        if (r106.hasNext() == false) goto L17;
        POIInfo r107 = (POIInfo) r106.next();
        if (TextUtils.equals(r107.getLocationName(), r104.getLocationName()) == false) goto L11;
        if (TextUtils.equals(r107.getLocationAddress(), r104.getLocationAddress()) == false) goto L11;
        r105.remove(r107);
        goto L11
    L17:
        ListProtector.add(r105, 0, r104);
        r100 = r105;
    L18:
        iqb.a r108 = this.f431274b.f431232l;
        r108.getClass();
        if (CollectionUtils.isEmpty(r100) == true) goto L32;
        if (r108.f495408b != null) goto L24;
        r108.f495408b = new ArrayList();
    L24:
        r108.f495408b.addAll(r100);
        r108.notifyDataSetChanged();
        goto L32
    }

    public o(LocationView r100, POIInfo r101) {
        this.f431274b = r100;
        this.f431273a = r101;
    }
}
