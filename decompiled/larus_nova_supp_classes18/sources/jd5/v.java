package jd5;

import com.bytedance.ee.bear.list.mine.MineSort;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v extends zd5.b {
    @Override // zd5.b
    public final void create() {
    }

    @Override // zd5.b
    public final void destroy() {
    }

    public v() {
    }

    @Override // zd5.g
    public final List<zd5.q> k7(ce5.a r6) {
        ArrayList r7 = new ArrayList();
        MineSort r1 = MineSort.MODIFIED_TIME;
        zd5.q r0 = new zd5.q(r1.getResId(), r1.getRank(), r1.getAsc(), r1.getReportSort());
        r0.a = 2131889266;
        r7.add(r0);
        MineSort r2 = MineSort.CREATE_TIME;
        zd5.q r3 = new zd5.q(r2.getResId(), r2.getRank(), r2.getAsc(), r2.getReportSort());
        r3.a = 2131887983;
        r7.add(r3);
        return r7;
    }
}
