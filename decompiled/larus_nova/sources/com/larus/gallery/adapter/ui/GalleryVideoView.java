package com.larus.gallery.adapter.ui;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0006\u0010\u001c\u001a\u00020\u000bJ\u0010\u0010\u001d\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/larus/gallery/adapter/ui/GalleryVideoView;", "Lcom/larus/gallery/adapter/ui/BaseScaleGalleryView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "videoPlayView", "Lcom/larus/gallery/adapter/ui/GalleryVideoPlayView;", "scalableView", "Landroid/view/View;", "getScalableView", "()Landroid/view/View;", "setCenteringProgress", "", "progress", "", "isReset", "", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "getScalableViewBounds", "Landroid/graphics/RectF;", "imageBounds", "getVideoPlayView", "setDisplayConfig", "config", "Lcom/larus/gallery/api/DisplayAreaConfig;", "gallery_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryVideoView extends BaseScaleGalleryView {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final GalleryVideoPlayView f343756v;

    public GalleryVideoView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GalleryVideoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return true;
    }

    @Override // com.larus.gallery.adapter.ui.BaseScaleGalleryView
    public View getScalableView() {
        return this.f343756v;
    }

    public final GalleryVideoPlayView getVideoPlayView() {
        return this.f343756v;
    }

    @Override // com.larus.gallery.adapter.ui.BaseScaleGalleryView
    public final RectF a(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "imageBounds");
        int r101 = this.f343756v.getVideoWidth();
        int r102 = this.f343756v.getVideoHeight();
        float r103 = (this.f343756v.getWidth() - r101) / 2.0f;
        float r104 = ((this.f343756v.getHeight() - r102) / 2.0f) + this.f343756v.getOffset();
        r100.set(r103, r104, r101 + r103, r102 + r104);
        return r100;
    }

    public final void setDisplayConfig(com.larus.gallery.api.a r100) {
        if (r100 == null) goto L5;
        this.f343756v.setDisplayConfig(r100);
        return;
    }

    @Override // com.larus.gallery.adapter.ui.BaseScaleGalleryView
    public final void i(float r100, boolean r101) {
        GalleryVideoPlayView r102 = this.f343756v;
        r102.getClass();
        FLogger.f375446a.i(r102.G1, "setCenteringProgress progress:" + r100 + ", isReset:" + r101 + ' ' + r102.L1 + ' ' + r102.H1);
        r102.T1 = r100;
        int r103 = r102.L1;
        if (r103 == 0) goto L8;
        r102.H1 = (int) (r103 * (1.0f - r100));
        if (r101 == false) goto L9;
        r102.m();
        return;
    L9:
        return;
    }

    public GalleryVideoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 8);
        GalleryVideoPlayView r103 = new GalleryVideoPlayView(r100, r101, r102);
        this.f343756v = r103;
        addView(r103, new FrameLayout.LayoutParams(-1, -1));
    }

    public /* synthetic */ GalleryVideoView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
