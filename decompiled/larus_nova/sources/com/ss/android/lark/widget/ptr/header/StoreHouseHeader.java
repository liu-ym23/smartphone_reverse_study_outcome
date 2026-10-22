package com.ss.android.lark.widget.ptr.header;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;
import java.util.ArrayList;
import java.util.Random;
import vdc.f;

/* JADX INFO: loaded from: classes38.dex */
public class StoreHouseHeader extends View implements com.ss.android.lark.widget.ptr.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<f> f448070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f448071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f448072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f448073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f448074e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f448075f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f448076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f448077h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f448078i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f448079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f448080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f448081c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f448082d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f448083e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ StoreHouseHeader f448084f;

        public final void a() {
            int r100 = this.f448079a % this.f448080b;
            int r101 = 0;
        L4:
            if (r101 >= this.f448081c) goto L10;
            int r102 = (this.f448080b * r101) + r100;
            if (r102 > this.f448079a) goto L9;
            f r103 = (f) ListProtector.get(this.f448084f.f448070a, r102 % this.f448084f.f448070a.size());
            r103.setFillAfter(false);
            r103.setFillEnabled(true);
            r103.setFillBefore(false);
            r103.setDuration(this.f448084f.f448076g);
            float r104 = this.f448084f.f448073d;
            r103.start();
        L9:
            r101 = r101 + 1;
            goto L4
        L10:
            this.f448079a++;
            if (this.f448083e == false) goto L17;
            this.f448084f.postDelayed(this, this.f448082d);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(StoreHouseHeader r100) {
            this.f448084f = r100;
            this.f448079a = 0;
            this.f448080b = 0;
            this.f448081c = 0;
            this.f448082d = 0;
            this.f448083e = true;
        }
    }

    private void setProgress(float r100) {
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void d(LKUIPtrFrameLayout r100) {
    }

    private int getBottomOffset() {
        return getPaddingBottom() + xdc.a.a(10.0f);
    }

    private int getTopOffset() {
        return getPaddingTop() + xdc.a.a(10.0f);
    }

    public final void f() {
        xdc.a.b(getContext());
        this.f448072c = xdc.a.f563308a / 2;
    }

    public int getLoadingAniDuration() {
        return this.f448074e;
    }

    public float getScale() {
        return this.f448071b;
    }

    public StoreHouseHeader(Context r100) {
        super(r100);
        this.f448070a = new ArrayList();
        this.f448071b = 1.0f;
        this.f448072c = -1;
        this.f448073d = 1.0f;
        this.f448074e = 1000;
        this.f448075f = 1000;
        this.f448076g = 400;
        new Transformation();
        this.f448077h = false;
        this.f448078i = new a(this);
        f();
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void b(LKUIPtrFrameLayout r100) {
        int r101 = 0;
        this.f448077h = false;
        a r102 = this.f448078i;
        r102.f448083e = false;
        r102.f448084f.removeCallbacks(r102);
    L4:
        if (r101 >= this.f448070a.size()) goto L6;
        f r103 = (f) ListProtector.get(this.f448070a, r101);
        int r104 = this.f448072c;
        r103.getClass();
        new Random().nextInt(r104);
        r101 = r101 + 1;
        goto L4
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void e(LKUIPtrFrameLayout r100) {
        this.f448077h = true;
        a r101 = this.f448078i;
        r101.f448083e = true;
        r101.f448079a = 0;
        StoreHouseHeader r102 = r101.f448084f;
        int r103 = r102.f448074e / r102.f448070a.size();
        r101.f448082d = r103;
        StoreHouseHeader r104 = r101.f448084f;
        r101.f448080b = r104.f448075f / r103;
        r101.f448081c = (r104.f448070a.size() / r101.f448080b) + 1;
        r101.run();
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        int r101 = r100.save();
        if (this.f448070a.size() <= 0) goto L5;
        r100.save();
        ((f) ListProtector.get(this.f448070a, 0)).getClass();
        throw null;
    L5:
        if (this.f448077h == false) goto L7;
        invalidate();
    L7:
        r100.restoreToCount(r101);
    }

    public void setLoadingAniDuration(int r100) {
        this.f448074e = r100;
        this.f448075f = r100;
    }

    public void setScale(float r100) {
        this.f448071b = r100;
    }

    public StoreHouseHeader(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f448070a = new ArrayList();
        this.f448071b = 1.0f;
        this.f448072c = -1;
        this.f448073d = 1.0f;
        this.f448074e = 1000;
        this.f448075f = 1000;
        this.f448076g = 400;
        new Transformation();
        this.f448077h = false;
        this.f448078i = new a(this);
        f();
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void a(LKUIPtrFrameLayout r100, boolean r101) {
        this.f448077h = false;
        a r102 = this.f448078i;
        r102.f448083e = false;
        r102.f448084f.removeCallbacks(r102);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec((getTopOffset() + 0) + getBottomOffset(), 1073741824));
        int r102 = (getMeasuredWidth() + 0) / 2;
        getTopOffset();
        getTopOffset();
    }

    public StoreHouseHeader(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f448070a = new ArrayList();
        this.f448071b = 1.0f;
        this.f448072c = -1;
        this.f448073d = 1.0f;
        this.f448074e = 1000;
        this.f448075f = 1000;
        this.f448076g = 400;
        new Transformation();
        this.f448077h = false;
        this.f448078i = new a(this);
        f();
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void c(LKUIPtrFrameLayout r100, boolean r101, byte r102, wdc.a r103) {
        int r104 = r103.f559320g;
        if (r104 != 0) goto L5;
        float r105 = 0.0f;
    L6:
        setProgress(Math.min(1.0f, r105));
        invalidate();
        return;
    L5:
        r105 = (r103.f559318e * 1.0f) / r104;
        goto L6
    }
}
