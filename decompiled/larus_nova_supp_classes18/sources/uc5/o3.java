package uc5;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.sort.FilterType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o3 extends g {
    @Override // mc5.k
    public final FolderSortStrategy getFilter() {
        tt5.a.h("PersonalRootListCache", "getFilter()...");
        FolderSortStrategy r0 = ((mc5.j) this.a.a(mc5.j.class)).m1("root");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new FolderSortStrategy("root", FilterType.ALL.getType(), "", "", FolderSort.NAME.getRank(), true);
    }

    public o3(ce5.a r2) {
        super("", r2);
    }
}
