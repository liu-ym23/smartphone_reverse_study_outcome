package com.bytedance.ee.bear.sheet.toolbar2;

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
import com.larksuite.component.universe_design.button.UDButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetBlockTextAttrAdapter extends BaseSubToolbarAdapter {
    public c c;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SheetBlockPrimaryItemId.TextAttrSecondaryItemId.values().length];
            a = r0;
            r0[SheetBlockPrimaryItemId.TextAttrSecondaryItemId.bold.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[SheetBlockPrimaryItemId.TextAttrSecondaryItemId.italic.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[SheetBlockPrimaryItemId.TextAttrSecondaryItemId.underline.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[SheetBlockPrimaryItemId.TextAttrSecondaryItemId.strikethrough.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class b extends RecyclerView.ViewHolder {
        public final UDButton a;
        public final TextView b;
        public final UDButton c;

        public b(View r3) {
            super(r3);
            UDButton r0 = (UDButton) r3.findViewById(2131388378);
            this.a = r0;
            this.b = (TextView) r3.findViewById(2131388377);
            UDButton r4 = (UDButton) r3.findViewById(2131388379);
            this.c = r4;
            T3(r0);
            T3(r4);
        }

        public final void T3(UDButton r5) {
            Drawable r6 = r5.getCompoundDrawablesRelative()[0];
            if (r6 == null) goto L6;
            int r0 = ((RecyclerView.ViewHolder) this).itemView.getContext().getResources().getDimensionPixelSize(2131168315);
            int r1 = r6.getIntrinsicWidth();
            int r2 = (r1 - r0) / 2;
            int r3 = (r6.getIntrinsicHeight() - r0) / 2;
            r6.setBounds(r2, r3, r2 + r0, r0 + r3);
            return;
        }
    }

    public interface c extends BaseSubToolbarAdapter.a {
    }

    public SheetBlockTextAttrAdapter(ItemV2[] r1) {
        super(r1);
    }

    public final int getItemViewType(int r4) {
        ItemV2[] r0 = ((BaseSubToolbarAdapter) this).a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        ItemV2 r5 = r0[r4];
        if (SheetBlockPrimaryItemId.TextAttrSecondaryItemId.separator.name().equals(r5.getId()) == false) goto L10;
        return 1;
    L10:
        if (SheetBlockPrimaryItemId.TextAttrSecondaryItemId.foreColor.name().equals(r5.getId()) == false) goto L14;
        return 4;
    L14:
        if (SheetBlockPrimaryItemId.TextAttrSecondaryItemId.fontSize.name().equals(r5.getId()) == false) goto L17;
        return 3;
    L17:
        return 0;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        if ((r6 instanceof BaseSubToolbarAdapter.DividerViewHolder) == true) goto L62;
        ItemV2[] r0 = ((BaseSubToolbarAdapter) this).a;
        if (r0 == null) goto L66;
        ItemV2 r8 = r0[r7];
        boolean r1 = false;
        boolean r2 = true;
        if ((r6 instanceof BaseSubToolbarAdapter.SubToolbarViewHolder) == false) goto L36;
        BaseSubToolbarAdapter.SubToolbarViewHolder r9 = (BaseSubToolbarAdapter.SubToolbarViewHolder) r6;
        ImageView r3 = r9.a;
        ItemIdV2 r4 = r8.id();
        if ((r4 instanceof SheetBlockPrimaryItemId.TextAttrSecondaryItemId) == false) goto L24;
        int r5 = a.a[((SheetBlockPrimaryItemId.TextAttrSecondaryItemId) r4).ordinal()];
        if (r5 != 1) goto L14;
        int r10 = 2131253866;
    L25:
        r3.setImageResource(r10);
        ImageView r11 = r9.a;
        r11.setImageTintList(r11.getResources().getColorStateList(2131106629));
        ImageView r12 = r9.a;
        if (r8.isEnable() == true) goto L28;
    L30:
        r12.setSelected(r1);
        r9.a.setEnabled(r8.isEnable());
        if (r8.isEnable() == false) goto L33;
        Drawable r13 = r9.a.getResources().getDrawable(2131233898).mutate();
    L34:
        r9.a.setBackground(r13);
        ((RecyclerView.ViewHolder) r9).itemView.setOnClickListener(new com.bytedance.ee.bear.sheet.toolbar2.a(this, r8));
        return;
    L33:
        r13 = null;
        goto L34
    L28:
        if (r8.isSelected() == false) goto L30;
        r1 = true;
        goto L30
    L14:
        if (r5 != 2) goto L16;
        r10 = 2131254942;
        goto L25
    L16:
        if (r5 != 3) goto L18;
        r10 = 2131256061;
        goto L25
    L18:
        if (r5 != 4) goto L24;
        r10 = 2131254887;
    L24:
        r10 = 0;
        goto L25
    L36:
        if ((r6 instanceof BaseSubToolbarAdapter.TextColorViewHolder) == false) goto L53;
        BaseSubToolbarAdapter.TextColorViewHolder r14 = (BaseSubToolbarAdapter.TextColorViewHolder) r6;
        String r15 = r8.getValue();
        int r16 = y2(r15, ((RecyclerView.ViewHolder) r14).itemView.getResources().getColor(2131103461));     // Catch: Throwable -> L50
        if (r16 != (-1)) goto L41;
        Drawable r17 = ((RecyclerView.ViewHolder) r14).itemView.getResources().getDrawable(2131248266);     // Catch: Throwable -> L50
        r14.a.setBackground(r17);     // Catch: Throwable -> L50
    L42:
        r14.b.setImageResource(2131255837);     // Catch: Throwable -> L50
        View r18 = ((RecyclerView.ViewHolder) r14).itemView;     // Catch: Throwable -> L50
        if (r8.isEnable() == true) goto L45;
    L47:
        r2 = false;
    L48:
        r18.setSelected(r2);     // Catch: Throwable -> L50
        ((RecyclerView.ViewHolder) r14).itemView.setEnabled(r8.isEnable());     // Catch: Throwable -> L50
        ((RecyclerView.ViewHolder) r14).itemView.setOnClickListener(new com.bytedance.ee.bear.sheet.toolbar2.b(this, r8));     // Catch: Throwable -> L50
        return;
    L45:
        if (r8.isSelected() == false) goto L47;
    L41:
        r14.a.setBackgroundColor(r16);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        tt5.a.f("SheetTextAttrAdapter", th, false);
        return;
    L53:
        if ((r6 instanceof b) == false) goto L65;
        b r19 = (b) r6;
        if (TextUtils.isEmpty(r8.getValue()) == false) goto L57;
        String r20 = "10";
    L58:
        r19.b.setText(r20);
        A2(r19, r8, r20);
        r19.a.setOnClickListener(new com.bytedance.ee.bear.sheet.toolbar2.c(this, r19, r8));
        r19.c.setOnClickListener(new d(this, r19, r8));
        return;
    L57:
        r20 = r8.getValue();
        goto L58
    L65:
        return;
    L66:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        if (r4 != 1) goto L7;
        return new BaseSubToolbarAdapter.DividerViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131560101, r3, false));
    L7:
        if (r4 != 4) goto L11;
        return new BaseSubToolbarAdapter.TextColorViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131560104, r3, false));
    L11:
        if (r4 != 3) goto L15;
        return new b(LayoutInflater.from(r3.getContext()).inflate(2131564585, r3, false));
    L15:
        return new BaseSubToolbarAdapter.SubToolbarViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131560103, r3, false));
    }

    public static void A2(b r2, ItemV2 r3, String r4) {
        int r5 = r3.valueIndexInList(r4);
        if (r3.getList() != null) goto L5;
        int r6 = 0;
    L7:
        if (r5 != 0) goto L9;
        r2.a.setEnabled(false);
        r2.c.setEnabled(true);
        return;
    L9:
        if (r6 != 0) goto L11;
    L13:
        r2.a.setEnabled(true);
        r2.c.setEnabled(true);
        return;
    L11:
        if (r5 != (r6 - 1)) goto L13;
        r2.a.setEnabled(true);
        r2.c.setEnabled(false);
        return;
    L5:
        r6 = r3.getList().length;
        goto L7
    }
}
