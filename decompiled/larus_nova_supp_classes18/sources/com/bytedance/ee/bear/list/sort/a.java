package com.bytedance.ee.bear.list.sort;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.larksuite.framework.mvp.IView;
import java.util.List;
import zd5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a extends IView<InterfaceC0035a> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.list.sort.a$a, reason: collision with other inner class name */
    public interface InterfaceC0035a extends IView.IViewDelegate {
        void onClickClose();

        void y2(FolderSortStrategy r1);

        void z2(FolderSortStrategy r1);
    }

    void H(FolderSortStrategy r1);

    void h7(List<FilterType> r1, List<q> r2);
}
