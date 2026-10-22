package jd5;

import com.bytedance.ee.bear.list.mine.MineSort;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class u extends zd5.a {
    @Override // zd5.f
    public final List<zd5.q> x7() {
        ArrayList r100 = new ArrayList();
        MineSort r101 = MineSort.MODIFIED_TIME;
        r100.add(new zd5.q(r101.getResId(), r101.getRank(), r101.getAsc(), r101.getReportSort()));
        MineSort r102 = MineSort.CREATE_TIME;
        r100.add(new zd5.q(r102.getResId(), r102.getRank(), r102.getAsc(), r102.getReportSort()));
        return r100;
    }

    public u(boolean r100) {
        super(r100);
    }
}
