package com.bytedance.ee.bear.middleground.comment.bitablediscuss;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ BitableDiscussListAdapter.BitableDiscussContentViewHolder a;
    public final /* synthetic */ BitableDiscussListAdapter b;

    public d(BitableDiscussListAdapter.BitableDiscussContentViewHolder r1, BitableDiscussListAdapter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        BitableDiscussListAdapter.BitableDiscussContentViewHolder r11 = this.a;
        CommentBean.CommentDetail.BitableExtraEntity r0 = r11.w;
        if (r0 == null) goto L17;
        BitableDiscussListAdapter r1 = this.b;
        if (r0.isMainComment() == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r0.getTableId()) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r0.getRecordId()) == true) goto L22;
        String r7 = r11.A;
        if (r7 == null) goto L20;
        ye5.a r3 = BitableDiscussListAdapter.access$getBitableFunction(r1);
        if (r3 == null) goto L21;
        r3.onDiscussShareClick(r0.getTableId(), r0.getViewId(), r0.getRecordId(), r7, r11.B);
        return;
    L21:
        return;
    L20:
        return;
    L22:
        return;
    }
}
