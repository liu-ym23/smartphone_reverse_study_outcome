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
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0019H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/sheet/panel/panelcell/SheetSortItemView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/sheet/panel/panelcell/IPanelCell;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mClickListener", "Lcom/bytedance/ee/bear/sheet/panel/panelcell/IPanelCell$OnClickListener;", "mIcon", "Landroid/widget/ImageView;", "mText", "Landroid/widget/TextView;", "mPosition", "Lcom/bytedance/ee/bear/sheet/panel/panelcell/SheetSortItemView$Position;", "update", "", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/sheet/panel/SheetItem;", "showBadge", "show", "", "setClickListener", "listener", "setBackground", "enable", "Position", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SheetSortItemView extends FrameLayout implements com.bytedance.ee.bear.sheet.panel.panelcell.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ee.bear.sheet.panel.panelcell.a.InterfaceC3426a f238287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f238288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f238289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Position f238290d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/sheet/panel/panelcell/SheetSortItemView$Position;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LEFT", "RIGHT", "CENTER", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Position extends Enum<Position> {
        public static final Position CENTER = null;
        public static final Position LEFT = null;
        public static final Position RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Position[] f238291a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f238292b = null;
        private final int value;

        public static EnumEntries<Position> getEntries() {
            return f238292b;
        }

        static {
            Position r100 = new Position("LEFT", 0, 0);
            LEFT = r100;
            Position r101 = new Position("RIGHT", 1, 1);
            RIGHT = r101;
            Position r102 = new Position("CENTER", 2, 2);
            CENTER = r102;
            Position[] r103 = {r100, r101, r102};
            f238291a = r103;
            f238292b = EnumEntriesKt.enumEntries(r103);
        }

        public static Position[] values() {
            return (Position[]) f238291a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Position valueOf(String r100) {
            return (Position) r27.a.a(Position.class, r100);
        }

        public Position(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f238293a = null;

        static {
            int[] r100 = new int[Position.values().length];
            r100[Position.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Position.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Position.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f238293a = r100;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetSortItemView f238294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SheetItem f238295b;

        public b(SheetSortItemView r100, SheetItem r101) {
            this.f238294a = r100;
            this.f238295b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f238294a.setSelected(true);
            com.bytedance.ee.bear.sheet.panel.panelcell.a.InterfaceC3426a r101 = this.f238294a.f238287a;
            if (r101 == null) goto L6;
            r101.a(this.f238295b.getId(), null);
            return;
        }
    }

    public SheetSortItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SheetSortItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.a
    public final void a(boolean r100) {
    }

    private final void setBackground(boolean r100) {
        int r101 = getResources().getColor(R.color.bg_body_overlay);
        int r102 = getResources().getDimensionPixelSize(R.dimen.ud_radius_l);
        if (r100 == false) goto L5;
        ColorStateList r103 = getResources().getColorStateList(R.color.sheet_attr_item_bg_tint_selector);
    L6:
        int r104 = a.f238293a[this.f238290d.ordinal()];
        if (r104 != 1) goto L9;
        GradientDrawable r105 = lp5.a.d(r101, r102, r103);
    L17:
        setBackground(r105);
        return;
    L9:
        if (r104 != 2) goto L11;
        r105 = lp5.a.e(r101, r103);
        goto L17
    L11:
        if (r104 != 3) goto L14;
        r105 = lp5.a.f(r101, r102, r103);
        goto L17
    L14:
        throw new NoWhenBranchMatchedException();
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.a
    public void setClickListener(com.bytedance.ee.bear.sheet.panel.panelcell.a.InterfaceC3426a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f238287a = r100;
    }

    @Override // com.bytedance.ee.bear.sheet.panel.panelcell.a
    public void update(SheetItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        ImageView r101 = this.f238288b;
        Resources r102 = getResources();
        if (r100.isEnable() == false) goto L5;
        int r103 = R.color.sheet_attr_item_icon_tint_selector;
    L6:
        r101.setImageTintList(r102.getColorStateList(r103));
        TextView r104 = this.f238289c;
        Resources r105 = getResources();
        if (r100.isEnable() == false) goto L9;
        int r106 = R.color.sheet_attr_item_text_tint_selector;
    L10:
        r104.setTextColor(r105.getColorStateList(r106));
        TextPaint r107 = this.f238289c.getPaint();
        if (r100.isSelected() == false) goto L13;
        float r108 = 1.0f;
    L14:
        r107.setStrokeWidth(r108);
        String r109 = r100.getTitle();
        boolean r110 = true;
        if (r109 != null) goto L17;
    L22:
        boolean r111 = false;
    L24:
        if (r111 == false) goto L26;
        this.f238289c.setVisibility(0);
        this.f238289c.setText(r100.getTitle());
    L27:
        String r112 = r100.getIconKey();
        if (r112 != null) goto L30;
    L35:
        r110 = false;
    L36:
        if (r110 == false) goto L38;
        this.f238288b.setVisibility(0);
        this.f238288b.setImageResource(n.n(getContext(), r100.getIconKey()));
    L39:
        setBackground(r100.isEnable());
        setOnClickListener(new b(this, r100));
        return;
    L38:
        this.f238288b.setVisibility(8);
        goto L39
    L30:
        if (r112.length() <= 0) goto L32;
        boolean r113 = true;
    L33:
        if (r113 != true) goto L35;
    L32:
        r113 = false;
        goto L33
    L26:
        this.f238289c.setVisibility(8);
        goto L27
    L17:
        if (r109.length() <= 0) goto L19;
        boolean r114 = true;
    L20:
        if (r114 != true) goto L22;
        r111 = true;
        goto L24
    L19:
        r114 = false;
        goto L20
    L13:
        r108 = 0.0f;
        goto L14
    L9:
        r106 = R.color.text_disable;
        goto L10
    L5:
        r103 = R.color.icon_disable;
        goto L6
    }

    public SheetSortItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Position r103 = Position.CENTER;
        this.f238290d = r103;
        LayoutInflater.from(getContext()).inflate(R.layout.sheet_panel_sort_item, this, true);
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.icon, R.attr.position, R.attr.text});
        ImageView r105 = (ImageView) findViewById(R.id.icon);
        this.f238288b = r105;
        Drawable r106 = r104.getDrawable(0);
        if (r106 == null) goto L5;
        r105.setVisibility(0);
        r105.setImageDrawable(r106);
    L5:
        TextView r107 = (TextView) findViewById(R.id.text);
        this.f238289c = r107;
        r107.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        String r108 = r104.getString(2);
        if (r108 == null) goto L8;
        r107.setVisibility(0);
        r107.setText(r108);
    L8:
        int r109 = r104.getInt(1, r103.getValue());
        this.f238290d = Position.values()[r109];
        r104.recycle();
    }

    public /* synthetic */ SheetSortItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
