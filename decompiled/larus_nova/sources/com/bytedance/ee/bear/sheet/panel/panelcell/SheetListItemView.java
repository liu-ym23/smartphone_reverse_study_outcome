package com.bytedance.ee.bear.sheet.panel.panelcell;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.bear.sheet.panel.oppanel.OperationEnum;
import com.bytedance.ee.bear.widgets.t;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larus.nova.R;
import com.ss.android.lark.utils.y0;

/* JADX INFO: loaded from: classes18.dex */
public class SheetListItemView extends LinearLayout implements com.bytedance.ee.bear.sheet.panel.panelcell.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ee.bear.sheet.panel.panelcell.a.InterfaceC3426a f238264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f238265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f238266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f238267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f238268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f238269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UDBadgeView f238270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f238271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f238272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public UDSwitch f238273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Drawable f238274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Drawable f238275l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final GroupPosition f238276m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SheetItem f238277n;

    public static final enum GroupPosition extends Enum<GroupPosition> {
        public static final GroupPosition BOTTOM = null;
        public static final GroupPosition CENTER = null;
        public static final GroupPosition NONE = null;
        public static final GroupPosition SINGLE = null;
        public static final GroupPosition TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GroupPosition[] f238278a = null;
        private int value;

        static {
            GroupPosition r100 = new GroupPosition("SINGLE", 0, 0);
            SINGLE = r100;
            GroupPosition r101 = new GroupPosition("TOP", 1, 1);
            TOP = r101;
            GroupPosition r102 = new GroupPosition("CENTER", 2, 2);
            CENTER = r102;
            GroupPosition r103 = new GroupPosition("BOTTOM", 3, 3);
            BOTTOM = r103;
            GroupPosition r104 = new GroupPosition(UserProfileEvent.POSITION_NONE, 4, 4);
            NONE = r104;
            f238278a = new GroupPosition[]{r100, r101, r102, r103, r104};
        }

        public static GroupPosition[] values() {
            return (GroupPosition[]) f238278a.clone();
        }

        public static /* synthetic */ int access$000(GroupPosition r100) {
            return r100.value;
        }

        public static GroupPosition valueOf(String r100) {
            return (GroupPosition) r27.a.a(GroupPosition.class, r100);
        }

        public GroupPosition(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SheetItem f238279c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SheetListItemView f238280d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            com.bytedance.ee.bear.sheet.panel.panelcell.a.InterfaceC3426a r101 = this.f238280d.f238264a;
            if (r101 == null) goto L6;
            r101.a(this.f238279c.getId(), null);
            return;
        }

        public a(SheetListItemView r100, SheetItem r101) {
            this.f238280d = r100;
            this.f238279c = r101;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f238281a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f238282b = null;

        static {
            int[] r100 = new int[SheetItem.GroupPosition.values().length];
            f238282b = r100;
            r100[SheetItem.GroupPosition.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            f238282b[SheetItem.GroupPosition.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L27:
            f238282b[SheetItem.GroupPosition.BOTTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            int[] r101 = new int[GroupPosition.values().length];
            f238281a = r101;
            r101[GroupPosition.SINGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L33:
            f238281a[GroupPosition.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L21:
            f238281a[GroupPosition.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L25:
            f238281a[GroupPosition.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    public void b() {
        this.f238267d = findViewById(R.id.list_item_container);
        this.f238268e = (TextView) findViewById(R.id.list_item_title);
        this.f238269f = (ImageView) findViewById(R.id.list_item_icon);
        this.f238271h = (ImageView) findViewById(R.id.list_item_next);
        this.f238270g = (UDBadgeView) findViewById(R.id.list_item_badge);
        this.f238273j = (UDSwitch) findViewById(R.id.list_item_switch);
        setShowDivider(this.f238265b);
        setIcon(this.f238274k);
        setShowNext(this.f238266c);
        setIndicator(this.f238275l);
    }

    public SheetListItemView(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.a
    public final void a(boolean r100) {
        UDBadgeView r101 = this.f238270g;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.a
    public void setClickListener(com.bytedance.ee.bear.sheet.panel.panelcell.a.InterfaceC3426a r100) {
        this.f238264a = r100;
    }

    public void setIcon(Drawable r100) {
        ImageView r101 = this.f238269f;
        if (r101 == null) goto L11;
        if (r100 == null) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        if (r100 == null) goto L12;
        this.f238269f.setImageDrawable(r100);
        return;
    L12:
        return;
    L6:
        r102 = 8;
        goto L7
    }

    public void setIndicator(Drawable r100) {
        ImageView r101 = (ImageView) findViewById(R.id.list_item_indicator_icon);
        this.f238272i = r101;
        if (r101 == null) goto L11;
        if (r100 == null) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        if (r100 == null) goto L12;
        this.f238272i.setImageDrawable(r100);
        return;
    L12:
        return;
    L6:
        r102 = 8;
        goto L7
    }

    public void setNextIcon(Drawable r100) {
        ImageView r101 = this.f238271h;
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.setImageDrawable(r100);
        return;
    L8:
        return;
    }

    public void setShowDivider(boolean r100) {
        View r101 = findViewById(R.id.list_item_divider);
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    public void setShowNext(boolean r100) {
        ImageView r101 = this.f238271h;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    public void update(SheetItem r100) {
        this.f238268e.setText(r100.getTitle());
        if (r100.isEnable() == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        TextView r102 = this.f238268e;
        Resources r103 = getResources();
        if (r101 == false) goto L11;
        int r104 = R.color.sheet_item_text_normal;
    L12:
        r102.setTextColor(r103.getColor(r104));
        boolean r105 = y0.a(OperationEnum.myAiDataInsight.name(), r100.getId());
        int r106 = R.color.sheet_item_icon_disable;
        if (r105 == false) goto L15;
        this.f238269f.setImageTintList(null);
    L20:
        ImageView r107 = this.f238271h;
        Resources r108 = getResources();
        if (r101 == false) goto L23;
        r106 = R.color.text_placeholder;
    L23:
        r107.setImageTintList(r108.getColorStateList(r106));
        c(r100.getGroupPosition(), r101);
        setOnClickListener(new a(this, r100));
        return;
    L15:
        ImageView r109 = this.f238269f;
        Resources r110 = getResources();
        if (r101 == false) goto L18;
        int r111 = R.color.sheet_item_icon_normal;
    L19:
        r109.setImageTintList(r110.getColorStateList(r111));
        goto L20
    L18:
        r111 = R.color.sheet_item_icon_disable;
        goto L19
    L11:
        r104 = R.color.sheet_item_text_disable;
        goto L12
    L5:
        if (r100.isAdminLimit() == true) goto L7;
        r101 = true;
        goto L8
    }

    public SheetListItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public void c(SheetItem.GroupPosition r100, boolean r110) {
        GroupPosition r101 = this.f238276m;
        if (r101 == GroupPosition.NONE) goto L15;
        int r102 = b.f238281a[r101.ordinal()];
        if (r102 == 1) goto L14;
        if (r102 == 2) goto L13;
        if (r102 != 3) goto L9;
        r100 = SheetItem.GroupPosition.CENTER;
        goto L15
    L9:
        if (r102 != 4) goto L15;
        r100 = SheetItem.GroupPosition.BOTTOM;
        goto L15
    L13:
        r100 = SheetItem.GroupPosition.TOP;
        goto L15
    L14:
        r100 = SheetItem.GroupPosition.SINGLE;
    L15:
        int r103 = getResources().getColor(R.color.sheet_panel_list_item_bg);
        int r104 = getResources().getDimensionPixelSize(R.dimen.ud_radius_l);
        if (r110 == false) goto L18;
        ColorStateList r111 = getResources().getColorStateList(R.color.sheet_list_item_tint_selector);
    L19:
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) this.f238267d.getLayoutParams();
        int r106 = getResources().getDimensionPixelSize(R.dimen.space_kit_len_8);
        int r107 = b.f238282b[r100.ordinal()];
        if (r107 == 1) goto L26;
        if (r107 == 2) goto L25;
        if (r107 == 3) goto L24;
        this.f238267d.setBackground(lp5.a.b(r103, r104, r111));
        r105.setMargins(0, r106, 0, r106);
        setShowDivider(false);
    L27:
        this.f238267d.setLayoutParams(r105);
        return;
    L24:
        this.f238267d.setBackground(lp5.a.a(r103, r104, r111));
        r105.setMargins(0, 0, 0, r106);
        setShowDivider(false);
        goto L27
    L25:
        this.f238267d.setBackground(lp5.a.e(r103, r111));
        r105.setMargins(0, 0, 0, 0);
        setShowDivider(true);
        goto L27
    L26:
        this.f238267d.setBackground(lp5.a.g(r103, r104, r111));
        r105.setMargins(0, r106, 0, 0);
        setShowDivider(true);
        goto L27
    L18:
        r111 = null;
        goto L19
    }

    public final void d(SheetItem r100, CompoundButton.OnCheckedChangeListener r101) {
        if (this.f238273j != null) goto L7;
        this.f238277n = r100;
        return;
    L7:
        if ("switch".equals(r100.getType()) == false) goto L13;
        this.f238273j.setVisibility(0);
        SheetItem r102 = this.f238277n;
        if (r102 != null) goto L11;
    L12:
        tt5.a.b("SheetListItemView", "setShowSwitch(), sheetItem.getValue() = " + r100.getValue() + ", setShowSwitch: " + r100);
        this.f238273j.setOnCheckedChangeListener(null);
        this.f238273j.setChecked(y0.a("1", r100.getValue()));
        this.f238273j.setOnCheckedChangeListener(r101);
    L14:
        this.f238277n = r100;
        return;
    L11:
        if (y0.a(r102.getValue(), r100.getValue()) == true) goto L14;
    L13:
        this.f238273j.setVisibility(8);
        goto L14
    }

    public SheetListItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.forceGroupPosition, R.attr.showListItemDivider, R.attr.showListItemIcon, R.attr.showListItemIndicator, R.attr.showListItemNext});
        if (r103 == null) goto L5;
        this.f238265b = r103.getBoolean(1, false);
        this.f238266c = r103.getBoolean(4, false);
        this.f238274k = r103.getDrawable(2);
        this.f238275l = r103.getDrawable(3);
        int r104 = r103.getInt(0, GroupPosition.access$000(GroupPosition.NONE));
        this.f238276m = GroupPosition.values()[r104];
        r103.recycle();
    L5:
        LayoutInflater.from(getContext()).inflate(R.layout.sheet_panel_list_item, this, true);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        b();
    }
}
