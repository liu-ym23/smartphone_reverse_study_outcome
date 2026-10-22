package com.bytedance.ee.bear.list.star;

import android.content.Context;
import android.widget.TextView;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.ListStyleAdapter;
import com.bytedance.ee.bear.list.list.ListStyleViewHolder;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.util.ui.l;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class FavoriteListStyleAdapter extends ListStyleAdapter {
    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final boolean G2() {
        return false;
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void y2(ListStyleViewHolder r100, Document r101) {
        TextView r102 = r100.f228502d;
        Context r103 = this.mContext;
        String[] r104 = t0.f229767a;
        r102.setText(xo5.a.c(r103, R.string.LarkCCM_NewCM_StarredTime_Description, "time", zu5.a.e(r103, yu5.c.g(r101.W, 0) * 1000)));
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void B2(ListStyleViewHolder r100, int r101, Document r102) {
        super.B2(r100, r101, r102);
        r100.f228508j.setImageResource(R.drawable.ud_icon_cancel_collection_outlined);
        l.c(r100.f228508j, R.color.static_white);
        r100.f228508j.setTag(r102);
    }

    public FavoriteListStyleAdapter(String r100, String r101, DocsLinearLayoutManager r102, ce5.a r103, LifeCycleFragment r104) {
        super(r100, r101, r102, r103, r104);
    }
}
