package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.SizeF;
import android.view.LayoutInflater;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes16.dex */
public class PDFThumbnailSlider extends FrameLayout implements m85.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f225264q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PDFVerticalSliderBar f225265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f225266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f225267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f225268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f225269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f225270f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SizeF f225271g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a f225272h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f225273i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f225274j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Disposable f225275k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DriveComponentRenderVM f225276l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewPropertyAnimator f225277m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f225278n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final m0 f225279o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f225280p;

    public interface a {
        void a(int r100);

        void b();

        void c();
    }

    @Override // m85.a
    public String getReleaseKey() {
        return "PDFThumbnailSlider";
    }

    static {
        f225264q = com.bytedance.ee.util.ui.n.d(8);
    }

    public final void a() {
        tt5.a.h("PDFThumbnailSlider", "cancelAnimator, lastAnimator: " + this.f225277m);
        ViewPropertyAnimator r100 = this.f225277m;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.cancel();
        this.f225277m = null;
    }

    public final void b() {
        tt5.a.h("PDFThumbnailSlider", "cancelAutoHideTask");
        removeCallbacks(this.f225279o);
    }

    @Override // m85.a
    public final void onRelease() {
        tt5.a.h("PDFThumbnailSlider", "onRelease");
        b();
        a();
        Disposable r100 = this.f225275k;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L9;
        this.f225275k.dispose();
        return;
    }

    public final void e() {
        b();
        tt5.a.h("PDFThumbnailSlider", "startAutoHideTask");
        postDelayed(this.f225279o, 2000);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f225276l.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    public final void c(boolean r100) {
        float r101 = this.f225265a.getMeasuredWidth();
        tt5.a.h("PDFThumbnailSlider", "hide, isAnimate: " + r100 + ", sliderBarTranslationX: " + r101);
        b();
        a();
        if (r100 == true) goto L6;
        this.f225265a.setTranslationX(r101);
        setVisibility(8);
        return;
    L6:
        ViewPropertyAnimator r102 = this.f225265a.animate().setDuration(300).translationX(r101).withEndAction(new l0(this));
        this.f225277m = r102;
        r102.start();
    }

    public final void d(boolean r100) {
        tt5.a.h("PDFThumbnailSlider", "show, isAnimate: " + r100 + ", isAutoHide: " + this.f225278n);
        b();
        a();
        if (r100 == true) goto L8;
        this.f225265a.setTranslationX(0.0f);
        setVisibility(0);
        if (this.f225278n == false) goto L10;
        e();
        return;
    L10:
        return;
    L8:
        ViewPropertyAnimator r101 = this.f225265a.animate().setDuration(300).translationX(0.0f).withStartAction(new n0(this)).withEndAction(new o0(this));
        this.f225277m = r101;
        r101.start();
    }

    public void setAutoHide(boolean r100) {
        tt5.a.h("PDFThumbnailSlider", "setAutoHide, isAutoHide: " + r100);
        this.f225278n = r100;
        if (r100 == true) goto L5;
        b();
        return;
    L5:
        if (getVisibility() == 0) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L14;
        e();
        return;
    L14:
        return;
    L7:
        if (this.f225265a.getTranslationX() != 0.0f) goto L9;
        r101 = true;
        goto L10
    }

    public void setViewDelegate(a r100) {
        this.f225274j = r100;
    }

    /* JADX WARN: Type inference failed for: r7v4, types: [com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.m0] */
    public PDFThumbnailSlider(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f225273i = -1;
        this.f225277m = null;
        this.f225278n = false;
        this.f225279o = new m0(this);
        int r102 = com.bytedance.ee.util.ui.n.d(100);
        int r103 = com.bytedance.ee.util.ui.n.d(4);
        Resources r104 = eu5.b.f474075a.getResources();
        this.f225280p = (int) Math.floor(((double) WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).widthPixels) / ((double) (r102 + r103)));
        LayoutInflater.from(r100).inflate(R.layout.drive_controls_thumbnail_slider, this);
        this.f225265a = (PDFVerticalSliderBar) findViewById(R.id.drive_pdf_indicator_slider);
        FrameLayout r105 = (FrameLayout) findViewById(R.id.controls_thumbnail_slider_thumbview);
        this.f225266b = r105;
        this.f225267c = (ImageView) r105.findViewById(R.id.drive_controls_thumbnail_slider_thumbview_thumb);
        this.f225268d = (FrameLayout) this.f225266b.findViewById(R.id.thumbview_thumb_layout);
        this.f225269e = (TextView) this.f225266b.findViewById(R.id.drive_controls_thumbnail_slider_thumbview_pagenumber);
    }
}
