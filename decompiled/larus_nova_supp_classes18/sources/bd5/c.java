package bd5;

import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.bear.list.homepage.title.SubMenuViewPad;
import com.bytedance.ee.bear.list.recent.RecentSort;
import com.bytedance.ee.bear.list.sort.FilterType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ com.bytedance.ee.bear.list.homepage.title.a a;

    public c(com.bytedance.ee.bear.lark.space.m r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        FolderSortStrategy r6 = (FolderSortStrategy) r5;
        if (r6 != null) goto L6;
        return;
    L6:
        if (TextUtils.equals("recent", r6.a) == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r6, this.a.a) == true) goto L30;
        com.bytedance.ee.bear.list.homepage.title.a r0 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "sortStrategy");
        tt5.a.h(r0.c().getClass().getName(), "onFilterChanged()...");
        r0.a = r6;
        SubMenuViewPad r1 = r0.f();
        if (r6.getType() != FilterType.ALL.getType()) goto L14;
        SubMenuView.FilterState r2 = SubMenuView.FilterState.DEFAULT;
    L15:
        r1.setFilterState(r2);
        SubMenuViewPad r3 = r0.f();
        RecentSort.a r4 = RecentSort.Companion;
        int r7 = r6.e;
        r4.getClass();
        RecentSort r8 = RecentSort.MODIFIED;
        if (r7 == r8.getRank()) goto L23;
        r8 = RecentSort.CREATED;
        if (r7 == r8.getRank()) goto L23;
        r8 = RecentSort.OPENED;
    L23:
        if (r8.getSortPos() == r0.a()) goto L25;
        boolean r9 = true;
    L26:
        r3.setSelectedSortState(r9);
        return;
    L25:
        r9 = false;
        goto L26
    L14:
        r2 = SubMenuView.FilterState.CHECKED;
        goto L15
    }
}
