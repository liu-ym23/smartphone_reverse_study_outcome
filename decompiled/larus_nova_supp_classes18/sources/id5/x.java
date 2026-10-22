package id5;

import com.bytedance.ee.bear.list.manualoffline.ManualOfflineSort;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x extends zd5.b {
    @Override // zd5.b
    public final void create() {
    }

    @Override // zd5.b
    public final void destroy() {
    }

    public x() {
    }

    @Override // zd5.g
    public final List<zd5.q> k7(ce5.a r6) {
        ArrayList r7 = new ArrayList();
        ManualOfflineSort r1 = ManualOfflineSort.MODIFIED;
        r7.add(new zd5.q(2131889266, r1.getRank(), r1.getAsc(), r1.getReportSort()));
        ManualOfflineSort r2 = ManualOfflineSort.CREATED;
        r7.add(new zd5.q(2131887983, r2.getRank(), r2.getAsc(), r2.getReportSort()));
        ManualOfflineSort r3 = ManualOfflineSort.DEFAULT;
        r7.add(new zd5.q(2131889634, r3.getRank(), r3.getAsc(), r3.getReportSort()));
        return r7;
    }
}
