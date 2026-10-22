package uc5;

import com.bytedance.ee.bear.list.folder.FolderSort;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x4 extends zd5.b {
    @Override // zd5.b
    public final void create() {
    }

    @Override // zd5.b
    public final void destroy() {
    }

    public x4() {
    }

    @Override // zd5.g
    public final List<zd5.q> k7(ce5.a r3) {
        ArrayList r4 = new ArrayList();
        zd5.q r0 = FolderSort.NAME.convertSortType();
        r0.a = 2131887985;
        r4.add(r0);
        zd5.q r1 = FolderSort.MODIFIED_TIME.convertSortType();
        r1.a = 2131889266;
        r4.add(r1);
        zd5.q r2 = FolderSort.CREATED_TIME.convertSortType();
        r2.a = 2131887983;
        r4.add(r2);
        return r4;
    }
}
