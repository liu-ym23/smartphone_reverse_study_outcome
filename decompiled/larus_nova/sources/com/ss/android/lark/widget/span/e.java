package com.ss.android.lark.widget.span;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f448662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f448663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f448664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f448665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f448666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f448667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f448668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f448669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f448670i;

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
        return this.f448662a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f448662a.getIntrinsicWidth();
    }

    public e(VideoImageSpan.b r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f448662a = r100;
        Paint r101 = new Paint(1);
        r101.setStyle(Paint.Style.STROKE);
        r101.setStrokeCap(Paint.Cap.ROUND);
        r101.setStrokeWidth(UIHelper.dp2px(2.0f));
        r101.setColor(UDColorUtils.getColor(LarkContext.getApplication(), R.color.static_white));
        this.f448664c = r101;
        Paint r102 = new Paint(1);
        r102.setStyle(Paint.Style.FILL);
        r102.setColor(1711276032);
        this.f448665d = r102;
        this.f448666e = new RectF();
        this.f448669h = new Handler(Looper.getMainLooper());
        this.f448670i = new f(this);
        r100.setCallback(this);
        setBounds(r100.getBounds());
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        this.f448662a.draw(r110);
        if (this.f448663b == true) goto L5;
        return;
    L5:
        Rect r100 = this.f448662a.getBounds();
        float r101 = r100.left + (r100.width() / 2.0f);
        float r102 = r100.top + (r100.height() / 2.0f);
        float r103 = UIHelper.dp2px(10.0f);
        r110.drawCircle(r101, r102, UIHelper.dp2px(6.0f) + r103, this.f448665d);
        this.f448666e.set(r101 - r103, r102 - r103, r101 + r103, r102 + r103);
        r110.drawArc(this.f448666e, this.f448667f, 270.0f, false, this.f448664c);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f448662a.setAlpha(r100);
        this.f448664c.setAlpha(r100);
        this.f448665d.setAlpha((int) (r100 * 0.4f));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f448662a.setColorFilter(r100);
        this.f448664c.setColorFilter(r100);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "who");
        Intrinsics.checkNotNullParameter(r101, "what");
        unscheduleSelf(r101);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "who");
        Intrinsics.checkNotNullParameter(r101, "what");
        scheduleSelf(r101, r102);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int r100, int r101, int r102, int r103) {
        super.setBounds(r100, r101, r102, r103);
        this.f448662a.setBounds(r100, r101, r102, r103);
    }
}
