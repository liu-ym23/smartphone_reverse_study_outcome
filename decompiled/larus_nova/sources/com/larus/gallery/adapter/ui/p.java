package com.larus.gallery.adapter.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class p extends l19.l {
    public boolean S;
    public final o T;

    @Override // l19.l
    public final boolean A() {
        return false;
    }

    @Override // l19.l
    public final void B(boolean r100) {
    }

    @Override // l19.l, l19.a
    public final boolean isSingleTagDismissEnabled() {
        return false;
    }

    @Override // l19.l, l19.a
    public final void setSingleTagDismissEnabled(boolean r100) {
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp
    public final boolean n() {
        if (this.S == true) goto L7;
        return false;
    L7:
        return super.n();
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp
    public final void x() {
        super.x();
        FLogger.f375446a.i("GalleryZoomableControllerImpl", "trySpringBack");
        this.T.invoke(this.f327679l);
    }

    public p(k19.e r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "transformGestureDetector");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.S = true;
        this.T = new o();
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp
    public final void y(float r100, PointF r101, Runnable r102, ValueAnimator.AnimatorUpdateListener r103) {
        super.y(r100, r101, null, null);
        if (this.f327671d == true) goto L5;
        return;
    L5:
        Matrix r104 = new Matrix();
        j(r104, r100, r101);
        this.T.invoke(r104);
    }
}
