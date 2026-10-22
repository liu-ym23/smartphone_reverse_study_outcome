package com.bytedance.ee.bear.widgets;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RotateLoadingView extends AppCompatImageView {
    public Drawable a;
    public ObjectAnimator b;

    public RotateLoadingView(Context r2) {
        this(r2, null);
    }

    public RotateLoadingView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onVisibilityChanged(View r1, int r2) {
        super/*android.widget.ImageView*/.onVisibilityChanged(r1, r2);
        ObjectAnimator r3 = this.b;
        if (r3 == null) goto L8;
        if (r2 != 0) goto L6;
        r3.start();
        return;
    L6:
        r3.end();
        return;
    }

    public RotateLoadingView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130973829});
        Drawable r0 = r7.getDrawable(0);
        this.a = r0;
        if (r0 != null) goto L5;
        this.a = r4.getDrawable(2131247476);
    L5:
        r7.recycle();
        setImageDrawable(this.a);
        ObjectAnimator r8 = ObjectAnimator.ofFloat(this, "rotation", new float[]{0.0f, 360.0f});
        this.b = r8;
        r8.setRepeatCount(-1);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.setRepeatMode(1);
        this.b.setDuration(1000);
        this.b.start();
    }
}
