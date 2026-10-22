package com.bytedance.locallife.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/live/view/RadiusFrameLayout;", "Landroid/widget/FrameLayout;", "", "radius", "", "setRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class RadiusFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f260808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f260809b;

    public RadiusFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f260809b = new Path();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float[] r101 = this.f260808a;
        if (r101 == null) goto L5;
        RectF r102 = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.f260809b.reset();
        this.f260809b.addRoundRect(r102, r101, Path.Direction.CW);
        r100.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        r100.clipPath(this.f260809b);
    L5:
        super.dispatchDraw(r100);
    }

    public final void setRadius(float r100) {
        this.f260808a = new float[]{r100, r100, r100, r100, r100, r100, r100, r100};
        invalidate();
    }

    public RadiusFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f260809b = new Path();
    }

    public final void a(float r100, float r101) {
        float r102 = 0;
        if (0.0f > r102) goto L9;
        if (0.0f > r102) goto L9;
        if (r101 > r102) goto L9;
        if (r100 > r102) goto L9;
        return;
    L9:
        this.f260808a = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r100, r100, r101, r101};
        invalidate();
    }

    public RadiusFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f260809b = new Path();
    }
}
