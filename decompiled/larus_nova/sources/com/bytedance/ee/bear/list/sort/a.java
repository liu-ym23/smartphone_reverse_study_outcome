package com.bytedance.ee.bear.list.sort;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.larksuite.framework.mvp.IView;
import java.util.List;
import zd5.q;

/* JADX INFO: loaded from: classes18.dex */
public interface a extends IView<InterfaceC3282a> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.sort.a$a, reason: collision with other inner class name */
    public interface InterfaceC3282a extends IView.IViewDelegate {
        void onClickClose();

        void y2(FolderSortStrategy r100);

        void z2(FolderSortStrategy r100);
    }

    void H(FolderSortStrategy r100);

    void h7(List<FilterType> r100, List<q> r101);
}
