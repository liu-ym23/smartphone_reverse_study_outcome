package com.bytedance.ee.bear.sheet.panel.oppanel;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.bear.sheet.panel.panelcell.SheetColorView;
import com.bytedance.ee.bear.sheet.panel.panelcell.SheetListItemView;
import com.bytedance.ee.bear.sheet.panel.panelcell.SheetRegulatorView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OperationListAdapter extends RecyclerView.Adapter<a> {
    public SheetItem[] a;
    public b b;
    public com.bytedance.ee.bear.sheet.panel.panelcell.a.InterfaceC0179a c;

    public class a extends RecyclerView.ViewHolder {
        public a(SheetListItemView r1) {
            super(r1);
        }
    }

    public interface b {
        boolean a(String r1);
    }

    public final int getItemCount() {
        SheetItem[] r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length;
    }

    public OperationListAdapter() {
    }

    public final int getItemViewType(int r4) {
        OperationEnum r5 = OperationEnum.valueOf(this.a[r4].getId());     // Catch: Exception -> L15
        if (r5 != OperationEnum.foreColor) goto L6;
        return 1;
    L6:
        if (r5 == OperationEnum.backColor) goto L20;
        if (r5 != OperationEnum.fontSize) goto L12;
        return 2;
    L12:
        return 0;
    L20:
        return 1;
    L15:
        e = move-exception;
        tt5.a.d("OperationListAdapter", "getItemViewType err: " + e.getMessage());
        return 0;
    }

    public final void y2(SheetItem[] r1) {
        this.a = r1;
        notifyDataSetChanged();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        a r9 = (a) r7;
        SheetListItemView r0 = (SheetListItemView) ((RecyclerView.ViewHolder) r9).itemView;
        SheetItem r10 = this.a[r8];
        r0.setContentDescription(r10.getId());
        boolean r2 = false;
    L14:
        e = move-exception;
        Exception e = e;
        int r11 = -1;
    L16:
        tt5.a.d("OperationListAdapter", "onBindViewHolder err: " + e);
        boolean r3 = false;
    L17:
        Drawable r4 = null;
        if (r11 == (-1)) goto L20;
        Drawable r12 = AppCompatResources.getDrawable(r0.getContext(), r11);
    L21:
        r0.setIcon(r12);
        r0.setNextIcon(AppCompatResources.getDrawable(r0.getContext(), 2131255566));
        if (r10.isHasSubPanel() == true) goto L26;
        if (r3 == true) goto L26;
        boolean r13 = false;
    L27:
        r0.setShowNext(r13);
        if (r10.isEnable() == false) goto L34;
        b r14 = this.b;
        if (r14 == null) goto L34;
        if (r14.a(r10.getId()) == false) goto L34;
        r2 = true;
    L34:
        r0.a(r2);
        r0.setClickListener(this.c);
        if (TextUtils.equals(r10.getId(), OperationEnum.borderLine.name()) == false) goto L37;
        r4 = AppCompatResources.getDrawable(r0.getContext(), 2131247783);
    L37:
        r0.setIndicator(r4);
        r0.update(r10);
        return;
    L26:
        r13 = true;
        goto L27
    L20:
        r12 = null;
        goto L21
    L4:
        if (TextUtils.equals("icon_formula_outlined", r10.getIconKey()) == false) goto L7;
        r11 = 2131247788;
    L40:
        r3 = OperationEnum.valueOf(r10.getId()).hasNext;     // Catch: Exception -> L12
    L12:
        e = e;
        goto L16
    L7:
        if (TextUtils.isEmpty(r10.getIconKey()) == false) goto L9;
        r11 = OperationEnum.valueOf(r10.getId()).iconResId;     // Catch: Exception -> L14
        goto L40
    L9:
        r11 = com.bytedance.ee.util.ui.n.n(((RecyclerView.ViewHolder) r9).itemView.getContext(), r10.getIconKey());     // Catch: Exception -> L14
        goto L40
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        if (r4 != 1) goto L5;
        SheetListItemView r5 = new SheetColorView(r3.getContext());
    L9:
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new a(r5);
    L5:
        if (r4 == 2) goto L7;
        r5 = new SheetListItemView(r3.getContext());
        goto L9
    L7:
        r5 = new SheetRegulatorView(r3.getContext());
        goto L9
    }
}
