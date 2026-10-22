package com.larus.dora.impl.dynamic.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class k extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f335533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f335534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ NewcomerGuideAdapter f335535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TextView f335536d;

    public static final class a implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f335537a;

        public a(TextView r100) {
            this.f335537a = r100;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r100) {
            Intrinsics.checkNotNullParameter(r100, "who");
            this.f335537a.invalidate();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r100, Runnable r101) {
            Intrinsics.checkNotNullParameter(r100, "who");
            Intrinsics.checkNotNullParameter(r101, "what");
            this.f335537a.removeCallbacks(r101);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "who");
            Intrinsics.checkNotNullParameter(r101, "what");
            this.f335537a.postDelayed(r101, r102);
        }
    }

    public k(int r100, boolean r101, NewcomerGuideAdapter r102, TextView r103) {
        this.f335533a = r100;
        this.f335534b = r101;
        this.f335535c = r102;
        this.f335536d = r103;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return ((int) r100.measureText(" ")) + this.f335533a;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r110) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r110, "paint");
        float r108 = r104 + r110.measureText(" ");
        if (this.f335534b == false) goto L17;
        NewcomerGuideAdapter r109 = this.f335535c;
        int r111 = NewcomerGuideAdapter.f335497f;
        final Drawable r112 = (Drawable) r109.f335500c.getValue();
        if (r112 == null) goto L19;
        int r113 = this.f335533a;
        NewcomerGuideAdapter r114 = this.f335535c;
        r112.setCallback(new a(this.f335536d));
        int r115 = (r105 + r107) / 2;
        int r116 = r113 / 2;
        r112.setBounds((int) r108, r115 - r116, (int) (r108 + r113), r115 + r116);
        r112.draw(r100);
        ValueAnimator r117 = r114.f335502e;
        if (r117 != null) goto L9;
    L13:
        ValueAnimator r118 = r114.f335502e;
        if (r118 == null) goto L16;
        r118.cancel();
    L16:
        ValueAnimator r119 = ValueAnimator.ofInt(new int[]{0, 10000});
        r119.setDuration(1000);
        r119.setRepeatCount(-1);
        r119.setInterpolator(new LinearInterpolator());
        r119.addUpdateListener(new j(r112));
        r119.start();
        r114.f335502e = r119;
        g49.d.a("NewcomerGuideAdapter", "setTextWithIcon() started loading animation");
        return;
    L9:
        if (r117.isRunning() == true) goto L11;
        boolean r120 = true;
    L12:
        if (r120 == true) goto L13;
        return;
    L11:
        r120 = false;
        goto L12
    L19:
        return;
    L17:
        Paint.FontMetricsInt r121 = r110.getFontMetricsInt();
        r100.drawText(">", r108, ((r105 + r107) / 2) - ((r121.bottom + r121.top) / 2), r110);
    }
}
