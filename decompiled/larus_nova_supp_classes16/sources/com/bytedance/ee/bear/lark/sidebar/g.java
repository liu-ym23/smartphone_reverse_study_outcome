package com.bytedance.ee.bear.lark.sidebar;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.manualoffline.ManualOfflineSort;
import com.bytedance.ee.bear.list.recent.RecentSort;
import com.bytedance.ee.bear.list.sort.FilterType;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ SidebarDocTabFragment a;

    public g(SidebarDocTabFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r18) {
        Boolean r1 = (Boolean) r18;
        tt5.a.h("SidebarDocTabFragment", "triggerResetData ");
        SidebarDocTabFragment r2 = this.a;
        int r3 = SidebarDocTabFragment.Y;
        if (r2.y != 2) goto L5;
        FolderSortStrategy r4 = new FolderSortStrategy("manual_offline", FilterType.ALL.getType(), "", "", ManualOfflineSort.DEFAULT.getRank(), false);
    L6:
        SidebarDocTabFragment r5 = this.a;
        r5.Q = Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new e(this.a, r4), f.a);
        return;
    L5:
        r4 = new FolderSortStrategy("recent", FilterType.ALL.getType(), "", "", RecentSort.OPENED.getRank(), false);
        goto L6
    }
}
