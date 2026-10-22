package com.ss.android.lark.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public class RotateLoadingView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f444564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObjectAnimator f444565b;

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator r100 = this.f444565b;
        if (r100 == null) goto L6;
        r100.end();
        return;
    }

    public RotateLoadingView(Context r100) {
        this(r100, null);
    }

    public RotateLoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);
        ObjectAnimator r102 = this.f444565b;
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
        this.f444564a = r104;
        if (r104 != null) goto L5;
        this.f444564a = AppCompatResources.getDrawable(r100, R.drawable.rotate_loading);
    L5:
        r103.recycle();
        setImageDrawable(this.f444564a);
        ObjectAnimator r105 = ObjectAnimator.ofFloat(this, "rotation", new float[]{0.0f, 360.0f});
        this.f444565b = r105;
        r105.setRepeatCount(-1);
        this.f444565b.setInterpolator(new LinearInterpolator());
        this.f444565b.setRepeatMode(1);
        this.f444565b.setDuration(1000);
        this.f444565b.start();
    }
}
