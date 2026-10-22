package yd5;

import ad5.e;
import ad5.f;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabEnum;
import com.bytedance.ee.bear.list.manualoffline.ManualOfflineDocumentFragment;
import com.bytedance.ee.bear.list.recent.RecentDocumentFragment;
import com.bytedance.ee.bear.list.sidebar.SidebarHomeTreeFragment;
import gc5.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements f {
    public b() {
    }

    @Override // ad5.f
    public final List<e> a(boolean r5) {
        ArrayList r0 = new ArrayList();
        if (r5 == true) goto L5;
        r0.add(new e(HomeTabEnum.RECENT.id, 2131887956, RecentDocumentFragment.class.getName()));
    L5:
        r0.add(new e(HomeTabEnum.SIDEBAR_TREE_VIEW.id, 2131889642, SidebarHomeTreeFragment.class.getName()));
        int r6 = t.a;
        if (qc5.a.a() == false) goto L8;
        r0.add(new e(HomeTabEnum.OFFLINE.id, 2131887949, ManualOfflineDocumentFragment.class.getName()));
    L8:
        return r0;
    }
}
