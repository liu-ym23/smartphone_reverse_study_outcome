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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ProfileTabView extends RelativeLayout {
    public TextView a;
    public TextView b;
    public int c;
    public int d;
    public ValueAnimator e;
    public ValueAnimator f;
    public boolean g;

    public final void b() {
        Resources r0 = getContext().getResources();
        float r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density;
        this.c = (int) (8.0f * r1);
        this.d = (int) (r1 * 3.0f);
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.e = r2;
        r2.addUpdateListener(new a(this));
        this.e.setDuration(300);
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f = r3;
        r3.addUpdateListener(new b(this));
        this.f.addListener(new c(this));
        this.f.setDuration(300);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TextView) findViewById(R.id.text1);
        this.b = (TextView) findViewById(2131368849);
    }

    public ProfileTabView(Context r1) {
        super(r1);
        this.g = false;
        b();
    }

    public void setAnimationEnabled(boolean r1) {
        this.g = r1;
    }

    public void setDescription(String r2) {
        this.b.setText(r2);
    }

    public void setDrawableLeft(Drawable r3) {
        this.a.setCompoundDrawables(r3, null, null, null);
        this.a.setCompoundDrawablesRelativeWithIntrinsicBounds(r3, null, null, null);
        this.a.setCompoundDrawablePadding((int) n0.a(getContext(), 3.5f));
    }

    public void setDrawableRight(Drawable r3) {
        this.a.setCompoundDrawables(null, null, r3, null);
        this.a.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, r3, null);
        this.a.setCompoundDrawablePadding((int) n0.a(getContext(), 3.5f));
    }

    @Override // android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        this.e.cancel();
        this.f.cancel();
        if (r2 == false) goto L8;
        if (this.g == false) goto L11;
        this.b.setVisibility(0);
        this.e.start();
        return;
    L11:
        return;
    L8:
        if (this.g == false) goto L13;
        this.f.start();
        return;
    }

    public void setText(String r2) {
        this.a.setText(r2);
    }

    public void setTextColor(int r2) {
        this.a.setTextColor(r2);
    }

    public ProfileTabView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.g = false;
        b();
    }

    public static void a(ProfileTabView r4, ValueAnimator r5) {
        r4.getClass();
        float r6 = ((Float) r5.getAnimatedValue()).floatValue();
        float r2 = r6 - 1.0f;
        r4.a.setTranslationY(r4.c * r2);
        float r7 = 1.0f - r6;
        float r1 = 1.0f - (0.13f * r7);
        r4.a.setScaleX(r1);
        r4.a.setScaleY(r1);
        r4.b.setTranslationY(r2 * (r4.c - r4.d));
        r4.b.setAlpha(r7);
    }

    public ProfileTabView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.g = false;
        b();
    }
}
