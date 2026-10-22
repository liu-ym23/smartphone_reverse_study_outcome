package com.bytedance.ee.bear.middleground.permission.batchauthorize;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class AuthDocViewHolder extends BaseViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SwipeMenuLayout f233102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f233103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f233104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f233105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f233106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f233107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f233108g;

    public AuthDocViewHolder(View r100) {
        super(r100);
        this.f233102a = (SwipeMenuLayout) r100.findViewById(R.id.list_item);
        this.f233103b = (ConstraintLayout) r100.findViewById(R.id.item_content);
        this.f233104c = (ImageView) r100.findViewById(R.id.item_icon);
        this.f233105d = (TextView) r100.findViewById(R.id.item_name);
        this.f233106e = (TextView) r100.findViewById(R.id.creator_button);
        this.f233107f = (TextView) r100.findViewById(R.id.auth_dep_tx);
        this.f233108g = (TextView) r100.findViewById(R.id.swipe_menu_operate);
    }
}
