package com.bytedance.ee.bear.edit.component.toolbar2;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public abstract class BaseSubToolbarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ItemV2[] f226050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f226051b;

    public static class DividerViewHolder extends RecyclerView.ViewHolder {
        public DividerViewHolder(View r100) {
            super(r100);
        }
    }

    public static class SubToolbarViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f226052a;

        public SubToolbarViewHolder(View r100) {
            super(r100);
            ImageView r101 = (ImageView) r100.findViewById(R.id.sub_toolbar_item_icon);
            this.f226052a = r101;
            com.bytedance.ee.util.ui.l.c(r101, R.color.icon_n1);
        }
    }

    public static class TextColorViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f226053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f226054b;

        public TextColorViewHolder(View r100) {
            super(r100);
            this.f226053a = r100.findViewById(R.id.textColorRect);
            ImageView r101 = (ImageView) r100.findViewById(R.id.icon);
            this.f226054b = r101;
            com.bytedance.ee.util.ui.l.c(r101, R.color.icon_n1);
        }
    }

    public interface a {
        void a(ItemV2 r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ItemV2[] r100 = this.f226050a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.length;
    }

    public BaseSubToolbarAdapter(ItemV2[] r100) {
        this.f226050a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r100, final int r101) {
        if ((r100 instanceof DividerViewHolder) == true) goto L11;
        ItemV2[] r102 = this.f226050a;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r101 >= r102.length) goto L13;
        r100.itemView.setOnClickListener(new c(this, r101));
        return;
    L13:
        return;
    }

    public final int y2(String r100, int r101) {
    L8:
        th = move-exception;
        tt5.a.e("BaseSubToolbarAdapter", "color:" + r100, th, false);
    L10:
        return r101;
    L3:
        if (TextUtils.isEmpty(r100) == true) goto L10;
        if (r100.startsWith("#") == false) goto L10;
        return ColorUtils.h(r100);
    }

    public static void z2(SubToolbarViewHolder r100, ItemV2 r101, int r102) {
        ImageView r103 = r100.f226052a;
        r103.setImageTintList(r103.getResources().getColorStateList(R.color.toolbar_item_tint));
        r100.f226052a.setImageResource(kac.a.b(r102));
        ImageView r104 = r100.f226052a;
        if (r101.isEnable() == true) goto L5;
    L7:
        boolean r105 = false;
    L8:
        r104.setSelected(r105);
        r100.f226052a.setEnabled(r101.isEnable());
        if (r101.isEnable() == false) goto L11;
        Drawable r106 = r100.f226052a.getResources().getDrawable(R.drawable.doc_toolbar_v2_subitem_all_selector).mutate();
    L12:
        r100.f226052a.setBackground(r106);
        return;
    L11:
        r106 = null;
        goto L12
    L5:
        if (r101.isSelected() == false) goto L7;
        r105 = true;
        goto L8
    }
}
