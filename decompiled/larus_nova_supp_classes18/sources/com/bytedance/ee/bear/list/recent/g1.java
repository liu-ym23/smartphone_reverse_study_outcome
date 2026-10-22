package com.bytedance.ee.bear.list.recent;

import com.bytedance.ee.bear.list.sort.FilterType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g1 extends zd5.b {
    public g1() {
    }

    @Override // zd5.g
    public final List<zd5.q> k7(ce5.a r10) {
        Intrinsics.checkNotNullParameter(r10, "userComponentAbility");
        ArrayList r11 = new ArrayList();
        RecentSort r0 = RecentSort.MODIFIED;
        r11.add(new zd5.q(r0.getResId(), r0.getRank(), r0.getAsc(), r0.getReportSort(), Integer.valueOf(FilterType.WIKI.getResId()), null, 32));
        return r11;
    }
}
