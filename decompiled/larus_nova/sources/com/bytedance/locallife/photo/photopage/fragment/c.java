package com.bytedance.locallife.photo.photopage.fragment;

import androidx.lifecycle.Observer;
import com.bytedance.ies.dmt.ui.widget.DmtStatusView;
import com.bytedance.locallife.photo.album.model.RequestStatus;
import com.bytedance.locallife.photo.photopage.view.ScrollFlexViewPager;

/* JADX INFO: loaded from: classes21.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiAlbumContainerFragment f262199a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f262200a = null;

        static {
            int[] r100 = new int[RequestStatus.values().length];
            r100[RequestStatus.FAIL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[RequestStatus.LOADING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[RequestStatus.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f262200a = r100;
        }
    }

    public c(PoiAlbumContainerFragment r100) {
        this.f262199a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        RequestStatus r101 = (RequestStatus) r100;
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 != 1) goto L9;
        DmtStatusView r103 = this.f262199a.f262166g;
        if (r103 == null) goto L21;
        r103.setVisibility(0);
        r103.f();
    L21:
        ScrollFlexViewPager r104 = this.f262199a.f262165f;
        if (r104 == null) goto L29;
        r104.setVisibility(4);
        return;
    L29:
        return;
    L9:
        if (r102 != 2) goto L27;
        DmtStatusView r105 = this.f262199a.f262166g;
        if (r105 == null) goto L14;
        r105.setVisibility(0);
        r105.g();
    L14:
        ScrollFlexViewPager r106 = this.f262199a.f262165f;
        if (r106 == null) goto L28;
        r106.setVisibility(0);
        return;
    L28:
        return;
    L27:
        return;
    L5:
        r102 = a.f262200a[r101.ordinal()];
        goto L7
    }
}
