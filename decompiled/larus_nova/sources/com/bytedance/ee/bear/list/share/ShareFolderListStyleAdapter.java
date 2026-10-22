package com.bytedance.ee.bear.list.share;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DocsLinearLayoutManager;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.list.ListStyleAdapter;
import com.bytedance.ee.bear.list.list.ListStyleViewHolder;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class ShareFolderListStyleAdapter extends ListStyleAdapter implements l0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View.OnClickListener f229435o;

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
        this.f229435o = r100;
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void E2(BaseViewHolder r100, Document r101) {
        if (r100.getItemViewType() != 33) goto L6;
        ((t4) r100).itemView.setOnClickListener(new t2(this));
        return;
    L6:
        if (r100.getItemViewType() != 11) goto L8;
        super.E2(r100, r101);
        return;
    L8:
        tt5.a.h("ShareFolderListStyleAdapter", "convert()...helper = " + r100);
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, Document r101) {
        E2(r100, r101);
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public final BaseViewHolder onCreateDefViewHolder(ViewGroup r100, int r101) {
        if (r101 != 22) goto L7;
        return new s4(LayoutInflater.from(this.mContext).inflate(R.layout.list_recycler_item_title, r100, false));
    L7:
        if (r101 != 33) goto L11;
        return new t4(LayoutInflater.from(this.mContext).inflate(R.layout.list_recycler_item_view_hidden, r100, false));
    L11:
        return super.onCreateDefViewHolder(r100, r101);
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void y2(ListStyleViewHolder r100, Document r101) {
        if (this.f228487h != FolderSort.CREATED_TIME.getRank()) goto L6;
        r100.f228502d.setText(com.bytedance.ee.bear.list.t0.C(this.mContext, r101));
        return;
    L6:
        if (this.f228487h != FolderSort.SHARED_TIME.getRank()) goto L8;
        r100.f228502d.setText(com.bytedance.ee.bear.list.t0.F(this.mContext, r101, this.f228488i));
        return;
    L8:
        r100.f228502d.setText(com.bytedance.ee.bear.list.t0.D(this.mContext, r101));
    }

    @Override // com.bytedance.ee.bear.list.list.ListStyleAdapter
    public final void B2(ListStyleViewHolder r100, int r101, Document r102) {
        super.B2(r100, r101, r102);
        ImageView r103 = r100.f228508j;
        if (r102.f227910z == false) goto L5;
        int r104 = R.drawable.ud_icon_cancel_collection_outlined;
    L6:
        r103.setImageResource(r104);
        ImageView r105 = r100.f228508j;
        if (r102.f227910z == false) goto L9;
        int r106 = R.color.function_danger_fill_default;
    L10:
        r105.setBackgroundResource(r106);
        return;
    L9:
        r106 = R.color.space_list_bg_item_menu_start;
        goto L10
    L5:
        r104 = R.drawable.ud_icon_collection_outlined;
        goto L6
    }

    public ShareFolderListStyleAdapter(String r100, DocsLinearLayoutManager r101, ce5.a r102, LifeCycleFragment r110) {
        super("shared_folder", r100, r101, r102, r110);
    }
}
