package uc5;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.sort.FilterType;

/* JADX INFO: loaded from: classes18.dex */
public final class p3 extends g {
    @Override // mc5.k
    public final FolderSortStrategy getFilter() {
        tt5.a.h("PersonalSubListCache", "getFilter()...");
        FolderSortStrategy r100 = ((mc5.j) this.f512885a.a(mc5.j.class)).m1(this.f549500b);
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new FolderSortStrategy(this.f549500b, FilterType.ALL.getType(), "", "", FolderSort.NAME.getRank(), true);
    }

    public p3(String r100, ce5.a r101) {
        super(r100, r101);
    }
}
