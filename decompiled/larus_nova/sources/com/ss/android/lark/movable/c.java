package com.ss.android.lark.movable;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f432655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f432656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObjectAnimator f432657c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f432658a;

        public a(c r100) {
            this.f432658a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewParent r100 = this.f432658a.getParent();     // Catch: Throwable -> L10
            if ((r100 instanceof ViewGroup) == false) goto L5;
            ViewGroup r101 = (ViewGroup) r100;     // Catch: Throwable -> L10
        L6:
            if (r101 == null) goto L8;
            r101.removeView(this.f432658a);     // Catch: Throwable -> L10
        L8:
            this.f432658a.setAlpha(1.0f);     // Catch: Throwable -> L10
            return;
        L5:
            r101 = null;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    public final void a() {
        if (getVisibility() == 0) goto L5;
        return;
    L5:
        ObjectAnimator r100 = this.f432657c;
        if (r100 == null) goto L8;
        r100.cancel();
    L8:
        animate().alpha(0.0f).setDuration(300).withEndAction(new a(this));
    }

    public final float getRadius() {
        return this.f432656b;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        Paint r101 = new Paint(1);
        this.f432655a = r101;
        this.f432656b = com.ss.android.lark.movable.utils.b.d(5.0f, r100);
        r101.setColor(UDColorUtils.getColor(r100, R.color.icon_n1));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = this.f432656b;
        r100.drawCircle(r101, r101, r101, this.f432655a);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        float r102 = this.f432656b;
        float r103 = 2;
        setMeasuredDimension((int) (r102 * r103), (int) (r102 * r103));
    }
}
