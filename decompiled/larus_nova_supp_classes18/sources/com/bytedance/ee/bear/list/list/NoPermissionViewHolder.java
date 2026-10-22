package com.bytedance.ee.bear.list.list;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.chad.library.adapter.base.BaseViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class NoPermissionViewHolder extends BaseViewHolder {
    public final ViewGroup a;
    public final ViewGroup b;

    public NoPermissionViewHolder(View r2) {
        super(r2);
        this.a = (ViewGroup) r2.findViewById(2131375720);
        AppCompatImageView r0 = r2.findViewById(2131375773);
        TextView r1 = (TextView) r2.findViewById(2131375808);
        this.b = (ViewGroup) r2.findViewById(2131373901);
        AppCompatImageView r3 = r2.findViewById(2131378116);
        AppCompatImageView r4 = r2.findViewById(2131378113);
        TextView r5 = (TextView) r2.findViewById(2131378112);
    }
}
