package jd5;

import com.bytedance.ee.bear.list.mine.MineSort;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u extends zd5.a {
    @Override // zd5.f
    public final List<zd5.q> x7() {
        ArrayList r0 = new ArrayList();
        MineSort r2 = MineSort.MODIFIED_TIME;
        r0.add(new zd5.q(r2.getResId(), r2.getRank(), r2.getAsc(), r2.getReportSort()));
        MineSort r3 = MineSort.CREATE_TIME;
        r0.add(new zd5.q(r3.getResId(), r3.getRank(), r3.getAsc(), r3.getReportSort()));
        return r0;
    }

    public u(boolean r1) {
        super(r1);
    }
}
