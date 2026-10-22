package id5;

import com.bytedance.ee.bear.list.manualoffline.ManualOfflineSort;
import com.bytedance.ee.bear.list.offlinecache.ManualOfflineConfig;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.w4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w extends zd5.a {
    @Override // zd5.a, zd5.f
    public final List<FilterType> G6() {
        ArrayList r0 = new ArrayList();
        r0.add(FilterType.ALL);
        r0.add(FilterType.DOC);
        ManualOfflineConfig r1 = ManualOfflineConfig.getConfig();
        if (r1.isSheet_enabled() == false) goto L5;
        r0.add(FilterType.SHEET);
    L5:
        w4 r2 = w4.a();
        int r3 = sbb.e.i.b;
        Set<Integer> r4 = r2.a;
        HashSet r5 = (HashSet) r4;
        if (r5.contains(Integer.valueOf(r3)) == false) goto L11;
        if (r1.isBitable_enabled() == false) goto L11;
        r0.add(FilterType.BITABLE);
    L11:
        if (t0.s() == false) goto L16;
        if (r1.isMindnote_enabled() == false) goto L16;
        r0.add(FilterType.MINDNOTE);
    L16:
        if (r1.isDrive_enabled() == false) goto L18;
        r0.add(FilterType.FILE);
    L18:
        return r0;
    }

    @Override // zd5.f
    public final List<zd5.q> x7() {
        ArrayList r0 = new ArrayList();
        ManualOfflineSort r2 = ManualOfflineSort.DEFAULT;
        r0.add(new zd5.q(r2.getResId(), r2.getRank(), r2.getAsc(), r2.getReportSort()));
        ManualOfflineSort r3 = ManualOfflineSort.MODIFIED;
        r0.add(new zd5.q(r3.getResId(), r3.getRank(), r3.getAsc(), r3.getReportSort()));
        ManualOfflineSort r4 = ManualOfflineSort.CREATED;
        r0.add(new zd5.q(r4.getResId(), r4.getRank(), r4.getAsc(), r4.getReportSort()));
        return r0;
    }

    public w(boolean r1) {
        super(r1);
    }
}
