package com.bytedance.ee.bear.middleground.comment.bitablediscuss;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableDiscussListAdapter.BitableDiscussContentViewHolder f230715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitableDiscussListAdapter f230716b;

    public d(BitableDiscussListAdapter.BitableDiscussContentViewHolder r100, BitableDiscussListAdapter r101) {
        this.f230715a = r100;
        this.f230716b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        BitableDiscussListAdapter.BitableDiscussContentViewHolder r111 = this.f230715a;
        CommentBean.CommentDetail.BitableExtraEntity r100 = r111.f230676w;
        if (r100 == null) goto L17;
        BitableDiscussListAdapter r101 = this.f230716b;
        if (r100.isMainComment() == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r100.getTableId()) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r100.getRecordId()) == true) goto L22;
        String r102 = r111.A;
        if (r102 == null) goto L20;
        ye5.a r103 = BitableDiscussListAdapter.access$getBitableFunction(r101);
        if (r103 == null) goto L21;
        r103.onDiscussShareClick(r100.getTableId(), r100.getViewId(), r100.getRecordId(), r102, r111.B);
        return;
    L21:
        return;
    L20:
        return;
    L22:
        return;
    }
}
