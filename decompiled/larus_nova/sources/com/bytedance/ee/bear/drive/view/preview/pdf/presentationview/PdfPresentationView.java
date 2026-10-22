package com.bytedance.ee.bear.drive.view.preview.pdf.presentationview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bytedance.ee.bear.drive.view.widget.RecyclingImageView;
import com.larus.nova.R;
import i75.e;
import io.reactivex.Flowable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes16.dex */
public class PdfPresentationView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f225136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f225137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclingImageView f225138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f225139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f225140e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public GestureDetector f225141f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f225142g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f225143h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f225144i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f225145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f225146b;

        public a(int r100, int r101) {
            this.f225145a = r100;
            this.f225146b = r101;
        }
    }

    public interface b {
        void onBackClick();
    }

    public interface c {
    }

    public class d extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PdfPresentationView f225147a;

        public d(PdfPresentationView r100) {
            this.f225147a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            if (this.f225147a.f225136a.getVisibility() == 0) goto L18;
            final View r101 = this.f225147a.f225136a;
            boolean r102 = false;
            if (r101.getVisibility() != 0) goto L7;
            boolean r103 = true;
        L8:
            if (r103 == true) goto L19;
            Animation r104 = r101.getAnimation();
            if (r104 != null) goto L12;
        L16:
            if (r102 == true) goto L19;
            tt5.a.b("CrossFadeAnimUtil", "showWithAnimAndAutoHide. ");
            TranslateAnimation r105 = new TranslateAnimation(0.0f, 0.0f, -r101.getHeight(), 0.0f);
            r105.setDuration(150);
            r105.setAnimationListener(new i75.c(r101));
            r101.startAnimation(r105);
            tt5.a.b("CrossFadeAnimUtil", "attach auto hide disposable. ");
            e.a(r101);
            r101.setTag(r101.getId(), Flowable.timer(3150, TimeUnit.MILLISECONDS, fo5.d.a()).observeOn(fo5.d.d()).subscribe(new i75.a(r101), new i75.b()));
            goto L19
        L12:
            if (r104.hasStarted() == false) goto L16;
            if (r104.hasEnded() == true) goto L16;
            r102 = true;
        L19:
            return true;
        L7:
            r103 = false;
            goto L8
        L18:
            e.b(this.f225147a.f225136a);
            goto L19
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            if ((r100.getX() - r101.getX()) <= 200.0f) goto L5;
        L19:
            tt5.a.b("PdfPresentationView", "next fling. ");
            PdfPresentationView r104 = this.f225147a;
            if (r104.f225142g == null) goto L24;
            e.b(r104.f225136a);
            PdfPresentationView r105 = this.f225147a;
            c r106 = r105.f225142g;
            a r107 = new a(r105.f225144i + 1, 1);
            com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.a.C3238a r108 = (com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.a.C3238a) r106;
            if (r108.isDisposed() == true) goto L24;
            r108.f225150c.onNext(r107);
        L24:
            return true;
        L5:
            if ((r100.getY() - r101.getY()) > 200.0f) goto L19;
            if ((r101.getX() - r100.getX()) <= 200.0f) goto L10;
        L13:
            tt5.a.b("PdfPresentationView", "last fling. ");
            PdfPresentationView r109 = this.f225147a;
            if (r109.f225142g == null) goto L18;
            e.b(r109.f225136a);
            PdfPresentationView r110 = this.f225147a;
            c r111 = r110.f225142g;
            a r112 = new a(r110.f225144i - 1, 0);
            com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.a.C3238a r113 = (com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.a.C3238a) r111;
            if (r113.isDisposed() == true) goto L18;
            r113.f225150c.onNext(r112);
        L18:
            return true;
        L10:
            if ((r101.getY() - r100.getY()) > 200.0f) goto L13;
            return false;
        }
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.drive_preview_pdf_presentation_view, this);
        this.f225136a = findViewById(R.id.presentation_nav_bar);
        this.f225138c = (RecyclingImageView) findViewById(R.id.page_view);
        this.f225140e = findViewById(R.id.back_view);
        this.f225139d = (TextView) findViewById(R.id.back_title_view);
        this.f225137b = (TextView) findViewById(R.id.indicator_view);
        this.f225141f = new GestureDetector(getContext(), new d(this));
        this.f225140e.setOnClickListener(new w95.a(this));
    }

    public int getPageIndex() {
        return this.f225144i;
    }

    public PdfPresentationView(Context r100) {
        super(r100);
        a();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        this.f225141f.onTouchEvent(r100);
        return true;
    }

    public void setBackClickListener(b r100) {
        this.f225143h = r100;
    }

    public void setBackTitle(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = R.string.Drive_Drive_PresentationEnd;
    L5:
        this.f225139d.setText(r101);
        return;
    L4:
        r101 = R.string.CreationMobile_MS_ExitFullScreen;
        goto L5
    }

    public void setFlingListener(c r100) {
        this.f225142g = r100;
    }

    public PdfPresentationView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);
        if (r100 != this) goto L13;
        if (r101 != 0) goto L6;
        this.f225136a.setVisibility(4);
        return;
    L6:
        View r102 = this.f225136a;
        if (r102.getVisibility() != 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L15;
        e.a(r102);
        r102.setVisibility(8);
        return;
    L15:
        return;
    L9:
        r103 = false;
        goto L10
    }

    public PdfPresentationView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }

    public final void b(int r100, int r101, com.bytedance.ee.bear.drive.view.preview.pdf.a.C3237a r102, LruBitmapPool r103) {
        if (r102.a() == false) goto L6;
        this.f225144i = r101;
        this.f225137b.setText(String.format("%s/%s", new Object[]{Integer.valueOf(r101), Integer.valueOf(r100)}));
        tt5.a.h("PdfPresentationView", "setIndexPage, width: " + r102.f225133c + "height: " + r102.f225132b);
        this.f225138c.b(r102.f225131a, r103);
        return;
    }
}
