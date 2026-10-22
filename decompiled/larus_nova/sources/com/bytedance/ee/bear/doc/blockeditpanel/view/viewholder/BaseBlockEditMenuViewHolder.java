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

/* JADX INFO: loaded from: classes16.dex */
public abstract class BaseBlockEditMenuViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f217746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f217747b;

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseBlockEditMenuViewHolder f217748c;

        public a(BaseBlockEditMenuViewHolder r100) {
            this.f217748c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            Object r101 = r100.getTag();
            if ((r101 instanceof BlockEditPanelMenusModel.BlockEditPanelMenuItem) == false) goto L8;
            b r102 = this.f217748c.f217746a;
            if (r102 == null) goto L9;
            r102.a((BlockEditPanelMenusModel.BlockEditPanelMenuItem) r101);
            return;
        L9:
            return;
        }
    }

    public ImageView T3() {
        return null;
    }

    public BaseBlockEditMenuViewHolder(View r100) {
        super(r100);
        this.f217747b = 0;
        r100.setOnClickListener(new a(this));
    }

    public void U3(BlockEditPanelMenusModel.BlockEditPanelMenuItem r100) {
        ImageView r101 = T3();
        EMenuItemConfig r102 = EMenuItemConfig.getMenuItemConfigById(r100.getId());
        if (r102 == EMenuItemConfig.UNKNOWN) goto L21;
        if (r101 == null) goto L22;
        int r103 = r102.imageRes;
        if (r103 == (-1)) goto L9;
        r101.setImageResource(r103);
    L16:
        int r104 = r102.bgRes;
        if (r104 == (-1)) goto L19;
        this.itemView.setBackgroundResource(r104);
    L19:
        f.g(r101, r102.iconStateColorList);
        f.f(this.itemView, r102.backgroundStateColorList);
        this.itemView.setEnabled(r100.isEnable());
        this.itemView.setSelected(r100.isSelected());
        return;
    L9:
        Context r105 = r101.getContext();
        int r106 = this.f217747b;
        if (r106 > 0) goto L13;
        r106 = n.d(48);
    L13:
        Drawable r107 = r102.getImageDrawable(r105, r106);
        if (r107 == null) goto L16;
        r101.setImageDrawable(r107);
        goto L16
    L22:
        return;
    }
}
