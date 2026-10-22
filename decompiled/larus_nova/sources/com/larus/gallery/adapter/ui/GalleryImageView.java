package com.larus.gallery.adapter.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.byted.cast.common.CastMonitor;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015J\u001d\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001eJ\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020\u0017H\u0014J\b\u0010#\u001a\u00020\u0017H\u0016J0\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0014J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0016J\u0018\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020&H\u0016Jl\u00101\u001a\u00020\u00172\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00072\n\b\u0002\u00106\u001a\u0004\u0018\u0001072\b\b\u0002\u00108\u001a\u00020&2\u0018\u00109\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00170:2\u001a\u0010;\u001a\u0016\u0012\u0004\u0012\u00020<\u0012\u0006\u0012\u0004\u0018\u00010=\u0012\u0004\u0012\u00020\u00170:J,\u0010>\u001a\u0004\u0018\u00010?2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u00072\u0006\u00108\u001a\u00020&H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/larus/gallery/adapter/ui/GalleryImageView;", "Lcom/larus/gallery/adapter/ui/BaseScaleGalleryView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tag", "", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "invalidateOutlineRunnable", "Ljava/lang/Runnable;", "scalableView", "Landroid/view/View;", "getScalableView", "()Landroid/view/View;", "fitCenterWithOffset", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "updateScaleType", "", "scaleType", "currentRadiusPx", "", "setContentInsetsAndRadius", "topPx", "radiusPx", "setContentInsetsAndRadius$gallery_mainlandRelease", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "onStartTemporaryDetach", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "left", "top", "right", "bottom", "getScalableViewBounds", "Landroid/graphics/RectF;", "imageBounds", "setCenteringProgress", "progress", "isReset", "loadImage", "image", "Lcom/larus/gallery/api/GalleryImage;", "width", "height", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "enableDownScale", "updateLoadingRetry", "Lkotlin/Function2;", "onLoadComplete", "Lcom/larus/gallery/adapter/ImageSetResult;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "buildResizeOptions", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "gallery_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryImageView extends BaseScaleGalleryView {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f343750v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final SimpleDraweeView f343751w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final j f343752x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ScalingUtils.ScaleType f343753y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f343754z;

    public GalleryImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GalleryImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        FLogger.f375446a.i(this.f343750v, "[onDetachedFromWindow] start");
        this.f343751w.removeCallbacks(this.f343752x);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        FLogger.f375446a.i(this.f343750v, "[onStartTemporaryDetach] start");
        this.f343751w.removeCallbacks(this.f343752x);
        super.onStartTemporaryDetach();
    }

    @Override // com.larus.gallery.adapter.ui.BaseScaleGalleryView
    public View getScalableView() {
        return this.f343751w;
    }

    @Override // com.larus.gallery.adapter.ui.BaseScaleGalleryView
    public final RectF a(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "imageBounds");
        this.f343751w.getHierarchy().getActualImageBounds(r100);
        return r100;
    }

    @Override // com.larus.gallery.adapter.ui.BaseScaleGalleryView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        String r101 = e.getMessage();
        boolean r102 = false;
        if (r101 != null) goto L9;
    L11:
        if (r102 == false) goto L14;
        FLogger.f375446a.w(this.f343750v, "[dispatchDraw] caught recycled bitmap exception, clear drawable");
        this.f343751w.setImageDrawable(null);
        return;
    L14:
        throw e;
    L9:
        if (StringsKt.contains$default(r101, "recycled bitmap", false, 2, null) != true) goto L11;
        r102 = true;
        goto L11
    }

    @Override // com.larus.gallery.adapter.ui.BaseScaleGalleryView
    public final void i(float r100, boolean r101) {
        ScalingUtils.ScaleType r102 = this.f343753y;
        if ((r102 instanceof i) == false) goto L11;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.larus.gallery.adapter.ui.FitCenterWithOffset");
        if (((i) r102).f343775f != r100) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L12;
        ScalingUtils.ScaleType r104 = this.f343753y;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.larus.gallery.adapter.ui.FitCenterWithOffset");
        ((i) r104).f343775f = r100;
        this.f343751w.invalidate();
        return;
    L12:
        return;
    L7:
        r103 = false;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.gallery.adapter.ui.j] */
    public GalleryImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 8);
        this.f343750v = "GalleryImageView";
        SimpleDraweeView r103 = new SimpleDraweeView(r100);
        this.f343751w = r103;
        this.f343752x = new j(this);
        this.f343753y = ScalingUtils.ScaleType.FIT_CENTER;
        r103.setHierarchy(new GenericDraweeHierarchyBuilder(getResources()).setActualImageScaleType(this.f343753y).build());
        addView(r103, new FrameLayout.LayoutParams(-1, -1));
    }

    public /* synthetic */ GalleryImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // com.larus.gallery.adapter.ui.BaseScaleGalleryView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == true) goto L5;
        return;
    L5:
        if (this.f343751w.isAttachedToWindow() == false) goto L9;
        this.f343751w.invalidateOutline();
        return;
    }
}
