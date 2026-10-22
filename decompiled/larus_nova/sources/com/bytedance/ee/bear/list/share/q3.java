package com.bytedance.ee.bear.list.share;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class q3 extends zd5.a {
    @Override // zd5.f
    public final List<zd5.q> x7() {
        ArrayList r100 = new ArrayList();
        ShareFileSort r101 = ShareFileSort.MODIFIED_TIME;
        r100.add(new zd5.q(r101.getResId(), r101.getRank(), r101.getAsc(), r101.getReportSort()));
        ShareFileSort r102 = ShareFileSort.CREATE_TIME;
        r100.add(new zd5.q(r102.getResId(), r102.getRank(), r102.getAsc(), r102.getReportSort()));
        ShareFileSort r103 = ShareFileSort.SHARE_TIME;
        r100.add(new zd5.q(r103.getResId(), r103.getRank(), r103.getAsc(), r103.getReportSort()));
        return r100;
    }

    public q3(boolean r100) {
        super(r100);
    }
}
