package com.bytedance.ee.bear.wikiv2.common.widget;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ExpandButton extends FrameLayout {
    public ImageView a;
    public TextView b;
    public final AnimatorSet c;

    public final void a() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131568256, this, true);
        this.a = (ImageView) r0.findViewById(2131376221);
        this.b = (TextView) r0.findViewById(2131390581);
    }

    public ExpandButton(Context r1) {
        super(r1);
        this.c = new AnimatorSet();
        a();
    }

    public ExpandButton(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = new AnimatorSet();
        a();
    }

    public ExpandButton(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = new AnimatorSet();
        a();
    }
}
