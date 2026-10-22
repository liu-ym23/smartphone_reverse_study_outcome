package com.ss.android.lark.location_ui.picklocation;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements com.ss.android.lark.location.service.h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationView.f f431265a;

    public h(LocationView.a r100) {
        this.f431265a = r100;
    }

    @Override // com.ss.android.lark.location.service.h.a
    public final void a(POIInfo r100) {
        LocationView.a r101 = (LocationView.a) this.f431265a;
        r101.getClass();
        Log.i("LocationView", "onRegeocodeSearched called.");
        LocationView r102 = r101.f431245a;
        r102.f431237q = true;
        r102.mNearByListView.setVisibility(0);
        r101.f431245a.mNearbyLoading.setVisibility(8);
        if (r100 != null) goto L5;
        r101.f431245a.mSearchBar.setEditTextEnabled(true);
        return;
    L5:
        iqb.a r103 = r101.f431245a.f431232l;
        if (r103.f495408b != null) goto L9;
        r103.f495408b = new ArrayList();
    L9:
        if (r103.f495408b.size() < 0) goto L12;
        ListProtector.add(r103.f495408b, 0, r100);
        r103.notifyDataSetChanged();
    L12:
        LocationView.h(r101.f431245a, 0);
        r101.f431245a.mSearchBar.setEditTextEnabled(true);
    }
}
