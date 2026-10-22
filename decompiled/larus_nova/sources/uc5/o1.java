package uc5;

import com.bytedance.ee.bear.list.folder.FolderSort;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class o1 extends zd5.a {
    @Override // zd5.f
    public final List<zd5.q> x7() {
        ArrayList r100 = new ArrayList();
        r100.add(FolderSort.NAME.convertSortType());
        r100.add(FolderSort.MODIFIED_TIME.convertSortType());
        r100.add(FolderSort.CREATED_TIME.convertSortType());
        return r100;
    }

    public o1(boolean r100) {
        super(r100);
    }
}
