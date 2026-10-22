package jd5;

import com.bytedance.ee.bear.list.mine.MineSort;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class v extends zd5.b {
    @Override // zd5.b, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
    }

    @Override // zd5.b, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    public v() {
    }

    @Override // zd5.g
    public final List<zd5.q> k7(ce5.a r100) {
        ArrayList r101 = new ArrayList();
        MineSort r102 = MineSort.MODIFIED_TIME;
        zd5.q r103 = new zd5.q(r102.getResId(), r102.getRank(), r102.getAsc(), r102.getReportSort());
        r103.f571310a = R.string.LarkCCM_Docs_SortByModified_Menu_Mob;
        r101.add(r103);
        MineSort r104 = MineSort.CREATE_TIME;
        zd5.q r105 = new zd5.q(r104.getResId(), r104.getRank(), r104.getAsc(), r104.getReportSort());
        r105.f571310a = R.string.Doc_List_SortByCreationTime;
        r101.add(r105);
        return r101;
    }
}
