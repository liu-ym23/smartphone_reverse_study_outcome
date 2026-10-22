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
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.bear.sheet.panel.oppanel.OperationEnum;
import com.bytedance.ee.bear.widgets.t;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.ss.android.lark.utils.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetListItemView extends LinearLayout implements com.bytedance.ee.bear.sheet.panel.panelcell.a {
    public com.bytedance.ee.bear.sheet.panel.panelcell.a.InterfaceC0179a a;
    public final boolean b;
    public final boolean c;
    public View d;
    public TextView e;
    public ImageView f;
    public UDBadgeView g;
    public ImageView h;
    public ImageView i;
    public UDSwitch j;
    public final Drawable k;
    public final Drawable l;
    public final GroupPosition m;
    public SheetItem n;

    public static final enum GroupPosition extends Enum<GroupPosition> {
        public static final GroupPosition BOTTOM = null;
        public static final GroupPosition CENTER = null;
        public static final GroupPosition NONE = null;
        public static final GroupPosition SINGLE = null;
        public static final GroupPosition TOP = null;
        public static final /* synthetic */ GroupPosition[] a = null;
        private int value;

        static {
            GroupPosition r0 = new GroupPosition("SINGLE", 0, 0);
            SINGLE = r0;
            GroupPosition r1 = new GroupPosition("TOP", 1, 1);
            TOP = r1;
            GroupPosition r3 = new GroupPosition("CENTER", 2, 2);
            CENTER = r3;
            GroupPosition r5 = new GroupPosition("BOTTOM", 3, 3);
            BOTTOM = r5;
            GroupPosition r7 = new GroupPosition("NONE", 4, 4);
            NONE = r7;
            a = new GroupPosition[]{r0, r1, r3, r5, r7};
        }

        public static GroupPosition[] values() {
            return (GroupPosition[]) a.clone();
        }

        public static /* synthetic */ int access$000(GroupPosition r0) {
            return r0.value;
        }

        public static GroupPosition valueOf(String r1) {
            return (GroupPosition) r27.a.a(GroupPosition.class, r1);
        }

        public GroupPosition(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public class a extends t {
        public final /* synthetic */ SheetItem c;
        public final /* synthetic */ SheetListItemView d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r3) {
            com.bytedance.ee.bear.sheet.panel.panelcell.a.InterfaceC0179a r4 = this.d.a;
            if (r4 == null) goto L6;
            r4.a(this.c.getId(), null);
            return;
        }

        public a(SheetListItemView r1, SheetItem r2) {
            this.d = r1;
            this.c = r2;
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[SheetItem.GroupPosition.values().length];
            b = r0;
            r0[SheetItem.GroupPosition.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            b[SheetItem.GroupPosition.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L27:
            b[SheetItem.GroupPosition.BOTTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            int[] r3 = new int[GroupPosition.values().length];
            a = r3;
            r3[GroupPosition.SINGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L33:
            a[GroupPosition.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L21:
            a[GroupPosition.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L25:
            a[GroupPosition.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    public void b() {
        this.d = findViewById(2131378133);
        this.e = (TextView) findViewById(2131378145);
        this.f = (ImageView) findViewById(2131378137);
        this.h = (ImageView) findViewById(2131378139);
        this.g = findViewById(2131378131);
        this.j = findViewById(2131378143);
        setShowDivider(this.b);
        setIcon(this.k);
        setShowNext(this.c);
        setIndicator(this.l);
    }

    public SheetListItemView(Context r2) {
        this(r2, null);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.a
    public final void a(boolean r2) {
        UDBadgeView r0 = this.g;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r1) {
        return super.onTouchEvent(r1);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.a
    public void setClickListener(com.bytedance.ee.bear.sheet.panel.panelcell.a.InterfaceC0179a r1) {
        this.a = r1;
    }

    public void setIcon(Drawable r3) {
        ImageView r0 = this.f;
        if (r0 == null) goto L11;
        if (r3 == null) goto L6;
        int r1 = 0;
    L7:
        r0.setVisibility(r1);
        if (r3 == null) goto L12;
        this.f.setImageDrawable(r3);
        return;
    L12:
        return;
    L6:
        r1 = 8;
        goto L7
    }

    public void setIndicator(Drawable r3) {
        ImageView r0 = (ImageView) findViewById(2131378138);
        this.i = r0;
        if (r0 == null) goto L11;
        if (r3 == null) goto L6;
        int r1 = 0;
    L7:
        r0.setVisibility(r1);
        if (r3 == null) goto L12;
        this.i.setImageDrawable(r3);
        return;
    L12:
        return;
    L6:
        r1 = 8;
        goto L7
    }

    public void setNextIcon(Drawable r2) {
        ImageView r0 = this.h;
        if (r0 == null) goto L7;
        if (r2 == null) goto L8;
        r0.setImageDrawable(r2);
        return;
    L8:
        return;
    }

    public void setShowDivider(boolean r2) {
        View r0 = findViewById(2131378134);
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    public void setShowNext(boolean r2) {
        ImageView r0 = this.h;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    public void update(SheetItem r6) {
        this.e.setText(r6.getTitle());
        if (r6.isEnable() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        TextView r1 = this.e;
        Resources r2 = getResources();
        if (r0 == false) goto L11;
        int r3 = 2131105858;
    L12:
        r1.setTextColor(r2.getColor(r3));
        int r4 = 2131105855;
        if (y0.a(OperationEnum.myAiDataInsight.name(), r6.getId()) == false) goto L15;
        this.f.setImageTintList(null);
    L20:
        ImageView r5 = this.h;
        Resources r7 = getResources();
        if (r0 == false) goto L23;
        r4 = 2131106620;
    L23:
        r5.setImageTintList(r7.getColorStateList(r4));
        c(r6.getGroupPosition(), r0);
        setOnClickListener(new a(this, r6));
        return;
    L15:
        ImageView r8 = this.f;
        Resources r9 = getResources();
        if (r0 == false) goto L18;
        int r10 = 2131105856;
    L19:
        r8.setImageTintList(r9.getColorStateList(r10));
        goto L20
    L18:
        r10 = 2131105855;
        goto L19
    L11:
        r3 = 2131105857;
        goto L12
    L5:
        if (r6.isAdminLimit() == true) goto L7;
        r0 = true;
        goto L8
    }

    public SheetListItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public void c(SheetItem.GroupPosition r9, boolean r10) {
        GroupPosition r0 = this.m;
        if (r0 == GroupPosition.NONE) goto L15;
        int r1 = b.a[r0.ordinal()];
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L13;
        if (r1 != 3) goto L9;
        r9 = SheetItem.GroupPosition.CENTER;
        goto L15
    L9:
        if (r1 != 4) goto L15;
        r9 = SheetItem.GroupPosition.BOTTOM;
        goto L15
    L13:
        r9 = SheetItem.GroupPosition.TOP;
        goto L15
    L14:
        r9 = SheetItem.GroupPosition.SINGLE;
    L15:
        int r2 = getResources().getColor(2131105864);
        int r3 = getResources().getDimensionPixelSize(2131169382);
        if (r10 == false) goto L18;
        ColorStateList r11 = getResources().getColorStateList(2131105859);
    L19:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
        int r6 = getResources().getDimensionPixelSize(2131168369);
        int r12 = b.b[r9.ordinal()];
        if (r12 == 1) goto L26;
        if (r12 == 2) goto L25;
        if (r12 == 3) goto L24;
        this.d.setBackground(lp5.a.b(r2, r3, r11));
        r5.setMargins(0, r6, 0, r6);
        setShowDivider(false);
    L27:
        this.d.setLayoutParams(r5);
        return;
    L24:
        this.d.setBackground(lp5.a.a(r2, r3, r11));
        r5.setMargins(0, 0, 0, r6);
        setShowDivider(false);
        goto L27
    L25:
        this.d.setBackground(lp5.a.e(r2, r11));
        r5.setMargins(0, 0, 0, 0);
        setShowDivider(true);
        goto L27
    L26:
        this.d.setBackground(lp5.a.g(r2, r3, r11));
        r5.setMargins(0, r6, 0, 0);
        setShowDivider(true);
        goto L27
    L18:
        r11 = null;
        goto L19
    }

    public final void d(SheetItem r4, CompoundButton.OnCheckedChangeListener r5) {
        if (this.j != null) goto L7;
        this.n = r4;
        return;
    L7:
        if ("switch".equals(r4.getType()) == false) goto L13;
        this.j.setVisibility(0);
        SheetItem r0 = this.n;
        if (r0 != null) goto L11;
    L12:
        tt5.a.b("SheetListItemView", "setShowSwitch(), sheetItem.getValue() = " + r4.getValue() + ", setShowSwitch: " + r4);
        this.j.setOnCheckedChangeListener(null);
        this.j.setChecked(y0.a("1", r4.getValue()));
        this.j.setOnCheckedChangeListener(r5);
    L14:
        this.n = r4;
        return;
    L11:
        if (y0.a(r0.getValue(), r4.getValue()) == true) goto L14;
    L13:
        this.j.setVisibility(8);
        goto L14
    }

    public SheetListItemView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        TypedArray r5 = r2.obtainStyledAttributes(r3, new int[]{2130970134, 2130974068, 2130974069, 2130974070, 2130974071});
        if (r5 == null) goto L5;
        this.b = r5.getBoolean(1, false);
        this.c = r5.getBoolean(4, false);
        this.k = r5.getDrawable(2);
        this.l = r5.getDrawable(3);
        int r6 = r5.getInt(0, GroupPosition.access$000(GroupPosition.NONE));
        this.m = GroupPosition.values()[r6];
        r5.recycle();
    L5:
        LayoutInflater.from(getContext()).inflate(2131564577, this, true);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        b();
    }
}
