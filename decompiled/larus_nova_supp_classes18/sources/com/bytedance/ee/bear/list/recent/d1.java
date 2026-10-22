package com.bytedance.ee.bear.list.recent;

import com.bytedance.ee.bear.list.sort.FilterType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d1 extends zd5.a {
    @Override // zd5.f
    public final List<zd5.q> x7() {
        ArrayList r0 = new ArrayList();
        RecentSort r1 = RecentSort.MODIFIED;
        r0.add(new zd5.q(r1.getResId(), r1.getRank(), r1.getAsc(), r1.getReportSort(), Integer.valueOf(FilterType.WIKI.getResId())));
        RecentSort r2 = RecentSort.CREATED;
        r0.add(new zd5.q(r2.getResId(), r2.getRank(), r2.getAsc(), r2.getReportSort()));
        RecentSort r3 = RecentSort.OPENED;
        r0.add(new zd5.q(r3.getResId(), r3.getRank(), r3.getAsc(), r3.getReportSort()));
        return r0;
    }

    @Override // zd5.a, zd5.f
    public final List<FilterType> G6() {
        return super.G6();
    }

    public d1(boolean r1) {
        super(r1);
    }
}
