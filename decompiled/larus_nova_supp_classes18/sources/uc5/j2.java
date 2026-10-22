package uc5;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.util.info.AppInfoUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class j2 extends g {
    @Override // mc5.k
    public FolderSortStrategy getFilter() {
        tt5.a.h("MyRootFolderListCache", "getFilter()...");
        FolderSortStrategy r0 = ((mc5.j) this.a.a(mc5.j.class)).m1("my_root");
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (AppInfoUtils.f().booleanValue() == false) goto L9;
        int r3 = FilterType.ALL.getType();
        FolderSort r1 = FolderSort.MODIFIED_TIME;
        return new FolderSortStrategy("my_root", r3, "", "", r1.getRank(), r1.getAsc());
    L9:
        return new FolderSortStrategy("my_root", FilterType.ALL.getType(), "", "", FolderSort.NAME.getRank(), true);
    }

    public j2(ce5.a r2) {
        super("", r2);
    }
}
