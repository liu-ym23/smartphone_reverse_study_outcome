package com.bytedance.ee.bear.list.manualoffline;

import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.ListStyleAdapter;
import com.bytedance.ee.bear.list.list.ListStyleViewHolder;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.util.io.FileUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import sbb.e;
import yu5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ManualOfflineDocumentListStyleAdapter extends ListStyleAdapter {
    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void y2(ListStyleViewHolder r5, Document r6) {
        if (t0.v(r6) == false) goto L6;
        String r0 = t0.G(((BaseQuickAdapter) this).mContext, r6);
    L10:
        if (r6.getType() != e.l.b) goto L12;
        r0 = FileUtils.A(c.g(r6.Z, 0)) + " " + r0;
    L12:
        r5.d.setText(r0);
        return;
    L6:
        if (this.h != ManualOfflineSort.CREATED.getRank()) goto L8;
        r0 = t0.C(((BaseQuickAdapter) this).mContext, r6);
        goto L10
    L8:
        r0 = t0.D(((BaseQuickAdapter) this).mContext, r6);
        goto L10
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void B2(ListStyleViewHolder r1, int r2, Document r3) {
        super.B2(r1, r2, r3);
        r1.j.setImageResource(2131255224);
    }

    public ManualOfflineDocumentListStyleAdapter(String r7, DocsLinearLayoutManager r8, ce5.a r9, LifeCycleFragment r10) {
        super(OperationName.OPERATION_OFFLINE_AVAILABLE, r7, r8, r9, r10);
    }
}
