package com.bytedance.ee.bear.sheet.toolbar2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarAdapter;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.l;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class SheetBlockCellAttrAdapter extends BaseSubToolbarAdapter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f238410c;

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ItemV2 f238411c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SheetBlockCellAttrAdapter f238412d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            if (this.f238412d.f226051b != null) goto L5;
            return;
        L5:
            if (SheetBlockPrimaryItemId.CellAttrSecondaryItemId.merge.name().equals(this.f238411c.getId()) == false) goto L7;
            this.f238412d.f238410c = -1;
        L7:
            this.f238412d.f226051b.a(this.f238411c);
        }

        public a(SheetBlockCellAttrAdapter r100, ItemV2 r101) {
            this.f238412d = r100;
            this.f238411c = r101;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f238413a = null;

        static {
            int[] r100 = new int[SheetBlockPrimaryItemId.CellAttrSecondaryItemId.values().length];
            f238413a = r100;
            r100[SheetBlockPrimaryItemId.CellAttrSecondaryItemId.merge.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f238413a[SheetBlockPrimaryItemId.CellAttrSecondaryItemId.autoWrap.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f238413a[SheetBlockPrimaryItemId.CellAttrSecondaryItemId.overflow.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f238413a[SheetBlockPrimaryItemId.CellAttrSecondaryItemId.clip.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f238413a[SheetBlockPrimaryItemId.CellAttrSecondaryItemId.borderLine.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f238413a[SheetBlockPrimaryItemId.CellAttrSecondaryItemId.backColor.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f238414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f238415b;

        public c(View r100) {
            super(r100);
            this.f238414a = r100.findViewById(R.id.itemRectColor);
            this.f238415b = (TextView) r100.findViewById(R.id.itemDesc);
            l.c((ImageView) r100.findViewById(R.id.itemIcon), R.color.icon_n1);
        }
    }

    public static class d extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f238416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f238417b;

        public d(View r100) {
            super(r100);
            ImageView r101 = (ImageView) r100.findViewById(R.id.itemIcon);
            this.f238416a = r101;
            this.f238417b = (TextView) r100.findViewById(R.id.itemDesc);
            l.c(r101, R.color.icon_n1);
        }
    }

    public static class e extends RecyclerView.ViewHolder {
        public e(View r100) {
            super(r100);
        }
    }

    public SheetBlockCellAttrAdapter(ItemV2[] r100) {
        super(r100);
        this.f238410c = -1;
    }

    public final void A2(TextView r100) {
        if (this.f238410c == (-1)) goto L5;
        return;
    L5:
        Context r101 = r100.getContext();
        ItemV2[] r102 = this.f226050a;
        int r103 = r102.length;
        int r104 = 0;
        int r105 = 0;
    L6:
        if (r105 >= r103) goto L11;
        ItemV2 r106 = r102[r105];
        if (SheetBlockPrimaryItemId.CellAttrSecondaryItemId.merge.name().equals(r106.getId()) == true) goto L9;
        r105 = r105 + 1;
        goto L6
    L9:
        boolean r107 = r106.isSelected();
    L12:
        String[] r108 = new String[5];
        if (r107 == false) goto L15;
        int r109 = R.string.Doc_Doc_ToolbarCellSplit;
    L16:
        r108[0] = r101.getString(r109);
        r108[1] = r101.getString(R.string.Doc_Doc_ToolbarCellAutoWrap);
        r108[2] = r101.getString(R.string.Doc_Doc_ToolbarCellOverflow);
        r108[3] = r101.getString(R.string.Doc_Doc_ToolbarCellClip);
        r108[4] = r101.getString(R.string.Doc_Doc_ToolbarCellBgColor);
        String r110 = "";
    L17:
        if (r104 >= 5) goto L24;
        String r111 = r108[r104];
        if (TextUtils.isEmpty(r111) == true) goto L23;
        if (r111.length() < r110.length()) goto L23;
        this.f238410c = Math.max(this.f238410c, (int) r100.getPaint().measureText(r111));
        r110 = r111;
    L23:
        r104 = r104 + 1;
        goto L17
    L24:
        return;
    L15:
        r109 = R.string.Doc_Doc_ToolbarCellMerge;
        goto L16
    L11:
        r107 = false;
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        ItemV2[] r101 = this.f226050a;
        if (r101 != null) goto L5;
        return 0;
    L5:
        ItemV2 r102 = r101[r100];
        if (SheetBlockPrimaryItemId.CellAttrSecondaryItemId.separator.name().equals(r102.getId()) == false) goto L10;
        return 2;
    L10:
        if (SheetBlockPrimaryItemId.CellAttrSecondaryItemId.backColor.name().equals(r102.getId()) == false) goto L13;
        return 5;
    L13:
        return 0;
    }

    public final String B2(RecyclerView.ViewHolder r100, ItemV2 r101) {
        if ((r101.id() instanceof SheetBlockPrimaryItemId.CellAttrSecondaryItemId) == false) goto L23;
        SheetBlockPrimaryItemId.CellAttrSecondaryItemId r102 = (SheetBlockPrimaryItemId.CellAttrSecondaryItemId) r101.id();
        switch(b.f238413a[r102.ordinal()]) {
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            default: goto L25;
        };
    L25:
        return "";
    L8:
        return r100.itemView.getResources().getString(R.string.Doc_Doc_ToolbarCellBgColor);
    L10:
        return r100.itemView.getResources().getString(R.string.Doc_Doc_ToolbarCellBorderLine);
    L12:
        return r100.itemView.getResources().getString(R.string.Doc_Doc_ToolbarCellClip);
    L14:
        return r100.itemView.getResources().getString(R.string.Doc_Doc_ToolbarCellOverflow);
    L16:
        return r100.itemView.getResources().getString(R.string.Doc_Doc_ToolbarCellAutoWrap);
    L18:
        if (r101.isSelected() == false) goto L20;
        int r103 = R.string.Doc_Doc_ToolbarCellSplit;
    L22:
        return r100.itemView.getResources().getString(r103);
    L20:
        r103 = R.string.Doc_Doc_ToolbarCellMerge;
        goto L22
    L23:
        return "";
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        if ((r110 instanceof e) == true) goto L66;
        ItemV2[] r100 = this.f226050a;
        if (r100 == null) goto L67;
        ItemV2 r112 = r100[r111];
        boolean r101 = r110 instanceof d;
        int r102 = R.color.primary_fill_default;
        if (r101 == false) goto L49;
        d r103 = (d) r110;
        View r104 = r103.itemView;
        boolean r105 = true;
        if (r112.isEnable() == true) goto L12;
    L14:
        boolean r106 = false;
    L15:
        r104.setSelected(r106);
        r103.itemView.setEnabled(r112.isEnable());
        ImageView r107 = r103.f238416a;
        r107.setImageTintList(r107.getResources().getColorStateList(R.color.toolbar_item_tint));
        ImageView r108 = r103.f238416a;
        ItemIdV2 r109 = r112.id();
        if ((r109 instanceof SheetBlockPrimaryItemId.CellAttrSecondaryItemId) == false) goto L33;
        int r113 = b.f238413a[((SheetBlockPrimaryItemId.CellAttrSecondaryItemId) r109).ordinal()];
        if (r113 != 1) goto L20;
        int r114 = R.drawable.sheet_icon_mergecells_outlined;
    L34:
        r108.setImageResource(r114);
        ImageView r115 = r103.f238416a;
        if (r112.isEnable() == true) goto L37;
    L39:
        r105 = false;
    L40:
        r115.setSelected(r105);
        r103.f238416a.setEnabled(r112.isEnable());
        r103.f238417b.setText(B2(r103, r112));
        A2(r103.f238417b);
        r103.f238417b.setWidth(this.f238410c);
        if (r112.isEnable() == true) goto L43;
        r102 = R.color.text_disable;
    L47:
        TextView r116 = r103.f238417b;
        r116.setTextColor(r116.getResources().getColor(r102));
    L64:
        r110.itemView.setOnClickListener(new a(this, r112));
        return;
    L43:
        if (r112.isSelected() == true) goto L47;
        r102 = R.color.text_title;
        goto L47
    L37:
        if (r112.isSelected() == false) goto L39;
    L20:
        if (r113 != 2) goto L22;
        r114 = R.drawable.ud_icon_wrap_outlined;
        goto L34
    L22:
        if (r113 != 3) goto L24;
        r114 = R.drawable.ud_icon_wrapping_outlined;
        goto L34
    L24:
        if (r113 != 4) goto L26;
        r114 = R.drawable.ud_icon_clip_outlined;
        goto L34
    L26:
        if (r113 != 5) goto L33;
        r114 = R.drawable.sheet_icon_borders_outlined;
    L33:
        r114 = 0;
        goto L34
    L12:
        if (r112.isSelected() == false) goto L14;
        r106 = true;
        goto L15
    L49:
        if ((r110 instanceof c) == false) goto L64;
        c r117 = (c) r110;
        r117.f238415b.setText(B2(r117, r112));
        if (r112.isEnable() == true) goto L53;
        r102 = R.color.text_disable;
    L57:
        TextView r118 = r117.f238415b;
        r118.setTextColor(r118.getResources().getColor(r102));
        A2(r117.f238415b);
        r117.f238415b.setWidth(this.f238410c);
        int r119 = y2(r112.getValue(), Integer.MIN_VALUE);
        if (r119 != Integer.MIN_VALUE) goto L60;
    L63:
        Drawable r120 = r117.itemView.getResources().getDrawable(R.drawable.space_kit_rect_border_empty);
        r117.f238414a.setBackground(r120);
        goto L64
    L60:
        if (r119 == (-1)) goto L63;
        r117.f238414a.setBackgroundColor(r119);
        goto L64
    L53:
        if (r112.isSelected() == true) goto L57;
        r102 = R.color.text_title;
        goto L57
    L67:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (r101 != 2) goto L7;
        return new e(LayoutInflater.from(r100.getContext()).inflate(R.layout.sheet_sub_toolbar_item_divider_horizontal, r100, false));
    L7:
        if (r101 != 5) goto L11;
        return new c(LayoutInflater.from(r100.getContext()).inflate(R.layout.sheet_sub_toolbar_item_cell_attr_bg, r100, false));
    L11:
        return new d(LayoutInflater.from(r100.getContext()).inflate(R.layout.sheet_sub_toolbar_item_cell_attr, r100, false));
    }
}
