package com.bytedance.ee.bear.doc.blockeditpanel.view.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class IconWithRightArrowViewHolder extends BaseBlockEditMenuViewHolder {
    public final ImageView c;

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.viewholder.BaseBlockEditMenuViewHolder
    public final ImageView T3() {
        return this.c;
    }

    public IconWithRightArrowViewHolder(View r2) {
        super(r2);
        this.c = (ImageView) r2.findViewById(2131376663);
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.viewholder.BaseBlockEditMenuViewHolder
    public final void U3(BlockEditPanelMenusModel.BlockEditPanelMenuItem r4) {
        ((RecyclerView.ViewHolder) this).itemView.setTag(r4);
        ImageView r0 = this.c;
        if (this.b <= 0) goto L5;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.width = this.b;
        r0.setLayoutParams(r1);
    L5:
        super.U3(r4);
    }
}
