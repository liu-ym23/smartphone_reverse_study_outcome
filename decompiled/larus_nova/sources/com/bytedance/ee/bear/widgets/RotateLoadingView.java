package com.bytedance.ee.bear.widgets;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class RotateLoadingView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f240116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObjectAnimator f240117b;

    public RotateLoadingView(Context r100) {
        this(r100, null);
    }

    public RotateLoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);
        ObjectAnimator r102 = this.f240117b;
        if (r102 == null) goto L8;
        if (r101 != 0) goto L6;
        r102.start();
        return;
    L6:
        r102.end();
        return;
    }

    public RotateLoadingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.rotate_src});
        Drawable r104 = r103.getDrawable(0);
        this.f240116a = r104;
        if (r104 != null) goto L5;
        this.f240116a = r100.getDrawable(R.drawable.rotate_loading);
    L5:
        r103.recycle();
        setImageDrawable(this.f240116a);
        ObjectAnimator r105 = ObjectAnimator.ofFloat(this, "rotation", new float[]{0.0f, 360.0f});
        this.f240117b = r105;
        r105.setRepeatCount(-1);
        this.f240117b.setInterpolator(new LinearInterpolator());
        this.f240117b.setRepeatMode(1);
        this.f240117b.setDuration(1000);
        this.f240117b.start();
    }
}
