package com.bytedance.ee.bear.list.folder;

import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.ListStyleAdapter;
import com.bytedance.ee.bear.list.list.ListStyleViewHolder;
import com.bytedance.ee.bear.list.mine.MineSort;
import com.bytedance.ee.bear.list.t0;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MyRootFolderListStyleAdapter extends ListStyleAdapter {
    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void y2(ListStyleViewHolder r3, Document r4) {
        if (this.h != MineSort.CREATE_TIME.getRank()) goto L5;
        r3.d.setText(t0.C(((BaseQuickAdapter) this).mContext, r4));
        return;
    L5:
        r3.d.setText(t0.D(((BaseQuickAdapter) this).mContext, r4));
    }

    public MyRootFolderListStyleAdapter(String r1, String r2, DocsLinearLayoutManager r3, ce5.a r4, LifeCycleFragment r5) {
        super(r1, r2, r3, r4, r5);
    }
}
