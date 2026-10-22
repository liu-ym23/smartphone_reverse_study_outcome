package com.bytedance.ee.bear.sheet.panel.panelcell;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.util.ui.n;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0019H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/sheet/panel/panelcell/SheetSortItemView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/sheet/panel/panelcell/IPanelCell;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mClickListener", "Lcom/bytedance/ee/bear/sheet/panel/panelcell/IPanelCell$OnClickListener;", "mIcon", "Landroid/widget/ImageView;", "mText", "Landroid/widget/TextView;", "mPosition", "Lcom/bytedance/ee/bear/sheet/panel/panelcell/SheetSortItemView$Position;", "update", "", "item", "Lcom/bytedance/ee/bear/sheet/panel/SheetItem;", "showBadge", "show", "", "setClickListener", "listener", "setBackground", "enable", "Position", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetSortItemView extends FrameLayout implements com.bytedance.ee.bear.sheet.panel.panelcell.a {
    public com.bytedance.ee.bear.sheet.panel.panelcell.a.InterfaceC0179a a;
    public final ImageView b;
    public final TextView c;
    public final Position d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/sheet/panel/panelcell/SheetSortItemView$Position;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LEFT", "RIGHT", "CENTER", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Position extends Enum<Position> {
        public static final Position CENTER = null;
        public static final Position LEFT = null;
        public static final Position RIGHT = null;
        public static final /* synthetic */ Position[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<Position> getEntries() {
            return b;
        }

        static {
            Position r0 = new Position("LEFT", 0, 0);
            LEFT = r0;
            Position r1 = new Position("RIGHT", 1, 1);
            RIGHT = r1;
            Position r3 = new Position("CENTER", 2, 2);
            CENTER = r3;
            Position[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static Position[] values() {
            return (Position[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Position valueOf(String r1) {
            return (Position) r27.a.a(Position.class, r1);
        }

        public Position(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Position.values().length];
            r0[Position.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Position.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Position.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SheetSortItemView a;
        public final /* synthetic */ SheetItem b;

        public b(SheetSortItemView r1, SheetItem r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            this.a.setSelected(true);
            com.bytedance.ee.bear.sheet.panel.panelcell.a.InterfaceC0179a r4 = this.a.a;
            if (r4 == null) goto L6;
            r4.a(this.b.getId(), null);
            return;
        }
    }

    public SheetSortItemView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SheetSortItemView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.a
    public final void a(boolean r1) {
    }

    private final void setBackground(boolean r5) {
        int r0 = getResources().getColor(2131100549);
        int r1 = getResources().getDimensionPixelSize(2131169382);
        if (r5 == false) goto L5;
        ColorStateList r6 = getResources().getColorStateList(2131105842);
    L6:
        int r2 = a.a[this.d.ordinal()];
        if (r2 != 1) goto L9;
        GradientDrawable r7 = lp5.a.d(r0, r1, r6);
    L17:
        setBackground(r7);
        return;
    L9:
        if (r2 != 2) goto L11;
        r7 = lp5.a.e(r0, r6);
        goto L17
    L11:
        if (r2 != 3) goto L14;
        r7 = lp5.a.f(r0, r1, r6);
        goto L17
    L14:
        throw new NoWhenBranchMatchedException();
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.a
    public void setClickListener(com.bytedance.ee.bear.sheet.panel.panelcell.a.InterfaceC0179a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a = r2;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.a
    public void update(SheetItem r6) {
        Intrinsics.checkNotNullParameter(r6, "item");
        ImageView r0 = this.b;
        Resources r1 = getResources();
        if (r6.isEnable() == false) goto L5;
        int r2 = 2131105843;
    L6:
        r0.setImageTintList(r1.getColorStateList(r2));
        TextView r3 = this.c;
        Resources r4 = getResources();
        if (r6.isEnable() == false) goto L9;
        int r5 = 2131105844;
    L10:
        r3.setTextColor(r4.getColorStateList(r5));
        TextPaint r7 = this.c.getPaint();
        if (r6.isSelected() == false) goto L13;
        float r8 = 1.0f;
    L14:
        r7.setStrokeWidth(r8);
        String r9 = r6.getTitle();
        boolean r10 = true;
        if (r9 != null) goto L17;
    L22:
        boolean r11 = false;
    L24:
        if (r11 == false) goto L26;
        this.c.setVisibility(0);
        this.c.setText(r6.getTitle());
    L27:
        String r12 = r6.getIconKey();
        if (r12 != null) goto L30;
    L35:
        r10 = false;
    L36:
        if (r10 == false) goto L38;
        this.b.setVisibility(0);
        this.b.setImageResource(n.n(getContext(), r6.getIconKey()));
    L39:
        setBackground(r6.isEnable());
        setOnClickListener(new b(this, r6));
        return;
    L38:
        this.b.setVisibility(8);
        goto L39
    L30:
        if (r12.length() <= 0) goto L32;
        boolean r13 = true;
    L33:
        if (r13 != true) goto L35;
    L32:
        r13 = false;
        goto L33
    L26:
        this.c.setVisibility(8);
        goto L27
    L17:
        if (r9.length() <= 0) goto L19;
        boolean r14 = true;
    L20:
        if (r14 != true) goto L22;
        r11 = true;
        goto L24
    L19:
        r14 = false;
        goto L20
    L13:
        r8 = 0.0f;
        goto L14
    L9:
        r5 = 2131106610;
        goto L10
    L5:
        r2 = 2131102416;
        goto L6
    }

    public SheetSortItemView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        Position r8 = Position.CENTER;
        this.d = r8;
        LayoutInflater.from(getContext()).inflate(2131564578, this, true);
        TypedArray r9 = r5.obtainStyledAttributes(r6, new int[]{2130970280, 2130973587, 2130974495});
        ImageView r10 = (ImageView) findViewById(2131374718);
        this.b = r10;
        Drawable r1 = r9.getDrawable(0);
        if (r1 == null) goto L5;
        r10.setVisibility(0);
        r10.setImageDrawable(r1);
    L5:
        TextView r11 = (TextView) findViewById(2131388367);
        this.c = r11;
        r11.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        String r2 = r9.getString(2);
        if (r2 == null) goto L8;
        r11.setVisibility(0);
        r11.setText(r2);
    L8:
        int r12 = r9.getInt(1, r8.getValue());
        this.d = Position.values()[r12];
        r9.recycle();
    }

    public /* synthetic */ SheetSortItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
