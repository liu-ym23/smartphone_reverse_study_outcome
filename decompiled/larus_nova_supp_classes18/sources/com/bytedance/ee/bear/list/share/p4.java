package com.bytedance.ee.bear.list.share;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p4 extends zd5.b {
    @Override // zd5.b
    public final void create() {
    }

    @Override // zd5.b
    public final void destroy() {
    }

    public p4() {
    }

    @Override // zd5.g
    public final List<zd5.q> k7(ce5.a r6) {
        ArrayList r0 = new ArrayList();
        if (r6.d.isCurrentEnable("ccm.space.disable_share_edittime_sort") == true) goto L5;
        ShareFileSort r1 = ShareFileSort.MODIFIED_TIME;
        zd5.q r7 = new zd5.q(r1.getResId(), r1.getRank(), r1.getAsc(), r1.getReportSort());
        r7.a = 2131889266;
        r0.add(r7);
    L5:
        ShareFileSort r2 = ShareFileSort.CREATE_TIME;
        zd5.q r8 = new zd5.q(r2.getResId(), r2.getRank(), r2.getAsc(), r2.getReportSort());
        r8.a = 2131887983;
        r0.add(r8);
        ShareFileSort r3 = ShareFileSort.SHARE_TIME;
        zd5.q r9 = new zd5.q(r3.getResId(), r3.getRank(), r3.getAsc(), r3.getReportSort());
        r9.a = 2131889637;
        r0.add(r9);
        return r0;
    }
}
