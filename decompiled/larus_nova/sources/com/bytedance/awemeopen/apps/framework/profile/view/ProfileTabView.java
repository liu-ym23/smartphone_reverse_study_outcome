package com.bytedance.awemeopen.apps.framework.profile.view;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import r04.a;
import r04.b;
import r04.c;

/* JADX INFO: loaded from: classes14.dex */
public class ProfileTabView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f197515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f197516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f197517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f197518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f197519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f197520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f197521g;

    public final void b() {
        Resources r100 = getContext().getResources();
        float r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density;
        this.f197517c = (int) (8.0f * r101);
        this.f197518d = (int) (r101 * 3.0f);
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.f197519e = r102;
        r102.addUpdateListener(new a(this));
        this.f197519e.setDuration(300);
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f197520f = r103;
        r103.addUpdateListener(new b(this));
        this.f197520f.addListener(new c(this));
        this.f197520f.setDuration(300);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f197515a = (TextView) findViewById(R.id.text1);
        this.f197516b = (TextView) findViewById(com.larus.nova.R.id.description);
    }

    public ProfileTabView(Context r100) {
        super(r100);
        this.f197521g = false;
        b();
    }

    public void setAnimationEnabled(boolean r100) {
        this.f197521g = r100;
    }

    public void setDescription(String r100) {
        this.f197516b.setText(r100);
    }

    public void setDrawableLeft(Drawable r100) {
        this.f197515a.setCompoundDrawables(r100, null, null, null);
        this.f197515a.setCompoundDrawablesRelativeWithIntrinsicBounds(r100, null, null, null);
        this.f197515a.setCompoundDrawablePadding((int) n0.a(getContext(), 3.5f));
    }

    public void setDrawableRight(Drawable r100) {
        this.f197515a.setCompoundDrawables(null, null, r100, null);
        this.f197515a.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, r100, null);
        this.f197515a.setCompoundDrawablePadding((int) n0.a(getContext(), 3.5f));
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        this.f197519e.cancel();
        this.f197520f.cancel();
        if (r100 == false) goto L8;
        if (this.f197521g == false) goto L11;
        this.f197516b.setVisibility(0);
        this.f197519e.start();
        return;
    L11:
        return;
    L8:
        if (this.f197521g == false) goto L13;
        this.f197520f.start();
        return;
    }

    public void setText(String r100) {
        this.f197515a.setText(r100);
    }

    public void setTextColor(int r100) {
        this.f197515a.setTextColor(r100);
    }

    public ProfileTabView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f197521g = false;
        b();
    }

    public static void a(ProfileTabView r100, ValueAnimator r101) {
        r100.getClass();
        float r102 = ((Float) r101.getAnimatedValue()).floatValue();
        float r103 = r102 - 1.0f;
        r100.f197515a.setTranslationY(r100.f197517c * r103);
        float r104 = 1.0f - r102;
        float r105 = 1.0f - (0.13f * r104);
        r100.f197515a.setScaleX(r105);
        r100.f197515a.setScaleY(r105);
        r100.f197516b.setTranslationY(r103 * (r100.f197517c - r100.f197518d));
        r100.f197516b.setAlpha(r104);
    }

    public ProfileTabView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f197521g = false;
        b();
    }
}
