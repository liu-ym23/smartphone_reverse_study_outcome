package com.bytedance.locallife.pdp.album;

import androidx.lifecycle.Observer;
import com.bytedance.ies.dmt.ui.widget.DmtStatusView;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;

/* JADX INFO: loaded from: classes21.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomAlbumActivity f260967a;

    public f(CustomAlbumActivity r100) {
        this.f260967a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        CustomAlbumViewModel.RequestStatus r101 = (CustomAlbumViewModel.RequestStatus) r100;
        if (r101 != CustomAlbumViewModel.RequestStatus.FAIL) goto L12;
        DmtStatusView r102 = this.f260967a.f260938i;
        if (r102 == null) goto L8;
        r102.setVisibility(0);
    L8:
        DmtStatusView r103 = this.f260967a.f260938i;
        if (r103 == null) goto L27;
        r103.f();
        return;
    L27:
        return;
    L12:
        if (r101 != CustomAlbumViewModel.RequestStatus.LOADING) goto L21;
        DmtStatusView r104 = this.f260967a.f260938i;
        if (r104 == null) goto L17;
        r104.setVisibility(0);
    L17:
        DmtStatusView r105 = this.f260967a.f260938i;
        if (r105 == null) goto L29;
        r105.g();
        return;
    L29:
        return;
    L21:
        if (r101 != CustomAlbumViewModel.RequestStatus.SUCCESS) goto L31;
        DmtStatusView r106 = this.f260967a.f260938i;
        if (r106 == null) goto L32;
        r106.setVisibility(8);
        return;
    L32:
        return;
    }
}
