package com.ss.android.lark.location_ui.picklocation;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.ui.CommonTitleBarConstants;

/* JADX INFO: loaded from: classes36.dex */
public final class k implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationView f431268a;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f431269a;

        public a(k r100) {
            this.f431269a = r100;
        }

        public final void a(POIInfo r100) {
            if (TextUtils.isEmpty(r100.getLocationName()) == true) goto L10;
            LocationView.k(this.f431269a.f431268a, r100, !r100.getIsSelfDefine());
            LocationView r101 = this.f431269a.f431268a;
            r101.T();
            r101.mNearByListView.setVisibility(8);
            r101.mNearbyLoading.b();
            iqb.a r102 = r101.f431232l;
            if (CollectionUtils.isEmpty(r102.f495408b) == true) goto L8;
            r102.f495408b.clear();
            r102.notifyDataSetChanged();
        L8:
            r101.f431231k.w6(r101.f431222b, r101.f431225e, new o(r101, r100), 0);
            return;
        }
    }

    public k(LocationView r100) {
        this.f431268a = r100;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r100, View r101, int r102, long r103) {
        kqb.e.b("search");
        KeyboardUtils.hideKeyboard(this.f431268a.f431222b);
        LocationView r104 = this.f431268a;
        r104.f431226f = false;
        r104.mRecommendListView.setVisibility(8);
        this.f431268a.mContentLayout.setVisibility(0);
        this.f431268a.mTitleBar.setRightVisible(true);
        this.f431268a.mTitleBar.setLeftTextOnly(CommonTitleBarConstants.TEXT_CANCEL);
        this.f431268a.P("");
        POIInfo r105 = this.f431268a.f431233m.a(r102);
        if (r105 != null) goto L5;
        return;
    L5:
        LocationView r106 = this.f431268a;
        r106.f431231k.q(r106.f431222b, r105, new a(this));
        Statistics.sendEvent("message_location__sugg_click");
    }
}
