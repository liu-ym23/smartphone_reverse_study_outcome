package com.bytedance.ee.bear.drive.core.thumbnail;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u0014\u0010\u0018\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0007H\u0002R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/thumbnail/GalleryRoundedFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cornerRadius", "", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "clipPath", "Landroid/graphics/Path;", "rectF", "Landroid/graphics/RectF;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "dp", "value", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryRoundedFrameLayout extends FrameLayout {
    public float a;
    public final Path b;
    public final RectF c;

    public GalleryRoundedFrameLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GalleryRoundedFrameLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final float getCornerRadius() {
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        int r0 = r6.save();
        this.c.set(0.0f, 0.0f, getWidth(), getHeight());
        this.b.reset();
        Path r1 = this.b;
        RectF r2 = this.c;
        float r3 = this.a;
        r1.addRoundRect(r2, r3, r3, Path.Direction.CW);
        r6.clipPath(this.b);
        super.dispatchDraw(r6);
        r6.restoreToCount(r0);
    }

    public final void setCornerRadius(float r1) {
        this.a = r1;
    }

    public GalleryRoundedFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Resources r5 = r2.getResources();
        this.a = (int) ((3 * WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density) + 0.5f);
        this.b = new Path();
        this.c = new RectF();
    }

    public /* synthetic */ GalleryRoundedFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
