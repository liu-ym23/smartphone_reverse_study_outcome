package com.bytedance.ee.bear.doc.blockeditpanel.view.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class IconViewHolder extends BaseBlockEditMenuViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f217749c;

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.viewholder.BaseBlockEditMenuViewHolder
    public final ImageView T3() {
        return this.f217749c;
    }

    public IconViewHolder(View r100) {
        super(r100);
        this.f217749c = (ImageView) r100.findViewById(R.id.editPanelMenuItemImg);
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.viewholder.BaseBlockEditMenuViewHolder
    public final void U3(BlockEditPanelMenusModel.BlockEditPanelMenuItem r100) {
        this.itemView.setTag(r100);
        View r101 = this.itemView;
        if (this.f217747b <= 0) goto L5;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        r102.width = this.f217747b;
        r101.setLayoutParams(r102);
    L5:
        super.U3(r100);
    }
}
