package com.bytedance.ee.bear.edit.component.toolbar2;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.util.ui.ColorUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseSubToolbarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public ItemV2[] a;
    public a b;

    public static class DividerViewHolder extends RecyclerView.ViewHolder {
        public DividerViewHolder(View r1) {
            super(r1);
        }
    }

    public static class SubToolbarViewHolder extends RecyclerView.ViewHolder {
        public final ImageView a;

        public SubToolbarViewHolder(View r2) {
            super(r2);
            ImageView r3 = (ImageView) r2.findViewById(2131387565);
            this.a = r3;
            com.bytedance.ee.util.ui.l.c(r3, 2131102418);
        }
    }

    public static class TextColorViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final ImageView b;

        public TextColorViewHolder(View r2) {
            super(r2);
            this.a = r2.findViewById(2131388373);
            ImageView r3 = (ImageView) r2.findViewById(2131374718);
            this.b = r3;
            com.bytedance.ee.util.ui.l.c(r3, 2131102418);
        }
    }

    public interface a {
        void a(ItemV2 r1);
    }

    public final int getItemCount() {
        ItemV2[] r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length;
    }

    public BaseSubToolbarAdapter(ItemV2[] r1) {
        this.a = r1;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder r2, final int r3) {
        if ((r2 instanceof DividerViewHolder) == true) goto L11;
        ItemV2[] r0 = this.a;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r3 >= r0.length) goto L13;
        r2.itemView.setOnClickListener(new c(this, r3));
        return;
    L13:
        return;
    }

    public final int y2(String r4, int r5) {
    L8:
        th = move-exception;
        tt5.a.e("BaseSubToolbarAdapter", "color:" + r4, th, false);
    L10:
        return r5;
    L3:
        if (TextUtils.isEmpty(r4) == true) goto L10;
        if (r4.startsWith("#") == false) goto L10;
        return ColorUtils.h(r4);
    }

    public static void z2(SubToolbarViewHolder r3, ItemV2 r4, int r5) {
        ImageView r0 = r3.a;
        r0.setImageTintList(r0.getResources().getColorStateList(2131106629));
        r3.a.setImageResource(kac.a.b(r5));
        ImageView r6 = r3.a;
        if (r4.isEnable() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        r6.setSelected(r1);
        r3.a.setEnabled(r4.isEnable());
        if (r4.isEnable() == false) goto L11;
        Drawable r7 = r3.a.getResources().getDrawable(2131233898).mutate();
    L12:
        r3.a.setBackground(r7);
        return;
    L11:
        r7 = null;
        goto L12
    L5:
        if (r4.isSelected() == false) goto L7;
        r1 = true;
        goto L8
    }
}
