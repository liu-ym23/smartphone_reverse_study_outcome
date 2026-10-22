package com.larus.gallery.adapter.ui;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.larus.gallery.adapter.r;
import com.larus.gallery.api.DisplayGravity;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseScaleGalleryView f343765a;

    public d(BaseScaleGalleryView r100) {
        this.f343765a = r100;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        FLogger.f375446a.i(this.f343765a.f343730b, "onLongPress");
        super.onLongPress(r100);
        r r101 = this.f343765a.getListener();
        if (r101 == null) goto L6;
        r101.g();
        return;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "e");
        FLogger r100 = FLogger.f375446a;
        r100.i(this.f343765a.f343730b, "onSingleTapConfirmed");
        final BaseScaleGalleryView r101 = this.f343765a;
        boolean r102 = r101.d(r101.f343729a.f327679l);
        boolean r103 = false;
        if (r101.f343737i != DisplayGravity.CENTER) goto L5;
        final boolean r104 = true;
    L6:
        r100.i(r101.f343730b, "changeViewPosition: hasScale " + r102 + ", isCentered " + r101.f343738j + " gravityIsCenter " + r104);
        if (r102 == false) goto L16;
        if (r104 == false) goto L10;
    L12:
        if (r103 == false) goto L14;
        f r105 = new f(r101);
    L15:
        p r111 = r101.f343729a;
        r111.C = true;
        r111.u(new Matrix(), 300, new b(r101, r104), r105);
    L25:
        r r106 = this.f343765a.getListener();
        if (r106 == null) goto L28;
        r106.a();
    L28:
        return true;
    L14:
        r105 = null;
        goto L15
    L10:
        if (r101.f343738j == false) goto L12;
        r103 = true;
        goto L12
    L16:
        if (r104 == true) goto L25;
        if (r101.f343739k == true) goto L25;
        r101.f343739k = true;
        r101.f343729a.C = true;
        if (r101.f343738j == true) goto L23;
        int r107 = r101.getScalableView().getWidth();
        int r108 = r101.getScalableView().getHeight();
        r101.f343748t.width = r101.getScalableView().getLayoutParams().width;
        r101.f343748t.height = r101.getScalableView().getLayoutParams().height;
        final int r109 = r108;
        final int r112 = r101.getWidth();
        final int r113 = r101.getHeight();
    L24:
        final int r114 = r107;
        ValueAnimator r115 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r115.addUpdateListener(new c(r114, r112, r109, r113, r101));
        r115.addListener(new g(r101));
        r115.setDuration(300);
        r115.start();
        goto L25
    L23:
        r107 = r101.getScalableView().getWidth();
        int r116 = r101.getScalableView().getHeight();
        FrameLayout.LayoutParams r117 = r101.f343748t;
        int r118 = r117.width;
        r109 = r116;
        r113 = r117.height;
        r112 = r118;
        goto L24
    L5:
        r104 = false;
        goto L6
    }
}
