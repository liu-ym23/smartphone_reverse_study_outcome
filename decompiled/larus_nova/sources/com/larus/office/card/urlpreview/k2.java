package com.larus.office.card.urlpreview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.graphics.ColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class k2 extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f361953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f361954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f361955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f361956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearGradient f361957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f361958f;

    public static final class a {
    }

    static {
    }

    public final void b() {
        ValueAnimator r100 = this.f361958f;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f361958f = null;
    }

    public final void a() {
        if (getWidth() <= 0) goto L14;
        ValueAnimator r100 = this.f361958f;
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L15;
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, getWidth() * 2.0f});
        r102.setDuration(1500);
        r102.setRepeatCount(-1);
        r102.setInterpolator(new LinearInterpolator());
        r102.addUpdateListener(new j2(this));
        r102.start();
        this.f361958f = r102;
        return;
    L15:
        return;
    L7:
        if (r100.isRunning() != true) goto L9;
        r101 = true;
        goto L10
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new i2(this));
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        float r100 = getHeight() / 2.0f;
        r110.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), r100, r100, this.f361953a);
    }

    public k2(Context r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f361953a = new Paint(1);
        this.f361954b = new Matrix();
        int r103 = v19.c.a(R.attr.larus_neutral_transparent_2, r100, R.color.larus_neutral_transparent_2);
        this.f361955c = ColorUtils.setAlphaComponent(r103, RangesKt.coerceAtLeast((int) (Color.alpha(r103) * r101), 1));
        this.f361956d = ColorUtils.setAlphaComponent(r103, RangesKt.coerceAtLeast((int) (Color.alpha(r103) * r102), 1));
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        if (r100 <= 0) goto L5;
        int r113 = this.f361955c;
        LinearGradient r114 = new LinearGradient(-r100, 0.0f, 0.0f, 0.0f, new int[]{r113, this.f361956d, r113}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.f361953a.setShader(r114);
    L6:
        this.f361957e = r114;
        if (isAttachedToWindow() == false) goto L10;
        post(new i2(this));
        return;
    L10:
        return;
    L5:
        r114 = null;
        goto L6
    }
}
