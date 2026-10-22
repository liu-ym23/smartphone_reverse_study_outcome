package com.bytedance.ee.bear.content.creation.mvp;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class SelectCreationMenuAdapter extends BaseQuickAdapter<SelectCreationMenuItem, BaseViewHolder> {
    public SelectCreationMenuAdapter() {
        super(R.layout.content_create_menu_item_new);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, SelectCreationMenuItem r101) {
        SelectCreationMenuItem r102 = r101;
        AppCompatImageView r103 = (AppCompatImageView) r100.getView(R.id.list_menu_img);
        r103.setImageResource(r102.f216850c);
        float r104 = 0.5f;
        if (r102.f216851d == false) goto L5;
        float r105 = 1.0f;
    L6:
        r103.setAlpha(r105);
        TextView r106 = (TextView) r100.getView(R.id.list_menu_name);
        r106.setText(r102.f216849b);
        if (r102.f216851d == false) goto L9;
        r104 = 1.0f;
    L9:
        r106.setAlpha(r104);
        r100.itemView.setTag(r102.getType().tag);
        return;
    L5:
        r105 = 0.5f;
        goto L6
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final BaseViewHolder onCreateDefViewHolder(ViewGroup r100, int r101) {
        return super.onCreateDefViewHolder(r100, r101);
    }
}
