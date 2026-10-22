package com.bytedance.ee.bear.middleground.permission.batchauthorize;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.chad.library.adapter.base.BaseViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AuthDocViewHolder extends BaseViewHolder {
    public final SwipeMenuLayout a;
    public final ConstraintLayout b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;

    public AuthDocViewHolder(View r2) {
        super(r2);
        this.a = r2.findViewById(2131378129);
        this.b = r2.findViewById(2131375720);
        this.c = (ImageView) r2.findViewById(2131375773);
        this.d = (TextView) r2.findViewById(2131375808);
        this.e = (TextView) r2.findViewById(2131368278);
        this.f = (TextView) r2.findViewById(2131363553);
        this.g = (TextView) r2.findViewById(2131387822);
    }
}
