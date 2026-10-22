package com.bytedance.ee.bear.list.recent;

import com.bytedance.ee.bear.list.sort.FilterType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e1 extends zd5.b {
    public e1() {
    }

    @Override // zd5.g
    public final List<zd5.q> k7(ce5.a r210) {
        Intrinsics.checkNotNullParameter(r210, "userComponentAbility");
        ArrayList r100 = new ArrayList();
        RecentSort r101 = RecentSort.MODIFIED;
        r100.add(new zd5.q(r101.getResId(), r101.getRank(), r101.getAsc(), r101.getReportSort(), Integer.valueOf(FilterType.WIKI.getResId()), null, 32));
        RecentSort r102 = RecentSort.CREATED;
        r100.add(new zd5.q(r102.getResId(), r102.getRank(), r102.getAsc(), r102.getReportSort(), null, null, 48));
        RecentSort r103 = RecentSort.OPENED;
        r100.add(new zd5.q(r103.getResId(), r103.getRank(), r103.getAsc(), r103.getReportSort(), null, null, 48));
        return r100;
    }
}
