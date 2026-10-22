package vz7;

import android.view.View;
import com.larksuite.component.ui.imageview.LKUIBadgeDrawable2;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements b08.b<View, b> {
    public a() {
    }

    @Override // b08.b
    public final void unbind(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        int r101 = LKUIBadgeDrawable2.f284145i;
        Intrinsics.checkNotNullParameter(r100, "view");
        LKUIBadgeDrawable2.a.a(r100, 0).setVisible(false, false);
    }

    @Override // b08.b
    public final void bind(View r100, b r101) {
        b r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        int r103 = LKUIBadgeDrawable2.f284145i;
        Intrinsics.checkNotNullParameter(r100, "view");
        LKUIBadgeDrawable2.b r104 = LKUIBadgeDrawable2.a.a(r100, 0).c();
        r104.f284163j = r102.f557741g;
        r104.f284162i = r102.f557740f;
        r104.f284164k = r102.f557742h;
        r104.f284160g = null;
        r104.f284161h = 0.0f;
        r104.f284155b = r102.f557735a;
        r104.f284159f = r102.f557739e;
        r104.f284156c = r102.f557736b;
        r104.f284158e = r102.f557738d;
        r104.f284157d = r102.f557737c;
        boolean r105 = r102.f557743i;
        r104.f284165l.setVisible(r105, false);
        r104.a();
    }
}
