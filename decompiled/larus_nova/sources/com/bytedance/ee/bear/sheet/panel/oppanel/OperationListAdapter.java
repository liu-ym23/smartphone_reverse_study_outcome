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
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class OperationListAdapter extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SheetItem[] f238198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f238199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ee.bear.sheet.panel.panelcell.a.InterfaceC3426a f238200c;

    public class a extends RecyclerView.ViewHolder {
        public a(SheetListItemView r100) {
            super(r100);
        }
    }

    public interface b {
        boolean a(String r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        SheetItem[] r100 = this.f238198a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.length;
    }

    public OperationListAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        OperationEnum r101 = OperationEnum.valueOf(this.f238198a[r100].getId());     // Catch: Exception -> L15
        if (r101 != OperationEnum.foreColor) goto L6;
        return 1;
    L6:
        if (r101 == OperationEnum.backColor) goto L20;
        if (r101 != OperationEnum.fontSize) goto L12;
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

    public final void y2(SheetItem[] r100) {
        this.f238198a = r100;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        a r102 = (a) r100;
        SheetListItemView r103 = (SheetListItemView) r102.itemView;
        SheetItem r104 = this.f238198a[r101];
        r103.setContentDescription(r104.getId());
        boolean r105 = false;
    L14:
        e = move-exception;
        Exception e100 = e;
        int r106 = -1;
    L16:
        tt5.a.d("OperationListAdapter", "onBindViewHolder err: " + e100);
        boolean r107 = false;
    L17:
        Drawable r108 = null;
        if (r106 == (-1)) goto L20;
        Drawable r109 = AppCompatResources.getDrawable(r103.getContext(), r106);
    L21:
        r103.setIcon(r109);
        r103.setNextIcon(AppCompatResources.getDrawable(r103.getContext(), R.drawable.ud_icon_right_outlined));
        if (r104.isHasSubPanel() == true) goto L26;
        if (r107 == true) goto L26;
        boolean r110 = false;
    L27:
        r103.setShowNext(r110);
        if (r104.isEnable() == false) goto L34;
        b r111 = this.f238199b;
        if (r111 == null) goto L34;
        if (r111.a(r104.getId()) == false) goto L34;
        r105 = true;
    L34:
        r103.a(r105);
        r103.setClickListener(this.f238200c);
        if (TextUtils.equals(r104.getId(), OperationEnum.borderLine.name()) == false) goto L37;
        r108 = AppCompatResources.getDrawable(r103.getContext(), R.drawable.sheet_icon_borders_outlined);
    L37:
        r103.setIndicator(r108);
        r103.update(r104);
        return;
    L26:
        r110 = true;
        goto L27
    L20:
        r109 = null;
        goto L21
    L4:
        if (TextUtils.equals("icon_formula_outlined", r104.getIconKey()) == false) goto L7;
        r106 = R.drawable.sheet_icon_formula;
    L40:
        r107 = OperationEnum.valueOf(r104.getId()).hasNext;     // Catch: Exception -> L12
    L12:
        e100 = e;
        goto L16
    L7:
        if (TextUtils.isEmpty(r104.getIconKey()) == false) goto L9;
        r106 = OperationEnum.valueOf(r104.getId()).iconResId;     // Catch: Exception -> L14
        goto L40
    L9:
        r106 = com.bytedance.ee.util.ui.n.n(r102.itemView.getContext(), r104.getIconKey());     // Catch: Exception -> L14
        goto L40
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (r101 != 1) goto L5;
        SheetListItemView r102 = new SheetColorView(r100.getContext());
    L9:
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new a(r102);
    L5:
        if (r101 == 2) goto L7;
        r102 = new SheetListItemView(r100.getContext());
        goto L9
    L7:
        r102 = new SheetRegulatorView(r100.getContext());
        goto L9
    }
}
