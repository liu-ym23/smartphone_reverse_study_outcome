package com.bytedance.ee.bear.list.list;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class NoPermissionListStyleViewHolder extends BaseViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f228523a;

    public NoPermissionListStyleViewHolder(View r100) {
        super(r100);
        this.f228523a = (ViewGroup) r100.findViewById(R.id.item_content);
        AppCompatImageView r101 = (AppCompatImageView) r100.findViewById(R.id.item_icon);
        TextView r102 = (TextView) r100.findViewById(R.id.item_name);
    }
}
