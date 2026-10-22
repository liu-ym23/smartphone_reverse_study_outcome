package com.ss.android.lark.location_ui.picklocation;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.content.res.AppCompatResources;
import com.larus.nova.R;
import com.ss.android.lark.location.dto.POIInfo;

/* JADX INFO: loaded from: classes36.dex */
public final class t implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationView f431280a;

    public t(LocationView r100) {
        this.f431280a = r100;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r100, View r101, int r102, long r103) {
        kqb.e.b("list");
        POIInfo r104 = this.f431280a.f431232l.a(r102);
        if (r104 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r104.getLocationName()) == true) goto L9;
        LocationView r105 = this.f431280a;
        r105.mIvLocatePosition.setImageDrawable(AppCompatResources.getDrawable(r105.f431222b, R.drawable.location_navigate_position_selector));
        LocationView.k(this.f431280a, r104, !r104.getIsSelfDefine());
        LocationView.h(this.f431280a, r102);
        return;
    }
}
