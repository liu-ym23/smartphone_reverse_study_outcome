package com.bytedance.ee.bear.list.share;

import android.widget.ImageView;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.ListStyleAdapter;
import com.bytedance.ee.bear.list.list.ListStyleViewHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SharedListStyleAdapter extends ListStyleAdapter {
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

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void B2(ListStyleViewHolder r2, int r3, Document r4) {
        super.B2(r2, r3, r4);
        ImageView r5 = r2.j;
        if (r4.z == false) goto L5;
        int r0 = 2131254025;
    L6:
        r5.setImageResource(r0);
        ImageView r6 = r2.j;
        if (r4.z == false) goto L9;
        int r7 = 2131102093;
    L10:
        r6.setBackgroundResource(r7);
        return;
    L9:
        r7 = 2131106272;
        goto L10
    L5:
        r0 = 2131254139;
        goto L6
    }

    public SharedListStyleAdapter(String r7, DocsLinearLayoutManager r8, ce5.a r9, LifeCycleFragment r10) {
        super("shared", r7, r8, r9, r10);
    }
}
