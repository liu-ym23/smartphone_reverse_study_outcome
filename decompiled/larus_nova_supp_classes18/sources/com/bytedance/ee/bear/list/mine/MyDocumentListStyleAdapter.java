package com.bytedance.ee.bear.list.mine;

import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.ListStyleAdapter;
import com.bytedance.ee.bear.list.list.ListStyleViewHolder;
import com.bytedance.ee.bear.list.t0;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MyDocumentListStyleAdapter extends ListStyleAdapter {
    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void y2(ListStyleViewHolder r3, Document r4) {
        if (this.h != MineSort.CREATE_TIME.getRank()) goto L5;
        r3.d.setText(t0.C(((BaseQuickAdapter) this).mContext, r4));
        return;
    L5:
        r3.d.setText(t0.D(((BaseQuickAdapter) this).mContext, r4));
    }

    public MyDocumentListStyleAdapter(String r7, DocsLinearLayoutManager r8, ce5.a r9) {
        super("belongtome", r7, r8, r9, null);
    }
}
