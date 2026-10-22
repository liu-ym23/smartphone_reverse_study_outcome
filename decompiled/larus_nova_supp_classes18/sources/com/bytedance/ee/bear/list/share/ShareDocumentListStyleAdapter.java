package com.bytedance.ee.bear.list.share;

import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.ListStyleAdapter;
import com.bytedance.ee.bear.list.list.ListStyleViewHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ShareDocumentListStyleAdapter extends ListStyleAdapter {
    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void y2(ListStyleViewHolder r3, Document r4) {
        if (this.h != ShareFileSort.CREATE_TIME.getRank()) goto L6;
        r3.d.setText(com.bytedance.ee.bear.list.t0.C(((BaseQuickAdapter) this).mContext, r4));
        return;
    L6:
        if (this.h != ShareFileSort.MODIFIED_TIME.getRank()) goto L8;
        r3.d.setText(com.bytedance.ee.bear.list.t0.D(((BaseQuickAdapter) this).mContext, r4));
        return;
    L8:
        r3.d.setText(com.bytedance.ee.bear.list.t0.F(((BaseQuickAdapter) this).mContext, r4, this.i));
    }

    public ShareDocumentListStyleAdapter(String r7, DocsLinearLayoutManager r8, ce5.a r9) {
        super("sharetome", r7, r8, r9, null);
    }
}
