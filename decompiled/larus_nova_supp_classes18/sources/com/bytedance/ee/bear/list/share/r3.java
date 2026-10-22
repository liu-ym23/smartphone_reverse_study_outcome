package com.bytedance.ee.bear.list.share;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r3 extends zd5.b {
    @Override // zd5.b
    public final void create() {
    }

    @Override // zd5.b
    public final void destroy() {
    }

    public r3() {
    }

    @Override // zd5.g
    public final List<zd5.q> k7(ce5.a r6) {
        ArrayList r7 = new ArrayList();
        ShareFileSort r1 = ShareFileSort.MODIFIED_TIME;
        zd5.q r0 = new zd5.q(r1.getResId(), r1.getRank(), r1.getAsc(), r1.getReportSort());
        r7.add(r0);
        r0.a = 2131889266;
        ShareFileSort r2 = ShareFileSort.CREATE_TIME;
        zd5.q r3 = new zd5.q(r2.getResId(), r2.getRank(), r2.getAsc(), r2.getReportSort());
        r3.a = 2131887983;
        r7.add(r3);
        ShareFileSort r4 = ShareFileSort.SHARE_TIME;
        zd5.q r5 = new zd5.q(r4.getResId(), r4.getRank(), r4.getAsc(), r4.getReportSort());
        r7.add(r5);
        r5.a = 2131889637;
        return r7;
    }
}
