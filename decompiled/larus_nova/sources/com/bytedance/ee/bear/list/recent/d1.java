package com.bytedance.ee.bear.list.recent;

import com.bytedance.ee.bear.list.sort.FilterType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class d1 extends zd5.a {
    @Override // zd5.f
    public final List<zd5.q> x7() {
        ArrayList r100 = new ArrayList();
        RecentSort r101 = RecentSort.MODIFIED;
        r100.add(new zd5.q(r101.getResId(), r101.getRank(), r101.getAsc(), r101.getReportSort(), Integer.valueOf(FilterType.WIKI.getResId())));
        RecentSort r102 = RecentSort.CREATED;
        r100.add(new zd5.q(r102.getResId(), r102.getRank(), r102.getAsc(), r102.getReportSort()));
        RecentSort r103 = RecentSort.OPENED;
        r100.add(new zd5.q(r103.getResId(), r103.getRank(), r103.getAsc(), r103.getReportSort()));
        return r100;
    }

    @Override // zd5.a, zd5.f
    public final List<FilterType> G6() {
        return super.G6();
    }

    public d1(boolean r100) {
        super(r100);
    }
}
