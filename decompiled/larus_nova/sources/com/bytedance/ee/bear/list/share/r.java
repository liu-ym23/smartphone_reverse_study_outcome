package com.bytedance.ee.bear.list.share;

import com.bytedance.ee.bear.list.folder.FolderSort;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class r extends zd5.b {
    @Override // zd5.b, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
    }

    @Override // zd5.b, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    public r() {
    }

    @Override // zd5.g
    public final List<zd5.q> k7(ce5.a r100) {
        ArrayList r101 = new ArrayList();
        zd5.q r102 = FolderSort.NAME.convertSortType();
        r102.f571310a = R.string.Doc_List_SortByTitle;
        r101.add(r102);
        zd5.q r103 = FolderSort.MODIFIED_TIME.convertSortType();
        r103.f571310a = R.string.LarkCCM_Docs_SortByModified_Menu_Mob;
        r101.add(r103);
        zd5.q r104 = FolderSort.CREATED_TIME.convertSortType();
        r104.f571310a = R.string.Doc_List_SortByCreationTime;
        r101.add(r104);
        return r101;
    }
}
