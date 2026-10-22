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

/* JADX INFO: loaded from: classes18.dex */
public final class w extends zd5.a {
    @Override // zd5.a, zd5.f
    public final List<FilterType> G6() {
        ArrayList r100 = new ArrayList();
        r100.add(FilterType.ALL);
        r100.add(FilterType.DOC);
        ManualOfflineConfig r101 = ManualOfflineConfig.getConfig();
        if (r101.isSheet_enabled() == false) goto L5;
        r100.add(FilterType.SHEET);
    L5:
        w4 r102 = w4.a();
        int r103 = sbb.e.f541298i.f541317b;
        Set<Integer> r104 = r102.f229842a;
        HashSet r105 = (HashSet) r104;
        if (r105.contains(Integer.valueOf(r103)) == false) goto L11;
        if (r101.isBitable_enabled() == false) goto L11;
        r100.add(FilterType.BITABLE);
    L11:
        if (t0.s() == false) goto L16;
        if (r101.isMindnote_enabled() == false) goto L16;
        r100.add(FilterType.MINDNOTE);
    L16:
        if (r101.isDrive_enabled() == false) goto L18;
        r100.add(FilterType.FILE);
    L18:
        return r100;
    }

    @Override // zd5.f
    public final List<zd5.q> x7() {
        ArrayList r100 = new ArrayList();
        ManualOfflineSort r101 = ManualOfflineSort.DEFAULT;
        r100.add(new zd5.q(r101.getResId(), r101.getRank(), r101.getAsc(), r101.getReportSort()));
        ManualOfflineSort r102 = ManualOfflineSort.MODIFIED;
        r100.add(new zd5.q(r102.getResId(), r102.getRank(), r102.getAsc(), r102.getReportSort()));
        ManualOfflineSort r103 = ManualOfflineSort.CREATED;
        r100.add(new zd5.q(r103.getResId(), r103.getRank(), r103.getAsc(), r103.getReportSort()));
        return r100;
    }

    public w(boolean r100) {
        super(r100);
    }
}
