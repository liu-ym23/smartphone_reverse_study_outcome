package com.bytedance.ee.bear.list.list;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class NoPermissionGridStyleViewHolder extends BaseViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f228521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f228522b;

    public NoPermissionGridStyleViewHolder(View r100) {
        super(r100);
        this.f228521a = (ViewGroup) r100.findViewById(R.id.grid_item);
        AppCompatImageView r101 = (AppCompatImageView) r100.findViewById(R.id.list_grid_thumbnail);
        this.f228522b = (AppCompatImageView) r100.findViewById(R.id.list_grid_item_type);
        TextView r102 = (TextView) r100.findViewById(R.id.list_grid_item_title);
    }
}
