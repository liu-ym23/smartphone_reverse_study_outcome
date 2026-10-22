package uc5;

import com.bytedance.ee.bear.list.folder.FolderSort;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o1 extends zd5.a {
    @Override // zd5.f
    public final List<zd5.q> x7() {
        ArrayList r0 = new ArrayList();
        r0.add(FolderSort.NAME.convertSortType());
        r0.add(FolderSort.MODIFIED_TIME.convertSortType());
        r0.add(FolderSort.CREATED_TIME.convertSortType());
        return r0;
    }

    public o1(boolean r1) {
        super(r1);
    }
}
