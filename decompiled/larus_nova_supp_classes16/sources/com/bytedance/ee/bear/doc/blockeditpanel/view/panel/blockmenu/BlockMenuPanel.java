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
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BlockMenuPanel extends BaseBlockEditPanel {
    public static final int w = 0;
    public static final int x = 0;
    public static final int y = 0;
    public RecyclerView o;
    public a p;
    public d q;
    public c r;
    public BlockEditPanelMenusModel.BlockEditPanel s;
    public final List<String> t;
    public int u;
    public int v;

    public class a extends GridLayoutManager {
        public final /* synthetic */ BlockMenuPanel a;

        public final void onLayoutChildren(RecyclerView.Recycler r3, RecyclerView.State r4) {
            super.onLayoutChildren(r3, r4);
            BlockMenuPanel r0 = this.a;
            r0.v = r0.p.getRowCountForAccessibility(r3, r4);
        }

        public a(BlockMenuPanel r1, Context r2, int r3) {
            this.a = r1;
            super(r2, r3);
        }
    }

    public class b extends RecyclerView.ItemDecoration {
        public final /* synthetic */ BlockMenuPanel a;

        public b(BlockMenuPanel r1) {
            this.a = r1;
        }

        public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
            int r5 = this.a.p.getSpanCount();
            if ((r3.getChildLayoutPosition(r2) % r5) == 0) goto L6;
            r1.left = BlockMenuPanel.y;
            return;
        }
    }

    public class c implements dy4.b {
        public final /* synthetic */ BlockMenuPanel a;

        public c(BlockMenuPanel r1) {
            this.a = r1;
        }

        @Override // dy4.b
        public final void a(BlockEditPanelMenusModel.BlockEditPanelMenuItem r3) {
            List<String> r0 = this.a.t;
            ArrayList r1 = (ArrayList) r0;
            if (r1.contains(r3.getId()) == false) goto L7;
            BlockMenuPanel r2 = this.a;
            BlockEditPanelMenusModel.BlockEditPanel r4 = r2.s;
            if (r4 == null) goto L7;
            r2.d(r4, r3);
        L7:
            this.a.e.onClickEditMenuItem(r3);
        }
    }

    public class d extends RecyclerView.Adapter<BaseBlockEditMenuViewHolder> {
        public final List<BlockEditPanelMenusModel.BlockEditPanelMenuItem> a;
        public final /* synthetic */ BlockMenuPanel b;

        public final int getItemCount() {
            return ((ArrayList) this.a).size();
        }

        public d(BlockMenuPanel r1) {
            this.b = r1;
            this.a = new ArrayList();
        }

        public final int getItemViewType(int r2) {
            BlockEditPanelMenusModel.BlockEditPanelMenuItem r3 = (BlockEditPanelMenusModel.BlockEditPanelMenuItem) ListProtector.get(this.a, r2);
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
            if (r3 >= 0) goto L5;
            return;
        L5:
            if (r3 >= ((ArrayList) this.a).size()) goto L10;
            r4.U3((BlockEditPanelMenusModel.BlockEditPanelMenuItem) ListProtector.get(this.a, r3));
            return;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Context r0 = r4.getContext();
            EMenuItemButtonType r6 = EMenuItemButtonType.getEMenuItemButtonTypeByOrdinal(r5);
            switch(jy4.a.a[r6.ordinal()]) {
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
            BaseBlockEditMenuViewHolder r7 = new jy4.b(LayoutInflater.from(r0).inflate(2131560068, r4, false));
        L9:
            r7.a = this.b.r;
            return r7;
        L5:
            r7 = new IconViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131560067, r4, false));
            goto L9
        L6:
            r7 = new jy4.b(LayoutInflater.from(r0).inflate(2131560068, r4, false));
            goto L9
        L7:
            r7 = new IconViewHolder(LayoutInflater.from(r0).inflate(2131560071, r4, false));
            goto L9
        L8:
            r7 = new DividerViewHolder(LayoutInflater.from(r0).inflate(2131560065, r4, false));
            goto L9
        }
    }

    public void d(BlockEditPanelMenusModel.BlockEditPanel r1, BlockEditPanelMenusModel.BlockEditPanelMenuItem r2) {
    }

    static {
        w = n.d(8);
        x = n.d(4);
        y = n.d(1);
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public final ViewGroup.LayoutParams b() {
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -2);
        int r1 = w;
        r0.leftMargin = r1;
        r0.rightMargin = r1;
        r0.bottomMargin = r1;
        return r0;
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public View getContentView() {
        if (this.o != null) goto L6;
        this.o = new RecyclerView(getContext());
        a r0 = new a(this, getContext(), getMaxSpanCount());
        this.p = r0;
        this.o.setLayoutManager(r0);
        this.o.setNestedScrollingEnabled(false);
        d r1 = new d(this);
        this.q = r1;
        this.o.setAdapter(r1);
        this.o.addItemDecoration(new b(this));
        this.r = new c(this);
    L6:
        return this.o;
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public int getPanelHeight() {
        RecyclerView r0 = this.o;
        int r1 = 0;
        if (r0 != null) goto L5;
    L14:
        return 0;
    L5:
        if (r0.getChildCount() <= 0) goto L14;
        int r2 = this.o.getChildCount();
        if (r2 != 0) goto L9;
        return 0;
    L9:
        int r3 = this.p.getSpanCount();
        int r4 = 0;
    L10:
        if (r1 >= r2) goto L12;
        r4 = r4 + this.o.getChildAt(r1).getHeight();
        r1 = r1 + r3;
        goto L10
    L12:
        int r5 = r4 + (x * this.v);
        tt5.a.h("BaseBlockEditPanel", "getPanelHeight:" + r5 + ", recyclerView:" + this.o.getHeight());
        return r5;
    }

    private int getMaxSpanCount() {
        Resources r0 = getContext().getResources();
        if (r0 == null) goto L10;
        Configuration r1 = r0.getConfiguration();
        if (r1 == null) goto L10;
        if (2 != r1.orientation) goto L10;
        return 6;
    L10:
        return 5;
    }

    public BlockMenuPanel(Context r2) {
        this(r2, null);
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public final void a(boolean r6) {
        if (this.o == null) goto L9;
        d r0 = this.q;
        if (r0 == null) goto L11;
        int r1 = ((ArrayList) r0.a).size();
        int r2 = getMaxSpanCount() * 2;
        int r3 = r1 - r2;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L12;
        int r5 = r2 + r4;
        ((BlockEditPanelMenusModel.BlockEditPanelMenuItem) ListProtector.get(this.q.a, r5)).setVisible(r6);
        this.q.notifyItemChanged(r5);
        r4 = r4 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public final void c(BlockEditPanelMenusModel.BlockEditPanel r3) {
        this.s = r3;
        int r0 = r3.getMenus().size();
        this.u = r0;
        e(r0);
        d r1 = this.q;
        List<BlockEditPanelMenusModel.BlockEditPanelMenuItem> r4 = r3.getMenus();
        ((ArrayList) r1.a).clear();
        if (r4 == null) goto L5;
        ((ArrayList) r1.a).addAll(r4);
    L5:
        r1.notifyDataSetChanged();
        this.o.post(new fy4.a(this));
    }

    public final void e(int r4) {
        int r0 = getMaxSpanCount();
        if (r4 <= 0) goto L10;
        if (r4 > r0) goto L6;
        this.p.setSpanCount(r4);
        return;
    L6:
        a r1 = this.p;
        if (r4 != 6) goto L9;
        r0 = 4;
    L9:
        r1.setSpanCount(r0);
        return;
    L10:
        tt5.a.d("BaseBlockEditPanel", "Span count should be at least 1. Provided 0");
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        e(this.u);
        a r3 = this.p;
        if (r3 == null) goto L5;
        r3.requestLayout();
    L5:
        RecyclerView r4 = this.o;
        if (r4 == null) goto L9;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        r5.height = -2;
        this.o.setLayoutParams(r5);
        return;
    }

    public BlockMenuPanel(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public BlockMenuPanel(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.t = new ArrayList();
        this.v = 0;
        setPadding(0, 0, 0, 0);
    }
}
