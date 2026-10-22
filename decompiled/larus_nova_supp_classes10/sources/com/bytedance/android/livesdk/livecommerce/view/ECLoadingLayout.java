package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.livesdk.livecommerce.utils.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class ECLoadingLayout extends FrameLayout {
    public ImageView a;

    public ECLoadingLayout(Context r1) {
        super(r1);
        a(r1);
    }

    public final void a(Context r9) {
        setClickable(true);
        this.a = new ImageView(r9);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(w0.a(20.0f), w0.a(20.0f));
        r2.gravity = 17;
        this.a.setLayoutParams(r2);
        this.a.setImageResource(2131234624);
        addView(this.a);
        RotateAnimation r10 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r10.setInterpolator(new LinearInterpolator());
        r10.setDuration(1000);
        r10.setRepeatCount(-1);
        r10.setFillAfter(true);
        r10.setStartOffset(0);
        this.a.setAnimation(r10);
    }

    public ECLoadingLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r1);
    }

    public ECLoadingLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a(r1);
    }
}
