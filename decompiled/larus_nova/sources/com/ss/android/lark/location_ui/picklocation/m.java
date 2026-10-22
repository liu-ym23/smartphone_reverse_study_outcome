package com.ss.android.lark.location_ui.picklocation;

import androidx.appcompat.content.res.AppCompatResources;
import com.larus.nova.R;
import com.ss.android.lark.location.service.IPickLocationMap;

/* JADX INFO: loaded from: classes36.dex */
public final class m implements IPickLocationMap.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationView f431271a;

    public final void a() {
        LocationView r100 = this.f431271a;
        r100.f431223c = true;
        r100.mIvLocatePosition.setImageDrawable(AppCompatResources.getDrawable(r100.f431222b, R.drawable.location_navigate_position_selector));
    }

    public m(LocationView r100) {
        this.f431271a = r100;
    }
}
