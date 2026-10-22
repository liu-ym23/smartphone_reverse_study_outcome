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
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes16.dex */
public class ToolbarMenuPanel extends BaseBlockEditPanel {
    public static final int A = 0;
    public static final int B = 0;
    public static final int C = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f217732x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f217733y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f217734z = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LinearLayout f217735o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextBlockMenuItemAdapter f217736p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public GroupIconView f217737q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public GroupIconView f217738r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public GroupIconView f217739s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public GroupIconView f217740t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public GroupIconView f217741u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public HighlightView f217742v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public h f217743w;

    public class a extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolbarMenuPanel f217744a;

        public a(ToolbarMenuPanel r100) {
            this.f217744a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            int r104 = r102.getChildAdapterPosition(r101);
            BlockEditPanelMenusModel.BlockEditPanelMenuItem r105 = (BlockEditPanelMenusModel.BlockEditPanelMenuItem) ListProtector.get(this.f217744a.f217736p.f217731c, r104);
            r100.top = 0;
            r100.bottom = 0;
            if (r104 != 0) goto L10;
            r100.left = 0;
            if (r105 != null) goto L7;
        L9:
            r100.right = 0;
            return;
        L7:
            if (EMenuItemButtonType.HEADING_BUTTON_GROUP.name.equals(r105.getGroupId()) == true) goto L9;
            r100.right = ToolbarMenuPanel.A;
            return;
        L10:
            if (r105 != null) goto L12;
        L14:
            r100.left = ToolbarMenuPanel.f217734z;
            return;
        L12:
            if (EMenuItemButtonType.HEADING_BUTTON_GROUP.name.equals(r105.getGroupId()) == false) goto L14;
            r100.left = ToolbarMenuPanel.C;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f217745a = null;

        static {
            int[] r100 = new int[EMenuItemConfig.values().length];
            f217745a = r100;
            r100[EMenuItemConfig.TEXT_BLOCK_TRANSFORM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f217745a[EMenuItemConfig.TEXT_TRANSFORM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f217745a[EMenuItemConfig.INLINE_CODE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f217745a[EMenuItemConfig.HIGHLIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f217745a[EMenuItemConfig.INDENT_TRANSFORM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f217745a[EMenuItemConfig.ALIGN_TRANSFORM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f217745a[EMenuItemConfig.BLOCK_BACKGROUND.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    static {
        f217732x = n.d(80);
        f217733y = n.d(8);
        f217734z = n.d(4);
        A = n.d(3);
        B = n.d(48);
        C = n.d(1);
    }

    public static LinearLayout.LayoutParams e() {
        return new LinearLayout.LayoutParams(-2, B);
    }

    public final LinearLayout d() {
        LinearLayout r100 = new LinearLayout(getContext());
        r100.setOrientation(0);
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(-1, -2);
        r101.bottomMargin = f217733y;
        this.f217735o.addView(r100, r101);
        return r100;
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public View getContentView() {
        if (this.f217735o != null) goto L5;
        LinearLayout r100 = new LinearLayout(getContext());
        this.f217735o = r100;
        r100.setOrientation(1);
        RecyclerView r101 = new RecyclerView(getContext());
        r101.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        r101.setHorizontalFadingEdgeEnabled(true);
        r101.setFadingEdgeLength(f217732x);
        TextBlockMenuItemAdapter r102 = new TextBlockMenuItemAdapter();
        this.f217736p = r102;
        r101.setAdapter(r102);
        r101.addItemDecoration(new a(this));
        int r103 = f217733y;
        r101.setPadding(r103, 0, r103, 0);
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-1, B);
        r104.bottomMargin = r103;
        this.f217735o.addView(r101, r104);
        LinearLayout r105 = d();
        LinearLayout.LayoutParams r106 = e();
        int r107 = f217734z;
        r106.rightMargin = r107;
        r106.leftMargin = r103;
        GroupIconView r108 = new GroupIconView(getContext());
        this.f217737q = r108;
        r105.addView(r108, r106);
        LinearLayout.LayoutParams r109 = e();
        r109.rightMargin = r107;
        GroupIconView r110 = new GroupIconView(getContext());
        this.f217738r = r110;
        r105.addView(r110, r109);
        LinearLayout.LayoutParams r111 = e();
        HighlightView r112 = new HighlightView(getContext());
        this.f217742v = r112;
        r105.addView(r112, r111);
        this.f217742v.setVisibility(8);
        LinearLayout.LayoutParams r113 = e();
        r113.rightMargin = r107;
        GroupIconView r114 = new GroupIconView(getContext());
        this.f217741u = r114;
        r105.addView(r114, r113);
        this.f217741u.setVisibility(8);
        LinearLayout r115 = d();
        LinearLayout.LayoutParams r116 = e();
        r116.rightMargin = r107;
        r116.leftMargin = r103;
        GroupIconView r117 = new GroupIconView(getContext());
        this.f217739s = r117;
        r115.addView(r117, r116);
        LinearLayout.LayoutParams r118 = e();
        GroupIconView r119 = new GroupIconView(getContext());
        this.f217740t = r119;
        r115.addView(r119, r118);
    L5:
        this.f217735o.post(new e(this));
        h r120 = new h(this);
        this.f217743w = r120;
        this.f217736p.f217730b = r120;
        this.f217737q.setOnClickMenuItemListener(r120);
        this.f217738r.setOnClickMenuItemListener(this.f217743w);
        this.f217739s.setOnClickMenuItemListener(this.f217743w);
        this.f217740t.setOnClickMenuItemListener(this.f217743w);
        i r121 = new i(this);
        this.f217742v.setOnClickHighlightItemListener(r121);
        this.f217741u.setOnClickMenuItemListener(this.f217743w);
        l.b(this.f217735o, R.color.bg_float);
        return this.f217735o;
    }

    public ToolbarMenuPanel(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public final void c(BlockEditPanelMenusModel.BlockEditPanel r100) {
        Iterator<BlockEditPanelMenusModel.BlockEditPanelMenuItem> r101 = r100.getMenus().iterator();
    L4:
        if (r101.hasNext() == false) goto L18;
        BlockEditPanelMenusModel.BlockEditPanelMenuItem r102 = r101.next();
        EMenuItemConfig r103 = EMenuItemConfig.getMenuItemConfigById(r102.getId());
        switch(b.f217745a[r103.ordinal()]) {
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
        this.f217741u.setVisibility(0);
        this.f217741u.setMenuItems(Collections.singletonList(r102));
        this.f217735o.post(new g(this));
        goto L4
    L9:
        this.f217740t.setMenuItems(r102.getMembers());
        goto L4
    L10:
        this.f217739s.setMenuItems(r102.getMembers());
        goto L4
    L11:
        this.f217742v.setVisibility(0);
        this.f217742v.setMenuItem(r102);
        this.f217735o.post(new f(this));
        goto L4
    L12:
        this.f217738r.setMenuItems(Collections.singletonList(r102));
        goto L4
    L13:
        this.f217737q.setMenuItems(r102.getMembers());
        goto L4
    L14:
        TextBlockMenuItemAdapter r104 = this.f217736p;
        List<BlockEditPanelMenusModel.BlockEditPanelMenuItem> r105 = r102.getMembers();
        ((ArrayList) r104.f217731c).clear();
        if (r105 == null) goto L17;
        ((ArrayList) r104.f217731c).addAll(r105);
    L17:
        r104.notifyDataSetChanged();
        goto L4
    }

    public final void f(boolean r100) {
        int r101 = ((getMeasuredWidth() - (n.d(8) * 4)) - (n.d(4) * 2)) - (C * 3);
        if (r100 == false) goto L5;
        int r102 = n.d(32);
    L6:
        int r103 = (r101 - r102) / 6;
        final TextBlockMenuItemAdapter r104 = this.f217736p;
        r104.f217729a = r103;
        j.c(new d(r104));
        this.f217737q.setIconWidth(r103);
        this.f217740t.setIconWidth(r103);
        this.f217739s.setIconWidth(r103);
        this.f217738r.setIconWidth(r103);
        this.f217742v.setIconWidth(r103);
        this.f217741u.setIconWidth(r103);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public ToolbarMenuPanel(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public ToolbarMenuPanel(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
