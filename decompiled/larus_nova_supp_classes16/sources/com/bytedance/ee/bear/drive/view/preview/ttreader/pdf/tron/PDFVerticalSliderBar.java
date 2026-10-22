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
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PDFVerticalSliderBar extends FrameLayout {
    public static final /* synthetic */ int m = 0;
    public ViewDragHelper a;
    public ViewGroup b;
    public TextView c;
    public TextView d;
    public b e;
    public int f;
    public int g;
    public ValueAnimator h;
    public boolean i;
    public int j;
    public int k;
    public boolean l;

    public class a extends ViewDragHelper.Callback {
        public int a;
        public final /* synthetic */ PDFVerticalSliderBar b;

        public a(PDFVerticalSliderBar r1) {
            this.b = r1;
        }

        public final boolean tryCaptureView(View r4, int r5) {
            if (r4 != this.b.b) goto L5;
            boolean r6 = true;
        L6:
            tt5.a.h("PDFVerticalSliderBar", "tryCaptureView() captured=" + r6);
            if (r6 == true) goto L9;
            return false;
        L9:
            PDFVerticalSliderBar r7 = this.b;
            r7.i = true;
            r7.k = r7.b.getTop();
            PDFVerticalSliderBar r8 = this.b;
            r8.d.setText(String.valueOf(r8.g + 1));
            this.b.d.setVisibility(0);
            this.a = 0;
            b r9 = this.b.e;
            if (r9 == null) goto L12;
            r0 r10 = (r0) r9;
            r10.getClass();
            tt5.a.h("PDFThumbnailSlider", "onStartTrackingTouch() mCurrentPage=" + r10.c.i);
            r10.b = false;
        L12:
            return true;
        L5:
            r6 = false;
            goto L6
        }

        public final int clampViewPositionVertical(View r10, int r11, int r12) {
            tt5.a.h("PDFVerticalSliderBar", "clampViewPositionVertical() dy=" + r12);
            if ((this.b.getHeight() - this.b.b.getHeight()) > 0) goto L6;
            tt5.a.h("PDFVerticalSliderBar", "clampViewPositionVertical() wrong state, return 0.");
            return 0;
        L6:
            this.a += r12;
            if (r11 >= 0) goto L10;
            r11 = 0;
        L12:
            int r13 = (int) ((r11 * 100.0f) / (this.b.getHeight() - this.b.b.getHeight()));
            PDFVerticalSliderBar r14 = this.b;
            int r0 = r14.f;
            int r16 = (r13 * r0) / 100;
            if (r16 > 0) goto L15;
            r16 = 0;
        L19:
            if (r16 == r14.g) goto L21;
            r14.g = r16;
            r14.d();
        L21:
            PDFVerticalSliderBar r17 = this.b;
            int r18 = this.a;
            int r1 = r17.g;
            b r19 = r17.e;
            if (r19 == null) goto L48;
            r0 r110 = (r0) r19;
            tt5.a.h("PDFThumbnailSlider", "onProgressChanged() currentIndicator=" + r1 + ", fromUser=true, dy=" + r18);
            PDFThumbnailSlider r2 = r110.c;
            int r4 = r2.i;
            r2.i = r1;
            r2.e.setText((r1 + 1) + "/" + r110.c.f);
            final PDFThumbnailSlider r3 = r110.c;
            final int r5 = r3.i;
            if (r4 == r5) goto L34;
            t0.b(r3.d, r3.p);
            if (r3.g == null) goto L34;
            Disposable r6 = r3.k;
            if (r6 != null) goto L30;
        L32:
            r3.k = Flowable.just(Integer.valueOf(r5)).delay(60, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).subscribe(new p0(r3, r5), new q0());
            goto L34
        L30:
            if (r6.isDisposed() == true) goto L32;
            tt5.a.b("PDFThumbnailSlider", "user move too fast, ignore it");
            r3.k.dispose();
        L34:
            if (r110.c.i != 0) goto L38;
            if (Math.abs(r18) > PDFThumbnailSlider.q) goto L38;
        L45:
            PDFThumbnailSlider.a r111 = r110.c.j;
            if (r111 == null) goto L48;
            r111.b();
        L38:
            if (r110.a == true) goto L45;
            if (r110.b == true) goto L45;
            tt5.a.h("PDFThumbnailSlider", "onProgressChanged() show alpha bg.");
            r110.c.b.setVisibility(0);
            PDFThumbnailSlider.a r112 = r110.c.j;
            if (r112 == null) goto L44;
            r112.c();
        L44:
            r110.c.setBackgroundColor(j08.b.b(r110.c.getResources().getColor(2131103451), 0.3f));
            r110.a();
            r110.a = true;
        L48:
            PDFVerticalSliderBar r113 = this.b;
            r113.j = r11;
            b r114 = r113.e;
            if (r114 == null) goto L51;
            ((r0) r114).a();
        L51:
            return r11;
        L15:
            int r7 = r0 - 1;
            if (r16 < r7) goto L19;
            r16 = r7;
            goto L19
        L10:
            if (r11 <= (this.b.getHeight() - this.b.b.getHeight())) goto L12;
            r11 = this.b.getHeight() - this.b.b.getHeight();
            goto L12
        }

        public final void onViewReleased(View r1, float r2, float r3) {
            super.onViewReleased(r1, r2, r3);
            tt5.a.h("PDFVerticalSliderBar", "onViewReleased()");
            PDFVerticalSliderBar r4 = this.b;
            b r5 = r4.e;
            if (r5 == null) goto L8;
            r0 r6 = (r0) r5;
            r6.c.i = r4.g;
            tt5.a.h("PDFThumbnailSlider", "onStopTrackingTouch() mCurrentPage=" + r6.c.i);
            r6.b = true;
            r6.c.b.setVisibility(8);
            r6.c.h.a();
            PDFThumbnailSlider r7 = r6.c;
            PDFThumbnailSlider.a r8 = r7.j;
            if (r8 == null) goto L7;
            r8.a(r7.i);
        L7:
            r6.c.setBackgroundDrawable(null);
            r6.a = false;
        L8:
            this.b.d.setVisibility(4);
        }
    }

    public interface b {
    }

    public final void d() {
        int r0 = this.g + 1;
        this.c.setText(String.valueOf(r0));
        if (r0 >= 100) goto L6;
        this.c.setTextSize(2, 16.0f);
        return;
    L6:
        if (r0 >= 1000) goto L9;
        this.c.setTextSize(2, 13.0f);
        return;
    L9:
        if (r0 >= 10000) goto L11;
        this.c.setTextSize(2, 10.0f);
        return;
    L11:
        this.c.setTextSize(2, 7.0f);
    }

    public int getIndicatorHeight() {
        return this.c.getHeight();
    }

    public final void c() {
        this.l = idb.f.a().isCurrentEnable("ccm.drive.pdf_location_persist");
        this.b = (ViewGroup) LayoutInflater.from(getContext()).inflate(2131560234, this, false);
        if (w55.n.d == false) goto L5;
        this.b.setBackgroundResource(2131234015);
    L6:
        this.c = (TextView) this.b.findViewById(2131370330);
        this.d = new TextView(getContext());
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, com.bytedance.ee.util.ui.n.d(24));
        r0.gravity = 5;
        r0.rightMargin = -com.bytedance.ee.util.ui.n.d(2);
        this.d.setLayoutParams(r0);
        this.d.setPadding(com.bytedance.ee.util.ui.n.d(7), 0, com.bytedance.ee.util.ui.n.d(7), 0);
        this.d.setGravity(17);
        this.d.setVisibility(4);
        this.d.setTextColor(-1);
        this.d.setTextSize(2, 10.0f);
        int r1 = h18.e.a;
        this.d.setTypeface(h18.e.a(getContext()), 1);
        this.d.setBackgroundDrawable(getResources().getDrawable(2131234019));
        this.d.setElevation(com.bytedance.ee.util.ui.n.d(6));
        addView(this.d);
        addView(this.b);
        d();
        this.a = ViewDragHelper.create(this, new a(this));
        return;
    L5:
        this.b.setBackgroundResource(2131234014);
        goto L6
    }

    public float getIndicatorPercent() {
        if (getHeight() > 0) goto L7;
        return 0.0f;
    L7:
        return (this.j * 1.0f) / getHeight();
    }

    public int getCurrentIndicatorPage() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public PDFVerticalSliderBar(Context r1) {
        super(r1);
        this.f = 0;
        this.g = 0;
        c();
    }

    public final int b(int r4) {
        return a(r4, (int) (((r4 * 1.0f) / this.f) * (getHeight() - this.b.getHeight())));
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r3) {
        boolean r4 = this.a.shouldInterceptTouchEvent(r3);
        tt5.a.h("PDFVerticalSliderBar", "slider onInterceptTouchEvent=" + r4);
        return r4;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r3) {
        this.a.processTouchEvent(r3);
        if (r3.getAction() == 2) goto L6;
        tt5.a.h("PDFVerticalSliderBar", "slider onTouchEvent acton=" + r3.getAction());
    L6:
        if (this.a.getViewDragState() == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public void setMaxPageCount(int r1) {
        this.f = r1;
    }

    public void setSeekListener(b r1) {
        this.e = r1;
    }

    public PDFVerticalSliderBar(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.f = 0;
        this.g = 0;
        c();
    }

    public final int a(int r3, int r4) {
        if (r4 < 0) goto L13;
        if (r3 > 0) goto L6;
        return 0;
    L6:
        if (r4 > (getHeight() - this.b.getHeight())) goto L12;
        if (r3 >= (this.f - 1)) goto L12;
        return r4;
    L12:
        return getHeight() - this.b.getHeight();
    L13:
        return 0;
    }

    public PDFVerticalSliderBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.f = 0;
        this.g = 0;
        c();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        super.onLayout(r2, r3, r4, r5, r6);
        ViewGroup r7 = this.b;
        r7.layout(r7.getLeft(), this.j, this.b.getRight(), this.j + this.b.getHeight());
        if (this.i == false) goto L6;
        TextView r8 = this.d;
        r8.layout(r8.getLeft(), this.k, this.d.getRight(), this.k + this.d.getHeight());
        return;
    }
}
