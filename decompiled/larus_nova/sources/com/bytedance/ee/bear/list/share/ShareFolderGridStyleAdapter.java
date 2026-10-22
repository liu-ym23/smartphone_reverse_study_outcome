package com.bytedance.ee.bear.list.share;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.GridStyleAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class ShareFolderGridStyleAdapter extends GridStyleAdapter implements l0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View.OnClickListener f229430h;

    public ShareFolderGridStyleAdapter(ce5.a r100) {
        super("shared_folder", r100);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 >= getHeaderLayoutCount()) goto L7;
        return 273;
    L7:
        if ((getItem(r100) instanceof TitleDocument) == false) goto L11;
        return 22;
    L11:
        if ((getItem(r100) instanceof ViewHiddenDocument) == false) goto L14;
        return 33;
    L14:
        return 11;
    }

    @Override // com.bytedance.ee.bear.list.share.l0
    public final void n1(m1 r100) {
        this.f229430h = r100;
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, Document r101) {
        z2(r100, r101);
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public final BaseViewHolder onCreateDefViewHolder(ViewGroup r100, int r101) {
        if (r101 != 22) goto L7;
        return new s4(LayoutInflater.from(this.mContext).inflate(R.layout.list_recycler_item_title, r100, false));
    L7:
        if (r101 != 33) goto L11;
        return new t4(LayoutInflater.from(this.mContext).inflate(R.layout.list_recycler_item_view_hidden, r100, false));
    L11:
        return super.onCreateDefViewHolder(r100, r101);
    }

    @Override // com.bytedance.ee.bear.list.list.GridStyleAdapter
    public final void z2(BaseViewHolder r100, Document r101) {
        if (r100.getItemViewType() != 33) goto L6;
        ((t4) r100).itemView.setOnClickListener(new o2(this));
        return;
    L6:
        if (r100.getItemViewType() != 11) goto L8;
        super.z2(r100, r101);
        return;
    L8:
        tt5.a.h("ShareFolderGridStyleAdapter", "convert()...helper = " + r100);
    }
}
