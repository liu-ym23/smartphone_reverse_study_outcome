package com.larus.dora.impl.device.settings.gesture.widget;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0010J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/widget/DoraGestureGuidanceMaskView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maskColor", "hollowPath", "Landroid/graphics/Path;", "paint", "Landroid/graphics/Paint;", "targetRect", "Landroid/graphics/RectF;", "porterDuffXfermode", "Landroid/graphics/PorterDuffXfermode;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setTargetRect", SVGRenderEngine.RECT, "setDarkMode", "isDarkMode", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGestureGuidanceMaskView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f334541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f334542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f334543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PorterDuffXfermode f334544d;

    public static final class a {
    }

    static {
    }

    public DoraGestureGuidanceMaskView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DoraGestureGuidanceMaskView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        this.f334541a.reset();
        this.f334541a.addRect(0.0f, 0.0f, getWidth(), getHeight(), Path.Direction.CW);
        RectF r101 = this.f334543c;
        if (r101 == null) goto L5;
        this.f334541a.addRect(r101, Path.Direction.CCW);
    L5:
        this.f334542b.setXfermode(this.f334544d);
        r100.drawPath(this.f334541a, this.f334542b);
        this.f334542b.setXfermode(null);
    }

    public final void setDarkMode(boolean r100) {
        if (r100 == false) goto L4;
        float r101 = 0.6f;
    L5:
        this.f334542b.setAlpha((int) (255 * r101));
        return;
    L4:
        r101 = 0.15f;
        goto L5
    }

    public final void setTargetRect(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        this.f334543c = r100;
        invalidate();
    }

    public DoraGestureGuidanceMaskView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = ContextCompat.getColor(r100, R.color.black);
        this.f334541a = new Path();
        Paint r104 = new Paint();
        r104.setAntiAlias(true);
        r104.setColor(r103);
        r104.setMaskFilter(new BlurMaskFilter(20.0f, BlurMaskFilter.Blur.NORMAL));
        this.f334542b = r104;
        this.f334544d = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }

    public /* synthetic */ DoraGestureGuidanceMaskView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
