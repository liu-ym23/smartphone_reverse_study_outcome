package com.bytedance.ee.bear.doc.blockeditpanel.view.panel.toolbatmenu;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.doc.blockeditpanel.model.EMenuItemButtonType;
import com.bytedance.ee.bear.doc.blockeditpanel.view.viewholder.BaseBlockEditMenuViewHolder;
import com.bytedance.ee.bear.doc.blockeditpanel.view.viewholder.DividerViewHolder;
import com.bytedance.ee.bear.doc.blockeditpanel.view.viewholder.IconViewHolder;
import com.bytedance.ee.bear.doc.blockeditpanel.view.viewholder.IconWithRightArrowViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import dy4.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TextBlockMenuItemAdapter extends RecyclerView.Adapter<BaseBlockEditMenuViewHolder> {
    public int a;
    public b b;
    public final List<BlockEditPanelMenusModel.BlockEditPanelMenuItem> c;

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    public TextBlockMenuItemAdapter() {
        this.a = 0;
        this.c = new ArrayList();
    }

    public final int getItemViewType(int r2) {
        BlockEditPanelMenusModel.BlockEditPanelMenuItem r3 = (BlockEditPanelMenusModel.BlockEditPanelMenuItem) ListProtector.get(this.c, r2);
        if (r3 != null) goto L5;
        String r4 = "";
    L7:
        return EMenuItemButtonType.getEMenuItemButtonTypeByName(r4).ordinal();
    L5:
        r4 = r3.getButtonType();
        goto L7
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        BaseBlockEditMenuViewHolder r4 = (BaseBlockEditMenuViewHolder) r2;
        BlockEditPanelMenusModel.BlockEditPanelMenuItem r5 = (BlockEditPanelMenusModel.BlockEditPanelMenuItem) ListProtector.get(this.c, r3);
        r4.b = this.a;
        r4.U3(r5);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        EMenuItemButtonType r6 = EMenuItemButtonType.getEMenuItemButtonTypeByOrdinal(r5);
        if (r6 != EMenuItemButtonType.SEPARATOR) goto L6;
        BaseBlockEditMenuViewHolder r7 = new DividerViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131560065, r4, false));
    L9:
        r7.a = this.b;
        return r7;
    L6:
        if (r6 != EMenuItemButtonType.ICON_WITH_RIGHT_ARROW) goto L8;
        r7 = new IconWithRightArrowViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131560070, r4, false));
        goto L9
    L8:
        r7 = new IconViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131560067, r4, false));
        goto L9
    }
}
