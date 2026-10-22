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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetBlockCellAttrAdapter extends BaseSubToolbarAdapter {
    public int c;

    public class a extends t {
        public final /* synthetic */ ItemV2 c;
        public final /* synthetic */ SheetBlockCellAttrAdapter d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            if (((BaseSubToolbarAdapter) this.d).b != null) goto L5;
            return;
        L5:
            if (SheetBlockPrimaryItemId.CellAttrSecondaryItemId.merge.name().equals(this.c.getId()) == false) goto L7;
            this.d.c = -1;
        L7:
            ((BaseSubToolbarAdapter) this.d).b.a(this.c);
        }

        public a(SheetBlockCellAttrAdapter r1, ItemV2 r2) {
            this.d = r1;
            this.c = r2;
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SheetBlockPrimaryItemId.CellAttrSecondaryItemId.values().length];
            a = r0;
            r0[SheetBlockPrimaryItemId.CellAttrSecondaryItemId.merge.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[SheetBlockPrimaryItemId.CellAttrSecondaryItemId.autoWrap.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[SheetBlockPrimaryItemId.CellAttrSecondaryItemId.overflow.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[SheetBlockPrimaryItemId.CellAttrSecondaryItemId.clip.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[SheetBlockPrimaryItemId.CellAttrSecondaryItemId.borderLine.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[SheetBlockPrimaryItemId.CellAttrSecondaryItemId.backColor.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static class c extends RecyclerView.ViewHolder {
        public final View a;
        public final TextView b;

        public c(View r2) {
            super(r2);
            this.a = r2.findViewById(2131375684);
            this.b = (TextView) r2.findViewById(2131375675);
            l.c((ImageView) r2.findViewById(2131375677), 2131102418);
        }
    }

    public static class d extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final TextView b;

        public d(View r3) {
            super(r3);
            ImageView r0 = (ImageView) r3.findViewById(2131375677);
            this.a = r0;
            this.b = (TextView) r3.findViewById(2131375675);
            l.c(r0, 2131102418);
        }
    }

    public static class e extends RecyclerView.ViewHolder {
        public e(View r1) {
            super(r1);
        }
    }

    public SheetBlockCellAttrAdapter(ItemV2[] r1) {
        super(r1);
        this.c = -1;
    }

    public final void A2(TextView r9) {
        if (this.c == (-1)) goto L5;
        return;
    L5:
        Context r0 = r9.getContext();
        ItemV2[] r1 = ((BaseSubToolbarAdapter) this).a;
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L11;
        ItemV2 r5 = r1[r4];
        if (SheetBlockPrimaryItemId.CellAttrSecondaryItemId.merge.name().equals(r5.getId()) == true) goto L9;
        r4 = r4 + 1;
        goto L6
    L9:
        boolean r6 = r5.isSelected();
    L12:
        String[] r7 = new String[5];
        if (r6 == false) goto L15;
        int r8 = 2131887695;
    L16:
        r7[0] = r0.getString(r8);
        r7[1] = r0.getString(2131887689);
        r7[2] = r0.getString(2131887694);
        r7[3] = r0.getString(2131887692);
        r7[4] = r0.getString(2131887690);
        String r10 = "";
    L17:
        if (r3 >= 5) goto L24;
        String r11 = r7[r3];
        if (TextUtils.isEmpty(r11) == true) goto L23;
        if (r11.length() < r10.length()) goto L23;
        this.c = Math.max(this.c, (int) r9.getPaint().measureText(r11));
        r10 = r11;
    L23:
        r3 = r3 + 1;
        goto L17
    L24:
        return;
    L15:
        r8 = 2131887693;
        goto L16
    L11:
        r6 = false;
        goto L12
    }

    public final int getItemViewType(int r4) {
        ItemV2[] r0 = ((BaseSubToolbarAdapter) this).a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        ItemV2 r5 = r0[r4];
        if (SheetBlockPrimaryItemId.CellAttrSecondaryItemId.separator.name().equals(r5.getId()) == false) goto L10;
        return 2;
    L10:
        if (SheetBlockPrimaryItemId.CellAttrSecondaryItemId.backColor.name().equals(r5.getId()) == false) goto L13;
        return 5;
    L13:
        return 0;
    }

    public final String B2(RecyclerView.ViewHolder r3, ItemV2 r4) {
        if ((r4.id() instanceof SheetBlockPrimaryItemId.CellAttrSecondaryItemId) == false) goto L23;
        SheetBlockPrimaryItemId.CellAttrSecondaryItemId r0 = (SheetBlockPrimaryItemId.CellAttrSecondaryItemId) r4.id();
        switch(b.a[r0.ordinal()]) {
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
        return r3.itemView.getResources().getString(2131887690);
    L10:
        return r3.itemView.getResources().getString(2131887691);
    L12:
        return r3.itemView.getResources().getString(2131887692);
    L14:
        return r3.itemView.getResources().getString(2131887694);
    L16:
        return r3.itemView.getResources().getString(2131887689);
    L18:
        if (r4.isSelected() == false) goto L20;
        int r5 = 2131887695;
    L22:
        return r3.itemView.getResources().getString(r5);
    L20:
        r5 = 2131887693;
        goto L22
    L23:
        return "";
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        if ((r10 instanceof e) == true) goto L66;
        ItemV2[] r0 = ((BaseSubToolbarAdapter) this).a;
        if (r0 == null) goto L67;
        ItemV2 r12 = r0[r11];
        int r1 = 2131105548;
        if ((r10 instanceof d) == false) goto L49;
        d r2 = (d) r10;
        View r4 = ((RecyclerView.ViewHolder) r2).itemView;
        boolean r6 = true;
        if (r12.isEnable() == true) goto L12;
    L14:
        boolean r5 = false;
    L15:
        r4.setSelected(r5);
        ((RecyclerView.ViewHolder) r2).itemView.setEnabled(r12.isEnable());
        ImageView r7 = r2.a;
        r7.setImageTintList(r7.getResources().getColorStateList(2131106629));
        ImageView r8 = r2.a;
        ItemIdV2 r9 = r12.id();
        if ((r9 instanceof SheetBlockPrimaryItemId.CellAttrSecondaryItemId) == false) goto L33;
        int r13 = b.a[((SheetBlockPrimaryItemId.CellAttrSecondaryItemId) r9).ordinal()];
        if (r13 != 1) goto L20;
        int r14 = 2131247794;
    L34:
        r8.setImageResource(r14);
        ImageView r15 = r2.a;
        if (r12.isEnable() == true) goto L37;
    L39:
        r6 = false;
    L40:
        r15.setSelected(r6);
        r2.a.setEnabled(r12.isEnable());
        r2.b.setText(B2(r2, r12));
        A2(r2.b);
        r2.b.setWidth(this.c);
        if (r12.isEnable() == true) goto L43;
        r1 = 2131106610;
    L47:
        TextView r3 = r2.b;
        r3.setTextColor(r3.getResources().getColor(r1));
    L64:
        r10.itemView.setOnClickListener(new a(this, r12));
        return;
    L43:
        if (r12.isSelected() == true) goto L47;
        r1 = 2131106622;
        goto L47
    L37:
        if (r12.isSelected() == false) goto L39;
    L20:
        if (r13 != 2) goto L22;
        r14 = 2131256302;
        goto L34
    L22:
        if (r13 != 3) goto L24;
        r14 = 2131256304;
        goto L34
    L24:
        if (r13 != 4) goto L26;
        r14 = 2131254117;
        goto L34
    L26:
        if (r13 != 5) goto L33;
        r14 = 2131247783;
    L33:
        r14 = 0;
        goto L34
    L12:
        if (r12.isSelected() == false) goto L14;
        r5 = true;
        goto L15
    L49:
        if ((r10 instanceof c) == false) goto L64;
        c r16 = (c) r10;
        r16.b.setText(B2(r16, r12));
        if (r12.isEnable() == true) goto L53;
        r1 = 2131106610;
    L57:
        TextView r17 = r16.b;
        r17.setTextColor(r17.getResources().getColor(r1));
        A2(r16.b);
        r16.b.setWidth(this.c);
        int r18 = y2(r12.getValue(), Integer.MIN_VALUE);
        if (r18 != Integer.MIN_VALUE) goto L60;
    L63:
        Drawable r19 = ((RecyclerView.ViewHolder) r16).itemView.getResources().getDrawable(2131248267);
        r16.a.setBackground(r19);
        goto L64
    L60:
        if (r18 == (-1)) goto L63;
        r16.a.setBackgroundColor(r18);
        goto L64
    L53:
        if (r12.isSelected() == true) goto L57;
        r1 = 2131106622;
        goto L57
    L67:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        if (r4 != 2) goto L7;
        return new e(LayoutInflater.from(r3.getContext()).inflate(2131564584, r3, false));
    L7:
        if (r4 != 5) goto L11;
        return new c(LayoutInflater.from(r3.getContext()).inflate(2131564583, r3, false));
    L11:
        return new d(LayoutInflater.from(r3.getContext()).inflate(2131564582, r3, false));
    }
}
