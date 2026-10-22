package com.bytedance.ee.bear.doc.blockeditpanel.view.panel.toolbatmenu;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.doc.blockeditpanel.model.EMenuItemButtonType;
import com.bytedance.ee.bear.doc.blockeditpanel.model.EMenuItemConfig;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import iy4.d;
import iy4.e;
import iy4.f;
import iy4.g;
import iy4.h;
import iy4.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ToolbarMenuPanel extends BaseBlockEditPanel {
    public static final int A = 0;
    public static final int B = 0;
    public static final int C = 0;
    public static final int x = 0;
    public static final int y = 0;
    public static final int z = 0;
    public LinearLayout o;
    public TextBlockMenuItemAdapter p;
    public GroupIconView q;
    public GroupIconView r;
    public GroupIconView s;
    public GroupIconView t;
    public GroupIconView u;
    public HighlightView v;
    public h w;

    public class a extends RecyclerView.ItemDecoration {
        public final /* synthetic */ ToolbarMenuPanel a;

        public a(ToolbarMenuPanel r1) {
            this.a = r1;
        }

        public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
            int r5 = r3.getChildAdapterPosition(r2);
            BlockEditPanelMenusModel.BlockEditPanelMenuItem r6 = (BlockEditPanelMenusModel.BlockEditPanelMenuItem) ListProtector.get(this.a.p.c, r5);
            r1.top = 0;
            r1.bottom = 0;
            if (r5 != 0) goto L10;
            r1.left = 0;
            if (r6 != null) goto L7;
        L9:
            r1.right = 0;
            return;
        L7:
            if (EMenuItemButtonType.HEADING_BUTTON_GROUP.name.equals(r6.getGroupId()) == true) goto L9;
            r1.right = ToolbarMenuPanel.A;
            return;
        L10:
            if (r6 != null) goto L12;
        L14:
            r1.left = ToolbarMenuPanel.z;
            return;
        L12:
            if (EMenuItemButtonType.HEADING_BUTTON_GROUP.name.equals(r6.getGroupId()) == false) goto L14;
            r1.left = ToolbarMenuPanel.C;
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[EMenuItemConfig.values().length];
            a = r0;
            r0[EMenuItemConfig.TEXT_BLOCK_TRANSFORM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            a[EMenuItemConfig.TEXT_TRANSFORM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            a[EMenuItemConfig.INLINE_CODE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            a[EMenuItemConfig.HIGHLIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            a[EMenuItemConfig.INDENT_TRANSFORM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            a[EMenuItemConfig.ALIGN_TRANSFORM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            a[EMenuItemConfig.BLOCK_BACKGROUND.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    static {
        x = n.d(80);
        y = n.d(8);
        z = n.d(4);
        A = n.d(3);
        B = n.d(48);
        C = n.d(1);
    }

    public static LinearLayout.LayoutParams e() {
        return new LinearLayout.LayoutParams(-2, B);
    }

    public final LinearLayout d() {
        LinearLayout r0 = new LinearLayout(getContext());
        r0.setOrientation(0);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, -2);
        r1.bottomMargin = y;
        this.o.addView(r0, r1);
        return r0;
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public View getContentView() {
        if (this.o != null) goto L5;
        LinearLayout r0 = new LinearLayout(getContext());
        this.o = r0;
        r0.setOrientation(1);
        RecyclerView r1 = new RecyclerView(getContext());
        r1.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        r1.setHorizontalFadingEdgeEnabled(true);
        r1.setFadingEdgeLength(x);
        TextBlockMenuItemAdapter r2 = new TextBlockMenuItemAdapter();
        this.p = r2;
        r1.setAdapter(r2);
        r1.addItemDecoration(new a(this));
        int r3 = y;
        r1.setPadding(r3, 0, r3, 0);
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-1, B);
        r4.bottomMargin = r3;
        this.o.addView(r1, r4);
        LinearLayout r5 = d();
        LinearLayout.LayoutParams r6 = e();
        int r7 = z;
        r6.rightMargin = r7;
        r6.leftMargin = r3;
        GroupIconView r8 = new GroupIconView(getContext());
        this.q = r8;
        r5.addView(r8, r6);
        LinearLayout.LayoutParams r9 = e();
        r9.rightMargin = r7;
        GroupIconView r10 = new GroupIconView(getContext());
        this.r = r10;
        r5.addView(r10, r9);
        LinearLayout.LayoutParams r11 = e();
        HighlightView r12 = new HighlightView(getContext());
        this.v = r12;
        r5.addView(r12, r11);
        this.v.setVisibility(8);
        LinearLayout.LayoutParams r13 = e();
        r13.rightMargin = r7;
        GroupIconView r14 = new GroupIconView(getContext());
        this.u = r14;
        r5.addView(r14, r13);
        this.u.setVisibility(8);
        LinearLayout r16 = d();
        LinearLayout.LayoutParams r17 = e();
        r17.rightMargin = r7;
        r17.leftMargin = r3;
        GroupIconView r18 = new GroupIconView(getContext());
        this.s = r18;
        r16.addView(r18, r17);
        LinearLayout.LayoutParams r19 = e();
        GroupIconView r20 = new GroupIconView(getContext());
        this.t = r20;
        r16.addView(r20, r19);
    L5:
        this.o.post(new e(this));
        h r21 = new h(this);
        this.w = r21;
        this.p.b = r21;
        this.q.setOnClickMenuItemListener(r21);
        this.r.setOnClickMenuItemListener(this.w);
        this.s.setOnClickMenuItemListener(this.w);
        this.t.setOnClickMenuItemListener(this.w);
        i r22 = new i(this);
        this.v.setOnClickHighlightItemListener(r22);
        this.u.setOnClickMenuItemListener(this.w);
        l.b(this.o, 2131100557);
        return this.o;
    }

    public ToolbarMenuPanel(Context r2) {
        this(r2, null);
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public final void c(BlockEditPanelMenusModel.BlockEditPanel r4) {
        Iterator<BlockEditPanelMenusModel.BlockEditPanelMenuItem> r5 = r4.getMenus().iterator();
    L4:
        if (r5.hasNext() == false) goto L18;
        BlockEditPanelMenusModel.BlockEditPanelMenuItem r0 = r5.next();
        EMenuItemConfig r1 = EMenuItemConfig.getMenuItemConfigById(r0.getId());
        switch(b.a[r1.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L4;
        };
    L8:
        this.u.setVisibility(0);
        this.u.setMenuItems(Collections.singletonList(r0));
        this.o.post(new g(this));
        goto L4
    L9:
        this.t.setMenuItems(r0.getMembers());
        goto L4
    L10:
        this.s.setMenuItems(r0.getMembers());
        goto L4
    L11:
        this.v.setVisibility(0);
        this.v.setMenuItem(r0);
        this.o.post(new f(this));
        goto L4
    L12:
        this.r.setMenuItems(Collections.singletonList(r0));
        goto L4
    L13:
        this.q.setMenuItems(r0.getMembers());
        goto L4
    L14:
        TextBlockMenuItemAdapter r2 = this.p;
        List<BlockEditPanelMenusModel.BlockEditPanelMenuItem> r3 = r0.getMembers();
        ((ArrayList) r2.c).clear();
        if (r3 == null) goto L17;
        ((ArrayList) r2.c).addAll(r3);
    L17:
        r2.notifyDataSetChanged();
        goto L4
    }

    public final void f(boolean r4) {
        int r0 = ((getMeasuredWidth() - (n.d(8) * 4)) - (n.d(4) * 2)) - (C * 3);
        if (r4 == false) goto L5;
        int r5 = n.d(32);
    L6:
        int r1 = (r0 - r5) / 6;
        final TextBlockMenuItemAdapter r6 = this.p;
        r6.a = r1;
        j.c(new d(r6));
        this.q.setIconWidth(r1);
        this.t.setIconWidth(r1);
        this.s.setIconWidth(r1);
        this.r.setIconWidth(r1);
        this.v.setIconWidth(r1);
        this.u.setIconWidth(r1);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    public ToolbarMenuPanel(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ToolbarMenuPanel(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
