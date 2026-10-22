package com.bytedance.scene.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes19.dex */
public final class StatusBarView extends View {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f268854e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindowInsetsCompat f268855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f268856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f268857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f268858d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StatusBarView f268859a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f268859a.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(StatusBarView r100) {
            this.f268859a = r100;
        }
    }

    public class b implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StatusBarView f268860a;

        public b(StatusBarView r100) {
            this.f268860a = r100;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            if (this.f268860a.getVisibility() != 8) goto L7;
            this.f268860a.f268855a = null;
            return r101;
        L7:
            if (new WindowInsetsCompat(r101).equals(this.f268860a.f268855a) == true) goto L10;
            StatusBarView r102 = this.f268860a;
            r102.f268855a = new WindowInsetsCompat(r101);
            StatusBarView r103 = this.f268860a;
            r103.post(r103.f268858d);
        L10:
            return new WindowInsetsCompat(r101).replaceSystemWindowInsets(r101.getSystemWindowInsetLeft(), 0, r101.getSystemWindowInsetRight(), r101.getSystemWindowInsetBottom());
        }
    }

    static {
        f268854e = new int[]{R.attr.colorPrimaryDark};
    }

    public final void a() {
        ViewCompat.setOnApplyWindowInsetsListener(this, new b(this));
        TypedArray r100 = getContext().obtainStyledAttributes(f268854e);
        this.f268857c = r100.getDrawable(0);     // Catch: Throwable -> L6
        r100.recycle();
        Resources r101 = getResources();
        ViewCompat.setElevation(this, TypedValue.applyDimension(1, 4.0f, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
        return;
    L6:
        th = move-exception;
        r100.recycle();
        throw th;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f268857c;
    }

    public StatusBarView(Context r100) {
        super(r100);
        this.f268856b = true;
        this.f268858d = new a(this);
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (this.f268856b == true) goto L5;
        return;
    L5:
        if (this.f268857c == null) goto L14;
        WindowInsetsCompat r101 = this.f268855a;
        if (r101 == null) goto L9;
        int r102 = r101.getSystemWindowInsetTop();
    L10:
        if (r102 <= 0) goto L15;
        this.f268857c.setBounds(0, 0, getWidth(), r102);
        this.f268857c.draw(r100);
        return;
    L15:
        return;
    L9:
        r102 = 0;
        goto L10
    }

    public void setStatusBarBackground(int r100) {
        if (r100 == 0) goto L4;
        Drawable r101 = ContextCompat.getDrawable(getContext(), r100);
    L5:
        this.f268857c = r101;
        invalidate();
        return;
    L4:
        r101 = null;
        goto L5
    }

    public void setStatusBarBackgroundColor(int r100) {
        this.f268857c = new ColorDrawable(r100);
        invalidate();
    }

    public void setStatusBarBackground(Drawable r100) {
        this.f268857c = r100;
        invalidate();
    }

    public StatusBarView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f268856b = true;
        this.f268858d = new a(this);
        a();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        WindowInsetsCompat r102 = this.f268855a;
        if (r102 == null) goto L17;
        int r103 = View.MeasureSpec.makeMeasureSpec(r102.getSystemWindowInsetTop(), 1073741824);
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

    public StatusBarView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f268856b = true;
        this.f268858d = new a(this);
        a();
    }
}
