package com.bytedance.ee.bear.sheet_core.toolbar2;

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
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarAdapter;
import com.bytedance.ee.bear.sheet.toolbar2.SheetBlockPrimaryItemId;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.nova.R;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes18.dex */
public class SheetBlockTextAttrAdapter extends BaseSubToolbarAdapter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f238541e;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f238542a = null;

        static {
            int[] r100 = new int[SheetBlockPrimaryItemId.TextAttrSecondaryItemId.values().length];
            f238542a = r100;
            r100[SheetBlockPrimaryItemId.TextAttrSecondaryItemId.bold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f238542a[SheetBlockPrimaryItemId.TextAttrSecondaryItemId.italic.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f238542a[SheetBlockPrimaryItemId.TextAttrSecondaryItemId.underline.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f238542a[SheetBlockPrimaryItemId.TextAttrSecondaryItemId.strikethrough.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UDButton f238543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f238544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final UDButton f238545c;

        public b(View r100) {
            super(r100);
            UDButton r101 = (UDButton) r100.findViewById(R.id.textSizeMinus);
            this.f238543a = r101;
            this.f238544b = (TextView) r100.findViewById(R.id.textSize);
            UDButton r102 = (UDButton) r100.findViewById(R.id.textSizePlus);
            this.f238545c = r102;
            T3(r101);
            T3(r102);
        }

        public final void T3(UDButton r100) {
            Drawable r101 = r100.getCompoundDrawablesRelative()[0];
            if (r101 == null) goto L6;
            int r102 = this.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.space_kit_len_16);
            int r103 = r101.getIntrinsicWidth();
            int r104 = (r103 - r102) / 2;
            int r105 = (r101.getIntrinsicHeight() - r102) / 2;
            r101.setBounds(r104, r105, r104 + r102, r102 + r105);
            return;
        }
    }

    public interface c extends BaseSubToolbarAdapter.b {
    }

    public SheetBlockTextAttrAdapter(ItemV2[] r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        ItemV2[] r101 = this.f226205a;
        if (r101 != null) goto L5;
        return 0;
    L5:
        ItemV2 r102 = r101[r100];
        if (SheetBlockPrimaryItemId.TextAttrSecondaryItemId.separator.name().equals(r102.getId()) == false) goto L10;
        return 1;
    L10:
        if (SheetBlockPrimaryItemId.TextAttrSecondaryItemId.foreColor.name().equals(r102.getId()) == false) goto L14;
        return 4;
    L14:
        if (SheetBlockPrimaryItemId.TextAttrSecondaryItemId.fontSize.name().equals(r102.getId()) == false) goto L17;
        return 3;
    L17:
        return 0;
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        if ((r100 instanceof BaseSubToolbarAdapter.DividerViewHolder) == true) goto L62;
        ItemV2[] r102 = this.f226205a;
        if (r102 == null) goto L66;
        ItemV2 r103 = r102[r101];
        boolean r104 = false;
        boolean r105 = true;
        if ((r100 instanceof BaseSubToolbarAdapter.SubToolbarViewHolder) == false) goto L36;
        BaseSubToolbarAdapter.SubToolbarViewHolder r106 = (BaseSubToolbarAdapter.SubToolbarViewHolder) r100;
        ImageView r107 = r106.f226209a;
        ItemIdV2 r108 = r103.id();
        if ((r108 instanceof SheetBlockPrimaryItemId.TextAttrSecondaryItemId) == false) goto L24;
        int r109 = a.f238542a[((SheetBlockPrimaryItemId.TextAttrSecondaryItemId) r108).ordinal()];
        if (r109 != 1) goto L14;
        int r110 = R.drawable.ud_icon_bold_outlined;
    L25:
        r107.setImageResource(r110);
        ImageView r111 = r106.f226209a;
        r111.setImageTintList(r111.getResources().getColorStateList(R.color.toolbar_item_tint));
        ImageView r112 = r106.f226209a;
        if (r103.isEnable() == true) goto L28;
    L30:
        r112.setSelected(r104);
        r106.f226209a.setEnabled(r103.isEnable());
        if (r103.isEnable() == false) goto L33;
        Drawable r113 = r106.f226209a.getResources().getDrawable(R.drawable.core_doc_toolbar_v2_subitem_all_selector).mutate();
    L34:
        r106.f226209a.setBackground(r113);
        r106.itemView.setOnClickListener(new com.bytedance.ee.bear.sheet_core.toolbar2.a(this, r103));
        return;
    L33:
        r113 = null;
        goto L34
    L28:
        if (r103.isSelected() == false) goto L30;
        r104 = true;
        goto L30
    L14:
        if (r109 != 2) goto L16;
        r110 = R.drawable.ud_icon_italic_outlined;
        goto L25
    L16:
        if (r109 != 3) goto L18;
        r110 = R.drawable.ud_icon_underline_outlined;
        goto L25
    L18:
        if (r109 != 4) goto L24;
        r110 = R.drawable.ud_icon_horizontal_line_outlined;
    L24:
        r110 = 0;
        goto L25
    L36:
        if ((r100 instanceof BaseSubToolbarAdapter.TextColorViewHolder) == false) goto L53;
        BaseSubToolbarAdapter.TextColorViewHolder r114 = (BaseSubToolbarAdapter.TextColorViewHolder) r100;
        String r115 = r103.getValue();
        int r116 = z2(r115, r114.itemView.getResources().getColor(R.color.lkui_N800));     // Catch: Throwable -> L50
        if (r116 != (-1)) goto L41;
        Drawable r117 = r114.itemView.getResources().getDrawable(R.drawable.space_kit_rect_border);     // Catch: Throwable -> L50
        r114.f226210a.setBackground(r117);     // Catch: Throwable -> L50
    L42:
        r114.f226211b.setImageResource(R.drawable.ud_icon_style_fontcolor_outlined);     // Catch: Throwable -> L50
        View r118 = r114.itemView;     // Catch: Throwable -> L50
        if (r103.isEnable() == true) goto L45;
    L47:
        r105 = false;
    L48:
        r118.setSelected(r105);     // Catch: Throwable -> L50
        r114.itemView.setEnabled(r103.isEnable());     // Catch: Throwable -> L50
        r114.itemView.setOnClickListener(new com.bytedance.ee.bear.sheet_core.toolbar2.b(this, r103));     // Catch: Throwable -> L50
        return;
    L45:
        if (r103.isSelected() == false) goto L47;
    L41:
        r114.f226210a.setBackgroundColor(r116);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        tt5.a.f("SheetTextAttrAdapter", th, false);
        return;
    L53:
        if ((r100 instanceof b) == false) goto L65;
        b r119 = (b) r100;
        if (TextUtils.isEmpty(r103.getValue()) == false) goto L57;
        String r120 = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
    L58:
        r119.f238544b.setText(r120);
        B2(r119, r103, r120);
        r119.f238543a.setOnClickListener(new com.bytedance.ee.bear.sheet_core.toolbar2.c(this, r119, r103));
        r119.f238545c.setOnClickListener(new d(this, r119, r103));
        return;
    L57:
        r120 = r103.getValue();
        goto L58
    L65:
        return;
    L66:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (r101 != 1) goto L7;
        return new BaseSubToolbarAdapter.DividerViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.core_doc_sub_toolbar_item_divider, r100, false));
    L7:
        if (r101 != 4) goto L11;
        return new BaseSubToolbarAdapter.TextColorViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.core_doc_sub_toolbar_item_text_color, r100, false));
    L11:
        if (r101 != 3) goto L15;
        return new b(LayoutInflater.from(r100.getContext()).inflate(R.layout.sheet_core_sub_toolbar_item_text_size, r100, false));
    L15:
        return new BaseSubToolbarAdapter.SubToolbarViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.core_doc_sub_toolbar_item_horizontal, r100, false));
    }

    public static void B2(b r100, ItemV2 r101, String r102) {
        int r103 = r101.valueIndexInList(r102);
        if (r101.getList() != null) goto L5;
        int r104 = 0;
    L7:
        if (r103 != 0) goto L9;
        r100.f238543a.setEnabled(false);
        r100.f238545c.setEnabled(true);
        return;
    L9:
        if (r104 != 0) goto L11;
    L13:
        r100.f238543a.setEnabled(true);
        r100.f238545c.setEnabled(true);
        return;
    L11:
        if (r103 != (r104 - 1)) goto L13;
        r100.f238543a.setEnabled(true);
        r100.f238545c.setEnabled(false);
        return;
    L5:
        r104 = r101.getList().length;
        goto L7
    }
}
