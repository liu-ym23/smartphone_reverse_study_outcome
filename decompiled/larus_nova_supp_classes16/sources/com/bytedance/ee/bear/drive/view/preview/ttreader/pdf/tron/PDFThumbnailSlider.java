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
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PDFThumbnailSlider extends FrameLayout implements m85.a {
    public static final int q = 0;
    public PDFVerticalSliderBar a;
    public FrameLayout b;
    public ImageView c;
    public FrameLayout d;
    public TextView e;
    public int f;
    public SizeF g;
    public com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a h;
    public int i;
    public a j;
    public Disposable k;
    public DriveComponentRenderVM l;
    public ViewPropertyAnimator m;
    public boolean n;
    public final m0 o;
    public final int p;

    public interface a {
        void a(int r1);

        void b();

        void c();
    }

    @Override // m85.a
    public String getReleaseKey() {
        return "PDFThumbnailSlider";
    }

    static {
        q = com.bytedance.ee.util.ui.n.d(8);
    }

    public final void a() {
        tt5.a.h("PDFThumbnailSlider", "cancelAnimator, lastAnimator: " + this.m);
        ViewPropertyAnimator r0 = this.m;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.cancel();
        this.m = null;
    }

    public final void b() {
        tt5.a.h("PDFThumbnailSlider", "cancelAutoHideTask");
        removeCallbacks(this.o);
    }

    @Override // m85.a
    public final void onRelease() {
        tt5.a.h("PDFThumbnailSlider", "onRelease");
        b();
        a();
        Disposable r0 = this.k;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        this.k.dispose();
        return;
    }

    public final void e() {
        b();
        tt5.a.h("PDFThumbnailSlider", "startAutoHideTask");
        postDelayed(this.o, 2000);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.l.needBindReleaseListener() == true) goto L6;
        onRelease();
        return;
    }

    public final void c(boolean r4) {
        float r0 = this.a.getMeasuredWidth();
        tt5.a.h("PDFThumbnailSlider", "hide, isAnimate: " + r4 + ", sliderBarTranslationX: " + r0);
        b();
        a();
        if (r4 == true) goto L6;
        this.a.setTranslationX(r0);
        setVisibility(8);
        return;
    L6:
        ViewPropertyAnimator r5 = this.a.animate().setDuration(300).translationX(r0).withEndAction(new l0(this));
        this.m = r5;
        r5.start();
    }

    public final void d(boolean r4) {
        tt5.a.h("PDFThumbnailSlider", "show, isAnimate: " + r4 + ", isAutoHide: " + this.n);
        b();
        a();
        if (r4 == true) goto L8;
        this.a.setTranslationX(0.0f);
        setVisibility(0);
        if (this.n == false) goto L10;
        e();
        return;
    L10:
        return;
    L8:
        ViewPropertyAnimator r5 = this.a.animate().setDuration(300).translationX(0.0f).withStartAction(new n0(this)).withEndAction(new o0(this));
        this.m = r5;
        r5.start();
    }

    public void setAutoHide(boolean r3) {
        tt5.a.h("PDFThumbnailSlider", "setAutoHide, isAutoHide: " + r3);
        this.n = r3;
        if (r3 == true) goto L5;
        b();
        return;
    L5:
        if (getVisibility() == 0) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L14;
        e();
        return;
    L14:
        return;
    L7:
        if (this.a.getTranslationX() != 0.0f) goto L9;
        r4 = true;
        goto L10
    }

    public void setViewDelegate(a r1) {
        this.j = r1;
    }

    /* JADX WARN: Type inference failed for: r7v4, types: [com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.m0] */
    public PDFThumbnailSlider(Context r6, AttributeSet r7) {
        super(r6, r7);
        this.i = -1;
        this.m = null;
        this.n = false;
        this.o = new m0(this);
        int r8 = com.bytedance.ee.util.ui.n.d(100);
        int r0 = com.bytedance.ee.util.ui.n.d(4);
        Resources r1 = eu5.b.a.getResources();
        this.p = (int) Math.floor(((double) WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).widthPixels) / ((double) (r8 + r0)));
        LayoutInflater.from(r6).inflate(2131560184, this);
        this.a = (PDFVerticalSliderBar) findViewById(2131370291);
        FrameLayout r9 = (FrameLayout) findViewById(2131367939);
        this.b = r9;
        this.c = (ImageView) r9.findViewById(2131370256);
        this.d = (FrameLayout) this.b.findViewById(2131388630);
        this.e = (TextView) this.b.findViewById(2131370255);
    }
}
