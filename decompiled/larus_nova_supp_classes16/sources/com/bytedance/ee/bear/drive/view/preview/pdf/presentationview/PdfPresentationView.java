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
import i75.e;
import io.reactivex.Flowable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PdfPresentationView extends FrameLayout {
    public View a;
    public TextView b;
    public RecyclingImageView c;
    public TextView d;
    public View e;
    public GestureDetector f;
    public c g;
    public b h;
    public int i;

    public static final class a {
        public final int a;
        public final int b;

        public a(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public interface b {
        void onBackClick();
    }

    public interface c {
    }

    public class d extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ PdfPresentationView a;

        public d(PdfPresentationView r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r6) {
            if (this.a.a.getVisibility() == 0) goto L18;
            final View r7 = this.a.a;
            boolean r2 = false;
            if (r7.getVisibility() != 0) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == true) goto L19;
            Animation r3 = r7.getAnimation();
            if (r3 != null) goto L12;
        L16:
            if (r2 == true) goto L19;
            tt5.a.b("CrossFadeAnimUtil", "showWithAnimAndAutoHide. ");
            TranslateAnimation r4 = new TranslateAnimation(0.0f, 0.0f, -r7.getHeight(), 0.0f);
            r4.setDuration(150);
            r4.setAnimationListener(new i75.c(r7));
            r7.startAnimation(r4);
            tt5.a.b("CrossFadeAnimUtil", "attach auto hide disposable. ");
            e.a(r7);
            r7.setTag(r7.getId(), Flowable.timer(3150, TimeUnit.MILLISECONDS, fo5.d.a()).observeOn(fo5.d.d()).subscribe(new i75.a(r7), new i75.b()));
            goto L19
        L12:
            if (r3.hasStarted() == false) goto L16;
            if (r3.hasEnded() == true) goto L16;
            r2 = true;
        L19:
            return true;
        L7:
            r1 = false;
            goto L8
        L18:
            e.b(this.a.a);
            goto L19
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r4, MotionEvent r5, float r6, float r7) {
            if ((r4.getX() - r5.getX()) <= 200.0f) goto L5;
        L19:
            tt5.a.b("PdfPresentationView", "next fling. ");
            PdfPresentationView r8 = this.a;
            if (r8.g == null) goto L24;
            e.b(r8.a);
            PdfPresentationView r9 = this.a;
            c r10 = r9.g;
            a r11 = new a(r9.i + 1, 1);
            com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.a.C0182a r12 = (com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.a.C0182a) r10;
            if (r12.isDisposed() == true) goto L24;
            r12.c.onNext(r11);
        L24:
            return true;
        L5:
            if ((r4.getY() - r5.getY()) > 200.0f) goto L19;
            if ((r5.getX() - r4.getX()) <= 200.0f) goto L10;
        L13:
            tt5.a.b("PdfPresentationView", "last fling. ");
            PdfPresentationView r13 = this.a;
            if (r13.g == null) goto L18;
            e.b(r13.a);
            PdfPresentationView r14 = this.a;
            c r16 = r14.g;
            a r17 = new a(r14.i - 1, 0);
            com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.a.C0182a r18 = (com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.a.C0182a) r16;
            if (r18.isDisposed() == true) goto L18;
            r18.c.onNext(r17);
        L18:
            return true;
        L10:
            if ((r5.getY() - r4.getY()) > 200.0f) goto L13;
            return false;
        }
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(2131560215, this);
        this.a = findViewById(2131382881);
        this.c = (RecyclingImageView) findViewById(2131381812);
        this.e = findViewById(2131363802);
        this.d = (TextView) findViewById(2131363790);
        this.b = (TextView) findViewById(2131375249);
        this.f = new GestureDetector(getContext(), new d(this));
        this.e.setOnClickListener(new w95.a(this));
    }

    public int getPageIndex() {
        return this.i;
    }

    public PdfPresentationView(Context r1) {
        super(r1);
        a();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        this.f.onTouchEvent(r2);
        return true;
    }

    public void setBackClickListener(b r1) {
        this.h = r1;
    }

    public void setBackTitle(boolean r2) {
        if (r2 == false) goto L4;
        int r3 = 2131888434;
    L5:
        this.d.setText(r3);
        return;
    L4:
        r3 = 2131887341;
        goto L5
    }

    public void setFlingListener(c r1) {
        this.g = r1;
    }

    public PdfPresentationView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
        if (r1 != this) goto L13;
        if (r2 != 0) goto L6;
        this.a.setVisibility(4);
        return;
    L6:
        View r3 = this.a;
        if (r3.getVisibility() != 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L15;
        e.a(r3);
        r3.setVisibility(8);
        return;
    L15:
        return;
    L9:
        r4 = false;
        goto L10
    }

    public PdfPresentationView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }

    public final void b(int r4, int r5, com.bytedance.ee.bear.drive.view.preview.pdf.a.C0181a r6, LruBitmapPool r7) {
        if (r6.a() == false) goto L6;
        this.i = r5;
        this.b.setText(String.format("%s/%s", new Object[]{Integer.valueOf(r5), Integer.valueOf(r4)}));
        tt5.a.h("PdfPresentationView", "setIndexPage, width: " + r6.c + "height: " + r6.b);
        this.c.b(r6.a, r7);
        return;
    }
}
