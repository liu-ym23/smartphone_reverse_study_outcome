package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.customview.widget.ViewDragHelper;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larus.nova.R;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes16.dex */
public class PDFVerticalSliderBar extends FrameLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f225293m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewDragHelper f225294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f225295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f225296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f225297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f225298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f225299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f225300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator f225301h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f225302i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f225303j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f225304k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f225305l;

    public class a extends ViewDragHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f225306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PDFVerticalSliderBar f225307b;

        public a(PDFVerticalSliderBar r100) {
            this.f225307b = r100;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final boolean tryCaptureView(View r100, int r101) {
            if (r100 != this.f225307b.f225295b) goto L5;
            boolean r102 = true;
        L6:
            tt5.a.h("PDFVerticalSliderBar", "tryCaptureView() captured=" + r102);
            if (r102 == true) goto L9;
            return false;
        L9:
            PDFVerticalSliderBar r103 = this.f225307b;
            r103.f225302i = true;
            r103.f225304k = r103.f225295b.getTop();
            PDFVerticalSliderBar r104 = this.f225307b;
            r104.f225297d.setText(String.valueOf(r104.f225300g + 1));
            this.f225307b.f225297d.setVisibility(0);
            this.f225306a = 0;
            b r105 = this.f225307b.f225298e;
            if (r105 == null) goto L12;
            r0 r106 = (r0) r105;
            r106.getClass();
            tt5.a.h("PDFThumbnailSlider", "onStartTrackingTouch() mCurrentPage=" + r106.f225386c.f225273i);
            r106.f225385b = false;
        L12:
            return true;
        L5:
            r102 = false;
            goto L6
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int clampViewPositionVertical(View r110, int r111, int r112) {
            tt5.a.h("PDFVerticalSliderBar", "clampViewPositionVertical() dy=" + r112);
            if ((this.f225307b.getHeight() - this.f225307b.f225295b.getHeight()) > 0) goto L6;
            tt5.a.h("PDFVerticalSliderBar", "clampViewPositionVertical() wrong state, return 0.");
            return 0;
        L6:
            this.f225306a += r112;
            if (r111 >= 0) goto L10;
            r111 = 0;
        L12:
            int r113 = (int) ((r111 * 100.0f) / (this.f225307b.getHeight() - this.f225307b.f225295b.getHeight()));
            PDFVerticalSliderBar r114 = this.f225307b;
            int r100 = r114.f225299f;
            int r115 = (r113 * r100) / 100;
            if (r115 > 0) goto L15;
            r115 = 0;
        L19:
            if (r115 == r114.f225300g) goto L21;
            r114.f225300g = r115;
            r114.d();
        L21:
            PDFVerticalSliderBar r116 = this.f225307b;
            int r117 = this.f225306a;
            int r101 = r116.f225300g;
            b r118 = r116.f225298e;
            if (r118 == null) goto L48;
            r0 r119 = (r0) r118;
            tt5.a.h("PDFThumbnailSlider", "onProgressChanged() currentIndicator=" + r101 + ", fromUser=true, dy=" + r117);
            PDFThumbnailSlider r102 = r119.f225386c;
            int r103 = r102.f225273i;
            r102.f225273i = r101;
            r102.f225269e.setText((r101 + 1) + HTTP.URL_DEFAULT + r119.f225386c.f225270f);
            final PDFThumbnailSlider r104 = r119.f225386c;
            final int r105 = r104.f225273i;
            if (r103 == r105) goto L34;
            t0.b(r104.f225268d, r104.f225280p);
            if (r104.f225271g == null) goto L34;
            Disposable r106 = r104.f225275k;
            if (r106 != null) goto L30;
        L32:
            r104.f225275k = Flowable.just(Integer.valueOf(r105)).delay(60, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).subscribe(new p0(r104, r105), new q0());
            goto L34
        L30:
            if (r106.isDisposed() == true) goto L32;
            tt5.a.b("PDFThumbnailSlider", "user move too fast, ignore it");
            r104.f225275k.dispose();
        L34:
            if (r119.f225386c.f225273i != 0) goto L38;
            if (Math.abs(r117) > PDFThumbnailSlider.f225264q) goto L38;
        L45:
            PDFThumbnailSlider.a r120 = r119.f225386c.f225274j;
            if (r120 == null) goto L48;
            r120.b();
        L38:
            if (r119.f225384a == true) goto L45;
            if (r119.f225385b == true) goto L45;
            tt5.a.h("PDFThumbnailSlider", "onProgressChanged() show alpha bg.");
            r119.f225386c.f225266b.setVisibility(0);
            PDFThumbnailSlider.a r121 = r119.f225386c.f225274j;
            if (r121 == null) goto L44;
            r121.c();
        L44:
            r119.f225386c.setBackgroundColor(j08.b.b(r119.f225386c.getResources().getColor(R.color.lkui_N1000), 0.3f));
            r119.a();
            r119.f225384a = true;
        L48:
            PDFVerticalSliderBar r122 = this.f225307b;
            r122.f225303j = r111;
            b r123 = r122.f225298e;
            if (r123 == null) goto L51;
            ((r0) r123).a();
        L51:
            return r111;
        L15:
            int r107 = r100 - 1;
            if (r115 < r107) goto L19;
            r115 = r107;
            goto L19
        L10:
            if (r111 <= (this.f225307b.getHeight() - this.f225307b.f225295b.getHeight())) goto L12;
            r111 = this.f225307b.getHeight() - this.f225307b.f225295b.getHeight();
            goto L12
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void onViewReleased(View r100, float r101, float r102) {
            super.onViewReleased(r100, r101, r102);
            tt5.a.h("PDFVerticalSliderBar", "onViewReleased()");
            PDFVerticalSliderBar r103 = this.f225307b;
            b r104 = r103.f225298e;
            if (r104 == null) goto L8;
            r0 r105 = (r0) r104;
            r105.f225386c.f225273i = r103.f225300g;
            tt5.a.h("PDFThumbnailSlider", "onStopTrackingTouch() mCurrentPage=" + r105.f225386c.f225273i);
            r105.f225385b = true;
            r105.f225386c.f225266b.setVisibility(8);
            r105.f225386c.f225272h.a();
            PDFThumbnailSlider r106 = r105.f225386c;
            PDFThumbnailSlider.a r107 = r106.f225274j;
            if (r107 == null) goto L7;
            r107.a(r106.f225273i);
        L7:
            r105.f225386c.setBackgroundDrawable(null);
            r105.f225384a = false;
        L8:
            this.f225307b.f225297d.setVisibility(4);
        }
    }

    public interface b {
    }

    public final void d() {
        int r100 = this.f225300g + 1;
        this.f225296c.setText(String.valueOf(r100));
        if (r100 >= 100) goto L6;
        this.f225296c.setTextSize(2, 16.0f);
        return;
    L6:
        if (r100 >= 1000) goto L9;
        this.f225296c.setTextSize(2, 13.0f);
        return;
    L9:
        if (r100 >= 10000) goto L11;
        this.f225296c.setTextSize(2, 10.0f);
        return;
    L11:
        this.f225296c.setTextSize(2, 7.0f);
    }

    public int getIndicatorHeight() {
        return this.f225296c.getHeight();
    }

    public final void c() {
        this.f225305l = idb.f.a().isCurrentEnable("ccm.drive.pdf_location_persist");
        this.f225295b = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.drive_slider_indicator, this, false);
        if (w55.n.f558339d == false) goto L5;
        this.f225295b.setBackgroundResource(R.drawable.drive_bg_pdf_slider_indicator_v2);
    L6:
        this.f225296c = (TextView) this.f225295b.findViewById(R.id.drive_slider_indicator_tv);
        this.f225297d = new TextView(getContext());
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-2, com.bytedance.ee.util.ui.n.d(24));
        r100.gravity = 5;
        r100.rightMargin = -com.bytedance.ee.util.ui.n.d(2);
        this.f225297d.setLayoutParams(r100);
        this.f225297d.setPadding(com.bytedance.ee.util.ui.n.d(7), 0, com.bytedance.ee.util.ui.n.d(7), 0);
        this.f225297d.setGravity(17);
        this.f225297d.setVisibility(4);
        this.f225297d.setTextColor(-1);
        this.f225297d.setTextSize(2, 10.0f);
        int r101 = h18.e.f483540a;
        this.f225297d.setTypeface(h18.e.a(getContext()), 1);
        this.f225297d.setBackgroundDrawable(getResources().getDrawable(R.drawable.drive_bg_slider_stub_indicator));
        this.f225297d.setElevation(com.bytedance.ee.util.ui.n.d(6));
        addView(this.f225297d);
        addView(this.f225295b);
        d();
        this.f225294a = ViewDragHelper.create(this, new a(this));
        return;
    L5:
        this.f225295b.setBackgroundResource(R.drawable.drive_bg_pdf_slider_indicator);
        goto L6
    }

    public float getIndicatorPercent() {
        if (getHeight() > 0) goto L7;
        return 0.0f;
    L7:
        return (this.f225303j * 1.0f) / getHeight();
    }

    public int getCurrentIndicatorPage() {
        return this.f225300g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public PDFVerticalSliderBar(Context r100) {
        super(r100);
        this.f225299f = 0;
        this.f225300g = 0;
        c();
    }

    public final int b(int r100) {
        return a(r100, (int) (((r100 * 1.0f) / this.f225299f) * (getHeight() - this.f225295b.getHeight())));
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        boolean r101 = this.f225294a.shouldInterceptTouchEvent(r100);
        tt5.a.h("PDFVerticalSliderBar", "slider onInterceptTouchEvent=" + r101);
        return r101;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        this.f225294a.processTouchEvent(r100);
        if (r100.getAction() == 2) goto L6;
        tt5.a.h("PDFVerticalSliderBar", "slider onTouchEvent acton=" + r100.getAction());
    L6:
        if (this.f225294a.getViewDragState() == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public void setMaxPageCount(int r100) {
        this.f225299f = r100;
    }

    public void setSeekListener(b r100) {
        this.f225298e = r100;
    }

    public PDFVerticalSliderBar(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f225299f = 0;
        this.f225300g = 0;
        c();
    }

    public final int a(int r100, int r101) {
        if (r101 < 0) goto L13;
        if (r100 > 0) goto L6;
        return 0;
    L6:
        if (r101 > (getHeight() - this.f225295b.getHeight())) goto L12;
        if (r100 >= (this.f225299f - 1)) goto L12;
        return r101;
    L12:
        return getHeight() - this.f225295b.getHeight();
    L13:
        return 0;
    }

    public PDFVerticalSliderBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225299f = 0;
        this.f225300g = 0;
        c();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        ViewGroup r105 = this.f225295b;
        r105.layout(r105.getLeft(), this.f225303j, this.f225295b.getRight(), this.f225303j + this.f225295b.getHeight());
        if (this.f225302i == false) goto L6;
        TextView r106 = this.f225297d;
        r106.layout(r106.getLeft(), this.f225304k, this.f225297d.getRight(), this.f225304k + this.f225297d.getHeight());
        return;
    }
}
