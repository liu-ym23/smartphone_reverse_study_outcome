package com.bytedance.scene.ui.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class NavigationBarView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindowInsetsCompat f268848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f268849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f268850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f268851d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NavigationBarView f268852a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f268852a.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(NavigationBarView r100) {
            this.f268852a = r100;
        }
    }

    public class b implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NavigationBarView f268853a;

        public b(NavigationBarView r100) {
            this.f268853a = r100;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            if (this.f268853a.getVisibility() != 8) goto L7;
            this.f268853a.f268848a = null;
            return r101;
        L7:
            if (new WindowInsetsCompat(r101).equals(this.f268853a.f268848a) == true) goto L10;
            NavigationBarView r102 = this.f268853a;
            r102.f268848a = new WindowInsetsCompat(r101);
            NavigationBarView r103 = this.f268853a;
            r103.post(r103.f268851d);
        L10:
            return new WindowInsetsCompat(r101).replaceSystemWindowInsets(r101.getSystemWindowInsetLeft(), r101.getSystemWindowInsetTop(), r101.getSystemWindowInsetRight(), 0);
        }
    }

    public final void a() {
        ViewCompat.setOnApplyWindowInsetsListener(this, new b(this));
        TypedArray r100 = getContext().obtainStyledAttributes(new int[]{R.attr.navigationBarColor});
        this.f268850c = r100.getDrawable(0);     // Catch: Throwable -> L6
        r100.recycle();
        return;
    L6:
        th = move-exception;
        r100.recycle();
        throw th;
    }

    public Drawable getNavigationBarBackgroundDrawable() {
        return this.f268850c;
    }

    public NavigationBarView(Context r100) {
        super(r100);
        this.f268849b = true;
        this.f268851d = new a(this);
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (this.f268849b == true) goto L5;
        return;
    L5:
        if (this.f268850c == null) goto L14;
        WindowInsetsCompat r101 = this.f268848a;
        if (r101 == null) goto L9;
        int r102 = r101.getSystemWindowInsetBottom();
    L10:
        if (r102 <= 0) goto L15;
        this.f268850c.setBounds(0, getHeight() - r102, getWidth(), getHeight());
        this.f268850c.draw(r100);
        return;
    L15:
        return;
    L9:
        r102 = 0;
        goto L10
    }

    public void setNavigationBarBackground(int r100) {
        if (r100 == 0) goto L4;
        Drawable r101 = ContextCompat.getDrawable(getContext(), r100);
    L5:
        this.f268850c = r101;
        invalidate();
        return;
    L4:
        r101 = null;
        goto L5
    }

    public void setNavigationBarBackgroundColor(int r100) {
        this.f268850c = new ColorDrawable(r100);
        invalidate();
    }

    public void setNavigationBarBackground(Drawable r100) {
        this.f268850c = r100;
        invalidate();
    }

    public NavigationBarView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f268849b = true;
        this.f268851d = new a(this);
        a();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        WindowInsetsCompat r102 = this.f268848a;
        if (r102 == null) goto L17;
        int r103 = View.MeasureSpec.makeMeasureSpec(r102.getSystemWindowInsetBottom(), 1073741824);
        int r104 = getSuggestedMinimumWidth();
        int r105 = View.MeasureSpec.getMode(r100);
        int r106 = View.MeasureSpec.getSize(r100);
        if (r105 == Integer.MIN_VALUE) goto L9;
        if (r105 != 1073741824) goto L10;
        r104 = r106;
    L10:
        int r107 = getSuggestedMinimumHeight();
        int r108 = View.MeasureSpec.getMode(r103);
        int r109 = View.MeasureSpec.getSize(r103);
        if (r108 == Integer.MIN_VALUE) goto L15;
        if (r108 != 1073741824) goto L16;
        r107 = r109;
    L16:
        setMeasuredDimension(r104, r107);
        return;
    L15:
        r107 = Math.min(r107, r109);
        goto L16
    L9:
        r104 = Math.min(r104, r106);
        goto L10
    L17:
        int r110 = getSuggestedMinimumWidth();
        int r111 = View.MeasureSpec.getMode(r100);
        int r112 = View.MeasureSpec.getSize(r100);
        if (r111 == Integer.MIN_VALUE) goto L22;
        if (r111 != 1073741824) goto L23;
        r110 = r112;
    L23:
        int r113 = getSuggestedMinimumHeight();
        int r114 = View.MeasureSpec.getMode(r101);
        int r115 = View.MeasureSpec.getSize(r101);
        if (r114 == Integer.MIN_VALUE) goto L28;
        if (r114 != 1073741824) goto L29;
        r113 = r115;
    L29:
        setMeasuredDimension(r110, r113);
        return;
    L28:
        r113 = Math.min(r113, r115);
        goto L29
    L22:
        r110 = Math.min(r110, r112);
        goto L23
    }

    public NavigationBarView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f268849b = true;
        this.f268851d = new a(this);
        a();
    }
}
