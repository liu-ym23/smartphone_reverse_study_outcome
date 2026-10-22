package com.bytedance.ee.bear.list.share;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.GridStyleAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ShareFolderGridStyleAdapter extends GridStyleAdapter implements l0 {
    public View.OnClickListener h;

    public ShareFolderGridStyleAdapter(ce5.a r2) {
        super("shared_folder", r2);
    }

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
        this.h = r1;
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r1, Object r2) {
        z2(r1, (Document) r2);
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter
    public final BaseViewHolder onCreateDefViewHolder(ViewGroup r4, int r5) {
        if (r5 != 22) goto L7;
        return new s4(LayoutInflater.from(((BaseQuickAdapter) this).mContext).inflate(2131563510, r4, false));
    L7:
        if (r5 != 33) goto L11;
        return new t4(LayoutInflater.from(((BaseQuickAdapter) this).mContext).inflate(2131563511, r4, false));
    L11:
        return super.onCreateDefViewHolder(r4, r5);
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter
    public final void z2(BaseViewHolder r3, Document r4) {
        if (r3.getItemViewType() != 33) goto L6;
        ((RecyclerView.ViewHolder) ((t4) r3)).itemView.setOnClickListener(new o2(this));
        return;
    L6:
        if (r3.getItemViewType() != 11) goto L8;
        super.z2(r3, r4);
        return;
    L8:
        tt5.a.h("ShareFolderGridStyleAdapter", "convert()...helper = " + r3);
    }
}
