package com.bytedance.ee.bear.list.recent;

import com.bytedance.ee.bear.list.sort.FilterType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e1 extends zd5.b {
    public e1() {
    }

    @Override // zd5.g
    public final List<zd5.q> k7(ce5.a r25) {
        Intrinsics.checkNotNullParameter(r25, "userComponentAbility");
        ArrayList r0 = new ArrayList();
        RecentSort r1 = RecentSort.MODIFIED;
        r0.add(new zd5.q(r1.getResId(), r1.getRank(), r1.getAsc(), r1.getReportSort(), Integer.valueOf(FilterType.WIKI.getResId()), null, 32));
        RecentSort r2 = RecentSort.CREATED;
        r0.add(new zd5.q(r2.getResId(), r2.getRank(), r2.getAsc(), r2.getReportSort(), null, null, 48));
        RecentSort r3 = RecentSort.OPENED;
        r0.add(new zd5.q(r3.getResId(), r3.getRank(), r3.getAsc(), r3.getReportSort(), null, null, 48));
        return r0;
    }
}
