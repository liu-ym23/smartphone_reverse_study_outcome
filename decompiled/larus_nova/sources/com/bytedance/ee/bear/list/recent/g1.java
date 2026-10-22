package com.bytedance.ee.bear.list.recent;

import com.bytedance.ee.bear.list.sort.FilterType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g1 extends zd5.b {
    public g1() {
    }

    @Override // zd5.g
    public final List<zd5.q> k7(ce5.a r110) {
        Intrinsics.checkNotNullParameter(r110, "userComponentAbility");
        ArrayList r111 = new ArrayList();
        RecentSort r100 = RecentSort.MODIFIED;
        r111.add(new zd5.q(r100.getResId(), r100.getRank(), r100.getAsc(), r100.getReportSort(), Integer.valueOf(FilterType.WIKI.getResId()), null, 32));
        return r111;
    }
}
