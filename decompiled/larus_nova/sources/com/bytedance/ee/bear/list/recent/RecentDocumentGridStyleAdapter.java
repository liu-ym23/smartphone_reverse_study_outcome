package com.bytedance.ee.bear.list.recent;

import android.view.ViewGroup;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.GridStyleAdapter;
import com.bytedance.ee.bear.list.list.GridStyleViewHolder;
import com.chad.library.adapter.base.BaseViewHolder;

/* JADX INFO: loaded from: classes18.dex */
public class RecentDocumentGridStyleAdapter extends GridStyleAdapter {
    public RecentDocumentGridStyleAdapter(ce5.a r100) {
        super("recent", r100);
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, Document r101) {
        z2(r100, r101);
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public final BaseViewHolder onCreateDefViewHolder(ViewGroup r100, int r101) {
        lc5.x.c().a("inflate_list_layout");
        GridStyleViewHolder r102 = new GridStyleViewHolder(pd5.b.a.f528675a.a(this.mContext));
        lc5.x.c().g("inflate_list_layout", 0, 0);
        return r102;
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter
    public final void z2(BaseViewHolder r100, Document r101) {
        lc5.x.c().a("bind_list_item");
        super.z2(r100, r101);
        lc5.x.c().g("bind_list_item", 0, 0);
    }
}
