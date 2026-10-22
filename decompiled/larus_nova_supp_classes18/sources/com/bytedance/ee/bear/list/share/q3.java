package com.bytedance.ee.bear.list.share;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q3 extends zd5.a {
    @Override // zd5.f
    public final List<zd5.q> x7() {
        ArrayList r0 = new ArrayList();
        ShareFileSort r2 = ShareFileSort.MODIFIED_TIME;
        r0.add(new zd5.q(r2.getResId(), r2.getRank(), r2.getAsc(), r2.getReportSort()));
        ShareFileSort r3 = ShareFileSort.CREATE_TIME;
        r0.add(new zd5.q(r3.getResId(), r3.getRank(), r3.getAsc(), r3.getReportSort()));
        ShareFileSort r4 = ShareFileSort.SHARE_TIME;
        r0.add(new zd5.q(r4.getResId(), r4.getRank(), r4.getAsc(), r4.getReportSort()));
        return r0;
    }

    public q3(boolean r1) {
        super(r1);
    }
}
