package sc5;

import com.bytedance.ee.bear.list.drive.HomeDriveFragment;
import com.bytedance.ee.bear.list.homepage.tab.HomeViewPager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements xc5.b.InterfaceC0330b {
    public final /* synthetic */ HomeDriveFragment a;

    public b(HomeDriveFragment r1) {
        this.a = r1;
    }

    @Override // xc5.b.InterfaceC0330b
    public final void a(int r3) {
        tt5.a.h("HomeDriveFragmentV2", "onTabSelected()...index = " + r3);
        HomeDriveFragment r0 = this.a;
        if (r0.o != r3) goto L5;
        return;
    L5:
        HomeViewPager r1 = r0.n;
        if (r1 == null) goto L8;
        r1.setCurrentItem(r3, false);
    L8:
        HomeDriveFragment r2 = this.a;
        r2.o = r3;
        r2.da0(r3);
    }
}
