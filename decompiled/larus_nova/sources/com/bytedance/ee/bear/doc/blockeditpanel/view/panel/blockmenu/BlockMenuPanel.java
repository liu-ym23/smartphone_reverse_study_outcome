package com.bytedance.ee.bear.doc.blockeditpanel.view.panel.blockmenu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.doc.blockeditpanel.model.EMenuItemButtonType;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel;
import com.bytedance.ee.bear.doc.blockeditpanel.view.viewholder.BaseBlockEditMenuViewHolder;
import com.bytedance.ee.bear.doc.blockeditpanel.view.viewholder.DividerViewHolder;
import com.bytedance.ee.bear.doc.blockeditpanel.view.viewholder.IconViewHolder;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class BlockMenuPanel extends BaseBlockEditPanel {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f217684w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f217685x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f217686y = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RecyclerView f217687o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f217688p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d f217689q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c f217690r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public BlockEditPanelMenusModel.BlockEditPanel f217691s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<String> f217692t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f217693u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f217694v;

    public class a extends GridLayoutManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BlockMenuPanel f217695a;

        @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
            super.onLayoutChildren(r100, r101);
            BlockMenuPanel r102 = this.f217695a;
            r102.f217694v = r102.f217688p.getRowCountForAccessibility(r100, r101);
        }

        public a(BlockMenuPanel r100, Context r101, int r102) {
            this.f217695a = r100;
            super(r101, r102);
        }
    }

    public class b extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BlockMenuPanel f217696a;

        public b(BlockMenuPanel r100) {
            this.f217696a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            int r104 = this.f217696a.f217688p.getSpanCount();
            if ((r102.getChildLayoutPosition(r101) % r104) == 0) goto L6;
            r100.left = BlockMenuPanel.f217686y;
            return;
        }
    }

    public class c implements dy4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BlockMenuPanel f217697a;

        public c(BlockMenuPanel r100) {
            this.f217697a = r100;
        }

        @Override // dy4.b
        public final void a(BlockEditPanelMenusModel.BlockEditPanelMenuItem r100) {
            List<String> r101 = this.f217697a.f217692t;
            ArrayList r102 = (ArrayList) r101;
            if (r102.contains(r100.getId()) == false) goto L7;
            BlockMenuPanel r103 = this.f217697a;
            BlockEditPanelMenusModel.BlockEditPanel r104 = r103.f217691s;
            if (r104 == null) goto L7;
            r103.d(r104, r100);
        L7:
            this.f217697a.f217674e.onClickEditMenuItem(r100);
        }
    }

    public class d extends RecyclerView.Adapter<BaseBlockEditMenuViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<BlockEditPanelMenusModel.BlockEditPanelMenuItem> f217698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BlockMenuPanel f217699b;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((ArrayList) this.f217698a).size();
        }

        public d(BlockMenuPanel r100) {
            this.f217699b = r100;
            this.f217698a = new ArrayList();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            BlockEditPanelMenusModel.BlockEditPanelMenuItem r101 = (BlockEditPanelMenusModel.BlockEditPanelMenuItem) ListProtector.get(this.f217698a, r100);
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
            if (r101 >= 0) goto L5;
            return;
        L5:
            if (r101 >= ((ArrayList) this.f217698a).size()) goto L10;
            r102.U3((BlockEditPanelMenusModel.BlockEditPanelMenuItem) ListProtector.get(this.f217698a, r101));
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Context r102 = r100.getContext();
            EMenuItemButtonType r103 = EMenuItemButtonType.getEMenuItemButtonTypeByOrdinal(r101);
            switch(jy4.a.f500945a[r103.ordinal()]) {
                case 1: goto L8;
                case 2: goto L7;
                case 3: goto L7;
                case 4: goto L6;
                case 5: goto L6;
                case 6: goto L6;
                case 7: goto L6;
                case 8: goto L5;
                case 9: goto L5;
                default: goto L4;
            };
        L4:
            BaseBlockEditMenuViewHolder r104 = new jy4.b(LayoutInflater.from(r102).inflate(R.layout.doc_block_edit_panel_icon_text_menu_item, r100, false));
        L9:
            r104.f217746a = this.f217699b.f217690r;
            return r104;
        L5:
            r104 = new IconViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.doc_block_edit_panel_icon_menu_item, r100, false));
            goto L9
        L6:
            r104 = new jy4.b(LayoutInflater.from(r102).inflate(R.layout.doc_block_edit_panel_icon_text_menu_item, r100, false));
            goto L9
        L7:
            r104 = new IconViewHolder(LayoutInflater.from(r102).inflate(R.layout.doc_block_edit_panel_recyclerview_menu_item, r100, false));
            goto L9
        L8:
            r104 = new DividerViewHolder(LayoutInflater.from(r102).inflate(R.layout.doc_block_edit_panel_divider_menu_item, r100, false));
            goto L9
        }
    }

    public void d(BlockEditPanelMenusModel.BlockEditPanel r100, BlockEditPanelMenusModel.BlockEditPanelMenuItem r101) {
    }

    static {
        f217684w = n.d(8);
        f217685x = n.d(4);
        f217686y = n.d(1);
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public final ViewGroup.LayoutParams b() {
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-1, -2);
        int r101 = f217684w;
        r100.leftMargin = r101;
        r100.rightMargin = r101;
        r100.bottomMargin = r101;
        return r100;
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public View getContentView() {
        if (this.f217687o != null) goto L6;
        this.f217687o = new RecyclerView(getContext());
        a r100 = new a(this, getContext(), getMaxSpanCount());
        this.f217688p = r100;
        this.f217687o.setLayoutManager(r100);
        this.f217687o.setNestedScrollingEnabled(false);
        d r101 = new d(this);
        this.f217689q = r101;
        this.f217687o.setAdapter(r101);
        this.f217687o.addItemDecoration(new b(this));
        this.f217690r = new c(this);
    L6:
        return this.f217687o;
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public int getPanelHeight() {
        RecyclerView r100 = this.f217687o;
        int r101 = 0;
        if (r100 != null) goto L5;
    L14:
        return 0;
    L5:
        if (r100.getChildCount() <= 0) goto L14;
        int r102 = this.f217687o.getChildCount();
        if (r102 != 0) goto L9;
        return 0;
    L9:
        int r103 = this.f217688p.getSpanCount();
        int r104 = 0;
    L10:
        if (r101 >= r102) goto L12;
        r104 = r104 + this.f217687o.getChildAt(r101).getHeight();
        r101 = r101 + r103;
        goto L10
    L12:
        int r105 = r104 + (f217685x * this.f217694v);
        tt5.a.h("BaseBlockEditPanel", "getPanelHeight:" + r105 + ", recyclerView:" + this.f217687o.getHeight());
        return r105;
    }

    private int getMaxSpanCount() {
        Resources r100 = getContext().getResources();
        if (r100 == null) goto L10;
        Configuration r101 = r100.getConfiguration();
        if (r101 == null) goto L10;
        if (2 != r101.orientation) goto L10;
        return 6;
    L10:
        return 5;
    }

    public BlockMenuPanel(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public final void a(boolean r100) {
        if (this.f217687o == null) goto L9;
        d r101 = this.f217689q;
        if (r101 == null) goto L11;
        int r102 = ((ArrayList) r101.f217698a).size();
        int r103 = getMaxSpanCount() * 2;
        int r104 = r102 - r103;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L12;
        int r106 = r103 + r105;
        ((BlockEditPanelMenusModel.BlockEditPanelMenuItem) ListProtector.get(this.f217689q.f217698a, r106)).setVisible(r100);
        this.f217689q.notifyItemChanged(r106);
        r105 = r105 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public final void c(BlockEditPanelMenusModel.BlockEditPanel r100) {
        this.f217691s = r100;
        int r101 = r100.getMenus().size();
        this.f217693u = r101;
        e(r101);
        d r102 = this.f217689q;
        List<BlockEditPanelMenusModel.BlockEditPanelMenuItem> r103 = r100.getMenus();
        ((ArrayList) r102.f217698a).clear();
        if (r103 == null) goto L5;
        ((ArrayList) r102.f217698a).addAll(r103);
    L5:
        r102.notifyDataSetChanged();
        this.f217687o.post(new fy4.a(this));
    }

    public final void e(int r100) {
        int r101 = getMaxSpanCount();
        if (r100 <= 0) goto L10;
        if (r100 > r101) goto L6;
        this.f217688p.setSpanCount(r100);
        return;
    L6:
        a r102 = this.f217688p;
        if (r100 != 6) goto L9;
        r101 = 4;
    L9:
        r102.setSpanCount(r101);
        return;
    L10:
        tt5.a.d("BaseBlockEditPanel", "Span count should be at least 1. Provided 0");
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        e(this.f217693u);
        a r101 = this.f217688p;
        if (r101 == null) goto L5;
        r101.requestLayout();
    L5:
        RecyclerView r102 = this.f217687o;
        if (r102 == null) goto L9;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        r103.height = -2;
        this.f217687o.setLayoutParams(r103);
        return;
    }

    public BlockMenuPanel(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public BlockMenuPanel(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f217692t = new ArrayList();
        this.f217694v = 0;
        setPadding(0, 0, 0, 0);
    }
}
