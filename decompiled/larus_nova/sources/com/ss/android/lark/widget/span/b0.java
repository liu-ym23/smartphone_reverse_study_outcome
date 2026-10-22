package com.ss.android.lark.widget.span;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.animation.DecelerateInterpolator;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b0 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f448650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f448651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f448652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f448653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f448654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f448655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f448656g;

    public static final class a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) (this.f448650a * 2);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return (int) (this.f448650a * 2);
    }

    public b0(float r100) {
        this.f448650a = r100;
        int r101 = UDColorUtils.getColor(LarkContext.getApplication(), R.color.icon_n2);
        Paint r102 = new Paint();
        r102.setColor(r101);
        this.f448651b = r102;
        this.f448652c = Color.alpha(r101);
        this.f448653d = Color.red(r101);
        this.f448654e = Color.blue(r101);
        this.f448655f = Color.green(r101);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        ValueAnimator r101 = this.f448656g;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == true) goto L15;
        ValueAnimator r103 = this.f448656g;
        if (r103 == null) goto L11;
        r103.removeAllListeners();
    L11:
        ValueAnimator r104 = this.f448656g;
        if (r104 == null) goto L14;
        r104.end();
    L14:
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r105.setDuration(901);
        r105.setRepeatMode(1);
        r105.setRepeatCount(-1);
        r105.setInterpolator(new DecelerateInterpolator());
        r105.addUpdateListener(new c0(this));
        r105.start();
        this.f448656g = r105;
    L15:
        r100.save();
        float r106 = this.f448650a;
        r100.drawCircle(r106, r106, r106, this.f448651b);
        r100.restore();
        return;
    L5:
        if (r101.isRunning() != true) goto L7;
        r102 = true;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f448651b.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f448651b.setColorFilter(r100);
    }
}
