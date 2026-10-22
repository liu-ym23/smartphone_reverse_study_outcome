package com.bytedance.ee.bear.list.star;

import android.content.Context;
import android.widget.TextView;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.ListStyleAdapter;
import com.bytedance.ee.bear.list.list.ListStyleViewHolder;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.util.ui.l;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FavoriteListStyleAdapter extends ListStyleAdapter {
    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final boolean G2() {
        return false;
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void y2(ListStyleViewHolder r6, Document r7) {
        TextView r8 = r6.d;
        Context r0 = ((BaseQuickAdapter) this).mContext;
        String[] r1 = t0.a;
        r8.setText(xo5.a.c(r0, 2131889651, SheetInputData.InputData.DateType.TIME, zu5.a.e(r0, yu5.c.g(r7.W, 0) * 1000)));
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void B2(ListStyleViewHolder r2, int r3, Document r4) {
        super.B2(r2, r3, r4);
        r2.j.setImageResource(2131254025);
        l.c(r2.j, 2131106521);
        r2.j.setTag(r4);
    }

    public FavoriteListStyleAdapter(String r1, String r2, DocsLinearLayoutManager r3, ce5.a r4, LifeCycleFragment r5) {
        super(r1, r2, r3, r4, r5);
    }
}
