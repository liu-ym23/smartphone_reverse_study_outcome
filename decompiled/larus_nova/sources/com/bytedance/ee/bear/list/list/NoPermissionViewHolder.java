package com.bytedance.ee.bear.list.list;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class NoPermissionViewHolder extends BaseViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f228524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f228525b;

    public NoPermissionViewHolder(View r100) {
        super(r100);
        this.f228524a = (ViewGroup) r100.findViewById(R.id.item_content);
        AppCompatImageView r101 = (AppCompatImageView) r100.findViewById(R.id.item_icon);
        TextView r102 = (TextView) r100.findViewById(R.id.item_name);
        this.f228525b = (ViewGroup) r100.findViewById(R.id.grid_item);
        AppCompatImageView r103 = (AppCompatImageView) r100.findViewById(R.id.list_grid_thumbnail);
        AppCompatImageView r104 = (AppCompatImageView) r100.findViewById(R.id.list_grid_item_type);
        TextView r105 = (TextView) r100.findViewById(R.id.list_grid_item_title);
    }
}
