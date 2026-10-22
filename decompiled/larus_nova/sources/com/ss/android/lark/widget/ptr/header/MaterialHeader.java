package com.ss.android.lark.widget.ptr.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;

/* JADX INFO: loaded from: classes38.dex */
public class MaterialHeader extends View implements com.ss.android.lark.widget.ptr.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vdc.a f448064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f448065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f448066c;

    public class a extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialHeader f448067a;

        public a(MaterialHeader r100) {
            this.f448067a = r100;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float r100, Transformation r101) {
            MaterialHeader r102 = this.f448067a;
            float r103 = 1.0f - r100;
            r102.f448065b = r103;
            r102.f448064a.f554276b.f554312v = (int) (r103 * 255.0f);
            r102.invalidate();
        }
    }

    public class b extends com.ss.android.lark.widget.ptr.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MaterialHeader f448068c;

        @Override // java.lang.Runnable
        public final void run() {
            MaterialHeader r100 = this.f448068c;     // Catch: Throwable -> L4
            r100.startAnimation(r100.f448066c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(MaterialHeader r100) {
            this.f448068c = r100;
        }
    }

    public class c implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.widget.ptr.c f448069a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public c(b r100) {
            this.f448069a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            com.ss.android.lark.widget.ptr.c r101 = this.f448069a;
            Runnable r102 = r101.f448062a;
            if (r102 == null) goto L5;
            r102.run();
        L5:
            r101.f448063b = 2;
        }
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void d(LKUIPtrFrameLayout r100) {
    }

    public final void f() {
        vdc.a r100 = new vdc.a(getContext(), this);
        this.f448064a = r100;
        r100.f554284j = -1;
        r100.f554276b.f554313w = -1;
        r100.setCallback(this);
    }

    public MaterialHeader(Context r100) {
        super(r100);
        this.f448065b = 1.0f;
        this.f448066c = new a(this);
        f();
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void b(LKUIPtrFrameLayout r100) {
        this.f448065b = 1.0f;
        this.f448064a.stop();
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void e(LKUIPtrFrameLayout r100) {
        vdc.a r101 = this.f448064a;
        r101.f554276b.f554312v = 255;
        r101.start();
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        if (r100 != this.f448064a) goto L5;
        invalidate();
        return;
    L5:
        super.invalidateDrawable(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        int r101 = r100.save();
        Rect r102 = this.f448064a.getBounds();
        r100.translate(getPaddingLeft() + ((getMeasuredWidth() - ((int) this.f448064a.f554281g)) / 2), getPaddingTop());
        float r103 = this.f448065b;
        r100.scale(r103, r103, r102.exactCenterX(), r102.exactCenterY());
        this.f448064a.draw(r100);
        r100.restoreToCount(r101);
    }

    public void setColorSchemeColors(int[] r100) {
        vdc.a.d r101 = this.f448064a.f554276b;
        r101.f554301k = r100;
        r101.f554302l = 0;
        r101.f554302l = 0;
        invalidate();
    }

    public void setPtrFrameLayout(LKUIPtrFrameLayout r100) {
        b r101 = new b(this);
        this.f448066c.setDuration(200);
        this.f448066c.setAnimationListener(new c(r101));
        r100.setRefreshCompleteHook(r101);
    }

    public MaterialHeader(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f448065b = 1.0f;
        this.f448066c = new a(this);
        f();
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void a(LKUIPtrFrameLayout r100, boolean r101) {
        this.f448064a.stop();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec((((int) this.f448064a.f554282h) + getPaddingTop()) + getPaddingBottom(), 1073741824));
    }

    public MaterialHeader(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f448065b = 1.0f;
        this.f448066c = new a(this);
        f();
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void c(LKUIPtrFrameLayout r100, boolean r101, byte r102, wdc.a r103) {
        int r104 = r103.f559320g;
        if (r104 != 0) goto L5;
        float r105 = 0.0f;
    L6:
        float r106 = Math.min(1.0f, r105);
        if (r102 != 2) goto L16;
        vdc.a.d r107 = this.f448064a.f554276b;
        r107.f554312v = (int) (255.0f * r106);
        if (r107.f554306p == true) goto L11;
        r107.f554306p = true;
        r107.a();
    L11:
        vdc.a r108 = this.f448064a;
        float r109 = Math.min(0.8f, r106 * 0.8f);
        vdc.a.d r110 = r108.f554276b;
        r110.f554296f = 0.0f;
        r110.a();
        vdc.a.d r111 = r108.f554276b;
        r111.f554297g = r109;
        r111.a();
        vdc.a r112 = this.f448064a;
        float r113 = Math.min(1.0f, r106);
        vdc.a.d r114 = r112.f554276b;
        if (r113 == r114.f554308r) goto L14;
        r114.f554308r = r113;
        r114.a();
    L14:
        float r115 = (((0.4f * r106) - 0.25f) + (r106 * 2.0f)) * 0.5f;
        vdc.a.d r116 = this.f448064a.f554276b;
        r116.f554298h = r115;
        r116.a();
        invalidate();
        return;
    L16:
        return;
    L5:
        r105 = (r103.f559318e * 1.0f) / r104;
        goto L6
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        vdc.a r105 = this.f448064a;
        int r106 = (int) r105.f554282h;
        r105.setBounds(0, 0, r106, r106);
    }
}
