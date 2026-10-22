package com.bytedance.ee.bear.list.list;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.list.docstate.SyncStateView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.chad.library.adapter.base.BaseViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class GridStyleViewHolder extends BaseViewHolder {
    public final ViewGroup a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final View d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final TextView g;
    public final View h;
    public final SyncStateView i;
    public final AppCompatImageView j;
    public final SpaceTagTitleView k;

    public GridStyleViewHolder(View r3) {
        super(r3);
        ViewGroup r0 = (ViewGroup) r3.findViewById(2131373901);
        this.a = r0;
        this.b = r3.findViewById(2131378116);
        this.c = r3.findViewById(2131378107);
        this.d = r3.findViewById(2131378115);
        this.e = r3.findViewById(2131378113);
        this.f = r3.findViewById(2131378109);
        this.g = (TextView) r3.findViewById(2131378112);
        this.h = r3.findViewById(2131378114);
        this.i = (SyncStateView) r3.findViewById(2131378110);
        this.j = r0.findViewById(2131378094);
        this.k = (SpaceTagTitleView) r3.findViewById(2131378111);
    }
}
