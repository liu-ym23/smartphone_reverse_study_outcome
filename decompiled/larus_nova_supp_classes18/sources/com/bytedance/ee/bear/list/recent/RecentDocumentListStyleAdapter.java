package com.bytedance.ee.bear.list.recent;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.ListStyleAdapter;
import com.bytedance.ee.bear.list.list.ListStyleViewHolder;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RecentDocumentListStyleAdapter extends ListStyleAdapter {
    public final i o;

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public BaseViewHolder onCreateDefViewHolder(ViewGroup r3, int r4) {
        lc5.x.c().a("inflate_list_layout");
        ListStyleViewHolder r5 = new ListStyleViewHolder(pd5.c.a.a.a(r3.getContext()));
        lc5.x.c().g("inflate_list_layout", 0, 0);
        return r5;
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public void y2(ListStyleViewHolder r6, Document r7) {
        r7.getClass();
        if (TextUtils.isEmpty(null) == true) goto L5;
        r6.d.setText(null);
        return;
    L5:
        if (com.bytedance.ee.bear.list.t0.v(r7) == false) goto L8;
        r6.d.setText(com.bytedance.ee.bear.list.t0.G(((BaseQuickAdapter) this).mContext, r7));
        return;
    L8:
        if (this.h != RecentSort.CREATED.getRank()) goto L11;
        r6.d.setText(com.bytedance.ee.bear.list.t0.C(((BaseQuickAdapter) this).mContext, r7));
        return;
    L11:
        if (this.h != RecentSort.MODIFIED.getRank()) goto L14;
        r6.d.setText(com.bytedance.ee.bear.list.t0.E(((BaseQuickAdapter) this).mContext, r7));
        return;
    L14:
        if (this.h != RecentSort.OPENED.getRank()) goto L16;
        r6.d.setText(com.bytedance.ee.bear.list.t0.H(((BaseQuickAdapter) this).mContext, r7));
        return;
    L16:
        TextView r8 = r6.d;
        Context r0 = ((BaseQuickAdapter) this).mContext;
        r8.setText(xo5.a.c(r0, 2131889605, SheetInputData.InputData.DateType.TIME, zu5.a.e(r0, yu5.c.g(r7.N, 0) * 1000)));
    }

    public RecentDocumentListStyleAdapter(String r7, DocsLinearLayoutManager r8, ce5.a r9) {
        this(r7, r8, r9, null, new i(r9));
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public void B2(ListStyleViewHolder r1, int r2, Document r3) {
        super.B2(r1, r2, r3);
        i r4 = this.o;
        if (r4 != null) goto L5;
    L7:
        r1.j.setImageResource(2131255224);
        return;
    L5:
        if (r4.a(r3) == false) goto L7;
        r1.j.setImageResource(2131254201);
    }

    public RecentDocumentListStyleAdapter(String r7, DocsLinearLayoutManager r8, ce5.a r9, LifeCycleFragment r10, i r11) {
        super("recent", r7, r8, r9, r10);
        if (r11 != null) goto L6;
        r11 = new i(r9);
    L6:
        this.o = r11;
    }
}
