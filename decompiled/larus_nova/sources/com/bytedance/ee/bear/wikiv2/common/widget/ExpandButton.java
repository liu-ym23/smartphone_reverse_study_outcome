package com.bytedance.ee.bear.wikiv2.common.widget;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class ExpandButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f240643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f240644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AnimatorSet f240645c;

    public final void a() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.wiki_space_detail_expand_btn_v2, this, true);
        this.f240643a = (ImageView) r100.findViewById(R.id.iv_expand);
        this.f240644b = (TextView) r100.findViewById(R.id.tv_expand);
    }

    public ExpandButton(Context r100) {
        super(r100);
        this.f240645c = new AnimatorSet();
        a();
    }

    public ExpandButton(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f240645c = new AnimatorSet();
        a();
    }

    public ExpandButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f240645c = new AnimatorSet();
        a();
    }
}
