package com.bytedance.ee.bear.list.share;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.list.ListStyleAdapter;
import com.bytedance.ee.bear.list.list.ListStyleViewHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ShareFolderListStyleAdapter extends ListStyleAdapter implements l0 {
    public View.OnClickListener o;

    @Override // com.bytedance.ee.bear.list.list.d
    public final int getItemViewType(int r2) {
        if (r2 >= getHeaderLayoutCount()) goto L7;
        return 273;
    L7:
        if ((getItem(r2) instanceof TitleDocument) == false) goto L11;
        return 22;
    L11:
        if ((getItem(r2) instanceof ViewHiddenDocument) == false) goto L14;
        return 33;
    L14:
        return 11;
    }

    @Override // com.bytedance.ee.bear.list.share.l0
    public final void n1(m1 r1) {
        this.o = r1;
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void E2(BaseViewHolder r3, Document r4) {
        if (r3.getItemViewType() != 33) goto L6;
        ((RecyclerView.ViewHolder) ((t4) r3)).itemView.setOnClickListener(new t2(this));
        return;
    L6:
        if (r3.getItemViewType() != 11) goto L8;
        super.E2(r3, r4);
        return;
    L8:
        tt5.a.h("ShareFolderListStyleAdapter", "convert()...helper = " + r3);
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r1, Object r2) {
        E2(r1, (Document) r2);
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final BaseViewHolder onCreateDefViewHolder(ViewGroup r4, int r5) {
        if (r5 != 22) goto L7;
        return new s4(LayoutInflater.from(((BaseQuickAdapter) this).mContext).inflate(2131563510, r4, false));
    L7:
        if (r5 != 33) goto L11;
        return new t4(LayoutInflater.from(((BaseQuickAdapter) this).mContext).inflate(2131563511, r4, false));
    L11:
        return super.onCreateDefViewHolder(r4, r5);
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void y2(ListStyleViewHolder r3, Document r4) {
        if (this.h != FolderSort.CREATED_TIME.getRank()) goto L6;
        r3.d.setText(com.bytedance.ee.bear.list.t0.C(((BaseQuickAdapter) this).mContext, r4));
        return;
    L6:
        if (this.h != FolderSort.SHARED_TIME.getRank()) goto L8;
        r3.d.setText(com.bytedance.ee.bear.list.t0.F(((BaseQuickAdapter) this).mContext, r4, this.i));
        return;
    L8:
        r3.d.setText(com.bytedance.ee.bear.list.t0.D(((BaseQuickAdapter) this).mContext, r4));
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

    public ShareFolderListStyleAdapter(String r7, DocsLinearLayoutManager r8, ce5.a r9, LifeCycleFragment r10) {
        super("shared_folder", r7, r8, r9, r10);
    }
}
