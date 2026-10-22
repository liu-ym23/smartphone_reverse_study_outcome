package iqb;

import android.graphics.Bitmap;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.service.IPickLocationMap;
import com.ss.android.lark.location_ui.picklocation.LocationView;
import com.ss.android.lark.location_ui.picklocation.q;

/* JADX INFO: loaded from: classes36.dex */
public final class n implements IPickLocationMap.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ POIInfo f495423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationView f495424b;

    @Override // com.ss.android.lark.location.service.IPickLocationMap.c
    public final void onMapScreenShot(Bitmap r100) {
        LocationView r101 = this.f495424b;
        POIInfo r102 = this.f495423a;
        String[] r103 = LocationView.f431220y;
        r101.f431231k.J3(r101.f431222b, r100, new q(r101, r102));
    }

    public n(LocationView r100, POIInfo r101) {
        this.f495424b = r100;
        this.f495423a = r101;
    }
}
