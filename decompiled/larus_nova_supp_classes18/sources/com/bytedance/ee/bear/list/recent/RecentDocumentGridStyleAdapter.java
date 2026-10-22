package com.bytedance.ee.bear.list.recent;

import android.view.ViewGroup;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.GridStyleAdapter;
import com.bytedance.ee.bear.list.list.GridStyleViewHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RecentDocumentGridStyleAdapter extends GridStyleAdapter {
    public RecentDocumentGridStyleAdapter(ce5.a r2) {
        super("recent", r2);
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r1, Object r2) {
        z2(r1, (Document) r2);
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter
    public final BaseViewHolder onCreateDefViewHolder(ViewGroup r3, int r4) {
        lc5.x.c().a("inflate_list_layout");
        GridStyleViewHolder r5 = new GridStyleViewHolder(pd5.b.a.a.a(((BaseQuickAdapter) this).mContext));
        lc5.x.c().g("inflate_list_layout", 0, 0);
        return r5;
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter
    public final void z2(BaseViewHolder r3, Document r4) {
        lc5.x.c().a("bind_list_item");
        super.z2(r3, r4);
        lc5.x.c().g("bind_list_item", 0, 0);
    }
}
