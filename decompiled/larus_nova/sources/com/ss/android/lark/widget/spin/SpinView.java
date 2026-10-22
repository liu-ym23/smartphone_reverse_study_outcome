package com.ss.android.lark.widget.spin;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public class SpinView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f448826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f448827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f448828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f448829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f448830e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpinView f448831a;

        @Override // java.lang.Runnable
        public final void run() {
            SpinView r100 = this.f448831a;     // Catch: Throwable -> L10
            float r101 = r100.f448826a + 30.0f;     // Catch: Throwable -> L10
            r100.f448826a = r101;     // Catch: Throwable -> L10
            if (r101 < 360.0f) goto L6;
            r101 = r101 - 360.0f;     // Catch: Throwable -> L10
        L6:
            r100.f448826a = r101;     // Catch: Throwable -> L10
            r100.invalidate();     // Catch: Throwable -> L10
            SpinView r102 = this.f448831a;     // Catch: Throwable -> L10
            if (r102.f448828c == false) goto L13;
            r102.postDelayed(this, r102.f448827b);     // Catch: Throwable -> L10
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public a(SpinView r100) {
            this.f448831a = r100;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        this.f448828c = false;
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f448828c = true;
        post(this.f448829d);
    }

    public SpinView(Context r100) {
        super(r100);
        init(r100, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        r100.rotate(this.f448826a, getWidth() / 2, getHeight() / 2);
        super.onDraw(r100);
    }

    public void setAnimationSpeed(float r100) {
        this.f448827b = (int) (83.0f / r100);
    }

    public void setSpinDrawable(Drawable r100) {
        if (r100 == null) goto L5;
        this.f448830e = r100;
        setImageDrawable(r100);
        return;
    }

    public SpinView(Context r100, AttributeSet r101) {
        super(r100, r101);
        init(r100, r101);
    }

    public final void init(Context r100, AttributeSet r101) {
        this.f448830e = r100.getResources().getDrawable(R.drawable.progress_spinner);
        if (r101 == null) goto L11;
        int r102 = 0;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.spinDrawable});
        int r104 = r103.getIndexCount();
    L5:
        if (r102 >= r104) goto L10;
        int r105 = r103.getIndex(r102);
        if (r105 != 0) goto L9;
        this.f448830e = r103.getDrawable(r105);
    L9:
        r102 = r102 + 1;
        goto L5
    L10:
        r103.recycle();
    L11:
        setImageDrawable(this.f448830e);
        this.f448827b = 83;
        this.f448829d = new a(this);
    }

    public SpinView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init(r100, r101);
    }
}
