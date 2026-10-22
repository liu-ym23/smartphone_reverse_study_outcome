package com.bytedance.ee.bear.list.share;

import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class r3 extends zd5.b {
    @Override // zd5.b, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
    }

    @Override // zd5.b, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    public r3() {
    }

    @Override // zd5.g
    public final List<zd5.q> k7(ce5.a r100) {
        ArrayList r101 = new ArrayList();
        ShareFileSort r102 = ShareFileSort.MODIFIED_TIME;
        zd5.q r103 = new zd5.q(r102.getResId(), r102.getRank(), r102.getAsc(), r102.getReportSort());
        r101.add(r103);
        r103.f571310a = R.string.LarkCCM_Docs_SortByModified_Menu_Mob;
        ShareFileSort r104 = ShareFileSort.CREATE_TIME;
        zd5.q r105 = new zd5.q(r104.getResId(), r104.getRank(), r104.getAsc(), r104.getReportSort());
        r105.f571310a = R.string.Doc_List_SortByCreationTime;
        r101.add(r105);
        ShareFileSort r106 = ShareFileSort.SHARE_TIME;
        zd5.q r107 = new zd5.q(r106.getResId(), r106.getRank(), r106.getAsc(), r106.getReportSort());
        r101.add(r107);
        r107.f571310a = R.string.LarkCCM_NewCM_SharedTime_Menu;
        return r101;
    }
}
