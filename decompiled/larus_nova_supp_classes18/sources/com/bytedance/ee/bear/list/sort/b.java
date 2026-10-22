package com.bytedance.ee.bear.list.sort;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.larksuite.framework.mvp.IView;
import java.util.List;
import zd5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b extends IView<a> {

    public interface a extends IView.IViewDelegate {
        void g6(FolderSortStrategy r1);

        void onClickClose();
    }

    void H(FolderSortStrategy r1);

    void S2(List<q> r1);
}
