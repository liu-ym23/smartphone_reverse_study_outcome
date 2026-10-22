package sc5;

import com.bytedance.ee.bear.list.drive.HomeDriveFragment;
import com.bytedance.ee.bear.list.homepage.tab.HomeViewPager;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements xc5.b.InterfaceC8214b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HomeDriveFragment f541346a;

    public b(HomeDriveFragment r100) {
        this.f541346a = r100;
    }

    @Override // xc5.b.InterfaceC8214b
    public final void a(int r100) {
        tt5.a.h("HomeDriveFragmentV2", "onTabSelected()...index = " + r100);
        HomeDriveFragment r101 = this.f541346a;
        if (r101.f227865o != r100) goto L5;
        return;
    L5:
        HomeViewPager r102 = r101.f227864n;
        if (r102 == null) goto L8;
        r102.setCurrentItem(r100, false);
    L8:
        HomeDriveFragment r103 = this.f541346a;
        r103.f227865o = r100;
        r103.da0(r100);
    }
}
