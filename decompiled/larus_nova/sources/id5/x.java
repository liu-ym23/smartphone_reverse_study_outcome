package id5;

import com.bytedance.ee.bear.list.manualoffline.ManualOfflineSort;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class x extends zd5.b {
    @Override // zd5.b, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
    }

    @Override // zd5.b, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    public x() {
    }

    @Override // zd5.g
    public final List<zd5.q> k7(ce5.a r100) {
        ArrayList r101 = new ArrayList();
        ManualOfflineSort r102 = ManualOfflineSort.MODIFIED;
        r101.add(new zd5.q(R.string.LarkCCM_Docs_SortByModified_Menu_Mob, r102.getRank(), r102.getAsc(), r102.getReportSort()));
        ManualOfflineSort r103 = ManualOfflineSort.CREATED;
        r101.add(new zd5.q(R.string.Doc_List_SortByCreationTime, r103.getRank(), r103.getAsc(), r103.getReportSort()));
        ManualOfflineSort r104 = ManualOfflineSort.DEFAULT;
        r101.add(new zd5.q(R.string.LarkCCM_NewCM_SavedTime_Option, r104.getRank(), r104.getAsc(), r104.getReportSort()));
        return r101;
    }
}
