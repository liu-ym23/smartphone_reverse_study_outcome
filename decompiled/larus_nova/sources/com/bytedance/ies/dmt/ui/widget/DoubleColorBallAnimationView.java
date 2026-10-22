package com.bytedance.ies.dmt.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.dux.drawable.doubleballV2.DoubleV2Scene;
import com.larus.nova.R;
import em4.k;

/* JADX INFO: loaded from: classes19.dex */
public class DoubleColorBallAnimationView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.dux.drawable.DoubleColorBallAnimationView f248442a;

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k.a("widget/DoubleColorBallAnimationView>>>onDetachedFromWindow");     // Catch: Exception -> L5
        this.f248442a.b();     // Catch: Exception -> L5
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public DoubleColorBallAnimationView(Context r100) {
        this(r100, null);
    }

    public void setCycleBias(int r100) {
        this.f248442a.setCycleBias(r100);
    }

    public void setProgress(float r100) {
        this.f248442a.setProgress(r100);
    }

    public void setProgressBarInfo(int r100) {
        this.f248442a.setProgressBarInfo(r100);
    }

    public void setStartAnimationAfterAttach(boolean r100) {
        this.f248442a.setStartAnimationAfterAttach(r100);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        this.f248442a.setVisibility(r100);
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, DoubleV2Scene.defaultscene.name());
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, DoubleV2Scene.defaultscene.name());
    }

    public DoubleColorBallAnimationView(Context r100, AttributeSet r101, int r110, String r111) {
        super(r100, r101, r110);
        if (com.bytedance.dux.drawable.DoubleColorBallAnimationView.c() == true) goto L15;
    L13:
        com.bytedance.dux.drawable.DoubleColorBallAnimationView r112 = new com.bytedance.dux.drawable.DoubleColorBallAnimationView(r100, r101, 0, r111, com.bytedance.dux.drawable.DoubleColorBallAnimationView.c());
        this.f248442a = r112;
        addView(r112, new ViewGroup.LayoutParams(-1, -1));
        return;
    L15:
        TypedArray r113 = r100.obtainStyledAttributes(r101, new int[]{R.attr.dmt_doublecolorball_scene});     // Catch: Exception -> L12
        String r102 = r113.getString(0);     // Catch: Exception -> L12
        if (r102 != null) goto L8;
    L10:
        r113.recycle();     // Catch: Exception -> L12
        goto L13
    L8:
        if (r102.isEmpty() == true) goto L10;
        r111 = r102;
    L12:
        em4.d.b("DuxLogger", "DoubleColorBall init get attribute error");
        goto L13
    }
}
