package com.ss.android.bytedcert.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import usa.c;
import usa.e;
import usa.f;

/* JADX INFO: loaded from: classes34.dex */
public class ScrollTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f407781e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f407782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f407783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f407784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f407785d;

    public c getScrollCallback() {
        return null;
    }

    public void setScrollCallback(c r100) {
    }

    public int getNormalColor() {
        return this.f407782a;
    }

    public int getPlayColor() {
        return this.f407783b;
    }

    public ScrollTextView(Context r100) {
        this(r100, null, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        this.f407784c.setColor(this.f407782a);
        if (getLayout() != null) goto L6;
        invalidate();
        return;
    }

    public void setNormalColor(int r100) {
        this.f407782a = r100;
    }

    public void setPlayColor(int r100) {
        this.f407783b = r100;
    }

    public ScrollTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public ScrollTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f407782a = -1;
        this.f407783b = getResources().getColor(R.color.byted_yellow);
        this.f407784c = getPaint();
        new Path();
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f407785d = r103;
        r103.setInterpolator(new LinearInterpolator());
        this.f407785d.addUpdateListener(new e(this));
        this.f407785d.addListener(new f(this));
    }
}
