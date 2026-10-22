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
import com.larus.nova.R;
import dy4.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class TextBlockMenuItemAdapter extends RecyclerView.Adapter<BaseBlockEditMenuViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f217729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f217730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<BlockEditPanelMenusModel.BlockEditPanelMenuItem> f217731c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f217731c).size();
    }

    public TextBlockMenuItemAdapter() {
        this.f217729a = 0;
        this.f217731c = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        BlockEditPanelMenusModel.BlockEditPanelMenuItem r101 = (BlockEditPanelMenusModel.BlockEditPanelMenuItem) ListProtector.get(this.f217731c, r100);
        if (r101 != null) goto L5;
        String r102 = "";
    L7:
        return EMenuItemButtonType.getEMenuItemButtonTypeByName(r102).ordinal();
    L5:
        r102 = r101.getButtonType();
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BaseBlockEditMenuViewHolder r102 = (BaseBlockEditMenuViewHolder) r100;
        BlockEditPanelMenusModel.BlockEditPanelMenuItem r103 = (BlockEditPanelMenusModel.BlockEditPanelMenuItem) ListProtector.get(this.f217731c, r101);
        r102.f217747b = this.f217729a;
        r102.U3(r103);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        EMenuItemButtonType r102 = EMenuItemButtonType.getEMenuItemButtonTypeByOrdinal(r101);
        if (r102 != EMenuItemButtonType.SEPARATOR) goto L6;
        BaseBlockEditMenuViewHolder r103 = new DividerViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.doc_block_edit_panel_divider_menu_item, r100, false));
    L9:
        r103.f217746a = this.f217730b;
        return r103;
    L6:
        if (r102 != EMenuItemButtonType.ICON_WITH_RIGHT_ARROW) goto L8;
        r103 = new IconWithRightArrowViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.doc_block_edit_panel_menu_item_hn, r100, false));
        goto L9
    L8:
        r103 = new IconViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.doc_block_edit_panel_icon_menu_item, r100, false));
        goto L9
    }
}
