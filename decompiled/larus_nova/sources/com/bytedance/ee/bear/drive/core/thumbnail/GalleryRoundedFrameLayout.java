package com.bytedance.ee.bear.drive.core.thumbnail;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u0014\u0010\u0018\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0007H\u0002R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/thumbnail/GalleryRoundedFrameLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cornerRadius", "", "getCornerRadius", "()F", "setCornerRadius", "(F)V", SVGRenderEngine.CLIP_PATH, "Landroid/graphics/Path;", "rectF", "Landroid/graphics/RectF;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "dp", "value", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryRoundedFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f224321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f224322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f224323c;

    public GalleryRoundedFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GalleryRoundedFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final float getCornerRadius() {
        return this.f224321a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = r100.save();
        this.f224323c.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f224322b.reset();
        Path r102 = this.f224322b;
        RectF r103 = this.f224323c;
        float r104 = this.f224321a;
        r102.addRoundRect(r103, r104, r104, Path.Direction.CW);
        r100.clipPath(this.f224322b);
        super.dispatchDraw(r100);
        r100.restoreToCount(r101);
    }

    public final void setCornerRadius(float r100) {
        this.f224321a = r100;
    }

    public GalleryRoundedFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Resources r103 = r100.getResources();
        this.f224321a = (int) ((3 * WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density) + 0.5f);
        this.f224322b = new Path();
        this.f224323c = new RectF();
    }

    public /* synthetic */ GalleryRoundedFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
