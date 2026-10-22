package com.bytedance.ee.bear.doc.blockeditpanel.view.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.doc.blockeditpanel.model.EMenuItemConfig;
import com.bytedance.ee.bear.doc.blockeditpanel.view.f;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.n;
import dy4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseBlockEditMenuViewHolder extends RecyclerView.ViewHolder {
    public b a;
    public int b;

    public class a extends t {
        public final /* synthetic */ BaseBlockEditMenuViewHolder c;

        public a(BaseBlockEditMenuViewHolder r1) {
            this.c = r1;
        }

        public final void a(View r2) {
            Object r3 = r2.getTag();
            if ((r3 instanceof BlockEditPanelMenusModel.BlockEditPanelMenuItem) == false) goto L8;
            b r0 = this.c.a;
            if (r0 == null) goto L9;
            r0.a((BlockEditPanelMenusModel.BlockEditPanelMenuItem) r3);
            return;
        L9:
            return;
        }
    }

    public ImageView T3() {
        return null;
    }

    public BaseBlockEditMenuViewHolder(View r2) {
        super(r2);
        this.b = 0;
        r2.setOnClickListener(new a(this));
    }

    public void U3(BlockEditPanelMenusModel.BlockEditPanelMenuItem r6) {
        ImageView r0 = T3();
        EMenuItemConfig r1 = EMenuItemConfig.getMenuItemConfigById(r6.getId());
        if (r1 == EMenuItemConfig.UNKNOWN) goto L21;
        if (r0 == null) goto L22;
        int r2 = r1.imageRes;
        if (r2 == (-1)) goto L9;
        r0.setImageResource(r2);
    L16:
        int r3 = r1.bgRes;
        if (r3 == (-1)) goto L19;
        ((RecyclerView.ViewHolder) this).itemView.setBackgroundResource(r3);
    L19:
        f.g(r0, r1.iconStateColorList);
        f.f(((RecyclerView.ViewHolder) this).itemView, r1.backgroundStateColorList);
        ((RecyclerView.ViewHolder) this).itemView.setEnabled(r6.isEnable());
        ((RecyclerView.ViewHolder) this).itemView.setSelected(r6.isSelected());
        return;
    L9:
        Context r4 = r0.getContext();
        int r5 = this.b;
        if (r5 > 0) goto L13;
        r5 = n.d(48);
    L13:
        Drawable r7 = r1.getImageDrawable(r4, r5);
        if (r7 == null) goto L16;
        r0.setImageDrawable(r7);
        goto L16
    L22:
        return;
    }
}
