package com.bytedance.ee.bear.content.creation.mvp;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectCreationMenuAdapter extends BaseQuickAdapter<SelectCreationMenuItem, BaseViewHolder> {
    public SelectCreationMenuAdapter() {
        super(2131559933);
    }

    public final void convert(BaseViewHolder r5, Object r6) {
        SelectCreationMenuItem r7 = (SelectCreationMenuItem) r6;
        AppCompatImageView r0 = r5.getView(2131378155);
        r0.setImageResource(r7.c);
        float r2 = 0.5f;
        if (r7.d == false) goto L5;
        float r1 = 1.0f;
    L6:
        r0.setAlpha(r1);
        TextView r3 = (TextView) r5.getView(2131378156);
        r3.setText(r7.b);
        if (r7.d == false) goto L9;
        r2 = 1.0f;
    L9:
        r3.setAlpha(r2);
        ((RecyclerView.ViewHolder) r5).itemView.setTag(r7.getType().tag);
        return;
    L5:
        r1 = 0.5f;
        goto L6
    }

    public final BaseViewHolder onCreateDefViewHolder(ViewGroup r1, int r2) {
        return super.onCreateDefViewHolder(r1, r2);
    }
}
