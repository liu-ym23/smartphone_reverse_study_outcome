package com.bytedance.ee.bear.list.pinview;

import android.content.res.ColorStateList;
import ce5.a;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.ListStyleAdapter;
import com.bytedance.ee.bear.list.list.ListStyleViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class PinDocumentListStyleAdapter extends ListStyleAdapter {
    public PinDocumentListStyleAdapter(String r7, DocsLinearLayoutManager r8, a r9) {
        super("quick_access", r7, r8, r9, null);
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void B2(ListStyleViewHolder r1, int r2, Document r3) {
        super.B2(r1, r2, r3);
        r1.j.setImageResource(2131254024);
        r1.j.setImageTintList(ColorStateList.valueOf(-1));
    }
}
