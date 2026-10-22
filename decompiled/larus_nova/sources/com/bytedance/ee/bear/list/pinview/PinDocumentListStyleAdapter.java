package com.bytedance.ee.bear.list.pinview;

import android.content.res.ColorStateList;
import ce5.a;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.ListStyleAdapter;
import com.bytedance.ee.bear.list.list.ListStyleViewHolder;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class PinDocumentListStyleAdapter extends ListStyleAdapter {
    public PinDocumentListStyleAdapter(String r100, DocsLinearLayoutManager r101, a r102) {
        super("quick_access", r100, r101, r102, null);
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void B2(ListStyleViewHolder r100, int r101, Document r102) {
        super.B2(r100, r101, r102);
        r100.f228508j.setImageResource(R.drawable.ud_icon_cancel_buzz_outlined);
        r100.f228508j.setImageTintList(ColorStateList.valueOf(-1));
    }
}
